package com.demo.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.ExtMsgResult;
import com.demo.system.entity.UserAccount;
import com.demo.system.service.SystemService;

@Controller
@RequestMapping(value = "/system")
public class SystemController {
	@Resource
	private SystemService systemService;
	
	@PostMapping("/login")
	public @ResponseBody ExtMsgResult login(UserAccount userAccount) {
		UserAccount account =  systemService.login(userAccount);
		if (account!=null) {
			return new ExtMsgResult(200, "登录成功");
		}
		return new ExtMsgResult(400, "登录失败");
	}
	
	@PostMapping("/register")
	public @ResponseBody ExtMsgResult register(UserAccount userAccount) {
		try {
			systemService.register(userAccount);
			return new ExtMsgResult(200, "注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ExtMsgResult(400, "注册失败");
		}
	}
	
	@PostMapping("/logout")
	public @ResponseBody ExtMsgResult logout() {
		try {
			systemService.logout();
			return new ExtMsgResult(200, "登出成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ExtMsgResult(400, "登出失败");
		}
	}
}
