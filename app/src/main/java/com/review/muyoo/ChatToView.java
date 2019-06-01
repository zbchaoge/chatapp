package com.review.muyoo;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.example.a11859.xchat.R;

public class ChatToView extends ConstraintLayout {
    private CircleImageView mimg;
    private TextView mtext;
    public ChatToView(Context context, AttributeSet attr){
        super(context,attr);
        LayoutInflater.from(context).inflate(R.layout.chat_to,this);
        mimg = (CircleImageView) findViewById(R.id.chatto_img);
        mtext = (TextView) findViewById(R.id.chatto_text);
    }
    public ChatToView(Context context){
        this(context,null);
    }
    public void Addimg(int mingsour){
        mimg.setImageResource(mingsour);
    }
    public void Addtext(String mtextsour){
        mtext.setText(mtextsour);
    }
}
