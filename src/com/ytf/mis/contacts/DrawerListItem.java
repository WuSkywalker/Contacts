package com.ytf.mis.contacts;

import android.graphics.drawable.Drawable;

/**
 * Package: com.ytf.mis.contacts.detail
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-14
 * Time: 22:35
 * Description:
 */
public class DrawerListItem {
    /**
     * Field
     */
    private Drawable icon;
    private String title;

    /**
     *
     * @param icon
     * @param title
     */
    public DrawerListItem(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Drawable getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     */
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
