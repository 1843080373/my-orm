package com.orm.test;

import java.util.List;

import com.test.entity.User;
import com.test.service.UserService;
import com.test.service.UserServiceImpl;

public class TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserService service = new UserServiceImpl();
		service.delete(User.class, 1);
		User u = new User();
		u.setUserId(1141);
		u.setPhone("222");
		u.setUserName("ÕÅÈý8888");
		u.setPassword("888");
		service.update(u);
		service.insert(u);
		service.delete(u);
		List<?> us = service.queryRows(u);
		System.out.println(us);
		Object o = service.queryOne(u);
		System.out.println(o);
		Number o1 = service.queryNumber(u);
		System.out.println(o1);

	}

}
