<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <title>로그인 메인</title>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    
    <link rel="stylesheet" href="../resources/css/login.css">
    <script src="../resources/js/login.js"></script>
</head>



    <!-- 바디 부분 -->
<body class="login">
    <div class="container">
        <div class="card card-container">
        
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="이메일을 작성해주세요" required autofocus value="admin@korea.kr">
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="비밀번호를 작성해주세요" required value="admin">
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" >로그인 하기</button>
            </form><!-- /form -->
            
            <!-- 회원가입 a태그 -->
            <a href="/user/tos" class="join">
                회원가입
            </a>
            
        </div><!-- /card-container -->
    </div><!-- /container -->

</body>

</html>