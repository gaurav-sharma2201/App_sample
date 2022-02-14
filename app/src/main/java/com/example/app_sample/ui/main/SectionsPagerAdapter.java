package com.example.app_sample.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.app_sample.R;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    private final ArrayList<String> fragmentName=new ArrayList<>();


    public SectionsPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {


        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        fragmentName.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {


        return fragmentName.get(position);
    }
}