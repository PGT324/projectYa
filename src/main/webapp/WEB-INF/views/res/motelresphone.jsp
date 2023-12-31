<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
                <div class="semi">
                     <div align="center">
						<c:choose>
						<c:when test="${empty list }">
							<h2>예약 내역이 없습니다!</h2>
						</c:when>
						<c:otherwise>
						<c:forEach var="vo" items="${list}" varStatus="status">
							<div class="card" style="width: 18rem;">
								<div class="card-body">
								    <h5 class="card-title">숙소 이름 : ${motelName[status.index] }</h5>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">예약자 이름 : ${vo.res_name }</li>
							    <li class="list-group-item">예약자 전화번호 : ${vo.res_phone }</li>
							    <li class="list-group-item">이용자 이름 : ${vo.use_name }</li>
							    <li class="list-group-item">이용자 전화번호 : ${vo.use_phone }</li>
							    <li class="list-group-item">체크인 : ${vo.checkin }</li>
							    <li class="list-group-item">체크아웃 : ${vo.checkout }</li>
							    <li class="list-group-item">가격 : ${vo.total_price }</li>
							    <li class="list-group-item">예약날짜 : ${vo.regdate }</li>
							  </ul>
							  <div class="card-body">
							    <input type="button" value="객실정보 확인하기" onclick="document.location.href='/pro/res/motelroominfo?m_region1_idx=${vo.m_region1_idx}&m_region2_idx=${vo.m_region2_idx }&motel_idx=${vo.motel_idx }&m_room_idx=${vo.m_room_idx }&m_res_idx=${vo.m_res_idx }'">
							  </div>
							  <c:choose>
							  <c:when test="${check == 1 }">
							  <div class="card-body">
							    <input type="button" value="예약 취소하기" onclick="document.location.href='/pro/mdelete?users_idx=${login.users_idx}&m_res_idx=${vo.m_res_idx }'">
							  </div>
							  </c:when>
							  <c:otherwise>
							  <div class="card-body">
							    <input type="button" value="예약 취소하기" onclick="#" disabled="disabled">
							  </div>
							  </c:otherwise>
							  </c:choose>
							  <p>※예약 취소는 체크인 2일전까지 가능합니다!</p>
							</div>
						</c:forEach>
						</c:otherwise>
						</c:choose>
						</div>
                </div>
            </div>
        </body>
    </html>
</DoCTYPE>
