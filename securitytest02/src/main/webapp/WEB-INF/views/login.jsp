<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/login" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		아이디: <input type="text" name="username"><br>
		비밀번호: <input type="password" name="password"><br>
		<button>로그인</button>
	</form>
	<a href="join">회원가입</a>
</body>
</html>