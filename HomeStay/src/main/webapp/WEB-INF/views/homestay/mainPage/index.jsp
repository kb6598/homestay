<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>HomeStay</title>
<jsp:include page="/common/bootstrap"></jsp:include>
</head>
<body>
<div class="row">
<div class="col-lg"><jsp:include page="/mainpage/top" flush="true"/></div>
</div>
<div class="row">
<div class="col-lg"><jsp:include page="/mainpage/topview" flush="true"/></div>
</div>
<div class="row">
<div class="col-lg"><jsp:include page="/mainpage/menu" flush="true"/></div>
</div><div class="row">
<div class="col-lg"><jsp:include page="/mainpage/mainview?theme=${theme}&theme_kor=${theme_kor}" flush="true"/></div>
</div><div class="row">
<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme}&theme_kor=${theme_kor}" flush="true"/></div>
</div><div class="row">
<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme}&theme_kor=${theme_kor}" flush="true"/></div>
</div><div class="row">
<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme}&theme_kor=${theme_kor}" flush="true"/></div>
</div><div class="row">
<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme}&theme_kor=${theme_kor}" flush="true"/></div>
</div><div class="row">
<div class="col-lg"><jsp:include page="/mainpage/subview?theme=${theme}&theme_kor=${theme_kor}" flush="true"/></div>
</div>






</body>
</html>