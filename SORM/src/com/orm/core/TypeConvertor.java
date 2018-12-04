package com.orm.core;

/**
 * 负责Java数据类型和数据库类型相互转化
 * 
 * @author 紫马
 *
 */
public interface TypeConvertor {

	/**
	 * 数据库类型转换Java类型
	 * 
	 * @param dbType
	 * @return
	 */
	public String dbTypeToJavaType(String dbType);

	/**
	 * Java类型转换数据库类型
	 * 
	 * @param dbType
	 * @return
	 */
	public String javaTypeToDbType(String javaType);
}
