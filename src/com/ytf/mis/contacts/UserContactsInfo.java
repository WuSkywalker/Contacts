package com.ytf.mis.contacts;

/**
 * Package: com.ytf.contactsdemo
 * Created with ContactsDemo
 * User: WuHua
 * Date: 14-11-13
 * Time: 15:23
 * Description:
 */
public class UserContactsInfo {
    public static final String TAG = "UserContacts";
    // 办公电话
    private String officePhone;
    // 手机号码
    private String mobilePhone;
    // 传真号码
    private String faxNumber;
    // 电子邮件
    private String email;
    // 联系地址
    private String address;
    // 邮编
    private String postalCode;

    /**
     *
     */
    public UserContactsInfo(){

    }
    /**
     *
     * @param officePhone
     * @param mobilePhone
     * @param faxNumber
     * @param email
     * @param address
     * @param postalCode
     */
    public UserContactsInfo(String officePhone, String mobilePhone, String faxNumber, String email, String address, String postalCode) {
        this.officePhone = officePhone;
        this.mobilePhone = mobilePhone;
        this.faxNumber = faxNumber;
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     *
     * @param officePhone
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    /**
     *
     * @return
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     *
     * @param mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     *
     * @return
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     *
     * @param faxNumber
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
