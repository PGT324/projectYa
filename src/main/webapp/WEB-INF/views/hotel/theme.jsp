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

                .mtitle {
                    font-weight : bold;
                    font-size : 20px;
                }
                .main-thema {
                    width : 600px;
                    height : 300px;
                    display : flex;
                    flex-direction: row;
                    flex-wrap : wrap;
                }
                .thema-one,.thema-two {
                    width : 20%;
                    height :50%;
                    color : #8D8D8D;
                    border : 2px solid #8D8D8D;
                    margin-top :2%;
                    margin-left : 2%;
                }
                .thema-one:hover {
                    border : 2px solid #03C75A;
                    
                }
                .thema-two:hover {
                    border : 2px solid #FF0000;
                }
                .th-info {
                    font-size : 15px;
                    margin-left : 1%;
                    text-align: center;
                    
                }
                .th-img {
                    margin-top : 15%;
                    margin-left : 2%;
                }
            </style>

        </head>
        <div class="main">
            <div class="mtitle">
                숙소시설 및 서비스
            </div>
            <div class="main-thema">
            <c:forEach var="vo" items="${image }" varStatus="status">
                <div class="thema-one">
                    <div class="th-img">
                        <img src="${vo }">
                    </div>
                    <div class="th-info">
                        <p>${name[status.index] }</p>
                    </div>
                </div>
			</c:forEach>
            </div>
        </div>
    </html>