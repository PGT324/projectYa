<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
				<script type="text/javascript">
					function move(e) {
						let a = (e.target.value - 1) * -1500;
						let b = e.target.value;
						document.querySelector('.semi2').style.transform = "translateX(" + a + "px)";
					}
				</script>
                <div class="semi">
                			<c:choose>
                			<c:when test="${fn:length(list)%3 == 0 }">
                			<c:forEach begin="1" end="${fn:length(list)/3 }" step="1" var="i">
                			<input type="button" class="btn btn-outline-danger" id="button${i }" onclick="move(event)" value="${i }"></button>
							</c:forEach>
                			</c:when>
                			<c:otherwise>
                			<c:forEach begin="1" end="${fn:length(list)/3 + 1 }" step="1" var="i">
                			<input type="button" class="btn btn-outline-danger" id="button${i }" onclick="move(event)" value="${i }"></button>
							</c:forEach>
							</c:otherwise>
							</c:choose>
                    <div class="semi2" align="center">
						<c:forEach var="vo" items="${list }" varStatus="status" >
							<form action="/pro/motel/checkdate" method="post">
							<div class="semi3">
							<input type="hidden" name="m_region1_idx" value="${vo.m_region1_idx }">
							<input type="hidden" name="m_region2_idx" value="${vo.m_region2_idx }">
							<input type="hidden" name="motel_idx" value="${vo.motel_idx }">
							<input type="hidden" name="max_date" value="${vo.max_date }">
							<input type="hidden" name="users_idx" value="${login.users_idx }">
							<div class="card" style="width: 18rem;">
							 
							  <img src="${vo.image }" class="card-img-top" alt="motelimage" onclick="window.open('/pro/motel/theme?motel_idx=${vo.motel_idx}', '_blank','location=no,status=no,scrollbars=yes, width=600,height=300')">
							  <div class="mid">
							  	<div class="img-one"><img src="https://www.nugu.co.kr/static/nugu_candle/src/images/station-button.png" onclick="window.open('/pro/motel/theme?motel_idx=${vo.motel_idx}', '_blank','location=no,status=no,scrollbars=yes, width=600,height=300')"/></div>
							  </div>
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							    <p class="card-text"><a href="/pro/map/motelmain?short_address=${vo.short_address }">${vo.short_address }</a></p>
							    <p class="card-text">별점 : ${star[status.index] }</p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">${vo.event }</li>
							    <li class="list-group-item">최대 연박 일수 : ${vo.max_date }</li>
							    <li class="list-group-item"><input type="date" name="checkin" required="required" ></li>
							    <li class="list-group-item"><input type="date" name="checkout" required="required"></li>
							  </ul>
							  <div class="card-body">
							    <button type="submit" class="btn btn-danger btn-rounded" style="color : white">예약 가능한 방 검색</button>
							  </div>
							  <c:choose>
							  <c:when test="${vo.heart == 1 }">
							  <input type="button" class="heart" value="♥" onclick="document.location.href='/pro/mylikedeletemotel?m_region1_idx=${vo.m_region1_idx }&m_region2_idx=${vo.m_region2_idx }&motel_idx=${vo.motel_idx }&users_idx=${login.users_idx}'">
							  </c:when>
							  <c:otherwise>
							  <input type="button" class="heart" value="♡" onclick="document.location.href='/pro/mylikemotel?m_region1_idx=${vo.m_region1_idx }&m_region2_idx=${vo.m_region2_idx }&motel_idx=${vo.motel_idx }&users_idx=${login.users_idx}'">
							  </c:otherwise>
							  </c:choose>
							</div>
							</div>
							</form>
						</c:forEach>		
                    </div>
                    
                </div>
            </div>
        </body>
    </html>
</DoCTYPE>