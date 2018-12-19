<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script src="js/jquery-2.2.3.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script>
	$(function() {
		$("table tr:odd").css("background-color", "#f2f2f2");
	});
	function oneUpdate(obj){
		that = obj;
		$.post("oneUpdate",{
			"userName" : $(that).parent().prev().prev().prev().prev().prev().children().html()
		},function(data){
			if(data.errorMsg == "true") {
				location.reload(true);
			}else {
				alert(data);
			}
		},'json');
	}
	
	function twoUpdate(obj){
		that = obj;
		$.post("twoUpdate",{
			"userName" : $(that).parent().prev().prev().prev().prev().children().html()
		},function(data){
			if(data == "true") {
				location.reload(true);
			}else {
				alert(data);
			}
		},'text');
	}
	
	function uniteUpdate(obj){
		that = obj;
		$.post("uniteUpdate",{
			"userName" : $(that).parent().prev().prev().prev().prev().prev().prev().children().html()
		},function(data){
			if(data == "true") {
				location.reload(true);
			}else {
				alert(data);
			}
		},'text');
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${!empty(username)}">
			<!-- 登录 -->
			<span><a href="#" style="font-size: 15px">欢迎用户:&nbsp;<%=session.getAttribute("username")%></a></span>
			<!-- end登录 -->
		</c:when>
		<c:otherwise>
			<span id="loginname">Login or Register</span>
		</c:otherwise>
	</c:choose>
	<br>
	<table style="border-collapse: collapse;" border="1">
		<tr>
			<td><span>用户名</span></td>
			<td><span> 密码</span></td>
			<td><span>生日</span></td>
			<td><span>年龄</span></td>
			<td><span>邮箱</span></td>
			<td><span>操作</span></td>
			<td><span>事物操作</span></td>
		</tr>
		<c:forEach items="${userlist}" var="userlist">
			<tr>
				<td><span>${userlist.username}</span></td>
				<td><span>${userlist.password}</span></td>
				<td><span>${userlist.birthday}</span></td>
				<td><span>${userlist.age}</span></td>
				<td><span>${userlist.email}</span></td>
				<td><button onclick="oneUpdate(this)">单一数据更改</button></td>
				<td><button onclick="uniteUpdate(this)">事物提交</button></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<br></br>
	<table style="border-collapse: collapse;" border="1">
		<tr>
			<td><span>用户名</span></td>
			<td><span>手机号</span></td>
			<td><span>当前积分</span></td>
			<td><span>账号状态</span></td>
			<td><span>操作</span></td>
		</tr>
		<c:forEach items="${userlists}" var="userlists">
			<tr>
				<td><span>${userlists.userName}</span></td>
				<td><span>${userlists.userTel}</span></td>
				<td><span>${userlists.userIntegral}</span></td>
				<td><span>${userlists.userState}</span></td>
				<td><button onclick="twoUpdate(this)">单一数据更改</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>