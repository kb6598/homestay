<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Tour API -->
	<!-- Swiper -->
	<div class="swiper-container" style="width: 1200px; height: 500px; margin-top: -130px;">
		<h2>다른 사용자의 추천 관광지</h2>
		<div class="swiper-wrapper">
			<%-- <c:forEach items="${}" var=""> --%>
				<div class="swiper-slide" style="width: 200px; height: 250px;">
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
				</div>
			<%-- </c:forEach> --%>
		</div>
		<!-- Add Pagination -->
		<!-- Add Arrows -->
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
	
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

</body>
</html>