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
                    font-size : 22px;
                    position : fixed;
                    justify-content: space-between;
                    height : 50px;
                    padding-top : 1%;
                    display: flex;
                    width : 100%;
                    background-color: white;
                }
                .inner {
                    width : 100%;
                    height : 50px;
                }
                .hd-left {
                    margin-left : 17%;
                }
                .hd-right {
                    margin-right : 47%;
                }
                .main-rule {
                    margin-left : 20%;
                    margin-right : 20%;
                    color : #818181;
                    font-size : 12px;
                    margin-top : 2%;
                    margin-bottom : 2%;
                }
                .mrle {
                    font-size : 16px;
                    color : black;
                    font-weight : bold;
                }
                h4 {
                    color : black;
                    font-size : 12px;
                }
            </style>
        </head>
        <body>
            <header class="header">
                <div class="inner">
                    <div class="hd-in" >
                        <div class="hd-left">
                            <a href="/pro/mypage/point?users_idx=${login.users_idx }"><img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxwYXRoIGZpbGwtcnVsZT0iZXZlbm9kZCIgZD0iTTE4LjM2NCA0LjIyMkwxOS43NzggNS42MzYgMTMuNDE0IDEyIDE5Ljc3OCAxOC4zNjQgMTguMzY0IDE5Ljc3OCAxMiAxMy40MTQgNS42MzYgMTkuNzc4IDQuMjIyIDE4LjM2NCAxMC41ODYgMTIgNC4yMjIgNS42MzYgNS42MzYgNC4yMjIgMTIgMTAuNTg2eiIvPgo8L3N2Zz4K"></a>
                        </div>
                        <div class="hd-right">
                            포인트 정책
                        </div>
                    </div>
                </div>
            </header>
            <div class="main">
                <div class="main-rule">
                    <span class="mrle">1. 적립</span><br><br>
                    <h4>1) 야놀자 프로모션 참여에 따른 보상 포인트</h4><br>
                    • 야놀자 포인트의 적립 정책은 지급 근거가 되는 야놀자 자체 프로모션(‘이벤트’ 등 프로모션 명칭 변경 가능) 정책 기준으로 계산 및 지급됩니다.<br><br>
                    • 참여하신 프로모션 정책에 따라 포인트 지급일, 적립률, 사용 유효기간, 최대 적립 가능 포인트 금액 등이 상이할 수 있습니다.<br><br>
                    • 프로모션이 진행 중일 경우, 일부 정책이 기본 포인트 정책과 상이할 수 있습니다.<br><br>
                    • 이 경우, 프로모션 정책이 본 포인트 정책보다 우선 적용됩니다.<br><br>
                    • 관계법령 또는 회사 정책에 반한 거래(부정 거래 등)의 경우, 기 지급된 포인트는 회수 처리 될 수 있습니다.<br><br>
                    <h4>2) 야놀자 서비스 거래에 따른 보상 포인트</h4><br>
                    • 국내 숙소 미리예약에 대한 포인트 적립은 2020년 6월 14일 종료되었습니다<br><br>
                    • 국내 레저/티켓, 해외 숙소, 기차 예약에 대한 포인트 적립은 2020년 11월 30일 종료되었습니다.<br><br>
                    <h4>3) 후기 포인트</h4><br>
                    • 2021년 3월 16일부터, 후기 작성을 통한 야놀자 포인트 적립은 종료되며, 야놀자 코인으로 지급됩니다.<br><br>
                    • 야놀자 코인 적립에 대한 자세한 내용은 다음 페이지에서 확인하실 수 있습니다.<br><br>
                    • 단, 각 숙소별 최초 작성된 후기는 기본 적립(야놀자 코인 적립)과 별도로 야놀자 포인트(1,000P)가 추가 적립됩니다.<br><br>
                    • 보다 상세한 &lt;후기&gt; 서비스에 관한 내용은 다음 페이지에서 확인하실 수 있습니다.<br><br>
                    <h4>4) 오프라인 방문 QR코드 인증 포인트</h4><br>
                    • 고객님께서 야놀자 제휴점을 방문하신 후, 제휴점 프런트에 비치된 QR코드를 인증하신 경우 지급되는 포인트입니다.<br><br>
                    • 본 서비스는 2019년 3월 20일(수) 자정을 기준으로 종료되었습니다.<br><br>
                    <span class="mrle">2. 사용</span><br><br>
                    • 2022년 9월 27일 전자금융 선불 서비스가 신규 런칭함에 따라, 야놀자 포인트를 사용하고자 할 경우 반드시 전자금융거래 이용약관에 동의하셔야 합니다.<br><br>
                    • 보유하신 적립 포인트는 야놀자 서비스 내 판매 상품의 예약 및 결제 시 사용하실 수 있습니다.<br><br>
                    • 다만, 쿠폰 등과 함께 복합 결제로 사용시 쿠폰 사용 조건 등에 따라 적립포인트 사용이 일부 제한될 수 있습니다.<br><br>
                    • 결제금액의 전액 또는 일부를 포인트로 결제하실 수 있습니다.<br><br>
                    • 최종 결제금액의 전액을 포인트로 결제하는 경우, 안전한 서비스 이용을 위하여 별도의 본인 확인 절차(ARS인증)를 거쳐 사용할 수 있습니다.<br><br>
                    • 단, 쿠폰 및 제휴사 포인트 등의 기타 할인수단 복합 사용 시, 할인수단 적용 화면 별도 고지에 따라, 보유 포인트의 사용의 전체 또는 일부가 제한될 수 있습니다.<br><br>
                    <span class="mrle">3. 회수 및 환불</span><br><br>
                    <h4>1) 포인트 또는 코인 회수</h4><br>
                    • 작성하신 후기를 일정 기간 이내 삭제하거나 운영 정책에 의거하여 삭제 또는 블라인드 처리되는 경우, 후기 작성 시 적립된 야놀자 포인트 및 야놀자 코인은 자동 회수됩니다. 단, 작성자 본인이 작성일로부터 일정 기간(모텔 카테고리: 180일, 그 외 카테고리: 365일)이 경과된 후 삭제 처리하였다면 자동회수 대상에서 제외됩니다.<br><br>
                    <h4 style="color : #818181">[후기 삭제 사유]</h4><br>
                    • 작성일로부터 30일 경과 후 작성자 본인이 직접 삭제<br><br>
                    • 제휴점의 권리침해신고 또는 관계법령 및 내부 회사 정책 등에 따른 검토 결과에 의한 삭제<br><br>
                    • 기타 자세한 내용은 &lt;후기&gt; 운영 정책에서 참고 가능
                    이 외, 회사가 규정 및 승인하지 않은 방법으로 야놀자 포인트 또는 야놀자 코인을 적립한 경우, 이에 대한 야놀자 포인트 또는 야놀자 코인은 임의 회수될 수 있습니다.<br><br>
                    <h4>2) 포인트 환불 및 이관</h4><br>
                    • 무료 적립된 포인트(예약 및 결제로 인해 지급된 Reward 성격)는 비현금성으로 환불되지 않으며, 지급받은 계정 외 타 계정으로 이관, 상속, 양도 등이 불가합니다.<br><br>
                    <span class="mrle">4. 만료</span><br><br>
                    • 포인트는 만료없이 사용 가능합니다. 야놀자 만세<br><br>
                    <span class="mrle">5. 정책의 변경</span><br><br>
                    • 포인트의 상세 정책은 별도의 고지없이 수시 변경될 수 있습니다.<br><br>
                    • 본 정책은 2023년 3월 7일(화) 변경 및 고지되었습니다.<br><br>
                </div>
            </div>
        </body>
    </html>