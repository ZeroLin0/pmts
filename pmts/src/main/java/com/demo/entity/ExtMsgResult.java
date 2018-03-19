package com.demo.entity;

/*
 * 不带实体的返回信息*/
public class ExtMsgResult {
	private int code;
	private String message;

	public ExtMsgResult(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
