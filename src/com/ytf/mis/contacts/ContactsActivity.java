package com.ytf.mis.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.ytf.mis.contacts.main
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-19
 * Time: 20:40
 * Description:
 */
public class ContactsActivity extends FragmentActivity{

    public static final String TAG = "MainActivity";

    /**
     * Field
     */
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();


    private LinearLayout mTabDesktop;
    private LinearLayout mTabRightMessages;
    private LinearLayout mTabContacts;
    private LinearLayout mTabSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_main);

        initView();


        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };

        mViewPager.setAdapter(mAdapter);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int currentIndex;

            @Override
            public void onPageSelected(int position) {
                resetTabImage();
                switch (position) {
                    case 0:
                        ((ImageButton) mTabDesktop.findViewById(R.id.my_desktop_tab_bottom_btn))
                                .setImageResource(R.drawable.txl_my_desktop);
                        break;
                    case 1:
                        ((ImageButton) mTabRightMessages.findViewById(R.id.my_right_message_tab_bottom_btn))
                                .setImageResource(R.drawable.txl_right_message);
                        break;
                    case 2:
                        ((ImageButton) mTabContacts.findViewById(R.id.my_contacts_tab_bottom_btn))
                                .setImageResource(R.drawable.txl_my_contacts);
                        break;
                    case 3:
                        ((ImageButton) mTabSettings.findViewById(R.id.my_system_setting_tab_bottom_btn))
                                .setImageResource(R.drawable.txl_system_setting);
                        break;
                }

                currentIndex = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    private void initView() {
        mTabDesktop = (LinearLayout) findViewById(R.id.my_desktop_tab_bottom);
        mTabDesktop.setOnClickListener(new BottomOnClickListener(0));
        mTabRightMessages = (LinearLayout) findViewById(R.id.my_right_message_tab_bottom);
        mTabRightMessages.setOnClickListener(new BottomOnClickListener(1));
        mTabContacts = (LinearLayout) findViewById(R.id.my_contacts_tab_bottom);
        mTabContacts.setOnClickListener(new BottomOnClickListener(2));
        mTabSettings = (LinearLayout) findViewById(R.id.my_system_setting_tab_bottom);
        mTabSettings.setOnClickListener(new BottomOnClickListener(3));

        MyDeskTopFragment tab01 = new MyDeskTopFragment();
        MyRightMessageFragment tab02 = new MyRightMessageFragment();
        MyContactsFragment tab03 = new MyContactsFragment();
        MySystemSettingFragment tab04 = new MySystemSettingFragment();
        mFragments.add(tab01);
        mFragments.add(tab02);
        mFragments.add(tab03);
        mFragments.add(tab04);
    }

    private void resetTabImage() {

        ((ImageButton) mTabDesktop.findViewById(R.id.my_desktop_tab_bottom_btn))
                .setImageResource(R.drawable.txl_my_desktop);
        ((ImageButton) mTabRightMessages.findViewById(R.id.my_right_message_tab_bottom_btn))
                .setImageResource(R.drawable.txl_right_message);
        ((ImageButton) mTabContacts.findViewById(R.id.my_contacts_tab_bottom_btn))
                .setImageResource(R.drawable.txl_my_contacts);
        ((ImageButton) mTabSettings.findViewById(R.id.my_system_setting_tab_bottom_btn))
                .setImageResource(R.drawable.txl_system_setting);
    }

    public class BottomOnClickListener implements View.OnClickListener{
        private int index = 0;

        public BottomOnClickListener(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            mViewPager.setCurrentItem(index, true);
        }
    }
}
