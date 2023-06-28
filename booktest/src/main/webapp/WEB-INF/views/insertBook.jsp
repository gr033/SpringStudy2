<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 등록</h2>
	<hr>
	<form action="insertBook" method="post">
	도서번호: <input type="text" name="bookid" value="${bookid }"><br>
	도서명: <input type="text" name="bookname"><br>
	출판사: <input type="text" name="publisher"><br>
	가격: <input type="text" name="price"><br>
	<input type="submit" value="등록"><br>
	<input type="reset" value="취소">
	</form>
</body>
</html>