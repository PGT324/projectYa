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
                     <form action="/pro/review/muresult?m_review_idx=${list.get(0).m_review_idx }" method="post">
                     	<table border="1">
                     			<th>제목</th>
                     			<th colspan="3"><input type="text" name="title" value="${list.get(0).title }" required="required"></th>
                     		</tr>
                     		<tr>
                     			<th colspan="4">
                     				<textarea id="summernote" name="content">${list.get(0).content }</textarea>
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
                     				<input type="submit" value="리뷰 수정하기">
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