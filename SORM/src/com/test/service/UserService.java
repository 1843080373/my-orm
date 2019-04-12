package com.test.service;
import com.test.entity.User;
import java.util.List;

public interface UserService {
	/**
	 * ִ��DQL sql
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object excuteDQL(String sql, Object[] params);
	/**
	 * ִ��DML sql
	 * 
	 * @param sql
	 * @param params �����б�
	 * @return
	 */
	public int excuteDML(String sql, Object[] params);
	/**
	 * �������
	 * 
	 * @param user
	 */
	public void insert(User user);
	/**
	 * ����idɾ������
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public void delete(Class<User> clazz, Integer id);
	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼
	 * 
	 * @param user
	 * @return
	 */
	public void delete(User user);
	/**
	 * ���¶����Ӧ�ļ�¼
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * ��ѯ���ض��м�¼
	 * 
	 * @param user
	 * @return
	 */
	public List<User> queryRows(User user);
	/**
	 * ��ѯ����һ�м�¼
	 * 
	 * @param user
	 * @return
	 */
	public User queryOne(User user);
	/**
	 * ��ѯ����һ������
	 * 
	 * @param user
	 * @return
	 */
	public Number queryNumber(User user);
}
