<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
				  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
				  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
				 <script>
					$(document).ready(function() {
					  $('#summernote').summernote({
					        minHeight: 370,
					        maxHeight: 370,
					        focus: true, 
					        lang : 'ko-KR'
					        	
					  });
					});
				</script>
                <div class="semi">
                     <div align="center">
                     <form action="/pro/motelReviewInsert" method="post">
                     <input type="hidden" name="m_region1_idx" value="${list.get(0).m_region1_idx }">
                     <input type="hidden" name="m_region2_idx" value="${list.get(0).m_region2_idx }">
                     <input type="hidden" name="motel_idx" value="${list.get(0).motel_idx }">
                     <input type="hidden" name="m_room_idx" value="${list.get(0).m_room_idx }">
                     <input type="hidden" name="users_idx" value="${login.users_idx }">
                     <input type="hidden" name="name" value="${list1.get(0).name }">
                     <input type="hidden" name="grade" value="${list.get(0).name }">
                     <input type="hidden" name="resdate" value="${list2.get(0).regdate }">
                     <input type="hidden" name="nickname" value="${login.nickname }">
                     	<table border="1">
                     		<tr>
                     			<th colspan="4">숙소 이름 : ${list1.get(0).name }</th>
                     		</tr>
                     		<tr>
                     			<th colspan="4">객실 등급 : ${list.get(0).name }</th>
                     		</tr>
                     		<tr>
                     			<th colspan="4">예약 날짜 : ${list2.get(0).regdate }</th>
                     		</tr>
                     		<tr>
                     			<th colspan="4">예약자 닉네임 : ${login.nickname }</th>
                     		</tr>
                     		<tr>
                     			<th>제목</th>
                     			<th colspan="3"><input type="text" name="title" required="required"></th>
                     		</tr>
                     		<tr>
                     			<th colspan="4">
                     				<textarea id="summernote" name="content"></textarea>
                     			</th>
                     		</tr>
                     		<tr>
                     			<th>친절도 : 
                     				<select name="kind">
                     					<option value="1">1</option>
                     					<option value="2">2</option>
                     					<option value="3">3</option>
                     					<option value="4">4</option>
                     					<option value="5">5</option>
                     				</select>
                     			</th>
            					<th>청결도 : 
                     				<select name="clean">
                     					<option value="1">1</option>
                     					<option value="2">2</option>
                     					<option value="3">3</option>
                     					<option value="4">4</option>
                     					<option value="5">5</option>
                     				</select>
                     			</th>
                     			<th>편의성 : 
                     				<select name="convinience">
                     					<option value="1">1</option>
                     					<option value="2">2</option>
                     					<option value="3">3</option>
                     					<option value="4">4</option>
                     					<option value="5">5</option>
                     				</select>
                     			</th>
                     			<th>접근성 : 
                     				<select name="location">
                     					<option value="1">1</option>
                     					<option value="2">2</option>
                     					<option value="3">3</option>
                     					<option value="4">4</option>
                     					<option value="5">5</option>
                     				</select>
                     			</th>
                     		</tr>
                     		<tr>
                     			<th colspan="4">
                     				<input type="submit" value="리뷰작성하기">
                     			</th>
                     		</tr>                     		
                     	</table>
                     	</form>
                     </div>
                </div>
            </div>
         </body>
    </html>
</DoCTYPE>