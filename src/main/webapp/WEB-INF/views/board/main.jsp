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
  <link rel="stylesheet" href="../resources/css/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
            <tr>
              <c:forEach items="${noticeList}" var="board">
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td>${board.user.dept.name}</td>
                <td>${board.date}</td>
              </c:forEach>
              </tr>
              <tr>
              	<td>1</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>2</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>3</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>4</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>5</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>6</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>7</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>8</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>9</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>10</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                            <tr>
              	<td>11</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                                          <tr>
              	<td>12</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                                          <tr>
              	<td>13</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                                          <tr>
              	<td>14</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
                                          <tr>
              	<td>15</td>
              	<td>공문서 어쩌구 저쩌구 제목 어라어ㅏ러아러ㅏㅇ러ㅏ어러알ㅇ</td>
              	<td>재정특별기획부</td>
              	<td>2022-06-01</td>
              </tr>
              
            </table>
            
          </div>
          <div class="col-sm-6">
            <h2>부서별 알림</h2>
            <table class="table table-hover">
              <c:forEach items="${deptList}" var="board">
              <tr>
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td>${board.user.dept.name}</td>
>>>>>>> moon
                <td>${board.date}</td>
               </tr>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
      <div class="col-sm-2 sidenav">
        <div class="starmark-list">
          <h3>즐겨찾기</h3>
          <table class="table table-hover">
            <tr>
            <c:forEach items="${starList}" var="board">
              <td>${board.title}</td>
              <td>${board.user.dept.name}</td>
              <td>${board.date}</td>
            </c:forEach>
            </tr>
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