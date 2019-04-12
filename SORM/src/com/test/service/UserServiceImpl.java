package com.test.service;

import com.test.entity.User;
import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import java.util.List;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	/**
	 * 执行DQL sql
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public Object excuteDQL(String sql, Object[] params){
		return userDao.excuteDQL(sql,params);
	}

	/**
	 * 执行DML sql
	 * 
	 * @param sql
	 * @param params 参数列表
	 * @return
	 */
	@Override
	public int excuteDML(String sql, Object[] params){
		return userDao.excuteDML(sql,params);
	}

	/**
	 * 保存对象
	 * 
	 * @param user
	 */
	@Override
	public void insert(User user){
		userDao.insert(user);
	}

	/**
	 * 根据id删除对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Override
	public void delete(Class<User> clazz, Integer id){
		userDao.delete(clazz,id);
	}

	/**
	 * 删除对象在数据库中对应的记录
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public void delete(User user){
		userDao.delete(user);
	}

	/**
	 * 更新对象对应的记录
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public int update(User user){
		return userDao.update(user);
	}

	/**
	 * 查询返回多行记录
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryRows(User user){
		return (List<User>)userDao.queryRows(user);
	}

	/**
	 * 查询返回一行记录
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User queryOne(User user){
		return (User)userDao.queryOne(user);
	}

	/**
	 * 查询返回一个数字
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public Number queryNumber(User user){
		return userDao.queryNumber(user);
	}

}
