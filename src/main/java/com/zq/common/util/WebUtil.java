package com.zq.common.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zq.common.dto.BaseDto;
import com.zq.common.dto.Dto;



/**
 * 常见的Web辅助类
 * 
 * @author PengLian
 * @since 2012-12-13
 */
public class WebUtil {
	
	/**
	 * 将请求参数封装为Dto
	 * @author PengLian
	 * @since 2012-12-13
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Dto getParamAsDto(HttpServletRequest request) {
		Dto dto = new BaseDto();
		Map map = request.getParameterMap();
		Iterator keyIterator = (Iterator) map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String value = ((String[]) (map.get(key)))[0];
			dto.put(key, value);
		}
		return dto;
	}   
	    
    /** *//** 
    * TODO 获取网站根目录  带 / 
    * @return 
    * @author PHeH
    */ 
   public static String getRootPath(){ 
	    //因为类名为"Application"，因此" Application.class"一定能找到 
	    String result = URLDecoder.decode(WebUtil.class.getResource("WebUtil.class").toString()); 
	    int index = result.indexOf("WEB-INF"); 
	    if(index == -1){ 
	    	index = result.indexOf("bin"); 
	    } 
	    result = result.substring(0,index); 
	    if(result.startsWith("jar")){ 
	    	// 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径 
	    	result = result.substring(10); 
	    }else if(result.startsWith("file")){ 
	    	// 当class文件在class文件中时，返回"file:/F:/ ..."样的路径 
	    	result = result.substring(6); 
	    } 
	    if(result.endsWith("/"))result = result.substring(0,result.length()-1);//不包含最后的"/" 
	    return result; 
    } 
	
	
}
