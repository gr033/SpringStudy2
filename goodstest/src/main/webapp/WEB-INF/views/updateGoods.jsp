<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품수정</h2>
	<form method="post" action = "updateGoods" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${g.no }">
		상품이름: <input type="text" name="name" value="${g.name }"><br>
		상품수량: <input type="text" name="qty" value="${g.qty }"><br>
		상품가격: <input type="text" name="price" value="${g.price }"><br>
		상품사진: <img src="images/${g.fname }" width="100" height="100"><br>
		<input type="hidden" name="fname" value="${g.fname }">
		<input type="file" name="uploadFile"><br>
		<input type="submit" value="수정"><br>		
		<input type="reset" value="다시입력"><br>
	</form>
</body>
</html>