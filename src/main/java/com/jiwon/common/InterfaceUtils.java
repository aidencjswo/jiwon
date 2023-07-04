package com.jiwon.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Map;

@ComponentScan
public interface InterfaceUtils {
    String get(String url, Map<String,String> queryMap) throws IOException;
    String get(String url) throws IOException;
}
