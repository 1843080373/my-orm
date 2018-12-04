package com.orm.core;

import java.util.List;

public interface Query {

	/**
	 * 执行DQL sql
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object excuteDQL(String sql, Object[] params);
	/**
	 * 执行DML sql
	 * 
	 * @param sql
	 * @param params 参数列表
	 * @return
	 */
	public int excuteDML(String sql, Object[] params);

	/**
	 * 保存对象
	 * 
	 * @param obj
	 */
	public void insert(Object obj);

	/**
	 * 根据id删除对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public void delete(Class<?> clazz, Integer id);

	/**
	 * 删除对象在数据库中对应的记录 对象对应的类对应表
	 * 
	 * @param obj
	 * @return
	 */
	public void delete(Object obj);

	/**
	 * 更新对象对应的记录，并且只更新对应字段的值
	 * 
	 * @param obj
	 * @return
	 */
	public int update(Object obj);

	/**
	 * 查询返回多行记录，并且将每一行封装到class对应的bean中去
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List<?> queryRows(Object obj);

	/**
	 * 查询返回一行行记录，并且将这一行封装到class对应的bean中去
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryOne(Object obj);

	/**
	 * 查询返回一个数字
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Number queryNumber(Object obj);
}
