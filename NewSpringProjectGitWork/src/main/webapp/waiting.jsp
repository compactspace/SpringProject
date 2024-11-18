<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<c:choose>
	<c:when test="${wannamember ne 'yes'}">
<script>
	window.onload = function(){
		 $("#waiting").click(function() {
			                                         //흠..출력은 되는데 스트링이 여서 쌍따옴표필요없을줄 알았는데
			                                         //개발자 도구 보면 쌍따옴표 없으면 인식을 못함 그래서 붙여줌
				location.href = "/isExistId.do?code="+"<%=request.getParameter("code")%>"+"&state="+"<%=request.getParameter("state")%>"
				                  
			})
			
			$("#waiting").trigger("click");
	}
	


	
</script>
</c:when>
<c:otherwise>
	
	</c:otherwise>
</c:choose>

</head>
<body>
<c:choose>
<c:when test="${wannamember eq 'yes'}">
	<a href="membership.jsp" >회원가입하러가기</button>
	</c:when>
	<c:otherwise>
	<button type="button" id="waiting">잠쉬만~기다려주세용</button>
	</c:otherwise>
</c:choose>

	
</body>
</html> --%>