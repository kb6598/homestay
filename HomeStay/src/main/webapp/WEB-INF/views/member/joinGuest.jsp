<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<script>
$(".login-form").validate({
	  rules: {
	    id: {
	      required: true,
	      minlength: 4
	    },     
	  
	    password: {
	      required: true,
	      minlength: 5
	    },
	    cpassword: {
	      required: true,
	      minlength: 5,
	      equalTo: "#password"
	    }
	  },
	  //For custom messages
	  messages: {
	    username:{
	      required: "Enter a username",
	      minlength: "Enter at least 4 characters"
	    }
	  },
	  errorElement : 'div',
	  errorPlacement: function(error, element) {
	    var placement = $(element).data('error');
	    if (placement) {
	      $(placement).append(error)
	    } else {
	      error.insertAfter(element);
	    }
	  }
	});
	
function inputPhoneNumber(obj) {



    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";



    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}


</script>
<script language="JavaScript">

// 설정 시작
var maxChecked = 3;
var totalChecked = 0;
// 설정 끝
function CountChecked(field) {
if (field.checked)
totalChecked += 1;
else
totalChecked -= 1; 
if (totalChecked > maxChecked) {
alert ("최대 3개 까지만 가능합니다.");
field.checked = false;
totalChecked -= 1;
} 
}
function ResetCount(){
totalChecked = 0;
}
</script>
<style>
body {
	display: table-cell;
	vertical-align: middle;
	background-color: #e0f2f1 !important;
}

html {
	display: table;
	margin: auto;
}

html, body {
	height: 100%;
}

.medium-small {
	font-size: 0.9rem;
	margin: 0;
	padding: 0;
}

.login-form {
	width: 280px;
}

.login-form-text {
	text-transform: uppercase;
	letter-spacing: 2px;
	font-size: 0.8rem;
}

.login-text {
	margin-top: -6px;
	margin-left: -6px !important;
}

.margin {
	margin: 0 !important;
}

.pointer-events {
	pointer-events: auto !important;
}

.input-field>.material-icons {
	padding-top: 10px;
}

.input-field div.error {
	position: relative;
	top: -1rem;
	left: 3rem;
	font-size: 0.8rem;
	color: #FF4081;
	-webkit-transform: translateY(0%);
	-ms-transform: translateY(0%);
	-o-transform: translateY(0%);
	transform: translateY(0%);
}
</style>
<!-- 부트스트랩 -->
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 마테리얼라이즈 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


<meta charset="UTF-8">
<title>HomeStayKorea</title>
</head>
<body>
	<div id="login-page" class="row">
		<div class="col s12 z-depth-4 card-panel">
			<form class="login-form" action="/join" method="POST">
				<div class="row">
					<div class="input-field col s12 center">
						<h4>Register</h4>
						<p class="center">Welcome To HomeStayKorea!</p>
					</div>
				</div>

				<div class="row margin">
					<div class="input-field col s12">

						<input id="id" name="id" type="text" /> <label for="id">아이디</label>
					</div>
				</div>


				<div class="row margin">
					<div class="input-field col s12">
						<!-- <i class="mdi-action-lock-outline prefix"></i> -->

						<input id="password" name="pw" type="password" /> <label
							for="password">비밀번호</label>
					</div>
				</div>

				<div class="row margin">
					<div class="input-field col s12">
						<!-- <i class="mdi-action-lock-outline prefix"></i> -->

						<input id="password_a" name="cpassword" type="password" /> <label
							for="password_a">비밀번호 확인</label>
					</div>
				</div>

				<div class="row margin">
					<div class="input-field col s12">
						<!-- <i class="mdi-action-lock-outline prefix"></i> -->

						<input id="name" name="name" type="text" /> <label for="name">이름</label>
					</div>
				</div>

				<div class="row margin">
					<div class="input-field col s12">
						<!-- <i class="mdi-action-lock-outline prefix"></i> -->

						<select name="nation" id="nation" class="custom-select">
							<option value="0">국가</option>
							<c:forEach var="country" items="${list}" varStatus="i">
								<option value="${country.id}">${country.cname}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row margin">
					<div class="input-field col s12">
						<!-- <i class="mdi-action-lock-outline prefix"></i> -->

						<select name="regional" id="regional" class="custom-select">
							<option value="0">권역</option>
							<option value="서울">서울</option>
							<option value="경기도">경기도</option>
							<option value="인천">인천</option>
							<option value="부산">부산</option>
							<option value="대전">대전</option>
							<option value="대구">대구</option>
							<option value="울산">울산</option>
							<option value="제주도">제주도</option>
							<option value="광주">광주</option>
							<option value="강원도">강원도</option>
							<option value="충청북도">충청북도</option>
							<option value="충청남도">충청남도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="세종특별자치시">세종특별자치시</option>
						</select>
					</div>
				</div>



				<div class="row margin">
					<div class="input-field col s12">
						<!-- <i class="mdi-action-lock-outline prefix"></i> -->
						<input id="phone" name="phone" type="text"
							onKeyup="inputPhoneNumber(this)" maxlength="13" /> <label
							for="phone">전화번호</label>
					</div>
				</div>

				<label for="gender">성 별
					<div class="row margin">
						<div class="input-field col s12">

							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input"
									id="gender_male" name="gender" value="m" /> <label
									class="custom-control-label" for="gender_male">남 자</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input"
									id="gender_female" name="gender" value="f" /> <label
									class="custom-control-label" for="gender_female">여 자</label>
							</div>
						</div>
					</div>
				</label> <label for="age">연 령 대
					<div class="row margin">
						<div class="input-field col s12">
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="age10"
									name="age" value="10" /> <label class="custom-control-label"
									for="age10">10대</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="age20"
									name="age" value="20" /> <label class="custom-control-label"
									for="age20">20대</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="age30"
									name="age" value="30" /> <label class="custom-control-label"
									for="age30">30대</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="age40"
									name="age" value="40" /> <label class="custom-control-label"
									for="age40">40대</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="age50"
									name="age" value="50" /> <label class="custom-control-label"
									for="age50">50대</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input" id="age60"
									name="age" value="60" /> <label class="custom-control-label"
									for="age60">60대</label>
							</div>
						</div>
					</div>
				</label> <label for="companion">여 행 동 반 자
					<div class="row margin">
						<div class="input-field col s12">
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input"
									id="companion_solo" name="companion" value="solo" /> <label
									class="custom-control-label" for="companion_solo">혼자</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input"
									id="companion_family" name="companion" value="family" /> <label
									class="custom-control-label" for="companion_family">가족</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input"
									id="companion_friends" name="companion" value="friends" /> <label
									class="custom-control-label" for="companion_friends">친구</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="radio" class="custom-control-input"
									id="companion_couple" name="companion" value="couple" /> <label
									class="custom-control-label" for="companion_couple">애인</label>

							</div>
						</div>
				</label> <label for="theme">관 광 지 (최대3개)
					<div class="row margin">
						<div class="input-field col s12">
							<div class="custom-control custom-radio custom-control-inline">
								<input type="checkbox" class="custom-control-input"
									id="theme_tour" name="tour_attr" value="1"
									onclick="CountChecked(this)" /> <label
									class="custom-control-label" for="theme_tour">관광지</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="checkbox" class="custom-control-input"
									id="theme_cult" name="cult_facil" value="1"
									onclick="CountChecked(this)" /> <label
									class="custom-control-label" for="theme_cult">문화시설</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="checkbox" class="custom-control-input"
									id="theme_event" name="event" value="1"
									onclick="CountChecked(this)" /> <label
									class="custom-control-label" for="theme_event">축제 및 공연</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="checkbox" class="custom-control-input"
									id="theme_shopping" name="shopping" value="1"
									onclick="CountChecked(this)" /> <label
									class="custom-control-label" for="theme_shopping">쇼핑</label>
							</div>

							<div class="custom-control custom-radio custom-control-inline">
								<input type="checkbox" class="custom-control-input"
									id="theme_leports" name="leports" value="1"
									onclick="CountChecked(this)" /> <label
									class="custom-control-label" for="theme_leports">레포츠</label>

							</div>
							<div class="custom-control custom-radio custom-control-inline">
								<input type="checkbox" class="custom-control-input"
									id="theme_dining" name="dining" value="1"
									onclick="CountChecked(this)" /> <label
									class="custom-control-label" for="theme_dining">음식점</label>

							</div>
						</div>
				</label>


				<div class="row">
					<div class="input-field col s12">
						<button type="submit" class="btn waves-effect waves-light col s12">회원가입</button>

					</div>
					<div class="input-field col s12">
						<p class="margin center medium-small sign-up">
							아이디가 이미 있으십니까? <a href="./loginForm">로그인</a>
						</p>
					</div>
				</div>


			</form>
		</div>
	</div>
</body>
</html>