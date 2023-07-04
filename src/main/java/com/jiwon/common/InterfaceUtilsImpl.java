package com.jiwon.common;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Map;

public class InterfaceUtilsImpl implements InterfaceUtils{
    @Override
    public String get(String requestURL, Map<String,String> queryMap) throws IOException {

//        if(queryMap != null){
//            StringBuffer sb = new StringBuffer(requestURL);
//            for (String s : queryMap.keySet()) {
//
//            }
//        }

        HttpClient client = HttpClientBuilder.create().build();

        HttpUriRequest request = RequestBuilder.get()
                .setUri(requestURL)
                .setHeader(HttpHeaders.CONTENT_TYPE,"application/json")
                .build();

        HttpGet getRequest = new HttpGet(requestURL);


        HttpResponse response = client.execute(getRequest);

        return response.toString();
    }
    @Override
    public String get(String requestURL) throws IOException {

//        if(queryMap != null){
//            StringBuffer sb = new StringBuffer(requestURL);
//            for (String s : queryMap.keySet()) {
//
//            }
//        }

        HttpClient client = HttpClientBuilder.create().build();

        HttpUriRequest request = RequestBuilder.get()
                .setUri(requestURL)
                .setHeader(HttpHeaders.CONTENT_TYPE,"application/json")
                .build();

        HttpGet getRequest = new HttpGet(requestURL);


        HttpResponse response = client.execute(getRequest);

        return response.toString();
    }
}
