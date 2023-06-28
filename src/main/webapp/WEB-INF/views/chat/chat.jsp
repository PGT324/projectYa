<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
				.inner {
                    position : relative;
                    width : 100%;
                    height : 41px;
                }
                .hd-in {
                    display : flex;
                    justify-content: space-between;
                    margin-top :1%;
                    border-bottom : 1px solid;
                    border-color : #E8E8E8;
                    height : 40px;
                }
                .hd-left {
                    font-weight: bolder;
                    font-size : 20px;
                    margin-left : 12%;
                    
                }
                .hd-left a{
                    color: black;
                }
                .hd-right {
                    font-weight : bold;
                    font-size : 20px;
                    margin-right : 48.5%;
                }
                .chat-head {
                    margin-top : 1%;
                    margin-left : 33%;
                    margin-right : 33%;
                    background-color: #9bbad7;
                    height : 100px;
                    border-bottom : 1px solid #cccccc;
                }
                .ch-one {
                    display : flex;
                }
                .ch-pic {
                    margin-top : 4%;
                    margin-left : 5%;
                    width : 10%;
                    height : 10%;;
                    border-right : 1px solid;
                    padding-right : 3%;
                }
                .ch-pic img {
                    width : 50px;
                    height : 50px;
                }
                .ch-prof {
                    margin-top : 5%;
                    margin-left : 3%;
                }
                .ch-name {
                    font-weight: bold;
                }
                .ch-introd {
                    font-size : 12px;
                    margin-top : 4%;
                }
                .main-chat {
                    margin-left : 33%;
                    padding-top : 2%;
                    padding-left : 2%;
                    background-color : #9BBAD7;
                    margin-right : 33%;
                    height : 500px;
                    overflow : scroll;
                    overflow-x: hidden;
                    margin-bottom : 1%;
                }
                .main-chat::-webkit-scrollbar {
                    width: 18px;
                    
                }
                .main-chat::-webkit-scrollbar-thumb {
                    background-color: #7D91A6;
                    border-radius: 10px;
                }
                .send-msg {
                    margin-left : 33%;
                    margin-top : -0.99%;
                    margin-bottom : 5%;
                    margin-right : 14%;
                    background-color: #f8f8f8;
                    width : 34%;
                    height : 100px;
                    display: flex;
                }
                
                #message {
                    width : 80%;
                    height : 100px;
                    font-size: 14px;
                    font-weight: 400;
                    background-color: #f8f8f8;
                    border: 0px;
                    resize : none;
                }
                #sendBtn {
                    width: 13%;
                    height: 30px; 
                     border : 0px;
                    color: black; 
                    cursor: pointer;
                    margin-left : 1%;
                    background-color : #F6E100;
                    margin-top : 7%;
                    
                }
                #message:focus {
                    outline : 0px;
                }
                .other-dp {
                    display: flex;
                }
                .ot-pic {
                    width : 50px;
                    height : 50px;
                    margin-left : -4%;
                }
                .ot-pic img {
                    width : 50px;
                    height : 50px;
                }
                .ot-name {
                    margin-top : 1%;
                    font-size : 13px;
                    font-weight: bold;
                }
                .ex-one {
                    display : inline-block;
                    position : relative;
                    width : 10px auto;
                    font-size : 13px;
                    border-radius: 2px;
                    background-color: white;
                    margin-left : 7%;
                    padding : 1%;
                    margin-right : 45%;
                    
                    
                }
                .ex-one:after {
	                content: '';
	                position: absolute;
	                left: 0;
	                top: 50%;
	                width: 0;
	                height: 0;
	                border: 9px solid transparent;
	                border-right-color: white;
	                border-left: 0;
	                border-top: 0;
	                margin-top: -4.5px;
	                margin-left: -9px;
                }
                .ex-two {
                    display : inline-block;
                    position : relative;
                    width : 10px auto;
                    font-size : 13px;
                    border-radius: 2px;
                    background-color: white;
                    margin-left : 7%;
                    margin-top : 1%;
                    padding : 1%;
                    margin-right : 45%;
                }
                .ex-lat {
                    display : inline-block;
                    position : relative;
                    width : 10px auto;
                    font-size : 13px;
                    border-radius: 2px;
                    background-color: white;
                    margin-left : 7%;
                    margin-top : 1%;
                    padding : 1%;
                    margin-right : 60%;
                    margin-bottom : 1%;
                }
                
                .ez-one {
                    display : inline-block;
                    position : relative;
                    width : 10px auto;
                    font-size : 13px;
                    border-radius: 2px;
                    background-color: #F6E100;
                    margin-left : 45%;
                    padding : 1%;
                    margin-right : 4%;
                    
                }
                .ez-one:after {
                    content: '';
	                position: absolute;
	                right: 0;
	                top: 50%;
	                width: 0;
	                height: 0;
	                border: 9px solid transparent;
	                border-left-color: #F6E100;
	                border-right: 0;
	                border-top: 0;
	                margin-top: -4.5px;
	                margin-right: -9px;
                }
                .ez-two {
                    display : inline-block;
                    position : relative;
                    width : 10px auto;
                    font-size : 13px;
                    border-radius: 2px;
                    background-color: #F6E100;
                    margin-left : 45%;
                    margin-top : 1%;
                    padding : 1%;
                    margin-right : 4%;
                    
                }
                .ez-lat {
                    display : inline-block;
                    position : relative;
                    width : 10px auto;
                    font-size : 13px;
                    border-radius: 2px;
                    background-color: #F6E100;
                    margin-left : 30%;
                    margin-top : 1%;
                    padding : 1%;
                    margin-right : 4%;
                    margin-bottom : 1%;
                }
                .my-chat {
                    display : inline-block;
                    width : 100%;
                }
                .last-tool {
                    display : flex;
                }
                .lat-time {
                    font-size : 8px;
                    margin-left: 7%;
                }
                .latt-time {
                    font-size : 8px;
                    margin-right : 4%;
                }
                .chat{
                padding-bottom: 1%;
                }
                .list{
                	width: 33%;
                	height: 70px;
                	box-shadow: 1px 1px 1px gray;
                	display: flex;
                	cursor: pointer;
                }
                .listpc{
                	margin-top: 2%;
                	margin-left: 2%;
                	padding-bottom: 0px;
                	width: 20%;
                }
</style>
<title>Insert title here</title>
</head>
	 <header class="header">
                <div class="inner">
                    <div class="hd-in">
                        <div class="hd-left">
                            <a style="text-decoration: none"  href = "${pageContext.request.contextPath }/users/mypage?users_idx=${login.users_idx}">〈</a> 
                        </div>
                        <div class="hd-right">
                     		고객문의
                        </div>
                    </div>
                </div>
          	</header>
            <div class="chat-head">
                <div class="ch-one">
                    <div class="ch-pic">
                        <img src="https://item.kakaocdn.net/do/dc9561970173c28a13654c3f14180b4b617ea012db208c18f6e83b1a90a7baa7">
                    </div>
                    <div class="ch-prof">
                        <div class="ch-name">
                            야놀자 고객센터
                        </div>
                        <div class="ch-introd">
                            보통 1시간 내 응답, 응답률 100%
                        </div>
                    </div>
                </div>
            </div>
           	<div class ="main-chat">
           
            
				
			</div>
	            <div class="send-msg">
	            	<textarea id = "message" onkeyup="if(event.keyCode == 13)sendMessage()"></textarea>
	            	<input id = "sendBtn" type = "button" value="전송">
	            </div>
	       </body>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">
	
	
	
	const main  = document.querySelector(".main-chat");
	let aetChat = null;
	let lastIdx = null;
	let lastChat = null;
	let lastDate = null;
	
	const myidx = ${login.users_idx};
	// 파일 불러드린 내용 보는 스크립트문
	$.ajax({
		url:"${pageContext.request.contextPath}/chat/getChat",
		type:"post",
		data:{idx:${login.users_idx}},
		success: function sc(s) {
			aetChat = s;
			let chdiv = document.createElement('div');
			console.log(s)
			let html = null;
			if (s == null)return;
			for(var i = 0; i < aetChat.length; i++){
				if(aetChat[i].idx == myidx && lastIdx == null || lastIdx != null && lastIdx != aetChat[i].idx && aetChat[i].idx == myidx){
					lastIdx = aetChat[i].idx;
					html = '<div class="my-chat" align="right" ><div class="chat"><div class="ez-one">'+aetChat[i].content+'</div>'
				}else if (aetChat[i].idx != myidx && lastIdx == null || lastIdx != null && lastIdx != aetChat[i].idx && aetChat[i].idx != myidx){
					lastIdx = aetChat[i].idx;
					html = '<div class="other"><div class="other-dp"><div class="ot-pic"><img src="https://item.kakaocdn.net/do/dc9561970173c28a13654c3f14180b4b617ea012db208c18f6e83b1a90a7baa7"></div> <div class="ot-name">'+"상담사"+'</div></div><div class="chat"><div class="ex-one">'+aetChat[i].content+'</div>'
				}else if(lastIdx == aetChat[i].idx && aetChat[i].idx == myidx){
					html += '<div class="ez-two">'+aetChat[i].content+'</div>'
				}else if(lastIdx == aetChat[i].idx && aetChat[i].idx != myidx){
					html += '<div class="ex-two">'+aetChat[i].content+'</div>'
				}
				
				if(aetChat[i+1] != null && aetChat[i+1].idx != aetChat[i].idx || i+1 == aetChat.length && aetChat[i].idx == myidx){
					html += '</div><div class="latt-time">'+aetChat[i].cdate+'</div></div>'
					chdiv.innerHTML = html
					main.appendChild(chdiv);
					lastChat = chdiv.children[0].children[0];	
					lastDate = chdiv.children[0].children[1];	
					chdiv = document.createElement('div');
				}else if(aetChat[i+1] != null && aetChat[i+1].idx != aetChat[i].idx || i+1 == aetChat.length && aetChat[i].idx != myidx){
					html += '</div><div class="lat-time">'+aetChat[i].cdate+'</div></div>'
					chdiv.innerHTML = html
					main.appendChild(chdiv);
					lastChat = chdiv.children[0].children[1];
					lastDate = chdiv.children[0].children[2];
					chdiv = document.createElement('div');
				}
				
			}
			$('.main-chat').scrollTop($('.main-chat').prop('scrollHeight'));
		}
	})
	 
	
	$("#sendBtn").click(function() {
	    sendMessage();
	    $('#message').val('')
	});
	
	let sock = new SockJS("http://localhost:8080/pro/echo");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	sock.onopen = (evn) => {
		console.log("채팅참여")
		sock.send("&key"+${login.users_idx});
	}
	function sendMessage() {
	    sock.send($("#message").val()+"&|&"+${login.users_idx}+"&key"+${login.users_idx});
	    $('#message').val('')
	}
	
	
	
	
	
	function onMessage(msg) {
	    var data = msg.data+"";
	   	let idxIndex = data.lastIndexOf("&|&");
	   	let dateIndex = data.lastIndexOf("&&&");
	   	
	   	let tf = false
	   	let ttf = false
	   	let sendDiv = document.createElement('div');
	   	console.log(msg)
	   	let idx = data.substring(idxIndex+3);
	   	let date = data.substring(dateIndex+3,idxIndex);
	   	let chat = data.substring(0,dateIndex);
	   	
	   	console.log(lastIdx, idx ,lastIdx != idx)
	   	
	   	let lchat = null;
	   	let ldate = null;
	   	
	   	if(lastIdx == null && idx == myidx || lastIdx != null && lastIdx != idx && idx == myidx){
	   		lastIdx = idx;
	   		sendDiv.setAttribute("class","my-chat");
	   		sendDiv.setAttribute("align","right");
	   		sendDiv.innerHTML = '<div class="chat"><div class="ez-one">'+chat+'</div></div><div class="latt-time">'+date+'</div>'
	   		tf = true;
	   		ttf = true;
	   	}else if(lastIdx == null && idx != myidx || lastIdx != null && lastIdx != idx && idx != myidx){
	   		lastIdx = idx;
	   		sendDiv.setAttribute("class","other");
	   		sendDiv.innerHTML = '<div class="other-dp"><div class="ot-pic"><img src="https://item.kakaocdn.net/do/dc9561970173c28a13654c3f14180b4b617ea012db208c18f6e83b1a90a7baa7"></div><div class="ot-name">'+"상담사"+'</div></div><div class="chat"><div class="ex-one">'+chat+'</div></div> <div class="lat-time">'+date+'</div>';
	   		tf = true;
	   	}else if(lastIdx != null && lastIdx == myidx && idx == myidx){
	   		sendDiv.setAttribute("class", "ez-two");
	   	}else if(lastIdx != null && lastIdx != myidx && idx != myidx){
	   		sendDiv.setAttribute("class", "ex-two");
	   	}
	   	
	   	if(tf){
	   		main.appendChild(sendDiv)
	   		lchat = Array.from(document.querySelectorAll('.chat'));
	   		if(ttf){
	   		ldate = Array.from(document.querySelectorAll('.latt-time'));   			
	   		}else{
	   		ldate = Array.from(document.querySelectorAll('.lat-time'));	   			
	   		}
			lastDate = ldate[ldate.length-1];
	   		lastChat = lchat[lchat.length-1];
	   	}else{
	   		sendDiv.innerText = chat;
		   	lastDate.innerText = date; 		
	   		lastChat.appendChild(sendDiv)	
	   	}
	   	
	   	
		   	$('.main-chat').scrollTop($('.main-chat').prop('scrollHeight')); 
	}
	
	function onClose(evt) {
	    $("#messageArea").append("연결 끊김");
	
	}
</script>
</html>