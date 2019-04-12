package com.orm.code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.orm.bean.Configuration;
import com.orm.bean.TableInfo;
import com.orm.core.DBMananger;
import com.orm.core.MySQLTypeConvertor;
import com.orm.core.TableContext;
import com.orm.core.TypeConvertor;
import com.orm.utils.StringUtils;

public class CreateJavaSrcFile {
	private static Configuration conf = null;
	static {
		conf = DBMananger.getConfiguration();
	}

	public static void createJavaSrcFile(String createJavaSrc,String packagePath,String javaFileName, TableInfo tableInfo, TypeConvertor typeConvertor) {
		BufferedWriter bufferedWriter = null;
		try {
			String srcPath = conf.getSrcPath();
			File f = new File(srcPath + packagePath);
			if (!f.exists()) {
				f.mkdirs();
			}
			bufferedWriter = new BufferedWriter(new FileWriter(
					f.getAbsolutePath() + "/" + javaFileName + ".java"));
			bufferedWriter.write(createJavaSrc);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void createJavaSrcFile(TableInfo tableInfo, TypeConvertor typeConvertor) {
		createJavaSrcFile(CreateEntityJavaSrc.createEntityJavaSrc(tableInfo, typeConvertor),conf.getEntityPackagePath().replaceAll("\\.", "\\\\"),StringUtils.fistCharUpperCase(tableInfo.gettName()),tableInfo,typeConvertor);
		createJavaSrcFile(CreateDaoJavaSrc.createDaoJavaSrc(tableInfo, typeConvertor),conf.getDaoPackagePath().replaceAll("\\.", "\\\\"),StringUtils.fistCharUpperCase(tableInfo.gettName())+"Dao",tableInfo,typeConvertor);
		createJavaSrcFile(CreateDaoImplJavaSrc.createDaoImplJavaSrc(tableInfo, typeConvertor),conf.getDaoPackagePath().replaceAll("\\.", "\\\\"),StringUtils.fistCharUpperCase(tableInfo.gettName())+"DaoImpl",tableInfo,typeConvertor);
		createJavaSrcFile(CreateServiceJavaSrc.createServiceJavaSrc(tableInfo, typeConvertor),conf.getServicePackagePath().replaceAll("\\.", "\\\\"),StringUtils.fistCharUpperCase(tableInfo.gettName())+"Service",tableInfo,typeConvertor);
		createJavaSrcFile(CreateServiceImplJavaSrc.createServiceImplJavaSrc(tableInfo, typeConvertor),conf.getServicePackagePath().replaceAll("\\.", "\\\\"),StringUtils.fistCharUpperCase(tableInfo.gettName())+"ServiceImpl",tableInfo,typeConvertor);
	}

	public static void main(String[] args) {
		Map<String, TableInfo> map = TableContext.getTabMap();
		for (TableInfo tableInfo : map.values()) {
			createJavaSrcFile(tableInfo, new MySQLTypeConvertor());
		}
	}
}
