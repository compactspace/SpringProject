<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>
<style>

@media (max-width: 360px){
 body {
  
    
  }
 
 .alldivwrapper{
    margin-left:0px !important;
    margin-right:0px !important;
    width: 100% !important;
 }
 

 
 #loginformwrappe{
 width: 100%!important;
 }
 
}






/* 이미지 태그의 직계 할머니 포지션을 타겟으로 해야해서
    포지션 릴레이티브 주자
    */
    
    .divwrapper{
      min-height: 100vh;
    box-orient: vertical;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    
    }
    
    
    
.alldivwrapper {
	width: 500px;
	position: relative;
	margin-left: auto;
	margin-right: auto;
}

.imgdiv {
	/* padding-top: 150px; */
}

#r {
	height: 900px;
	width: 500px;
	border: 1px solid #ddd
}

#imgone {
	position: absolute;
	right: 0px;
	top: 25px;
	height: 200px;
	width: 200px;
}

.loginform {
	height: 100%;
	border: 1px solid #666;
    border-radius: 4px;
}


           #loginformwrapper>span{
          color: #444;
    font-size: 35px;
    font-weight: 600;
    line-height: 90px;
           }

.container {
	display: flex;
	flex-direction: column;
}

.passwordinput, .idinput {
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	width: 100%;
	height: 50px;
}

h3 {
	color: #797979;
}

.iddiv, .passworddiv {
	margin-left: auto;
	margin-right: auto;
	width: 95%;
}

.logindiv, .membershipdiv {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	background-color: #1a70dc;
	color: aliceblue;
	line-height: 35px;
}

.loginbtn {
	padding-top: 10px;
	padding-bottom: 50px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	background-color: #1a70dc;
	color: aliceblue;
	line-height: 35px;
}

.kakaologindiv {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	background-color: #fee500;
	line-height: 35px;
}

.gohmoe{
    padding-top: 10px;
    padding-bottom: 40px;
    margin-left: auto;
    margin-right: auto;
    width: 95%;
    height: 40px;
    border: none;
    line-height: 35px;
}

#gohmoeicon{
    width: 110px;
}





#naver{

    border: none;
    background-color: transparent;
    color: aliceblue;
    

}

.naverlogindiv {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	color: aliceblue;
	background-color: #03c75a;
	line-height: 35px;
}

.login_membershipdivwrapper {
	text-align: center;
}
</style>

<script>
	window.onload = function() {
		$("#naver").click(function() {
			location.href = "naverloginform.do"
		})

		
		$("#gohmoeicon").hover(function(){
			$(".gohmoe").css({"background-color":"#72AEE3"})
			
			
		})
		
		
		$("#gohmoeicon").mouseout(function(){
			$(".gohmoe").css({"background-color":"transparent"})
			
			
		})
		
		
		
	}
</script>

<body>
<div class="all">
<div class="divwrapper">
	<div class="alldivwrapper">
		<div class="imgdiv">
			<h2>
				<!-- 로그인 <img id="imgone" src="img_membership/membership.png"> -->
			</h2>

		</div>
		<div id="loginformwrapper">
            <span>Login </span>            
            <!-- 정상 로그인 컨트롤러 login.do  -->
            <!-- 인젝션 로그인 :sqlinjectlogin.do  -->
            
			<form class="loginform container" action="login.do" method="post">
				<div class="iddiv">
					<h3>아이디</h3>
					<!--value="${userVO.id}" 를 지워봄  -->
					<input type="text" class="idinput" placeholder="ID" id="id"
						name="id" value="">
				</div>
				<div class="passworddiv">
					<h3>비밀번호</h3>
					<!--value="${userVO.password}" 를 지워봄  -->
					<input type="password" class="passwordinput" placeholder="Password"
						id="password" name="password" value="">
				</div>				
				<div class="naverlogindiv">
						<button type="button" class="sqlinjectlogin" >sql인젝션로그인</button>
					</div>
				<br> <br>
				<div class="login_membershipdivwrapper">
					<!-- 조심해라! form태그 안에 버튼 태그 타입의 디폴트값은 submit으로  현재 로그인 버튼은 서브밋이다. -->
					<span>password= '1' or '1=1 ';</span>
						<span>id= ' or 1=1--;</span>
					
					<button class="loginbtn">로그인</button>
					<br>
					<br>
		
				<div class="membershipdiv" type="button"
						onclick="javascript:location.href='phonesms.jsp'">회원가입</div>
						<br>
					<br>
					
							<div class="membershipdiv" type="button"
						onclick="javascript:location.href='loginfom.do'">시큐리티 회원가입</div>
						<br>
					<br>						
				
					<div class="naverlogindiv">
						<button type="button" id="naver">네이버로그인</button>
					</div>
					<br>
					<div class="naverlogindiv">
						<button type="button" onclick="javascript:location.href='loginfom.do'">시큐리티 로그인</button>
					</div>
					<br>
				
					
	<div class="gohmoe" onclick="javascript:location.href='mainhome.jsp'"><img id='gohmoeicon' src="./img_icon/homeicon.png"></div>
			
			</form>
		</div>
	</div>
</div>
</div>
<script>

$(".sqlinjectlogin").on("click",(e)=>{
	let  password=$(e.target).parent().prev().children().next().val();
	let id=$(e.target).parent().prev().prev().children().next().val();

	
	console.log("id->"+id+"password->>"+password);
	
	window.location.href="sqlinjectlogin.do?id="+id+"&password="+password;
	
})




</script>
</body>
</html>