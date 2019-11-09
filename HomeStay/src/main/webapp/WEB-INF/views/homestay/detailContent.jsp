<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<!-- Top CSS -->
<link rel="stylesheet" href="/resources/mainContent/top.css">
<!-- End Top CSS -->
<!-- API CSS -->
<link rel="stylesheet" href="/resources/detailContent/swiper.min.css">
<!-- End API CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<!-- Image Slider -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<!-- End Image Slider -->
<meta charset="UTF-8">
<title>HomeStay</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<style>
	/*GLOBALS*/
	* {
		margin: 0;
		padding: 0;
		list-style: none;
	}
	
	a {
		text-decoration: none;
		color: #666;
	}
	
	a:hover {
		color: #1bc1a3;
	}
	
	html {
		background-color: #E2E2E2;
	}
	
	#wrapper {
		width: 600px;
		margin: 50px auto;
		height: 400px;
		position: relative;
		color: #fff;
		text-shadow: rgba(0, 0, 0, 0.1) 2px 2px 0px;
		float : left;
		margin-left: 130px;
	}
	
	#slider-wrap {
		width: 600px;
		height: 400px;
		position: relative;
		overflow: hidden;
	}
	
	#slider-wrap ul#slider {
		width: 100%;
		height: 100%;
		position: absolute;
		top: 0;
		left: 0;
	}
	
	#slider-wrap ul#slider li {
		float: left;
		position: relative;
		width: 600px;
		height: 400px;
	}
	
	#slider-wrap ul#slider li>div {
		position: absolute;
		top: 20px;
		left: 35px;
	}
	
	#slider-wrap ul#slider li>div h3 {
		font-size: 36px;
		text-transform: uppercase;
	}
	
	#slider-wrap ul#slider li>div span {
		font-family: Neucha, Arial, sans serif;
		font-size: 21px;
	}
	
	#slider-wrap ul#slider li img {
		display: block;
		width: 100%;
		height: 100%;
	}
	
	/*btns*/
	.btns {
		position: absolute;
		width: 50px;
		height: 60px;
		top: 50%;
		margin-top: -25px;
		line-height: 57px;
		text-align: center;
		cursor: pointer;
		background: rgba(0, 0, 0, 0.1);
		z-index: 100;
		-webkit-user-select: none;
		-moz-user-select: none;
		-khtml-user-select: none;
		-ms-user-select: none;
		-webkit-transition: all 0.1s ease;
		-moz-transition: all 0.1s ease;
		-o-transition: all 0.1s ease;
		-ms-transition: all 0.1s ease;
		transition: all 0.1s ease;
	}
	
	.btns:hover {
		background: rgba(0, 0, 0, 0.3);
	}
	
	#next {
		right: -50px;
		border-radius: 7px 0px 0px 7px;
	}
	
	#previous {
		left: -50px;
		border-radius: 0px 7px 7px 7px;
	}
	
	#counter {
		top: 30px;
		right: 35px;
		width: auto;
		position: absolute;
	}
	
	#slider-wrap.active #next {
		right: 0px;
	}
	
	#slider-wrap.active #previous {
		left: 0px;
	}
	
	/*bar*/
	#pagination-wrap {
		min-width: 20px;
		margin-top: 350px;
		margin-left: auto;
		margin-right: auto;
		height: 15px;
		position: relative;
		text-align: center;
	}
	
	#pagination-wrap ul {
		width: 100%;
	}
	
	#pagination-wrap ul li {
		margin: 0 4px;
		display: inline-block;
		width: 5px;
		height: 5px;
		border-radius: 50%;
		background: #fff;
		opacity: 0.5;
		position: relative;
		top: 0;
	}
	
	#pagination-wrap ul li.active {
		width: 12px;
		height: 12px;
		top: 3px;
		opacity: 1;
		box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 0px;
	}
	
	/*Header*/
	h1, h2 {
		text-shadow: none;
		text-align: center;
	}
	
	h1 {
		color: #666;
		text-transform: uppercase;
		font-size: 36px;
	}
	
	h2 {
		color: #7f8c8d;
		font-family: Neucha, Arial, sans serif;
		font-size: 18px;
		margin-bottom: 30px;
	}
	
	/*ANIMATION*/
	#slider-wrap ul, #pagination-wrap ul li {
		-webkit-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
		-moz-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
		-o-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
		-ms-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
		transition: all 0.3s cubic-bezier(1, .01, .32, 1);
	}
	
	/*Tour API Image Slider*/
	.ApiImage {
		width: 200px;
		height: 250px;
	}
	
</style>
<body style="background-color: #E2E2E2;">

	<!-- Top -->
	<div class="col-lg" style="background: #E2E2E2;">
		<jsp:include page="/mainpage/top" flush="false" />
	</div>
	<!-- End Top -->
	<hr>

	<!-- Content & Image Slider -->
	<div id="wrapper">
		<div id="slider-wrap">
			<ul id="slider">
				<c:forEach items="${readWithPlaceDetailDataImage}" var="placeDetailDataImage">
					<li>
						<img src="${placeDetailDataImage.imageurl}" class="ContentImage">
					</li>
				</c:forEach>
			</ul>

			<!--controls-->
			<div class="btns" id="next">
				<i class="fa fa-arrow-right"></i>
			</div>
			<div class="btns" id="previous">
				<i class="fa fa-arrow-left"></i>
			</div>
			<div id="counter"></div>

			<div id="pagination-wrap">
				<ul>
				</ul>
			</div>
			<!--controls-->

		</div>
	</div>
	
	<!-- 개요 -->
	<div id="content" style="float: left;">
		<div style="width: 600px; padding-left: 30px;">
			<!-- Tab -->
			<ul class="nav nav-tabs">
				<li class="nav-item">
					<a class="nav-link active" data-toggle="tab" href="#introduction">개요</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" data-toggle="tab" href="#asd">공통정보</a>
				</li>
			</ul>
			<!-- End Tab -->

			<!-- Tab Content -->
			<div class="tab-content">
				<div class="tab-pane fade show active" id="introduction">
					<c:forEach items="${readWithPlaceDetailData}" var="placeDetailData" begin="0" step="1" end="1">
						<span style="font-size: 15px; color: black;">
							${placeDetailData.content}
						</span>
					</c:forEach>
				</div>
				
				<div class="tab-pane fade" id="asd">
					<c:forEach items="${readWithPlaceDetailData}" var="placeDetailData" begin="2" step="1">
						<span style="font-size: 15px; color: black;">
							${placeDetailData.content_category} : ${placeDetailData.content}
							<br>
						</span>
					</c:forEach>
				</div>
			</div>
			<!-- End Tab Content -->
		</div>
	</div>
	<!-- End Content & Image Slider -->
	
	<!-- Tour API -->
	<div class="swiper-container" style="width: 1200px; height: 500px; margin-top: 50px;">
		<h2>주변 관광지</h2>
		<div id="imgDiv" class="swiper-wrapper">
		</div>
		
		<!-- Add Pagination -->
		<!-- Add Arrows -->
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
	<br>
	<br>
	
	<!-- Recommendation -->
	
	<!-- End Recommendation -->



	<!-- Swiper JS -->
	<script src="/resources/detailContent/swiper.min.js"></script>
	<script>
		//current position
		var pos = 0;
		//number of slides
		var totalSlides = $('#slider-wrap ul li').length;
		//get the slide width
		var sliderWidth = $('#slider-wrap').width();
	
	
		$(document).ready(function(){
		    
		    
		    /*****************
		     BUILD THE SLIDER
		    *****************/
		    //set width to be 'x' times the number of slides
		    $('#slider-wrap ul#slider').width(sliderWidth*totalSlides);
		    
		    //next slide    
		    $('#next').click(function(){
		        slideRight();
		    });
		    
		    //previous slide
		    $('#previous').click(function(){
		        slideLeft();
		    });
		    
		    
		    
		    /*************************
		     //*> OPTIONAL SETTINGS
		    ************************/
		    //automatic slider
		    //var autoSlider = setInterval(slideRight, 3000);
		    
		    //for each slide 
		    $.each($('#slider-wrap ul li'), function() { 
	
		       //create a pagination
		       var li = document.createElement('li');
		       $('#pagination-wrap ul').append(li);    
		    });
		    
		    //counter
		    countSlides();
		    
		    //pagination
		    pagination();
		    
		    //hide/show controls/btns when hover
		    //pause automatic slide when hover
		    $('#slider-wrap').hover(
		      function(){ $(this).addClass('active'); /* clearInterval(autoSlider); */ }, 
		      function(){ $(this).removeClass('active'); /* autoSlider = setInterval(slideRight, 3000); */ }
		    );
		    
		    
	
		});//DOCUMENT READY
		    
	
	
		/***********
		 SLIDE LEFT
		************/
		function slideLeft(){
		    pos--;
		    if(pos==-1){ pos = totalSlides-1; }
		    $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos));    
		    
		    //*> optional
		    countSlides();
		    pagination();
		}
	
	
		/************
		 SLIDE RIGHT
		*************/
		function slideRight(){
		    pos++;
		    if(pos==totalSlides){ pos = 0; }
		    $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos)); 
		    
		    //*> optional 
		    countSlides();
		    pagination();
		}
	
	
	
		    
		/************************
		 //*> OPTIONAL SETTINGS
		************************/
		function countSlides(){
		    $('#counter').html(pos+1 + ' / ' + totalSlides);
		}
	
		function pagination(){
		    $('#pagination-wrap ul li').removeClass('active');
		    $('#pagination-wrap ul li:eq('+pos+')').addClass('active');
		}
		//End Image Slide
		
		//NO IMAGE Script
		var imgs = document.getElementsByTagName("img");
		
		for(i = 0;i < imgs.length; i++)
	    {
	    	imgs[i].setAttribute("onError","http://toeic.ybmclass.com/toeic/img/noimage.gif");
	        if(imgs[i].getAttribute("src") == null ||
	        		imgs[i].getAttribute("src") == ""||
	        		imgs[i].getAttribute("src") == "null"||
	        		imgs[i].getAttribute("src") == "noImage")
	        {
	            imgs[i].setAttribute("src","http://toeic.ybmclass.com/toeic/img/noimage.gif");   
	        }
	    }
		//End NO IMAGE Script
	</script>
	
	<script>  
	function bind(){
	
		var swiper = new Swiper('.swiper-container', {
			slidesPerView : 5,
			spaceBetween : 30,
			loop : true,
			pagination : {
				el : '.swiper-pagination',
				clickable : true,
			},
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},
		});
		
		//주변관광지
		$(document).ready(function(){
			$.ajax({
		        type : "POST",
		        url : "/location",
		        data: {contentid:"${contentid}"},
		        dataType: "text",
		        error : function(data,xhr,status,error){
		            alert(xhr+", "+status+", "+error);
		        },
		        success : function(data){
		        	alert(data);
		        	var obj = JSON.parse(data);
		        	obj.forEach(function (item, index, array) {
		        		if(item.hasOwnProperty('firstimage')){
			        		imgDiv.innerHTML += '<div class="swiper-slide" style="width: 200px; height: 250px;">'+
			        		'<a href="/detailContent?contentid='+item.contentid+'">'+
			        		'<img src="'+item.firstimage+'" class="ApiImage"></a></div>';
			        	}
		        	})
		        	bind();
		        }  
		    });
		});
	</script>
</body>
</html>