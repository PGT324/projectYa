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
                			<c:when test="${size%3 == 0 }">
                			<c:forEach begin="1" end="${size/3 }" step="1" var="i">
                			<input type="button" class="btn" id="button${i }" onclick="move(event)" value="${i }"></button>
							</c:forEach>
                			</c:when>
                			<c:otherwise>
                			<c:forEach begin="1" end="${size/3 + 1 }" step="1" var="i">
                			<input type="button" class="btn" id="button${i }" onclick="move(event)" value="${i }"></button>
							</c:forEach>
							</c:otherwise>
							</c:choose>
					<c:choose>
					<c:when test="${size < 2 }">
					<div class="semi2" style="margin-left : 33%">
						<c:forEach var="vo" items="${list1 }" >
							<form action="/pro/motel/checkdate" method="post">
							<div class="semi3">
							<input type="hidden" name="m_region1_idx" value="${vo.m_region1_idx }">
							<input type="hidden" name="m_region2_idx" value="${vo.m_region2_idx }">
							<input type="hidden" name="motel_idx" value="${vo.motel_idx }">
							<input type="hidden" name="max_date" value="${vo.max_date }">
							<input type="hidden" name="users_idx" value="${login.users_idx }">
							<div class="card" style="width: 18rem;">
							  <img src="${vo.image }" class="card-img-top" alt="motelimage" onclick="window.open('/pro/motel/theme?motel_idx=${vo.motel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')">
							  <div class="mid">
							  	<div class="img-one"><img src="https://www.nugu.co.kr/static/nugu_candle/src/images/station-button.png" onclick="window.open('/pro/motel/theme?motel_idx=${vo.motel_idx}', '_blank','location=no,status=no,scrollbars=yes, width=600,height=300')"/></div>
							  </div>
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							    <p class="card-text"><a href="/pro/map/motelmain?short_address=${vo.short_address }">${vo.short_address }</a></p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">${vo.event }</li>
							    <li class="list-group-item">최대 연박 일수 : ${vo.max_date }</li>
							    <li class="list-group-item"><input type="date" name="checkin" required="required" ></li>
							    <li class="list-group-item"><input type="date" name="checkout" required="required"></li>
							  </ul>
							  <div class="card-body">
							    <input type="submit" value="예약 가능한 방 검색">
							  </div>
							  <c:choose>
							  <c:when test="${vo.heart == 1 }">
							  <input type="button" class="heart" value="♥">
							  </c:when>
							  <c:otherwise>
							  <input type="button" class="heart" value="♡">
							  </c:otherwise>
							  </c:choose>
							</div>
							</div>
							</form>
						</c:forEach>
						<c:forEach var="vo" items="${list2 }" >
							<form action="/pro/hotel/checkdate" method="post">
							<div class="semi3">
							<input type="hidden" name="h_region1_idx" value="${vo.h_region1_idx }">
							<input type="hidden" name="h_region2_idx" value="${vo.h_region2_idx }">
							<input type="hidden" name="hotel_idx" value="${vo.hotel_idx }">
							<input type="hidden" name="max_date" value="${vo.max_date }">
							<div class="card" style="width: 18rem;">
							  <img src="${vo.image }" class="card-img-top" alt="hotelimage" onclick="window.open('/pro/hotel/theme?hotel_idx=${vo.hotel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')">
							  <div class="mid">
							  	<div class="img-one"><img src="https://www.nugu.co.kr/static/nugu_candle/src/images/station-button.png" onclick="window.open('/pro/hotel/theme?hotel_idx=${vo.hotel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')"/></div>
							  </div>
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							    <p class="card-text"><a href="/pro/map/hotelmain?short_address=${vo.short_address }">${vo.short_address }</a></p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">${vo.event }</li>
							    <li class="list-group-item">최대 연박 일수 : ${vo.max_date }</li>
							    <li class="list-group-item"><input type="date" name="checkin" required="required" ></li>
							    <li class="list-group-item"><input type="date" name="checkout" required="required"></li>
							  </ul>
							  <div class="card-body">
							    <input type="submit" value="예약 가능한 방 검색">
							  </div>
							  <c:choose>
							  <c:when test="${vo.heart == 1 }">
							  <input type="button" class="heart" value="♥">
							  </c:when>
							  <c:otherwise>
							  <input type="button" class="heart" value="♡">
							  </c:otherwise>
							  </c:choose>
							</div>
							</div>
							</form>
						</c:forEach>				
                    </div>
					</c:when>
					<c:otherwise>
                    <div class="semi2" align="center">
						<c:forEach var="vo" items="${list1 }" >
							<form action="/pro/motel/checkdate" method="post">
							<div class="semi3">
							<input type="hidden" name="m_region1_idx" value="${vo.m_region1_idx }">
							<input type="hidden" name="m_region2_idx" value="${vo.m_region2_idx }">
							<input type="hidden" name="motel_idx" value="${vo.motel_idx }">
							<input type="hidden" name="max_date" value="${vo.max_date }">
							<input type="hidden" name="users_idx" value="${login.users_idx }">
							<div class="card" style="width: 18rem;">
							  <img src="${vo.image }" class="card-img-top" alt="motelimage" onclick="window.open('/pro/motel/theme?motel_idx=${vo.motel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')">
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							    <p class="card-text"><a href="/pro/map/motelmain?short_address=${vo.short_address }">${vo.short_address }</a></p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">${vo.event }</li>
							    <li class="list-group-item">최대 연박 일수 : ${vo.max_date }</li>
							    <li class="list-group-item"><input type="date" name="checkin" required="required" ></li>
							    <li class="list-group-item"><input type="date" name="checkout" required="required"></li>
							  </ul>
							  <div class="card-body">
							    <input type="submit" value="예약 가능한 방 검색">
							  </div>
							  <c:choose>
							  <c:when test="${vo.heart == 1 }">
							  <input type="button" class="heart" value="♥">
							  </c:when>
							  <c:otherwise>
							  <input type="button" class="heart" value="♡">
							  </c:otherwise>
							  </c:choose>
							</div>
							</div>
							</form>
						</c:forEach>
						<c:forEach var="vo" items="${list2 }" >
							<form action="/pro/hotel/checkdate" method="post">
							<div class="semi3">
							<input type="hidden" name="h_region1_idx" value="${vo.h_region1_idx }">
							<input type="hidden" name="h_region2_idx" value="${vo.h_region2_idx }">
							<input type="hidden" name="hotel_idx" value="${vo.hotel_idx }">
							<input type="hidden" name="max_date" value="${vo.max_date }">
							<div class="card" style="width: 18rem;">
							  <img src="${vo.image }" class="card-img-top" alt="hotelimage" onclick="window.open('/pro/hotel/theme?hotel_idx=${vo.hotel_idx}', '_blank','location=no,status=no,scrollbars=yes,width=600,height=300')">
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							    <p class="card-text"><a href="/pro/map/hotelmain?short_address=${vo.short_address }">${vo.short_address }</a></p>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">${vo.event }</li>
							    <li class="list-group-item">최대 연박 일수 : ${vo.max_date }</li>
							    <li class="list-group-item"><input type="date" name="checkin" required="required" ></li>
							    <li class="list-group-item"><input type="date" name="checkout" required="required"></li>
							  </ul>
							  <div class="card-body">
							    <input type="submit" value="예약 가능한 방 검색">
							  </div>
							  <c:choose>
							  <c:when test="${vo.heart == 1 }">
							  <input type="button" class="heart" value="♥">
							  </c:when>
							  <c:otherwise>
							  <input type="button" class="heart" value="♡">
							  </c:otherwise>
							  </c:choose>
							</div>
							</div>
							</form>
						</c:forEach>				
                    </div>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </body>
    </html>
</DoCTYPE>