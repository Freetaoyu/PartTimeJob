package com.clv.parttimejobs.entity.consult.job;

import java.util.HashMap;
import java.util.List;

public class ProblemBean {

	private String partTimeId;//��ְid
	private String problemId;//����id
	private String topy;//����
	private String problem_topic;//��������  0---������ 1---����������  2---ѡ��������
	private String problem_content;//����ѡ��
	
	public String getPartTimeId() {
		return partTimeId;
	}
	public void setPartTimeId(String partTimeId) {
		this.partTimeId = partTimeId;
	}
	public String getProblemId() {
		return problemId;
	}
	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}
	public String getTopy() {
		return topy;
	}
	public void setTopy(String topy) {
		this.topy = topy;
	}
	public String getProblem_topic() {
		return problem_topic;
	}
	public void setProblem_topic(String problem_topic) {
		this.problem_topic = problem_topic;
	}
   
	public String getProblem_content() {
		return problem_content;
	}
	public void setProblem_content(String problem_content) {
		this.problem_content = problem_content;
	}
	public ProblemBean() {
		super();
	}
	public ProblemBean(String partTimeId, String problemId, String topy,
			String problem_topic, String problem_content) {
		super();
		this.partTimeId = partTimeId;
		this.problemId = problemId;
		this.topy = topy;
		this.problem_topic = problem_topic;
		this.problem_content = problem_content;
	}
	
	
}
