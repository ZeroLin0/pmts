package com.demo.entity;

public class ExtjsAjaxResult {
	private boolean success = true;
	private String msg = "";
	
	public ExtjsAjaxResult() {
	}
	
	public ExtjsAjaxResult(boolean success,String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getMsg() {
		return msg;
	}
}
