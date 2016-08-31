package com.zq.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zq.common.page.Page;
import com.zq.system.entity.Dict;

@Repository
public interface DictDao {
	 /**
	  * 根据用户ID查询字典项
	 * @param userId
	 * @return
	 */
	 public List<Dict> getDictList(Integer dictId);
	 /**
	  * 查询所有字典项
	 * @return
	 */
	public List<Dict> getDictTree();
	
	/**
	 * 分页查询
	 * @param menuId
	 * @return
	 */
	public List<Dict> getLastDictList(Page page);

	/**
	 *
	 * 添加字典
	 * @param dict
	 */
	public void insertDict(Dict dict);
	/**
	 *
	 * 查询单个字典项
	 * @param dict
	 */
	public Dict getDict(Integer dictId);
}
