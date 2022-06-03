<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<span> Context : <%= request.getContextPath() %></span> 
<br><br><hr><br><br>
<span> URL : <%= request.getRequestURL() %></span>
<br><br><hr><br><br> 
<span> URI : <%= request.getRequestURI() %></span>
<br><br><hr><br><br>  
 <span>Path : <%= request.getServletPath() %> </span>
 <br><br><hr><br><br>
 <span> protocol: <%= request.getProtocol() %></span>
 <br><br><hr><br><br>
 <span> remoteaddr: <%= request.getRemoteAddr() %></span>
 <br><br><hr><br><br>
 <span> servname: <%= request.getServerName() %></span>
</body>
</html>