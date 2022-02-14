package com.example.app_sample;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_sample.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.view_pager);


        tabLayout.setupWithViewPager(viewPager);

        SectionsPagerAdapter vpadapter=new SectionsPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpadapter.addFragment(new Fragment1(),"Certificate");
        vpadapter.addFragment(new Fragment2(),"Profile");
        vpadapter.addFragment(new Fragment3(),"Chat");
        vpadapter.addFragment(new Fragment4(),"Score");

        viewPager.setAdapter(vpadapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPager.setCurrentItem(1);
    }
}