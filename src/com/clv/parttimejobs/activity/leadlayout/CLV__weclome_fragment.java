package com.clv.parttimejobs.activity.leadlayout;

import java.util.ArrayList;

import com.clv.homework.R;
import com.clv.parttimejobs.activity.mainlayout.MainActivity;
import com.clv.parttimejobs.view.adapter.ViewPagerAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;


/**
 * @author yangyu
 *	���������������������
 */
public class CLV__weclome_fragment extends Activity implements OnClickListener,OnPageChangeListener {
	//����ViewPager����
	private ViewPager viewPager;
	
	//����ViewPager������
	private ViewPagerAdapter vpAdapter;
	
	//����һ��ArrayList�����View
	private ArrayList<View> views = new ArrayList<View>();;

	//����ͼƬ��Դ
    private static final int[] pics = {R.drawable.weclome1,R.drawable.weclome2,R.drawable.weclome3,R.drawable.weclome4};
    
    //�ײ�С���ͼƬ
    private RadioButton[] points =new RadioButton[4];
    private ImageButton gotoLandButton;
    //��¼��ǰѡ��λ��
    private int currentIndex=0;
    
    private int screenWdith ;
    private int screenHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clv__weclome_fragment);
		initView();
		initData();	
		
	}

	/**
	 * ��ʼ�����
	 */
	private void initView(){
		WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);

		screenWdith = wm.getDefaultDisplay().getWidth();
		screenHeight = wm.getDefaultDisplay().getHeight();
		//ʵ����ArrayList����
		
		
		//ʵ����ViewPager
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		
		//��ʼ���ײ�С��
		points[0] =(RadioButton)findViewById(R.id.radiobutton_wecl1);
		points[1] =(RadioButton)findViewById(R.id.radiobutton_wecl2);
		points[2] =(RadioButton)findViewById(R.id.radiobutton_wecl3);
		points[3] =(RadioButton)findViewById(R.id.radiobutton_wecl4);
		//ʵ����ViewPager������
		gotoLandButton =(ImageButton) findViewById(R.id.gotoland);
		InnerOnClickListener i =new InnerOnClickListener();
		gotoLandButton.setOnClickListener(i);
	}
	
	/**
	 * ��ʼ������
	 */
	private void initData(){
		//����һ�����ֲ����ò���
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
																  LinearLayout.LayoutParams.MATCH_PARENT);
       
	//��ʼ������ͼƬ�б�
	for(int i=0; i<pics.length; i++) {
	    ImageView iv = new ImageView(this);
	    iv.setLayoutParams(mParams);
	    
	    Bitmap bm = BitmapFactory.decodeResource( getResources(),pics[i]);
	    bm  = Bitmap.createScaledBitmap(bm, screenWdith, screenHeight, false);
	    iv.setBackgroundResource(pics[i]);
//	    iv.setImageResource(pics[i]);
	    views.add(iv);
	} 
	vpAdapter = new ViewPagerAdapter(views);
	//��������
	viewPager.setAdapter(vpAdapter);
	//���ü���
	viewPager.setOnPageChangeListener(this);
	
	
	}
	private class InnerOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.gotoland:{
				CLV__weclome_fragment.this.finish();
				Intent intent =new Intent(CLV__weclome_fragment.this,MainActivity.class);
				startActivity(intent);
				break;
			}
			}
		}
		
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}
	
	/**
	 * ����ǰҳ�汻����ʱ����
	 */

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}
	
	/**
	 * ���µ�ҳ�汻ѡ��ʱ����
	 */

	@Override
	public void onPageSelected(int position) {
		//���õײ�С��ѡ��״̬
		if(position==3){
			gotoLandButton.setVisibility(View.VISIBLE);
		}else{
			gotoLandButton.setVisibility(View.INVISIBLE);
		}
	    setCurDot(position);
	}

	/**
	 * ͨ������¼����л���ǰ��ҳ��
	 */
	@Override
	public void onClick(View v) {
		 int position = (Integer)v.getTag();
	 setCurView(position);
	 setCurDot(position);		
	}

	/**
	 * ���õ�ǰҳ���λ��
	 */
	private void setCurView(int position){
	 if (position < 0 || position >= pics.length) {
	     return;
	 }
	 if(position==3){
		 
	 }
	 viewPager.setCurrentItem(position);
     }
//
     /**
     * ���õ�ǰ��С���λ��
     */
    private void setCurDot(int positon){
	 if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
	     return;
	 }
	 points[positon].setChecked(true);
	 points[currentIndex].setChecked(false);

	 currentIndex = positon;
     }
	
}