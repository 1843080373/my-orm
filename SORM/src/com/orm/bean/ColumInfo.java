package com.orm.bean;

import com.orm.utils.AliasConvertor;

/**
 * ����һ���ֶε���Ϣ
 * 
 * @author ����
 *
 */
public class ColumInfo {

	/**
	 * �ֶ�����
	 */
	private String name;
	/**
	 * �ֶ���������
	 */
	private String dataType;
	/**
	 * �ֶεļ���0��ͨ1����2���������
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
