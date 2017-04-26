package com.clv.parttimejobs.activity.minelayout.mywallet;

import java.util.ArrayList;
import java.util.List;

import com.clv.homework.R;
import com.clv.parttimejobs.activity.minelayout.login.Login;
import com.clv.parttimejobs.entity.my.mywallet.Pickers;
import com.clv.parttimejobs.view.ui.customview.PickerScrollView;
import com.clv.parttimejobs.view.ui.customview.PickerScrollView.onSelectListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MyWallet_TJYingHangKa_activity extends Activity {

	private Context context;
	private PopupWindow popupWindow;
	private PickerScrollView pickerscrlllview01; // ����ѡ����
	private PickerScrollView pickerscrlllview02; 

	private List<Pickers> list; // ����ѡ��������
	private String[] id;
	private String[] name;

	private List<Pickers> list2;
	private String[] id2;
	private String[] name2;
	
	private ImageButton returnButton;
	private Button selectButton;
	private EditText edittext_name;
	private EditText edittext_cardno;
	private EditText edittext_phoneno;
	private ImageButton nextButton;
	private CheckBox checkbox;
	
	private String temp_YHname="",temp_CardName="";
	private String YHname="",CardName="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mywallet_tjyhk_layout);
		context = this;
		init();
	}

	public void init(){
		returnButton =(ImageButton) findViewById(R.id.tjyhk_return_button);
		selectButton=(Button) findViewById(R.id.mymywallet_tjyhk_button01);
		edittext_name = (EditText) findViewById(R.id.mymywallet_tjyhk_edittext01);
		edittext_cardno = (EditText) findViewById(R.id.mymywallet_tjyhk_edittext02);
		edittext_phoneno = (EditText) findViewById(R.id.mymywallet_tjyhk_edittext03);
		checkbox = (CheckBox) findViewById(R.id.mymywallet_tjyhk_check);
		nextButton =(ImageButton) findViewById(R.id.mymywallet_tjyhk_imagebutton);
		edittext_name.addTextChangedListener(textWatcher); 
		edittext_cardno.addTextChangedListener(textWatcher); 
		edittext_phoneno.addTextChangedListener(textWatcher); 
		InnerOnClickListener i=new InnerOnClickListener();
		selectButton.setOnClickListener(i);
		returnButton.setOnClickListener(i);
		nextButton.setOnClickListener(i);
	}
	private class InnerOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.mymywallet_tjyhk_button01:{
				createView(v);
				break;
			}
			case R.id.tjyhk_return_button:{
				MyWallet_TJYingHangKa_activity.this.finish();
				break;
			}
			case R.id.mymywallet_tjyhk_imagebutton:{
				String name= edittext_name.getText().toString().trim();
				String cardno= edittext_cardno.getText().toString().trim();
				String phoneno= edittext_phoneno.getText().toString().trim();
				if(name.length()==0){
					Toast.makeText(MyWallet_TJYingHangKa_activity.this, "��������Ϊ��", Toast.LENGTH_SHORT).show();
				}else{
					if(cardno.length()==0){
					  Toast.makeText(MyWallet_TJYingHangKa_activity.this, "���Ų���Ϊ��", Toast.LENGTH_SHORT).show();
				    }else{
				    	if(phoneno.length()!=11){
					      Toast.makeText(MyWallet_TJYingHangKa_activity.this, "����д�������ֻ���", Toast.LENGTH_SHORT).show();
				        }else{ 
				        	if(YHname.length()==0){
					          Toast.makeText(MyWallet_TJYingHangKa_activity.this, "��ѡ�����п�", Toast.LENGTH_SHORT).show();
				            }else{
                              if(CardName.length()==0){
					             Toast.makeText(MyWallet_TJYingHangKa_activity.this, "��ѡ�����п�", Toast.LENGTH_SHORT).show();
				              }else{
				            	 if(!checkbox.isChecked()){
					               Toast.makeText(MyWallet_TJYingHangKa_activity.this, "ͬ���û�Э�����ע��", Toast.LENGTH_SHORT).show();
			                     }else{
					                Intent intent =new Intent(MyWallet_TJYingHangKa_activity.this,MyWallet_YZSJ_activty.class);
					                startActivity(intent);	
				                 }
				              }
                            }
				        }
				    }
				}
				break;
			}
			}
		}
		
	}
	public void changeImg(){
		String name= edittext_name.getText().toString().trim();
		String cardno= edittext_cardno.getText().toString().trim();
		String phoneno= edittext_phoneno.getText().toString().trim();
		if((name.length()!=0)&&(cardno.length()!=0)&&(phoneno.length()!=0)&&(YHname.length()!=0)&&(CardName.length()!=0)){
			nextButton.setImageResource(R.drawable.select_tjyhk_next_button);
		}else{
			nextButton.setImageResource(R.drawable.mywalt_bar_xiayibu_set);
		}
	}
	private TextWatcher textWatcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			changeImg();
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			//
		}

		@Override
		public void afterTextChanged(Editable s) {
			//
		}
	};
	private void createView(View v) {
		// ��ȡ�Զ��岼���ļ�activity_popupwindow_left.xml����ͼ
		View popupWindow_view = this.getLayoutInflater().inflate(
				R.layout.popwindow_mywallet_addyinghangcard, null, false);

		Display display = getWindowManager().getDefaultDisplay();
		// ����PopupWindowʵ��,200,LayoutParams.MATCH_PARENT�ֱ��ǿ�Ⱥ͸߶�
		System.out.println(display.getWidth()+","+ display.getHeight()/3);
		popupWindow = new PopupWindow(popupWindow_view,
				display.getWidth(),display.getHeight()/3, true);
		popupWindow.setFocusable(true);
		backgroundAlpha(0.7f);

		// ���ö���Ч��
		// popupWindow.setAnimationStyle(R.style.AnimationFade);
		// ������λ����ʾ��ʽ,����Ļ�����
		popupWindow.showAtLocation(v, Gravity.BOTTOM
				, 0, 0);
		pickerscrlllview01 = (PickerScrollView) popupWindow_view
				.findViewById(R.id.pickerscrlllview01);
		pickerscrlllview02 = (PickerScrollView) popupWindow_view
				.findViewById(R.id.pickerscrlllview02);
		pickerscrlllview01.setOnSelectListener(1,pickerListener);
		pickerscrlllview02.setOnSelectListener(2,pickerListener);

		initView1();initView2();
		Button button_exit = (Button) popupWindow_view.findViewById(R.id.popwin_mywallet_button01);
		Button button_goto = (Button) popupWindow_view
				.findViewById(R.id.popwin_mywallet_button02);
		button_exit.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				backgroundAlpha(1f);
				popupWindow.dismiss();
				popupWindow = null;
				return true;
			}
		});

		button_goto.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				backgroundAlpha(1f);
				changeYHnameText();
				popupWindow.dismiss();
				popupWindow = null;
				return true;
			}
		});

	}

	// ����ѡ����ѡ���¼�
	onSelectListener pickerListener = new onSelectListener() {

		@Override
		public void onSelect(int position,Pickers pickers) {
			if(position==1){
				temp_YHname = pickers.getShowConetnt();
			}else if(position==2){
				temp_CardName = pickers.getShowConetnt();
			}
		}
	};

	public void changeYHnameText(){
		YHname=temp_YHname;
		CardName=temp_CardName;
		selectButton.setText(YHname+CardName);
		changeImg();
	}
	public void backgroundAlpha(float bgAlpha) {
		WindowManager.LayoutParams lp = this.getWindow().getAttributes();
		lp.alpha = bgAlpha; // 0.0-1.0
		this.getWindow().setAttributes(lp);
	}

	public void initView1() {
		list = new ArrayList<Pickers>();
		id = new String[] { "1", "2", "3" };
		name = new String[] { "ũҵ����", "��������", "��������" };
		for (int i = 0; i < name.length; i++) {
			list.add(new Pickers(name[i], id[i]));
		}
		// �������ݣ�Ĭ��ѡ���һ��
		pickerscrlllview01.setData(list);
		pickerscrlllview01.setSelected(0);
		temp_YHname="ũҵ����";
	}

	private void initView2(){
		list2 = new ArrayList<Pickers>();
		id2 = new String[] { "1", "2" };
		name2 = new String[] { "���", "���ÿ�"};
		for (int i = 0; i < name2.length; i++) {
			list2.add(new Pickers(name2[i], id2[i]));
		}
		// �������ݣ�Ĭ��ѡ���һ��
		pickerscrlllview02.setData(list2);
		pickerscrlllview02.setSelected(0);
		temp_CardName="���";
	}


}
