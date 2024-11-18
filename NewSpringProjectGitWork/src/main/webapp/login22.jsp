<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form class="form-signin" action="login.do" method="post">
				<div class="form-group">
					<label for="inputUserName" class="sr-only">User Name</label> 
					<input	type="text" class="form-control" placeholder="ID" name="id" value="${userVO.id}" required autofocus>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="sr-only">Password</label> 
					<input 	type="password" class="form-control" placeholder="Password" name="password" value="${userVO.password}" required>
				</div>
				<button class="btn btn btn-lg btn-success btn-inline" type="submit">로그인</button>
																					 													
				<button class="btn btn btn-lg btn-success btn-inline" type="button" onclick="javascript:location.href='membership.jsp'">회원가입</button>
			</form>
			
			
			

</body>
</html>