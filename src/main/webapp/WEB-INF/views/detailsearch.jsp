<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세검색페이지</title>

  <!---------------- css 시작 부분 -------------------->
  <style>
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



<body>

	<jsp:include page="header.jsp"></jsp:include>

	



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
        <select name="searchField" id="searchCategory" title="검색어 분류 선택">
          <option value="all" selected="selected">제목</option>
          <option value="title">내용</option>
          <option value="dept_nm">작성자</option>
          <option value="writer">기관</option>
        </select>
        <input name="searchKeyword" type="text" id="searchKeyword"
          placeholder="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)"
          title="검색어를 입력하세요. 각 단어는 콤마로 구분합니다. (예 : 보고, 지출, 납부)" value="">
      </dd>
    </dl>

    <dl class="dl-table">
      <dt class="dt-open"><span>항목<em>(다중선택)</em></span></dt>
      <dd class="dd-date">
        <select name="rangeLevel" id="rangeDateUi" title="기간설정 선택">
          <option value="all" selected="selected">직책(전체)</option>
          <option value="31">대통령</option>
          <option value="92">국회</option>
          <option value="183">7급</option>
          <option value="365">9급</option>
        </select>
        
        <input name="searchFile" type="text" id="searchKeyword" 
        placeholder="원하시는 파일명을 입력하세요"
          title="원하시는 파일명을 입력하세요" value="">

          <input name="searchNumber" type="text" id="searchKeyword" 
        placeholder="문서 번호"
          title="문서번호" value="">
        </dd>
    </dl>


    <dl class="dl-table">
      <dt class="dt-open"><span>태그검색<em>(다중입력 , 로 구분)</em></span></dt>
      <dd class="dd-date">
        
        <input name="searchTag" type="text" id="searchKeyword" 
        placeholder="태그를 입력하세요 (예 행정,공공기관 )"
          title="태그를 입력하세요 (예 #행정 #공공기관 )" value="">
        </dd>
    </dl>



    <dl class="dl-table">
      <dt class="dt-date"><label for="rangeDateUi">검색기간</label></dt>
      <dd class="dd-date">
        <select name="rangeDate" id="rangeDateUi" title="기간설정 선택">
          <option value="all" selected="selected">전체</option>
          <option value="31">1개월</option>
          <option value="92">3개월</option>
          <option value="183">6개월</option>
          <option value="365">1년</option>
          <option value="custom">기간설정</option>
          <p><input type="date"></p>
        </select>

      </dd>
    </dl>

  </div>
  <!--// .dl-table-wrap -->
  <div class="btn-groups half btn-groups-search">
    <button type="button" class="btn btn-reset btn-search-reset">초기화</button>
    <button type="submit" class="btn btn-search">검색</button>
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
        	<td>${board.pk}</td>
          	<td>${board.title}</td>
          	<td></td>
          	<td>${board.deptDescription}</td>
          	<td>${board.date}</td>
          	<td>${board.userName}</td>
         </tr>
        </c:forEach>
       	
      </tbody>
    </table>
    </div>
    <!-- 목록 리스트 -->
    
    <!-- 푸터 -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>

<script>
  const trs = document.querySelectorAll(".list-body > tr");
  trs.forEach((v) => {
    console.log(v);
    let first = v.firstElementChild.innerHTML;
    console.log(first)
    v.addEventListener("click", () => {
      alert(`hi u are in \${first}`)
      wind
      
      ow.location.href = `board/\${first}`
    })
  })
</script>

</html>