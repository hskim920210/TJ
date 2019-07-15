<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 소켓 테스트</title>

<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery.js"></script>
<script type="text/javascript">
	// 웹 소켓 변수
	var wsocket = null;
	
	// 메세지를 보내고자 하는 대상을 저장하고 있는 전역변수
	var messageTarget = "all";
	
	$(document).on("click", ".client", function() {
		// 공백으로 자르고
		splitTarget = $(this).val().split(" ");
		messageTarget = splitTarget[1].substring(1,splitTarget[1].length-1);
		alert(messageTarget);
	});
	
	$(document).ready(function() {
		$('#connBtn').click(function() { sockConnect(); });
		$('#sendBtn').click(function() { sendMessage(); });
		$('#closeBtn').click(function() { sockClose(); });
	});
	
	function sockConnect() {
		var alias = $("#alias").val().trim();
		if( !alias ) {
			alert("별칭을 입력해야 연결할 수 있습니다.")
			return;
		}
		
		if( wsocket != null )
			return;
		
		wsocket = 
			new WebSocket("ws://localhost:8080/webapp/bc");
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
		wsocket.onopen = function() {
			wsocket.send(alias);
		};
		
		var message = $("#chat-window").html("<p>서버와 연결되었습니다.</p>")	
	}
	
	function sockClose() {
		if( wsocket == null )
			return;
		
		wsocket.close()
	}
	
	function sendMessage() {
		if( wsocket == null ) {
			alert("웹 소켓이 연결되지 않았습니다.")
			return;
		}
		/*//
		var selected = $("input[name=client]").is(':checked');
		if( selected ){
			var receiver = $("input[name=client]").val();
		}
		//
		*/
		
		wsocket.send("to:" + messageTarget + "@" + $("#message").val() );
	}
	
	function onMessage(evt) {
		var data = evt.data;
		var target_new = "newClient:";
		var target_close = "closed:";
		if( data.indexOf(target_new) == 0 ) {
			// alert(data);
			list_alias = data.substring(target_new.length, data.length);
			split_alias = list_alias.split(",");
			// alert(split_alias);
			
			cur_clients = "";
			for( var i = 0 ; i < split_alias.length ; i++ ){
				// 비어있는 문자열이라면 건너뛰라
				if( !split_alias[i].length ){
					continue;
				}
				cur_clients += "<p><label><input type='radio' class='client' name='client' value='" + split_alias[i] + "'>" + split_alias[i] + "</label></p>";
			}
			$("#client-list").append(cur_clients);
			return;
		} else if( data.indexOf(target_close) == 0 ){
				close_alias = data.substring(target_close.length, data.length);
				// alert(close_alias);
				
				// 가장 가까운 부모 p를 찾는다. 그래서 remove
				$("input[value='" + close_alias + "']").closest("p").remove();
				
				return;
		}
		
		var message = $("#chat-window").html()
		message += "<p>" + data + "</p>"
		$("#chat-window").html(message)		
	}
		
	function onClose(evt) {
		var message = $("#chat-window").html()
		message += "<p>연결종료</p>"
		$("#chat-window").html(message)		
	}
</script>

</head>
<body>
	<p>별칭 : <input type="text" id="alias">
    <input type="button" id="connBtn" value="연결"></p>

	<div id='client-list'>
		<p><label><input type='radio' class='client' name='client' value='all (all)' checked="checked">전체 사용자</label></p>
	</div>
	
	<h3>채팅메세지</h3>
	<div id='chat-window'></div>

	<p>메세지 : <input type="text" id="message">
    <input type="button" id="sendBtn" value="전송">
    <input type="button" id="closeBtn" value="연결종료"></p>
</body>
</html>