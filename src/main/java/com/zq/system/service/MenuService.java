package com.zq.system.service;

import java.util.List;

import com.zq.common.page.Page;
import com.zq.system.entity.Menu;

public interface MenuService {
	 /**
	  * 根据用户ID查询菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> getMenuList(Integer userid);
	 /**
	  * 查询所有菜单
	 * @return
	 */
	public List<Menu> getAllMenuList();
	/**
	 * 根据菜单Id查询下级
	 * @param menuId
	 * @return
	 */
	public List<Menu> getLastMenuList(Page page);
	/**
	 * 添加菜单
	 * @param menu
	 * @return
	 */
	public Integer addMenu(Menu menu);
}
