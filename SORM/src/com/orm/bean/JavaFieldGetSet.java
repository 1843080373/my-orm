package com.orm.bean;

/**
 * java��������Դ����Ϣ
 * 
 * @author ����
 *
 */
public class JavaFieldGetSet {

	/**
	 * ����Դ�� private String name;
	 */
	private String fieldInfo;

	/**
	 * getԴ�� public String getName() { return name; }
	 */
	private String getInfo;
	/**
	 * setԴ�� public void setName(String name) { this.name = name; }
	 */
	private String setInfo;

	public String getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	public String getGetInfo() {
		return getInfo;
	}

	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}

	public String getSetInfo() {
		return setInfo;
	}

	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}

	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}

	public JavaFieldGetSet() {
		super();
	}

	public void log() {
		System.out.println(this.fieldInfo);
		System.out.println(this.getInfo);
		System.out.println(this.setInfo);
	}

}
