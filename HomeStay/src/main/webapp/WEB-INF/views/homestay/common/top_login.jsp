<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/common/bootstrap"></jsp:include>
<link rel="stylesheet" href="/resources/mainContent/top.css">

<div class="container">
    <div class="row top-header">
        <div class="col-sm-9">
            <a href="../main">
                <logo>HomeStay Korea</logo>
            </a>
        </div>
        <div class="col-sm-3">
            	<a>${memberinfo.id} 님  &nbsp&nbsp</a>
                <a class="btn btn-outline-dark" href="/logout">Log Out</a>
        </div>
    </div>
</div>