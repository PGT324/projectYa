<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="kr">
        <head>
            <meta charset="utf-8">
            <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
            <title>찜 목록 | 야놀자 공식 모바일사이트</title>
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
                    display : flex;
                    justify-content: space-between;
                    margin-top : 1%;
                    height : 40px;
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
                .hd-left {
                    font-size : 20px;
                    margin-left : 20%;
                }
                .hd-right {
                    font-size : 18px;
                    margin-right : 20%;
                }
                .main-title {
                    font-weight: bolder;
                    font-size : 24px;
                    margin-left : 20%;
                }
                .mt-one {
                    display : flex;
                    
                    margin-top : 1%;
                    border-bottom : 1px solid #FAFAFA;
                    
                }
                .mt-date {
                    border : 1px solid #CFCFCF;
                    padding : 0.7%;
                    border-radius: 5px;
                    font-weight : 400;
                    font-size : 14px;
                    margin-bottom : 1%;
                    margin-left : 20%;
                }
                .cus-num {
                    border : 1px solid #CFCFCF;
                    padding : 0.7%;
                    border-radius: 5px;
                    margin-left : 1%;
                    font-weight : 400;
                    font-size : 14px;
                    margin-bottom : 1%;
                }
                .mt-date a, .cus-num a {
                    text-decoration: none;
                    color : black;
                }
                .mt-date:hover, .cus-num:hover {
                    background-color: #F2F2F2;
                }
                .jjim-cate {
                    margin-top : 3%;
                    border-bottom : 1px solid #F2F2F2;
                }
                .dome {
                    margin-top : 0.5%;
                    padding-bottom : 0.5%;
                    margin-left : 20%;
                    margin-right : 75.7%;
                    color : #5E5E5E;
                    border-bottom : 2px solid black;
                    font-weight : bold;
                }
                .main {
                    position : relative;
                }
                
                .jj-list {
                    margin-left : 20%;
                    margin-right : 20%;
                    width : 60%;
                    display : flex;
                    position : relative;
                    height : 400px;
                    flex-direction: row;
                    flex-wrap: wrap;
                }
                .jjlist-one {
                    
                    width : 47%;
                    border : 1px solid #ECECEC;
                    padding : 1%;
                    height : 60%;
                    
                }
                .jjlist-one a {
                    
                    height : 100%;
                    text-decoration: none;
                    color : black;
                }
                .jl-one {
                    width : 70%;
                    
                }
                .jl-one img {
                    border-radius: 8px;
                    object-fit: cover;
                    height : 10%;
                    
                }
                .jl-two {
                    height : 100%;
                    width : 100%;
                    font-weight: bold;
                    font-size : 17px;
                    margin-top : 1%;
                    text-align : right;
                }
                
                .jt-img  {
                    margin-left : 72%;
                    width : 12.696%;
                    height : 10%;
                    background-image : url("https://yaimg.yanolja.com/joy/sunny/static/images/icon-score-yayellow-fill.svg");
                    background-repeat: repeat-x;
                }
                .jt-imgs {
                    margin-left : 72%;
                    width : 10.212%;
                    height : 10%;
                    background-image : url("https://yaimg.yanolja.com/joy/sunny/static/images/icon-score-yayellow-fill.svg");
                    background-repeat: repeat-x;
                }
                .jt-imgss {
                    margin-left : 72%;
                    width : 7.176%;
                    height : 10%;
                    background-image : url("https://yaimg.yanolja.com/joy/sunny/static/images/icon-score-yayellow-fill.svg");
                    background-repeat: repeat-x;
                }
                .jt-score {
                    position :relative;
                    font-size : 12px;
                    font-weight : 400;
                    top : -11%;
                    
                }
                .jt-score span {
                    font-size : 12px;
                    font-weight: bold;
                }
                .jt-price {
                    font-size : 20px;
                    position : relative;
                    top : 55%;
                    left : 35%;
                }
                .jt-price span {
                    font-weight : 200;
                    font-size : 12px;
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
                        <div class="hd-right">
                            <a href="#"><img src="https://yaimg.yanolja.com/joy/sunny/static/images/icon-cart-black-line-2.svg"></a>
                        </div>
                    </div>
                </div>
                <div class="main-title">
                    찜
                </div>
                
                <div class="jjim-cate">
                    <div class="dome">
                        국내숙소
                    </div>
                </div>
            </header>
            <div class="main">
                <div class="jj-list">
                    <c:forEach var="vo" items="${list3 }" varStatus="status">
                    <div class="jjlist-one">
                        <a href="/pro/motel/onelist?m_region1_idx=${vo.m_region1_idx }&m_region2_idx=${vo.m_region2_idx}&motel_idx=${vo.motel_idx}&users_idx=${login.users_idx}">
                            <div class="jl-one">
                                <img src="${vo.image }">
                            </div>
                            <div class="jl-two">
                                <div>${vo.name }</div>
                                <div class="jt-img" style="width : ${0.276 * (star1[status.index]*10)}%"></div>
                                <div class="jt-score">
                                    <span>${star1[status.index] }</span>
                                </div>
                            </div>
                        </a>
                    </div>
                    </c:forEach>
      				<c:forEach var="vo" items="${list4 }" varStatus="status">
                    <div class="jjlist-one">
                        <a href="/pro/hotel/onelist?h_region1_idx=${vo.h_region1_idx }&h_region2_idx=${vo.h_region2_idx}&hotel_idx=${vo.hotel_idx}&users_idx=${login.users_idx}">
                            <div class="jl-one">
                                <img src="${vo.image }">
                            </div>
                            <div class="jl-two">
                                <div>${vo.name }</div>
                                <div class="jt-img" style="width : ${0.276 * (star2[status.index]*10)}%"></div>
                                <div class="jt-score">
                                    <span>${star2[status.index] }</span>
                                </div>
                            </div>
                        </a>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </body>
    </html>