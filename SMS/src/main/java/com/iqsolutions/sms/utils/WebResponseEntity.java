package com.iqsolutions.sms.utils;

import org.json.simple.JSONObject;

public class WebResponseEntity<T> {

	private int status;
	private boolean flag;
	private String message;
	private Object response;
	private JSONObject otherInfo;

	public WebResponseEntity() {
		super();
	}

	public WebResponseEntity(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public WebResponseEntity(boolean flag, String message) {
		super();
		this.flag = flag;
		this.message = message;
	}

	public WebResponseEntity(boolean flag, Object response) {
		super();
		this.flag = flag;
		this.response = response;
	}

	public WebResponseEntity(boolean flag, String message, Object response) {
		super();
		this.flag = flag;
		this.message = message;
		this.response = response;
	}

	public WebResponseEntity(int status, boolean flag, String message, JSONObject otherInfo) {
		super();
		this.status = status;
		this.flag = flag;
		this.message = message;
		this.otherInfo = otherInfo;
	}

	public WebResponseEntity(int status, boolean flag, String message, Object response, JSONObject otherInfo) {
		super();
		this.status = status;
		this.flag = flag;
		this.message = message;
		this.response = response;
		this.otherInfo = otherInfo;
	}

	public WebResponseEntity(int status, boolean flag, Object response, JSONObject otherInfo) {
		super();
		this.status = status;
		this.flag = flag;
		this.response = response;
		this.otherInfo = otherInfo;
	}

	public WebResponseEntity(boolean flag, int status, Object response, String message) {
		super();
		this.flag = flag;
		this.status = status;
		this.response = response;
		this.message = message;
	}

	public WebResponseEntity(int status, boolean flag, String message) {
		super();
		this.status = status;
		this.flag = flag;
		this.message = message;
	}

	public WebResponseEntity(int status, boolean flag, Object response) {
		super();
		this.status = status;
		this.flag = flag;
		this.response = response;

	}
	
	public WebResponseEntity(int status, String message, Object response) {
//		super();
		this.status = status;
		this.message = message;
		this.response = response;

	}

	public int getstatus() {
		return status;
	}

	public WebResponseEntity(JSONObject otherInfo) {
		super();
		this.otherInfo = otherInfo;
	}

	public WebResponseEntity(Object response) {
		super();
		this.response = response;
	}

	public void setstatus(int status) {
		this.status = status;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	public JSONObject getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(JSONObject otherInfo) {
		this.otherInfo = otherInfo;
	}

	@Override
	public String toString() {
		return "WebResponseEntity [status=" + status + ", flag=" + flag + ", message=" + message + ", response="
				+ response + ", otherInfo=" + otherInfo + "]";
	}

}
