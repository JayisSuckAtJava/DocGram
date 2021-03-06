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
  <title>main</title>
  <meta charset="utf-8">
    <link rel="icon" href="/resources/images/favicon.png">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
  <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/comp.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="/resources/js/bootstrap.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>


<body>

<!-- header -->
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
	<jsp:include page="../comp/header.jsp"></jsp:include>
</header>

  <div class="container-fluid text-center">
    <div class="row content">
      <div class="col-sm-2 sidenav">
        <c:if test="${sessionScope.user == null}">
        <p>로그인이 필요합니다.</p>
        <p><a href="/user/signin">로그인</a></p>
        <p><a href="/user/tos">회원가입</a></p>
        
        </c:if>
        <c:if test="${sessionScope.user != null}">
                <p>${user.name} / ${user.dept.name}</p>
        <p><a href="mypage">My page</a></p>
        <p><a href="user/signout">로그아웃</a></p>
        </c:if>
      </div>
      <div class="col-sm-8 text-left">
        <div class="row">
        
          <div class="col-sm-6">
            <h3>공지</h3>
            
            <c:if test="${sessionScope.user == null}">
          <br><br><br><br><br><br><br><br>
          <p>로그인 부탁 드립니다.</p>
          <br><br><br><br><br><br><br><br>
          </c:if>
            
            <c:if test="${sessionScope.user != null}">            
            <table class="table table-hover">
              <c:forEach items="${noticeList}" var="board">
      		   <tr onclick="location.href = 'board/${board.id}'" style="cursor:pointer;">
                <td style="width: 60%">${board.title}</td>
                <td style="width: 20%">${board.user.dept.name}</td>
				<td style="width: 20%">${board.date}</td>
          	  </tr>
              </c:forEach>

                          
            </table> 
            </c:if>           
          </div>
          
          
          <div class="col-sm-6">
            <h3>부서별 알림</h3>
            <c:if test="${sessionScope.user == null}">
          <br><br><br><br><br><br><br><br>
          <p>로그인 부탁 드립니다.</p>
          <br><br><br><br><br><br><br><br>
          </c:if>
            <c:if test="${sessionScope.user != null}">
            <table class="table table-hover">
              <c:forEach items="${deptList}" var="board">
              <tr onclick="location.href = 'board/${board.id}'" style="cursor:pointer;">
                <td style="width: 60%">${board.title}</td>
                <td style="width: 20%">${board.user.dept.name}</td>
				<td style="width: 20%">${board.date}</td>
               </tr>
              </c:forEach>
            </table>
            </c:if>
          </div>
          
          
        </div>
      </div>
      
      <div class="col-sm-2 sidenav">
        <div class="starmark-list">
          <h3>즐겨찾기</h3>
          <c:if test="${sessionScope.user == null}">
          <br><br><br><br><br><br><br>
          <p>로그인 부탁 드립니다.</p>
          <br><br><br><br><br><br><br><br>
          </c:if>
          
          <c:if test="${sessionScope.user != null}">
          <table class="table table-hover">
            <c:forEach items="${starList}" var="board">
            <tr onclick="location.href = 'board/${board.id}'" style="cursor:pointer;">
              <td>${board.title}</td>
<%--               <td style="width: 30%">${board.user.dept.name}</td> --%>
<%--               <td>${board.date}</td>  --%>
              </tr>
            </c:forEach>
          </table>
          </c:if>
        </div>
      </div>
    </div>
  </div>

<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>

</body>
</html>