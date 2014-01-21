package com.example.password;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * [*] [*] [*] [*] [*] [*]
 * 密码输入框(默认六位)
 *
 * Created by jerry on 14-1-20.
 */
public class PasswordEditText extends EditText{

    private float mSpacingWidth = 20.00f;
    private int mMaxCharact;
    private Bitmap mPwdImg;
    private Paint mPaint = new Paint();

    public PasswordEditText(Context context) {
        this(context, null);
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(Color.TRANSPARENT);
        setMaxCharacter(6);
        setSingleLine(true);
        setCursorVisible(false);
        setLongClickable(false);
        setInputType(InputType.TYPE_CLASS_NUMBER);
        mPwdImg = BitmapFactory.decodeResource(context.getResources(), R.drawable.ui_pw_is_set);
    }

    public void setSpacingWidth(float mSpacingLen) {
        this.mSpacingWidth = mSpacingLen;
    }

    public void setMaxCharacter(int maxCharacter) {
        this.mMaxCharact = maxCharacter;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxCharacter)});
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float disWidth  = getWidth();
        float disHeight = getHeight();
        int spacingCount = mMaxCharact -1;
        float pwdWidth = (disWidth - mSpacingWidth * spacingCount) / 6;
        int textLen = getText().toString().trim().length();
        float cacheWidth = 0;

        for (int i = 0; i < mMaxCharact; i++) {
            RectF rectRim = new RectF(cacheWidth,0,cacheWidth + pwdWidth,disHeight);
            mPaint.setColor(Color.GRAY);
            canvas.drawRoundRect(rectRim,0,0, mPaint);
            RectF rectContent = new RectF(cacheWidth + 2,2,cacheWidth + pwdWidth - 2 ,disHeight - 2);
            mPaint.setColor(Color.WHITE);
            canvas.drawRoundRect(rectContent,0,0, mPaint);

            if (i < textLen){
                mPaint.reset();
                canvas.drawBitmap(mPwdImg,pwdWidth/2 - mPwdImg.getWidth()/2 + cacheWidth,
                        disHeight/2 - mPwdImg.getHeight()/2, mPaint);
            }

            cacheWidth += (pwdWidth + mSpacingWidth);
        }
    }
}
