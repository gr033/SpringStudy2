<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 삭제</h2>
	<form action="deleteBoard" method="post">
	<input type="hidden" value="${no }" name="no">
		비밀번호 확인: <input type="password" name="pwd"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>