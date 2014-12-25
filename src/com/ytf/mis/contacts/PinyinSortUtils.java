package com.ytf.mis.contacts;

/**
 * Package: com.ytf.mis.contacts.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-17
 * Time: 19:49
 * Description:
 */
public class PinyinSortUtils {
    public static final String TAG = "SortUtils";

    /**
     * Field
     */
    private String name; // 姓名
    private String pinYin; // 姓名拼音
    private String sortLetters; // 姓名拼音首字母

    /**
     *
     * @param name
     */
    public PinyinSortUtils(String name) {
        this.name = name;
        this.pinYin = PinyinUtils.getPinYin(name);
        this.sortLetters = getLetters();
    }

    /**
     *
     * @return
     */
    private String getLetters(){
        String letter = pinYin.substring(0, 1).toUpperCase();
        return letter;
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
    public String getPinYin() {
        return pinYin;
    }

    /**
     *
     * @param pinYin
     */
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    /**
     *
     * @return
     */
    public String getSortLetters() {
        return sortLetters;
    }

    /**
     *
     * @param sortLetters
     */
    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
}
