package com.zq.system.controller;

import javax.servlet.http.HttpServletRequest;

import com.zq.system.entity.Dict;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.system.service.DictService;

@Controller("DictController")
@RequestMapping("dict")
public class DictController {
	@Autowired
	private DictService dictService;

	/**
	 *根据字典ID查询字典项
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getDictList",method=RequestMethod.GET)
	@ResponseBody
	public Object getDictList(HttpServletRequest request){
		Integer dictId = Integer.parseInt(request.getParameter("dictId"));
		return dictService.getDictList(dictId);
	}
	/**
	 *查询所有字典项树显示
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getAllDictList",method=RequestMethod.POST)
	@ResponseBody
	public Object getAllDictList(HttpServletRequest request){
		return dictService.getAllDictList();
	}

	/**
	 * 添加字典项
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addDict", method=RequestMethod.POST)
	@ResponseBody
	public Object addDict(HttpServletRequest request){
		String data = request.getParameter("data");
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}));
		Dict dict = (Dict) JSONObject.toBean(JSONObject.fromObject(data), Dict.class);
		dictService.insertDict(dict);
		return "";
	}

	/**
	 *
	 * 查询单个字典项
	 * @param dict
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getDict", method=RequestMethod.POST)
	@ResponseBody
	public Object getDict(HttpServletRequest request){
		Integer dictId = Integer.parseInt(request.getParameter("dictId"));

		return dictService.getDict(dictId);
	}
}
