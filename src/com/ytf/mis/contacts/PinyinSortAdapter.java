package com.ytf.mis.contacts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.List;

/**
 * Package: com.ytf.mis.contacts.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-17
 * Time: 20:11
 * Description:
 */
public class PinyinSortAdapter extends BaseAdapter implements SectionIndexer{
    public static final String TAG = "PinyinSortAdapter";

    /**
     * Field
     */
    private LayoutInflater mInflater;
    private List<PinyinSortUtils> mData = null;
    private Context mContext;
    private Bitmap mManIcon;
    private Bitmap mFemaleIcon;

    /**
     *
     * @param context
     * @param data
     */
    public PinyinSortAdapter(Context context, List<PinyinSortUtils> data){
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mData = data;
        this.mManIcon = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.txl_man_icon);
        this.mFemaleIcon = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.txl_female_icon);
    }
    /**
     * if data changed, call this method
     * @param data
     */
    public void updateListView(List<PinyinSortUtils> data){
        this.mData = data;
        notifyDataSetChanged();
    }
    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return this.mData.size();
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return this.mData.get(position);
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
        ViewHolder holder = null;
        final PinyinSortUtils tmp = mData.get(position);
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.txl_contacts_list_item, null);
            holder.letter = (TextView) convertView.findViewById(R.id.letter);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageBitmap(mFemaleIcon);
        holder.title.setText(tmp.getName());
        //holder.phone.setText("18080064615");
        //根据position获取分类的首字母的Char值
        int section = getSectionForPosition(position);

        //如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if(position == getPositionForSection(section)){
            holder.letter.setVisibility(View.VISIBLE);
            holder.letter.setText(tmp.getSortLetters());
        } else{
            holder.letter.setVisibility(View.GONE);
        }

        return convertView;
    }

    /**
     *
     * @return
     */
    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    /**
     * 根据分类的首字母的Char值获取其第一次出现该首字母的位置
     * @param sectionIndex
     * @return
     */
    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = mData.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == sectionIndex) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 提取英文的首字母，非英文字母用#代替。
     *
     * @param str
     * @return
     */
    private String getAlpha(String str) {
        String  sortStr = str.trim().substring(0, 1).toUpperCase();
        // 正则表达式，判断首字母是否是英文字母
        if (sortStr.matches("[A-Z]")) {
            return sortStr;
        } else {
            return "#";
        }
    }

    /**
     * 根据ListView的当前位置获取分类的首字母的Char值
     * @param position
     * @return
     */
    @Override
    public int getSectionForPosition(int position) {
        return mData.get(position).getSortLetters().charAt(0);
    }
}
