<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1103_loginGet.jsp</title>
</head>
<body>
<h1>로그인</h1>
 <form action="LoginPro.me" method="post">
	아이디 : <input type="text" name="id"><br>
	패스워드 : <input type="text" name="password"><br>
	<input type="submit" value="로그인(POST)">
 </form>
  <form action="LoginPro2.me" method="get">
	아이디 : <input type="text" name="id"><br>
	패스워드 : <input type="text" name="password"><br>
	<input type="submit" value="로그인(GET)">
 </form>
</body>
</html>