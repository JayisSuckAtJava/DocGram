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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../resources/css/main.css">
    <link rel="stylesheet" href="../resources/css/comp.css">
    <link rel="stylesheet" href="../resources/css/read.css">
  <script src="../resources/js/read.js"></script>
  
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
        <input class="ss" name="searchKeyword" type="text" id="searchKeyword" style="margin-left: 3%;"
          placeholder="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)"
          title="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)" value="">
        </form>
      </dd>
    </dl>

    <dl class="dl-table">
      <dt class="dt-open"><span>항목<em>(다중선택)</em></span></dt>
      <dd class="dd-date">
        <form action="" method=""> <!-- form-->
        <select name="rangeLevel" id="rangeDateUi" title="기간설정 선택">
          <option value="all" selected="selected">직책(전체)</option>
          <option value="31">대통령</option>
          <option value="92">국회</option>
          <option value="183">7급</option>
          <option value="365">9급</option>
        </select>
        
        <input name="searchFile" type="text" id="searchKeyword" style="margin-left: 3%; width: 30%;" 
        placeholder="원하시는 파일명을 입력하세요"
          title="원하시는 파일명을 입력하세요" value="">
          <input name="searchNumber" type="text" id="searchKeyword" style="margin-left: 3%; width: 30%"
        placeholder="문서 번호"
          title="문서번호" value="">
        </form>

        </dd>
    </dl>


    <dl class="dl-table">
      <dt class="dt-open"><span>태그검색<em>(다중입력 , 로 구분)</em></span></dt>
      <dd class="dd-date">
        <form action="" method=""> <!-- form-->
        <input name="searchTag" type="text" id="searchKeyword" style="width: 30%;"
        placeholder="태그를 입력하세요 (예 행정,공공기관 )"
          title="태그를 입력하세요 (예 #행정 #공공기관 )" value="">
        </form>
        </dd>
    </dl>



    <dl class="dl-table">
      <dt class="dt-date"><label for="rangeDateUi">검색기간</label></dt>
      <dd class="dd-date">
        <form action="" method=""> <!-- form-->
        <select name="rangeDate" id="rangeDateUi" title="기간설정 선택">
          <option value="all" selected="selected">전체</option>
          <option value="31">1개월</option>
          <option value="92">3개월</option>
          <option value="183">6개월</option>
          <option value="365">1년</option>
        </select>
        </form>

      </dd>
      
    </dl>

  </div>
  <!--// .dl-table-wrap -->
  <div class="btn-search">
    <button type="button" class="btn btn-reset btn-search-reset">초기화</button>
    <button type="submit" class="btn btn-search">검색</button>
    <button type="write" class="btn btn-search">작성하기</button>
    <hr>
  </div>
    <!-- 상세 검색 부분  끝 -->


    <!-- 목록 리스트 -->
    <table class="table table-hover">


      <thead id="list_title">

        <tr>
          <th>즐쳐찾기</th>
          <th>번호</th>
          <th>제목</th>
          <th>다운로드</th>
          <th>소속기관</th>
          <th>작성일</th>
          <th>작성자</th>
        </tr>
      </thead>

      <tbody class="table table-hover">
        <tr>
          <td><i class="bi bi-star"></i></td>
          <td >김띵띵</td>
          <td>cho@gmail.com</td>
          <td>010-2345-342</td>
          <td>부서 번호</td>
          <td>물전환특별팀</td>
          <td>부서관</td>
        </tr>
        <c:forEach items="${boardList}" var="board">
          <tr>
            <td>
            <!--  아래 c:if를 통해서 즐찾 리스트가 맞으면 출력 하는걸로 -->
            <c:if test="session != null">
            <i class="bi bi-star-full"></i>  <!-- 왼쪽 찬별 / 오른쪽 안찬별 --> <i class="bi bi-star"></i>
            </c:if>
            </td>
            <td>${board.user.name}</td>
            <td>${유저 아이디 (이메일)}</td>
            <td>${개인번호}</td>
            <td>${부서번호}</td>
            <td>${소속}</td>
            <td>부서관</td>
          </tr>
        </c:forEach>

      </tbody>
    </table>
      
      
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
