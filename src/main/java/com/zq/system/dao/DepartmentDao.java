package com.zq.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zq.system.entity.Department;

@Repository
public interface DepartmentDao{
	 /**
	  * 根据用户查询部门信息
	 * @param userId
	 * @return
	 */
	public List<Department> getDepartmentList(Integer userId);
	
	/**
	 * 根据departmentId查看下级部门
	 * @param departmentId
	 * @return
	 */
	public List<Department> getDepartmentParentIdList(Integer departmentId);
}
