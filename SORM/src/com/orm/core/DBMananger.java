package com.orm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.orm.bean.Configuration;

/**
 * 根据配置文件，管理连接对象
 * 
 * @author 紫马
 *
 */
public class DBMananger {

	private static Configuration conf = null;
	static {
		Properties pro = new Properties();
		try {
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
			String srcPath=System.getProperty("user.dir")+"\\src\\";
			conf = new Configuration(
					pro.getProperty("orm.jdbc.driver"),
					pro.getProperty("orm.jdbc.url"),
					pro.getProperty("orm.jdbc.username"),
					pro.getProperty("orm.jdbc.password"),
					pro.getProperty("orm.jdbc.usingDB"), 
					srcPath,
					pro.getProperty("orm.package.entity"),
					pro.getProperty("orm.package.service"),
					pro.getProperty("orm.package.dao"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Configuration getConfiguration() {
		return conf;

	}
}
