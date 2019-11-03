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
                                                <img src="https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="https://i0.hippopx.com/photos/174/613/190/mountain-landscape-mountains-landscape-steinweg-preview.jpg" class="card-img-top" alt="...">
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
                                            <div class="card"><img src="https://i0.hippopx.com/photos/174/613/190/mountain-landscape-mountains-landscape-steinweg-preview.jpg" class="card-img-top" alt="">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg" class="card-img-top" alt="...">
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
                                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="https://i0.hippopx.com/photos/174/613/190/mountain-landscape-mountains-landscape-steinweg-preview.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" >
                                                <img src="https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg" class="card-img-top" alt="...">
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
