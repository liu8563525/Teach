package com.kevin.exception;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.util.WebUtils;

public class SimpleMappingExceptionResolver extends
		AbstractHandlerExceptionResolver {
	public static final String DEFAULT_EXCEPTION_ATTRIBUTE = "exception";
	private Properties exceptionMappings;
	private Class<?>[] excludedExceptions;
	private String defaultErrorView;
	private Integer defaultStatusCode;
	private Map<String, Integer> statusCodes;
	private String exceptionAttribute;

	public SimpleMappingExceptionResolver() {
		logger.debug("edu.gduf.liu.exception.SimpleMappingExceptionResolver");
		this.statusCodes = new HashMap();
		this.exceptionAttribute = "exception";
	}

	public void setExceptionMappings(Properties mappings) {
		this.exceptionMappings = mappings;
	}

	public void setExcludedExceptions(Class<?>[] excludedExceptions) {
		this.excludedExceptions = excludedExceptions;
	}

	public void setDefaultErrorView(String defaultErrorView) {
		this.defaultErrorView = defaultErrorView;
	}

	public void setStatusCodes(Properties statusCodes) {
		for (Enumeration enumeration = statusCodes.propertyNames(); enumeration
				.hasMoreElements();) {
			String viewName = (String) enumeration.nextElement();
			Integer statusCode = new Integer(statusCodes.getProperty(viewName));
			this.statusCodes.put(viewName, statusCode);
		}
	}

	public void addStatusCode(String viewName, int statusCode) {
		this.statusCodes.put(viewName, Integer.valueOf(statusCode));
	}

	public Map<String, Integer> getStatusCodesAsMap() {
		return Collections.unmodifiableMap(this.statusCodes);
	}

	public void setDefaultStatusCode(int defaultStatusCode) {
		this.defaultStatusCode = Integer.valueOf(defaultStatusCode);
	}

	public void setExceptionAttribute(String exceptionAttribute) {
		this.exceptionAttribute = exceptionAttribute;
	}

	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response,
						statusCode.intValue());
			}
			return getModelAndView(viewName, ex, request);
		}

		return null;
	}

	protected String determineViewName(Exception ex, HttpServletRequest request) {
		String viewName = null;
		if (this.excludedExceptions != null) {
			for (Class excludedEx : this.excludedExceptions) {
				if (excludedEx.equals(ex.getClass())) {
					return null;
				}
			}
		}

		if (this.exceptionMappings != null) {
			viewName = findMatchingViewName(this.exceptionMappings, ex);
		}

		if ((viewName == null) && (this.defaultErrorView != null)) {
			if (this.logger.isDebugEnabled()) {
				this.logger.debug("Resolving to default view '"
						+ this.defaultErrorView + "' for exception of type ["
						+ ex.getClass().getName() + "]");
			}

			viewName = this.defaultErrorView;
		}
		return viewName;
	}

	protected String findMatchingViewName(Properties exceptionMappings,
			Exception ex) {
		String viewName = null;
		String dominantMapping = null;
		int deepest = 2147483647;
		for (Enumeration names = exceptionMappings.propertyNames(); names
				.hasMoreElements();) {
			String exceptionMapping = (String) names.nextElement();
			int depth = getDepth(exceptionMapping, ex);
			if ((depth >= 0)
					&& (((depth < deepest) || ((depth == deepest)
							&& (dominantMapping != null) && (exceptionMapping
							.length() > dominantMapping.length()))))) {
				deepest = depth;
				dominantMapping = exceptionMapping;
				viewName = exceptionMappings.getProperty(exceptionMapping);
			}
		}
		if ((viewName != null) && (this.logger.isDebugEnabled())) {
			this.logger
					.debug("Resolving to view '" + viewName
							+ "' for exception of type ["
							+ ex.getClass().getName()
							+ "], based on exception mapping ["
							+ dominantMapping + "]");
		}

		return viewName;
	}

	protected int getDepth(String exceptionMapping, Exception ex) {
		return getDepth(exceptionMapping, ex.getClass(), 0);
	}

	private int getDepth(String exceptionMapping, Class<?> exceptionClass,
			int depth) {
		if (exceptionClass.getName().contains(exceptionMapping)) {
			return depth;
		}

		if (exceptionClass.equals(Throwable.class)) {
			return -1;
		}
		return getDepth(exceptionMapping, exceptionClass.getSuperclass(),
				depth + 1);
	}

	protected Integer determineStatusCode(HttpServletRequest request,
			String viewName) {
		if (this.statusCodes.containsKey(viewName)) {
			return ((Integer) this.statusCodes.get(viewName));
		}
		return this.defaultStatusCode;
	}

	protected void applyStatusCodeIfPossible(HttpServletRequest request,
			HttpServletResponse response, int statusCode) {
		if (!(WebUtils.isIncludeRequest(request))) {
			if (this.logger.isDebugEnabled()) {
				this.logger.debug("Applying HTTP status code " + statusCode);
			}
			response.setStatus(statusCode);
			request.setAttribute("javax.servlet.error.status_code",
					Integer.valueOf(statusCode));
		}
	}

	protected ModelAndView getModelAndView(String viewName, Exception ex,
			HttpServletRequest request) {
		return getModelAndView(viewName, ex);
	}

	protected ModelAndView getModelAndView(String viewName, Exception ex) {
		ModelAndView mv = new ModelAndView(viewName);
		if (this.exceptionAttribute != null) {
			if (this.logger.isDebugEnabled()) {
				this.logger.debug("Exposing Exception as model attribute '"
						+ this.exceptionAttribute + "'");
			}
			mv.addObject(this.exceptionAttribute, ex);
		}
		return mv;
	}
}
