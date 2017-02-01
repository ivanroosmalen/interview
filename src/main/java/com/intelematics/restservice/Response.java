package com.intelematics.restservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ian on 1/31/2017.
 */
public class Response {

    private Map<String, Object> body;
    private int statusCode;
    private String message;

    public Response() {
        this.statusCode = 200;
        this.body = new HashMap<String, Object>();
    }

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = new HashMap<String, Object>();
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, Object> getBody() {
        return this.body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getTimestamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return sdf.format(date);
    }
}
