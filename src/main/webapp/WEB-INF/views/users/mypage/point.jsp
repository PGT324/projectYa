<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="kr">
        <head>
            <meta charset="utf-8">
            <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
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
                    border-bottom : 1px solid #E8E8E8;
                    height : 40px;
                }
                .hd-left {
                    font-size : 20px;
                }
                .hd-middle {
                    font-size : 24px;
                    margin-top : -0.3%;
                    margin-left : -1.5%;
                }
                .hd-right {
                    font-size : 18px;
                }
                .po-tab {
                    margin-left : 20%;
                    margin-right : 20%;
                    margin-top : 2%;
                    border : 1px solid #EFEFEF;
                    padding : 0.5% 2% 2% 1%;
                    border-radius: 15px;
                    
                }
                .u-po {
                    font-size : 12px;
                    font-weight : 600;
                }
                .po-now {
                    color : #DE3263;
                    font-size : 20px;
                    font-weight: 400;
                    
                }
                .pn-he {
                    margin-top : 0.5%;
                }
                .p-list {
                    margin-top : 2%;
                    margin-left : 47%;
                    margin-right : 49%;
                    padding-bottom : 1%;
                    border-bottom : 2px solid;
                    font-weight : 600;
                    font-size : 14px;
                }
                .list-info {
                    color : #8A8A8A;
                    font-size : 12px;
                    font-weight : 600;
                    margin-left : 20%;
                    margin-right : 20%;
                    margin-top : 2%;
                    background-color: #F8F8F8;
                    padding : 1%;
                }
                .plo-tab {
                    border : 1px solid #EFEFEF;
                    margin-left : 20%;
                    margin-right : 20%;
                    border-radius: 15px;
                    padding : 2%;
                    display : flex;
                    justify-content: space-between;
                }
                .get-po {
                    font-size : 24px;
                    padding-top : 2%;
                    font-weight: 600;
                    color : #DE3263;
                    margin-left : 5%;
                    border-right : 1px solid;
                    border-color : #EFEFEF;
                    padding-right : 10%;
                }
                .get-po span {
                    color :black;
                    font-size : 20px;
                }
                .where {
                    font-weight : 600;
                    font-size : 18px;
                    margin-top : -5%;
                    margin-bottom : 2%;
                    
                }
                .much {
                    font-weight : 200;
                    font-size : 12px;
                    margin-top : 15%;
                }
                .get-date {
                    font-size : 12px;
                }
                .po-state {
                    margin-left : 74%;
                    color : #8A8A8A;
                    font-size : 12px;
                    font-weight: 600;
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
                            포인트
                        </div>
                        <div class="hd-right">
                            <a href="/pro/mypage/pr"> ⓘ</a>
                        </div>
                    </div>
                </div>
            </header>
            <div class="main">
                <div class="main-top">
                    <div class="po-tab" style='box-shadow: 0px 2px 0px 0px #F2F2F2'>
                        <div class="u-po">&#9413;사용 가능한 포인트</div>
                        <div class="pn-he">
                            <span class="po-now">${totalValue }</span>p
                        </div>
                    </div>
                </div>
                <div class="main-mid">
                    <div class="p-list">
                        전체내역
                    </div>
                    <div class="list-info">
                        지난 1년간 적립된 포인트 내역입니다.
                    </div>
                </div>
                <div class="point-list">
                    <div class="pl-one">
                    	<c:forEach var="list" items="${list3 }" varStatus="status" >
                    	<c:forEach var="vo" items="${list }" >
                        <div class="plo-tab" style='box-shadow: 0px 2px 0px 0px #F2F2F2'>
                            <div class="get-po">
                                ${value1[status.index] }<span>P</span>
                            </div>
                            <div class="get-info">
                                <div class="where">
                                    ${name1[status.index]}
                                </div>
                                <div class="much">
                                    결제금액 : ${vo.total_price }원
                                </div>
                                <div class="get-date">
                                    결제 일시 : ${vo.regdate }
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        </c:forEach>
                        <div class="po-state">
                        
                        </div>
                    </div>
                </div>
                <div class="point-list">
                    <div class="pl-one">
                    	<c:forEach var="list" items="${list4 }" varStatus="status" >
                    	<c:forEach var="vo" items="${list }" >
                        <div class="plo-tab" style='box-shadow: 0px 2px 0px 0px #F2F2F2'>
                            <div class="get-po">
                                ${value2[status.index] }<span>P</span>
                            </div>
                            <div class="get-info">
                                <div class="where">
                                    ${name2[status.index] }
                                </div>
                                <div class="much">
                                    결제금액 : ${vo.total_price }원
                                </div>
                                <div class="get-date">
                                    결제 일시 : ${vo.regdate }
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        </c:forEach>
                        <div class="po-state">
                        
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </html>