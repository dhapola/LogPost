package com.logpost.android.model;

/**
 * An interface that defines message types
 *
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 *
 */
public interface LogPostMessage {

    static final String LOGPOST_SERVICE_IP = "http://10.10.10.6:45600/";

    public String getMessage();
    public void setMessage(String msg);
    public String getLogURL();
}
