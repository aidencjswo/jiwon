package com.jiwon.common;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Service
@ServerEndpoint("/socket")
@CrossOrigin
public class WebSocketTestHandler extends TextWebSocketHandler {

    private String inputText;
    private List<WebSocketSession> sessionList = new ArrayList<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 메시지 수신
        String clientMessage = message.getPayload();
        System.out.println("클라이언트로부터 메시지 수신: " + clientMessage);

        inputText = clientMessage;

        // 서버에서 클라이언트로 메시지 전송
        String serverMessage = inputText;

        sessionList.forEach(webSocketSession -> System.out.println("webSocketSession = " + webSocketSession));

        session.sendMessage(new TextMessage(serverMessage));
        System.out.println("서버에서 클라이언트로 메시지 전송: " + serverMessage);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("연결됨 = " + session);
        sessionList.add(session);
        System.out.println("sessionList = " + sessionList);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("연결끊어짐");

    }
}
