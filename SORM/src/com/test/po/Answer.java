package com.test.po;

import java.sql.*;

public class Answer {
	private Timestamp updateTime;
	private Timestamp createTime;
	private Integer questionnaireId;
	private Integer userId;
	private Integer id;
	private Integer version;
	private Integer choiceId;
	private Boolean enabled;

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public Integer getChoiceId() {
		return choiceId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setChoiceId(Integer choiceId) {
		this.choiceId = choiceId;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
