package test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;

import test.base.TestBase;

public class TestMovieController extends TestBase {

	@Test
	public void movie() throws Exception {
		mockMvc.perform((get("/movie/myname1/name").requestAttr("namel", "liu"))).andExpect(status().isOk())
				.andDo(print());
		//mockMvc.perform((post("/movie/myname2").param("name", "liu").requestAttr("p", "p"))).andDo(print());
		//mockMvc.perform(post("/movie/myname2", "string").content("foo".getBytes())).andExpect(content().string("Read string 'foo'"));
	}
}
