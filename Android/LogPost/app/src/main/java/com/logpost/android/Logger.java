package com.logpost.android;

import android.os.Message;
import android.util.Log;

import com.logpost.android.model.*;

import static android.util.Log.getStackTraceString;

/**
 * Logger class encapsulates Android Log class to extend capabilities for posting log entries in
 * Logcat as well as logpost service. Successfully posted log entries are picked up by ELK stack
 *
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 *
 */
public class Logger {
    private static LogPostLooperThread _logpostThread = null;

    /**
     * This method initiates Looper thread that can start accepting messages in queue
     */
    public static void startLooper(){
        _logpostThread = new LogPostLooperThread();
        _logpostThread.start();

    }

    /**
     * This method terminates looper thread
     */
    public static void stopLooper(){
        _logpostThread.stopThread();
    }


    /**
     * Send an info log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void i(String tag, String msg) {
        Log.i(tag, msg);

        Message message = Message.obtain(_logpostThread.getHandler());
        InfoMessage infoMessage = new InfoMessage(msg );

        message.obj = infoMessage;

        message.sendToTarget();
        return;
    }

    /**
     * Send a warning log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void w(String tag, String msg) {
        Log.w(tag, msg);
        Message message = Message.obtain(_logpostThread.getHandler());
        WarnMessage warnMessage = new WarnMessage(msg);

        message.obj = warnMessage;

        message.sendToTarget();
        return;
    }


    /**
     * Send an error or exception log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception & stack trace to log
     */
    public static void e(String tag, String msg, Throwable tr) {
        Log.e(tag, msg, tr);

        Message message = Message.obtain(_logpostThread.getHandler());
        ErrorMessage errorMessage = new ErrorMessage(msg + '\n' + getStackTraceString(tr));

        message.obj = errorMessage;

        message.sendToTarget();
        return;
    }

    /**
     * Send a warning log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void e(String tag, String msg) {
        Log.e(tag, msg);

        Message message = Message.obtain(_logpostThread.getHandler());
        ErrorMessage errorMessage = new ErrorMessage(msg);

        message.obj = errorMessage;

        message.sendToTarget();
        return;
    }
}
