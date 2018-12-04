package com.orm.test;

import java.util.List;

import com.orm.core.MySQLQuery;
import com.orm.utils.AliasConvertor;
import com.test.po.User;

public class TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySQLQuery query=new MySQLQuery();
		//query.delete(User.class, 1);
		User u=new User();
		//u.setUserId(3);
		u.setPhone("222");
		//u.setUserName("ÕÅÈý8888");
		//u.setPassword("888");
		//query.update(u);
		//query.insert(u);
		//query.delete(u);
		//List<?> us= query.queryRows(u);
		//System.out.println(us);
		//Object o=query.queryOne(u);
		Number o=query.queryNumber(u);
		System.out.println(o);
		//String dbFeild="user_id";
		//System.out.println(AliasConvertor.db2Java(dbFeild));
		//String javaFeild="user_name";
		//System.out.println(AliasConvertor.javaToDb(javaFeild));
	}

}
