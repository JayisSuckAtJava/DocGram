<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name :  Search.JavaScript
 Description : 상세 검색 페이지
 Author : 조윤구
 Since : 2022-05-20
--%>

<!DOCTYPE html>
<html>
<head>
  <title>상세 검색</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../resources/css/main.css">
    <link rel="stylesheet" href="../resources/css/comp.css">
    <link rel="stylesheet" href="../resources/css/read.css">

  
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

  <div class="dl-table-wrap">
  <div>
  <form action="" method="get">
    <dl class="dl-table">
      <dt class="dt-keyword"><label for="searchKeyword">검색어</label></dt>
      <dd class="dd-keyword">
        <select class="ss" name="sel" id="searchCategory" title="검색어 분류 선택">
          <option value="title" selected="selected">제목</option>
          <option value="content">내용</option>
          <option value="name">작성자</option>
          <option value="dept">기관</option>
        </select>
        <input class="ss" name="text" type="text" id="searchKeyword" style="margin-left: 3%;"
          placeholder="검색어를 입력하세요."
          title="검색어를 입력하세요." value="">
      </dd>
    </dl>

    <dl class="dl-table">
      <dt class="dt-open"><span>항목<em>(다중선택)</em></span></dt>
      <dd class="dd-date">
        <select name="position" id="rangeDateUi" title="기간설정 선택">
          <option value="null" selected="selected">직책(전체)</option>
          <option value="1">서기보</option>
          <option value="2">서기</option>
          <option value="3">주사보</option>
          <option value="4">주사</option>
          <option value="5">사무관</option>
          <option value="6">서기관</option>
          <option value="7">부이사관</option>
          <option value="8">이사관</option>
          <option value="9">관리관</option>
        </select>
        
        <input name="fileName" type="text" id="searchKeyword" style="margin-left: 3%; width: 30%;" 
        placeholder="원하시는 파일명을 입력하세요"
          title="원하시는 파일명을 입력하세요" value="">
          <input name="fileNum" type="text" id="searchKeyword" style="margin-left: 3%; width: 30%"
        placeholder="문서 번호"
          title="문서번호" value="">

        </dd>
    </dl>


    <dl class="dl-table">
      <dt class="dt-open"><span>태그검색<em>(다중입력 , 로 구분)</em></span></dt>
      <dd class="dd-date">
        <input name="hashtagList" type="text" id="searchKeyword" style="width: 30%;"
        placeholder="태그를 입력하세요 (예 행정,공공기관 )"
          title="태그를 입력하세요 (예 행정,공공기관 )" value="">
        </dd>
    </dl>



    <dl class="dl-table">
      <dt class="dt-date"><label for="rangeDateUi">검색기간</label></dt>
      <dd class="dd-date">
        <select name="dateRange" id="rangeDateUi" title="기간설정 선택">
          <option value="null" selected="selected">전체</option>
          <option value="31">1개월</option>
          <option value="92">3개월</option>
          <option value="183">6개월</option>
          <option value="365">1년</option>
        </select>
          <div class="btn-search">
    <button type="submit" class="btn btn-outline-secondary btn-search">검색</button>
  </div>

      </dd>
      
    </dl>
 </form>
  </div>
  <!--// .dl-table-wrap -->

 
    <hr>
  </div>
    <!-- 상세 검색 부분  끝 -->


    <!-- 목록 리스트 -->
    <table class="table table-hover">

	<div>
	<span> 검색된 데이터의 총 합은 : ${listSize} 개 입니다.</span>
	</div>

      <thead id="list_title">

        <tr>
          <th style="width: 7%"><i class="bi bi-star"></i></th>
          <th style="width: 7%">번호</th>
          <th style="width: 38%">제목</th>
          <th style="width: 7%"></th>
          <th style="width: 15%">소속기관</th>
          <th style="width: 13%">작성일</th>
          <th style="width: 13%">작성자</th>
        </tr>
      </thead>

      <tbody class="table table-hover list-body-star">
        <c:forEach items="${boardList}" var="board">
          <tr style='cursor:pointer;'>
            
            <!--  아래 c:if를 통해서 즐찾 리스트가 맞으면 출력 하는걸로 -->
           <c:if test="${board.starmarkId == null}">
               <td id="emptyStar"><i class="bi bi-star"></i></td>
               </c:if>
               <c:if test="${board.starmarkId != null}">
               <td id="filledStar"><i class="bi bi-star-fill"></i></td>
               </c:if>
            <td>${board.id}</td>
            <td>${board.title}</td>
            <td><a href="/download/${board.fileId}" ><i class="bi bi-file-earmark-pdf"></i></a></td>
            <td>${board.user.dept.name}</td>
            <td>${board.date}</td>
            <td>${board.user.name}</td>
          </tr>
        </c:forEach>
  <script src="/resources/js/read.js"></script>
      </tbody>
    </table>
      
      
      <!-- 페이징 -->
      <div class="page">
        <nav aria-label="Page navigation example" style="text-align: center;" id="pagenation">
        </nav>
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
	
	if(location.search == ""){
		page();			
	}else {
		pageinget();
	}
}
</script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script type="text/javascript">
    
    const emptyStar = document.querySelectorAll("#emptyStar")
    emptyStar.forEach((v)=>{
        v.addEventListener("click",(e)=>{
            let boardId = v.nextElementSibling.innerHTML;
            starCreate(e, boardId);
        });
    });
    
    const filledStar = document.querySelectorAll("#filledStar")
    filledStar.forEach((v)=>{
        v.addEventListener("click",(e)=>{
            let boardId = v.nextElementSibling.innerHTML;
            starDelete(e, boardId);
        });
    });
    
function starDelete(e, id) {
	e.stopPropagation();
    	const data = axios({
			   url: '/starmark/delete',
			   data: {
			   'boardId': `\${id}`
			   },
			   dataType : 'text',
				   method: 'post'
			   });
        	data.then(function (result) {
        		location.href="/search/list";
    		});
}
function starCreate(e, id) {
	e.stopPropagation();
	const data = axios({
		   url: '/starmark/create',
		   data: {
		   'boardId': `\${id}`
		   },
		   dataType : 'text',
			   method: 'post'
		   });
 	data.then(function (result) {
 			location.href="/search/list";
		});
}
</script>
</body>
</html>
