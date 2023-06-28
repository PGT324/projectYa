<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
						<c:forEach var="vo" items="${list }">
							<form action="/pro/res/h_res" method="post">
							<div class="semi3">
							<input type="hidden" name="h_region1_idx" value="${vo.h_region1_idx }">
							<input type="hidden" name="h_region2_idx" value="${vo.h_region2_idx }">
							<input type="hidden" name="hotel_idx" value="${vo.hotel_idx }">
							<input type="hidden" name="h_room_idx" value="${vo.h_room_idx }">
							<input type="hidden" name="checkin" value="${checkin }">
							<input type="hidden" name="checkout" value="${checkout }">
							<input type="hidden" name="day_price" value="${vo.day_price }">
							<input type="hidden" name="value" value="${value }">
							<input type="hidden" name="users_idx" value="${login.users_idx }">
							<div class="card" style="width: 18rem;">
							  <img src="${vo.image }" class="card-img-top" alt="hotelimage">
							  <div class="card-body">
							    <h5 class="card-title">${vo.name }</h5>
							  </div>
							  <ul class="list-group list-group-flush">
							    <li class="list-group-item">체크인 : ${checkin }</li>
							    <li class="list-group-item">체크아웃 : ${checkout }</li>
							    <li class="list-group-item">${vo.short_info }</li>
							    <li class="list-group-item">최대 : ${vo.max_person }인</li>
							    <li class="list-group-item">인원수 : 
							    	<select name="person_size">
										<c:forEach begin="1" end="${vo.max_person }" step="1" var="i">
										<option value="${i }">${i }</option>
										</c:forEach>
									</select>
							    </li>
							    <li class="list-group-item">침대 : ${vo.bedsize }</li>
							    <li class="list-group-item">${vo.smoke }</li>
							    <li class="list-group-item">입실시간 : ${vo.entrance_time }</li>
							    <li class="list-group-item">퇴실시간 : ${vo.out_time }</li>
							    <li class="list-group-item">1박 가격 : ${vo.day_price }</li>
							    <li class="list-group-item">쿠폰선택 : 
							    	<select name="h_coupon_idx">
										<option value="0">선택안함</option> 
										<c:forEach var="vo1" items="${couponList }">
										<option value="${vo1.h_coupon_idx }">${vo1.name }</option>
										</c:forEach>
										<c:if test="${ucList != null }">
										<option value="${ucList.get(0).sale }">${ucList.get(0).name }</option>
										</c:if>
									</select>
							    </li>
							    <li class="list-group-item">사용가능 포인트 : ${value }
							    <input type="text" name="point">
							    </li>
							    <li class="list-group-item">남은 객실 수 : ${vo.room_number }</li>
							  </ul>
							  <div class="card-body">
							  <c:choose>
								<c:when test="${vo.room_number == 0}">							
									<button type="submit" class="btn btn-danger btn-rounded" style="color : white" disabled="disabled">예약하기</button>
								</c:when>
								<c:otherwise>
									<button type="submit" class="btn btn-danger btn-rounded" style="color : white">예약하기</button>
								</c:otherwise>
							  </c:choose>
							  </div>
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