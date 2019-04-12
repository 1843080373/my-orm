package com.test.service;

import com.test.entity.Answer;
import com.test.dao.AnswerDao;
import com.test.dao.AnswerDaoImpl;
import java.util.List;

public class AnswerServiceImpl implements AnswerService {

	private AnswerDao answerDao = new AnswerDaoImpl();

	/**
	 * ִ��DQL sql
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public Object excuteDQL(String sql, Object[] params){
		return answerDao.excuteDQL(sql,params);
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
		return answerDao.excuteDML(sql,params);
	}

	/**
	 * �������
	 * 
	 * @param answer
	 */
	@Override
	public void insert(Answer answer){
		answerDao.insert(answer);
	}

	/**
	 * ����idɾ������
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Override
	public void delete(Class<Answer> clazz, Integer id){
		answerDao.delete(clazz,id);
	}

	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public void delete(Answer answer){
		answerDao.delete(answer);
	}

	/**
	 * ���¶����Ӧ�ļ�¼
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public int update(Answer answer){
		return answerDao.update(answer);
	}

	/**
	 * ��ѯ���ض��м�¼
	 * 
	 * @param answer
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> queryRows(Answer answer){
		return (List<Answer>)answerDao.queryRows(answer);
	}

	/**
	 * ��ѯ����һ�м�¼
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public Answer queryOne(Answer answer){
		return (Answer)answerDao.queryOne(answer);
	}

	/**
	 * ��ѯ����һ������
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public Number queryNumber(Answer answer){
		return answerDao.queryNumber(answer);
	}

}
