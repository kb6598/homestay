<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<title>HomeStay</title>
<jsp:include page="/common/bootstrap"></jsp:include>
<link rel="stylesheet" href="/resources/mainContent/top.css">
<link rel="stylesheet" href="/resources/mainContent/topView.css">
<link rel="stylesheet" href="/resources/mainContent/menu.css">
<link rel="stylesheet" href="/resources/mainContent/mainView.css">
<link rel="stylesheet" href="/resources/mainContent/subView.css">
</head>
<body>
	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/top" flush="false" /></div>
	</div>
	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/topview" flush="false" /></div>
	</div>
	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/menu?location=${location}" flush="false" /></div>
	</div>
	
	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/mainview?theme1=${theme1}&theme_kor1=${theme_kor1}&theme2=${theme2}&theme_kor2=${theme_kor2}&theme3=${theme3}&theme_kor3=${theme_kor3}&location=${location}" flush="false" /></div>
	</div>

	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme4}&theme_kor=${theme_kor4}&location=${location}" flush="false" /></div>
	</div>
	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme5}&theme_kor=${theme_kor5}&location=${location}" flush="false" /></div>
	</div>
	 
	<div class="row">
		<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme6}&theme_kor=${theme_kor6}&location=${location}" flush="false" /></div>
	</div>

<script>

    var imgs = document.getElementsByTagName("img");

    for(i = 0;i < imgs.length; i++)
    {
    	imgs[i].setAttribute("onError","http://toeic.ybmclass.com/toeic/img/noimage.gif");
        if(imgs[i].getAttribute("src") == null || imgs[i].getAttribute("src") == ""||imgs[i].getAttribute("src") == "null"||imgs[i].getAttribute("src") == "noImage"){
            imgs[i].setAttribute("src","http://toeic.ybmclass.com/toeic/img/noimage.gif");
            
        }
    }
            var as = document.getElementsByTagName("a");

    for(i = 0;i < as.length; i++)
    {
    	
        if(as[i].getAttribute("href") == null || as[i].getAttribute("href") == ""||as[i].getAttribute("href") == "null"||as[i].getAttribute("href") == "/detailContent?contentid="){
            as[i].removeAttribute("href");
            
        }
    }

    </script>	
	
</body>
</html>