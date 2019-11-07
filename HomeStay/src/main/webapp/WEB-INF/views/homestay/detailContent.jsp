<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<!-- API CSS -->
<link rel="stylesheet" href="/resources/detailContent/swiper.min.css">
<!-- End API CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
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
	
	hmtl {
		font-family: 'Anton', sans-serif;
	}
	
	#wrapper {
		width: 600px;
		margin-left: 20%;
		height: 400px;
		position: relative;
		color: #fff;
		text-shadow: rgba(0, 0, 0, 0.1) 2px 2px 0px;
	}
	
	#slider-wrap {
		width: 400px;
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
		width: 400px;
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
		width: 400px;
		height: 400px;
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
<body>
	<div id="wrapper">
	
		<!-- Content Image Slider -->
		<div style="width: 2000px;">
			<div id="slider-wrap" style="float: left;">
				<ul id="slider">
					<c:forEach items="${readWithPlaceDetailDateImage}" var="placeDetailDataImage">
						<li><img src="${placeDetailDataImage.imageurl}"></li>
					</c:forEach>
				</ul>
				<!--controls-->
				<div class="btns" id="next">
					<i class="swiper-button-next"></i>
				</div>
				<div class="btns" id="previous">
					<i class="swiper-button-prev"></i>
				</div>
				<div id="counter"></div>

				<div id="pagination-wrap">
					<ul>
					</ul>
				</div>
				<!--controls-->
			</div>
			<!-- End Image Slider -->

			<div style="float: left; height: 400px; margin-left: 3%">
				<div style="margin-left:; height: 400px; margin-top: 20%;">
					<font style="font-size: 20px; color: black;"> 
						<c:forEach items="${readWithPlaceDetailDate}" var="placeDetailData">
							${placeDetailData.content}
						</c:forEach>
					</font>
				</div>
			</div>
		</div>
	</div>
	<!-- End Content Image Slider -->
	<br>
	<br>

	<!-- Tour API -->
	<div class="swiper-container" style="width: 1200px; height: 500px;">
		<h2>주변 관광지</h2>
		<div id="imgDiv" class="swiper-wrapper">
			<%-- <c:forEach items="${}" var=""> --%>
				<!-- <div class="swiper-slide" style="width: 200px; height: 250px;">
					<img src="/resources/detailContent/1.jpg" class="ApiImage">
				</div>
				<div class="swiper-slide" style="width: 200px; height: 250px;">
					<img src="/resources/detailContent/2.jpg" class="ApiImage">
				</div>
				<div class="swiper-slide" style="width: 200px; height: 250px;">
					<img src="/resources/detailContent/3.jpg" class="ApiImage">
				</div>
				<div class="swiper-slide" style="width: 200px; height: 250px;">
					<img src="/resources/detailContent/4.jpg" class="ApiImage">
				</div>
				<div class="swiper-slide" style="width: 200px; height: 250px;">
					<img src="/resources/detailContent/5.jpg" class="ApiImage">
				</div>
				<div class="swiper-slide" style="width: 200px; height: 250px;">
					<img src="/resources/detailContent/6.jpg" class="ApiImage">
				</div> -->
			<%-- </c:forEach> --%>
		</div>
		<!-- Add Pagination -->
		<!-- Add Arrows -->
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
	<!-- End Tour API -->
	<br>
	<br>
	
	<!-- 피어슨 상관계수 -->
	<c:if test="${not empty sessionScope.memberInfo}">
		<jsp:include page="recommendation.jsp" />
	</c:if>
	<!-- End 피어슨 상관계수 -->


	<!-- Swiper JS -->
	<script src="/resources/detailContent/swiper.min.js"></script>
	<script>  
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
	</script>

	<!-- Content Image Slider -->
	<script type="text/javascript">
		//current position
		var pos = 0;
		//number of slides
		var totalSlides = $('#slider-wrap ul li').length;
		//get the slide width
		var sliderWidth = $('#slider-wrap').width();

		$(document).ready(function() {
			/*****************
			 BUILD THE SLIDER
			 *****************/
			//set width to be 'x' times the number of slides
			$('#slider-wrap ul#slider').width(sliderWidth * totalSlides);

			//next slide    
			$('#next').click(function() {
				slideRight();
			});

			//previous slide
			$('#previous').click(function() {
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
			$('#slider-wrap').hover(function() {
				$(this).addClass('active');
				clearInterval(autoSlider);
			}, function() {
				$(this).removeClass('active');
			} //autoSlider = setInterval(slideRight, 3000); }
			);

		});//DOCUMENT READY

		
		
		/***********
		 SLIDE LEFT
		 ************/
		function slideLeft() {
			pos--;
			if (pos == -1) {
				pos = totalSlides - 1;
			}
			$('#slider-wrap ul#slider').css('left', -(sliderWidth * pos));

			//*> optional
			countSlides();
			pagination();
		}

		
		
		/************
		 SLIDE RIGHT
		 *************/
		function slideRight() {
			pos++;
			if (pos == totalSlides) {
				pos = 0;
			}
			$('#slider-wrap ul#slider').css('left', -(sliderWidth * pos));

			//*> optional 
			countSlides();
			pagination();
		}

		
		
		/************************
		 //*> OPTIONAL SETTINGS
		 ************************/
		function countSlides() {
			$('#counter').html(pos + 1 + ' / ' + totalSlides);
		}

		function pagination() {
			$('#pagination-wrap ul li').removeClass('active');
			$('#pagination-wrap ul li:eq(' + pos + ')').addClass('active');
		}
		
		//주변관광지
		$(document).ready(function(){
			$.ajax({
		        type : "POST",
		        url : "/location",
		        data: {contentId:"${contentId}"},
		        dataType: "text",
		        error : function(data,xhr,status,error){
		            alert(xhr+", "+status+", "+error);
		        },
		        success : function(data){
		        	alert(data);

		        	
		        	   var 
		               targetDiv = document.getElementById("imgDiv"),
		               wrapDiv, tmpImg, tmpA;
		        	   



		        	
		        	
		               var obj = JSON.parse(data);
		        	obj.forEach(function (item, index, array) {
		        		
		        		
		        		if(item.hasOwnProperty('firstimage')){
				        	   wrapDiv = document.createElement('div');
				          		wrapDiv.setAttribute("draggable", 'true');
				        	   wrapDiv.setAttribute("class", "swiper-slide");
								
				        	   tmpA = document.createElement('a');
				               tmpA.setAttribute("href", "/detailContent?contentid="+item.contentid);
								
				               tmpImg = document.createElement('img');
				               tmpImg.setAttribute("class","ApiImage");
				               tmpImg.setAttribute("src",item.firstimage);
				               
				               tmpA.appendChild(tmpImg);    
				               wrapDiv.appendChild(tmpA);
				               targetDiv.appendChild(wrapDiv);
				               console.info(wrapDiv);

		        		}        		
      				});
		        }   
		    });
		});
	</script>

</body>
</html>