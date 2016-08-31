package com.zq.system.controller;

import com.zq.system.entity.Department;
import com.zq.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("DepartmentController")
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	
	
	
	/**
	 * 
	 * 根据用户显示部门树
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getDepartmentListUser",method=RequestMethod.POST)
	@ResponseBody
	public Object roleUserMenu(@ModelAttribute("department") Department department,HttpServletRequest request) throws Exception{
		Integer userId = Integer.parseInt(request.getParameter("userId")); 
		List<Department> departmentList = departmentService.getDepartmentList(userId);
		return departmentList;
	}
	
	public Object departmentAllList(HttpServletRequest request) throws Exception{
		
		return null;
	}
}
