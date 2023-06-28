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
					  $('#summernote').summernote('disable');
					});
				</script>
                <div class="semi">
                     <div align="center">
						<ul class="list-group" style="width : 60%">
						  <li class="list-group-item">제목 : ${list.get(0).title }</li>
						  <li class="list-group-item">작성자 : ${list.get(0).nickname }</li>
						  <li class="list-group-item">방 등급 : ${list.get(0).grade }</li>
						  <li class="list-group-item">숙소 이름 : ${list.get(0).name }</li>
						  <li class="list-group-item">친절도 : ${list.get(0).kind }점  / 청결도 : ${list.get(0).clean }점  / 편의성 : ${list.get(0).convinience }점  / 접근성 : ${list.get(0).location }점</li>
						  <li class="list-group-item">작성 일자 : ${list.get(0).regdate }</li>
						  <li class="list-group-item">
						<textarea id="summernote" name="content">${list.get(0).content }</textarea>
						  </li>
						 </ul>
					</div>
                </div>
            </div>
              </body>
    </html>
</DoCTYPE>