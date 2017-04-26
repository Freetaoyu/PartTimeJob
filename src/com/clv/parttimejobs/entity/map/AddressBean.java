package com.clv.parttimejobs.entity.map;

public class AddressBean {
	private double longitude;// ����
	private double latitude;// γ��
	private String title;// ��Ϣ����
	private String text;// ��Ϣ����

	public AddressBean(double lon, double lat, String title, String text) {
		this.longitude = lon;
		this.latitude = lat;
		this.title = title;
		this.text = text;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
}
