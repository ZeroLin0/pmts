package com.demo.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
	private static final String USERNAME = "username";
	private static final String USER_ID = "userId";
	private static final String FULL_NAME = "fullName";
	
	private SessionUtil() {
	}

	public static String getUsername(HttpSession session) {
		return (String)session.getAttribute(USERNAME);
	}

	public static Long getUserId(HttpSession session) {
		return (Long)session.getAttribute(USER_ID);
	}

	public static String getFullName(HttpSession session) {
		return (String)session.getAttribute(FULL_NAME);
	}
	
	public static void setUsername(HttpSession session,String username) {
		session.setAttribute(USERNAME, username);
	}
	
	public static void setUserId(HttpSession session,Long userId) {
		session.setAttribute(USER_ID, userId);
	}
	
	public static void setFullName(HttpSession session,String fullName) {
		session.setAttribute(FULL_NAME, fullName);
	}
	
	public static void removeAttribute(HttpSession session) {
		session.removeAttribute(USERNAME);
		session.removeAttribute(FULL_NAME);
		session.removeAttribute(USER_ID);
	}
}
