package com.logpost.android;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.logpost.android.model.LogPostMessage;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * LogPostLooperThread class provides a mechanism to queue log messages and send these log messages
 * to LogPost service.
 *
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-11
 *
 */
class LogPostLooperThread extends Thread{

    /**
     * TAG is used to provide class name in logs
     */
    private final String TAG = LogPostLooperThread.class.getName();

    /**
     * Handler instance is used for managing message queue
     */
    private Handler handler;

    /**
     * Looper is used for creating a waiting infinite loop to process messages in queue
     */
    private Looper looper;

    /**
     * Default constructor
     */
    public LogPostLooperThread(){

    }

    /**
     * Provides a reference of Handler to send messages in queue
     * @return reference of Handler object
     */
    public Handler getHandler() {
        return handler;
    }

    /**
     * This method starts a new worker thread
     */
    public void run(){

        Log.i(TAG, "Started new thread - LogPostLooperThread...");

        Looper.prepare();

        handler = new Handler(){

            public void handleMessage(Message msg){
                HttpURLConnection httpConnection = null;

                try {

                    LogPostMessage messageData = (LogPostMessage)msg.obj;

                    String messageToLog     = messageData.getMessage();
                    byte[] postData         = messageToLog.getBytes( StandardCharsets.UTF_8 );

                    URL url = new URL(messageData.getLogURL());
                    httpConnection = (HttpURLConnection) url.openConnection();
                    httpConnection.setRequestMethod("POST");
                    httpConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
                    httpConnection.setRequestProperty("Content-Length", Integer.toString(postData.length) );
                    httpConnection.setRequestProperty( "charset", "utf-8");
                    httpConnection.setUseCaches(false);
                    httpConnection.setDoInput(true);
                    httpConnection.setDoOutput(false);

                    httpConnection.getOutputStream().write(postData);
                    BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
                    in.read();
                    in.close();

                    int responseCode = httpConnection.getResponseCode();

                    //Use this response code if required
                    Log.i(TAG, "HTTP Response Code: " + responseCode);

                }
                catch(Exception exception) {

                    Log.e(TAG, exception.getMessage(), exception);
                }
            }
        };
        Looper.loop();
        looper = Looper.getMainLooper();
    }

    /**
     * Stops lopper thread
     */
    public void stopThread(){
        try {
            if (looper != null)
                looper.quit();
        }catch (Exception e){}
    }
}
