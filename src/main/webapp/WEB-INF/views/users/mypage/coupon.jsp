<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">

<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="//yaimg.yanolja.com/joy/sunny/static/images/favicon/favicon_16x16.png">
    <title>대한민국 최저가 종합숙박</title>

    <style>
        html,
        body,
        div,
        span,
        object,
        iframe,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        p,
        blockquote,
        pre,
        abbr,
        address,
        cite,
        code,
        del,
        dfn,
        em,
        img,
        ins,
        kbd,
        q,
        samp,
        small,
        strong,
        sub,
        sup,
        var,
        b,
        i,
        dl,
        dt,
        dd,
        ol,
        ul,
        li,
        fieldset,
        form,
        label,
        legend,
        table,
        caption,
        tbody,
        tfoot,
        thead,
        tr,
        th,
        td,
        article,
        aside,
        canvas,
        details,
        figcaption,
        figure,
        footer,
        header,
        hgroup,
        menu,
        nav,
        section,
        summary,
        time,
        mark,
        audio,
        video,
        fieldset {
            margin: 0;
            padding: 0;
        }


        ol,
        ul {
            list-style: none
        }

        li {
            list-style-type: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        img {
            max-width: 100%;
            height: auto;
        }

        mark {
            background: none
        }

        select {
            max-width: 100%;
        }

        caption,
        legend {
            display: none;
        }

        hr {
            display: none;
        }

        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            font-size: 100%;
        }

        address,
        strong {
            font-style: normal;
            font-weight: normal;
        }

        table {
            border-collapse: collapse;
        }

        input,
        select {
            outline: none;
            font-family: inherit
        }

        .hd-in {
            font-weight: bolder;
        }

        .hd-in a {
            text-decoration: none;
            color: black;
        }

        .inner {
            position: relative;
            width: 100%;
            height: 50px;
        }

        .hd-in {
            display: flex;
            justify-content: space-around;
            margin-top: 1%;
            border-bottom: 1px solid #E8E8E8;
            height: 40px;
        }

        .hd-left {
            font-size: 20px;
        }

        .hd-middle {
            font-size: 24px;
            margin-top: -0.3%;
        }

        .hd-right {
            font-size: 18px;
        }

        .cu-tab {
            position: relative;
            border: 1px solid #E7E7E7;
            margin-left: 20%;
            margin-right: 20%;
            height: 100px;
            margin-top: 3%;
            border-radius: 15px;
        }

        .cu-info {
            position: relative;
            display: flex;
            height: 100px;

        }

        .cu-infol {
            display: flex;
            margin-top: 3%;
            margin-left: 2%;
            width: 40%;
            font-size: 12px;
        }

        .cu-name {
            margin-top: 1%;
        }

        .cu-num {
            margin-top: 3%;
            margin-left: -20%;
            font-size: 10px;
            font-weight: bold;
        }

        .cu-num span {
            color: #DF3561;
            font-size: 20px;
        }

        .cu-load {
            margin-left: 60%;
            margin-top: 3.5%;
        }

        .cu-load a {
            text-decoration: none;
            color: #115DCF;
            border: 1px solid #115DCF;
            padding: 7px;
            border-radius: 7px;
        }

        .cl-one {
            font-weight: bold;
            margin-top: 2%;
            margin-left: 20%;
            margin-right: 75.7%;
            border-bottom: 2px solid;
        }

        .cu-main {
            height: 700px;
        }

        .cm-list {
            display: flex;
            margin-left: 20%;
            margin-top: 3%;
            height: 700px;

        }

        .cm-list1 {
            border: 1px solid #EFEFEF;
            margin-right: 3%;
            width: 30%;
            height: 20%;
            border-radius: 15px;
            padding: 20px;
            background-color: #F8F8F8;
        }

        .cm-list2 {
            border: 1px solid #EFEFEF;
            width: 30%;
            height: 20%;
            border-radius: 15px;
            padding: 20px;
            background-color: #F8F8F8;
        }

        .cm-name {
            margin-left: 2%;
        }

        .cm-per {
            font-weight: bolder;
            font-size: 30px;
            margin-top: 10%;
            margin-left: 40%;
            color: #FFAA38;
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
                    쿠폰함
                </div>
                <div class="hd-right">
                    <a href="/pro/users/mypage/crule"> ⓘ</a>
                </div>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="main-top">
            <div class="cu-tab">
                <div class="cu-info">
                    <div class="cu-infol">
                        <div class="cu-pic">
                            <img src="https://yaimg.yanolja.com/joy/sunny/static/images/my/icon-coupon-2-line-1.svg">
                        </div>
                        <div class="cu-name">
                            사용대기/사용가능 쿠폰
                        </div>
                    </div>
                    <div class="cu-num">
                        <span>${count }</span>장
                    </div>
                    <div class="cu-load">
                        <a onclick="window.open('/pro/users/mypage/couponinsert', '_blank','location=no,status=no,scrollbars=yes,width=900,height=400')">쿠폰
                            등록하기</a>
                    </div>
                </div>

            </div>
            <div class="cu-list">
                <div class="cl-one">
                    국내숙소
                </div>
            </div>
        </div>
        <div class="cu-main">
            <div class="cm-list">
                <c:forEach var="vo" items="${list }">
                    <div class="cm-list1">
                        <div class="cm-name">${vo.name }</div>
                        <div class="cm-name">${vo.regdate }</div>
                        <div class="cm-per">${vo.sale }</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>

</html>