package com.orm.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.orm.bean.ColumInfo;
import com.orm.bean.Configuration;
import com.orm.bean.JavaFieldGetSet;
import com.orm.bean.TableInfo;
import com.orm.core.DBMananger;
import com.orm.core.TypeConvertor;
import com.orm.utils.AliasConvertor;
import com.orm.utils.StringUtils;

/** 
* <p>Title: JavaFileUtils.java</p>  
* <p>Description:Java源码生成 </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.jhjhome.com</p>  
* @author huangjian 
* @date 2019年4月11日  
* @version 1.0  
*/  
public class CreateEntityJavaSrc {
	private static Configuration conf = null;
	
	static{
		conf=DBMananger.getConfiguration();
	}
	public static JavaFieldGetSet create(ColumInfo columInfo, TypeConvertor typeConvertor) {
		JavaFieldGetSet fieldGetSet = new JavaFieldGetSet();
		StringBuilder fieldInfoBuilder = new StringBuilder();
		String javaType = typeConvertor.dbTypeToJavaType(columInfo.getDataType());
		String columName = AliasConvertor.db2Java(columInfo.getName());
		fieldInfoBuilder.append("\tprivate " + javaType + " " + columName + ";\n");
		StringBuilder getInfoBuilder = new StringBuilder();
		getInfoBuilder.append("\tpublic " + javaType + " get" + StringUtils.fistCharUpperCase(columName) + "() {\n");
		getInfoBuilder.append("\t\treturn " + columName + ";\n");
		getInfoBuilder.append("\t}\n\n");
		StringBuilder setInfoBuilder = new StringBuilder();
		setInfoBuilder.append("\tpublic void set" + StringUtils.fistCharUpperCase(columName) + "(" + javaType
				+ " " + columName + ") {\n");
		setInfoBuilder.append("\t\tthis." + columName + " = " + columName + ";\n");
		setInfoBuilder.append("\t}\n\n");
		fieldGetSet.setFieldInfo(fieldInfoBuilder.toString());
		fieldGetSet.setGetInfo(getInfoBuilder.toString());
		fieldGetSet.setSetInfo(setInfoBuilder.toString());
		return fieldGetSet;
	}

	public static String createEntityJavaSrc(TableInfo tableInfo, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		List<JavaFieldGetSet> list = new ArrayList<>();
		Map<String, ColumInfo> map = tableInfo.getColumns();
		/**
		 * 无参构造源码
		 */
		String noArgConstructorInfo = generateNoArgConstructorInfo(tableInfo);
		/**
		 * 全参构造源码
		 */
		String allArgConstructorInfo=generateAllArgConstructorInfo(tableInfo,map,typeConvertor);
		/**
		 * toString源码
		 */
		String toStringInfo=generateToStringInfo(tableInfo,map,typeConvertor);
		for (ColumInfo columInfo : map.values()) {
			list.add(create(columInfo, typeConvertor));
		}
		
		srcBuilder.append("package " + conf.getEntityPackagePath() + ";\n\n");
		srcBuilder.append("import java.sql.*;" + "\n\n");
		srcBuilder.append("public class " + StringUtils.fistCharUpperCase(tableInfo.gettName()) + " {\n");
		for (JavaFieldGetSet javaFieldGetSet : list) {
			srcBuilder.append(javaFieldGetSet.getFieldInfo());
		}
		srcBuilder.append("\n");
		for (JavaFieldGetSet javaFieldGetSet : list) {
			srcBuilder.append(javaFieldGetSet.getGetInfo());
			srcBuilder.append(javaFieldGetSet.getSetInfo());
		}
		srcBuilder.append(noArgConstructorInfo);
		srcBuilder.append(allArgConstructorInfo);
		srcBuilder.append(toStringInfo);
		srcBuilder.append("}\n");
		return srcBuilder.toString();
	}

	private static String generateNoArgConstructorInfo(TableInfo tableInfo) {
		StringBuilder srcBuilder = new StringBuilder();
		/**
		 * public User() {
				super();
			}
		 */
		srcBuilder.append("\tpublic " + StringUtils.fistCharUpperCase(tableInfo.gettName()) + "() {\n");
		srcBuilder.append("\t\tsuper();");
		srcBuilder.append("\n\t}\n\n");
		return srcBuilder.toString();
	}

	private static String generateToStringInfo(TableInfo tableInfo,Map<String, ColumInfo> map, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		/**
		 * @Override
			public String toString() {
				return "User [password=" + password + ", userId=" + userId + ", phone=" + phone + ", userName=" + userName
						+ "]";
			}
		 */
		srcBuilder.append("\t@Override\n");
		srcBuilder.append("\tpublic String toString() {\n");
		StringBuilder argBuilder = new StringBuilder(StringUtils.fistCharUpperCase(tableInfo.gettName())+" [");
		for (ColumInfo columInfo : map.values()) {
			argBuilder.append(columInfo.getName()+"=\" + "+columInfo.getName()+" + \", ");
		}
		argBuilder=argBuilder.deleteCharAt(argBuilder.length()-2);
		argBuilder.append("]");
		srcBuilder.append("\t\treturn \""+argBuilder+"\";\n");
		srcBuilder.append("\t}\n\n");
		return srcBuilder.toString();
	}

	private static String generateAllArgConstructorInfo(TableInfo tableInfo, Map<String, ColumInfo> map, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		/**
		 * public User(String password, Integer userId, String phone, String userName) {
					super();
					this.password = password;
					this.userId = userId;
					this.phone = phone;
					this.userName = userName;
				}
		 */
		srcBuilder.append("\tpublic " + StringUtils.fistCharUpperCase(tableInfo.gettName()));
		StringBuilder argBuilder = new StringBuilder();
		StringBuilder thisColumnBuilder = new StringBuilder();
		for (ColumInfo columInfo : map.values()) {
			String javaType = typeConvertor.dbTypeToJavaType(columInfo.getDataType());
			argBuilder.append(javaType+ " " + columInfo.getName() + ",");
			thisColumnBuilder.append("\t\tthis.").append(columInfo.getName()).append("=").append(columInfo.getName())
			.append(";\n");
		}
		argBuilder=argBuilder.deleteCharAt(argBuilder.length()-1);
		srcBuilder.append("(").append(argBuilder).append(")");
		srcBuilder.append(" {\n");
		srcBuilder.append("\t\tsuper();\n");
		srcBuilder.append(thisColumnBuilder);
		srcBuilder.append("\t}\n\n");
		return srcBuilder.toString();
	}
	
}
