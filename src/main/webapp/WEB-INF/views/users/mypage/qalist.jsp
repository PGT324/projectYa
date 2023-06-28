<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="kr">
        <head>
        	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
            <meta charset="utf-8">
            <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
            <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
            <title>야놀자 | 여행의 모든 것, 한 번에 쉽게</title>
            <style>
                html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,
                blockquote,pre,abbr,address,cite,code,del,dfn,em,img,
                ins,kbd,q,samp,small,strong,sub,sup,var,b,i,dl,dt,dd,ol,ul,li,
                fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,
                article,aside,canvas,details,figcaption,figure,footer,header,hgroup,
                menu,nav,section,summary,time,mark,audio,video,fieldset {margin:0; padding:0; }


                ol,ul{list-style:none}
                li { list-style-type:none; }
                table{border-collapse:collapse;border-spacing:0;}
                img{max-width:100%;height:auto;}
                mark{background:none}
                select{max-width:100%;}
                caption, legend {display:none;}
                hr{display:none;}
                h1,h2,h3,h4,h5,h6 { font-size:100%; }
                address,strong{font-style:normal; font-weight:normal;}
                table {border-collapse:collapse; }
                input, select{outline: none;font-family:inherit}

                .hd-in {
                    font-weight : bolder;
                }
                .hd-in a {
                    text-decoration: none;
                    color : black;
                }
                .inner {
                    position : relative;
                    width : 100%;
                    height : 50px;
                }
                .hd-in {
                    display : flex;
                    justify-content: space-around;
                    margin-top : 1%;
                    border-bottom:  1px solid #E8E8E8;
                    height : 40px;
                }
                .hd-left {
                    margin-left : -3%;
                    font-size : 20px;
                }
                .hd-middle {
                    font-size : 24px;
                    margin-top : -0.3%;
                    margin-left : 6.5%;
                }
                
                .qa-one a, .qa-two a {
                    display : flex;
                    text-decoration: none;
                    color : black;
                    margin-top : 2%;
                    border-bottom : 2px solid #E7E7E7;
                    margin-left : 20%;
                    margin-right : 20%;
                    padding : 1%;
                    justify-content: space-between;
                    background-color :#F2F6FC;
                }
                .qa-one a:hover, .qa-two a:hover {
                    border-bottom : 2px solid black;
                }
                .qa-two {
                    margin-bottom : 3%;
                    
                }

            </style>
        </head>
        <body>
            <header class="header">
                <div class="inner">
                    <div class="hd-in">
                        <div class="hd-left">
                            <a href="/pro/users/mypage?users_idx=${login.users_idx }">〈 </a>
                        </div>
                        <div class="hd-middle">
                            자주 묻는 질문
                        </div>
                        <div class="hd-right">
                            <a href="/pro/"><img src="https://yaimg.yanolja.com/joy/sunny/static/images/icon-home-black-line-2.svg"></a>
                        </div>  
                    </div>
                </div>
            </header>
            <div class="main">
                <div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%; margin-top : 3%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    천재지변/기상악화로 인한 취소는 어떻게하나요?
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">천재지변 또는 기상악화로 인해 숙소 방문이 어려우실 경우
										야놀자 고객센터 카카오톡 채널 상담원 연결을 통해 문의해 주세요.<br><br>
										
										▶ 야놀자 고객센터 카카오톡 채널 > '상담원 연결하기'<br><br>
										
										※ 증빙 자료를 요청할 수 있으며, 상황에 따라 취소가 어려울 수 있습니다.<br><br>
										
										🗨️ 야놀자 고객센터 카카오톡 상담하기  
										오전 9시 ~ 다음 날 새벽 3시 / 연중무휴 </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                    		<div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    아이디,비밀번호를 잊어버렸어요.
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">환불 기간은 결제수단에 따라 영업일 기준 3~5일 소요됩니다.<br><br>
										또는 100% 수수료가 부과되어 환불금액이 0원인 경우일 수 있습니다.<br><br>
										
										정상 취소 후 환불 및 입금이 지연되는 경우 각 결제사 및 카드사로 문의 바랍니다.<br><br>
										
										※ 시일이 소요되는 경우 아래 사유를 확인해주세요.<br><br>
										- 카드결제 : 카드사의 한도복원이 필요한 경우<br><br>
										- 계좌이체 : 은행 계좌입금에 시일이 소요되는 경우<br><br>
										- 휴대폰 소액결제 : 결제월과 환불월이 다른 경우 (원결제수단으로 환불 불가하므로 야놀자 고객센터 카카오톡 채널 문의해 주세요.)<br><br>
										
										결제 수단별 취소 소요 기간 FAQ 바로가기<br><br>
										🗨️ 야놀자 고객센터 카카오톡 상담하기<br><br>
										오전 9시 ~ 다음 날 새벽 3시 / 연중무휴 </p>
								  </div>
                            </div>
                             <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    예약을 취소했는데 결제 환불이 되지 않아요.
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">환불 기간은 결제수단에 따라 영업일 기준 3~5일 소요됩니다.<br><br>

									또는 100% 수수료가 부과되어 환불금액이 0원인 경우일 수 있습니다.<br><br>
									
									정상 취소 후 환불 및 입금이 지연되는 경우 각 결제사 및 카드사로 문의 바랍니다.<br><br>
									
									※ 시일이 소요되는 경우 아래 사유를 확인해주세요.<br><br>
									- 카드결제 : 카드사의 한도복원이 필요한 경우<br><br>
									- 계좌이체 : 은행 계좌입금에 시일이 소요되는 경우<br><br>
									- 휴대폰 소액결제 : 결제월과 환불월이 다른 경우 (원결제수단으로 환불 불가하므로 야놀자 고객센터 카카오톡 채널 문의해 주세요.)<br><br>
									
									결제 수단별 취소 소요 기간 FAQ 바로가기<br><br>
									🗨️ 야놀자 고객센터 카카오톡 상담하기<br><br>
									오전 9시 ~ 다음 날 새벽 3시 / 연중무휴 </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    미성년자도 예약할 수 있나요?
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">만 19세 미만의 청소년의 경우 청소년 보호법에 의거하여 혼숙이 불가하며, 이용에 제한이 있을 수 있습니다.<br><br>

										숙소에 입실할 때 신분증 제시를 요구할 수 있으며,<br><br>
										미성년자 입실 거부 등으로 인한 취소나 환불은 불가하오니 예약 전 숙소와 이용 가능 여부를 반드시 확인해 주세요. </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    입실할 때 모바일 신분증도 사용할 수 있나요?
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">네. 허용 가능한 모바일 신분증에 한하여 사용할 수 있습니다.<br><br>

										단, 모바일 신분증의 캡처본, 사진 등은 모바일 신분증으로써 인정되지 않습니다.<br><br>
										
										[허용 가능한 모바일 신분증]<br><br>
										※정부24 앱을 통한 '주민등록증 모바일 확인서비스'<br><br> 
										※PASS 앱을 통한 '주민등록증 모바일 확인서비스' <br><br>
										※모바일 신분증 앱을 통한 '모바일 운전면허증(경찰정 발행)'<br><br>
										[허용 불가능한 모바일 신분증]   <br><br>
										※PASS 앱을 통한 '운전면허증 모바일 확인서비스'<br><br> 
										※삼성페이 앱을 통한 '운전면허증 모바일 확인서비스'<br><br>
										
										※ 더욱 안전한 확인을 위해 숙소에서 모바일 신분증 검증을 요청할 수 있습니다.</p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    로그인이 안 돼요.
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">• 간편 로그인(카카오톡/네이버)이 안될 경우<br><br>
									- 이메일/휴대폰 번호로 가입한 계정이 있는지 확인해주세요.<br><br>
									▶ 야놀자 앱 > MY 야놀자 > 설정 > 간편 로그인 > 연동 후 이용 가능합니다.<br><br>
									
									<a href="/pro/">MY 야놀자 바로가기</a><br><br>
									
									• 장기 미사용 고객일 경우<br><br>
									- 회원 가입 시 선택 약관('장기 미접속 시에도 계정 유지') 동의를 하지 않은 계정의 경우, 1년 이상 미사용 시 자동 탈퇴 처리됩니다.<br><br>
									
									※ 로그인 시 '입력한 회원정보를 다시 확인해주세요' 메세지가 확인되는 경우 정확한 정보(계정/비밀번호)를 입력해 주셨는지 확인해 주세요. </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    탈퇴하고 싶어요.
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">아래 경로를 통해 회원 탈퇴를 할 수 있습니다.<br><br>

										▶ 야놀자 앱 > MY 야놀자 > 상단 닉네임 아래 '내 정보 관리' > 회원탈퇴 </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    포인트는 어떻게 적립되나요?
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">결제 총 금액의 10%가 적립됩니다.  </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    <div>
                            <div class="dropdown" style="margin-left : 30%; padding-bottom : 50%">
                                 <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false" style="width : 60%; background-color : #F2F6FC; color : black; box-shadow : 2px 2px 2px 2px gray; border : 0px;">
								    예약자와 투숙자가 달라도 되나요?
								  </a>							
								  <div class="dropdown-menu">
								    <p class="dropdown-item">예약자와 투숙객 정보가 다르더라도 예약할 수 있습니다.<br><br>

										아래 내용을 참고하셔서 예약 진행 부탁드립니다. <br><br>
										
										• 예약자 정보 : 예약 완료 후 메시지와 예약확인서를 전달 받는 분의 정보를 입력 <br><br>
										
										• 투숙객 정보 : 실제 숙소를 이용해주시는 분의 정보를 입력 <br><br>
										
										※ 투숙객 정보는 숙소를 이용하는 분의 여권 이름과 반드시 동일한 영문 성/이름을 입력해주셔야 숙소 이용이 가능합니다. </p>
								  </div>
                            </div>
                            <div class="qo-two">
                                <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-arrow-small-black.svg">
                            </div>
                    </div>
                    
                </div>
                
            </div>
        </body>
    </html>