package com.test.service;
import com.test.entity.Answer;
import java.util.List;

public interface AnswerService {
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
	 * @param answer
	 */
	public void insert(Answer answer);
	/**
	 * ����idɾ������
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public void delete(Class<Answer> clazz, Integer id);
	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼
	 * 
	 * @param answer
	 * @return
	 */
	public void delete(Answer answer);
	/**
	 * ���¶����Ӧ�ļ�¼
	 * 
	 * @param answer
	 * @return
	 */
	public int update(Answer answer);
	/**
	 * ��ѯ���ض��м�¼
	 * 
	 * @param answer
	 * @return
	 */
	public List<Answer> queryRows(Answer answer);
	/**
	 * ��ѯ����һ�м�¼
	 * 
	 * @param answer
	 * @return
	 */
	public Answer queryOne(Answer answer);
	/**
	 * ��ѯ����һ������
	 * 
	 * @param answer
	 * @return
	 */
	public Number queryNumber(Answer answer);
}
