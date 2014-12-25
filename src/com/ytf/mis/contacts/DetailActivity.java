package com.ytf.mis.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Package: com.ytf.mis.contacts.detail
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-14
 * Time: 22:02
 * Description:
 */
public class DetailActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    public static final String TAG = "DetailActivity";
    /**
     * Field
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private Fragment mCurrentFragment;
    private Fragment mLastFragment;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.txl_detail_activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    /**
     * @param title
     */
    @Override
    public void onNavigationDrawerItemSelected(String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        mCurrentFragment = fragmentManager.findFragmentByTag(title);

        String[] itemTitle = getResources().getStringArray(R.array.item_title);
        if (mCurrentFragment == null) {
            if (title.equals(itemTitle[0])) {
                UserBasicInfo info = new UserBasicInfo();
                mCurrentFragment = UserBasicInfoFragment.newInstance(title, info);
            } else if (title.equals(itemTitle[1])) {
                UserContactsInfo info = new UserContactsInfo();
                mCurrentFragment = UserContactsFragment.newInstance(title, info);
            } else if (title.equals(itemTitle[2])) {
                UserDetailInfo info = new UserDetailInfo();
                mCurrentFragment = UserDetailInfoFragment.newInstance(title, info);
            } else {
                StaffInfo info = new StaffInfo();
                mCurrentFragment = UserInfoFragment.newInstance(title, info);
            }

            fragmentTransaction.add(R.id.container, mCurrentFragment, title);
        }

        if (mLastFragment != null) {
            fragmentTransaction.hide(mLastFragment);
        }

        if (mCurrentFragment.isDetached()) {
            fragmentTransaction.attach(mCurrentFragment);
        }

        fragmentTransaction.show(mCurrentFragment);
        mLastFragment = mCurrentFragment;
        fragmentTransaction.commit();
        onSectionAttached(title);
    }

    /**
     * @param title
     */
    private void onSectionAttached(String title) {
        mTitle = title;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.menu, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * update the action bar title
     */
    private void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
