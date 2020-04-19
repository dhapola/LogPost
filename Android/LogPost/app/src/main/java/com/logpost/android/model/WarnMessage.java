package com.logpost.android.model;


import android.os.Build;

import com.deepesh.logpostdemo.LogPostDemoApplication;
import com.deepesh.logpostdemo.R;

/**
 * class to facilitate sending Warning log entries
 *
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 *
 */

public class WarnMessage implements LogPostMessage {

    private String message;
    private String logURL;

    public WarnMessage(String msg){
        this.message = Build.MODEL + " - " + msg;

        logURL = String.format("%s%s", LOGPOST_SERVICE_IP,  LogPostDemoApplication.getInstance().getString(R.string.warn_url));
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
