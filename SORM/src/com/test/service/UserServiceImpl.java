package com.test.service;

import com.test.entity.User;
import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import java.util.List;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	/**
	 * ִ��DQL sql
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public Object excuteDQL(String sql, Object[] params){
		return userDao.excuteDQL(sql,params);
	}

	/**
	 * ִ��DML sql
	 * 
	 * @param sql
	 * @param params �����б�
	 * @return
	 */
	@Override
	public int excuteDML(String sql, Object[] params){
		return userDao.excuteDML(sql,params);
	}

	/**
	 * �������
	 * 
	 * @param user
	 */
	@Override
	public void insert(User user){
		userDao.insert(user);
	}

	/**
	 * ����idɾ������
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
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public void delete(User user){
		userDao.delete(user);
	}

	/**
	 * ���¶����Ӧ�ļ�¼
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public int update(User user){
		return userDao.update(user);
	}

	/**
	 * ��ѯ���ض��м�¼
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
	 * ��ѯ����һ�м�¼
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User queryOne(User user){
		return (User)userDao.queryOne(user);
	}

	/**
	 * ��ѯ����һ������
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public Number queryNumber(User user){
		return userDao.queryNumber(user);
	}

}
