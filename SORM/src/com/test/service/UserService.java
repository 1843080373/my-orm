package com.test.service;
import com.test.entity.User;
import java.util.List;

public interface UserService {
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
	 * @param user
	 */
	public void insert(User user);
	/**
	 * 根据id删除对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public void delete(Class<User> clazz, Integer id);
	/**
	 * 删除对象在数据库中对应的记录
	 * 
	 * @param user
	 * @return
	 */
	public void delete(User user);
	/**
	 * 更新对象对应的记录
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * 查询返回多行记录
	 * 
	 * @param user
	 * @return
	 */
	public List<User> queryRows(User user);
	/**
	 * 查询返回一行记录
	 * 
	 * @param user
	 * @return
	 */
	public User queryOne(User user);
	/**
	 * 查询返回一个数字
	 * 
	 * @param user
	 * @return
	 */
	public Number queryNumber(User user);
}
