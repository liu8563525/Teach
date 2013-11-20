package test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;

import test.base.BaseTest;

public class TestUserController extends BaseTest {
	
	@Test
	public void movie() throws Exception {
		super.mockMvc.perform((get("/myPage/3").requestAttr("p", "p"))).andDo(print());
	}
}
