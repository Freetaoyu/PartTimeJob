package com.clv.parttimejobs.view.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class CircleWaveView extends View {
    private float mWidth;
    private float mHeight;

    private float centerX; // Բ��X
    private float centerY; // Բ��Y
    private float floatRadius; // �仯�İ뾶
    private float maxRadius = -1; // Բ�뾶
    private volatile boolean started = false;
    private Paint mLinePaint;
    private Paint mSolidPaint;
    private int waveColor =  Color.LTGRAY;// Color.argb(0, 0, 0, 0); //��ɫColor.LTGRAY;
    private int waveInterval = 90; // Բ���Ŀ��
    private boolean centerAlign = true;// ����
    private float bottomMargin = 0;// �ײ�margin
    private boolean fillCircle = true;// �Ƿ�����ʵ��Բ��

    public CircleWaveView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleWaveView(Context context) {
        this(context, null, 0);
    }

    public CircleWaveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        mLinePaint = new Paint();
        mSolidPaint = new Paint();
    }

    private void init() {
        mWidth = getWidth();
        mHeight = getHeight();

        mLinePaint.setAntiAlias(true);
        mLinePaint.setStrokeWidth(1.0F);
        mLinePaint.setStyle(Paint.Style.FILL);//
        mLinePaint.setColor(waveColor);

        if (fillCircle) {
            mSolidPaint.setStyle(Paint.Style.FILL);//
            mSolidPaint.setStrokeWidth(waveInterval);
            // ���ñ���ɫ����ɫ
            mSolidPaint.setColor(Color.WHITE);
        }

        centerX = mWidth / 2.0F;
        if (centerAlign) {
            centerY = (mHeight / 2.0F);

        } else {
            centerY = mHeight - bottomMargin;
        }

        if (mWidth >= mHeight) {
            maxRadius = mHeight / 2.0F;
        } else {
            maxRadius = mWidth / 2.0F;
        }

        floatRadius = (maxRadius % waveInterval);

        start();
    }

    public void start() {
        if (!started) {
            started = true;
            new Thread(thread).start();
        }
    }

    public void stop() {
        // Thread.interrupted();
        started = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        stop();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (maxRadius <= 0.0F) {
            return;
        }
        float radius = floatRadius % waveInterval;
        while (true) {
            int alpha = (int) (255.0F * (1.0F - radius / maxRadius));
            if (alpha <= 0) {
                break;
            }
            // ���ñ���ɫ

            if (fillCircle) {
                mSolidPaint.setAlpha(alpha >> 2);
                canvas.drawCircle(centerX, centerY, radius - waveInterval / 2,
                        mSolidPaint);
            }
            mLinePaint.setAlpha(alpha);
            canvas.drawCircle(centerX, centerY, radius, mLinePaint);
            radius += waveInterval;
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            init();
        } else {
            stop();
        }
    }
    
//�����涨��һ��������started����Ϊtrue�Ϳ�����ͣ��
    private Runnable thread = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (started) {
                floatRadius = 4.0F + floatRadius;
                if (floatRadius > maxRadius) {
                    floatRadius = (maxRadius % waveInterval);
                    postInvalidate();
                }
                postInvalidate();
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException localInterruptedException) {
                    localInterruptedException.printStackTrace();
                }
            }
        }
    };

    public void setMaxRadius(float maxRadius) {
        this.maxRadius = maxRadius;
    }

    public void setWaveColor(int waveColor) {
        this.waveColor = waveColor;
    }

    public void setWaveInterval(int waveInterval) {
        this.waveInterval = waveInterval;
    }

    public void setCenterAlign(boolean centerAlign) {
        this.centerAlign = centerAlign;
    }

}
