<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/main.css">
<title>Insert title here</title>
</head>
<body>
      <div class="left-sidebar">
        
        <h2>Left Sidebar</h2>
        <ul>
          <li>Lorem</li>
          <li>Ipsum</li>
          <li>Dolor</li>
        </ul>
      </div>

      <div class="main_bar">
        <div class="main_notice" id="notice">
          <h3 class="notice_title">공지사항</h3>
          <hr>
          <div class="notice_list">
            <c:forEach items="${boardList}" var="board">
              <a href="">
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>
              </a>
            </c:forEach>
          </div>

          <!--문서 리스트 예시(형식x)-->
          <li>
            <a href="">
              <span>★</span>
              <span>[제306회 임시회]서울주택도시공사 업무 보고</span>
              <span>기후환경본부</span>
              <span>2022-04-22</span>
            </a>
          </li>
          </ul>
        </div>
        <div class="main_recentBoard_dept" id="recentBoard_dept">
          <h3 class="recentBoard_dept_title">최신 문서[부서별]</h3>          
            <c:forEach items="${boardList}" var="board">
              <tr class="recentBoard_dept_list">  
              <a href="">
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>
              </a> 
            </tr>
            </c:forEach>
        </div>
        <div class="main_recentBoard_all" id="recentBoard_dept">
          <h3 class="recentBoard_all_title">최신 문서[전 체]</h3>
          <c:forEach items="${boardList}" var="board">
              <tr class="recentBoard_all_list">
              <a href="">
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>
              </a>
            </tr>
            </c:forEach>
        </div>
        <div class="main_recentBoard_team" id="recentBoard_dept">
          <h3 class="recentBoard_team_title">최신 문서[팀 별]</h3>
          <c:forEach items="${boardList}" var="board">
              <tr class="recentBoard_team_list">
              <a href="">
                <td>${user.starmark}</td>
                <td>${board.title}</td>
                <td>${department.description}</td>
                <td>${user.date}</td>
              </a>
            </tr>
            </c:forEach>
        </div>
      </div>

      <div class="right-sidebar">
        <h2>Rigth Sidebar</h2>
        <ul>
          <li>Lorem</li>
          <li>Ipsum</li>
          <li>Dolor</li>
        </ul>
      </div>
      
</body>
</html>