<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Board.JavaScript
 Description : 관리자 게시물 관리 페이지
 Author : 조윤구
 Since : 2022-06-02
--%>
<!DOCTYPE html>
<html>
<head>
  <title>게시물 관리</title>
  <meta charset="utf-8">
  <!-- css 링크 -->
<link rel="stylesheet" href="../resources/css/admin.css">

<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/comp.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <!-- js 링크 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../resources/js/admin.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
function deleteBoard(id) {
	const check = confirm("게시글을 삭제 하시겠습니까?");
	if(check) {
		const data = axios({
			url: `/board/delete/\${id}`,
			method: 'get'
			});
			data.then(function (result) {
				console.log(result)
				const dataCheck = result.data;
				if(dataCheck == 1) {
				location.reload();					
				}
			});

	}
}
function hashtagUpdate(id) {
	const data = axios({
		url: `/admin/board/\${id}`,
		method: 'get'
		});
		data.then(function (result) {
		console.log(result.data);
		});
}
function deptMarkCreate(id) {
	const check = confirm("부서 알림에 등록 하시겠습니까?")
	if(check) {
		console.log(id)
	}
}
function deptMarkDelete(id) {
	const check = confirm("부서 알림에 등록 취소 하시겠습니까?")
	if(check) {
		console.log(id)
	}
}
</script>




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
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td>${board.user.dept.name}</td>
                <td>${board.date}</td>
                <td>${board.user.name}</td>
                <td><button onclick='deleteBoard(${board.id})'>🗑</button></td>
                <td>
                  <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart" onclick="hashtagUpdate(${board.id})">#</button>
                </td>
                <c:if test="${board.starmarkId == null}">
                <td>
                  <button class="btn btn-outline-success input-group-append" type="submit" style="height: 35px;" onclick='deptMarkCreate(${board.id})'><i class="bi bi-megaphone"></i></button>
                </td>
                </c:if>
                <c:if test="${board.starmarkId != null}">
                <td>
                  <button class="btn btn-outline-success input-group-append" type="submit" style="height: 35px;" onclick='deptMarkDelete(${board.id})'><i class="bi bi-megaphone-fill"></i></button>
                </td>
                </c:if>
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
                  <i class="bi bi-patch-question"></i>
                  태그 수정
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
                    <td>${board.hashtag.name}<button class="btn" ><i class="bi bi-x"></i></button></td>
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
      						<!-- a태그 -->
        <a href="user">개인정보관리</a>
      </div>
      						<!-- a태그 -->
      <div class="well">
        <a href="board">게시물 관리</a>
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
