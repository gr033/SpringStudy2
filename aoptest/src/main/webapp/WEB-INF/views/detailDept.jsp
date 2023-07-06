<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서 상세</h2>
	<br>
	부서번호: ${d.dno }<br>
	부서이름: ${d.dname }<br>
	부서위치: ${d.dloc }<br>
	<hr>
    <a href="listDept">부서목록</a>
</body>
</html>