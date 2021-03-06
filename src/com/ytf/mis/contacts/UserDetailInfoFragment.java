package com.ytf.mis.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Package: com.ytf.mis.contacts.detail
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-16
 * Time: 11:29
 * Description:
 */
public class UserDetailInfoFragment extends Fragment {
    public static final String TAG = "UserDetailInfoFragment";

    private static final String ARG_SELECTION_TITLE = "selection_title";
    private static UserDetailInfoFragment fragment = null;

    /**
     *
     */
    public UserDetailInfoFragment() {

    }

    /**
     *
     * @param title
     * @param info
     * @return
     */
    public static UserDetailInfoFragment newInstance(String title, UserDetailInfo info) {
        if (fragment == null) {
            fragment = new UserDetailInfoFragment();
        }
        Bundle args = new Bundle();
        args.putString(ARG_SELECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.txl_user_detail_fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getArguments().getString(ARG_SELECTION_TITLE));
        return rootView;
    }
}
