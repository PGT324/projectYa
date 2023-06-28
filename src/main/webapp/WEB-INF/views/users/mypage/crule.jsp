<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="kr">
        <head>
            <meta charset="utf-8">
            <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
            <title>야놀자 : 대한민국 대표 종합 숙박어플</title>

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
                    font-weight : bold;
                    font-size: 22px;
                    display : flex;
                    justify-content: space-between;
                    margin-top : 0.5%;
                }
                .inner {
                    position : relative;
                    width : 100%;
                    height : 50px;
                }
                .hd-left {
                    margin-left : 25%;
                }
                .hd-right {
                    margin-right : 45%;
                }
                .main-rule {
                    margin-left : 20%;
                    margin-right : 20%;
                    color : #818181;
                    font-size : 15px;
                }
                .mrle {
                    font-size : 16px;
                    color : black;
                    font-weight: bold;
                    
                }
                h3 {
                    color : black;
                }
            </style>
        </head>
        <body>
            <header class="header">
                <div class="inner">
                    <div class="hd-in">
                        <div class="hd-left">
                            <a href="/pro/users/mypage/coupon?users_idx=${login.users_idx }"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxwYXRoIGZpbGwtcnVsZT0iZXZlbm9kZCIgZD0iTTE4LjM2NCA0LjIyMkwxOS43NzggNS42MzYgMTMuNDE0IDEyIDE5Ljc3OCAxOC4zNjQgMTguMzY0IDE5Ljc3OCAxMiAxMy40MTQgNS42MzYgMTkuNzc4IDQuMjIyIDE4LjM2NCAxMC41ODYgMTIgNC4yMjIgNS42MzYgNS42MzYgNC4yMjIgMTIgMTAuNTg2eiIvPgo8L3N2Zz4K"></a>
                        </div>
                        <div class="hd-right">
                            쿠폰 정책
                        </div>
                    </div>
                </div>
            </header>
            <div class="main">
                <div class="main-rule">
                    <span class="mrle">1. 쿠폰이란?</span><br><br>
                    • 쿠폰은 “회원”이 해당 숙소, 레저 및 교통 상품을 결제 시 해당 쿠폰을 사용하여 할인을 적용 받을 수 있는 서비스를 말합니다.<br><br>
                    • 쿠폰의 종류와 할인금액(할인율), 사용 조건, 사용 유효기간 및 제한에 대한 사항은 회원 계정 내 쿠폰함 또는 주문 결제화면에 표기됩니다.<br><br>
                    • 쿠폰의 종류 및 내용, 정책은 회사의 각 서비스 및 프로모션 정책에 따라 변경될 수 있습니다.<br><br><br>
                    <span class="mrle">2. 지급 및 사용</span><br><br>
                    <h3>공통사항</h3><br>
                    • "회원"은 쿠폰 사용 가능한 서비스(국내숙소, 국내 레저/티켓, 해외숙소, KTX, 고속버스)에서, 쿠폰 사용 가능 기간에 쿠폰을 적용하여 사용할 수 있습니다.<br><br>
                    • 쿠폰은 숙소의 경우 객실가, 숙소 외의 경우 판매가를 기준으로 사용할 수 있습니다.<br><br>
                    • 쿠폰은 명시된 사용 유효기간 내만 사용할 수 있으며, 자세한 사항은 할인쿠폰 상세 또는 주문 결제 서비스 화면에 안내됩니다.<br><br>
                    • 쿠폰을 사용한 예약 취소 시, 쿠폰 할인 금액을 제외한 실제 결제 금액에서 위약금을 제외한 금액이 환불 처리되며, 해당 쿠폰의 재 사용은 불가할 수 있습니다.<br><br>
                    <h3>가. 고객 보유 쿠폰</h3><br>
                    • 고객이 보유하며, 사용 유효기간 및 사용 조건에 따라 사용 가능한 '즉시할인' 또는 '페이백' 유형의 쿠폰입니다.<br><br>
                    • 고객 쿠폰함 내, 각 쿠폰 상세정보 페이지에서 사용 유효기간 및 사용 조건 확인 가능합니다.<br><br>
                    <h3>나. 업체 보유 쿠폰</h3><br>
                    • 업체가 보유하며, 업체별 제공 수량에 따라 선착순으로 사용 가능한 '즉시할인' 유형의 쿠폰입니다.<br><br>
                    • 주문 결제화면 내, 사용 가능한 쿠폰 목록에서 확인 가능합니다.(사용완료 기준으로 마감처리)<br><br>
                    • 쿠폰 사용조건內 최소 결제금액은 순수 1객실 가격 기준입니다.(인원 추가, 조식 추가 등 기타 옵션 금액은 미포함)<br><br><br>
                    <span class="mrle">3. 소멸</span><br><br>
                    • 보유한 쿠폰에 표기된 사용 유효기간이 경과되거나, 서비스 이용계약이 종료되면 소멸됩니다.<br><br>
                    • "회원" 탈퇴 또는 "휴면회원" 전환 시, 회사로부터 발급받은 미사용 쿠폰은 즉시 소멸되며, 재가입 이후에도 소멸된 쿠폰은 복원되지 않습니다.<br><br><br>
                    <span class="mrle">4. 쿠폰 정책의 변경</span><br><br>
                    • 본 쿠폰의 정책은 회원에 별도 고지절차 없이 홈페이지 개시 등으로 변경될 수 있습니다.<br><br>
                    • 본 쿠폰정책은 2021년 7월 27일(화) 변경 및 고지되었습니다.<br><br><br>
                </div>
            </div>
        </body>
    </html>