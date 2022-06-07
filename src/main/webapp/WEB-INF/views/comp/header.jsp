<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
 Class Name : Header.JavaScript
 Description : header
 Author : 조윤구
 Since : 2022-05-28
--%>



		<nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="/main">
                    <h1>Docgram</h1>
                </a>
                <div class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/notice/list">공지 소식</a>
                        <span class="sr-only">(current)</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/search">상세 검색</a>
                        <span class="sr-only">(current)</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/board/list">부서별 알림</a>
                        <span class="sr-only">(current)</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/search?hashtagList=${user.mytag.name}">My tag :
                            ${user.mytag.name}</a>
                        <span class="sr-only">(current)</span>
                    </li>

                </div>


            </div>
        </nav>
        <c:if test="${sessionScope.user.id
         == admin }">
	        <div class="navbar-nav">
	            <li class="nav-item" id="admin-nav">
	                <a class="nav-link" href="/admin/board">관리자 페이지</a>
	                <span class="sr-only">(current)</span>
	            </li>
	        </div>
        </c:if>
        <c:if test="${sessionScope.user.id != 1 }">
        	<span class="sr-only">(current)</span>
        </c:if>
