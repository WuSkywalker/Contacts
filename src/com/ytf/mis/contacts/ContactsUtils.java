package com.ytf.mis.contacts;

import android.content.Context;
import android.util.Log;
import com.XFastFactory.XDbUtils.XDbUtils;
import com.XFastFactory.XJson.XJsonUtils;
import com.XFastFactory.XWebService.XWebService;
import com.XFastFactory.XWebService.XWebServiceListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Package: com.ytf.mis.contacts
 * Created with Contacts
 * User: WuHua
 * Date: 14-11-27
 * Time: 10:38
 * Description:
 */
public class ContactsUtils {
    private static final String TAG = "ContactsUtils";

    public final static String NAME_SPACE = "http://tempuri.org/";
    public static String URL = "http://116.52.157.156:8089/service/jichu/misinfo.asmx";

    public final static int HTTP_TIMEOUT = 60000;

    public static XWebService webService;
    public static XDbUtils db;
    private Context mContext;

    /**
     *
     * @param context
     */
    public ContactsUtils(Context context){
        this.mContext = context;
        XWebService.Initialize(NAME_SPACE, URL, true);
        webService = XWebService.newInstance();
        db = new XDbUtils(context, "MisContactsDB");

    }

    public void checkVersion(final String preVersion){
        webService.call("GetContactVersion", null, new XWebServiceListener() {
            @Override
            public void onReceive(String s) {
                s = s.substring(s.indexOf('=') + 1);
                try {
                    JSONObject object = new JSONObject(s);
                    String version = object.getString("Result");
                    if (version.equals(preVersion)){
                        update();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String s) {

            }
        });
    }
    public void create(){

    }
    public void update(){
        webService.call("GetContact", null, new XWebServiceListener() {
            @Override
            public void onReceive(String s) {
                try {
                    Log.e(TAG, "json : " + s);
                    s = s.substring(s.indexOf('=') + 1);
                    JSONObject object = new JSONObject(s);
                    JSONObject result = object.getJSONObject("Result");
                    String version = result.getString("Version");
                    // add depts to db
                    db.createTable(Department.class);
                    JSONArray depts = result.getJSONArray("Depts");
                    for (int i = 0; i < depts.length(); ++i) {
                        JSONObject temp = depts.getJSONObject(i);
                        Department department = (Department) XJsonUtils.toClass(temp, Department.class);
                        Log.e(TAG, "department : " + department.toString());
                        db.insert(department);
                    }
//                    db.close();

                    // add users to db
                    db.createTable(User.class);
                    JSONArray users = result.getJSONArray("Users");
                    for (int i = 0; i < users.length(); ++i) {
                        JSONObject temp = users.getJSONObject(i);
                        User user = (User) XJsonUtils.toClass(temp, User.class);
                        user.callTime = callTime();
                        Log.e(TAG, "user : " + user.toString());
                        db.insert(user);
                    }
                    db.close();

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(String s) {

            }
        });
    }

    /**
     * get current call of time
     * @return
     */
    public static String callTime (){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currTime = new Date(System.currentTimeMillis());
        return format.format(currTime);
    }
}
