package com.zq.system.service;

import java.util.List;

import com.zq.common.page.Page;
import com.zq.system.entity.Dict;


public interface DictService {
	 /**
	  * 根据dictId查询字典项
	 * @param dictId
	 * @return
	 */
	 public List<Dict> getDictList(Integer dictId);
	 /**
	  * 查询所有字典项
	 * @return
	 */
	public List<Dict> getAllDictList();
	
	/**
	 * 分页查询
	 * @param
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
