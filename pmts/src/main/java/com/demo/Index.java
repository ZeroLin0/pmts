package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class Index {
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return new String("hello");
	}
}
