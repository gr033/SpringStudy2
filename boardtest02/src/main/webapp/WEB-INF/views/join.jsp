<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#box_check {
	display: none;
}
#box_insert {
	display: none;
}
</style>
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	var check;
	var userNUM;
	$("#btnCheckEmail").click(function(){
		var data = {
			email: $("#checkEmail").val()
		};
		$.ajax({
			url: "sendMessage",
			data: data,
			success: function(n){
				console.log(n);
				$("#box_check").css("display", "block");
				check = n;
			}
		})
	});
	
	$("#btnConfirmEmail").click(function(){
		userNUM = $("#checkNUM").val();
		if(userNUM == check){
			$("#box_insert").css("display", "block");
			$("#email").val($("#checkEmail").val());
		}else{
			alert("인증번호를 다시 입력해주세요.");
		}
	})
});
</script>
</head>
<body>
	<h2>회원가입</h2>
		<div id="box_email">
		전화번호: <input type="tel" name="checkEmail" id="checkEmail">
		<button id="btnCheckEmail">인증</button><br>
		</div>
	
		<div id="box_check">
			인증번호 입력: <input type="text" name="checkNUM" id="checkNUM">
			<button id="btnConfirmEmail">확인</button>
		</div>
		<div id="box_insert">
		<form action="join" method="post">
				아이디: <input type="text" name="id"><br> 
				암호: <input type="password" name="pwd"><br>
				이름: <input type="text" name="name"><br>
				이메일: <input type="email" name="email" id="email" readonly="readonly"><br>
				<input type="submit" value="가입">
		</form>
		</div>
</body>
</html>