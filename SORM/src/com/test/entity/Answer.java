package com.test.entity;

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

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(Integer choiceId) {
		this.choiceId = choiceId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Answer() {
		super();
	}

	public Answer(Timestamp updateTime,Timestamp createTime,Integer questionnaireId,Integer userId,Integer id,Integer version,Integer choiceId,Boolean enabled) {
		super();
		this.updateTime=updateTime;
		this.createTime=createTime;
		this.questionnaireId=questionnaireId;
		this.userId=userId;
		this.id=id;
		this.version=version;
		this.choiceId=choiceId;
		this.enabled=enabled;
	}

	@Override
	public String toString() {
		return "Answer [updateTime=" + updateTime + ", createTime=" + createTime + ", questionnaireId=" + questionnaireId + ", userId=" + userId + ", id=" + id + ", version=" + version + ", choiceId=" + choiceId + ", enabled=" + enabled + " ]";
	}

}
