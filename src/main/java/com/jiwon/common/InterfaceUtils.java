package com.jiwon.common;
import java.io.IOException;
import java.util.Map;

public interface InterfaceUtils {
    String get(String url, Map<String,String> queryMap) throws IOException;
    String get(String url) throws IOException;
}
