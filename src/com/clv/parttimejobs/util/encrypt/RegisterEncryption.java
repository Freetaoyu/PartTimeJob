package com.clv.parttimejobs.util.encrypt;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apaches.commons.codec.binary.Base64;

public class RegisterEncryption {
	public String Encrypt_phone(String phone, String password, String sKey)
			throws Exception {
		// ���������MD5����
		String passwordMD5 = getMD5(password);
		System.out.println(passwordMD5);

		// ���ܽ�����
		byte[] raw = sKey.getBytes("UTF-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encryptedPhone = cipher.doFinal(phone.getBytes("UTF-8"));
		byte[] encryptedPassword = cipher
				.doFinal(passwordMD5.getBytes("UTF-8"));

		// ��ü��ܺ�Ľ��
		String enPhone = new Base64().encodeToString(encryptedPhone);
		String enPassword = new Base64().encodeToString(encryptedPassword);

		return enPhone;
	}

	public String Encrypt_password(String phone, String password, String sKey)
			throws Exception {
		// ���������MD5����
		String passwordMD5 = getMD5(password);
		System.out.println(passwordMD5);

		// ���ܽ�����
		byte[] raw = sKey.getBytes("UTF-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encryptedPhone = cipher.doFinal(phone.getBytes("UTF-8"));
		byte[] encryptedPassword = cipher
				.doFinal(passwordMD5.getBytes("UTF-8"));

		// ��ü��ܺ�Ľ��
		String enPhone = new Base64().encodeToString(encryptedPhone);
		String enPassword = new Base64().encodeToString(encryptedPassword);

		return enPassword;
	}

	public String getMD5(String str) {
		try {
			// ����һ��MD5���ܼ���ժҪ
			MessageDigest md = MessageDigest.getInstance("MD5");
			// ����md5����
			md.update(str.getBytes());
			// digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
			// BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			System.out.println("MD5���ܳ���");
		}
		return null;
	}
}
