package com.orm.bean;

/**
 * ������Ϣ
 * 
 * @author ����
 *
 */
public class Configuration {

	/**
	 * ����
	 */
	private String driver;
	/**
	 * ���ݿ������
	 */
	private String url;
	/**
	 * �û���
	 */
	private String username;
	/**
	 * ����
	 */
	private String password;
	/**
	 * ���ݿ�
	 */
	private String usingDB;
	/**
	 * ����·��
	 */
	private String srcPath;
	/**
	 * ��·��
	 */
	private String packagePath;

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

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public Configuration(String driver, String url, String username, String password, String usingDB, String srcPath,
			String packagePath) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.packagePath = packagePath;
	}

	public Configuration() {
		super();
	}

}
