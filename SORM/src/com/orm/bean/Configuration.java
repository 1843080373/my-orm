package com.orm.bean;

/**
 * 配置信息
 * 
 * @author 紫马
 *
 */
public class Configuration {

	/**
	 * 驱动
	 */
	private String driver;
	/**
	 * 数据库服务器
	 */
	private String url;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 数据库
	 */
	private String usingDB;
	/**
	 * 代码路径
	 */
	private String srcPath;
	/**
	 * entity包路径
	 */
	private String entityPackagePath;
	/**
	 * service包路径
	 */
	private String servicePackagePath;
	/**
	 * dao包路径
	 */
	private String daoPackagePath;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsingDB() {
		return usingDB;
	}

	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}


	public String getEntityPackagePath() {
		return entityPackagePath;
	}

	public void setEntityPackagePath(String entityPackagePath) {
		this.entityPackagePath = entityPackagePath;
	}

	public String getServicePackagePath() {
		return servicePackagePath;
	}

	public void setServicePackagePath(String servicePackagePath) {
		this.servicePackagePath = servicePackagePath;
	}

	public String getDaoPackagePath() {
		return daoPackagePath;
	}

	public void setDaoPackagePath(String daoPackagePath) {
		this.daoPackagePath = daoPackagePath;
	}

	public Configuration(String driver, String url, String username, String password, String usingDB, String srcPath,
			String entityPackagePath, String servicePackagePath, String daoPackagePath) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.entityPackagePath = entityPackagePath;
		this.servicePackagePath = servicePackagePath;
		this.daoPackagePath = daoPackagePath;
	}

	public Configuration() {
		super();
	}

}
