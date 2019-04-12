package com.orm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.orm.bean.TableInfo;
import com.orm.utils.AliasConvertor;
import com.orm.utils.BeanUtils;

@SuppressWarnings("rawtypes")
public class MySQLQuery implements Query {

	@Override
	public int excuteDML(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBMananger.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBMananger.closeConnection(conn, ps);
		}
		return 0;
	}

	@Override
	public void insert(Object obj) {
		Class<?> clazz = obj.getClass();
		Map<Class, TableInfo> poClassTableMap = TableContext.getPOTabMap();
		TableInfo tableInfo = poClassTableMap.get(clazz);
		Field[] fieldArray = clazz.getDeclaredFields();
		StringBuilder sql = new StringBuilder("insert into " + tableInfo.gettName() + " (");
		int count = 0;
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				count++;
				sql.append(AliasConvertor.javaToDb(tableInfo.getColumns().get(AliasConvertor.javaToDb(field.getName())).getName()) + ",");
			}
		}
		int j = 0;
		Object[] params = new Object[count];
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				params[j] = fieldValue;
				j++;
			}
		}
		// 删除最后一个逗号
		sql.deleteCharAt(sql.length() - 1);
		sql.append(") values (");
		for (int i = 0; i < count; i++) {
			sql.append("?,");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		excuteDML(sql.toString(), params);
	}

	@Override
	public void delete(Class<?> clazz, Integer id) {
		Map<Class, TableInfo> poClassTableMap = TableContext.getPOTabMap();
		TableInfo tableInfo = poClassTableMap.get(clazz);
		Object[] params = new Object[] { id };
		StringBuilder sql = new StringBuilder(
				"delete from " +  tableInfo.gettName()+ " where " + AliasConvertor.javaToDb(tableInfo.getKeyColumn().getName()) + "=?");
		excuteDML(sql.toString(), params);
	}

	@Override
	public void delete(Object obj) {
		Map<Class, TableInfo> poClassTableMap = TableContext.getPOTabMap();
		TableInfo tableInfo = poClassTableMap.get(obj.getClass());
		String keyFiledName = tableInfo.getKeyColumn().getName();
		Integer id = (Integer) BeanUtils.invokeGet(obj, keyFiledName);
		delete(obj.getClass(), id);
	}

	@Override
	public int update(Object obj) {
		Class<?> clazz = obj.getClass();
		Map<Class, TableInfo> poClassTableMap = TableContext.getPOTabMap();
		TableInfo tableInfo = poClassTableMap.get(clazz);
		Field[] fieldArray = clazz.getDeclaredFields();
		StringBuilder sql = new StringBuilder("update " + tableInfo.gettName() + " set ");
		int count = 0;
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				count++;
				sql.append(AliasConvertor.javaToDb(tableInfo.getColumns().get(AliasConvertor.javaToDb(field.getName())).getName()) + "=?,");
			}
		}
		int j = 0;
		Object[] params = new Object[count];
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				params[j] = fieldValue;
				j++;
			}
		}
		// 删除最后一个逗号
		sql.deleteCharAt(sql.length() - 1);
		String keyFiledName = tableInfo.getKeyColumn().getName();
		Integer id = (Integer) BeanUtils.invokeGet(obj, keyFiledName);
		sql.append(" where " + AliasConvertor.javaToDb(keyFiledName) + "=" + id);
		System.out.println(sql.toString());
		return excuteDML(sql.toString(), params);
	}

	@Override
	public List<?> queryRows(Object obj) {
		Class<?> clazz = obj.getClass();
		Map<Class, TableInfo> poClassTableMap = TableContext.getPOTabMap();
		TableInfo tableInfo = poClassTableMap.get(clazz);
		Field[] fieldArray = clazz.getDeclaredFields();
		StringBuilder sql = new StringBuilder("SELECT * FROM " + tableInfo.gettName() + " ");
		int count = 0;
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				if (count == 0) {
					sql.append("WHERE " + AliasConvertor.javaToDb(tableInfo.getColumns().get(AliasConvertor.javaToDb(field.getName())).getName()) + "=? ");
				} else {
					sql.append("AND " + AliasConvertor.javaToDb(tableInfo.getColumns().get(AliasConvertor.javaToDb(field.getName())).getName()) + "=? ");
				}
				count++;
			}
		}
		int j = 0;
		Object[] params = new Object[count];
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				params[j] = fieldValue;
				j++;
			}
		}
		// 删除最后一个逗号
		sql.deleteCharAt(sql.length() - 1);
		System.out.println(sql);
		ResultSet rs = excuteDQL(sql.toString(), params);
		try {
			ArrayList<Object> list = new ArrayList<Object>();
			while (rs.next()) {
				Object o = clazz.newInstance();
				int columnCount = rs.getMetaData().getColumnCount();
				for (int k = 0; k < columnCount; k++) {
					String filedName=rs.getMetaData().getColumnName(k+1);
					BeanUtils.invokeSet(o, AliasConvertor.db2Java(filedName),
							new MySQLTypeConvertor().dbType2JavaType(tableInfo.getColumns().get(filedName).getDataType()),
							rs.getObject(filedName));
				}
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object queryOne(Object obj) {
		List<Object> os=(List<Object>) queryRows(obj);
		if(!os.isEmpty()) {
			return os.get(0);
		}
		return null;
	}

	@Override
	public Number queryNumber(Object obj) {
		Class<?> clazz = obj.getClass();
		Map<Class, TableInfo> poClassTableMap = TableContext.getPOTabMap();
		TableInfo tableInfo = poClassTableMap.get(clazz);
		Field[] fieldArray = clazz.getDeclaredFields();
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM " + tableInfo.gettName() + " ");
		int count = 0;
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				if (count == 0) {
					sql.append("WHERE " + AliasConvertor.javaToDb(tableInfo.getColumns().get(AliasConvertor.javaToDb(field.getName())).getName()) + "=? ");
				} else {
					sql.append("AND " + AliasConvertor.javaToDb(tableInfo.getColumns().get(AliasConvertor.javaToDb(field.getName())).getName()) + "=? ");
				}
				count++;
			}
		}
		int j = 0;
		Object[] params = new Object[count];
		for (int i = 0; i < fieldArray.length; i++) {
			Field field = fieldArray[i];
			Object fieldValue = BeanUtils.invokeGet(obj, field.getName());
			if (fieldValue != null) {
				params[j] = fieldValue;
				j++;
			}
		}
		// 删除最后一个逗号
		sql.deleteCharAt(sql.length() - 1);
		System.out.println(sql);
		ResultSet rs = excuteDQL(sql.toString(), params);
		try {
			while (rs.next()) {
				return rs.getInt(1);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet excuteDQL(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBMananger.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
