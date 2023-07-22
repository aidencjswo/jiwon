package com.jiwon.service;


import java.util.Map;

public interface MemberService {

    String memberIdCheck(String id);

    String memberJoin(Map<String, String> memberMap);
}
