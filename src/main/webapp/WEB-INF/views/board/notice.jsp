<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Detail.JavaScript
 Description : 공지 글 게시판
 Author : 조윤구
 Since : 2022-05-21
--%>
<!DOCTYPE html>
<html>
<head>
  <title>공지사항 페이지</title>
  <meta charset="utf-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../resources/css/main.css">
    <link rel="stylesheet" href="../resources/css/comp.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../resources/js/board.js"></script>

</head>
<body>

<!-- header -->
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
	<jsp:include page="../comp/header.jsp"></jsp:include>
</header>




<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
      
      <div class="all">
        <!-- 타이틀 부분 -->

        <h3 class="title-article">공지사항 (모두알림) </h3>

        <!-- 공공문서 리스트 -->

         <!-- 목록 리스트 -->
    <div class="col-8">
      <table class="table table-hover">
  
        <thead id="list_title">
  
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>다운로드</th>
            <th>소속 기관</th>
            <th>작성일</th>
            <th>작성자</th>
            <th>수정하기</th>
            <th>삭제하기</th>
          </tr>
        </thead>
  
        <tbody class="list-body">
          <tr>
            <td>10</td>
            <td>공공문서 관련한 문서 관리</td>
            <td><i class="bi bi-file-earmark-pdf"></i></td>
            <td>세종특별청사</td>
            <td>5/19</td>
            <td>부서관</td>
            <td>
              <button class="btn btn-danger pull-right"  
                      type="button" onclick="getUserName1()">수정</button>
            </td>
            <td>
              <button class="btn btn-danger pull-right"  
                      type="button" onclick="getUserName2()">삭제</button>
            </td>
          </tr>

          </tr>
          <c:forEach items="${noticeList}" var="board">
          <tr>
              <td>${board.id}</td>
              <td>${board.title}</td>
              <td><a href="/download/${board.fileId}" ><i class="bi bi-file-earmark-pdf"></i></a></td>
              <td>${board.user.dept.name}</td>
              <td>${board.date}</td>
              <td>${board.user.name}</td>
              <td>
                <button class="btn btn-danger pull-right"  
                        type="button" onclick="getUserName1()">수정</button>
              </td>
              <td>
                <button class="btn btn-danger pull-right"  
                        type="button" onclick="getUserName2()">삭제</button>
              </td>
           </tr>
          </c:forEach> 
           <script src="../resources/js/read.js"></script>
        </tbody>
      </table>
      <div class="bb">
          	<a href="create"><button>작성하기</button></a>
          </div>
      </div>
      
      

    
              <!-- 페이징 -->
              <div class="page">
                <nav aria-label="Page navigation example" style="text-align: center;" >
                  <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                    
                      <a class="page-link">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item">
                      <a class="page-link" href="#">Next</a>
                    </li>
                  </ul>
                </nav>
              </div>


      </div>

    </div>
    <div class="col-sm-2 sidenav">

    </div>
  </div>
</div>

<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>


</body>
</html>
