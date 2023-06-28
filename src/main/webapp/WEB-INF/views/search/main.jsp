<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
                <div class="semi">	
					<form action="/pro/search/list" method="post" style="width : 30%; margin-left : 33%" >
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <button class="btn btn-outline-secondary" type="submit" id="button-addon1">🔍</button>
					  </div>
					  <input type="text" name="search" class="form-control" placeholder="이름을 입력해주세요!" aria-label="Example text with button addon" aria-describedby="button-addon1">
					</div>
					</form>
                </div>
            </div>
        </body>
    </html>
</DoCTYPE>

