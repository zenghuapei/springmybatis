package com.zq.system.entity;

/**
 * @author Administrator
 *角色权限表
 */
public class RolePerm {
	
	/**
	 * 角色权限ID
	 */
	private Integer rolePermId;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 权限ID
	 */
	private Integer permId;
	public Integer getRolePermId() {
		return rolePermId;
	}
	public void setRolePermId(Integer rolePermId) {
		this.rolePermId = rolePermId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPermId() {
		return permId;
	}
	public void setPermId(Integer permId) {
		this.permId = permId;
	}
	
	
	
}
