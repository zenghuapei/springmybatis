package com.zq.system.service;

import java.util.List;

import com.zq.system.entity.Department;

public interface DepartmentService {
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
