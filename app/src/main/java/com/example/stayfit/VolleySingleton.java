package com.example.stayfit;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    RequestQueue requestQueue;
    private static VolleySingleton mInstance;

    private VolleySingleton(Context context){
        requestQueue= Volley.newRequestQueue(context.getApplicationContext());

    }
    public static synchronized VolleySingleton getInstance(Context context){
        if(mInstance==null){
            mInstance=new VolleySingleton(context);
        }
        return mInstance;
    }
    public RequestQueue getRequestQueue(){
        return  requestQueue;
    }

}

