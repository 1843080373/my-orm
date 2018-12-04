package com.orm.core;

import java.util.List;

public interface Query {

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
	 * @param obj
	 */
	public void insert(Object obj);

	/**
	 * ����idɾ������
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public void delete(Class<?> clazz, Integer id);

	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼ �����Ӧ�����Ӧ��
	 * 
	 * @param obj
	 * @return
	 */
	public void delete(Object obj);

	/**
	 * ���¶����Ӧ�ļ�¼������ֻ���¶�Ӧ�ֶε�ֵ
	 * 
	 * @param obj
	 * @return
	 */
	public int update(Object obj);

	/**
	 * ��ѯ���ض��м�¼�����ҽ�ÿһ�з�װ��class��Ӧ��bean��ȥ
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List<?> queryRows(Object obj);

	/**
	 * ��ѯ����һ���м�¼�����ҽ���һ�з�װ��class��Ӧ��bean��ȥ
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryOne(Object obj);

	/**
	 * ��ѯ����һ������
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Number queryNumber(Object obj);
}
