package com.orm.code;

import com.orm.bean.Configuration;
import com.orm.bean.TableInfo;
import com.orm.core.DBMananger;
import com.orm.core.TypeConvertor;
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
public class CreateDaoImplJavaSrc {
	private static Configuration conf = null;
	
	static{
		conf=DBMananger.getConfiguration();
	}
	public static String createDaoImplJavaSrc(TableInfo tableInfo, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		srcBuilder.append("package " + conf.getDaoPackagePath() + ";\n\n");
		srcBuilder.append("import com.orm.core.MySQLQuery;\n\n");
		srcBuilder.append("public class " + StringUtils.fistCharUpperCase(tableInfo.gettName())+"DaoImpl extends MySQLQuery implements " +StringUtils.fistCharUpperCase(tableInfo.gettName()) + "Dao"+ " {\n");
		
		srcBuilder.append("}\n");
		return srcBuilder.toString();
	}
}
