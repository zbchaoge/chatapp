package com.example.a11859.xchat;
//xchat android聊天app
// By:muyoo
// Time:2019/4/30
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.support.design.widget.BottomNavigationView;
import android.widget.Toast;

import com.review.muyoo.mySimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO 首页Activity
public class MainActivity extends AppCompatActivity
        implements  AdapterView.OnItemClickListener,NavigationView.OnNavigationItemSelectedListener  {
    //聊天消息界面示例内容
    private String[] names = new String[]{"示例文本", "示例文本", "示例文本","示例文本", "示例文本", "示例文本","示例文本", "示例文本", "示例文本","示例文本", "示例文本", "示例文本"};
    private String[] says = new String[]{"示例内容文本", "示例内容文本", "示例内容文本","示例内容文本", "示例内容文本", "示例内容文本","示例内容文本", "示例内容文本", "示例内容文本","示例内容文本", "示例内容文本", "示例内容文本"};
    private String[] chatTime = new String[]{"下午9:22","下午5:26","下午3:10","下午1:40","上午10:32","昨天","昨天","昨天","昨天","昨天","昨天","昨天"};
    private int[] imgIds = new int[]{R.mipmap.to1, R.mipmap.to2, R.mipmap.to3,R.mipmap.to4, R.mipmap.to5, R.mipmap.to6,R.mipmap.to1, R.mipmap.to2, R.mipmap.to3,R.mipmap.to4, R.mipmap.to5, R.mipmap.to6};
    //联系人界面实例内容
    private String[] ct_name = new String[]{"好友分组示例","好友分组示例","好友分组示例"};
    private String[][] ct_name_in = new String[][]{{"好友1","好友2","好友3","好友4"},{"好友1","好友2","好友3","好友4"},{"好友1","好友2","好友3","好友4"}};
    private int[][] ct_name_in_img = new int[][]{{R.mipmap.to1,R.mipmap.to2,R.mipmap.to3,R.mipmap.to1},{R.mipmap.to4,R.mipmap.to5,R.mipmap.to6,R.mipmap.to1},{R.mipmap.to1,R.mipmap.to2,R.mipmap.to3,R.mipmap.to4}};
    public static final String EXTRA_MESSAGE = "com.example.a11859.TOCHAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/      //TODO 侧面抽屉布局
        DrawerLayout drawer =(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //TODO 消息界面ListView

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name", names[i]);
            showitem.put("says", says[i]);
            showitem.put("chatTime",chatTime[i]);
            listitem.add(showitem);
        }
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.list_item, new String[]{"touxiang", "name", "says","chatTime"}, new int[]{R.id.imgtou, R.id.name, R.id.says,R.id.chat_time});
        ListView listView =  (ListView) findViewById(R.id.list_test);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);

        //TODO 底部导航栏 BottomNavigationView


        final BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.nav1);
        bnv.getMenu().getItem(0).setChecked(true);
        bnv.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    View include1 = findViewById(R.id.include);
                    View include2 = findViewById(R.id.include2);
                    View include3 = findViewById(R.id.include3);
                    int se_order;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                se_order = bnv.getSelectedItemId();
                switch (item.getItemId()) {
                    case R.id.nav_bu_1:
                        //2131230838
                        if(se_order==2131230838){
                            Toast ts = Toast.makeText(getBaseContext(),"已选中", Toast.LENGTH_LONG);
                            ts.show();
                            break;
                        }
                        include2.setVisibility(View.VISIBLE);
                        include3.setVisibility(View.GONE);
                        break;
                    case R.id.nav_bu_2:
                        if(se_order==2131230839){
                            Toast ts = Toast.makeText(getBaseContext(),"已选中", Toast.LENGTH_LONG);
                            ts.show();
                            break;
                        }
                        include2.setVisibility(View.GONE);
                        include3.setVisibility(View.VISIBLE);
                        break;
                    case R.id.nav_bu_3:
                        //2131230840
                        /*
                        Toast ts2 = Toast.makeText(getBaseContext(),""+order, Toast.LENGTH_LONG);
                        ts2.show();
                        */
                        break;
                }
                return true;
            }
        });

        //TODO 联系人界面多级菜单 ExpandableList
        Log.d("MainActivity","run Start!");
        mySimpleExpandableListAdapter myExpandAdapter = new mySimpleExpandableListAdapter(getApplicationContext(),ct_name,ct_name_in,ct_name_in_img,R.layout.contect_father,R.layout.contect_child,R.id.ct_textview,new int[]{R.id.ct_textView2,R.id.imgtou_ct});
        ExpandableListView contect_ExList = findViewById(R.id.ct_dynamic);

        contect_ExList.setAdapter(myExpandAdapter);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent ToChatIntent = new Intent(this,ChatActivity.class);
        //通过view获取其内部的组件，进而进行操作
        //String text = (String) ((TextView)view.findViewById(R.id.name)).getText();
        //大多数情况下，position和id相同，并且都从0开始
        ToChatIntent.putExtra(EXTRA_MESSAGE,id);
        startActivity(ToChatIntent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this,"action_user",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
