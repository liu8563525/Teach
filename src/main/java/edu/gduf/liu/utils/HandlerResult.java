package edu.gduf.liu.utils;


import org.apache.log4j.Logger;

import edu.gduf.liu.page.PageOthers;



@SuppressWarnings("serial")
public class HandlerResult implements java.io.Serializable
{
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(HandlerResult.class);
	
	ResultState resultState;
	
	protected Object resultObj;
	
	protected PageOthers page;
	
	protected ClientCallbackInfo clientCallbackInfo;
	
	public ResultState getResultState() {
		return resultState;
	}

	public void setResultState(ResultState resultState) {
		this.resultState = resultState;
	}

	public HandlerResult(){}

	public ClientCallbackInfo getClientCallbackInfo()
	{
		return clientCallbackInfo;
	}

	public void setClientCallbackInfo(ClientCallbackInfo clientCallbackInfo)
	{
		this.clientCallbackInfo = clientCallbackInfo;
	}


	public PageOthers getPage() {
		return page;
	}

	public void setPage(PageOthers page) {
		this.page = page;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}


}
