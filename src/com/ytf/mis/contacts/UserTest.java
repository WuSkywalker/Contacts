package com.ytf.mis.contacts;

/**
 * Package: com.ytf.mis.contacts
 * Created with Contacts
 * User: AndyHua
 * Date: 14-12-25
 * Time: 10:20
 * Description:
 */
public class UserTest {
    private static final String TAG = "UserTest";

    private String name;
    private int id;
    private String telephone;

    /**
     *
     * @param name
     * @param id
     * @param telephone
     */
    public UserTest(String name, int id, String telephone) {
        this.name = name;
        this.id = id;
        this.telephone = telephone;
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
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }
}
