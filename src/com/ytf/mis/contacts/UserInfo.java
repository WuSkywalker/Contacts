package com.ytf.mis.contacts;

import java.util.Date;

/**
 * Package: com.ytf.mis.contacts.common
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-24
 * Time: 9:13
 * Description:
 */
public class UserInfo extends ItemInfo{
    /**
     * field
     */
    private String id;
    private String userName;
    private String telephone;
    private int callTimes;
    private Date callDate;

    /**
     *
     */
    public UserInfo(){
        this.callTimes = 0;
       this.callDate = new Date(System.currentTimeMillis());
    }

    /**
     *
     * @param info
     */
    public UserInfo(UserInfo info) {
        super(info);
        this.id = info.id;
        this.userName = info.userName;
        this.telephone = info.telephone;
        this.callTimes = info.callTimes;
        this.callDate = info.callDate;
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     *
     * @return
     */
    public int getCallTimes() {
        return callTimes;
    }

    /**
     *
     * @param callTimes
     */
    public void setCallTimes(int callTimes) {
        this.callTimes = callTimes;
    }

    /**
     *
     * @return
     */
    public Date getCallDate() {
        return callDate;
    }

    /**
     *
     * @param callDate
     */
    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }
}
