package com.zq.system.entity;

/**
 * @author Administrator
 *账号
 */
public class Account {
	/**
	 * 账号ID
	 */
	private Integer accountId;
	/**
	 * 账号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 用户ID
	 */
	private Integer userId;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
