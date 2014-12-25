package com.ytf.mis.contacts;

/**
 * Package: com.ytf.contactsdemo
 * Created with ContactsDemo
 * User: WuHua
 * Date: 14-11-13
 * Time: 15:23
 * Description:
 */
public class UserDetailInfo {
    public static final String ATG = "UerDetailInfo";

    // 国家
    private String country;
    // 省份
    private String province;
    // 城市
    private String city;
    //血型(A型、B型、O型、AB型、其他)
    private String bloodType;
    //生日(年/月/日)
    private String birthday;
    // 个人主页
    private String personalWebsite;
    // 个人说明
    private String personalInfomation;

    /**
     *
     */
    public UserDetailInfo(){

    }
    /**
     *
     * @param country
     * @param province
     * @param city
     * @param bloodType
     * @param birthday
     * @param personalWebsite
     * @param personalInfomation
     */
    public UserDetailInfo(String country, String province, String city, String bloodType, String birthday, String personalWebsite, String personalInfomation) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.bloodType = bloodType;
        this.birthday = birthday;
        this.personalWebsite = personalWebsite;
        this.personalInfomation = personalInfomation;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getProvince() {
        return province;
    }

    /**
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     *
     * @param bloodType
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     *
     * @return
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return
     */
    public String getPersonalWebsite() {
        return personalWebsite;
    }

    /**
     *
     * @param personalWebsite
     */
    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    /**
     *
     * @return
     */
    public String getPersonalInfomation() {
        return personalInfomation;
    }

    /**
     *
     * @param personalInfomation
     */
    public void setPersonalInfomation(String personalInfomation) {
        this.personalInfomation = personalInfomation;
    }
}
