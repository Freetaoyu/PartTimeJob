package com.clv.parttimejobs.entity.message.person;

public class MessageSend {

	private String name;//����
	private String headimg_url;//ͷ���ַ
	private String textcontext;//��
	private int istext;//����
	private String musicUrl;//������ַ
	private int isMy;//���Լ�����
	private float time;//ʱ��
	private String datetime;
	private boolean isRead ;
	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getTextcontext() {
		return textcontext;
	}
	public void setTextcontext(String textcontext) {
		this.textcontext = textcontext;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public int getIsMy() {
		return isMy;
	}
	public void setIsMy(int isMy) {
		this.isMy = isMy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadimg_url() {
		return headimg_url;
	}
	public void setHeadimg_url(String headimg_url) {
		this.headimg_url = headimg_url;
	}
	public int getIstext() {
		return istext;
	}
	public void setIstext(int istext) {
		this.istext = istext;
	}
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public MessageSend(String name, String headimg_url, String textcontext,
			int istext, String musicUrl, int isMy, float time, String datetime,
			boolean isRead) {
		super();
		this.name = name;
		this.headimg_url = headimg_url;
		this.textcontext = textcontext;
		this.istext = istext;
		this.musicUrl = musicUrl;
		this.isMy = isMy;
		this.time = time;
		this.datetime = datetime;
		this.isRead = isRead;
	}
	
	
}
