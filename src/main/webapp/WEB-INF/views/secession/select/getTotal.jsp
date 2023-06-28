<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/setting/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table style="width: 20%;" border="1">
			<tr>			

				<th>total list </th>
				<th style="width: 10%;">인원</th>
			</tr>
			<c:forEach var="total" items="${total }">
			<tr>
				<td>${total.TYPE_NAME}</td>
				<th><a onclick="list(this)" style="cursor: pointer; color: red;" id = "${total.TYPE_IDX }">${total.C}</a></th>
			</tr>
			</c:forEach>
		</table>
		<div id = "mainDiv" align="center" style="margin-top: 4%;  display: none;">
			<div align="left" style="margin-left: 20%; margin-bottom: 1%; ">
				<input type = "button" value = "필터" onclick="div()">
				<form>
					<div id = "pit" style=" display: none;  width: 30%; height: 10%; position: absolute; background-color: #b4b4b4;">
						<div style="margin-left: 1%; margin-top: 1%;">
							<div>유저 번호
								<input name = "idx" type= "text" size="1"><br>
							</div>
							<div style="margin-top: 1%;">
								회원 등급 <select name = "checked">
									<option value="0">전부</option>
									<option value="1">일반회원</option>
									<option value="2">사업자회원</option>
								</select>
							</div>
							<div style="margin-top: 2%;">
								<a style="position: absolute;">
									<select name = "date">
										<option value="exit">나간날</option>
										<option value="end">종료날</option>
									</select>
									<input name = "start" type = "date"> ~ 
									<input name = "endd" type = "date">
								</a>
							</div>
						</div>
						<div style="margin-left: 1%; margin-top: 1%;">
							<div>
								폰 <input name = "phone" type= "text" size="8">
							</div>
							<div style="margin-top: 1%;">
								글 <input name = "content" type= "text" size="8">
							</div>
						</div>
						<div style="margin-left: 1%; margin-top: 1%;">이메일
							<input name = "email" type= "text" size="17">
						</div>
						<div style="position: absolute; margin-left: 90%; margin-top: 10%;">
							<input type = "button" value = "검색" onclick = "pirter(this.form)">
						</div>
					</div>
				</form>
			</div>
			 <table border="1" style="width: 65%;">
				<tr>
					<th style="width: 8.4%;">유저 번호<br>닉네임</th>
					<th style="width: 9.4%">폰</th>
					<th style="width: 15%">이메일</th>
					<th style="width: 8.1%">회원 등급</th>
					<th style="width: 12.8%">콘텐트</th>
					<th style="width: 23.1%">나간날</th>
					<th>개인정보 종료날</th>
				</tr>
			</table> 
			<table id = "maintable" border="1" width = "65%">

			</table>
			<div id = "noq" style="display: none;"><h1>리스트가 없습니다</h1></div>
		</div>
	</div>
</body>
<script type="text/javascript">

	const maintable = document.querySelector('#maintable');
	const mainDiv = document.querySelector('#mainDiv')
	const noq = document.querySelector('#noq');
	
	let sel = null
	let sell = null
	let on = false;
	function div() {
		if(on){
			document.querySelector('#pit').style.display = 'none';	
			on = false;
		}else{
			document.querySelector('#pit').style.display = 'flex';
			on = true;
		}
	}
	
	function pirter(f) {
		let idx = f.idx.value;
		let checked = f.checked.value;
		let start = Date.parse(f.start.value);
		let end = Date.parse(f.endd.value);
		let phone = f.phone.value;
		let content = f.content.value;
		let email = f.email.value;
		noq.style.display = "none";
		
		let trArr = Array.from(document.querySelectorAll('#maintable tr'))
		
		for (var i = 0; i < trArr.length; i++) {
				trArr[i].style.display = '';
				if(idx != ""){
					if(idx != trArr[i].children[0].innerText){
						trArr[i].style.display = 'none';
					}
				}
				
				if(checked != 0){
					let check = checked != 1 ? '사업자회원' : '일반회원';
					console.log(check == trArr[i].children[4].innerText)
					if(trArr[i].children[4].innerText != check){
						trArr[i].style.display = 'none';
					}	
				}
				
				if(phone != ""){
					if(!trArr[i].children[2].innerText.includes(phone)){
						trArr[i].style.display = 'none';
					}	
				}
				
				if(email != ""){
					if(trArr[i].children[3].innerText != email){
						trArr[i].style.display = 'none';
					}
				}
				
				if(content != ""){
					if(!trArr[i].children[5].innerText.includes(content)){
						trArr[i].style.display = 'none';
					}
				} 
				
				if(!isNaN(start) && !isNaN(end)){
					let choice = f.date.value;
					let index = choice == 'exit' ? 6 : 7;
					let longD = Date.parse(trArr[i].children[index].innerText.substr(0, 10).replace("년","-").replace("월", "-"))
					
					if(start > longD || end < longD){
						trArr[i].style.display = 'none';
					}
				}
				
				
			}
			
			for (var i = 0; i < trArr.length; i++) {
				
				if(trArr[i].style.display == "")return
				if(i+1 == trArr.length){
					noq.style = "";
				}
			}
		
	}
		
/* 
	        const tf = choice == '이름' || choice == '성별'; //charAt을 사용해야하는지 아닌지
			const ph = choice == '전화번호'; // replaecAll을 사용해야하는지 아닌지
	        trArr.sort((trA,trB) => {//정리된걸로 정렬시작
	
	           	
				const at = trA.children[index].innerText;
	           	const bt = trB.children[index].innerText;
	           	
	            const a = ph ? at.replaceAll("-", "") : at;
	            const b = ph ? bt.replaceAll("-", "") : bt;
	            
	            return a.age > b.age ? 1 : -1;
	        });

	        let tbody = document.getElementById("tbody");
	        tbody.innerHTML = ""; 
	        trArr.forEach(tr => tbody.appendChild(tr));
	        				
			
		} */
		
		
	
	
	
	
	
	
	
	
	
	
	
	function list(t) {
		const type = t.id;
		noq.style.display = "none";
		$.ajax({
			url:"${pageContext.request.contextPath}/secession/admin/oneType",
			type:"post",
			data:{type: type},
			success: function sc(s) {
				let newTr = null;
				maintable.innerHTML = "";
				if(s.length != 0){
					s.forEach(l => {
						newTr = document.createElement('tr');
						let addTh = [l.USERS_IDX,l.NICKNAME,l.PHONE,l.EMAIL,l.USERS_CHECK,l.C,l.DATE_EXIT,l.DATE_END]
						for (var i = 0; i < addTh.length; i++) {
							const newTd = document.createElement('td');
							switch (i) {
							case 0:
								newTd.setAttribute("width", "1%")
								break;
							case 1:
								newTd.setAttribute("width", "6%")
								break;
							case 2:
								newTd.setAttribute("width", "8%")
								break;
							case 3:
								newTd.setAttribute("width", "13%")
								break;
							case 4:
								if(addTh[i] == 0){
									addTh[i] = '일반회원';
								}else{
									addTh[i] = '사업자회원';
								}
								newTd.setAttribute("width", "7%")
								break;
							case 5:
								if(addTh[i].length == 8)addTh[i] += '...';
								newTd.setAttribute("width", "11%");
								break;
							case 6:
								newTd.setAttribute("width", "20%");
								break;
							case 7:
								newTd.setAttribute("width", "20%");
								break;
							}
								
							newTd.innerHTML = addTh[i];
							newTr.appendChild(newTd);
						}
					maintable.appendChild(newTr);
					})
				}else{
					noq.style.display = "";
				}
			}
		})
		mainDiv.style.display = "";
	}
</script>
</html>