package com.demo.system;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.system.controller.SystemController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SystemControllerTest {
	@Resource
	private SystemController systemController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(systemController).build();
	}
	
//	@Test
	public void loginTest() throws Exception{
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/system/login")
				.param("username", "admin").param("password", "123");
		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void registerTest() throws Exception{
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/system/register")
				.param("username", "admin").param("password", "123");
		mockMvc.perform(builder).andDo(MockMvcResultHandlers.print());
	}
}
