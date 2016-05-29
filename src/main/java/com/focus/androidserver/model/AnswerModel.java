package com.focus.androidserver.model;

public class AnswerModel {
	private int id;
	private int uid;
	private int qid;
	private String answer;
	private String updatetime;

	public AnswerModel() {
		super();
	}

	public AnswerModel(int uid, int qid, String answer,
			String updatetime) {
		super();
		this.uid = uid;
		this.qid = qid;
		this.answer = answer;
		this.updatetime = updatetime;
	}
	
	public AnswerModel(int id, int uid, int qid, String answer,
			String updatetime) {
		super();
		this.id = id;
		this.uid = uid;
		this.qid = qid;
		this.answer = answer;
		this.updatetime = updatetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	
}
