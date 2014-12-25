package com.ytf.mis.contacts;

/**
 * Package: com.ytf.mis.contacts.common
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-24
 * Time: 15:45
 * Description:
 */
public class ItemInfo {
    /**
     * department ID
     */
    int deptID;
    /**
     * department name
     */
    String deptName;

    /**
     *
     */
    public ItemInfo(){

    }

    /**
     *
     * @param info
     */
    public ItemInfo(ItemInfo info){
        this.deptID = info.deptID;
        this.deptName = info.deptName;
    }

    /**
     *
     * @return
     */
    public int getDeptID() {
        return deptID;
    }

    /**
     *
     * @param deptID
     */
    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    /**
     *
     * @return
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
