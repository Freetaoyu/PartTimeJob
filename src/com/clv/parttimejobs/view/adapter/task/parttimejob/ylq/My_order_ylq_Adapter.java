package com.clv.parttimejobs.view.adapter.task.parttimejob.ylq;

import java.util.List;

import com.clv.homework.R;
import com.clv.parttimejobs.entity.consult.News;
import com.clv.parttimejobs.entity.consult.PartJobBean;
import com.clv.parttimejobs.model.interfacebackage.orderfragment_interface;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class My_order_ylq_Adapter extends BaseAdapter {

	private List<PartJobBean> list;
	private Context context;
	private orderfragment_interface listener;
	private DisplayImageOptions options;
	private String imgurl="http://images.haidaojobs.cn/parttimePhoto/";
	public My_order_ylq_Adapter(Context context, List<PartJobBean> list,orderfragment_interface listener) {
		super();
		this.list = list;
		this.context = context;
		this.listener=listener;
		options = new DisplayImageOptions.Builder()
		.showStubImage(R.drawable.jianzhi2) // ����ͼƬ�����ڼ���ʾ��ͼƬ
		.showImageForEmptyUri(R.drawable.jianzhi2) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
		.showImageOnFail(R.drawable.jianzhi2) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
		.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
		.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
		.displayer(new RoundedBitmapDisplayer(20)) // ���ó�Բ��ͼƬ
		.build(); // �������ù���DisplayImageOption����
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int position, View view, ViewGroup viewpartents) {
		// TODO Auto-generated method stub
		PartJobBean n = list.get(position);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.item_order_ylq, null);
		Holder holder =new Holder(view);
		// 4. ����������ģ��Ŀؼ���
		if(n.getPhotoName().length()!=0){
			ImageLoader.getInstance().displayImage(imgurl+n.getPhotoName(),holder.image, options);
		}
		holder.tvName.setText(n.getTitle());
		holder.button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.gotoalayout(position);
			}
		});
		return view;
	}

	class Holder {
		ImageView image;
		TextView tvName;
		TextView tvePeopleName;
		TextView tvetel;
		Button button;
		public Holder(View view){
			image =(ImageView) view.findViewById(R.id.shop_image);
			tvName =(TextView) view.findViewById(R.id.tv_contact_item_name);
			tvePeopleName =(TextView) view.findViewById(R.id.tv_contact_item_people);
			tvetel =(TextView) view.findViewById(R.id.tv_contact_item_pay_way);
			button =(Button)view.findViewById(R.id.ylq_button);
		}
	}
}
