package com.ytf.mis.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Package: com.ytf.mis.contacts.main
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-19
 * Time: 21:57
 * Description:
 */
public class OrganizationFragment extends Fragment{

    // 组织架构
    private ListView mOrganizations;
    private ArrayList<TreeElement> mElements = new ArrayList<TreeElement>();
    private TreeViewAdapter mTreeViewAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOrganizationDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.txl_organization_tab_main, null);
        mOrganizations = (ListView) convertView.findViewById(R.id.organizations);
        mTreeViewAdapter = new TreeViewAdapter(getActivity(), R.layout.txl_contacts_list_item, mElements);
        mOrganizations.setAdapter(mTreeViewAdapter);
        registerForContextMenu(mOrganizations);
        mOrganizations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (!mElements.get(position).isHasChild()) {
                    Toast.makeText(getActivity(), mElements.get(position)
                            .getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), DetailActivity.class);
                    startActivity(intent);
                }

                if (mElements.get(position).isExpanded()) {
                    mElements.get(position).setExpanded(false);
                    TreeElement element = mElements.get(position);
                    ArrayList<TreeElement> temp = new ArrayList<TreeElement>();

                    for (int i = position + 1; i < mElements.size(); i++) {
                        if (element.getLevel() >= mElements.get(i).getLevel()) {
                            break;
                        }
                        temp.add(mElements.get(i));
                    }

                    mElements.removeAll(temp);

                    mTreeViewAdapter.notifyDataSetChanged();

                } else {
                    TreeElement obj = mElements.get(position);
                    obj.setExpanded(true);
                    int level = obj.getLevel();
                    int nextLevel = level + 1;

                    for (TreeElement element : obj.getChildren()) {
                        element.setLevel(nextLevel);
                        element.setExpanded(false);
                        mElements.add(position + 1, element);

                    }
                    mTreeViewAdapter.notifyDataSetChanged();
                }

            }
        });

        return convertView;
    }

    /**
     * init the data of Organizations and staffs
     */
    private void initOrganizationDatas() {
        TreeElement element1 = new TreeElement("01", "总经理");
        TreeElement element2 = new TreeElement("02", "副总经理");
        TreeElement element3 = new TreeElement("03", "王二");
        TreeElement element4 = new TreeElement("04", "崔三");
        TreeElement element5 = new TreeElement("05", "王五");
        TreeElement element6 = new TreeElement("06", "麻四");
        TreeElement element7 = new TreeElement("07", "副总经理");
        TreeElement element8 = new TreeElement("08", "李一");
        TreeElement element9 = new TreeElement("09", "IT中心");
        TreeElement element10 = new TreeElement("10", "技术四部");
        TreeElement element11 = new TreeElement("11", "技术五部");
        TreeElement element12 = new TreeElement("12", "王二");
        TreeElement element13 = new TreeElement("13", "王二");
        TreeElement element14 = new TreeElement("14", "王二");
        TreeElement element15 = new TreeElement("15", "王二");
        TreeElement element16 = new TreeElement("16", "王二");
        TreeElement element17 = new TreeElement("17", "王二");
        TreeElement element18 = new TreeElement("18", "王二");
        TreeElement element19 = new TreeElement("19", "王二");
        TreeElement element20 = new TreeElement("20", "财务部");
        TreeElement element201 = new TreeElement("201", "主任");
        TreeElement element202 = new TreeElement("202", "副主任");
        TreeElement element203 = new TreeElement("203", "员工");
        TreeElement element21 = new TreeElement("21", "商务部");
        TreeElement element211 = new TreeElement("211", "主任");
        TreeElement element212 = new TreeElement("212", "副主任");
        TreeElement element213 = new TreeElement("213", "员工");
        TreeElement element22 = new TreeElement("22", "软件中心");
        TreeElement element221 = new TreeElement("221", "软件研发部");

        mElements.add(element1);
        mElements.add(element2);
        mElements.add(element9);
        mElements.add(element20);
        mElements.add(element21);
        mElements.add(element22);
        element2.addChild(element3);
        element1.addChild(element4);
        element1.addChild(element5);
        element1.addChild(element6);
        element1.addChild(element7);
        element7.addChild(element8);
        element9.addChild(element10);
        element9.addChild(element11);
        element11.addChild(element12);
        element11.addChild(element13);
        element10.addChild(element14);
        element10.addChild(element15);
        element10.addChild(element16);
        element10.addChild(element17);
        element10.addChild(element18);
        element10.addChild(element19);
        element20.addChild(element201);
        element20.addChild(element202);
        element20.addChild(element203);
        element21.addChild(element211);
        element21.addChild(element212);
        element21.addChild(element213);
        element22.addChild(element221);

    }
}
