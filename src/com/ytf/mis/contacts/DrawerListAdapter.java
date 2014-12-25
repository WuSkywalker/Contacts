package com.ytf.mis.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Package: com.ytf.mis.contacts.detail
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-15
 * Time: 0:10
 * Description:
 */
public class DrawerListAdapter extends BaseAdapter{
    /**
     * Field
     */
    private LayoutInflater mInflater;
    private List<DrawerListItem> mItems;

    public DrawerListAdapter(Context context, List<DrawerListItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mItems = data;
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return mItems.size();
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public DrawerListItem getItem(int position) {
        return mItems.get(position);
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerListItem item = getItem(position);
        TextView itemTitle = null;
        ImageView itemIcon = null;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.txl_detail_drawer_list_item, null);
        }
        itemTitle = (TextView) convertView.findViewById(R.id.item_title);
        itemIcon = (ImageView) convertView.findViewById(R.id.item_icon);
        itemTitle.setText(item.getTitle());
        itemIcon.setBackground(item.getIcon());
        return convertView;
    }
}
