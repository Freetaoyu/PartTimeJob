package com.clv.parttimejobs.util.Factory;

public class UriFactory {

	/*
	 * 
	 * 
	 * 
	 * <-------------------��������ӿ�---------------------->
	 * 
	 * 
	 * 
	 * 
	 */
	private final static String  questHead ="http://115.159.64.167:8080/haidaojobs/user";//����ͷ
	/*
	 * 
	 * ��------------------------------------��ְ��-------------------------------------------��
	 * 
	 */
	// ��ȡ��ְ�б�
	public static String getPartJobUrl() {
//		String url = "http://115.159.64.167:8080/ssm/user/parttimes/getPartTimeList";
		String url = questHead+"/parttimes/getPartTimeList";
		return url;
	}

	// ��ȡ��ְ����
	public static String getPartJobInformationUrl() {
		String url = questHead+"/parttimes/getPartTimeInformation";
		return url;
	}

	// ��ְ����
	public static String getPartRegistrationUrl() {
		String url = questHead+"/parttimes/partTimeRegistration";
		return url;
	}

	//��ȡ����˼�ְ
	public static String getPendingListUrl() {
		String url = questHead+"/parttimes/getPendingList";
		return url;
	}
	/*
	 * 
	 * <------------------------------�û���----------------------------------------->
	 * 
	 */
	// ��ѯǩ������
	public static String getselectSignInUrl() {
		String url = questHead+"/my/selectSignIn";
		return url;
	}

	// �û�ǩ��
	public static String getRetroactiveUrl() {
		String url = questHead+"/my/retroactive";
		return url;
	}

	// ��ѯ���
	public static String getSelectSignInGiftUrl() {
		String url = questHead+"/my/selectSignInGift";
		return url;
	}
	
	//�û���ȡ����
	public static String getSignInGiftUrl() {
		String url = questHead+"/my/getSignInGift";
		return url;
	}
	
	//�û������Ϣ��д
	public static String getIdentityAuthenticationUrl() {
		String url = questHead+"/resume/identity/identityAuthentication";
		return url;
	}
	
	// �鿴�û��ύ��Ϣ
	public static String getSelectIdentityAuditConclusionUrl() {
		String url = questHead+"/resume/identity/selectIdentityAuditConclusion";
		return url;
	}
	
	//�û��ϴ�ͼƬ
	public static String getUploadCertificatePhotoUrl() {
		String url = questHead+"/resume/identity/uploadCertificatePhoto";
		return url;
	}
	//�û��ϴ����ͼƬ
	public static String getAddPhotoUrl() {
		String url = questHead+"/resume/photo/addPhoto";
		return url;
	}
	//�������ͼƬ
	public static String getSelectPhotoUrl() {
		String url = questHead+"/resume/photo/selectPhoto";
		return url;
	}
	//ɾ�����ͼƬ
	public static String getDeletePhotoUrl() {
		String url = questHead+"/resume/photo/deletePhoto";
		return url;
	}
	//�û��޸�����
	public static String getModifyUserNameUrl() {
		String url = questHead+"/modify/modifyUserName";
		return url;
	}
	//�޸��û������Ϣ
	public static String getModifyUserHeightUrl() {
		String url = questHead+"/resume/identity/modifyHeight";
		return url;
	}
	//��ѯ�û���Ϣ
	public static String getInformationUrl() {
		String url = questHead+"/resume/identity/getInformation";
		return url;
	}
	//��ȡ�û�����
	public static String getSelectSkillUrl() {
		String url = questHead+"/resume/skill/selectSkill";
		return url;
	}
	//�û����Ӽ���
	public static String getAddKillUrl() {
		String url = questHead+"/resume/skill/addSkill";
		return url;
	}
	//�û�ɾ������
	public static String getDeleteKillUrl() {
		String url = questHead+"/resume/skill/deleteSkill";
		return url;
	}
	//�û��޸ļ���
	public static String getModifySkillUrl() {
		String url = questHead+"/resume/skill/modifySkill";
		return url;
	}
	/*
	 * 
	 * ��-------------------------------�û���¼--------------------------------��
	 * 
	 */
	//�û���¼
	public static String getSignInUrl() {
		String url = questHead+"/signIn";
		return url;
	}
	/*
	 * 
	 * �û�ע��
	 * 
	 */
	//�����ֻ��Ƿ�����
	public static String getIsUserPhoneNoUrl() {
		String url = questHead+"/isUserPhoneNo";
		return url;
	}
	//��ȡ��֤��
	public static String getCodeUrl() {
		String url = questHead+"http://115.159.64.167:8080/ssm/code/getCode";//
		return url;
	}
	//�����֤��
	public static String getCheckCode() {
		String url = questHead+"http://115.159.64.167:8080/ssm/code/checkCode";
		return url;
	}
	//�����û�----ע��
	public static String getAddUserUrl() {
		String url = questHead+"/addUser";
		return url;
	}
	//�޸��û��ֻ�
	public static String getModifyUserPhoneUrl() {
		String url = questHead+"http://115.159.64.167:8080/ssm/user/modify/modifyUserPhone";
		return url;
	}
	//�޸��û�����
	public static String getModifyUserPasswordUrl() {
		String url = questHead+"http://115.159.64.167:8080/ssm/user/modify/modifyUserPassword";
		return url;
	}
	/*
	 * 
	 * 
	 * �û�����
	 * 
	 * 
	 */
	//��ȡ�û�ͷ��
	public static String getHeadPortraitUrl() {
		String url = "http://115.159.64.167:8080/ssm/user/selectHeadPortraitURL";
		return url;
	}
	//�޸��û�ͷ��
	public static String getModifyUserHeadPortraitUrl() {
		String url = "http://115.159.64.167:8080/ssm/user/modify/modifyUserHeadPortrait";
		return url;
	}
	
}
