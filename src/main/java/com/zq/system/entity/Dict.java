package com.zq.system.entity;

/**
 * @author Administrator
 *字典表
 */
public class Dict {
	/**
	 * 字典ID
	 */
	private Integer dictId;
	/**
	 * 字典编码
	 */
	private String dictCode;
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 字典值
	 */
	private String dictValue;
	/**
	 * 父级id
	 */
	private Integer parentId;
	/**
	 * 排序号
	 */
	private Integer dictDesc;
	/**
	 * 是否有效
	 */
	private String dictIsEffective;
	public Integer getDictId() {
		return dictId;
	}
	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}
	public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getDictDesc() {
		return dictDesc;
	}
	public void setDictDesc(Integer dictDesc) {
		this.dictDesc = dictDesc;
	}

	public String getDictIsEffective() {
		return dictIsEffective;
	}

	public void setDictIsEffective(String dictIsEffective) {
		this.dictIsEffective = dictIsEffective;
	}
}
