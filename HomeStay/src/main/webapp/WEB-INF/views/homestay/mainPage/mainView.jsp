<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div class="container mainview-container">
	<div class="row mainview">
		<div class="col">
			<div id="mainViewArea1" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner left">
					<c:forEach items="${joinPlaceTourImageDTO1}" var="item"
						varStatus="idx">
						<c:choose>
							<c:when test="${idx.index == 0}">
								<div class="carousel-item active">
							</c:when>
							<c:otherwise>
								<div class="carousel-item">
							</c:otherwise>
						</c:choose>
						<a href="/detailContent?contentid=${item.contentid}"><img  src="${item.imageurl}" class="d-block w-100" alt="..."></a>
						<div class="carousel-text">
							<div class="category">${item.theme}</div>
							<div class="place">${titleList1[idx.index]}</div>
						</div>
				</div>
				</c:forEach>

			</div>
			<div class="carousel-arrow">
				<div class="carousel-left arw">
					<a href="#mainViewArea1" data-slide="prev"> <i class="fas">&#xf104;</i>
					</a>
				</div>
				<div class="carousel-right arw">
					<a href="#mainViewArea1" data-slide="next"> <i class="fas">&#xf105;</i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col right">
		<div id="mainViewArea2" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner right">
				<c:forEach items="${joinPlaceTourImageDTO2}" var="item" varStatus="idx">
					<c:choose>
						<c:when test="${idx.index == 0}">
							<div class="carousel-item active">
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
						</c:otherwise>
					</c:choose>
					<a href="/detailContent?contentid=${item.contentid}"><img src="${item.imageurl}" class="d-block w-100" alt="..."></a>
					<div class="carousel-text">
						<div class="category">${item.theme}</div>
						<div class="place">${titleList2[idx.index]}</div>
					</div>
			</div>
			</c:forEach>
		</div>
		<div class="carousel-arrow">
			<div class="carousel-left arw">
				<a href="#mainViewArea2" data-slide="prev"> <i class="fas">&#xf104;</i>
				</a>
			</div>
			<div class="carousel-right arw">
				<a href="#mainViewArea2" data-slide="next"> <i class="fas">&#xf105;</i>
				</a>
			</div>
		</div>
	</div>
	<div id="mainViewArea3" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner right">


			<c:forEach items="${joinPlaceTourImageDTO3}" var="item" varStatus="idx">
				<c:choose>
					<c:when test="${idx.index == 0}">
						<div class="carousel-item active">
					</c:when>
					<c:otherwise>
						<div class="carousel-item">
					</c:otherwise>
				</c:choose>
				<a href="/detailContent?contentid=${item.contentid}"><img src="${item.imageurl}" class="d-block w-100" alt="..."></a>
				<div class="carousel-text">
					<div class="category">${item.theme}</div>
					<div class="place">${titleList2[idx.index]}</div>
				</div>
		</div>
		</c:forEach>
	</div>
	<div class="carousel-arrow">
		<div class="carousel-left arw">
			<a href="#mainViewArea3" data-slide="prev"> <i class="fas">&#xf104;</i>
			</a>
		</div>
		<div class="carousel-right arw">
			<a href="#mainViewArea3" data-slide="next"> <i class="fas">&#xf105;</i>
			</a>
		</div>
	</div>
</div>
</div>
</div>
</div>
