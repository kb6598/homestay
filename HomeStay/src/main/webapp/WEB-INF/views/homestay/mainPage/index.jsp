<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>HomeStay</title>
   		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   		<link href="https://fonts.googleapis.com/css?family=Mansalva|Nanum+Gothic|Nanum+Myeongjo|Noto+Sans+KR|Lora|East+Sea+Dokdo|Jua&display=swap" rel="stylesheet">
   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style>
<!--topView-->
.carousel-item {
	overflow: hidden;
}

img {
	width: 100%;
	height: 300px;
	object-fit: cover
}
<!--menu-->
.col-sm-12
{
	text-align :center;
	color: black;
    text-decoration: none;
}

ul
{
	list-style: none;
}

ul li
{
	float: left;
}

a
{
	color : #000;
	padding-left: 30px;
	padding-right: 30px;
	text-decoration: none;
}

a:hover, a:focus
{
	color : #FC0;
	text-decoration: underline;

}
<!--mainView-->
 body {
            width: 100%;
            height: 100%;
            background-color: #e2e2e2;
            font-family: 'Noto Sans KR', sans-serif;
        }

        .container {
            width: auto;
            //height: 540px;
        }

        .row {
            height: 100%;
            display: flex;
            flex-direction: row;
        }

        .col {
            display: flex;
            flex-direction: column;
            padding: 10px;
            height: 100%;
        }

        .carousel-arrow {
            display: flex;
            flex-direction: row;
            position: absolute;
            top: 0;
            right: 0;
        }

        .arw {
            margin: 10px;
            width: 30px;
            height: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
            outline: none;
            border: none;
        }

        .fas {
            color: #fff;
            font-size: 30px;
            text-shadow: 0px 0px 5px rgba(0, 0, 0, .5);
            transition-duration: .5s;
        }

        .carousel-text {
            display: flex;
            flex-direction: column;
            position: absolute;
            bottom: 0;
            margin: 10px;
        }

        .carousel-text .category {
            color: #fff;
            font-size: 30px;
            font-weight: 700;
            text-shadow: 0px 0px 15px rgba(0, 0, 0, .8);
        }

        .carousel-text .place {
            color: #fff;
            font-size: 15px;
            font-weight: 300;
            margin-top: -7px;
            padding-left: 3px;
            text-shadow: 0px 0px 6px rgba(0, 0, 0, .5);
        }

        .carousel-inner.left img {
            height: 510px;
        }

        .carousel-inner.right img {
            padding-bottom: 10px;
            height: 260px;
        }

        /* for padding-bottom */
        .carousel-inner.right>.carousel-item>.carousel-text {
            bottom: 10px;
        }
        
<!--subView-->
        .btn-wrapper{
            float: right;
            height: 50px;
        }
        .subviw {
            width: 100%;
        }
        .subview-header{
        
        }

        .carousel-item {
            overflow: hidden;

        }

        img {
            width: 100%;
            height: 250px;
            object-fit: cover
        }
        .subview-header{
        height: 50px;
        }

</style>
</head>
<body>


<jsp:include page="/mainpage/topview" flush="false"/>
<jsp:include page="/mainpage/menu" flush="false"/>
<jsp:include page="/mainpage/mainview" flush="false"/>
<jsp:include page="/mainpage/subview" flush="false"/>
<jsp:include page="/mainpage/subview" flush="false"/>
<jsp:include page="/mainpage/subview" flush="false"/>
<jsp:include page="/mainpage/subview" flush="false"/>
<jsp:include page="/mainpage/subview" flush="false"/>

</body>
</html>