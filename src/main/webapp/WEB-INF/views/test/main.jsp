<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Main.JavaScript
 Description : 메인페이지
 Author : 문예빈
 Since : 2022-05-26
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/main.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script></head>
<title>Main page</title>
</head>
<body>
	<!-- mypage sidebar -->
<div class="main-sidebar">
	<div class="main-category-list">

		  <ul>
		  	<li>
		    	이름/소속
		    </li>
		    <li><a href="">마이페이지</a></li>
		    <li><a href="">로그아웃</a></li>
		  </ul>

	</div>      
</div> 
     
    <!-- main bar -->
      <div class="main_bar">
        <div class="main_notice" id="notice">
          <h3 class="notice_title">공지사항</h3>
          <ul class="list-group list-group-flush">
  		<li class="list-group-item">   
          <div class="notice_list">
            <c:forEach items="${boardList}" var="board">
                <td>${user.starmark}1</td>
                <td>${board.title}2</td>
                <td>${department.description}3</td>
                <td>${user.date}4</td>
            </c:forEach>
          </div>
          </li>
          </ul>
        </div>
        <div class="main_recentBoard_dept" id="recentBoard_dept">
          <h3 class="recentBoard_dept_title">최신 문서[부서별]</h3>          
            <c:forEach items="${boardList}" var="board">
              <tr class="recentBoard_dept_list">  
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>
            </tr>
            </c:forEach>
        </div>        
        <div class="main_recentBoard_all" id="recentBoard_dept">
          <h3 class="recentBoard_all_title">최신 문서[전 체]</h3>
          <c:forEach items="${boardList}" var="board">
              <tr class="recentBoard_all_list">
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>
            </tr>
            </c:forEach>
        </div>
        <div class="main_recentBoard_team" id="recentBoard_dept">
          <h3 class="recentBoard_team_title">최신 문서[팀 별]</h3>
          <c:forEach items="${boardList}" var="board">
            <tr class="recentBoard_team_list">
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>           
            </tr>
          </c:forEach>
        </div>
      </div>

      
	<!-- right sidebar -->
     <div class="right-sidebar">
  <h2>
    <a href="">
      즐겨찾기
    </a>
  </h2>
  <c:forEach items="${boardList}" var="board">
    <tr class="recentBoard_team_list">
        <td>${user.starmark}</td>
        <td>${board.title}</td>
        <td>${department.description}</td>
        <td>${user.date}</td>    
    </tr>
  </c:forEach>
</div>


      <br><br><br><br>



    <footer></footer>

      
</body>
</html>