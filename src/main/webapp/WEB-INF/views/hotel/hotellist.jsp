<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
				<script type="text/javascript">
					function move(e) {
						let a = (e.target.value - 1) * -1500;
						document.querySelector('.semi2').style.transform = "translateX(" + a + "px)";
					}
				</script>
                <div class="semi">
                			<c:choose>
                			<c:when test="${fn:length(list)%3 == 0 }">
                			<c:forEach begin="1" end="${fn:length(list)/3 }" step="1" var="i">
                			<input type="button" class="btn btn-outline-danger" onclick="move(event)" value="${i }"></button>
							</c:forEach>
                			</c:when>
                			<c:otherwise>
                			<c:forEach begin="1" end="${fn:length(list)/3 + 1 }" step="1" var="i">
                			<input type="button" class="btn btn-outline-danger" onclick="move(event)" value="${i }"></button>
							</c:forEach>
							</c:otherwise>
							</c:choose>
					  <div class="semi2" align="center">
						<c:forEach var="vo" items="${list }" varStatus="status">
							<form action="/pro/hotel/checkdate" method="post">
							<div class="semi3">
							<input type="hidden" name="h_region1_idx" value="${vo.h_region1_idx }">
							<input type="hidden" name="h_region2_idx" value="${vo.h_region2_idx }">
							<input type="hidden" name="hotel_idx" value="${vo.hotel_idx }">
							<input type="hidden" name="max_date" value="${vo.max_date }">
							<input type="hidden" name="users_idx" value="${login.users_idx }">
							<div class="card" style="width: 18rem;">
							  <img src="${vo.image }" class="card-img-top" alt="hotelimage" onclick="window.open('/pro/hotel/theme?hotel_idx=${vo.hotel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')">
							  <div class="mid">
							  	<div class="img-one"><img src="https://www.nugu.co.kr/static/nugu_candle/src/images/station-button.png" onclick="window.open('/pro/hotel/theme?hotel_idx=${vo.hotel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')"/></div>
							  </div>
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							    <p class="card-text"><a href="/pro/map/hotelmain?short_address=${vo.short_address }">${vo.short_address }</a></p>
							  	<p class="card-text">별점 : ${star[status.index] }</p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">${vo.event }</li>
							    <li class="list-group-item">최대 연박 일수 : ${vo.max_date }</li>
							    <li class="list-group-item"><input type="date" name="checkin" required="required" ></li>
							    <li class="list-group-item"><input type="date" name="checkout" required="required"></li>
							  </ul>
							  <div class="card-body" >
							    <button type="submit" class="btn btn-danger btn-rounded" style="color : white">예약 가능한 방 검색</button>
							  </div>
							  <c:choose>
							  <c:when test="${vo.heart == 1 }">
							  <input type="button" class="heart" value="♥" onclick="document.location.href='/pro/mylikedeletehotel?h_region1_idx=${vo.h_region1_idx }&h_region2_idx=${vo.h_region2_idx }&hotel_idx=${vo.hotel_idx }&users_idx=${login.users_idx}'">
							  </c:when>
							  <c:otherwise>
							  <input type="button" class="heart" value="♡" onclick="document.location.href='/pro/mylikehotel?h_region1_idx=${vo.h_region1_idx }&h_region2_idx=${vo.h_region2_idx }&hotel_idx=${vo.hotel_idx }&users_idx=${login.users_idx}'">
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