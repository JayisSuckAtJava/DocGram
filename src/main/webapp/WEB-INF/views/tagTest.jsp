<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${result}

<script type="text/javascript">
const tds = document.querySelectorAll("tag");
tds.forEach((v) => {
    console.log(v)
    let text = v.innerHTML;
    v.addEventListener("click" , ()=>{
        alert(`\${text}`)
    })
    })
</script>
</body>
</html>