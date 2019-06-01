package com.example.a11859.xchat;

import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.review.muyoo.ChatToView;

public class ChatActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener{
    private ConstraintLayout mChatRoot;
    private ConstraintSet mconset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //TODO 标题栏
        setContentView(R.layout.activity_chat);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.inflateMenu(R.menu.chat);
        toolbar.setTitle("测试标题");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        LinearLayout chat_linear = findViewById(R.id.chat_linear);
        ChatToView mctv = new ChatToView(getApplicationContext());
        mctv.Addimg(R.mipmap.to1);
        mctv.Addtext("测试文本");
        chat_linear.addView(mctv);


        mChatRoot = (ConstraintLayout) findViewById(R.id.chat_root);
        mconset = new ConstraintSet();
        mconset.clone(mChatRoot);
        mconset.setMargin(R.id.keyboard_text,4,1000);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int screenHeight = metrics.heightPixels;
        mChatRoot.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() { //当界面大小变化时，系统就会调用该方法
                        Rect r = new Rect(); //该对象代表一个矩形（rectangle）
                        mChatRoot.getWindowVisibleDisplayFrame(r); //将当前界面的尺寸传给Rect矩形
                        int deltaHeight = screenHeight - r.bottom;  //弹起键盘时的变化高度，在该场景下其实就是键盘高度。
                        if (deltaHeight > 150) {  //该值是随便写的，认为界面高度变化超过150px就视为键盘弹起。
                            //mChatRoot.setConstraintSet(mconset);
                        } else {

                        }
                    }
                });

    }

    @Override
    //TODO 标题栏Action item.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat,menu);
        return true;
    }

    @Override
    //TODO 标题栏按钮监听
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_user) {
            Toast.makeText(ChatActivity.this,"action_user",Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.action_search) {
            Toast.makeText(ChatActivity.this,"action_search",Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onGlobalLayout() {

    }
}
