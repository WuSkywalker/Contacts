package com.ytf.mis.contacts;

/**
 * Package: com.ytf.mis.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-27
 * Time: 11:09
 * Description:
 */
public class Department {
    /**
     * department ID
     */
    int DeptID;
    /**
     * department name
     */
    String DeptName;
    /**
     * display index
     */
    int DisplayIndex;

    @Override
    public String toString() {
        return "Department{" +
                ", DeptID=" + DeptID +
                ", DeptName='" + DeptName + '\'' +
                ", DisplayIndex=" + DisplayIndex +
                '}';
    }
}
