package com.ytf.mis.contacts;

/**
 * Package: com.ytf.mis.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-14
 * Time: 15:32
 * Description:
 */
public class StaffInfo {
    /**
     * Field
     */
    private UserBasicInfo userBasicInfo;
    private UserContactsInfo userContactsInfo;
    private UserDetailInfo userDetailInfo;

    /**
     *
     */
    public StaffInfo(){

    }
    /**
     *
     * @param userBasicInfo
     */
    public StaffInfo(UserBasicInfo userBasicInfo) {
        this.userBasicInfo = userBasicInfo;
        this.userContactsInfo = new UserContactsInfo(null, null, null, null, null, null);
        this.userDetailInfo = new UserDetailInfo(null, null, null, null, null, null, null);
    }

    /**
     *
     * @param userBasicInfo
     * @param userContactsInfo
     */
    public StaffInfo(UserBasicInfo userBasicInfo, UserContactsInfo userContactsInfo) {
        this.userBasicInfo = userBasicInfo;
        this.userContactsInfo = userContactsInfo;
        this.userDetailInfo = new UserDetailInfo(null, null, null, null, null, null, null);
    }

    /**
     *
     * @param userBasicInfo
     * @param userContactsInfo
     * @param userDetailInfo
     */
    public StaffInfo(UserBasicInfo userBasicInfo, UserContactsInfo userContactsInfo, UserDetailInfo userDetailInfo) {
        this.userBasicInfo = userBasicInfo;
        this.userContactsInfo = userContactsInfo;
        this.userDetailInfo = userDetailInfo;
    }

    /**
     *
     * @return
     */
    public UserBasicInfo getUserBasicInfo() {
        return userBasicInfo;
    }

    /**
     *
     * @param userBasicInfo
     */
    public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
        this.userBasicInfo = userBasicInfo;
    }

    /**
     *
     * @return
     */
    public UserContactsInfo getUserContactsInfo() {
        return userContactsInfo;
    }

    /**
     *
     * @param userContactsInfo
     */
    public void setUserContactsInfo(UserContactsInfo userContactsInfo) {
        this.userContactsInfo = userContactsInfo;
    }

    /**
     *
     * @return
     */
    public UserDetailInfo getUserDetailInfo() {
        return userDetailInfo;
    }

    /**
     *
     * @param userDetailInfo
     */
    public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
        this.userDetailInfo = userDetailInfo;
    }
}
