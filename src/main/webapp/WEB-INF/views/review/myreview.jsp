<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
                <div class="semi">
                     <div align="center">
                     	<ul class="list-group" style="width : 50%">
                     	<p>모텔 리뷰</p>
						  	<c:choose>
		                     	<c:when test="${empty list1 }">
		                     	
		                     		<h3>작성한 후기가 없습니다!</h3>

		                     	</c:when>
		                     	<c:otherwise>
								<c:forEach var="vo" items="${list1 }">
								<li class="list-group-item">
										<h3>제목</h3>
										<p><a class="nav-link active" href="/pro/review/reviewDetailM?m_review_idx=${vo.m_review_idx }">${vo.title }</a></p>		
								<button type="button" class="btn btn-danger" style="width : 10%" onclick="document.location.href='/pro/review/mupdate?m_review_idx=${vo.m_review_idx}&users_idx=${login.users_idx }'">수정</button>
								<button type="button" class="btn btn-secondary" style="width : 10%" onclick="document.location.href='/pro/review/mdelete?m_review_idx=${vo.m_review_idx}&users_idx=${login.users_idx }'">삭제</button>
								</li>
								</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
						<br><br>
						<ul class="list-group" style="width : 50%">
						<p>호텔 리뷰</p>
						  	<c:choose>
		                     	<c:when test="${empty list2 }">
		                     		<h3>작성한 후기가 없습니다!</h3>
		                     	</c:when>
		                     	<c:otherwise>
								<c:forEach var="vo" items="${list2 }">
								<li class="list-group-item">
										<h3>제목</h3>
										<p><a class="nav-link active" href="/pro/review/reviewDetailH?h_review_idx=${vo.h_review_idx }">${vo.title }</a></p>		
								<button type="button" class="btn btn-danger" style="width : 10%" onclick="document.location.href='/pro/review/hupdate?h_review_idx=${vo.h_review_idx}&users_idx=${login.users_idx }'">수정</button>
								<button type="button" class="btn btn-secondary" style="width : 10%" onclick="document.location.href='/pro/review/hdelete?h_review_idx=${vo.h_review_idx}&users_idx=${login.users_idx }'">삭제</button>
								</li>
								
								</c:forEach>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
                </div>
            </div>
         </body>
    </html>
</DoCTYPE>