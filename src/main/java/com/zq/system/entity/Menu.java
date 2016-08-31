package com.zq.system.entity;

import java.util.List;

/**
 * @author Administrator
 *菜单
 */
public class Menu {
	/**
	 * 菜单连接ID
	 */
	private Integer menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单连接
	 */
	private String menuUrl;
	/**
	 * 父级ID
	 */
	private Integer parentId;
	/**
	 * 排序号
	 */
	private Integer menuDesc;
	
	/**
	 * 菜单类型
	 */
	private Integer menuType;
	
	/**
	 * 菜单级别
	 */
	private String menuLevel;
	
	/**
	 * 菜单图标
	 */
	private String menuIcon;
	/**
	 * 是否有效

	 */
	private String menuIsEffective;
	/**
	 * 菜单list
	 */
	private List<Menu> menuList;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(Integer menuDesc) {
		this.menuDesc = menuDesc;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	public String getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuIsEffective() {
		return menuIsEffective;
	}

	public void setMenuIsEffective(String menuIsEffective) {
		this.menuIsEffective = menuIsEffective;
	}
}
