<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function deleteGoods(no){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href="deleteGoods?no="+no;
		}
	}
</script>
</head>
<body>
	상품번호: ${g.no }<br>
	상품이름: ${g.name }<br>
	상품가격: ${g.price}<br>
	상품수량: ${g.qty }<br>
	상품사진: <br>
	<img src="../images/${g.fname }"><br>
	<a href="updateGoods?no=${g.no }">수정</a><br>
	<a href="#" onclick="deleteGoods(${g.no})">삭제</a><br>
	<a href="listGoods">목록으로</a>
</body>
</html>