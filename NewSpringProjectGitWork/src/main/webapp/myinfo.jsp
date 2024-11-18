<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<link
	href="https://fonts.googleapis.com/css2?family=Orbit&family=Sunflower:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 아이디 : 4~12글자, 영어나 숫자만 가능하다.
    8글자 이상, 영문, 숫자, 특수문자를 모두 사용해야 한다.
    비밀번호 확인 : 비밀번호와 일치해야 한다. -->
<style>

.mobileheader{
display:none;
}


/*pcNave의 속성을 재정의 페이지 마다 색깔이나 배경이다르니 pcNave.jsp 의 태그 css를 수정한다.   */

.naveulwrapper ul{
color:#000 !important;
font-size: 14px !important;


}

.naveulwrapper a{
color:#000 !important;
}

.naveulwrapper li{
    padding: 5px 5px !important;
}

/*pcNave의 속성을 재정의 페이지 마다 색깔이나 배경이다르니 pcNave.jsp 의 태그 css를 종료  */



.alldivwrapper {
	max-width: 500px;
	position: relative;
	margin-left: auto;
	margin-right: auto;
}

.imgdiv {
	padding-top: 150px;
}

 .imgdiv  img {
	position: absolute;
	right: 0px;
	top: 100px;
	height: 200px;
	width: 200px;
}

#membershipform {
	border: 1px solid #ddd;
}

#idslengthcheck {
	display: none;
}

#idspattern {
	display: none;
}

.idsinput {
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	width: 100%;
	height: 50px;
}

.idinput {
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	width: 100%;
	height: 50px;
}

#idduplicationcheck {
	/* 이유는 모르겠는데 위드스100% 로가 씹혀 그냥 절대단위 px으로 함 */
	width: 505px !important;
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	height: 50px;
}

.checkpwdinput {
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	width: 100%;
	height: 50px;
}

.pwdinput {
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	width: 100%;
	height: 50px;
}

.finallsubmitinput {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	height: 40px;
	border: none;
	background-color: #1a70dc;
	color: aliceblue;
	line-height: 30px;
}


#successcontatinder {
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0;
	left: 0;
	justify-content: center;
	align-items: center;
	background: rgba(0, 0, 0, 0.5);
}

#suceessmodal {
	width: 300px;
	height: 150px;
	background-color: #ffffff;
}

/* 나의 정보 디자인 css 디자인 */
.myinfotablearea {
	display: flex;
	flex-direction: column;
}

.titlecontetn {
	text-align: center;
	color: white;
	font-weight: 700;
	background: #1e81f8;
}

.infocontent {
	display: grid;
	grid-template-columns: 100px 1fr;
}

.infonametext {
	background: #f9f9f9;
	padding: 10px 5px;
	color: #555;
}

.infotext {
	padding: 10px 5px;
}

.changepassword {
	text-align: right;
}

.changepassword button {
	color: white;
	font-weight: 700;
	background: #1e81f8;
	border: none;
}

#loginformwrapper {
	display: none;
}


	#successcontatinder{
	left: 300px !important;
    max-width: 140px !important;
    position: absolute;
        top: 220px;
        display:none;
        }


	#suceessmodal{
	    width: 100%;
    height: 80%;
        display: flex;
    flex-direction: column;
    justify-content: space-between;
	}



@media screen and (max-width: 701px) {

#navebarwrapper{
display:none;
}

.mobileheader{
display:block;
}

	body {
		padding: 0px 0px !important;
		margin: 0px 0px !important;
	}
	.alldivwrapper {
		max-width: 344px !important;
	}
	.loginformwrapper {
		max-width: 344px !important;
	}
	
	.imgdiv  img {
	top: 60px;
	
}
	
	
	
	#idduplicationcheck {
		width: 344px !important;
	}
		
		
	#successcontatinder{
	border-radius: 10px 10px 10px 10px;
	box-shadow: 5px 5px 20px;
	left: 8px !important;
	max-width: 344px !important;
        position: absolute;	
	height: 150px;
    top: 220px;
    background: rgba(0, 0, 0, 0.5);	
	}
	
	#suceessmodal{
	    width: 100%;
    height: 80%;
  

	}

	
}
</style>
<script>
var pwdcheck;
var pwdcheckstep2;

	window.onload = function() {
		

		
		
		$(".changepassword").on("click",()=>{		
			$(".myinfotablearea").hide();
			$("#loginformwrapper").show();
			
		})
		
		
	

		$("#afterpwdpwd").attr("disabled", "true");
		$("#aftercheckpwd").attr("disabled", "true");
		/* 	$("#idduplicationcheck").attr("disabled", "true"); */

		$("#finallsubmit").attr("disabled", "true")
		$("#pwdlengthcheck").hide();
		$("#pwdpattern").hide();

		/* data-val 는 최종 제출 하기전  하나라도 부족한게 있는지 체크하는 용도임 */
		$("#id").attr("data-val", "false");
		$("#idduplicationcheck").attr("data-val", "false")
		$("#checkpwd").attr("data-val", "false");

		$("#pwd").attr("data-val", "false");
		var id = document.querySelector("#ids")
		var pwd = document.querySelector("#afterpwdpwd");
		var checkpwd = document.querySelector("#aftercheckpwd");

		//아이디입력창 폼 함수 종료
		
		//현재의 비밀번호 확인아작스
		$("#idduplicationcheck").on("click",function() {

			console.log("아이디"+$("#ids").val()+" 현재비번"+$("#pwd").val());
			id=$("#ids").val();
			password=$("#pwd").val();
			
			
			 $.ajax({
				url : "checkpassword.do",
				type : "POST",
				data : {
					"id" : id,
					"password" :password
				},
				success : function(data) {
					console.log("아작스통신 성공?->>>>" + data);
					if (data) {
						$("#answerexistpwd").val("현재비밀번호를확인하였습니다.");
						$("#afterpwdpwd").removeAttr("disabled");
						pwdcheck=true;
						

					} else {
						$("#answerexistpwd").val("비밀번호를다시확인하여주세요")
						pwdcheck=false;
					}
				},
				error : function() {

				}

			}) 

		})//현재 비밀번호 확인 아작스종료
		
		
		//그냥 잡기능
		$(".pwdinput").on("click",()=>{
			let clear=	$("#answerexistpwd").val();
			console.log(clear=="비밀번호를다시확인하여주세요")
		if(clear=="비밀번호를다시확인하여주세요"){
			$("#answerexistpwd").val("");
		}
			
		})
		
		

		//비빌번호 변경 하기 아작스
		$("#finallsubmit").on("click", function() {

			if(pwdcheck&&pwdcheckstep2){
				id=$("#ids").val();
				afterpassword= $("#afterpwdpwd").val();				
				console.log("아이디 :"+id+" 바꿀비번: "+afterpassword)
				
				$.ajax({
					url : "changepassword.do",
					type : "POST",
					data : {
						"id" : id,
						"afterpassword" : afterpassword
					},
					
					success : function(data) {
						console.log("아작스통신 성공?->>>>" + data);
						if (data) {
							$("#successcontatinder").show();
							$("#suceessmodal").show();
							$(".alldivwrapper").hide();							
						} else {
							$("#answerexistpwd").val("비밀번호를다시확인하여주세요")
							pwdcheckstep2=false;
						}
					},
					error : function() {

					}
				})	//아작스 통신종료
				
			}
			
		})//클릭함수종료
			
			
		
		//클래스명이나 아디디 명에 . 하고 onkeyup 등 이벤트 걸기
		pwd.onkeyup = function() {

			let pwdlength = pwd.value
			console.log("벡스페이스시길이" + pwdlength.length);
			if (pwdlength.length !== 0) {
				$("#pwdlengthcheck").show();

				console.log("pwdlengthcheck(pwdlength)->>>"
						+ pwdlengthcheck(pwdlength));
				if (pwdlengthcheck(pwdlength)) {
					$("#pwdlengthcheck").hide();

					if (pwdpattern(pwdlength) || pwdlengthcheck(pwdlength)) {
						$("#pwdpattern").show();
						console.log("패턴->>>" + pwdpattern(pwdlength));
						if (pwdpattern(pwdlength) && pwdlengthcheck(pwdlength)) {
							$("#aftercheckpwd").removeAttr("disabled");
							//여기까지 확인됨

							$("#pwdpattern").hide();
							$("#pwdlengthcheck").hide();
							if ($("#aftercheckpwd").val() != ''
									&& pwdpattern(pwdlength)) {
								console.log("어머나 이게 나?"
										+ $("#aftercheckpwd").val())
								$("#aftercheckpwd").val('');
								$("#aftercheckpwd").attr("disabled", "true");
							}

						}
					}

				} else if ($("#aftercheckpwd").val() != ''
						&& pwdlength.length !== 0) {
					$("#aftercheckpwd").val('');
					$("#aftercheckpwd").attr("disabled", "true");
					$("#finallsubmit").attr("disabled", "true");
				} else {
					$("#aftercheckpwd").attr("disabled", "true");
					$("#pwdpattern").hide();
				}
				$("#pwdpattern").hide();

			} //첫 이프문

		}

		checkpwd.onkeyup = function() {
			console.log("어머나 이게 나?" + $("#aftercheckpwd").val());
			console.log("같은데 왜 불일치영" + $("#afterpwdpwd").val());
			/* $("#checkpwd").attr("disabled","true");   */
			let check = checkpwd.value;
			if ($("#afterpwdpwd").val() == check) {
				console.log("비밀번호일치")
				$("#finallsubmit").removeAttr("disabled");
				pwdcheckstep2=true;
			} else {
				console.log("비밀번호 불일치")
				$("#finallsubmit").attr("disabled", "true");
				pwdcheckstep2=false;
			}

		}

		//아이디 길이 만족 함수
		function idlengthcheck(value) {

			return value.length > 4 && value.length < 7;

		}
		//아이디는 대소/문/숫 판별만족함수
		function idspattern(str) {
			return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
		}

		//패스워드 길이 만족 함수
		function pwdlengthcheck(value) {

			return value.length > 7 && value.length < 40;

		}

		//패스워드 대소/문/숫 판별만족함수
		function pwdpattern(str) {
			return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
		}

	}
</script>
</head>

<body>	
	<div class="alldivwrapper">	
	
	<%@ include file="/pcNave.jsp"%>
	<%@ include file="/mobileNave.jsp"%>
	
	
		<div class="imgdiv">
			<h2>
				로그인 <img src="./img_membership/membership.png">
			</h2>

		</div>




		<div class="myinfotablearea">
			<div class="titlecontetn">
				<h3>기본정보</h3>
			</div>

			<!-- 여기다가 class="infocontent"  jstl 반복문 돌리시고 -->
			<%
			List<String> infonamelist = new ArrayList();
			infonamelist.add(0, "아이디");
			infonamelist.add(1, "이메일주소");
			infonamelist.add(2, "연락처");
			infonamelist.add(3, "가입일");
			%>


			<%-- ${myinfolist}		 --%>


			<c:forEach items="${myinfolist}" var="myinfo" varStatus="i" begin="0"
				end="4">
				<c:set var="infoname" value="<%=infonamelist%>"></c:set>
				<div class="infocontent">
					<div class="infonametext">${infoname.get(i.index)}</div>
					<div class="infotext">${myinfo}</div>
				</div>
			</c:forEach>
			<div class="changepassword">
				<button>비밀번호변경</button>
			</div>

		</div>

		<div id="loginformwrapper">

			<form action="공란" id="membershipform" method="post">
				<div class="iddiv">
					<h3>로그인중인비밀번호를입력하여주세요</h3>

					<input type="hidden" class="idsinput" id="ids" name="id"
						value="${userId}"> <input type="text" class="pwdinput"
						id="pwd" name="password" data-val="false"> <input
						type="text" class="idinput" id="answerexistpwd" value="">
					<h1 id="idslengthcheck">아이디는4자이상 7자이상만</h1>
					<h1 id="idspattern">패턴이틀립니다.</h1>
					<input type="button" id="idduplicationcheck" data-val="false"
						value="현재비밀번호확인">
				</div>


				<div class="passworddiv">
					<h3>새롭게변경할 비밀번호를입력해주세요</h3>
					<input type="password" class="pwdinput" id="afterpwdpwd" name="afterpassword" data-val="false">
					<input type="password" class="checkpwdinput" id="aftercheckpwd" name="checkpwd" value="">
				</div>


				<br> <br>
				<div class="login_membershipdivwrapper">
					<input class="finallsubmitinput" id="finallsubmit" type="button"
						value="비밀번호변경">



				</div>
			</form>
		</div>

	</div>
	<!--올레퍼 종료  -->



		<div id="successcontatinder">
		<div id="suceessmodal">
			<p>비밀번호 변경에 성공하였습니다.</p>
			<a href="login.jsp">로그인하러가기</a>
		</div>
	</div>
<!--  <button id="showtest">쇼유하이드테스트</button>
<script type="text/javascript">
$("#showtest").on("click",()=>{
	
$("#successcontatinder").show();
$("#suceessmodal").show();
$(".alldivwrapper").hide();


	
})
</script>  -->



</body>
</html>