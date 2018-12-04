package com.orm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.orm.bean.ColumInfo;
import com.orm.bean.TableInfo;
import com.orm.utils.StringUtils;

/**
 * 负责管理数据库，生产类结构
 * 
 * @author 紫马
 *
 */
@SuppressWarnings("rawtypes")
public class TableContext {

	private static Map<String, TableInfo> tables = new HashMap<>();

	private static Map<Class, TableInfo> poClassTableMap = new HashMap<>();

	private TableContext() {
	}

	static {
		try {
			Connection conn = DBMananger.getConnection();
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			ResultSet tableRes = databaseMetaData.getTables(null, "%", "%", new String[] { "TABLE" });
			while (tableRes.next()) {
				String table_name = (String) tableRes.getObject("TABLE_NAME");
				TableInfo tableInfo = new TableInfo(table_name, new HashMap<>(), new ArrayList<>());
				tables.put(table_name, tableInfo);
				Class c=Class.forName(DBMananger.getConfiguration().getPackagePath()+"."+StringUtils.fistCharUpperCase(table_name));
				poClassTableMap.put(c, tableInfo);
				ResultSet columnsRes = databaseMetaData.getColumns(null, "%", table_name, "%");
				while (columnsRes.next()) {
					ColumInfo columInfo = new ColumInfo(columnsRes.getString("COLUMN_NAME"),
							columnsRes.getString("TYPE_NAME"), 0);
					tableInfo.getColumns().put(columnsRes.getString("COLUMN_NAME"), columInfo);
				}
				ResultSet priKeyRes = databaseMetaData.getPrimaryKeys(null, "%", table_name);
				while (priKeyRes.next()) {
					ColumInfo columInfo = tableInfo.getColumns().get(priKeyRes.getString("COLUMN_NAME"));
					columInfo.setKeyType(1);
					tableInfo.getPriKeys().add(columInfo);
				}
				if (tableInfo.getPriKeys().size() > 0) {
					tableInfo.setKeyColumn(tableInfo.getPriKeys().get(0));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Map<Class, TableInfo> getPOTabMap() {
		return poClassTableMap;
	}

	public static Map<String, TableInfo> getTabMap() {
		return tables;
	}

	public static void main(String[] args) {
		Map<String, TableInfo> taMap = tables;
		for (TableInfo ti : taMap.values()) {
			System.out.println(ti);
		}
	}
}
