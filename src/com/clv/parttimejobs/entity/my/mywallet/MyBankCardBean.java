package com.clv.parttimejobs.entity.my.mywallet;

public class MyBankCardBean {

	private int bank_site;//���б�־ 0-ũ�� 1-���� 2-����
	private String sfz_no;//���֤
	private boolean isSelected;
	public int getBank_site() {
		return bank_site;
	}
	public void setBank_site(int bank_site) {
		this.bank_site = bank_site;
	}
	public String getSfz_no() {
		return sfz_no;
	}
	public void setSfz_no(String sfz_no) {
		this.sfz_no = sfz_no;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public MyBankCardBean() {
		super();
	}
	public MyBankCardBean(int bank_site, String sfz_no, boolean isSelected) {
		super();
		this.bank_site = bank_site;
		this.sfz_no = sfz_no;
		this.isSelected = isSelected;
	}
	
	
}
