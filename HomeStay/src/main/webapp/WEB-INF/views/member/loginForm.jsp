<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
@import "bourbon";

body {
	background: #eee !important;
}

.wrapper {
	margin-top: 80px;
	margin-bottom: 80px;
}

.form-signin {
	max-width: 380px;
	padding: 15px 35px 45px;
	margin: 0 auto;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, 0.1);
	.
	form-signin-heading
	,
	.checkbox
	{
	margin-bottom
	:
	30px;
}

.checkbox {
	font-weight: normal;
}

.form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	@
	include
	box-sizing(border-box);
	&:
	focus
	{
	z-index
	:
	2;
}

}
input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

input[type="password"] {
	margin-bottom: 20px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
}
</style>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">

<meta charset="UTF-8">
<title>HomeStayKorea</title>
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<div class="row">
		<div class="col-lg-12">
             <div class="panel-body">
				<div class="wrapper">
					<form class="form-signin" action="/login" method="POST">
						<h2 class="form-signin-heading">HomeStayKorea</h2>
						<input type="text" class="form-control" name="id" placeholder="ID" /> 
							<input type="password" class="form-control" name="pw" placeholder="Password"/>
						<button class="btn btn-lg btn-primary btn-block" data-oper="login" type="submit">Login</button>
						<button class="btn btn-lg btn-primary btn-block" data-oper="join" type="submit">회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	$(document).ready(function(){
		var form = $("form");
		$("button").on("click",function(e){
			e.preventDefault();
			
			var operation = $(this).data("oper");
			console.log('operaion: ' + operation);
			if(operation === 'join') {
				form.attr("action","/member/join").attr("method", "GET");
				form.empty();
			}
			form.submit();
		});
	});
</script>
</html>













