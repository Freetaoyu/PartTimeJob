package com.clv.parttimejobs.view.ui.customview;

import com.clv.homework.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ExpandView_jiesuan extends FrameLayout {
	private Animation mCollapseAnimation;
	private Animation mExpandAnimation;
	private boolean mIsExpand;

	private Button button1;
	private Button button2;
	private Button button3;
	
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	
	public ExpandView_jiesuan(Context paramContext) {
		this(paramContext, null);
	}

	public ExpandView_jiesuan(Context paramContext,
			AttributeSet paramAttributeSet) {
		this(paramContext, paramAttributeSet, 0);
	}

	public ExpandView_jiesuan(Context paramContext,
			AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		initExpandView();
	}

	private void initExpandView() {
		LayoutInflater.from(getContext()).inflate(
				R.layout.news_rey_select_jiesuan, this, true);
		this.mExpandAnimation = AnimationUtils.loadAnimation(getContext(),
				R.anim.expand);
		this.mExpandAnimation
				.setAnimationListener(new Animation.AnimationListener() {
					public void onAnimationEnd(Animation paramAnonymousAnimation) {
						ExpandView_jiesuan.this.setVisibility(0);
					}

					public void onAnimationRepeat(
							Animation paramAnonymousAnimation) {
					}

					public void onAnimationStart(
							Animation paramAnonymousAnimation) {
					}
				});
		this.mCollapseAnimation = AnimationUtils.loadAnimation(getContext(),
				R.anim.collapse);
		this.mCollapseAnimation
				.setAnimationListener(new Animation.AnimationListener() {
					public void onAnimationEnd(Animation paramAnonymousAnimation) {
						ExpandView_jiesuan.this.setVisibility(4);
					}

					public void onAnimationRepeat(
							Animation paramAnonymousAnimation) {
					}

					public void onAnimationStart(
							Animation paramAnonymousAnimation) {
					}
				});
		initView();
	}

	public void initView(){
		InnerOnclickListener i =new InnerOnclickListener();
		button1 =(Button) findViewById(R.id.buttonj__01);
		button2 =(Button) findViewById(R.id.buttonj__02);
		button3 =(Button) findViewById(R.id.buttonj__03);
		imageview1 = (ImageView) findViewById(R.id.imgj__01);
		imageview2 = (ImageView) findViewById(R.id.imgj__02);
		imageview3 = (ImageView) findViewById(R.id.imgj__03);
		button1.setOnClickListener(i);
		button2.setOnClickListener(i);
		button3.setOnClickListener(i);
	}
	public void hideImg(){
		imageview1.setVisibility(View.GONE);
		imageview2.setVisibility(View.GONE);
		imageview3.setVisibility(View.GONE);
	}
	private class InnerOnclickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.buttonj__01:{hideImg();
				imageview1.setVisibility(View.VISIBLE);
				collapse();
				break;
			}
			case R.id.buttonj__02:{hideImg();
				imageview2.setVisibility(View.VISIBLE);
				collapse();
				break;
			}
			case R.id.buttonj__03:{hideImg();
				imageview3.setVisibility(View.VISIBLE);
				collapse();
				break;
			}
			}
		}
	}
	
	public void collapse() {
		if (this.mIsExpand) {
			this.mIsExpand = false;
			clearAnimation();
			startAnimation(this.mCollapseAnimation);
		}
	}

	public void expand() {
		if (!this.mIsExpand) {
			this.mIsExpand = true;
			clearAnimation();
			startAnimation(this.mExpandAnimation);
		}
	}

	public boolean isExpand() {
		return this.mIsExpand;
	}

	public void setContentView() {
		View localView = LayoutInflater.from(getContext()).inflate(
				R.layout.news_rey_select_jiesuan, null);
		removeAllViews();
		addView(localView);
	}
}