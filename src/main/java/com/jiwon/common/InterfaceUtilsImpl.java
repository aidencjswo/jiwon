package com.jiwon.common;

import lombok.extern.log4j.Log4j2;
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

import java.io.IOException;
import java.util.Map;

@Component
@Log4j2
public class InterfaceUtilsImpl implements InterfaceUtils{
    @Override
    public String get(String requestURL, Map<String,String> queryMap) throws IOException {

        if(queryMap != null){
            int idx = 0;
            requestURL += "?";
            for (String s : queryMap.keySet()) {
                if (idx == queryMap.size()-1) {
                    requestURL += s+"="+queryMap.get(s);
                    break;
                }else{
                    requestURL += s+"="+queryMap.get(s)+"&";
                    idx++;
                }
            }
        }

        HttpGet httpGet = new HttpGet(requestURL);

        httpGet.setHeader("Accept","application/json");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        CloseableHttpResponse response = httpClient.execute(httpGet);

        ResponseHandler<String> handler = new BasicResponseHandler();

        String body = handler.handleResponse(response);

        return body;
    }
    @Override
    public String get(String requestURL) throws IOException {

        HttpGet httpGet = new HttpGet(requestURL);

        httpGet.setHeader("Accept","application/json");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        CloseableHttpResponse response = httpClient.execute(httpGet);

        ResponseHandler<String> handler = new BasicResponseHandler();

        String body = handler.handleResponse(response);

        return body;
    }
}
