package com.dejans.eurekaclient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class HttpUtils {
    private String url = new String();
    private String urlForAnalyze;
    private String scheme = new String();
    private String host = new String();
    private String port = new String();
    private String path = new String();
    private String query = new String();

    // this constructor is used when prepare request
    public HttpUtils() {

    }

    // this constructor is used when should analize request 
    public HttpUtils(String url) {
        urlForAnalyze = url;
    }

    public HttpUtils setScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public HttpUtils setHost(String host) {
        this.host = host;
        return this;
    }

    public HttpUtils setPort(String port) {
        this.port = port;
        return this;
    }

    public HttpUtils setPath(String path) {
        this.path = path;
        return this;
    }


    public HttpUtils addParamToQuery(String param, String value) throws UnsupportedEncodingException {
        if (query == null)
            query = new String();

        if (query != "")
            query += "&";
        query += param;
        if (value == null)
            return this;
        if (value != "") {
            query += "=" + URLEncoder.encode(value, "UTF-8");
        }
        return this;
    }

    // this method will be used if you want to clear existing query and start buld a new
    public HttpUtils newParamsToQuery () {
        query = "";
        return this;
    }

    public String getUrl () {
        if (scheme == null || !scheme.equals("")) {
            scheme = "http";
        }
        if (scheme.toLowerCase().equals("http")) {
            url = scheme + "://";
            url += host;
            if (port != null && !port.equals("")) {
                url += ":" + port;
            }
            if (path != null && !path.equals("")) {
                url += path;
            }
            if (query != null && !query.equals("")) {
                url += "?" + query;
            }
            return url;
        }
        return null;
    }
}