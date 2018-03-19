package com.demo.system.service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.demo.system.dao.UserAccountDao;
import com.demo.system.entity.UserAccount;
import com.demo.util.SessionUtil;


@Service
public class SystemServiceImpl implements SystemService {

	@Resource
	private UserAccountDao userAccountDao;
	@Resource
	private HttpSession session;
	
	@Resource
	private HttpServletResponse response;
	@Resource
	private HttpServletRequest request;
	
	@Override
	public UserAccount login(UserAccount userAccount) {
		UserAccount account = userAccountDao.findByUsername(userAccount.getUsername());
		if (account!=null && account.getPassword().equals(userAccount.getPassword())) {
			SessionUtil.setUsername(session, userAccount.getUsername());
			SessionUtil.setUserId(session, userAccount.getId());
			
			Cookie un = new Cookie("username", userAccount.getUsername());
			un.setMaxAge(60*60*24);
			response.addCookie(un);
			
			Cookie pw = new Cookie("password", userAccount.getPassword());
			pw.setMaxAge(60*60*24);
			response.addCookie(pw);
			
			for (Cookie cookie : request.getCookies()) {
				System.out.println(cookie.getName()+" : "+cookie.getValue());
			}
			
			return account;
		}
		return null;
	}

	@Override
	public void register(UserAccount userAccount) {
		userAccountDao.save(userAccount);
	}

	@Override
	public void logout() {
		SessionUtil.removeAttribute(session);
	}

}
