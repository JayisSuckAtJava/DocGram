<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <!-- 헤더 -->
    <head>

        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/mypage.css">
        <title>상세검색페이지</title>
        <meta http-equiv="Content-Type" content="text/html;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../css/main.css">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
  <!---------------- css 시작 부분 -------------------->
  <style>
  	/* 전체 마진 css */
  	 .all {
      margin-left: 15%;
      margin-right: 15%;
    }
  
    /* 문서 목록 리스트 css */
    .table table-hover {
      border: solid;
      height: 100px;
      background-color: rgb(128, 197, 229);
    }
    #list_title {
      border: solid;
    }

    #list_title>tr>th {
      border: solid;
    }

    #page-title {
      border: solid;
      text-align: right;
    }

    .sibalnoma {
      width: 100%;
      max-width: 1000px;
      margin: 0 auto;
    }

    /* 상단 검색 */
    .dl-table-wrap {  position: relative;  border: 1px solid #b5b5b5;  border-radius: 5px; }
    .dl-table-wrap:after {  content: '';  clear: both;  display: block;  }
    .dl-table-wrap .dl-table:first-child {  border-top: 0; }
    .dl-table-wrap .dl-table:last-child {  border-bottom-left-radius: 5px;  border-bottom-right-radius: 5px; }
    .dl-table-wrap .dl-table:not([style*="display: none"]):last-child {  border-bottom-left-radius: 5px;  border-bottom-right-radius: 5px; }
    .dl-table-wrap .dl-table.dl-organ dt {  border-bottom-left-radius: 5px; }
    .dl-table-wrap.open .dl-table.dl-organ dt { border-bottom-left-radius: 0 }
    .dl-table-wrap .dl-table:first-child dt { border-top-left-radius: 5px;}
    .dl-table-wrap .dl-table:last-child dt { border-bottom-left-radius: 5px;}


/* 상단검색 결과 */


.dl-table {display: table;width: 100%;border-top: 1px dashed #b5b5b5;}
.dl-table dd {display: table-cell;width: 850px;padding: 4px 10px;font-size: 0.8125em}
.dl-table dd input[type="text"] {background: #f2f2f2;border: 1px solid #b5b5b5;border-radius: 5px;}

input::placeholder {color:#434343;}
/* .dl-table */

.dl-table dd select {min-width: 19%;border: 1px solid #b5b5b5;border-radius: 5px;font-size: 1em;}
.dl-table dd * {vertical-align: middle;}
.dl-table dd input[type="text"],
.dl-table dd select,
.dl-table dd .date-box {float: left;}
.dl-table dt {display: table-cell;width: 150px;padding: 6px 0 6px 10px;background: #f8eff3;font-weight: 700;font-size: 0.8125em;vertical-align: middle;}
.dl-table dt label, .dl-table dt span {font-size: inherit;font-weight: inherit;}
.dl-table dt span em {font-weight: 400;}
.dl-table dd {display: table-cell;width: 850px;padding: 4px 10px;font-size: 0.8125em}
.dl-table dd input[type="text"] {background: #f2f2f2;border: 1px solid #b5b5b5;border-radius: 5px;}


.dl-table-wrap .dl-table.dl-organ dt {border-bottom-left-radius: 5px;}
.dl-table-wrap.open .dl-table.dl-organ dt {border-bottom-left-radius: 0}

/* .dl-table  검색 크기 */
.dl-table dd.dd-keyword input[type="text"] {width: 50%}

.dl-table-wrap .dl-table:first-child dt {border-top-left-radius: 5px;}
.dl-table-wrap .dl-table:last-child dt {border-bottom-left-radius: 5px;}

  </style>

  <!---------------- css 끝 부분 -------------------->

</head>
<!--------- head 끝 --------------------->



<!-- body 상세 검색 부분 -->



<body class="all">
	
	<jsp:include page="../comp/header.jsp"></jsp:include>

	



	<div class="Detail-search">
    <div class="test">

      <h2 id="page-title" style="color: rgb(0, 0, 0);">서울시의회 정보</h2>

      <ul class="bc-depth1 cf">
        <li class="step "><a href="/">홈</a><span>&gt;</span></li>
        <li class="step step1"><em class="element-invisible">현재 1depth 메뉴 :</em><a
            href="/smc/list">시정정보</a><span>&gt;</span></li>
        <li class="step step2"><em class="element-invisible">현재 2depth 메뉴 :</em><a href="/smc/list">서울시의회
            정보</a><span>&gt;</span></li>
        <li class="step step3"><em class="element-invisible">현재 3depth 메뉴 :</em><a href="/council/list">서울시의회
            자료</a><span>&gt;</span></li>
       </ul>
    </div>
  </div>


  <!-- 문서 검색부분 -->

  <div class="dl-table-wrap">
    <dl class="dl-table">
      <dt class="dt-keyword"><label for="searchKeyword">검색어</label></dt>
      <dd class="dd-keyword">
        <form action="" method="post"> <!-- form-->
        <select name="text" id="searchCategory" title="검색어 분류 선택">
          <option value="title" selected="selected">제목</option>
          <option value="content">내용</option>
          <option value="name">작성자</option>
          <option value="dept_name">기관</option>
        </select>
        <input name="searchKeyword" type="text" id="searchKeyword"
          placeholder="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)"
          title="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)" value="">
        </form>
      </dd>
    </dl>

    <dl class="dl-table">
      <dt class="dt-open"><span>항목<em>(다중선택)</em></span></dt>
      <dd class="dd-date">
        <form action="" method=""> <!-- form-->
        <select name="position_id" id="rangeDateUi">
          <option value="1" selected="selected">직책(전체)</option>
          <option value="2">서기</option>
          <option value="3">주사보</option>
          <option value="4">주사</option>
          <option value="5">사무관</option>
          <option value="6">서기관</option>
          <option value="7">부이사관</option>
          <option value="8">이사관</option>
          <option value="9">관리관</option>
        </select>
        
        <input name="file_name" type="text" id="searchKeyword" 
        placeholder="원하시는 파일명을 입력하세요"
          title="원하시는 파일명을 입력하세요" value="">
          <input name="file_num" type="text" id="searchKeyword" 
        placeholder="문서 번호"
          title="문서번호" value="">
        </form>

        </dd>
    </dl>


    <dl class="dl-table">
      <dt class="dt-open"><span>태그검색<em>(다중입력 , 로 구분)</em></span></dt>
      <dd class="dd-date">
        <form action="" method=""> <!-- form-->
        <input name="hashtagList" type="text" id="searchKeyword" 
        placeholder="태그를 입력하세요 (예 행정,공공기관 )"
          title="태그를 입력하세요 (예 #행정 #공공기관 )" value="">
        </form>
        </dd>
    </dl>



    <dl class="dl-table">
      <dt class="dt-date"><label for="rangeDateUi">검색기간</label></dt>
      <dd class="dd-date">
        <form action="" method=""> <!-- form-->
        <select name="date" id="rangeDateUi" title="기간설정 선택">
          <option value="0" selected="selected">전체</option>
          <option value="30">1개월</option>
          <option value="90">3개월</option>
          <option value="180">6개월</option>
          <option value="365">1년</option>
          <option value="custom">기간설정</option>
          <p><input type="date"></p>
        </select>
        </form>

      </dd>
      
    </dl>

  </div>
  
  <!--// .dl-table-wrap -->
  <div class="btn-groups half btn-groups-search">
    <button type="button" class="btn btn-reset btn-search-reset">초기화</button>
    <button type="submit" class="btn btn-search">검색</button>
        <button type="write" class="btn btn-search">작성하기</button> 
    <!-- 상세 검색 부분 -->


	<div classs="col"></div>

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
        </tr>
      </thead>

      <tbody class="list-body">
        <tr>
          <td>10</td>
          <td>공공문서 관련한 문서 관리</td>
          <td>파일</td>
          <td>세종특별청사</td>
          <td>5/19</td>
          <td>부서관</td>
        </tr>
        <c:forEach items="${boardList}" var="board">
        <tr>
        	<td>${board.id}</td>
          	<td>${board.title}</td>
          	<td>${board.fileId}</td>
          	<td>${board.user.dept.name}</td>
          	<td>${board.date}</td>
          	<td>${board.user.name}</td>
         </tr>
        </c:forEach>
       	
      </tbody>
    </table>
    </div>
    
    <!-- 페이징 -->
            <div class="page">
              <nav aria-label="Page navigation example">
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
     
    
    <!-- 푸터 -->
    <jsp:include page="../comp/footer.jsp"></jsp:include>
</body>

<script>
  const trs = document.querySelectorAll(".list-body > tr");
  trs.forEach((v) => {
    console.log(v);
    let first = v.firstElementChild.innerHTML;
    console.log(first)
    v.addEventListener("click", () => {
      alert(`hi u are in \${first}`)
      window.location.href = `board/\${first}`
    })
  })
</script>

</html>