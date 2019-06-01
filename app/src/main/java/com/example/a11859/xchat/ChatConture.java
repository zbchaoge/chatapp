package com.example.a11859.xchat;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;

//用于控制聊天界面
public class ChatConture {
    private ConstraintLayout mcon;
    private Context mcontext;
    public ChatConture(ConstraintLayout con, Context context){
        mcontext = context;
        mcon = con;
    }
    public void NewTextMessage() {
        TextView tv = new TextView(mcontext);
        tv.setId(R.id.id_add_file);
        tv.setText("HelloWorld");
        tv.setLeft(80);
        tv.setTop(80);
        tv.setWidth(200);
        tv.setHeight(200);
        mcon.addView(tv);
    }
}
