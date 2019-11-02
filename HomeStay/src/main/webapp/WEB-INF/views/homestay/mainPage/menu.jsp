<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/common/bootstrap"></jsp:include>
<link rel="stylesheet" href="/resources/mainContent/menu.css">
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">

	<div class="row">

		<div class="regionCategory">
		<%
			String locs[] ={"전체","서울","경기","인천","강원","충청","대구","부산","울산","광주","제주"};
		String curLoc;
		if(request.getParameter("location") != null){
			curLoc= request.getParameter("location").toString();
		}else{
			curLoc = "전체";
		}
		 

		for(String loc : locs){
			if(loc.equals(curLoc)){
				%><%= "<div class='col-sm regionItem selected'>" %><%
			}else{
				%><%= "<div class='col-sm regionItem'>" %><%
			}
			%><%= "<a href='/main?location="+loc+"'>"+loc+"</a></div>" %><%
		}
		
		%>
					
		</div>
	</div>
</div>



