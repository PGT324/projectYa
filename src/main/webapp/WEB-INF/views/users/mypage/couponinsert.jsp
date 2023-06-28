<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="kr">
        <head>
            <meta charset="utf-8">
            <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
            <title>야놀자 쿠폰등록 | 여행의 모든 것, 한 번에 쉽게</title>
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
                    font-size : 28px;
                    font-weight : 400;
                    text-align: center;
                    margin-top : 3%;
                }
                .cu-img {
                    width : 40px;
                    margin-left : 12%;
                    margin-top : 4.5%;
                }
                .cu-img img {
                    width : 40px;
                    height : 40px;
                    transform: rotate(325deg);
                }
                .cu-in {
                    margin-top : 3%;
                    margin-left : 10%;
                }
                .main {
                    display : flex;
                    
                }
                .foot {
                    margin-top : 7%;
                    font-size : 18px;
                    color : #B9B9B9;
                    margin-left : 26%;
                }
                .foot-info {
                    margin-top : 1%;
                    font-size : 14px;
                    
                }
                body {
                    background-color: #F6F6F6;
                }
                
                
            </style>
        </head>
        <body>
            <header class="header">
                <div class="inner">
                    쿠폰상자
                </div>
            </header>
            <div class="main">
                <div class="cu-img">
                    <img src="https://img.freepik.com/free-icon/coupon_318-534561.jpg">
                </div>
                <div class="cu-in">
                    <form action="/pro/users/mypage/result?users_idx=${login.users_idx }" method="POST">
                        <input type="text" name="code" placeholder="쿠폰 번호 입력" style="width : 450px; height: 50px; border : 2px solid #E7E7E7; border-right : 0px; font-size: 17px; border-radius: 3px; margin-top : 1%;">
                        <input type="submit" value="확인" style="height : 56px; width : 50px; border : 0px;margin-left : -1.2%; border-radius: 3px; background-color: #FF5000; color : white; ">
                    </form>
                </div>
            </div>
            <div class="foot">
                이용안내
                <div class="foot-info">
                    • 쿠폰을 통해 이미 지급받은 혜택은 환불이 불가능합니다.<br>
                    • 업체에 따라 혜택을 지급받기까지 시간이 소요될 수 있습니다.<br>
                    • 타인에게 쿠폰의 양도 혹은 판매할 경우 사용이 제한될 수 있습니다.<br>
                </div>
            </div>
        </body>
      
    </html>