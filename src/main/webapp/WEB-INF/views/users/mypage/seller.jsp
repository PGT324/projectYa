<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="kr">
        <head>
            <meta charset="utf-8">
            <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
            <title>사업자 등록 | 야놀자 공식 모바일사이트</title>
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

                .inner {
                    width : 100%;
                    height : 50px;
                }
                .hd-in {
                    margin-top : 0.5%;
                    height : 40px;
                }
                .hd-left {
                    font-weight: bold;
                    color : #929292;
                    font-size : 13px;
                    margin-left : 2%;
                }
                .title {
                    width : 100%;
                    height : 200px;
                }
                .mtitle {
                    font-weight : bold;
                    font-size : 35px;
                    margin-left : 40%;
                    margin-top : 5%;
                }
                .stitle {
                    font-weight : bold;
                    color : #9B9D9B;
                    margin-left : 38.5%;
                    margin-top : 2%;
                }
                .tinfo {
                    text-align : right;
                    color : #B1B1AF;
                    font-weight : bold;
                    font-size : 14px;
                    margin-right : 10%;
                    margin-top : 5%;
                }
                .tinfo span {
                    color : #FF3478;
                    font-weight: bold;
                    
                }
                .minfo {
                    border-top :2px solid;
                    margin-left : 10%;
                    margin-right : 10%;
                    
                    border-bottom : 2px solid;
                }
                .mi-one, .mi-two, .mi-thr {
                    border-bottom : 1px solid #EDEDED;
                    padding : 1%;
                    display : flex;
                }
                .mi-name, .exp, .licens {
                    font-weight: bold;
                    font-size : 16px;
                    padding : 2%;
                }
                .input-one {
                    padding : 1%;
                    width : 50%;
                    margin-left : 19%;
                }
                .input-one input, .input-thr input {
                    border : 2px solid #E8E8E8;
                    width : 50%;
                    height : 90%;
                }
                .all-span {
                    color : #FF3478;
                    font-weight: bold;
                }
                .input-one input:focus, .input-thr input:focus {
                    border : 1px solid #FF3478;
                    box-shadow: #FF3478 0px 0px 0px 1px;
                }
                .input-one input, .input-thr input  {
                    font-size : 16px;
                    color : #9B9D9B;
                    font-weight: bold;
                }
                .input-two {
                    margin-left : 10%;
                    padding : 1%;
                    margin-top : 1%;
                    width : 50%;
                    font-size : 16px;
                    font-weight: 600;
                    color : #666666;
                }
                
                .lab-one {
                    padding-left : 15%;
                }
                .lab-two {
                    padding-left : 10%;
                }
                .input-thr {
                    padding : 1%;
                    width : 50%;
                    margin-left : 10%;
                }
                .check-title {
                    margin-left : 10%;
                    margin-top : 2%;
                    font-weight: bolder;
                    font-size : 20px;
                }
                .check-list {
                    margin-top : 2%;
                    border : 1px solid #cccccc;
                    margin-left : 10%;
                    margin-right : 10%;
                    padding-left : 2%;
                    padding-top : 2%;
                }
                #check1 {
                    margin-bottom :2%;
                    
                }
               
                .cl-one, .cl-two {
                    font-weight: bold;
                    font-size : 14px;
                }
                .ch-sp {
                    color : #FF4080;
                }
                .ft-submit {
                    
                    margin-top : 3%;
                    margin-left : 38%;
                    margin-right : 35%;
                    margin-bottom : 5%;
                    border :0px;
                    background-color: #FF3478;
                    
                    padding : 1%;
                    border-radius : 45px;
                }
                .ft-submit:hover {
                    border : 2px solid;
                }
                .fts-one {
                    padding : 2%;
                    border : 0px;
                    margin-left : 39%;
                    background-color: #FF3478;
                    color : white;
                    font-weight: bold;
                    font-size : 20px;
                }
                .fts-two {
                    margin-left : 23%;
                    font-size : 20px;
                    font-weight : bold;
                    color : white;
                }
                

            </style>
        </head>
        <body>
            <header class="header">
                <div class="inner">
                    <div class="hd-in">
                        <div class="hd-left">
                            <img src="https://business.yanolja.com/common/kr/web/img/icon-home.png"> > 마이페이지 > 입점/사업자등록
                        </div>
                    </div>
                </div>
                <div class="title">
                    <div class="mtitle">
                        입점/사업자 등록
                    </div>
                    <div class="stitle">
                        성공 파트너 야놀자에 오신 것을 환영합니다.
                    </div>
                    <div class="tinfo">
                        <span>*</span>필수입력사항
                    </div>
                </div>
            </header>
            <div class="main">
                <form action="/pro/insert" method="POST">
                <input type="hidden" name="users_idx" value=${login.users_idx }>
                    <div class="minfo">
                        <div class="mi-one">
                            <div class="mi-name">
                                이름<span class="all-span">*</span>
                            </div>
                            <div class="input-one">
                                <input type="text" name="name">
                            </div>
                        </div>
                        <div class="mi-two">
                            <div class="exp">
                                숙박업 경험
                            </div>
                            <div class="input-two">
                                <label class="lab-two"><input type="radio" name ="exp" value="유"> 유</label>
                                <label class="lab-one"><input type="radio" name="exp" value="무"> 무</label>
                            </div>
                        </div>
                        <div class="mi-thr">
                            <div class="licens">
                                사업자 등록증 번호<span class="all-span">*</span>
                            </div>
                            <div class="input-thr">
                                <input type="text" name="snumber">
                            </div>
                        </div>
                    </div>
                    <div class="main-check">
                        <div class="check-title">
                            개인정보 수집 및 이용에 대한 동의
                        </div>
                        <div class="check-list">
                            <div class="cl-one">
                                <input type="checkbox" id="check1" required="required">
                                <label for="check1"><span class="ch-sp">&#40;필수&#41; </span>개인정보 수집 및 이용에 동의합니다.</label>
                            </div>
                            <div class="cl-two">
                                <input type="checkbox" id="check1" name="ad" value="1">
                                <label for="check1"><span class="ch-sp">&#40;선택&#41; </span>야놀자 소식 및 정보 등 마케팅 수신보다는 보노보노 PPT 발표에 동의합니다.</label>
                            </div>
                        </div>
                    </div>
                
                    <div class="foot">
                        <div class="ft-submit">
                            <input class="fts-one" type="submit" value="제출하기">
                            <span class="fts-two">⭧</span>    
                        </div>
                    </div>    
                </form>
            </div>
        </body>
    </html>