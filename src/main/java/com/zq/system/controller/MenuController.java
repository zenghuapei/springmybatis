package com.zq.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.common.controller.BaseController;
import com.zq.common.dto.Dto;
import com.zq.common.page.Page;
import com.zq.common.util.WebUtil;
import com.zq.system.entity.Menu;
import com.zq.system.entity.UserInfo;
import com.zq.system.service.MenuService;

@Controller("MenuController")
@RequestMapping("menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuService;
	
	/**
	 * 
	 * 查询菜单树
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/querymenuList", method=RequestMethod.POST)
	@ResponseBody
	public Object querymenuList(HttpServletRequest request) throws Exception{
		Dto dto=WebUtil.getParamAsDto(request);
		List<Menu> menuList = menuService.getAllMenuList();
		return menuList;
	}
	/**
	 * 
	 * 查询下级
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/querymenuLastList", method=RequestMethod.POST)
	@ResponseBody
	public Object querymenuLastList(HttpServletRequest request) throws Exception{
		Dto dto=WebUtil.getParamAsDto(request);
		Page<Menu> page = this.getPage(dto); 
		page.setParams(dto);
		List<Menu> menuList = menuService.getLastMenuList(page);
		page.setData(menuList);
		return page;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addMenu", method=RequestMethod.POST)
	@ResponseBody
	public Object addMenu(HttpServletRequest request) throws Exception{
		String data = request.getParameter("data");

		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}));
		Menu menu = (Menu) JSONObject.toBean(JSONObject.fromObject(data), Menu.class);
		menuService.addMenu(menu);
		return "";
	}
}
