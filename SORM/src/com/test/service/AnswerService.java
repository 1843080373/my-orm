package com.test.service;
import com.test.entity.Answer;
import java.util.List;

public interface AnswerService {
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
	 * @param answer
	 */
	public void insert(Answer answer);
	/**
	 * 根据id删除对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public void delete(Class<Answer> clazz, Integer id);
	/**
	 * 删除对象在数据库中对应的记录
	 * 
	 * @param answer
	 * @return
	 */
	public void delete(Answer answer);
	/**
	 * 更新对象对应的记录
	 * 
	 * @param answer
	 * @return
	 */
	public int update(Answer answer);
	/**
	 * 查询返回多行记录
	 * 
	 * @param answer
	 * @return
	 */
	public List<Answer> queryRows(Answer answer);
	/**
	 * 查询返回一行记录
	 * 
	 * @param answer
	 * @return
	 */
	public Answer queryOne(Answer answer);
	/**
	 * 查询返回一个数字
	 * 
	 * @param answer
	 * @return
	 */
	public Number queryNumber(Answer answer);
}
