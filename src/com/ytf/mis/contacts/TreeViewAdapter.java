package com.ytf.mis.contacts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Package: com.ytf.contactsdemo
 * Created with ContactsDemo
 * User: WuHua
 * Date: 14-11-10
 * Time: 16:15
 * Description:
 */
public class TreeViewAdapter extends ArrayAdapter {

    /**
     * Field
     */
    private Context context;
    private LayoutInflater inflater;
    private List<TreeElement> elementList;
    private Bitmap expandedIcon;
    private Bitmap collapsedIcon;
    private Bitmap manIcon;
    private Bitmap femaleIcon;

    /**
     * @param context
     * @param textViewResourceId
     * @param objects
     */
    public TreeViewAdapter(Context context, int textViewResourceId,
                           List objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.elementList = objects;
        this.collapsedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.txl_collapsed_icon);
        this.expandedIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.txl_expanded_icon);
        this.manIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.txl_man_icon);
        this.femaleIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.txl_female_icon);
    }

    /**
     * @return
     */
    public int getCount() {
        return elementList.size();
    }

    /**
     * @param position
     * @return
     */
    public Object getItem(int position) {
        return position;
    }

    /**
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        convertView = inflater.inflate(R.layout.txl_contacts_list_item, null);

        holder = new ViewHolder();
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.icon = (ImageView) convertView.findViewById(R.id.icon);
        holder.letter = (TextView) convertView.findViewById(R.id.letter);
        holder.phone = (TextView) convertView.findViewById(R.id.phone);
        /**
         * hide the letter
         */
        holder.letter.setVisibility(View.GONE);

        convertView.setTag(holder);

        final TreeElement element = elementList.get(position);

        int level = element.getLevel();

        holder.icon.setPadding(64 * level, holder.icon
                .getPaddingTop(), 0, holder.icon.getPaddingBottom());
        holder.title.setText(element.getTitle());
        if (element.isHasChild() && (element.isExpanded() == false)) {
            holder.icon.setImageBitmap(collapsedIcon);
        } else if (element.isHasChild() && (element.isExpanded() == true)) {
            holder.icon.setImageBitmap(expandedIcon);
        } else if (!element.isHasChild()) {
            //holder.phone.setText("18080064615");
            holder.icon.setImageBitmap(manIcon);
        }
        return convertView;
    }

}
