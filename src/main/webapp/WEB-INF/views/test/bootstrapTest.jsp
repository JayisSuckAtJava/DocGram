<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<title>부트스트랩 기본 틀</title>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script></head>
<body>
	<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>
</nav>
<br>

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
  <li class="list-group-item">A second item</li>
  <li class="list-group-item">A third item</li>
  <li class="list-group-item">A fourth item</li>
  <li class="list-group-item">And a fifth one</li>
</ul>

      <div class="main_bar">
        <div class="main_notice" id="notice">
          <h3 class="notice_title">공지사항</h3>

        </div>

	
</body>
</html>