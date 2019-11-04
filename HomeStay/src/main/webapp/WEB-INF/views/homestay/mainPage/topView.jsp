<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/common/bootstrap"></jsp:include>
<link rel="stylesheet" href="/resources/mainContent/topView.css">







<body>
	<div class="container">
		<div class="row">
			<div class="col-lg">
				<div id="topView" class="carousel slide carousel-fade"
					data-ride="carousel">
					<ol class="carousel-indicators">
				<c:forEach items="${images}" var="item"	varStatus="idx">
						<c:choose>
							<c:when test="${idx.index == 0}">
								<li data-target="#topView" data-slide-to="${idx.index}" class="active"></li>
							</c:when>
							<c:otherwise>
								<li data-target="#topView" data-slide-to=""></li>
							</c:otherwise>
						</c:choose>
				</c:forEach>

					</ol>
					<div class="carousel-inner">
						<c:forEach items="${images}" var="item"	varStatus="idx">
							<c:choose>
								<c:when test="${idx.index == 0}">
									<div class="carousel-item active">
								</c:when>
								<c:otherwise>
									<div class="carousel-item">
								</c:otherwise>
							</c:choose>
								<img class="topview-img" src="${item}">
								</div>
						</c:forEach>
					</div>
					<a class="carousel-control-prev" href="#topView" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#topView" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
