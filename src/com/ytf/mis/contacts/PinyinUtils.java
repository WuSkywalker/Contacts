package com.ytf.mis.contacts;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Package: com.ytf.mis.contacts.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-16
 * Time: 23:02
 * Description: Pinyin Utils
 */
public class PinyinUtils {
    public static final String TAG = "PinyinUtils";

    /**
     * 将字符串中的中文转化为拼音,其他字符不变
     * @param inputData
     * @return
     */
    public static String getPinYin(String inputData){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] input = inputData.trim().toCharArray();
        String output = "";

        try {
            for (char curChar : input) {
                if (java.lang.Character.toString(curChar).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(
                            curChar, format);
                    output += temp[0];
                } else
                    output += java.lang.Character.toString(curChar);
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * 汉字转换为汉语拼音首字母，英文字符不变
     * @param chinese
     * @return
     */
    public static String getFirstpell(String chinese){
        StringBuffer pinyinBf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char curChar : arr) {
            if (curChar > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(curChar, defaultFormat);
                    if (temp != null) {
                        pinyinBf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinBf.append(curChar);
            }
        }
        return pinyinBf.toString().replaceAll("\\W", "").trim();
    }
}
