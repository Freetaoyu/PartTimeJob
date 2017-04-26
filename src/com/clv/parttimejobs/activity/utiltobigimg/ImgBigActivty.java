package com.clv.parttimejobs.activity.utiltobigimg;

import com.clv.homework.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ImgBigActivty extends Activity {

	Intent intent;
	private DisplayImageOptions options;
	private ImageButton bigimg_imgbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img_big_activty);
		options = new DisplayImageOptions.Builder()
		.showStubImage(R.drawable.nologin_headimage) // ����ͼƬ�����ڼ���ʾ��ͼƬ
		.showImageForEmptyUri(R.drawable.nologin_headimage) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
		.showImageOnFail(R.drawable.nologin_headimage) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
		.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
		.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
		.displayer(new RoundedBitmapDisplayer(20)) // ���ó�Բ��ͼƬ
		.build(); // �������ù���DisplayImageOption����
		
		bigimg_imgbutton =(ImageButton)findViewById(R.id.bigimg_imgbutton);
		
		intent =this.getIntent();
		String url=intent.getStringExtra("url");
		
		
		ImageLoader.getInstance().displayImage(url, bigimg_imgbutton, options);
		bigimg_imgbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ImgBigActivty.this.finish();
			}
		});
	}

}
