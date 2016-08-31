package com.zq.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;


/**
 * 数据传输对象(DateTransferObject)<br>
 * 建议在参数传递过程中尽量使用Dto来传递<br>
 * 
 * @author PengLian
 * @since 2012-12-12
 * @see Dto
 * @see java.io.Serializable
 */
@SuppressWarnings("rawtypes")
public class BaseDto extends HashMap implements Dto, Serializable {
	
	private static final long serialVersionUID = -3575851200978541141L;

	public BaseDto(){
		
	}
	
	@SuppressWarnings("unchecked")
	public BaseDto(String key, Object value){
		put(key, value);
	}

	/**
	 * 以BigDecimal类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return BigDecimal 键值
	 */
	public BigDecimal getAsBigDecimal(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "BigDecimal", null);
		if (obj != null)
			return (BigDecimal) obj;
		else
			return null;
	}

	/**
	 * 以Date类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Date 键值
	 */
	public Date getAsDate(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Date", "yyyy-MM-dd");
		if (obj != null)
			return (Date) obj;
		else
			return null;
	}

	/**
	 * 以Integer类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Integer 键值
	 */
	public Integer getAsInteger(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Integer", null);
		if (obj != null)
			return (Integer) obj;
		else
			return null;
	}

	/**
	 * 以Long类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Long 键值
	 */
	public Long getAsLong(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Long", null);
		if (obj != null)
			return (Long) obj;
		else
			return null;
	}

	/**
	 * 以String类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return String 键值
	 */
	public String getAsString(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "String", null);
		if (obj != null)
			return (String) obj;
		else
			return "";
	}
	
	/**
	 * 以List类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return List 键值
	 */
	@SuppressWarnings("unchecked")
	public List getAsList(String key){
		return (List)get(key);
	}

	/**
	 * 以Timestamp类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Timestamp getAsTimestamp(String key) {
		Object obj = TypeCaseHelper.convert(get(key), "Timestamp", "yyyy-MM-dd HH:mm:ss");
		if (obj != null)
			return (Timestamp) obj;
		else
			return null;
	}
	
	/**
	 * 以Boolean类型返回键值
	 * 
	 * @param key
	 *            键名
	 * @return Timestamp 键值
	 */
	public Boolean getAsBoolean(String key){
		Object obj = TypeCaseHelper.convert(get(key), "Boolean", null);
		if (obj != null)
			return (Boolean) obj;
		else
			return null;
	}
	
	/**
	 * 设置交易提示信息
	 * 
	 * @param pSuccess
	 */
	@SuppressWarnings("unchecked")
	public void setMsg(String pMsg){
		put("msg", pMsg);
	}
	
	/**
	 * 获取交易提示信息
	 * 
	 * @param pSuccess
	 */
	public String getMsg(){
		return getAsString("msg");
	}
	
	/**
	 * 打印DTO对象
	 * 
	 */
	public void println(){
		System.out.println(this);
	}

	@SuppressWarnings("unchecked")
	public void setDefaultList(List<Object> defaultList) {
		put("defaultList", defaultList);
	}

	@SuppressWarnings("unchecked")
	public List<Object> DefaultList() {
		return (List<Object>) get("defaultList");
	}
}

