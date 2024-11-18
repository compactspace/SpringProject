<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index페이지</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
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
<style>


/*pcNave의 속성을 재정의 페이지 마다 색깔이나 배경이다르니 pcNave.jsp 의 태그 css를 수정한다.   */
.naveulwrapper ul {
	color: #000 !important;
	font-size: 16px;
}

.naveulwrapper  ul li {
	padding:5px 5px !important;
}

.naveulwrapper a {
	color: #000 !important;
}

/*pcNave의 속성을 재정의 페이지 마다 색깔이나 배경이다르니 pcNave.jsp 의 태그 css를 종료  */



* {
	margin: 0;
	padding: 0;
}

body {
	margin: 0 0 0 0px;
	box-shadow: 0 0 17px 3px rgb(171 171 171/ 50%);
	background-color: #FFF !important;
}

p {
	background-color: rgb(119, 193, 61) font-family: 'Sunflower', sans-serif;
}

#headerwrappers {
	max-width: 560px;
	margin: 0 auto;
	box-shadow: 0 0 17px 3px rgb(171 171 171/ 50%);
}

header {
	position: relative;
	height: 70px;
	background: #fff;
	margin: 0;
}

/* 배치도 생각으로 전체 wrapper 감싼후 마진 오토 */
#bodywrapper {
	display: grid;
	grid-gap: 30px;
	position: relative;
	max-width: 560px;
	/* 	max-height: 688px; */
	margin: 0 auto;
	width: 560px;
	background-color: rgb(171 171 171/ 50%);
	box-shadow: 0 0 17px 3px rgb(171 171 171/ 50%);
}

h2 {
	font-weight: 500;
	color: #333333;
	font-style: normal;
}

nav {
	position: absolute;
	top: 20px;
	width: 100%;
}

ul {
	display: flex;
	list-style-type: none;
}

li {
	display: inline-block;
	width: 30%;
	text-align: center;
	color: #333333;
	letter-spacing: .01em;
	font-style: normal;
	font-weight: 300;
}

a {
	text-decoration: none;
	color: #333333;
}

#header1 {
	width: 100%;
	color: #333333;
	padding: 20px 0px;
	font-weight: 600;
}

#content1 {
	border-bottom: 1px solid rgba(230, 230, 230, 0.5);
}

.paymentstatus {
	padding-top: 15px;
	gap: 25px;
	font-size: 15px;
	display: flex;
	justify-content: right;
	color: #98CBFD;
}

.paymentstatus h3 {
	position: relative;
}

.payarea::after {
	content: "";
	position: absolute;
	left: 0px;
	bottom: 0px;
	height: 1px;
	width: 100px;
	background: #1e81f8;
}

.paycancelarea::after {
	content: "";
	position: absolute;
	left: 0px;
	bottom: 0px;
	height: 1px;
	width: 100px;
	background: #1e81f8;
}


.totallpayment {
	text-align: right;
	color: white;
	font-weight: 700;
	background: #1e81f8;
	    margin-bottom: 10px;
	
}

.totallpaymentinfo {
	padding: 10px 10px;
}

.content2 {
	background: rgb(255, 255, 255);
	border-radius: 10px;
	display: grid;
	grid-template-columns: 140px auto;
}

.classname {
	color: #252525;
	background: #fff;
	padding: 10px 0px;
	font-weight: 600;
	font-size: 13px;
}

.classname>h2 {
	margin-left: 5px;
}

.classname>p {
	display: block;
	width: 80%;
	margin: 5px 0px 0px 5px;
	font-weight: 300;
}

.Section2_2 {
	width: 100%;
	padding: 10px 10px;
	display: grid;
}

}
#info2 {
	width: 90%;
	float: left;
	margin: 0px 0px 30px 50px;
	color: #333333;
}

.Section2_3 {
	display: grid;
}

.cancelarea {
	text-align: right;
}

.cancelicon {
	height: 20px;
	width: 20px;
}

.applicantinfoarea {
	width: 100%;
	display: flex;
	flex-direction: column;
}

.detail {
	display: flex;
	padding: 10px;
}

.detail span {
	font-size: 14px;
}

.reserve_img {
	display: block;
	width: 130px;
	height: 130px;
}

#info3 {
	width: 90%;
	float: left;
	margin: 0px 0px 30px 50px;
}

.allwarpper {
	position: absolute;
	/*컨텐츠의 위쪽 기준 으로 50% 수직임  */
	top: 50%;
	/*따라서 높의 절반만큼 올려준다. */
	margin-top: -339.5px;
	/*컨텐츠의 왼쪽 기준 으로 50% 이동임  */
	left: 50%;
	/*따라서 컨텐츠의 널비 절반만큼 올려준다. */
	margin-left: -280px;
}

.cancelcontent {
	display: none
}



.paycontent {
/* background-color: rgb(255, 88, 98); */
	/* background-color: white; */
}

.emptyinof {
	font-size: 20px;
}

.emptyimg {
	text-align: center;
}

.emptyimg img {
	padding: 20px;
}

.goclassreserve {
	padding-bottom: 10px;
}

.goclassreserve span {
	color: white;
	font-weight: 700;
	background: #1e81f8;
	border: 1px solid;
	padding: 5px;
}


.payarea {
	display: flex;
	flex-direction: column;
	    gap: 20px;
}

.payinfolabel{

    position: relative;
}

.shortinfoarea {
	display: flex;
	flex-direction: column;
	box-shadow: 5px 5px 5px gray;	
	border-radius: 10px 10px 10px 10px;
    width: 95%;
    margin: 0 auto;
        margin-top: 10px;
        background-color: white;
        
	/*    margin-left: 60px;
	   width: 80%;  
    top: 40%;  
    position: absolute;
    margin-top: -30px; */
}		
	
.infoandpaystatus{
border-bottom: 1px solid #000;
}	
	


.infostatus {
	display: flex;
	flex-direction: column;
	padding: 5px 5px;
}

.infostatus h3 {
    padding: 2px 0px;
font-family: 'Noto Sans KR';
    font-weight: 400;
    font-size: 16px;
    color: #000;
}


.paystatus {

	display: flex;
	justify-content: space-between;
	    padding: 5px 5px;
	        gap: 2px;
    flex-direction: column;
}

.paystatus h3 {
	font-size: 15px;
	font-weight: 700;
	color: #98CBFD;
}

 .detailpayinfo h3{
padding: 5px 5px;
    text-align: center;
}


@media screen and (max-width: 701px) {


.mobileheader {
		display: block;
	}
	#navebarwrapper {
		display: none;
	}


	.allwarpper {
		top: 0px !important;
		margin-top: 0px !important;
		left: 0px !important;
		margin-left: 0px !important;
	}
	#headerwrappers, #bodywrapper {
		margin: 0px 0px !important;
		max-width: 360px !important;
	}
	
/* 	.payarea {
	display: flex;
	flex-direction: column;
}

.payinfolabel{
height: 100px;
    position: relative;
}

.shortinfoarea {
	display: flex;
	flex-direction: column;
	box-shadow: 5px 5px 5px gray;
	    margin-left: 30px !important;    
    top: 50%;   
    position: absolute;
    margin-top: -30px;
} 
	
	
}

.infostatus {
	display: flex;
	flex-direction: column;
}

.infostatus h3 {
	font-size: 10px;
	font-weight: 700;
}

.paystatus {
	display: flex;
	justify-content: space-between;
}

.paystatus h3 {
	font-size: 15px;
	font-weight: 700;
}
	*/
	
	
}
</style>

<script type="text/javascript">
	window.onload = function() {
		
		$(".goclassreserve").click(()=>{
			window.location.href="/finall2/onedayclass.jsp"
		})

		
		//payarea
		$(".paycancelarea").removeClass('paycancelarea'); 
		
	
		$("#paycancelarea").click(()=>{
			console.log("클릭")
			$(".payarea").removeClass('payarea'); 
			$("#paycancelarea").addClass('paycancelarea'); 
			$(".cancelcontent").css("display", "block");
			$(".paycontent").css("display", "none");
		})

		$("#payarea").click(()=>{
			console.log("클릭")
			$(".paycancelarea").removeClass('paycancelarea'); 
			$("#payarea").addClass('payarea');
			$(".cancelcontent").css("display", "none");
			$(".paycontent").css("display", "block");
		})

		
		
		
		
		let cancels = document.querySelectorAll(".cancelarea")
		
		for (let cancel of cancels) {
			cancel.addEventListener('click', function(event) {
				/* console.log(this.previousSibling)
				console.log(this.nextSibling)
				console.log(this.nextSibling.value) */
				
			/* 	console.log(event.target)
				console.log(event.target.nextSibling.value) */
				
				//이벤트 타겟 제어법을 몰라..제이쿼리를 씀
			
			let next=	$(event.target).next();
				
			/* 	console.log(next)
				console.log(next.val()) */
			let cancelcode=next.val();
			let openday=next.next().val();
			let onedayclass_num=next.next().next().val();
			let reserveinfo_num=next.next().next().next().val();
			/* console.log("코드는"+cancelcode+"  개설강의 날짜"+openday+"  클래스번호"+onedayclass_num) */
	
				cancelPay(cancelcode,openday,onedayclass_num,reserveinfo_num)
		  })
		}
		

		
		//취소 api호출
		function cancelPay(cancelcode,openday,onedayclass_num,reserveinfo_num) {
	// 결제 취소를 위해 필요한 변수들
	//merchant_uid 토큰발급을 위한 변수
	//cancel_request_amount 결제 금액 취소를 위한변수
	// 그리고 취소가 되었다면 수업의 남은 자리수를 올리기위한 변수들
	//onedayclass_num 과 openday
	//UPDATE reserverest rest=10 WHERE onedayclass_null=? AND openday=?
			
			console.log("코드는"+cancelcode+"  개설강의 날짜"+openday+"  클래스번호"+onedayclass_num+"예약번호는 "+reserveinfo_num)
			
		
		 	$.ajax({
			url : "callcancelapi.do",
			method : "get",
			data : {
				"merchant_uid":cancelcode,
				"cancel_request_amount":100,
				"openday":openday,
				"onedayclass_num":onedayclass_num,
				"reserveinfo_num":reserveinfo_num
			},
			success : function(data) {
				console.log(data);
				if(data ==1 || data=="1"){
					alert("취소처리 되었습니다.");
					window.location.reload();	
				}
				else{
					alert("결제에 실패했습니다. 잠시후 다시 시도해주세요");
				}
				
				
			},
			error : function() {

			}

		})//아작스 통신 종료
		
		}//취소 api호출 종료		
		
		
	
		$("#testbtn").on("click",(e)=>{
			
			let displaycss=$(".payarea").css("display");
			console.log(displaycss)			
			if(displaycss=="block"){
				$(".payarea").css({"display":"none"})	
			}
			if(displaycss=="none"){
				$(".payarea").css({"display":"block"})	
			}
			
			
		})
		
		
		
		
	}//윈도우 함수 종료
</script>
</head>
<body>
	<div class="allwarpper">
		<%@ include file="/mobileNave.jsp"%>
		<%@ include file="/pcNave.jsp"%>
		<div class="paymentstatus">

			<h3 id="payarea" class="payarea">나의 결제건</h3>
			<h3 id="paycancelarea" class="paycancelarea">나의 취소건</h3>

		</div>

		<div id="content1">

			<h3 id="header1">나의 결제현황</h3>

		</div>


		<div class="totallpayment">
			<h3 class="totallpaymentinfo">총 결제/환불 ${mypayinfo.size()}건</h3>
		</div>
		<div id="bodywrapper">
			<div class="paycontent">



				<c:choose>
					<c:when test="${mypayinfo eq null  }">
						<h1>결제건이 없습니다.</h1>
					</c:when>
					<c:otherwise>

						<div class="payarea">
							<c:forEach items="${mypayinfo}" var="first" varStatus="status">

								<%-- 	<input type="hidden" value="${list.add(first.reservestatus)}"> --%>
								<c:set var="receipt_merchant_uid"
									value="${first.receipt_merchant_uid}" />
								<c:set var="receipt_paid_amount"
									value="${first.receipt_paid_amount}" />

								<c:set var="cartvo" value="${first.cartvo}" />
								<c:set var="cartvosize" value="${first.cartvo.size()}" />
								<c:set var="orderinfovo" value="${first.orderinfovo}" />


<%-- <h1>배열?:${orderinfovo.size()}</h1>
<h1>배열?:${orderinfovo}</h1> --%>

<!--  이게다 디비를 제 1유형으로 세팅해서 생긴 일이다.. 코드가 중첩으로 계속 포이치임.. 쓰레기인듯	 -->
<c:choose>
<c:when test="${orderinfovo.size()<=1 }">
								<!-- 어쩔수 없음 데이터를 이딴식으로 받아와서 중첩 포이치로 돌려야함  -->
								<c:forEach items="${orderinfovo}" var="orderinfo">
								
									<c:if test="${orderinfo.orderinfo_pay eq 'yes'}">
										<!-- 어쩔수 없음 데이터를 이딴식으로 받아와서 중첩 포이치로 돌려야함  -->
										<div class="payinfolabel">
											<div class="shortinfoarea">
											<div class="infoandpaystatus">
												<div class="infostatus">
													<h3>고객 결제 번호: ${receipt_merchant_uid}</h3>
													<h3>고객 결제 일: ${orderinfo.orderinfo_create}</h3>
													<h3>고객 구매 건: ${cartvo.get(0).product_name} 외
														${cartvosize-1}건</h3>
												</div>
												<div class="paystatus">
												<c:if test="${orderinfo.orderinfo_pay eq 'yes'}"><h3 >고객 결제상태:결제완료</h3></c:if>
													<h3>고객 결제금액: ${receipt_paid_amount}</h3>
												</div>
												</div>
												<div class="detailpayinfo"><a href="mypaydetailinfo.do?id=${userId}&receipt_merchant_uid=${receipt_merchant_uid}&status=pay"><h3 style="color: #1e81f8;">상세확인/결제취소</h3></a></div>
											</div>											
										</div>
									</c:if>
								</c:forEach><!-- 오더 인포가 하나만 물고 있는경우  -->
								</c:when>
								
								<c:otherwise>
										<c:forEach items="${orderinfovo}" var="orderinfo" end="0">
								
									<c:if test="${orderinfo.orderinfo_pay eq 'yes'}">
										<!-- 어쩔수 없음 데이터를 이딴식으로 받아와서 중첩 포이치로 돌려야함  -->
										<div class="payinfolabel">
											<div class="shortinfoarea">
											<div class="infoandpaystatus">
												<div class="infostatus">
													<h3>고객 결제 번호: ${receipt_merchant_uid}</h3>
													<h3>고객 결제 일: ${orderinfo.orderinfo_create}</h3>
													<h3>고객 구매 건: ${cartvo.get(0).product_name} 외
														${cartvosize-1}건</h3>
												</div>
												<div class="paystatus">
												<c:if test="${orderinfo.orderinfo_pay eq 'yes'}"><h3 >고객 결제상태:결제완료</h3></c:if>
													<h3>고객 결제금액: ${receipt_paid_amount}</h3>
												</div>
												</div>
												<div class="detailpayinfo"><a href="mypaydetailinfo.do?id=${userId}&receipt_merchant_uid=${receipt_merchant_uid}&status=pay"><h3>상세확인/결제취소</h3></a></div>
											</div>											
										</div>
									</c:if>
								</c:forEach><!-- 오더 인포가 하나만 물고 있는경우  -->
								</c:otherwise>			
								
								</c:choose>
								
								
								

							</c:forEach>
						</div>
					
					</c:otherwise>


				</c:choose>
			</div>
			<div class="cancelcontent">
			
				<c:choose>
					<c:when test="${mypayinfo eq null  }">
						<h1>고객님 취소내역</h1>
					</c:when>
					<c:otherwise>

						<div class="payarea">
							<c:forEach items="${mypayinfo}" var="first" varStatus="status">

								<%-- 	<input type="hidden" value="${list.add(first.reservestatus)}"> --%>
								<c:set var="receipt_merchant_uid"
									value="${first.receipt_merchant_uid}" />
								<c:set var="receipt_paid_amount"
									value="${first.receipt_paid_amount}" />

								<c:set var="cartvo" value="${first.cartvo}" />
								<c:set var="cartvosize" value="${first.cartvo.size()}" />
								<c:set var="orderinfovo" value="${first.orderinfovo}" />

								<!-- 어쩔수 없음 데이터를 이딴식으로 받아와서 중첩 포이치로 돌려야함  -->
								<c:forEach items="${orderinfovo}" var="orderinfo">

									<c:if test="${orderinfo.orderinfo_pay eq 'no'}">
										<!-- 어쩔수 없음 데이터를 이딴식으로 받아와서 중첩 포이치로 돌려야함  -->
										<div class="payinfolabel">
											<div class="shortinfoarea">
											<div class="infoandpaystatus">
												<div class="infostatus">
													<h3>고객 취소 번호: ${receipt_merchant_uid}</h3>
													<h3>고객 결제취소 일: ${orderinfo.orderinfo_cancel_create}</h3>
													<h3>고객 취소 건: ${cartvo.get(0).product_name} 외
														${cartvosize-1}건</h3>
												</div>
												<div class="paystatus">
												<c:if test="${orderinfo.orderinfo_pay eq 'yes'}"><h3 >고객 결제상태:취소완료</h3></c:if>
													<h3>고객 환불금액: ${receipt_paid_amount}</h3>
												</div>
												</div>
												<div class="detailpayinfo"><a href="mypaydetailinfo.do?id=${userId}&receipt_merchant_uid=${receipt_merchant_uid}&status=cancel"><h3>상세취소내역</h3></a></div>
											</div>											
										</div>


									</c:if>


								</c:forEach>

							</c:forEach>
						</div>
					
					</c:otherwise>


				</c:choose>
		
			</div>
		</div>
	</div>
</body>
</html>