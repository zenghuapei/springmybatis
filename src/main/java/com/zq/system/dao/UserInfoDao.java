package com.zq.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zq.common.page.Page;
import com.zq.system.entity.UserInfo;

@Repository
public interface UserInfoDao {
	public void insertUserInfo(UserInfo userInfo);
	public void updateUserInfo(UserInfo userInfo);
	public void deleteUserInfo(UserInfo userInfo);
	/**
	 * 进行模糊查询
	 * @param likeCondition
	 * @param page
	 * @return
	 */
	public List<UserInfo> getAllUserInfo(Map<String,Object> likeCondition);
	/**
	 * 
	 * 分页查询
	 * @param page
	 * @return
	 */
	public List<UserInfo> getPageUserInfo(Page page);
	public UserInfo getUserInfo(String account);
}
