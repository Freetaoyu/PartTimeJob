package com.clv.parttimejobs.util.networkinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;


public class CheckNetWerk {

	public boolean isConnectNetWork(Context act) {
		NetworkInfo netIntfo = null;
		ConnectivityManager cm ;
		try {
			cm = (ConnectivityManager) act
					.getSystemService(act.CONNECTIVITY_SERVICE);
			netIntfo = cm.getActiveNetworkInfo();
		} catch (Exception e) {
			// �쳣����
			Toast.makeText(act, "û������Ȩ�ޣ���������Ȩ��", Toast.LENGTH_LONG).show();
		}

		if (netIntfo == null) {
			// ���û������ ��ʾ������
			return false;

		} else {
			// ���û������ ��ʾ������
			return true;

		}
	}
}
