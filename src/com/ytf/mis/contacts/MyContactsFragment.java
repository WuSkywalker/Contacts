package com.ytf.mis.contacts;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Package: com.ytf.mis.contacts.main
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-19
 * Time: 21:04
 * Description:
 */
public class MyContactsFragment extends Fragment {
    /**
     * Field
     */
    public final static int num = 3;
    Resources resources;
    Fragment mRecentlyFragment;
    Fragment mContactsFragment;
    Fragment mOrganizationFragment;
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private ImageView mIndicator;
    private TextView mRecentlyTitle, mContactsTitle, mOrganizationTitle;
    private int currIndex = 0;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    private int position_two;

    /**
     * 
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.my_contacts_tab_main, null);
        resources = getResources();
        InitWidth(view);
        InitTextView(view);
        InitViewPager(view);
        TranslateAnimation animation = new TranslateAnimation(offset, position_one, 0, 0);
        mRecentlyTitle.setTextColor(resources.getColor(R.color.lightwhite));
        animation.setFillAfter(true);
        animation.setDuration(300);
        mIndicator.startAnimation(animation);
        return view;
    }

    private void InitTextView(View parentView) {
        mRecentlyTitle = (TextView) parentView.findViewById(R.id.txl_recently_tab_title);
        mContactsTitle = (TextView) parentView.findViewById(R.id.txl_contacts_tab_title);
        mOrganizationTitle = (TextView) parentView.findViewById(R.id.txl_organization_tab_title);

        mRecentlyTitle.setOnClickListener(new MyOnClickListener(0));
        mContactsTitle.setOnClickListener(new MyOnClickListener(1));
        mOrganizationTitle.setOnClickListener(new MyOnClickListener(2));
    }

    private void InitViewPager(View parentView) {
        mPager = (ViewPager) parentView.findViewById(R.id.contactsPager);
        fragmentsList = new ArrayList<Fragment>();

        mRecentlyFragment = new RecentFragment();
        mContactsFragment = new ContactsFragment();
        mOrganizationFragment = new OrganizationFragment();

        fragmentsList.add(mRecentlyFragment);
        fragmentsList.add(mContactsFragment);
        fragmentsList.add(mOrganizationFragment);

        mPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentsList));
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
        mPager.setCurrentItem(1);

    }

    private void InitWidth(View parentView) {
        mIndicator = (ImageView) parentView.findViewById(R.id.iv_bottom_line);
        bottomLineWidth = mIndicator.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = ((screenW / num - bottomLineWidth) / 2);
        int avg = (screenW / num);
        position_one = avg + offset;
        position_two = 2 * avg + offset;

    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, offset, 0, 0);
                        mContactsTitle.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 2){
                        animation = new TranslateAnimation(position_two, offset, 0, 0);
                        mOrganizationTitle.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    mRecentlyTitle.setTextColor(resources.getColor(R.color.red));
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_one, 0, 0);
                        mRecentlyTitle.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, position_one, 0, 0);
                        mOrganizationTitle.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    mContactsTitle.setTextColor(resources.getColor(R.color.red));
                    break;
                case 2:
                    if (currIndex == 0){
                        animation = new TranslateAnimation(offset, position_two, 0, 0);
                        mRecentlyTitle.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, position_two, 0, 0);
                        mContactsTitle.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    mOrganizationTitle.setTextColor(resources.getColor(R.color.red));
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(300);
            mIndicator.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

}
