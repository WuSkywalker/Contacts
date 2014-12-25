package com.ytf.mis.contacts;

import java.util.ArrayList;

/**
 * Package: com.ytf.mis.contacts.common
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-24
 * Time: 9:03
 * Description:
 */
public class DepartmentInfo extends ItemInfo {
    /**
     * field
     */
    private int displayIndex;
    ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
    /**
     *
     */
    public DepartmentInfo() {

    }

    /**
     *
     * @param info
     */
    public DepartmentInfo(DepartmentInfo info){
        super(info);
        this.displayIndex = info.displayIndex;
    }

    public void addStaff(UserInfo userInfo){
        this.userInfos.add(userInfo);
    }
    /**
     *
     * @return
     */
    public int getDisplayIndex() {
        return displayIndex;
    }

    /**
     *
     * @param displayIndex
     */
    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }
}
