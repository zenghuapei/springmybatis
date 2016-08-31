package com.zq.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zq.common.controller.BaseController;
import com.zq.common.dto.Dto;
import com.zq.common.page.Page;
import com.zq.common.util.WebUtil;
import com.zq.system.entity.UserInfo;
import com.zq.system.service.UserInfoService;

@Controller("UserInfoController")
@RequestMapping("userInfo")
public class UserInfoController  extends BaseController{

	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 
	 * 根据部门Id查询用户信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/queryPage", method=RequestMethod.POST)
	@ResponseBody
	public Object queryPage(HttpServletRequest request) throws Exception{
		Dto dto=WebUtil.getParamAsDto(request);
		Page<UserInfo> page =this.getPage(dto);
		Map params = new HashMap();
		params.put("departmentId",dto.get("departmentId"));
		page.setParams(params);
		List<UserInfo> user = userInfoService.getPageUserInfo(page);
	    page.setData(user);
		System.out.println("");
		return page;
	}
	/**
	 * 
	 * 根据部门Id查询用户信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addUserInfo", method=RequestMethod.POST)
	@ResponseBody
	public Object addUserInfo(HttpServletRequest request) throws Exception{
		String data = request.getParameter("data");
		
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}));
		UserInfo userinfo = (UserInfo) JSONObject.toBean(JSONObject.fromObject(data), UserInfo.class);
		System.out.println(userinfo.getUserBirthday());
		System.out.println(userinfo.getUserRegister());
		userInfoService.insertUserInfo(userinfo);
		return "";
	}
}
