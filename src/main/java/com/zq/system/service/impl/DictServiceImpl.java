package com.zq.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.common.page.Page;
import com.zq.system.dao.DictDao;
import com.zq.system.entity.Dict;
import com.zq.system.service.DictService;
@Service("dictService")
public class DictServiceImpl implements DictService {

	@Autowired
	private DictDao dictDao;
	
	
	public List<Dict> getDictList(Integer dictId) {
		return dictDao.getDictList(dictId);
	}

	public List<Dict> getAllDictList() {

		return dictDao.getDictTree();
	}

	public List<Dict> getLastDictList(Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 *
	 * 添加字典
	 * @param dict
	 */
	public void insertDict(Dict dict){
		dictDao.insertDict(dict);
	}

	/**
	 *
	 * 查询单个字典项
	 * @param dictId
	 */
	public Dict getDict(Integer dictId){
		return dictDao.getDict(dictId);
	}
}
