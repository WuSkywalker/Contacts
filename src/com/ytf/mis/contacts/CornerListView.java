package com.ytf.mis.contacts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ytf.mis.contacts.R;


/**
 * Package: com.ytf.mis.contacts.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-18
 * Time: 18:38
 * Description:
 */
public class CornerListView extends ListView{
    /**
     *
     * @param context
     */
    public CornerListView(Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param attrs
     */
    public CornerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CornerListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int x = (int) ev.getX();
                int y = (int) ev.getY();
                int itemnum = pointToPosition(x, y);

                if (itemnum == AdapterView.INVALID_POSITION){
                    break;
                } else {
                    if (itemnum == 0){
                        if (itemnum == (getAdapter().getCount()-1)) {
                            //只有一项
                            setSelector(R.drawable.txl_corner_list_single_item);
                        } else {
                            //第一项
                            setSelector(R.drawable.txl_corner_list_first_item);
                        }
                    } else if (itemnum==(getAdapter().getCount()-1)){
                        //最后一项
                        setSelector(R.drawable.txl_corner_list_last_item);
                    } else {
                        //中间项
                        setSelector(R.drawable.txl_corner_list_item);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
