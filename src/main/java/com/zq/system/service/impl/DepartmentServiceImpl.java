package com.zq.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.system.dao.DepartmentDao;
import com.zq.system.entity.Department;
import com.zq.system.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	/*@Resource(name = "departmentDao")*/
	@Autowired
	private DepartmentDao departmentDao;
	
	
	 /**
	  * 根据用户查询部门信息
	 * @param userId
	 * @return
	 */
	public List<Department> getDepartmentList(Integer userId) {
		return departmentDao.getDepartmentList(userId);
	}
	/**
	 * 根据departmentId查看下级部门
	 * @param departmentId
	 * @return
	 */
	public List<Department> getDepartmentParentIdList(Integer departmentId) {
		/*PageHelper.startPage(1, 10);
		List<Department> list = departmentDao.getDepartmentParentIdList(departmentId);
		PageInfo page = new PageInfo(list);*/
		return null;
	}

	
	
}
