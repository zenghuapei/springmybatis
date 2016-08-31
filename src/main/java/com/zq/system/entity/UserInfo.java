package com.zq.system.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zq.common.date.DateSerializer;

/**
 * @author Administrator
 *用户信息
 */
public class UserInfo {
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户性别
	 */
	private String userSex;
	/**
	 * 用户生日
	 */
	private Date userBirthday;
	
	/**
	 * 籍贯
	 */
	private String userRecruitment;
	/**
	 * 现居住地址
	 */
	private String userNewaddress;
	/**
	 * 学历
	 */
	private Integer userEducation;
	/**
	 * 状态
	 */
	private Integer userState;
	/**
	 * 注册时间
	 */
	private Date userRegister;
	/**
	 * 联系电话
	 */
	private String userNumber;
	/**
	 * E-mail
	 */
	private String userEmail;
	/**
	 * 紧急联系电话
	 */
	private String userUrgentnumber;
	
	/**
	 * 账号信息
	 */
	private Account account;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@JsonSerialize(using = DateSerializer.class)
	public Date getUserBirthday() {
		return userBirthday;
	}
	@JsonSerialize(using = DateSerializer.class)
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getUserRecruitment() {
		return userRecruitment;
	}
	public void setUserRecruitment(String userRecruitment) {
		this.userRecruitment = userRecruitment;
	}
	public String getUserNewaddress() {
		return userNewaddress;
	}
	public void setUserNewaddress(String userNewaddress) {
		this.userNewaddress = userNewaddress;
	}
	public Integer getUserEducation() {
		return userEducation;
	}
	public void setUserEducation(Integer userEducation) {
		this.userEducation = userEducation;
	}
	public Integer getUserState() {
		return userState;
	}
	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	@JsonSerialize(using = DateSerializer.class)
	public Date getUserRegister() {
		return userRegister;
	}
	@JsonSerialize(using = DateSerializer.class)
	public void setUserRegister(Date userRegister) {
		this.userRegister = userRegister;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserUrgentnumber() {
		return userUrgentnumber;
	}
	public void setUserUrgentnumber(String userUrgentnumber) {
		this.userUrgentnumber = userUrgentnumber;
	}
	
	
	
}
