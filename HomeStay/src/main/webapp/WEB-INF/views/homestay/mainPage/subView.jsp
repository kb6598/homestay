<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<jsp:include page="/common/bootstrap"></jsp:include>
<link rel="stylesheet" href="/resources/mainContent/subView.css">

   <div class="container container-subview">
    <div class="row subview">
        <div class="container">
            <div class="row subview-header">
                <div class="col-lg">
                    <h5>${theme_kor}</h5>
                </div>
                <div class="col-lg">
                    <div class="btn-wrapper" >
                    <a class="btn-secondary" href="#subView_${theme}" data-slide="prev">◁</a>
                    
                    <a class="btn-secondary" href="#subView_${theme}" data-slide="next">▷</a>
                    </div>
                </div>
            </div>
     </div>
            <div class="row subview-center">
                <div class="col-lg">
                    <div id="subView_${theme}" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#subView" data-slide-to="0" class="active"></li>
                            <li data-target="#subView" data-slide-to="1"></li>
                            <li data-target="#subView" data-slide-to="2"></li>
                        </ol>
						<div class="carousel-inner">
							<c:set var="tmpidx" value = "0" scope="page"/>
							<c:forEach begin="0" end="2" step="1" var="i">
								<c:choose>
									<c:when test="${i == 0}">
                            			<div class="carousel-item active" data-interval="5000">
                                			<div class="row">
                                	</c:when>
                                	<c:otherwise>
                            			<div class="carousel-item" data-interval="5000">
                                			<div class="row">
                                	</c:otherwise>
                                </c:choose>
                                
                                <c:forEach begin="0" end="2" step="1" var="j">
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <a href="/detailContent?contentid=${joinPlaceTourImageDTO[tmpidx].contentid }"><img src="${joinPlaceTourImageDTO[tmpidx].imageurl}" class="card-img-top" alt="..."></a>
                                                <div class="card-body">
                                                    <h5 class="card-title"><a href="/detailContent?contentid=${joinPlaceTourImageDTO[tmpidx].contentid }">Card title</a></h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:set var="tmpidx" value = "${tmpidx + 1}" scope="page"/>
								</c:forEach>
                                </div>
                               </div>
                             </c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
