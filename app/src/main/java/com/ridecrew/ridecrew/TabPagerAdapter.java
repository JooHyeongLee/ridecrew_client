package com.ridecrew.ridecrew;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ScheduleFragment schedule = new ScheduleFragment();
                return schedule;
            case 1:
                NoticeFragment notice = new NoticeFragment();
                return notice;
            case 2:
                ListFragment list = new ListFragment();
                return list;
            case 3:
                GalleryFragment gallery = new GalleryFragment();
                return gallery;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
