<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Header.JavaScript
 Description : header
 Author : 조윤구
 Since : 
--%>

<!DOCTYPE html>

<head>
  <title>Header</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="../resources/css/main.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>

<header class="container-fluid text-center">
	<a href="/" class="main-logo">
		<svg class="bi me-2" width="40" height="32">
		<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">Docgram</span>
	</a>
	<ul class="nav nav-pills">
		<li class="nav-item"><a href="#" class="nav-link">공지 소식</a></li>
		<li class="nav-item"><a href="#" class="nav-link">상세 검색</a></li>
		<li class="nav-item"><a href="#" class="nav-link">최신 문서</a></li>
		<li class="nav-item"><a href="#" class="nav-link">${mytage}</a></li>
	</ul>
</header>

<%-- 	<div class="container">
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
							<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">Docgram</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item"><a href="#" class="nav-link">공지 소식</a></li>
				<li class="nav-item"><a href="#" class="nav-link">상세 검색</a></li>
				<li class="nav-item"><a href="#" class="nav-link">최신 문서</a></li>
				<li class="nav-item"><a href="#" class="nav-link">${mytage}</a></li>
			</ul>
		</header>
	</div> --%>
</body>
</html>

