<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Popup.JavaScript
 Description : 회원가입의 기관 검색 팝업
 Author : 문예빈
 Since : 2022-05-30
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/main.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script></head>
<title>Main page</title>
</head>
    <!-- 참고 사이트 : https://kimvampa.tistory.com/196 -->

    <body>
      <div class="subject_name_warp">
        <span>기관 검색</span>
      </div>

      <div class="content_wrap">
        <!-- 검색 영역 -->
        <div class="search_wrap">
          <form id="searchForm" action="" method="">
            <div class="search_input">
              <input type="text" name="keyword" value='<c:out value="${사용자가 검색한 단어}"></c:out>'>
              <input type="hidden" name="pageNum" value='<c:out value="${페이지 넘버}"></c:out>'>
              <input type="hidden" name="amount" value='${한 페이지에 몇개나 들어갈지}'>
              <button class='btn search_btn'>검 색</button>
            </div>
          </form>
        </div>

        <!-- 게시물 표 영역 -->
        <div class="author_table_wrap">
          <!-- 게시물 O -->
          <c:if test="${listCheck != 'empty'}">
            <div class="table_exist">
              <table class="author_table">
                <thead>
                  <tr>
                    <td class="th_colum">기관명</td>
                  </tr>
                </thead>
                <c:forEach items="${dept}" var="dept">
                  <tr>
                    <td>
                      <c:out value="${기관명}"></c:out>
                    </td>
                  </tr>
                </c:forEach>
              </table>
            </div>
          </c:if>
          <!-- 게시물 x -->
          <c:if test="${게시물 == 'empty'}">
            <div class="table_empty">
              등록된 기관이 없습니다.
            </div>
          </c:if>

          <!-- 페이지 이동 인터페이스 영역 -->
          <div class="pageMaker_wrap">

            <ul class="pageMaker">

              <!-- 이전 버튼 -->
              <c:if test="${이전버튼 클릭}">
                <li class="pageMaker_btn prev">
                  <a href="${pageMaker.pageStart - 1}">이전</a>
                </li>
              </c:if>

              <!-- 페이지 번호 -->
              <c:forEach begin="${pageMaker.pageStart}" end="${pageMaker.pageEnd}" var="num">
                <li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? " active":""}">
                  <a href="${num}">${num}</a>
                </li>
              </c:forEach>

              <!-- 다음 버튼 -->
              <c:if test="${pageMaker.next}">
                <li class="pageMaker_btn next">
                  <a href="${pageMaker.pageEnd + 1 }">다음</a>
                </li>
              </c:if>

            </ul>

          </div>

          <form id="moveForm" action="/admin/authorPop" method="get">
            <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
            <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
            <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
          </form>


        </div>

      </div>
           <!-- 페이지네이션 -->
     <script>

      let searchForm = $('#searchForm');
      let moveForm = $('#moveForm');
      
      /* 작거 검색 버튼 동작 */
      $("#searchForm button").on("click", function(e){
        
        e.preventDefault();
        
        /* 검색 키워드 유효성 검사 */
        if(!searchForm.find("input[name='keyword']").val()){
          alert("키워드를 입력하십시오");
          return false;
        }
        
        searchForm.find("input[name='pageNum']").val("1");
        
        searchForm.submit();
        
      });
      
      
      /* 페이지 이동 버튼 */
      $(".pageMaker_btn a").on("click", function(e){
        
        e.preventDefault();
        
        console.log($(this).attr("href"));
        
        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
        
        moveForm.submit();
        
      });	
  
    
    </script>
    </body>

    </html>