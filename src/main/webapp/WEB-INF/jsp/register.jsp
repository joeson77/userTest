<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="css/Info.css" rel="stylesheet" />
<script src="js/jquery-2.2.3.min.js"></script>
<script>
	$(function() {
		$("input[name='birthday']").blur(
				function() {
					$("input[name='age']").prop(
							"value",
							(new Date().getFullYear())
									- ($(this).val().substring(0, 4)));
				});
		$("input[name='email']").blur(function() {
			var email = $(this).val();
			var reg = /\w+[@]{1}\w+[.]\w+/;
			if (!(reg.test(email))) {
				if($("input[name='email']").val() != ""){
					$("#test7").fadeToggle(1000);
					$("#test7").addClass("bounceinDown");
					$("#test7").fadeToggle(3000);
					$("input[name='email']").prop("value","");
				}
			}
		});
	});
	function Judge(){
		if($("input[name='username']").val() == ""){
			$("input[name='username']").focus();
			$("#test1").fadeToggle(1000);
			$("#test1").addClass("bounceinDown");
			$("#test1").fadeToggle(3000);
			return false;
		}else if($("input[name='password']").val() == ""){
			$("input[name='password']").focus();
			$("#test2").fadeToggle(1000);
			$("#test2").addClass("bounceinDown");
			$("#test2").fadeToggle(3000);
			return false;
		}else if($("input[name='birthday']").val() == ""){
			$("input[name='birthday']").focus();
			$("#test3").fadeToggle(1000);
			$("#test3").addClass("bounceinDown");
			$("#test3").fadeToggle(3000);
			return false;
		}else if($("input[name='age']").val() == ""){
			$("input[name='age']").focus();
			$("#test4").fadeToggle(1000);
			$("#test4").addClass("bounceinDown");
			$("#test4").fadeToggle(3000);
			return false;
		}else if($("input[name='email']").val() == ""){
			$("input[name='email']").focus();
			/* $("#test5").fadeToggle(1000);
			$("#test5").addClass("bounceinDown");
			$("#test5").fadeToggle(3000); */
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<body>
	<form action="reg" method="post" onsubmit="return Judge()">
		用户: <input type="text" name="username"> <br> 密码: <input
			type="password" name="password"> <br>生日: <input
			type="date" name="birthday"> <br> 年龄: <input type="text"
			name="age"> <br> 邮箱: <input type="text" name="email">
		<br> <input type="submit" name="reg" value="注册">
	</form>
	<div id="test1" class="div1">
		<span style="color: #a5dc86">用户名不能为空!</span>
	</div>
	<div id="test2" class="div1">
		<span style="color: #a5dc86">密码不能为空!</span>
	</div>
	<div id="test3" class="div1">
		<span style="color: #a5dc86">生日不能为空!</span>
	</div>
	<div id="test4" class="div1">
		<span style="color: #a5dc86">年龄不能为空!</span>
	</div>
	<div id="test5" class="div1">
		<span style="color: #a5dc86">email不能为空!</span>
	</div>
	<div id="test6" class="div1">
		<span style="color: #a5dc86">该用户已存在!</span>
	</div>
	<div id="test7" class="div1">
		<span style="color: #a5dc86">邮箱格式不正确!</span>
	</div>
</body>
</html>