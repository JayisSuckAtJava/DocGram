<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
 Class Name : Header.JavaScript
 Description : header
 Author : 조윤구
 Since : 2022-05-28
--%>



<nav class="navbar navbar-expand-lg">
        <div class="container-fluid">

      
            
              <a class="navbar-brand" href="main">
                 <h1>Docgram</h1>
              </a>
              <div class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="notice">공지 소식</a>
                <span class="sr-only">(current)</span>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="search">상세 검색</a>
                <span class="sr-only">(current)</span>
              </li>
              <li class="nav-item">
              <a class="nav-link" href="board">부서별 알림</a>
                <span class="sr-only">(current)</span>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">${mytag}</a>
                <span class="sr-only">(current)</span> 
              </li>
            </div>
     
        </div>
      </nav>
