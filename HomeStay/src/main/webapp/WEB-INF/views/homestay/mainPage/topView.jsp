<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/common/bootstrap"></jsp:include>
<link rel="stylesheet" href="/resources/mainContent/topView.css">

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg">
				<div id="topView" class="carousel slide carousel-fade"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#topView" data-slide-to="0" class="active"></li>
						<li data-target="#topView" data-slide-to="1"></li>
						<li data-target="#topView" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active" data-interval="5000">
							<img class="topview-img"
								src="${image_1}">
						</div>
						<div class="carousel-item" data-interval="5000">
							<img class="topview-img"
								src="${image_2}">
						</div>
						<div class="carousel-item" data-interval="5000">
							<img class="topview-img"
								src="${image_3}">
						</div>
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
