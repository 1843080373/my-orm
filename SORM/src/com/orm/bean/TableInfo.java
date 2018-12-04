package com.orm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * 
 * @author 紫马
 *
 */
public class TableInfo {

	/**
	 * 表名称
	 */
	private String tName;
	/**
	 * 列信息
	 */
	private Map<String, ColumInfo> columns;
	/**
	 * 主键
	 */
	private ColumInfo keyColumn;
	/**
	 * 联合主键
	 */
	private List<ColumInfo> priKeys;

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Map<String, ColumInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumInfo> columns) {
		this.columns = columns;
	}

	public ColumInfo getKeyColumn() {
		return keyColumn;
	}

	public void setKeyColumn(ColumInfo keyColumn) {
		this.keyColumn = keyColumn;
	}

	public TableInfo(String tName, Map<String, ColumInfo> columns, ColumInfo keyColumn, List<ColumInfo> priKeys) {
		super();
		this.tName = tName;
		this.columns = columns;
		this.keyColumn = keyColumn;
		this.priKeys = priKeys;
	}

	public TableInfo(String tName, Map<String, ColumInfo> columns, List<ColumInfo> priKeys) {
		super();
		this.tName = tName;
		this.columns = columns;
		this.priKeys = priKeys;
	}

	public List<ColumInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumInfo> priKeys) {
		this.priKeys = priKeys;
	}

	public TableInfo() {
		super();
	}

	@Override
	public String toString() {
		return "TableInfo [tName=" + tName + ", columns=" + columns + ", keyColumn=" + keyColumn + ", priKeys="
				+ priKeys + "]";
	}

}
