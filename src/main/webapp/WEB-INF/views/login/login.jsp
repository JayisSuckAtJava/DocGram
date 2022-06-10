<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <title>로그인 메인</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resources/css/login.css">
    <script type="text/javascript">
    if(${fail != null}) {
    	alert(`${fail}`);
    }
    </script>
</head>



    <!-- 바디 부분 -->
<body class="login">

<!-- header -->
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
	<jsp:include page="../comp/header.jsp"></jsp:include>
</header>

    <div class="container">
        <div class="card card-container">
        
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="이메일을 작성해주세요" required autofocus value="admin@korea.kr">
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="비밀번호를 작성해주세요" required value="admin">
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">로그인 하기</button>
            </form><!-- /form -->
            
            <!-- 회원가입 a태그 -->
            <a href="/user/tos" class="join">
                회원가입
            </a>
            
        </div><!-- /card-container -->
    </div><!-- /container -->
    
    <!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>

</body>

</html>