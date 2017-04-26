package com.clv.parttimejobs.util.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apaches.commons.codec.binary.Base64;
/**
 * �ͻ�������Ψһ�ܳ��Ҿ���ʱЧ��
 * @author evanglist
 *
 */
public class MarkKey {
	/**
	 * ����
	 * @param sSrc
	 * 			����������
	 * @param sKey
	 * 			������Կ��
	 * @return
	 * @throws Exception
	 */
	 public static String Encrypt(String sSrc, String sKey) throws Exception {
	        if (sKey == null) {
	            System.out.print("KeyΪ��null");
	            return null;
	        }
	        // �ж�Key�Ƿ�Ϊ16λ
	        if (sKey.length() != 16) {
	            System.out.print("Key���Ȳ���16λ");
	            return null;
	        }
	        byte[] raw = sKey.getBytes("utf-8");
	        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"�㷨/ģʽ/���뷽ʽ"
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
	        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

	        return new Base64().encodeToString(encrypted);///�˴�ʹ��BASE64��ת�빦�ܣ�ͬʱ����2�μ��ܵ����á�
	    }
	/**
	 * ������ݺ�
	 * @param phone
	 * @return
	 */
	public String builderId(String id,String security_key){
		long time = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder(security_key);
//		sb.delete(0, 11);
		sb.append(Long.valueOf(time).toString());
		sb.append(id);
		String idr = sb.toString();
		System.out.println(idr.length());
		System.out.println(idr);
		return idr;
	}
	/**
	 * ������ϢԿ��
	 * @param phone
	 * @param security_key
	 * @return
	 */
	public String builderMessageKey(String phone,String security_key){
		
		StringBuilder sb = new StringBuilder(security_key);
		sb.delete(0, 16);
		
		String str = sb.toString();
		char[] ch = str.toCharArray();
		int sum = 0;
		for(char c: ch){
			sum += (int) c;
		}
		sb.append(Integer.valueOf(sum%9).toString());
		
		long Num = Long.parseLong(phone);
		sb.append(Integer.valueOf((int)sum(Num)%7).toString());
		
		int count = 0;
		while(Num>10){
			count += Num%10%2==0?1:0;
			Num /= 10;
		}
		sb.append(Integer.valueOf(count).toString());
		String message =  sb.toString();
		return message;
	}
	/**
	 * ����ʱ��Կ��
	 * @param timeDelta
	 * 			:ʱ���
	 * @return
	 */
	public String builderTimeKey(){
		long time = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder(getMD5(getMD5(Long.valueOf(time/100000*100000).toString())));
		
		return sb.substring(0, 16);
		
	}
	
	public static long sum(long num){
		return num<10?num:num%10+sum(num/10);
	}
	
	public static String getMD5(String str) {
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











