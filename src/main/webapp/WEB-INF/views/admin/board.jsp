<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>게시물 관리</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">


        <!-- css 링크 -->
        <link rel="stylesheet" href="../../css/admin.css">

        <!-- js 링크 -->
        <script src="../../js/admin.js"></script>

  <!-- <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style> -->
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
      
      <!-- 문서 검색부분 -->

      <h3 class="title-article">게시물 관리</h3>

 <div class="dl-table-wrap">
   <dl class="dl-table">
     <dt class="dt-keyword"><label for="searchKeyword">검색어</label></dt>
     <dd class="dd-keyword">
       <form action="" method=""> <!-- form-->
       <select class="ss" name="searchField" id="searchCategory" title="검색어 분류 선택">
         <option value="all" selected="selected">제목</option>
         <option value="title">내용</option>
         <option value="dept_nm">작성자</option>
         <option value="writer">기관</option>
       </select>
       <input class="ss"  name="searchKeyword" type="text" id="searchKeyword"
         placeholder="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)"
         title="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)" value="">
         <button class="btn btn-outline-success input-group-append" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
        </form>
      
     </dd>
   </dl>

      
      <h3>목록</h3>
      <!-- 목록 리스트 -->
      <div class="col-8">
        <table class="table table-hover">


          <thead id="list_title">

            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>소속 기관</th>
              <th>작성 일</th>
              <th>작성자</th>
              <th>🗑</th>
              <th>📌</th>
              <th><i class="bi bi-megaphone-fill"></th>
            </tr>
          </thead>

          <tbody class="table table-hover">
            <tr>
              <td >10</td>
              <td>제목들</td>
              <td>소속기관</td>
              <td>작성일</td>
              <td>작성자</td>
              <td>🗑</td>

              <td>
                <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart">#</button>                              
              </td>
              <td>
                <button class="btn btn-outline-success input-group-append" type="submit" style="height: 35px;"><i class="bi bi-megaphone-fill"></i></button>
              </td>

            </tr>
            <c:forEach items="${boardList}" var="board">
              <tr>
                <td>${numb}</td>
                <td>${제목}</td>
                <td>${기관}</td>
                <td>${작성일}</td>
                <td>${작성자}</td>
                <td>🗑</td>
                <td>
                  <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart">#</button>
                </td>
                <td>
                  <button class="btn btn-outline-success input-group-append" type="submit" style="height: 35px;"><i class="bi bi-megaphone"></i></button>
                </td>
              </tr>
            </c:forEach>

          </tbody>
        </table>


        <!-- 페이징 -->
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

        <!-- Modal: modalCart -->
        <div class="modal fade" id="modalCart" tabindex="-1" role="dialog"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <!--Modal Header-->
            <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">
                <a class="">
                  <i class="bi bi-patch-question"></i>
                  태그 수정
                </a>
              </h4>
              <form class="d-flex" method="" action="" role="search" style="display: flex;">
                <input class="form-control me-2" type="search" name="search" placeholder="Search"
                  aria-label="Search">
                <button class="btn btn-outline-success input-group-append" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
              </form>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
              </button>
            </div>
            <!--Modal Body-->
            <div class="modal-body">

              <table class="table table-hover">
                <thead>
                  <tr>
                    <th>태그</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>${태그}<button class="btn" ><i class="bi bi-x"></i></button></td>
                  </tr>
                </tbody>
              </table>

            </div>
            <!--Footer-->
            <div class="modal-footer">
              <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
        
      </div>
    </div>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <a>개인정보관리</a>
      </div>
      <div class="well">
        <a>게시물 관리</a>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
>>>>>>> 737b6579f9fc0c5d04e9cd85323a62155a815251
