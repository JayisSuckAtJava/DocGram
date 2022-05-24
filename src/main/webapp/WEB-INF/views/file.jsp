<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form method="post" enctype="multipart/form-data">
 <input type="text" name="text"><br>
 <input type="file" name="mFile" multiple><br>
 <input type="submit" value="업로드">
</form>
<a href="downloadTest">Download</a>
</body>
</html>