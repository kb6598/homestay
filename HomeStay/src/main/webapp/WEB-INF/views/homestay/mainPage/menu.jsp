<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" style="width:100%;">

	<div class="row regionCategory">


		<%
		/*		<option value="0">권역</option>
 	          	<option value="서울">서울</option>
	          	<option value="경기">경기</option>
	          	<option value="인천">인천</option>
	          	<option value="강원">강원</option>
	          	<option value="충청">충청</option>
	          	<option value="대구">대구</option>
	          	<option value="부산">부산</option>
	          	<option value="울산">울산</option>
	          	<option value="광주">광주</option>
	          	<option value="제주">제주</option>
	          </select> */
	          
/* 	          
	  		String locs1[] ={"전체","서울","경기도","인천","부산","충청남도","대전","울산","강원도"};
	  		String locs2[] = {"충청북도","대구","세종특별자치시","전라북도","전라남도","제주도","광주"}; // 세종특별자치시는 여행지가 2개 밖에 없음.
			//String locs[] ={"전체","서울","경기","인천","강원","충청","대구","부산","울산","광주","제주"}; */
		String locs1[] ={"전체","서울","경기도","인천","부산","대전","대구","울산"};
		String locs2[] = {"제주도","광주","강원도","충청북도","충청남도","전라북도","전라남도","세종특별자치시"}; // 세종특별자치시는 여행지가 2개 밖에 없음.
		//String locs2[] = {	"충청북도","대구","전라북도","전라남도","경상남도","경상북도","제주도","광주"};
		String curLoc;
		if(request.getParameter("location") != null){
			curLoc= request.getParameter("location").toString();
		}else{
			curLoc = "전체";
		}		 

		for(String loc : locs1){
			if(loc.equals(curLoc)){
				%><%= "<div class='col-sm regionItem selected'>" %><%
			}else{
				%><%= "<div class='col-sm regionItem'>" %><%
			}
			%><%= "<a href='/main?location="+URLEncoder.encode(loc, "UTF-8").toString()+"'>"+loc+"</a></div>" %><%
		}
		%>
		</div>
		<div class="row regionCategory">
		<%
		for(String loc : locs2){
			if(loc.equals(curLoc)){
				%><%= "<div class='col-sm regionItem selected'>" %><%
			}else{
				%><%= "<div class='col-sm regionItem'>" %><%
			}
			%><%= "<a href='/main?location="+URLEncoder.encode(loc, "UTF-8").toString()+"'>"+loc+"</a></div>" %><%
		}
		
		
		%></div>
					

	</div>
</div>



