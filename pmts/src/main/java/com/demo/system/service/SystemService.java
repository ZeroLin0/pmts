package com.demo.system.service;

import com.demo.system.entity.UserAccount;

public interface SystemService {
	public UserAccount login(UserAccount userAccount);
	public void register(UserAccount userAccount);
	public void logout();
}
