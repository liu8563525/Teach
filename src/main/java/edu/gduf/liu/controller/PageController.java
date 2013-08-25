package edu.gduf.liu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.gduf.liu.entity.User;

/**
 * 
 * @author kevin.liu
 * 
 */
@Controller
@RequestMapping("/paging")
public class PageController {
	private static final long serialVersionUID = -3305996070755176492L;

	private List<String> datas;
	public static final int PAGER_PAGESIZE = 10;
	private List<String> back;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/")
	public String sayHello(ModelMap map, HttpServletRequest request) {
		back = new ArrayList<String>();
		for (int i = 1; i <= 156; i++) {
			back.add("字符串" + i);
		}
		this.datas = back;
		logger.info("init paging");
		// 获取当前页号
		int pageNo = 1;
		String pageNoStr = request.getParameter("pageNo");
		if (null != pageNoStr && !pageNoStr.equals("")) {
			pageNo = Integer.parseInt(pageNoStr);
		}

		// 获取数据
		String name = request.getParameter("name");
		if (null != name && !"".equals(name)) {
			List<String> temp = new ArrayList<String>();
			for (String str : datas) {
				if (str.contains(name)) {
					temp.add(str);
				}
			}
			this.datas = temp;
		}

		// 获取总记录数
		int recordCount = this.datas.size();

		// 获取分页数据
		int start = (pageNo - 1) * PAGER_PAGESIZE;
		int end = start + PAGER_PAGESIZE;
		if (end > this.datas.size()) {
			end = this.datas.size();
		}
		List<String> results = this.datas.subList(start, end);
		//把分页数据和分页标签所需要的参数存放到request中
		request.setAttribute("datas", results);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", PAGER_PAGESIZE);
		request.setAttribute("recordCount", recordCount);
		
		//转发请求到FTL页面
		//request.getRequestDispatcher("/index.ftl").forward(request, response);
		//转发请求到JSP页面
		//request.getRequestDispatcher("/pager.jsp").forward(request, response);
		
		map.addAttribute("name", "liu");
		return "paging";
	}
}
