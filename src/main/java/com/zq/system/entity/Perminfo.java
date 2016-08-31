package com.zq.system.entity;

/**
 * @author Administrator
 *权限信息表
 */
public class Perminfo {
	
	/**
	 * 权限信息ID
	 */
	private Integer permId;
	/**
	 * 权限名称
	 */
	private String permName;
	/**
	 * 权限字符串
	 */
	private String permString;
	/**
	 *排序号 
	 */
	private Integer permDesc;
	public Integer getPermId() {
		return permId;
	}
	public void setPermId(Integer permId) {
		this.permId = permId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getPermString() {
		return permString;
	}
	public void setPermString(String permString) {
		this.permString = permString;
	}
	public Integer getPermDesc() {
		return permDesc;
	}
	public void setPermDesc(Integer permDesc) {
		this.permDesc = permDesc;
	}
	
	
}
