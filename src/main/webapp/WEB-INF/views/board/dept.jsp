<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Dept.JavaScript
 Description :  소속 알림 페이지
 Author : 조윤구
 Since : 2022-05-23
--%>
<!DOCTYPE html>
<html>
<head>
  <title>유저 소속 알림</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../resources/css/main.css">
    <link rel="stylesheet" href="../resources/css/comp.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  


    <link rel="stylesheet" href="../resources/css/board.css">
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

      <!--바디부분 -->

       <div class="all">
            <!-- 타이틀 부분 -->
    
            <h3 class="title-article">${sessionScope.user.dept.name}의 알림  </h3>
    


              <!-- 소속 검색부분 -->

  <div class="dl-table-wrap">
    <dl class="dl-table">
      <dt class="dt-keyword"><label for="searchKeyword">검색어</label></dt>
      <dd class="dd-keyword">
        <form  action="" method=""> <!-- form-->
        <select class="ss" name="searchField" id="searchCategory" title="검색어 분류 선택">
          <option value="all" selected="selected">제목</option>
          <option value="title">내용</option>
          <option value="dept_nm">작성자</option>

        </select>
        <input class="ss" name="searchKeyword" type="text" id="searchKeyword"
          placeholder="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)"
          title="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)" value="">
          <button class="btn btn-outline-success input-group-append" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
        </form>
      </dd>
    </dl>
    </div>
    
             <!-- 목록 리스트 -->
        <div class="col-8">
          <table class="table table-hover">
          
      
            <thead id="list_title">
      
              <tr>
                <th><i class="bi bi-star-fill"></i></th>
                <th>번호</th>
                <th>제목</th>
                <th>다운로드</th>
                <th>소속 기관</th>
                <th>작성일</th>
                <th>작성자</th>
              </tr>
            </thead>
      
            <tbody class="list-body-star">
              <tr>
                <td><i class="bi bi-star-fill"></i></td>
                <td>10</td>
                <td>공공문서 관련한 문서 관리</td>
                <td>파일</td>
                <td>세종특별청사</td>
                <td>5/19</td>
                <td>부서관</td>
              </tr>
             
              
              <c:forEach items="${boardList}" var="board">
              <tr>
               <c:if test="${board.starmarkId == null}">
               <td><i class="bi bi-star"></i></td>
               </c:if>
               <c:if test="${board.starmarkId != null}">
               <td><i class="bi bi-star-fill"></i></td>
               </c:if>
                <td>${board.id}</td>
                  <td>${board.title}</td>
                  <td><a href="/download/${board.fileId}" ><i class="bi bi-file-earmark-pdf"></a></td>
                  <td>${board.user.dept.name}</td>
              	  <td>${board.date}</td>
              	  <td>${board.user.name}</td>
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
                  
                  <!-- 페이징 a 테그 처리 해야하나? -->
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
      
      <!--  사이드 바 -->
    </div>
  </div>
</div>

<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>

</body>
</html>
