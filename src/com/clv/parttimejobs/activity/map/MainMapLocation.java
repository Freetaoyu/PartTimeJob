package com.clv.parttimejobs.activity.map;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.clv.parttimejobs.activity.mainlayout.MainActivity;
import com.clv.parttimejobs.activity.message.personal.Message_person_activity;
import com.clv.parttimejobs.entity.map.InputTask;
import com.clv.parttimejobs.view.adapter.map.SearchAdapter;
import com.clv.homework.R;
import com.clv.homework.R.id;
import com.clv.homework.R.layout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainMapLocation extends Activity implements
		AMap.OnMapLongClickListener, AMap.OnMapScreenShotListener,
		LocationSource, AMapLocationListener, TextWatcher, OnItemClickListener {

	private String province = "";
	// ��ʾ��ͼ��Ҫ�ı���
	private MapView mapView;// ��ͼ�ؼ�
	private AMap aMap;// ��ͼ����
	private EditText text;
	private TextView text01;
	private TextView text02;
	private ListView listview;
	private Button map_button;
	SearchAdapter mAdapter;
	private ArrayAdapter<String> adapter;
	// ��λ��Ҫ������
	private AMapLocationClient mLocationClient = null;// ��λ�����
	private AMapLocationClientOption mLocationOption = null;// ��λ����
	private OnLocationChangedListener mListener = null;// ��λ������
	private List<String> list = new ArrayList<String>();
	// ��ʶ�������ж��Ƿ�ֻ��ʾһ�ζ�λ��Ϣ���û����¶�λ
	private boolean isFirstLoc = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_map_location);

		text = (EditText) findViewById(R.id.map_edittext);
		text01 = (TextView) findViewById(R.id.map_textview_address);
		text02 = (TextView) findViewById(R.id.map_textview_address_xx);
		map_button = (Button) findViewById(R.id.map_button);
		InnerOnClickListener i = new InnerOnClickListener();
		map_button.setOnClickListener(i);

//		Spinner spinner = (Spinner) findViewById(R.id.spinner2);
//		list.add("��ɽ");
//		list.add("����");
//		list.add("�Ϻ�");
//		list.add("����");
//		list.add("����");
//		list.add("����");
//		adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_spinner_item, list);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner.setAdapter(adapter);

		listview = (ListView) findViewById(R.id.listmap);
		text.addTextChangedListener(this);
		mAdapter = new SearchAdapter(this);
		listview.setAdapter(mAdapter);
		// ��ʾ��ͼ
		mapView = (MapView) findViewById(R.id.map);
		// ����Ҫд
		mapView.onCreate(savedInstanceState);
		// ��ȡ��ͼ����
		aMap = mapView.getMap();

		// ������ʾ��λ��ť ���ҿ��Ե��
		UiSettings settings = aMap.getUiSettings();
		// ���ö�λ����
		aMap.setLocationSource(this);
		// �Ƿ���ʾ��λ��ť
		settings.setMyLocationButtonEnabled(true);
		// �Ƿ�ɴ�����λ����ʾ��λ��
		aMap.setMyLocationEnabled(true);
		aMap.moveCamera(CameraUpdateFactory.zoomTo(14));

		// //��λ��Сͼ�� Ĭ�������� �����Զ���һ�Ż���ʵ����һ��ͼƬ
		// MyLocationStyle myLocationStyle = new MyLocationStyle();
		// myLocationStyle.radiusFillColor(android.R.color.transparent);
		// myLocationStyle.strokeColor(android.R.color.transparent);
		// aMap.setMyLocationStyle(myLocationStyle);

		// ��ʼ��λ
		initLoc();
	}

	private class InnerOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.map_button: {
				Intent intent = new Intent();
				intent.putExtra("province", province);
				setResult(101, intent);
				MainMapLocation.this.finish();
				break;
			}
			}
		}

	}

	// ��λ
	private void initLoc() {
		// ��ʼ����λ
		mLocationClient = new AMapLocationClient(getApplicationContext());
		// ���ö�λ�ص�����
		mLocationClient.setLocationListener(this);
		// ��ʼ����λ����
		mLocationOption = new AMapLocationClientOption();
		// ���ö�λģʽΪ�߾���ģʽ��Battery_SavingΪ�͹���ģʽ��Device_Sensors�ǽ��豸ģʽ
		mLocationOption
				.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
		// �����Ƿ񷵻ص�ַ��Ϣ��Ĭ�Ϸ��ص�ַ��Ϣ��
		mLocationOption.setNeedAddress(true);
		// �����Ƿ�ֻ��λһ��,Ĭ��Ϊfalse
		mLocationOption.setOnceLocation(false);
		// �����Ƿ�ǿ��ˢ��WIFI��Ĭ��Ϊǿ��ˢ��
		mLocationOption.setWifiActiveScan(true);
		// �����Ƿ�����ģ��λ��,Ĭ��Ϊfalse��������ģ��λ��
		mLocationOption.setMockEnable(false);
		// ���ö�λ���,��λ����,Ĭ��Ϊ2000ms
		mLocationOption.setInterval(2000);
		// ����λ�ͻ��˶������ö�λ����
		mLocationClient.setLocationOption(mLocationOption);
		// ������λ
		mLocationClient.startLocation();
	}

	public void onLocationChanged(AMapLocation amapLocation) {
		if (amapLocation != null) {
			if (amapLocation.getErrorCode() == 0) {
				// ��λ�ɹ��ص���Ϣ�����������Ϣ
				amapLocation.getLocationType();// ��ȡ��ǰ��λ�����Դ�������綨λ���������ٷ���λ���ͱ�
				amapLocation.getLatitude();// ��ȡγ��
				amapLocation.getLongitude();// ��ȡ����
				amapLocation.getAccuracy();// ��ȡ������Ϣ
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date = new Date(amapLocation.getTime());
				df.format(date);// ��λʱ��
				amapLocation.getAddress();// ��ַ�����option������isNeedAddressΪfalse����û�д˽�������綨λ����л��е�ַ��Ϣ��GPS��λ�����ص�ַ��Ϣ��
				amapLocation.getCountry();// ������Ϣ
				amapLocation.getProvince();// ʡ��Ϣ
				province = amapLocation.getCity();// ������Ϣ
				amapLocation.getDistrict();// ������Ϣ
				amapLocation.getStreet();// �ֵ���Ϣ
				amapLocation.getStreetNum();// �ֵ����ƺ���Ϣ
				amapLocation.getCityCode();// ���б���
				amapLocation.getAdCode();// ��������

				// ��������ñ�־λ����ʱ���϶���ͼʱ�����᲻�Ͻ���ͼ�ƶ�����ǰ��λ��
				if (isFirstLoc) {
					// �������ż���
					// aMap.moveCamera(CameraUpdateFactory.zoomTo(22));
					// ����ͼ�ƶ�����λ��
					aMap.moveCamera(CameraUpdateFactory
							.changeLatLng(new LatLng(
									amapLocation.getLatitude(), amapLocation
											.getLongitude())));
					// �����λ��ť �ܹ�����ͼ�������ƶ�����λ��
					mListener.onLocationChanged(amapLocation);
					// ���ͼ��
					aMap.addMarker(getMarkerOptions(amapLocation));
					// getMarkerOptions(amapLocation);
					// ��ȡ��λ��Ϣ
					StringBuffer buffer = new StringBuffer();
					text01.setText(amapLocation.getCountry() + " "
							+ amapLocation.getProvince() + " "
							+ amapLocation.getCity());
					text02.setText(amapLocation.getCity() + ""
							+ amapLocation.getProvince() + ""
							+ amapLocation.getDistrict() + ""
							+ amapLocation.getStreet() + ""
							+ amapLocation.getStreetNum());
					buffer.append(amapLocation.getCountry() + ""
							+ amapLocation.getProvince() + ""
							+ amapLocation.getCity() + ""
							+ amapLocation.getProvince() + ""
							+ amapLocation.getDistrict() + ""
							+ amapLocation.getStreet() + ""
							+ amapLocation.getStreetNum());
					Toast.makeText(getApplicationContext(), buffer.toString(),
							Toast.LENGTH_LONG).show();
					isFirstLoc = false;
					aMap.moveCamera(CameraUpdateFactory.zoomTo(14));
				}

			} else {
				// ��ʾ������ϢErrCode�Ǵ����룬errInfo�Ǵ�����Ϣ������������
				Log.e("AmapError",
						"location Error, ErrCode:"
								+ amapLocation.getErrorCode() + ", errInfo:"
								+ amapLocation.getErrorInfo());

				Toast.makeText(getApplicationContext(), "��λʧ��",
						Toast.LENGTH_LONG).show();
			}
		}
	}

	// �Զ���һ��ͼ������������ͼ�꣬�����ǵ��ͼ��ʱ����ʾ���õ���Ϣ
	private MarkerOptions getMarkerOptions(AMapLocation amapLocation) {
		// �Զ���ϵͳ��λС����
		MarkerOptions options = new MarkerOptions();
		// ͼ��
		// options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.fire));
		// λ��
		options.position(new LatLng(amapLocation.getLatitude(), amapLocation
				.getLongitude()));
		StringBuffer buffer = new StringBuffer();
		buffer.append(amapLocation.getCountry() + ""
				+ amapLocation.getProvince() + "" + amapLocation.getCity() + ""
				+ amapLocation.getDistrict() + "" + amapLocation.getStreet()
				+ "" + amapLocation.getStreetNum());
		// ����
		options.title(buffer.toString());
		// �ӱ���
		// options.snippet("����û�");
		// ���ö���֡ˢ��һ��ͼƬ��Դ
		options.period(60);
		return options;
	}

	// ���λ
	@Override
	public void activate(OnLocationChangedListener listener) {
		mListener = listener;

	}

	// ֹͣ��λ
	@Override
	public void deactivate() {
		mListener = null;
	}

	/**
	 * ����������д
	 */
	@Override
	protected void onResume() {
		super.onResume();
		mapView.onResume();
	}

	/**
	 * ����������д
	 */
	@Override
	protected void onPause() {
		super.onPause();
		mapView.onPause();
	}

	/**
	 * ����������д
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	/**
	 * ����������д
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	/**
	 * ������ͼ���н���
	 *
	 * @param latLng
	 */
	@Override
	public void onMapLongClick(LatLng latLng) {

		// ���ý��������ӿڣ���ȡ��ͼ��������
		// ��Ҫ����һ�� AMap.OnMapLongClickListener �ӿڵ�ʵ����
		aMap.getMapScreenShot(this);
	}

	/**
	 * �����ص����� �����ͼ
	 */

	@Override
	public void onMapScreenShot(Bitmap bitmap) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			// ������SD����Ŀ¼�£�ͼƬΪpng��ʽ��
			FileOutputStream fos = new FileOutputStream(
					Environment.getExternalStorageDirectory() + "/test_"
							+ sdf.format(new Date()) + ".png");
			boolean b = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (b)

				Toast.makeText(MainMapLocation.this, "�����ɹ�", Toast.LENGTH_LONG)
						.show();
			else {
				Toast.makeText(MainMapLocation.this, "����ʧ��", Toast.LENGTH_LONG)
						.show();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMapScreenShot(Bitmap arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		InputTask.getInstance(this, mAdapter, aMap).onSearch(s.toString(), "");
	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// Item����¼�����
	}

}
