package com.ytf.mis.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.ytf.mis.contacts.*;
import com.ytf.mis.contacts.DetailActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Package: com.ytf.mis.contacts.main
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-19
 * Time: 21:56
 * Description:
 */
public class ContactsFragment extends Fragment{
    // 联系人列表
    private ListView mContacts;
    private AlphabetScrollBar mAlphabetScrollbar;
    private TextView mLetterNotice;
    private TextView mNoContacsNotice;
    private PinyinSortAdapter mPinyinSortAdapter;
    private ClearEditText mClearEditText;

    private List<PinyinSortUtils> mDatas = new ArrayList<PinyinSortUtils>();

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinSortComparatorUtils mComparator;

    ArrayList<UserTest> mUsers = new ArrayList<UserTest>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContactsDatas();
    }

    private void initContactsDatas() {
        UserTest user1 = new UserTest("李一", 0, "18080064615");
        mUsers.add(user1);
        mDatas.add(new PinyinSortUtils(user1.getName()));
        UserTest user2 = new UserTest("王二", 0, "18080064615");
        mUsers.add(user2);
        mDatas.add(new PinyinSortUtils(user2.getName()));
        UserTest user3 = new UserTest("张三", 0, "18080064615");
        mUsers.add(user3);
        mDatas.add(new PinyinSortUtils(user3.getName()));
        UserTest user4 = new UserTest("孙四", 0, "18080064615");
        mUsers.add(user4);
        mDatas.add(new PinyinSortUtils(user4.getName()));
        UserTest user5 = new UserTest("罗五", 0, "18080064615");
        mUsers.add(user5);
        mDatas.add(new PinyinSortUtils(user5.getName()));
        UserTest user6 = new UserTest("赵六", 0, "18080064615");
        mUsers.add(user6);
        mDatas.add(new PinyinSortUtils(user6.getName()));
        UserTest user7 = new UserTest("朱七", 0, "18080064615");
        mUsers.add(user7);
        mDatas.add(new PinyinSortUtils(user7.getName()));
        UserTest user8 = new UserTest("龙八", 0, "18080064615");
        mUsers.add(user8);
        mDatas.add(new PinyinSortUtils(user8.getName()));
        UserTest user9 = new UserTest("吴九", 0, "18080064615");
        mUsers.add(user9);
        mDatas.add(new PinyinSortUtils(user9.getName()));
        UserTest user10 = new UserTest("杨十", 0, "18080064615");
        mUsers.add(user10);
        mDatas.add(new PinyinSortUtils(user10.getName()));
        UserTest user11 = new UserTest("钱大", 0, "18080064615");
        mUsers.add(user11);
        mDatas.add(new PinyinSortUtils(user11.getName()));
        UserTest user12 = new UserTest("周十一", 0, "18080064615");
        mUsers.add(user12);
        mDatas.add(new PinyinSortUtils(user12.getName()));
        UserTest user13 = new UserTest("卫成功", 0, "18080064615");
        mUsers.add(user13);
        mDatas.add(new PinyinSortUtils(user13.getName()));
        UserTest user14 = new UserTest("将天", 0, "18080064615");
        mUsers.add(user14);
        mDatas.add(new PinyinSortUtils(user14.getName()));
        UserTest user15 = new UserTest("沈钱", 0, "18080064615");
        mUsers.add(user15);
        mDatas.add(new PinyinSortUtils(user15.getName()));
        UserTest user16 = new UserTest("姜太公", 0, "18080064615");
        mUsers.add(user16);
        mDatas.add(new PinyinSortUtils(user16.getName()));
        UserTest user17 = new UserTest("太白", 0, "18080064615");
        mUsers.add(user17);
        mDatas.add(new PinyinSortUtils(user17.getName()));
        UserTest user18 = new UserTest("曹操", 0, "18080064615");
        mUsers.add(user18);
        mDatas.add(new PinyinSortUtils(user18.getName()));
        UserTest user19 = new UserTest("曹植", 0, "18080064615");
        mUsers.add(user19);
        mDatas.add(new PinyinSortUtils(user19.getName()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.txl_contacts_list_tab_main, null);
        mClearEditText = (ClearEditText) convertView.findViewById(R.id.search_edit);
        //根据输入框输入值的改变来过滤搜索
        mClearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mContacts = (ListView) convertView.findViewById(R.id.contacts);
        View header = inflater.inflate(R.layout.txl_contacts_list_header, null);
        mContacts.addHeaderView(header);

        mAlphabetScrollbar = (AlphabetScrollBar) convertView.findViewById(R.id.alphabetscrollbar);
        mLetterNotice = (TextView) convertView.findViewById(R.id.letter_notice);
        mNoContacsNotice = (TextView) convertView.findViewById(R.id.no_contacts_notice);

        mAlphabetScrollbar.setTextView(mLetterNotice);
        mAlphabetScrollbar.setOnTouchBarListener(new AlphabetScrollBar.OnTouchBarListener() {
            @Override
            public void onTouch(String letter) {
                //该字母首次出现的位置
                if (letter == "#") {
                    mContacts.setSelectionFromTop(0, 0);
                } else {
                    int position = mPinyinSortAdapter.getPositionForSection(letter.charAt(0));
                    if (position != -1) {
                        mContacts.setSelection(position);
                    }
                }
            }
        });

        mContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });

        mComparator = new PinyinSortComparatorUtils();
        Collections.sort(mDatas, mComparator);
        mPinyinSortAdapter = new PinyinSortAdapter(getActivity(), mDatas);
        mContacts.setAdapter(mPinyinSortAdapter);
        return convertView;
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param input
     */
    private void filterData(String input) {
        List<PinyinSortUtils> filterData = new ArrayList<PinyinSortUtils>();

        if (TextUtils.isEmpty(input)) {
            filterData = mDatas;
        } else {
            filterData.clear();
            for (PinyinSortUtils data : mDatas) {
                String name = data.getName();
                if (name.indexOf(input.toString()) != -1 || PinyinUtils.getFirstpell(name).indexOf(input.toString().toLowerCase()) != -1) {
                    filterData.add(data);
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterData, mComparator);
        mPinyinSortAdapter.updateListView(filterData);
    }
}
