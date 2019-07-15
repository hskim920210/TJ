package com.tje.webapp.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// @Controller 없으므로 servlet-context에 빈객체 만들어준다.
// 왜냐면 백그라운드 동작해야하므로 Controller로 등록 안한다.

// 웹 소켓을 사용하여 클라이언트 페이지와 텍스트 기반의 데이터를 주고받기 위한 컨트롤러 클래스 선언.
public class EchoController extends TextWebSocketHandler {
	// 웹 소켓 클라이언트가 서버로 연결될 때,
	// 각 클라이언트마다 한번만 실행되는 메소드 (최초의 시작에만)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트가 연결되면 세션 아이디 값을 출력 // 기존 알고있는 그 세션(서버쪽에서 클라이언트의 정보를 저장)과 같다
		System.out.printf("%s가 연결됨\n", session.getId());
	}
	
	// 웹 소켓 클라이언트가 서버측으로 데이터를 전송할 때 실행되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 어떤 사용자(세션에 저장된)가 어떤 메세지를 보내는가
		// getPayload : 실제 메세지를 스트링으로 가져옴
		// 클라이언트가 전송한 데이터 출력
		System.out.printf("%s로부터 [%s]를 받음\n", session.getId(), message.getPayload());
		
		// 세션을 사용하여 클라이언트에게 텍스트 메세지를 전송.
		session.sendMessage(new TextMessage("echo : " + message.getPayload()));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.printf("%s가 연결 종료됨\n", session.getId());
	}
}
