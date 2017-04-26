package com.clv.parttimejobs.entity.consult;

public class PartJobBean {

	private String lastTime;// �ü�ְ����޸�ʱ��
	private String location;// ��ַ����
	private String partTimeId;// ��ְid
	private String partTimeQualification;// ��ְ����
	private String photoName;// ��ְͼƬ
	private String salary;// н��
	private String title;// ��ְ����
	private String workDate;// ����ʱ���

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPartTimeId() {
		return partTimeId;
	}

	public void setPartTimeId(String partTimeId) {
		this.partTimeId = partTimeId;
	}

	public String getPartTimeQualification() {
		return partTimeQualification;
	}

	public void setPartTimeQualification(String partTimeQualification) {
		this.partTimeQualification = partTimeQualification;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public PartJobBean() {
		super();
	}

	public PartJobBean(String lastTime, String location, String partTimeId,
			String partTimeQualification, String photoName, String salary,
			String title, String workDate) {
		super();
		this.lastTime = lastTime;
		this.location = location;
		this.partTimeId = partTimeId;
		this.partTimeQualification = partTimeQualification;
		this.photoName = photoName;
		this.salary = salary;
		this.title = title;
		this.workDate = workDate;
	}


}
