package test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;

import test.base.TestBase;

public class TestFreemarkerController extends TestBase {
	
	@Test
	public void movie() throws Exception {
		super.mockMvc.perform((get("/freeMarker/hello2").param("name", "liu").requestAttr("p", "p"))).andDo(print());
	}
}
