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
public class CreateDaoJavaSrc {
	private static Configuration conf = null;
	
	static{
		conf=DBMananger.getConfiguration();
	}
	public static String createDaoJavaSrc(TableInfo tableInfo, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		srcBuilder.append("package " + conf.getDaoPackagePath() + ";\n\n");
		//srcBuilder.append("import "+conf.getEntityPackagePath()+"."+StringUtils.fistCharUpperCase(tableInfo.gettName())+";" + "\n\n");
		srcBuilder.append("import com.orm.core.Query;\n\n");
		srcBuilder.append("public interface " + StringUtils.fistCharUpperCase(tableInfo.gettName()) + "Dao extends Query {\n");
		srcBuilder.append("}\n");
		return srcBuilder.toString();
	}
	
}
