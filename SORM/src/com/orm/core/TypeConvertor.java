package com.orm.core;

/**
 * ����Java�������ͺ����ݿ������໥ת��
 * 
 * @author ����
 *
 */
public interface TypeConvertor {

	/**
	 * ���ݿ�����ת��Java����
	 * 
	 * @param dbType
	 * @return
	 */
	public String dbTypeToJavaType(String dbType);

	/**
	 * Java����ת�����ݿ�����
	 * 
	 * @param dbType
	 * @return
	 */
	public String javaTypeToDbType(String javaType);
}
