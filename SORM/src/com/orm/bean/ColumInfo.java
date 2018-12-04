package com.orm.bean;

import com.orm.utils.AliasConvertor;

/**
 * 表中一个字段的信息
 * 
 * @author 紫马
 *
 */
public class ColumInfo {

	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 字段数据类型
	 */
	private String dataType;
	/**
	 * 字段的键（0普通1主键2外键）类型
	 */
	private int keyType;

	public ColumInfo() {
		super();
	}

	public String getName() {
		return AliasConvertor.db2Java(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getKeyType() {
		return keyType;
	}

	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}

	public ColumInfo(String name, String dataType, int keyType) {
		super();
		this.name = name;
		this.dataType = dataType;
		this.keyType = keyType;
	}

	@Override
	public String toString() {
		return "ColumInfo [name=" + name + ", dataType=" + dataType + ", keyType=" + keyType + "]";
	}

}
