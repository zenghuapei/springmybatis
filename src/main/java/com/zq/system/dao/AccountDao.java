package com.zq.system.dao;

import org.springframework.stereotype.Repository;

import com.zq.system.entity.Account;

@Repository
public interface AccountDao {
	/**
	 * 添加账号
	 * @param account
	 */
	public void insertAccount(Account account);
}
