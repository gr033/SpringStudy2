<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 수정</h2>
	<form action="updateBook" method="post">
	<input type="hidden" name="bookid" value="${b.bookid }">
		도서명: <input type="text" name="bookname" value="${b.bookname }"><br>
		출판사: <input type="text" name="publisher" value="${b.publisher }"><br>
		도서가격: <input type="text" name="price" value="${b.price }"><br>
	<input type="submit" value="수정">
	</form>
</body>
</html>