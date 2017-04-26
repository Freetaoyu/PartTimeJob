package com.clv.parttimejobs.entity.map;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener;
import com.clv.parttimejobs.view.adapter.map.SearchAdapter;

public class InputTask implements OnPoiSearchListener {
	private static InputTask mInstance;
	private SearchAdapter mAdapter;
	private PoiSearch mSearch;
	private Context mContext;
	private AMap aMap;// ��ͼ����
	double lon;
	double lat;
	String title;
	String text;

	private InputTask(Context context, SearchAdapter adapter, AMap aMap) {
		this.mContext = context;
		this.mAdapter = adapter;
		this.aMap = aMap;
	}

	/**
	 * ��ȡʵ��
	 * 
	 * @param context
	 *            ������
	 * @param adapter
	 *            ����������
	 * @return
	 */
	public static InputTask getInstance(Context context, SearchAdapter adapter,
			AMap aMap) {
		if (mInstance == null) {
			synchronized (InputTask.class) {
				if (mInstance == null) {
					mInstance = new InputTask(context, adapter, aMap);
				}
			}
		}
		return mInstance;
	}

	/**
	 * ��������������
	 * 
	 * @param adapter
	 */
	public void setAdapter(SearchAdapter adapter) {
		this.mAdapter = adapter;
	}

	/**
	 * POI����
	 * 
	 * @param key
	 *            �ؼ���
	 * @param city
	 *            ����
	 */
	public void onSearch(String key, String city) {

		// POI��������
		PoiSearch.Query query = new PoiSearch.Query(key, "", city);
		mSearch = new PoiSearch(mContext, query);
		// �����첽����
		mSearch.setOnPoiSearchListener(this);
		// ��ѯPOI�첽�ӿ�
		mSearch.searchPOIAsyn();
	}

	/**
	 * �첽�����ص�
	 */
	@Override
	public void onPoiSearched(PoiResult poiResult, int rCode) {
		if (poiResult != null) {
			ArrayList<AddressBean> data = new ArrayList<AddressBean>();
			ArrayList<PoiItem> items = poiResult.getPois();
			for (PoiItem item : items) {
				// ��ȡ��γ�ȶ���
				LatLonPoint llp = item.getLatLonPoint();
				lon = llp.getLongitude();
				lat = llp.getLatitude();
				// ��ȡ����
				title = item.getTitle();
				// ��ȡ����
				text = item.getSnippet();
				data.add(new AddressBean(lon, lat, title, text));
			}
			mAdapter.setData(data);
			mAdapter.notifyDataSetChanged();

			aMap.addMarker(getMarkerOptions());
		}
	}

	// �Զ���һ��ͼ������������ͼ�꣬�����ǵ��ͼ��ʱ����ʾ���õ���Ϣ
	private MarkerOptions getMarkerOptions() {
		// �Զ���ϵͳ��λС����
		MarkerOptions options = new MarkerOptions();
		// ͼ��
		// options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.fire));
		// λ��
		options.position(new LatLng(lon, lat));
		// ����
		options.title(title);
		// �ӱ���
		options.snippet(text);
		// ���ö���֡ˢ��һ��ͼƬ��Դ
		options.period(60);
		return options;
	}

	@Override
	public void onPoiItemSearched(PoiItem arg0, int arg1) {
		// TODO Auto-generated method stub

	}
}