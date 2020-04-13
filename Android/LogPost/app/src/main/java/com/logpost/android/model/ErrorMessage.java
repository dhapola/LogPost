package com.logpost.android.model;


import android.os.Build;

import com.deepesh.logpostdemo.LogPostDemoApplication;
import com.deepesh.logpostdemo.R;

/**
 * class to facilitate sending Error and Exception log entries
 *
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 *
 */
public class ErrorMessage implements LogPostMessage {

    private String message;
    private String logURL;

    public ErrorMessage(String msg){
        this.message = Build.MODEL + " - " + msg;
        logURL = String.format("http://10.10.10.6:45600/%s",  LogPostDemoApplication.getInstance().getString(R.string.error_url));
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String msg) {
        this.message = msg;
    }

    @Override
    public String getLogURL() {
        return logURL;
    }

}
