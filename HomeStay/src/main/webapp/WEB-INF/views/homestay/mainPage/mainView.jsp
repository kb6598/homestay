<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
   		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   		<link href="https://fonts.googleapis.com/css?family=Mansalva|Nanum+Gothic|Nanum+Myeongjo|Noto+Sans+KR|Lora|East+Sea+Dokdo|Jua&display=swap" rel="stylesheet">
   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
    		
		<style>
        body {
            width: 100%;
            height: 100%;
            background-color: #e2e2e2;
            font-family: 'Noto Sans KR', sans-serif;
        }

        .container {
            width: auto;
            height: 540px;
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
        
		</style>
	</head>
	
	<body>
	
    	<div class="container">
        	<div class="row">
            	<div class="col">
	                <div id="mainViewArea1" class="carousel slide" data-ride="carousel">
	                    <div class="carousel-inner left">
                        	<div class="carousel-item active">
	                            <img src="/resources/mainContent/testImage01.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">문화시설</div>
                                	<div class="place">롯데월드</div>
                            	</div>
                        	</div>
                        	<div class="carousel-item">
	                            <img src="/resources/mainContent/testImage02.jpg" class="d-block w-100" alt="...">
   	                         	<div class="carousel-text">
                                	<div class="category">카테고리</div>
	                                <div class="place">장소명</div>
                            	</div>
                        	</div>
                        	<div class="carousel-item">
	                            <img src="/resources/mainContent/testImage03.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">카테고리2</div>
                                	<div class="place">장소명2</div>
                            	</div>
                        	</div>
                    	</div>
                    	<div class="carousel-arrow">
	                        <div class="carousel-left arw">
                            	<a href="#mainViewArea1" data-slide="prev">
	                                <i class="fas">&#xf104;</i>
                            	</a>
                        	</div>
                        	<div class="carousel-right arw">
	                            <a href="#mainViewArea1" data-slide="next">
                                	<i class="fas">&#xf105;</i>
                            	</a>
                        	</div>
                    	</div>
                	</div>
            	</div>
            	<div class="col right">
	                <div id="mainViewArea2" class="carousel slide" data-ride="carousel">
                    	<div class="carousel-inner right">
	                        <div class="carousel-item active">
                            	<img src="/resources/mainContent/testImage01.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">문화시설</div>
                                	<div class="place">롯데월드</div>
                            	</div>
                        	</div>
                        	<div class="carousel-item">
	                            <img src="/resources/mainContent/testImage02.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">카테고리</div>
                                	<div class="place">장소명</div>
                            	</div>
                        	</div>
                        	<div class="carousel-item">
	                            <img src="/resources/mainContent/testImage03.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">카테고리2</div>
                                	<div class="place">장소명2</div>
                            	</div>
                        	</div>
                    	</div>
                    	<div class="carousel-arrow">
	                        <div class="carousel-left arw">
                            	<a href="#mainViewArea2" data-slide="prev">
	                                <i class="fas">&#xf104;</i>
                            	</a>
                        	</div>
                        	<div class="carousel-right arw">
	                            <a href="#mainViewArea2" data-slide="next">
                                	<i class="fas">&#xf105;</i>
                            	</a>
                        	</div>
                    	</div>
                	</div>
                	<div id="mainViewArea3" class="carousel slide" data-ride="carousel">
	                    <div class="carousel-inner right">
                        	<div class="carousel-item active">
	                            <img src="/resources/mainContent/testImage01.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">문화시설</div>
                                	<div class="place">롯데월드</div>
                            	</div>
                        	</div>
                        	<div class="carousel-item">
	                            <img src="/resources/mainContent/testImage02.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">카테고리</div>
                                	<div class="place">장소명</div>
                            	</div>
                        	</div>
                        	<div class="carousel-item">
	                            <img src="/resources/mainContent/testImage03.jpg" class="d-block w-100" alt="...">
                            	<div class="carousel-text">
	                                <div class="category">카테고리2</div>
                                	<div class="place">장소명2</div>
                            	</div>
                        	</div>
                    	</div>
                    	<div class="carousel-arrow">
	                        <div class="carousel-left arw">
                            	<a href="#mainViewArea3" data-slide="prev">
	                                <i class="fas">&#xf104;</i>
                            	</a>
                        	</div>
                        	<div class="carousel-right arw">
	                            <a href="#mainViewArea3" data-slide="next">
                                	<i class="fas">&#xf105;</i>
                            	</a>
                        	</div>
                    	</div>
                	</div>
            	</div>
        	</div>
    	</div>
	</body>
</html>