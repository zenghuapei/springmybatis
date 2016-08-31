package com.zq.system.entity;

/**
 * @author Administrator
 *部门机构表
 */
public class Department {
	/**
	 * 部门ID
	 */
	private Integer departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 部门编码
	 */
	private String departmentCode;
	/**
	 * 父级ID
	 */
	private Integer parentId;
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
}
