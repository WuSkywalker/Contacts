package com.ytf.mis.contacts;

/**
 * Package: com.ytf.mis.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-27
 * Time: 11:10
 * Description:
 */
public class User {
    /**
     * department ID
     */
    int DeptID;
    /**
     * department name
     */
    String DeptName;
    /**
     * user id
     */
    String ID;
    /**
     * user name
     */
    String UserName;
    /**
     * user Telephone
     */
    String Telephone;
    /**
     * call times
     */
    int callTimes = 0;
    /**
     * call time
     */
    String callTime = null;

    @Override
    public String toString() {
        return "User{" +
                ", DeptID=" + DeptID +
                ", DeptName='" + DeptName + '\'' +
                ", ID='" + ID + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", callTimes=" + callTimes +
                ", callTime='" + callTime + '\'' +
                '}';
    }
}
