package com.zq.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.system.entity.Menu;
import com.zq.system.service.MenuService;
@Controller("RoleController")
@RequestMapping("role")
public class RoleController {
	/*@Resource(name="menuService")*/
	@Autowired
	private MenuService menuService;

	
	
	
	@RequestMapping(value="/roleUserMenu",method=RequestMethod.GET)
	@ResponseBody
	public Object roleUserMenu(HttpServletRequest request){
		List<Menu> menuList = menuService.getMenuList(1);
		return menuList;
	}
}
