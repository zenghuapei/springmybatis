package com.zq.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.common.page.Page;
import com.zq.common.sequence.SequenceGenerator;
import com.zq.system.dao.AccountDao;
import com.zq.system.dao.UserInfoDao;
import com.zq.system.entity.Account;
import com.zq.system.entity.UserInfo;
import com.zq.system.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired  
	public SequenceGenerator sequenceGenerator;
	public UserInfo insertUserInfo(UserInfo userInfo) {
		Integer userId = sequenceGenerator.nextRechargeOrderSeq(sequenceGenerator.USER_INFO_SEQUENCES);
		Integer accountId = sequenceGenerator.nextRechargeOrderSeq(sequenceGenerator.ACCOUNT_SEQUENCES);
		userInfo.setUserId(userId);
		Account account = userInfo.getAccount();
		account.setAccountId(accountId);
		account.setUserId(userId);
		userInfo.setAccount(account);
		userInfoDao.insertUserInfo(userInfo);
		accountDao.insertAccount(account);
		return userInfo;
	}

	public void deleteUserInfo(Long uid) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	public List<UserInfo> getPageUserInfo(Page page) {
		
		return userInfoDao.getPageUserInfo(page);
	}

	public List<UserInfo> getUserNeeded(Map<String, Object> likeCondition) {
		userInfoDao.getAllUserInfo(likeCondition);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.zq.system.service.UserInfoService#getOneUserInfo(java.lang.Long)
	 * 根据用户名查询用户数据
	 */
	public UserInfo getOneUserInfo(String account) {
		
		return userInfoDao.getUserInfo(account);
	}
	
	
}
