package com.orm.utils;

import java.lang.reflect.Method;

public class BeanUtils {

	public static Object invokeGet(Object obj, String keyFiledName) {
	    Class<? extends Object> c=obj.getClass();
	    Method m = null;
		try {
			m = c.getDeclaredMethod("get"+StringUtils.fistCharUpperCase(keyFiledName));
			return m.invoke(obj,new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Object invokeSet(Object obj, String filedName,String fieldType,Object value) {
	    Class<? extends Object> c=obj.getClass();
	    Method m = null;
		try {
			m = c.getDeclaredMethod("set"+StringUtils.fistCharUpperCase(filedName),Class.forName(fieldType));
			return m.invoke(obj,new Object[]{value});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
