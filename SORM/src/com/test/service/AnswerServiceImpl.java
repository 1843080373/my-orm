package com.test.service;

import com.test.entity.Answer;
import com.test.dao.AnswerDao;
import com.test.dao.AnswerDaoImpl;
import java.util.List;

public class AnswerServiceImpl implements AnswerService {

	private AnswerDao answerDao = new AnswerDaoImpl();

	/**
	 * 执行DQL sql
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public Object excuteDQL(String sql, Object[] params){
		return answerDao.excuteDQL(sql,params);
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
		return answerDao.excuteDML(sql,params);
	}

	/**
	 * 保存对象
	 * 
	 * @param answer
	 */
	@Override
	public void insert(Answer answer){
		answerDao.insert(answer);
	}

	/**
	 * 根据id删除对象
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
	 * 删除对象在数据库中对应的记录
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public void delete(Answer answer){
		answerDao.delete(answer);
	}

	/**
	 * 更新对象对应的记录
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public int update(Answer answer){
		return answerDao.update(answer);
	}

	/**
	 * 查询返回多行记录
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
	 * 查询返回一行记录
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public Answer queryOne(Answer answer){
		return (Answer)answerDao.queryOne(answer);
	}

	/**
	 * 查询返回一个数字
	 * 
	 * @param answer
	 * @return
	 */
	@Override
	public Number queryNumber(Answer answer){
		return answerDao.queryNumber(answer);
	}

}
