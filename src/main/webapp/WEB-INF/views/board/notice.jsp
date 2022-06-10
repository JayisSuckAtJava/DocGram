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
    <link rel="stylesheet" href="../resources/css/board.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../resources/js/board.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
function deleteBoard(e, id) {
	e.stopPropagation();
	const check = confirm("게시글을 삭제 하시겠습니까?");
	if(check) {
		const data = axios({
			url: `/board/delete/\${id}`,
			method: 'get'
			});
			data.then(function (result) {
				const dataCheck = result.data;
				if(dataCheck == 1) {
				location.reload();					
				}
			});

	}
}
function updateBtn(e, id) {
	e.stopPropagation();
	location.href='/board/update/'+id;
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
      
      <div class="all">
        <!-- 타이틀 부분 -->

        <h3 class="title-article">공지</h3>

        <!-- 공공문서 리스트 -->

         <!-- 목록 리스트 -->
    <div class="col-12">
      <table class="table table-hover">
  
        <thead id="list_title">
  
          <tr>
            <th style="width: 7%">번호</th>
            <th style="width: 27%">제목</th>
            <th style="width: 5%"></th>
            <th style="width: 15%">소속 기관</th>
            <th style="width: 13%">작성일</th>
            <th style="width: 13%">작성자</th>
            <c:if test="${sessionScope.user.positionId >= '6' }">
            <th style="width: 9%">수정</th>
            <th style="width: 9%">삭제</th>
            </c:if>
          </tr>
        </thead>
  
        <tbody class="list-body">

          <c:forEach items="${noticeList}" var="board">
          <tr style="cursor:pointer;">
              <td>${board.id}</td>
              <td>${board.title}</td>
                                <c:if test="${board.fileId != null}">
                  <td><a href="/download/${board.fileId}" ><i class="bi bi-file-earmark-pdf"></a></td>
                  </c:if>
                  <c:if test="${board.fileId == null}">
                  <td></td>
                  </c:if>
              <td>${board.user.dept.name}</td>
              <td>${board.date}</td>
              <td>${board.user.name}</td>
              <c:if test="${sessionScope.user.positionId >= '6' }">
              <td>
                <button class="btn btn-outline-danger btn-sm"  
                        type="button" onclick="updateBtn(event, ${board.id})">수정</button>
              </td>
              <td>
                <button class="btn btn-outline-danger btn-sm"  
                        type="button" onclick="deleteBoard(event, ${board.id})">삭제</button>
              </td>
              </c:if>
           </tr>
          </c:forEach> 
           <script src="../resources/js/read.js"></script>
        </tbody>
      </table>
      <c:if test="${sessionScope.user.positionId >= '6' }">
      <div class="bb">
          	<a href="create"><button>작성하기</button></a>
          </div>
          </c:if>
      </div>
      
              <!-- 페이징 -->
              <div class="page">
                <nav aria-label="Page navigation example" style="text-align: center;" id="pagenation">
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

<!-- pagenation -->
<script src="/resources/js/page.js"></script>
<script src="/resources/js/pageinget.js"></script>
<script type="text/javascript">
window.onload = function() {
	
	if((location.search == "")){
		page();			
	}else {
		pageinget();
	}
}


</script>


</body>
</html>
