package ch.chtool.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ch.chtool.R;
import ch.chtool.utils.DisplayUtils;

/**
 * Created by CH
 * on 2020/5/7 09:38
 */
public class CTextView extends RelativeLayout {
    private TextView textView_label;
    private TextView textView_value;

    public CTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CTextView);
        float paddingLeft = typedArray.getDimension(R.styleable.CTextView_paddingLeft, (float) DisplayUtils.dp2px(context, 16.0F));
        float paddingTop = typedArray.getDimension(R.styleable.CTextView_paddingTop, (float) DisplayUtils.dp2px(context, 0.0F));
        float paddingRight = typedArray.getDimension(R.styleable.CTextView_paddingRight, (float) DisplayUtils.dp2px(context, 16.0F));
        float paddingBottom = typedArray.getDimension(R.styleable.CTextView_paddingBottom, (float) DisplayUtils.dp2px(context, 0.0F));
        boolean segmentation = typedArray.getBoolean(R.styleable.CTextView_segmentation, true);
        Drawable imageLeft = typedArray.getDrawable(R.styleable.CTextView_CTV_imageLeft);
        float imageLeftWidth = typedArray.getDimension(R.styleable.CTextView_CTV_imageLeftWidth, (float) DisplayUtils.dp2px(context, 30.0F));
        float imageLeftHeight = typedArray.getDimension(R.styleable.CTextView_CTV_imageLeftHeight, (float) DisplayUtils.dp2px(context, 30.0F));
        float imageLeftMargin = typedArray.getDimension(R.styleable.CTextView_CTV_imageLeftMargin, (float) DisplayUtils.dp2px(context, 10.0F));
        String lable = typedArray.getString(R.styleable.CTextView_CTV_label);
        float labelSize = typedArray.getDimension(R.styleable.CTextView_CTV_labelSize, (float) DisplayUtils.sp2px(context, 14.0F));
        int labelColor = typedArray.getColor(R.styleable.CTextView_CTV_labelColor, this.getResources().getColor(R.color.bg_black));
        float labelWidth = typedArray.getDimension(R.styleable.CTextView_CTV_labelWidth, -2.0F);
        String value = typedArray.getString(R.styleable.CTextView_CTV_value);
        float valueSize = typedArray.getDimension(R.styleable.CTextView_CTV_valueSize, (float) DisplayUtils.sp2px(context, 14.0F));
        int valueColor = typedArray.getColor(R.styleable.CTextView_CTV_valueColor, this.getResources().getColor(R.color.bg_black));
        Drawable imageRight = typedArray.getDrawable(R.styleable.CTextView_CTV_imageRight);
        float imageRightWidth = typedArray.getDimension(R.styleable.CTextView_CTV_imageRightWidth, (float) DisplayUtils.dp2px(context, 20.0F));
        float imageRightHeight = typedArray.getDimension(R.styleable.CTextView_CTV_imageRightHeight, (float) DisplayUtils.dp2px(context, 20.0F));
        float imageRightMargin = typedArray.getDimension(R.styleable.CTextView_CTV_imageRightMargin, (float) DisplayUtils.dp2px(context, 10.0F));
        LayoutInflater.from(context).inflate(R.layout.view_textshow, this);
        LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.linearLayout);
        ImageView imageView_left = (ImageView) this.findViewById(R.id.imageView_left);
        this.textView_label = (TextView) this.findViewById(R.id.textView_label);
        this.textView_value = (TextView) this.findViewById(R.id.textView_value);
        ImageView imageView_right = (ImageView) this.findViewById(R.id.imageView_right);
        View view = this.findViewById(R.id.view);
        linearLayout.setPadding((int) paddingLeft, (int) paddingTop, (int) paddingRight, (int) paddingBottom);
        LayoutParams imageLeftParams = (LayoutParams) imageView_left.getLayoutParams();
        imageLeftParams.leftMargin = 0;
        imageLeftParams.topMargin = 0;
        imageLeftParams.rightMargin = (int) imageLeftMargin;
        imageLeftParams.bottomMargin = 0;
        imageLeftParams.width = (int) imageLeftWidth;
        imageLeftParams.height = (int) imageLeftHeight;
        imageView_left.setLayoutParams(imageLeftParams);
        LayoutParams labelParams = (LayoutParams) this.textView_label.getLayoutParams();
        labelParams.height = -1;
        labelParams.width = (int) labelWidth;
        this.textView_label.setLayoutParams(labelParams);
        LayoutParams valueParams = (LayoutParams) this.textView_value.getLayoutParams();
        valueParams.height = -1;
        valueParams.width = -1;
        this.textView_value.setLayoutParams(valueParams);
        LayoutParams imageRightParams = (LayoutParams) imageView_right.getLayoutParams();
        imageRightParams.leftMargin = (int) imageRightMargin;
        imageRightParams.topMargin = 0;
        imageRightParams.rightMargin = 0;
        imageRightParams.bottomMargin = 0;
        imageRightParams.width = (int) imageRightWidth;
        imageRightParams.height = (int) imageRightHeight;
        imageView_right.setLayoutParams(imageRightParams);
        if (imageLeft != null) {
            imageView_left.setVisibility(0);
            imageView_left.setImageDrawable(imageLeft);
        } else {
            imageView_left.setVisibility(8);
        }

        if (lable != null) {
            this.textView_label.setVisibility(0);
            this.textView_label.setText(lable);
            this.textView_label.setTextSize((float) DisplayUtils.px2sp(context, labelSize));
            this.textView_label.setTextColor(labelColor);
        } else {
            this.textView_label.setVisibility(8);
        }

        if (value != null) {
            this.textView_value.setVisibility(0);
            this.textView_value.setText(value);
            this.textView_value.setTextSize((float) DisplayUtils.px2sp(context, valueSize));
            this.textView_value.setTextColor(valueColor);
        } else {
            this.textView_value.setVisibility(4);
        }

        if (imageRight != null) {
            imageView_right.setVisibility(0);
            imageView_right.setImageDrawable(imageRight);
        } else {
            imageView_right.setVisibility(8);
        }

        if (segmentation) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }

    }

    public String getLabel() {
        return this.textView_label.getText().toString();
    }

    public void setLabel(String label) {
        this.textView_label.setText(label);
    }

    public String getValue() {
        return this.textView_value.getText().toString();
    }

    public void setValue(String value) {
        this.textView_value.setText(value);
    }
}
