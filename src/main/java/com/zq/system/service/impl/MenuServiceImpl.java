package com.zq.system.service.impl;

import java.util.List;

import com.zq.common.sequence.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.common.page.Page;
import com.zq.system.dao.MenuDao;
import com.zq.system.entity.Menu;
import com.zq.system.service.MenuService;
@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	@Autowired
	public SequenceGenerator sequenceGenerator;
	public List<Menu> getMenuList(Integer userid) {
		List<Menu> menuList = menuDao.getMenuList(userid);
		return menuList;	
	}

	public List<Menu> getAllMenuList() {
		List<Menu> menuList = menuDao.getAllMenuList();
		return menuList;
	}

	public List<Menu> getLastMenuList(Page page) {
		List<Menu> menuList = menuDao.getLastMenuList(page);
		return menuList;
	}

	public Integer addMenu(Menu menu){
		Integer menuId = sequenceGenerator.nextRechargeOrderSeq(SequenceGenerator.MENU_SEQUENCES);
		menu.setMenuId(menuId);
		Integer save = menuDao.addMenu(menu);
		return save;
	}

	
}
