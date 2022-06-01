<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>헤더</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
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
	</div>
</body>
</html>

