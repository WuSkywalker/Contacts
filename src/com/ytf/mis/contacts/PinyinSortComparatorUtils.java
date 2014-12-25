package com.ytf.mis.contacts;

import java.util.Comparator;

/**
 * Package: com.ytf.mis.contacts.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-17
 * Time: 19:56
 * Description:
 */
public class PinyinSortComparatorUtils implements Comparator<PinyinSortUtils>{
    @Override
    public int compare(PinyinSortUtils lhs, PinyinSortUtils rhs) {
        String left = lhs.getPinYin();
        String right = rhs.getPinYin();
        return left.compareToIgnoreCase(right);
    }
}
