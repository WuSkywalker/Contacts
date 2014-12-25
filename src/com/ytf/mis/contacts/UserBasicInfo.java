package com.ytf.mis.contacts;

import android.graphics.Bitmap;

/**
 * Package: com.ytf.contactsdemo
 * Created with ContactsDemo
 * User: WuHua
 * Date: 14-11-13
 * Time: 14:59
 * Description:
 */
public class UserBasicInfo {
    public static final String TAG = "UerBasicInfo";
    /**
     * Field
     */
    // 帐号
    private String acount;
    // RTX号码
    private String rtxNumber;
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 年龄
    private int age;
    // 部门
    private String department;
    // 职务
    private String duty;
    // 头像
    private Bitmap iconHead;

    /**
     *
     */
    public UserBasicInfo(){

    }
    /**
     * @param acount
     * @param rtxNumber
     * @param name
     * @param sex
     * @param age
     * @param department
     * @param duty
     * @param iconHead
     */
    public UserBasicInfo(String acount, String rtxNumber, String name, String sex, int age, String department, String duty, Bitmap iconHead) {
        this.acount = acount;
        this.rtxNumber = rtxNumber;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.department = department;
        this.duty = duty;
        this.iconHead = iconHead;
    }

    /**
     *
     * @return
     */
    public String getAcount() {
        return acount;
    }

    /**
     *
     * @return
     */
    public String getRtxNumber() {
        return rtxNumber;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @return
     */
    public String getDuty() {
        return duty;
    }

    /**
     *
     * @param duty
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     *
     * @return
     */
    public Bitmap getIconHead() {
        return iconHead;
    }

    /**
     *
     * @param iconHead
     */
    public void setIconHead(Bitmap iconHead) {
        this.iconHead = iconHead;
    }
}
