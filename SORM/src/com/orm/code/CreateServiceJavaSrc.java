package com.orm.code;

import com.orm.bean.Configuration;
import com.orm.bean.TableInfo;
import com.orm.core.DBMananger;
import com.orm.core.TypeConvertor;
import com.orm.utils.StringUtils;

/** 
* <p>Title: JavaFileUtils.java</p>  
* <p>Description:JavaԴ������ </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.jhjhome.com</p>  
* @author huangjian 
* @date 2019��4��11��  
* @version 1.0  
*/  
public class CreateServiceJavaSrc {
	private static Configuration conf = null;
	
	static{
		conf=DBMananger.getConfiguration();
	}
	public static String createServiceJavaSrc(TableInfo tableInfo, TypeConvertor typeConvertor) {
		StringBuilder srcBuilder = new StringBuilder();
		String entityName=StringUtils.fistCharUpperCase(tableInfo.gettName());
		String entityFieldName=tableInfo.gettName();
		srcBuilder.append("package " + conf.getServicePackagePath() + ";\n");
		srcBuilder.append("import "+conf.getEntityPackagePath()+"."+entityName+";" + "\n");
		srcBuilder.append("import java.util.List;\n\n");
		srcBuilder.append("public interface " + entityName + "Service {\n");
		srcBuilder.append("\t/**\r\n" + 
				"	 * ִ��DQL sql\r\n" + 
				"	 * @param sql\r\n" + 
				"	 * @param params\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic Object excuteDQL(String sql, Object[] params);\n");
		
		srcBuilder.append("\t/**\r\n" + 
				"	 * ִ��DML sql\r\n" + 
				"	 * \r\n" + 
				"	 * @param sql\r\n" + 
				"	 * @param params �����б�\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic int excuteDML(String sql, Object[] params);\n");
		
		srcBuilder.append("\t/**\r\n" + 
				"	 * �������\r\n" + 
				"	 * \r\n" + 
				"	 * @param "+entityFieldName+"\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic void insert("+entityName+" "+entityFieldName+");\n");

		srcBuilder.append("\t/**\r\n" + 
				"	 * ����idɾ������\r\n" + 
				"	 * \r\n" + 
				"	 * @param clazz\r\n" + 
				"	 * @param id\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic void delete(Class<"+entityName+"> clazz, Integer id);\n");
		
		srcBuilder.append("\t/**\r\n" + 
				"	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼\r\n" + 
				"	 * \r\n" + 
				"	 * @param "+entityFieldName+"\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic void delete("+entityName+" "+entityFieldName+");\n");
		
		srcBuilder.append("\t/**\r\n" + 
				"	 * ���¶����Ӧ�ļ�¼\r\n" + 
				"	 * \r\n" + 
				"	 * @param "+entityFieldName+"\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic int update("+entityName+" "+entityFieldName+");\n");
		
		srcBuilder.append("\t/**\r\n" + 
				"	 * ��ѯ���ض��м�¼\r\n" + 
				"	 * \r\n" + 
				"	 * @param "+entityFieldName+"\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic List<"+entityName+"> queryRows("+entityName+" "+entityFieldName+");\n");
		
		srcBuilder.append("\t/**\r\n" + 
				"	 * ��ѯ����һ�м�¼\r\n" + 
				"	 * \r\n" + 
				"	 * @param "+entityFieldName+"\r\n" + 
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic "+entityName+" queryOne("+entityName+" "+entityFieldName+");\n");

		srcBuilder.append("\t/**\r\n" + 
				"	 * ��ѯ����һ������\r\n" + 
				"	 * \r\n" + 
				"	 * @param "+entityFieldName+"\r\n" +  
				"	 * @return\r\n" + 
				"	 */");
		srcBuilder.append("\n");
		srcBuilder.append("\tpublic Number queryNumber("+entityName+" "+entityFieldName+");\n");
		
		srcBuilder.append("}\n");
		return srcBuilder.toString();
	}
}
