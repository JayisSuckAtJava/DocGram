<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Main.JavaScript
 Description : 메인페이지
 Author : 문예빈
 Since : 2022-05-26
--%>

<!DOCTYPE html>

<head>
  <title>main-로그인</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="../resources/css/board/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-medical"
    viewBox="0 0 16 16">
    <path
      d="M7.5 5.5a.5.5 0 0 0-1 0v.634l-.549-.317a.5.5 0 1 0-.5.866L6 7l-.549.317a.5.5 0 1 0 .5.866l.549-.317V8.5a.5.5 0 1 0 1 0v-.634l.549.317a.5.5 0 1 0 .5-.866L8 7l.549-.317a.5.5 0 1 0-.5-.866l-.549.317V5.5zm-2 4.5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 2a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5z" />
    <path
      d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z" />
  </svg>


</head>


<body>

  <header class="container-fluid text-center">
    <p>Header Text</p>
  </header>

  <div class="container-fluid text-center">
    <div class="row content">
      <div class="col-sm-2 sidenav">
        <p>${user.name}/${dept.name}</p>
        <p><a href="#">My page</a></p>
        <p><a href="#">로그아웃</a></p>
      </div>
      <div class="col-sm-8 text-left">
        <div class="row">
          <div class="col-sm-6">
            <h2>공지사항</h2>
            <table class="table table-hover">
              <c:forEach items="${boardList}" var="board">
                <td>${board.id}</td>
                <td class="title">${board.title}</td>
                <td>${dept.name}</td>
                <td>${board.date}</td>
              </c:forEach>
            </table>
          </div>
          <div class="col-sm-6">
            <h2>부서별 알림</h2>
            <table class="table table-hover">
              <c:forEach items="${boardList}" var="board">
                <td>${board.id}</td>
                <td class="title">${board.title}</td>
                <td>${dept.name}</td>
                <td>${board.date}</td>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
      <div class="col-sm-2 sidenav">
        <div class="starmark-list">
          <h3>즐겨찾기</h3>
          <table class="table table-hover">
            <c:forEach items="${boardList}" var="board">
              <td>${board.title}</td>
              <td>${dept.name}</td>
              <td>${board.date}</td>
            </c:forEach>
          </table>
        </div>
      </div>
    </div>
  </div>

  <footer class="container-fluid text-center">
    <p>Footer Text</p>
  </footer>

</body>

</html></html>