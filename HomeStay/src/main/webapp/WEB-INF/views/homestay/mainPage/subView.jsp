<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>HomeStay</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>

    	
        .btn-wrapper{
            float: right;
        }
        .subview {
            width: 100%;
            margin: 15px 0px;
        }
        .subview-header{
        margin: 10px 0px;
        }

        .carousel-item {
            overflow: hidden;

        }

        img {
            width: 100%;
            height: 250px;
            object-fit: cover
        }
    </style>
</head>

<body>
   <div class="container container-subview">
    <div class="row subview">
        <div class="container">
            <div class="row subview-header">
                <div class="col-lg">
                    <h5>제목</h5>
                </div>
                <div class="col-lg">
                    <div class="btn-wrapper" >
                    <a class="btn-secondary" href="#subView" data-slide="prev">◁</a>
                    num/num
                    <a class="btn-secondary" href="#subView" data-slide="next">▷</a>
                    </div>
                </div>
            </div>
        </div>
     
            <div class="row subview-center">
                <div class="col-lg">
                    <div id="subView" class="carousel slide carousel-fade" data-ride="carousel">
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
                                            <div class="card" style="">
                                                <img src="https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" style="">
                                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" style="">
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
                                            <div class="card" style="">
                                                <img src="https://cdn.pixabay.com/photo/2018/06/16/07/48/nature-3478370_960_720.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" style="">
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
                                            <div class="card" style="">
                                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/ab/%EA%B4%91%EC%A3%BC%EB%8C%80_%EB%B4%84%ED%92%8D%EA%B2%BD.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" style="">
                                                <img src="https://i0.hippopx.com/photos/174/613/190/mountain-landscape-mountains-landscape-steinweg-preview.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">Card title</h5>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-sm">
                                        <div class="container">
                                            <div class="card" style="">
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
</body>

</html>