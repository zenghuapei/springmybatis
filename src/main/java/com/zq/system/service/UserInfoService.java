package com.zq.system.service;

import java.util.List;
import java.util.Map;

import com.zq.common.page.Page;
import com.zq.system.entity.UserInfo;

public interface UserInfoService {
	public UserInfo insertUserInfo(UserInfo userInfo);
	public void deleteUserInfo(Long uid);
	public void updateUserInfo(UserInfo userInfo);
	
	public List<UserInfo> getPageUserInfo(Page page);
	public List<UserInfo> getUserNeeded(Map<String, Object> likeCondition);
	public UserInfo getOneUserInfo(String account);
}
