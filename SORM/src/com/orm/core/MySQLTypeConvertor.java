package com.orm.core;

/**
 * mysql类型转换器
 * 
 * @author 紫马
 *
 */
public class MySQLTypeConvertor implements TypeConvertor {

	@Override
	public String dbTypeToJavaType(String dbType) {
		if ("VARCHAR".equalsIgnoreCase(dbType) || "char".equalsIgnoreCase(dbType)) {
			return "String";
		} else if ("int".equalsIgnoreCase(dbType) || "tinyint".equalsIgnoreCase(dbType)
				|| "smallint".equalsIgnoreCase(dbType) || "integer".equalsIgnoreCase(dbType)) {
			return "Integer";
		} else if ("bigint".equalsIgnoreCase(dbType)) {
			return "Long";
		} else if ("double".equalsIgnoreCase(dbType) || "float".equalsIgnoreCase(dbType)) {
			return "Double";
		} else if ("Clob".equalsIgnoreCase(dbType)) {
			return "Clob";
		} else if ("Blob".equalsIgnoreCase(dbType)) {
			return "Blob";
		} else if ("Date".equalsIgnoreCase(dbType)) {
			return "Date";
		} else if ("datetime".equalsIgnoreCase(dbType)) {
			return "Timestamp";
		} else if ("Timestamp".equalsIgnoreCase(dbType)) {
			return "Timestamp";
		} else if ("bit".equalsIgnoreCase(dbType)) {
			return "Boolean";
		}
		return null;
	}
	
	public String dbType2JavaType(String dbType) {
		if ("VARCHAR".equalsIgnoreCase(dbType) || "char".equalsIgnoreCase(dbType)) {
			return "java.lang.String";
		} else if ("int".equalsIgnoreCase(dbType) || "tinyint".equalsIgnoreCase(dbType)
				|| "smallint".equalsIgnoreCase(dbType) || "integer".equalsIgnoreCase(dbType)) {
			return "java.lang.Integer";
		} else if ("bigint".equalsIgnoreCase(dbType)) {
			return "java.lang.Long";
		} else if ("double".equalsIgnoreCase(dbType) || "float".equalsIgnoreCase(dbType)) {
			return "java.lang.Double";
		} else if ("Clob".equalsIgnoreCase(dbType)) {
			return "java.lang.Clob";
		} else if ("Blob".equalsIgnoreCase(dbType)) {
			return "java.lang.Blob";
		} else if ("Date".equalsIgnoreCase(dbType)) {
			return "java.sql.Date";
		} else if ("datetime".equalsIgnoreCase(dbType)) {
			return "java.sql.Timestamp";
		} else if ("Timestamp".equalsIgnoreCase(dbType)) {
			return "java.sql.Timestamp";
		} else if ("bit".equalsIgnoreCase(dbType)) {
			return "java.sql.Boolean";
		}
		return null;
	}

	@Override
	public String javaTypeToDbType(String javaType) {
		return null;
	}

}
