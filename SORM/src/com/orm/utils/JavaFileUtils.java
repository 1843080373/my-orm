package com.orm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.orm.bean.ColumInfo;
import com.orm.bean.JavaFieldGetSet;
import com.orm.bean.TableInfo;
import com.orm.core.DBMananger;
import com.orm.core.MySQLTypeConvertor;
import com.orm.core.TableContext;
import com.orm.core.TypeConvertor;

public class JavaFileUtils {

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

	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		List<JavaFieldGetSet> list = new ArrayList<>();
		Map<String, ColumInfo> map = tableInfo.getColumns();
		for (ColumInfo columInfo : map.values()) {
			list.add(create(columInfo, typeConvertor));
		}
		srcBuilder.append("package " + DBMananger.getConfiguration().getPackagePath() + ";\n\n");
		srcBuilder.append("import java.sql.*;" + "\n\n");
		srcBuilder.append("public class " + StringUtils.fistCharUpperCase(tableInfo.gettName()) + " {\n");
		for (JavaFieldGetSet javaFieldGetSet : list) {
			srcBuilder.append(javaFieldGetSet.getFieldInfo());
		}
		srcBuilder.append("\n");
		for (JavaFieldGetSet javaFieldGetSet : list) {
			srcBuilder.append(javaFieldGetSet.getGetInfo());
		}
		for (JavaFieldGetSet javaFieldGetSet : list) {
			srcBuilder.append(javaFieldGetSet.getSetInfo());
		}
		srcBuilder.append("}\n");
		return srcBuilder.toString();
	}

	public static void createJavaSrcFile(TableInfo tableInfo, TypeConvertor typeConvertor) {
		BufferedWriter bufferedWriter = null;
		try {
			String createJavaSrc = createJavaSrc(tableInfo, typeConvertor);
			String srcPath = DBMananger.getConfiguration().getSrcPath();
			String packagePath = DBMananger.getConfiguration().getPackagePath().replaceAll("\\.", "\\\\");
			File f = new File(srcPath + packagePath);
			if (!f.exists()) {
				f.mkdirs();
			}
			bufferedWriter = new BufferedWriter(new FileWriter(
					f.getAbsolutePath() + "/" + StringUtils.fistCharUpperCase(tableInfo.gettName()) + ".java"));
			bufferedWriter.write(createJavaSrc);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedWriter!=null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Map<String, TableInfo> map = TableContext.getTabMap();
		for (TableInfo tableInfo : map.values()) {
			createJavaSrcFile(tableInfo, new MySQLTypeConvertor());
		}
	}
}
