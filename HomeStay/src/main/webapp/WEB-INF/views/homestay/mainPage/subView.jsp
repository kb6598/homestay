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
                    num/num
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
                            <div class="carousel-item active" data-interval="5000">

                                <div class="row">
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[0].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[1].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[2].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="carousel-item" data-interval="5000">

                                <div class="row">
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card"><img src="${TourImageList[3].imageurl}" class="card-img-top" alt="">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[4].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[5].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="carousel-item" data-interval="5000">

                                <div class="row">
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[6].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[7].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="${TourImageList[8].imageurl}" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
       
    </div>
    </div>
