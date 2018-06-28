package com.example.nastisch.cakeroom;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class AndroidLoginController extends Application {

    public static final String TAG = AndroidLoginController.class.getSimpleName();

    //initialize objects for RequestQueue - AndroidLoginController
    private static AndroidLoginController mInstance;
    private RequestQueue m_RequestQueue;

    private static AndroidLoginController mInstanceStaff;
    private RequestQueue m_RequestQueueStaff;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mInstanceStaff = this;
    }

    public static synchronized AndroidLoginController getmInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue () {
        if(m_RequestQueue==null) {

            m_RequestQueue = Volley.newRequestQueue(getApplicationContext());
        } return m_RequestQueue;
    }


    //use the initialized objects
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public static synchronized AndroidLoginController getmInstanceStaff(){
        return mInstanceStaff;
    }

    public RequestQueue getRequestQueueStaff () {
        if(m_RequestQueueStaff==null) {

            m_RequestQueueStaff = Volley.newRequestQueue(getApplicationContext());
        } return m_RequestQueueStaff;
    }


    //use the initialized objects
    public <T> void addToRequestQueueStaff(Request<T> reqstaff, String tagstaff) {
        reqstaff.setTag(TextUtils.isEmpty(tagstaff) ? TAG : tagstaff);
        getRequestQueueStaff().add(reqstaff);
    }
}
