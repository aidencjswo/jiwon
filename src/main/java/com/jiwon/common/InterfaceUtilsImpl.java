package com.jiwon.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.util.Map;

@Component
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
        HttpGet httpGet = new HttpGet(requestURL);

        httpGet.setHeader("Accept","application/json");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = httpClient.execute(httpGet);

        ResponseHandler<String> handler = new BasicResponseHandler();

        String body = handler.handleResponse(response);

        return body;
    }
}
