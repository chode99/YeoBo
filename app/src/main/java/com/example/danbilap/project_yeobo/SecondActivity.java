package com.example.danbilap.project_yeobo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    String t_title, t_nation_en;
    int t_num, n_id;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();

    }

    void init(){

        title = (TextView)findViewById(R.id.title);

        Bundle bundle = getIntent().getExtras();

        t_title  = bundle.getString("t_title");
        title.setText(t_title);

        t_nation_en = bundle.getString("t_nation_en");
        t_num = bundle.getInt("t_num");
        n_id = bundle.getInt("n_id");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new TestFragment1());
        fragmentArrayList.add(TestFragment2.newInstance(n_id));
        fragmentArrayList.add(new TestFragment3());

        TestViewPagerAdapter adapter = new TestViewPagerAdapter(getSupportFragmentManager(), fragmentArrayList);
        pager.setAdapter(adapter);

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);




    }

    @Override
    public void onBackPressed() { // 뒤로 가기 했을 때 MainActivity로 돌아가도록
        super.onBackPressed();
        SecondActivity.this.finish();
    }
}