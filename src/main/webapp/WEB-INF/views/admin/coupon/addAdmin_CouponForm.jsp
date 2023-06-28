<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center" style="margin-top: 7%;">
		<form>
			<table>
				<tr>
					<th colspan="3"><h1>쿠폰을 만들어 보야요</h1></th>
				</tr>
				<tr>
					<th>쿠폰이름 입력</th>
					<td><input name = "name" type = "text"></td>
					<td><input type = "checkbox" onclick="checkEvent(this)"><font size="1">난수로 아무렇게 만들기!!!</font></td>
				</tr>
				<tr>
					<th>할인 설정하기</th>
					<td><input name = "sale" type = "text"></td>
				</tr>
				<tr>
					<th>코드 설정하기</th>
					<td><input name = "code" type = "text"></td>
				</tr>
			</table>
			<input type ="button" onclick="subcheck(this.form)" value = "쿠폰 생성">
		</form>
	</div>
</body>
<script type="text/javascript">
	
		function checkEvent() {
			
		}
		
		function subcheck(f) {
			const name = f.name.value;
			const sale = f.sale.value;
			const code = f.code.value;
			
			if(name == "" || sale == "" || code == ""){
				alert('안적은것을 체크해주세요')
				return
			}
			
			f.submit();
			
			
		}
		

</script>
</html>