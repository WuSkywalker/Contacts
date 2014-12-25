package com.ytf.mis.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ytf.mis.contacts.R;

/**
 * Package: com.ytf.mis.contacts.main
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-19
 * Time: 21:04
 * Description:
 */
public class MyRightMessageFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_right_message_tab_main, null);
        return view;
    }
}
