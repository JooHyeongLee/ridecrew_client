package com.ridecrew.ridecrew;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    boolean login = false;

    //옵션메뉴
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        Log.d("test","onCreateOptionsMenu");
        return true;
    }

    //option menu setVisible
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("test", "onPrepareOptionsMenu - 옵션메뉴가 " +
                "화면에 보여질때 마다 호출됨");
        if(login){ // 로그인 한 상태: 로그인은 안보이게, 로그아웃은 보이게
            menu.getItem(0).setVisible(true);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(true);
        }else{ // 로그 아웃 한 상태 : 로그인 보이게, 로그아웃은 안보이게
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(true);
            menu.getItem(2).setVisible(false);
        }
        login = !login;   // 값을 반대로 바꿈
        return super.onPrepareOptionsMenu(menu);
    }
    //option menu event (login, logout, enlist)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_login:
                Intent login = new Intent(this,LoginDialogActivity.class);
                startActivity(login);
                return true;
            case R.id.menu_logout:
                Toast.makeText(this,"logout",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_enlist:
                Intent enlist = new Intent(this,EnlistDialogActivity.class);
                startActivity(enlist);
                Toast.makeText(this,"enlist",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //fregment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("일정"));
        tabLayout.addTab(tabLayout.newTab().setText("공지"));
        tabLayout.addTab(tabLayout.newTab().setText("내역"));
        tabLayout.addTab(tabLayout.newTab().setText("갤러리"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
