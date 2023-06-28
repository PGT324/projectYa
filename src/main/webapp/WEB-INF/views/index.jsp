<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
                <div class="semi" style="height: 120%">
               
                <!-- 이미지 메인 -->
                     <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="height : 800px; width : 80%; margin-left : 150px; margin-top : 5%;">
					  <div class="carousel-inner">
					    <div class="carousel-item active" style="height : 100%; width : 100%;">
					      <img src="https://play-lh.googleusercontent.com/qvVglAwLoIQWIcoF6lTBmJtLUMG1IEJ2Cx4lSxFw9J4L8bKqgjXtKPPO4rLrKwBNxg=h500" class="d-block w-100" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img src="https://i.ytimg.com/vi/yfsQXyTGoiY/maxresdefault.jpg" class="d-block w-100" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img src="https://i.ytimg.com/vi/0-m9HKQ4YeI/maxresdefault.jpg" class="d-block w-100" alt="...">
					    </div>
					  </div>
					 <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </button>
					  <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </button>
					</div>
					 <!-- 문의사항 네비 -->
					 <c:choose>
                            <c:when test="${login == null }">
                            <div class="qalist">
		                        <a href="${pageContext.request.contextPath }/users/login">
		                            <img class="qaimg" src="https://business.yanolja.com/common/kr/web/img/quick-open-img2.png">
		                            <img src="https://business.yanolja.com/common/kr/web/img/main-quick-off.png">
		                            
		                        </a>
		                     </div>
                            </c:when>
                            <c:otherwise>
                             <div class="qalist">
		                        <a href="${pageContext.request.contextPath }/users/chat">
		                            <img class="qaimg" src="https://business.yanolja.com/common/kr/web/img/quick-open-img2.png">
		                            <img src="https://business.yanolja.com/common/kr/web/img/main-quick-off.png">
		                            
		                        </a>
		                     </div>
                            </c:otherwise>
                            </c:choose>
                </div>
            </div>
            <div class="foot-fix">
    <div class="ff-inner">
        <div class="ff-one">
            <div class="fo-loca">
                <a href="${pageContext.request.contextPath }${login == null ? "/users/login" : "/region/motelregion1"}">
                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-location-empty.svg">
                    <div class="loca-name">지역</div>
                </a>
            </div>
            <c:choose>
	            <c:when test="${login == null }">
		            <div class="fo-search">
	                <a href="${pageContext.request.contextPath }/users/login">
	                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-nearme-empty.svg">
	                    <div class="my-name">검색</div>
	                </a>
	            	</div>
	            </c:when>
	            <c:otherwise>
	              	<div class="fo-search">
	                <a href="${pageContext.request.contextPath }/search">
	                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-nearme-empty.svg">
	                    <div class="my-name">검색</div>
	                </a>
	            	</div>
	            </c:otherwise>
            </c:choose>  
        </div>
        <div class="ff-two">
            <c:choose>
	            <c:when test="${login == null }">
		            <div class="ft-like">
	                <a href="${pageContext.request.contextPath }/users/login">
	                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-favorite-empty.svg">
	                    <div class="like-name">찜</div>
	                </a>
	            	</div>
	            </c:when>
	            <c:otherwise>
	              	<div class="ft-like">
	                <a href="/pro/like/mylike?users_idx=${login.users_idx }">
	                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-favorite-empty.svg">
	                    <div class="like-name">찜</div>
	                </a>
	            	</div>
	            </c:otherwise>
            </c:choose>
            <c:choose>
	            <c:when test="${login == null }">
		            <div class="ft-my">
	                <a href="${pageContext.request.contextPath }/users/login">
	                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-my-empty.svg">
	                    <div class="my-name">마이</div>
	                </a>
	            	</div>
	            </c:when>
	            <c:otherwise>
	              	<div class="ft-my">
	                <a href="${pageContext.request.contextPath }/users/mypage?users_idx=${login.users_idx}">
	                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-my-empty.svg">
	                    <div class="my-name">마이</div>
	                </a>
	            	</div>
	            </c:otherwise>
            </c:choose>  
        </div>
        <div class="ya-logo">
            <div class="most-logo">
                <a href="/pro/">
                    <img src="https://yaimg.yanolja.com/joy/sunny/static/images/gnb/icon-home-fill.svg">
                </a>
            </div>
        </div>
    </div>
</div>
            <div class="footer">
                <div class="foot-top">
                    <div class="ft-main">
                        <div class="ft-left">
                            <img src ="https://yaimg.yanolja.com/joy/sunny/static/images/ico-logo-gray.svg"/>
                        </div>
                     
                    </div>
                        <div class="companyInfo">
                            (주)야놀자 |대표이사 : 이수진, 김종윤, 배보찬 | 사업자 등록번호 : 220-87-42885 | 통신판매업신고 : 강남-14211호 | 메일 : help@yanolja.com<br>
                            관광사업자 등록번호 : 제2016-31호 | 주소 : 서울특별시 강남구 테헤란로108길 42 | 호스팅서비스 제공자 : 주식회사 야놀자<br>
                            고객센터 : 1644-1346 (오전 9시 - 익일 새벽 3시)
                        </div>
                        <ul class="homepInfo" >
                            <li>
                                <a href="https://yanolja.in/" target="_blank">회사소개</a>
                            </li>
                            <li>
                                <a href="https://ad.yanolja.com/intro" target="_blank">광고제휴문의</a>
                            </li>
                            <li>
                                <a href="https://careers.yanolja.co/" target="_blank">인재채용</a>
                            </li>
                            <li>
                                <a href="https://m.policy.yanolja.com/policy/?t=privacy&d=m" target="_blank">개인정보처리방침</a>
                            </li>
                            <li>
                                <a href="https://policy.yanolja.com/policy/?t=youth" target="_blank">청소년 보호 정책</a>
                            </li>
                            <li>
                                <a href="https://m.policy.yanolja.com/pf/policy/service?t=service&d=m" target="_blank">서비스 이용약관</a>
                            </li>
                            <li>
                                <a href="https://m.policy.yanolja.com/policy/?t=location&d=m" target="_blank">위치정보이용약관</a>
                            </li>
                            <li>
                                <a href="https://www.ftc.go.kr/bizCommPop.do?wrkr_no=2208742885&apv_perm_no=">사업자 정보확인</a>
                            </li>
                            <li>
                                <a href="https://policy.yanolja.com/policy/?t=terms-eft">전자금융거래 이용약관</a>
                            </li>
                            <li>
                                <a href="https://policy.yanolja.com/policy/?t=notes-eft">전자금융거래 이용자 유의사항</a>
                            </li>
                        </ul>
                        <div class="ft-right">
                            <form class="foot-form">
                                <select name="site" onchange="window.open(value,'_blank');">
                                    <option>
                                        패밀리사이트
                                    </option>
                                    <option value="https://business.yanolja.com/web/kr/index">
                                        비지니스사이트
                                    </option>
                                    <option value="https://partner.yanolja.com/intro">
                                        파트너센터
                                    </option>
                                    <option value="https://www.hotelup.com/">
                                        호텔업
                                    </option>
                                    <option value="https://ad.yanolja.com/intro">
                                        야놀자 광고센터
                                    </option>
                                    <option value="https://home.nowwaiting.co/">
                                        나우웨이팅
                                    </option>
                                    <option value="https://www.dodopoint.com/">
                                        도도포인트
                                    </option>
                                </select>
                            </form>
                        </div>
                        <div class="sns-link">
                            <a href="https://www.instagram.com/yanolja.official/" class="instalink">야놀자 인스타</a>
                            <a href="https://www.youtube.com/user/yanoljamedia" class="youtubelink">야놀자 유튜브</a>
                            <a href="https://www.facebook.com/yanolja/?fref=ts" class="fblink">야놀자 페북</a>
                            <a href="https://blog.naver.com/yanolog" class="bloglink">야놀자 블로그</a>
                            <a href="https://post.naver.com/my.nhn?memberNo=2768780" class="postlink">야놀자 포스트</a>
                        </div>
                        <div class="yaInfo">
                            (주) 야놀자는 통신판매 중개자로서 통신판매의 당사자가 아니며 상품의 예약, 이용 및 환불 등과 관련한 의무와 책임은 각 판매자에게 있습니다.<br><br>(주)야놀자가 소유/운영/관리하는 웹사이트 및 앱 내의 상품/판매자/이벤트 정보, 디자인 및 화면의 구성, UI를 포함하여 일체의 콘텐츠에 대한 무단 복제, 배포, 방송 또는 전송, 스크래핑 등의 행위는 저작권법 및 콘텐츠산업 진흥법 등 관련 법령에 의하여 엄격히 금지 됩니다.
                        </div>
                        <div class="lawInfo">
                            <button onclick="window.open('https://www.yanolja.com/popup/contents-law','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">콘텐츠산업 진흥법에 따른 표시</button>
                        </div>
                        <div class="reward-tab">
                            <ul class="reward">
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-07.svg" width="36" height="36" alt="정보보호관리체계인증 ISMS">
                                    <div class="r1">
                                        정보보호관리체계인증<br>ISMS
                                    </div>
                                </li>
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-08.svg" width="36" height="36" alt="공정거래위원회 CCM인증">
                                    <div class="r2">
                                        공정거래위원회 인증<br>소비자중심경영(CCM)
                                    </div>
                                </li>
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-09.svg" width="45" height="31" alt="하이서울브랜드">
                                    <div class="r3">
                                        2017하이서울<br>브랜드 선정
                                    </div>
                                </li>
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-10.svg" width="36" height="36" alt="2017브랜드스타">
                                    <div class="r4">
                                        2017브랜드스타<br>숙박앱 부문1위
                                    </div>
                                </li>
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-11.svg" width="26" height="36" alt="2016모바일어워드코리아">
                                    <div class="r5">
                                        2016모바일어워드코리아<br>숙박정보부문 대상
                                    </div>
                                </li>
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-12.svg" width="36" height="36" alt="2015앱어워드코리아">
                                    <div class="r6">
                                        2015앱어워드코리아<br>숙박정보부문 대상
                                    </div>
                                </li>
                                <li>
                                    <img class="PageFooterAwardItem_logo__2epBa" src="//yaimg.yanolja.com/joy/sunny/static/images/footer/img-award-13.svg" width="36" height="36" alt="2015대한민국마케팅">
                                    <div class="r7">
                                        2015대한민국<br>마케팅대상 최우수상
                                    </div>
                                </li>
                            </ul>
                        </div>
                </div>
            </div>
        </body>
    </html>
</DoCTYPE>
