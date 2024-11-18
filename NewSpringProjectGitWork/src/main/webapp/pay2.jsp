<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	padding: 0px 0px;
	margin: 0px 0px;
}

.allwrapper {
	display: flex;
	flex-direction: column;
	min-width: 1152px;
	min-height: 100%;
	background-color: #f3f5f7;
}

.headerarea {
	background-color: #ffffff;
	text-align: center;
	font-family: -apple-system, BlinkMacSystemFont, helvetica,
		"Apple SD Gothic Neo", "나눔고딕", NanumGothic, "맑은 고딕", MalgunGothic,
		sans-serif;
	font-size: 14px;
}

.headerinfo {
	position: relative;
	padding-top: 16px;
	padding-bottom: 14px;
}

.bodyarea {
	width: 1080px;
	margin: 0 auto;
}

.bodytitle {
	display: flex;
}

.leftarea {
	flex: 0 0 681px;
	min-width: 0;
}

.leftinfo {
	padding-bottom: 40px;
}

.contents {
	margin-top: 12px;
	padding: 20px 16px;
	border-radius: 12px;
	background-color: #fff;
	display: grid;
	grid-template-columns: 20% 80%;
}

.col1>img {
	width: 100%;
	height: 100%;
}

.col2 {
	font-size: 16px;
	line-height: 22px;
	letter-spacing: -0.3px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	display: block;
	color: #404048;
	font-weight: 500;
}

.rightarea {
	flex: 0 0 375px;
	min-width: 0;
	margin-left: 24px;
}

.rightinfo {
	margin-top: 12px;
	padding: 20px 16px;
	border-radius: 12px;
	background-color: #fff;
}

#insertreceipt {
	display: none
}

@media screen and (max-width: 701px) {
	.allwrapper {
		max-width: 344px !important;
		min-width: 0px !important;
	}
	.bodyarea {
		max-width: 344px !important;
	}
	.bodytitle {
		flex-direction: column;
	}
	.contents {
		max-width: 344px !important;
		grid-template-columns: 100px 240px;
		padding: 0px 0px !important;
	}
	.col1 img {
		width: 100px;
		height: 100px;
	}
	.col2 {
		width: 80% !important;
	}
	.col1, .col2 {
		padding: 10px 10px !important;
	}
	.leftarea {
		flex: 0px !important;
	}
	.rightarea {
		flex: 0px !important;
		margin-left: 0px !important;
	}
}
</style>


<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
var cart_idarray=[];
var cart_quantityArray=[];
var product_codArray=[];



var chk = false;
$(document).ready(function(){
	
	

	
	

	let cart_ids=document.getElementsByClassName("cart_id");
	let cart_quantitys=document.getElementsByClassName("cart_quantitys");
	let product_cods=document.getElementsByClassName("product_cods");
/* 	console.log(cart_ids[0].getAttribute("value"));
	console.log(cart_ids.length) */
	
	for(let k=0; k<cart_ids.length; k++){
		cart_idarray[k]=cart_ids[k].getAttribute("value");
		console.log(cart_idarray[k]);
	} 
	
	for(let k=0; k<cart_quantitys.length; k++){
		cart_quantityArray[k]=cart_quantitys[k].getAttribute("value");
		console.log("변수명...내업보다....")
		console.log(cart_quantityArray[k]);
	} 
	
	for(let k=0; k<product_cods.length; k++){
		product_codArray[k]=product_cods[k].getAttribute("value");
		console.log(product_codArray[k]);
	}
	
	
	
	
	let IMPKEY = "imp77544746";
	
	$("#completequantity").click(()=>{
		$.ajax({
			url : "/completeredis.do",
			data : {"receipt_merchant_uid": $("#merchant_uid").val(),"receipt_buyer_id":$("#unm").val()},
			method : "POST",
			success : function(val){
				console.log(val);
				if(val>0){
					alert("재고반영");
					/* $("#all_mdule").trigger("click"); */
				}
				else alert("재고반영 실패");
			},
			error :  function(request, status){
				alert("재고수정시 오류");
			}
		});
		
		
		
		
	})
	
	
	
		
	var IMP = window.IMP; // 생략가능
	
	// imp 객체를 가맹점식별코드로 초기화 한다 암기
	// 물론  위에 스크립트 불러와야함
	
	IMP.init(IMPKEY);
	//test(navigator.userAgent)  헤더 정규패턴??
	var isMobile = /Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent) ? true : false;
	   
	if(!isMobile) {
		//모바일이 아닌 경우 스크립트
		$("#check_module").click(function () {
			
		//IMP.request_pay 를 요약하자면 첫 번째 매개변수 {} 꼴에서 데이터를 넣어 통신 요청을하고
			// 두번째 매개인자인 콜백함수 fucntion(rsp)가 아작스의 success함수처럼 응답을 받아와 처리하는듯
			IMP.request_pay({
				pg: "danal_tpay.9810030929", 
				pay_method: 'card',
				//callback에서 결제가 성공하면 rsp의 imp_uid와 merchant_uid를 가맹점 서버에 인자로 전달
				merchant_uid: new Date().getTime(),
				name: '주문명:결제테스트',				
				amount: $("#amount").val(),
				salequantity: $("#salequantity").val(),	
				buyer_name: $("#unm").val(),
				buyer_tel: $("#utel").val(),
				buyer_addr: $("#uaddr").val() ,
				buyer_postcode: '123-456',
				}, function (rsp) {//아작스의 함수 success 비슷 rsp 는 성공 에러 다 받음 	
				
					if (rsp.success) {
						
						console.log(rsp.success)
							console.log(rsp.merchant_uid)	
						$("#receipt_merchant_uid").val(rsp.merchant_uid);					
						$("#receipt_imp_uid").val(rsp.merchant_uid);
						
						
						chk = true;
					} else {
						var msg = '결제에 실패했다 자식아';
						msg += '\n에러내용 : ' + rsp.error_msg;

						chk = false;
					}
					alert(msg);
					if(chk==true){
						
						alert("트리거 작동시작");
					
						$("#insertreceipt").trigger("click");	
					
					}
			}); 
		});
		
	} else {
		
	   //모바일인 경우 스크립트
		$("#check_module").click(function () {
			
			IMP.request_pay({
				pg: 'A010002002', // 자신이 설정한 pg사 설정
				pay_method: 'card',
				merchant_uid: 'merchant_' + new Date().getTime(),
				name: '주문명:결제테스트',
				amount: $("#amount").val(),				
				buyer_name: $("#unm").val() ,
				buyer_tel: $("#utel").val() ,
				buyer_addr: $("#uaddr").val() ,
			
				m_redirect_url: 'http://localhost:8090/payments/complete',
				}, function (rsp) {
					console.log(rsp);
			});
		});
		
	}


	//결제컨트롤러
	$("#insertreceipt").click(function () {
		
			
		console.log(cart_idarray)
		 $.ajax({
			 //red를 타고 싶다면 url을 paycomplete.do 으로 바꾸어라.
			url : "generalpaycomplete.do",
			  traditional : true,
			data : {"receipt_merchant_uid": $("#receipt_merchant_uid").val()
				,"receipt_paid_amount":$("#amount").val(),
				id:$("#unm").val(),cart_id:cart_idarray ,"user_code":$("#user_code").val()},
			method : "POST",
			success : function(val){
				
				
				if(val==1){
					//alert("결제가 완료 되었습니다. 메인 홈으로 이동합니다.")
				//	winodw.location.replace("/mainhome.jsp")	
				}else if(val ==-1){
					//결제후에 DB에 삽입중 주문 수량이 창고수량보다 큰경우 발동되는 결제 취소 아작스통신입니다.
					$.ajax({
						url:"cancelpay.do",
						type:"POST",
						data:{"receipt_merchant_uid":$("#receipt_merchant_uid").val()},
						success:(data)=>{
							if(data==1){
								alert("결제 취소 되었습니다 주문 수량이 창고수량보다 초과할 수 없습니다. 메인 홈으로 이동합니다.");
								winodw.location.replace("/mainhome.jsp");
							}
						}// 주문수량이 창고수량보다 큰 경우 결제취소 석세스 종료
					})
					
				}
				
			}//첫 석세스 함수 종료
		}); //첫 아작스 통신 종료
	});//클릭 종료
	
	
	
	
	
	
	
	$("#cancel_module_complete").click(function () {
		
		$.ajax({
			url : "/paycan.do",
			data : {"receipt_merchant_uid": $("#merchant_uid").val(),"receipt_buyer_id":$("#unm").val()},
			method : "POST",
			success : function(val){
				console.log(val);
				if(val==1){
					alert("취소 완료 밑 재고에반영됨 홈으로 이동합니다.");
					/* $("#all_module").trigger("click"); */
				}
				else alert("취소 실패\n이미 취소되었거나 잘못된 정보입니다.");
			},
			error :  function(request, status){
				alert("취소가 실패하였습니다.");
			}
		});
	});
	
	
	
	
	
	
	
	
	
	
	
	$("#cancel_module_complete").click(function () {
	
		$.ajax({
			url : "/paycan.do",
			data : {"receipt_merchant_uid": $("#merchant_uid").val(),"receipt_buyer_id":$("#unm").val()},
			method : "POST",
			success : function(val){
				console.log(val);
				if(val==1){
					alert("취소 완료 밑 재고에반영됨 홈으로 이동합니다.");
					/* $("#all_module").trigger("click"); */
				}
				else alert("취소 실패\n이미 취소되었거나 잘못된 정보입니다.");
			},
			error :  function(request, status){
				alert("취소가 실패하였습니다.");
			}
		});
	});
	
	
	
	//아작스는 나랑 동일한 도메인의 url만 요청가능! 즉 지금은 나의 서버쪽 url이다.
	//바로 아이폼트로 요청하는거 아님
	$(".myOrder_module").click(function(){	
		$.ajax({		
			url : "/payamount.do",
			                                              
			data : {"receipt_imp_uid":$("#receipt_imp_uid").val(),"receipt_buyer_addr":$("#receipt_buyer_addr").val(),"receipt_buyer_tel":$("#utel").val(),"receipt_buyer_id":$("#unm").val(),"receipt_merchant_uid": $("#merchant_uid").val(),"receipt_paid_amount": $("#salequantity").val(),"receipt_product_cod": $("#receipt_product_cod").val() ,"status" : $(this).attr("data-val")},
			
			
			// 파라미터 mid = 상점 주문번호 status=/paid
			method : "GET",//method 보단 type으로 적어 주는게 좋긴 하다.
	//	contentType : 'application/json; charset=UTF-8',
//	method : "POST",
			success : function(val){//리턴값 map을 받음
				console.log("아작스석세스 의 val값:"+val);
				$("#paylist").empty();
				if(val.msg!=null){
					$("#paylist").append(val.msg);
				}else{
					$("#paylist").append("고유ID: "+val.imp_uid);
					$("#paylist").append("<br>상점 거래ID: "+val.merchant_uid);
					$("#paylist").append("<br>주문상품: "+val.name);
					$("#paylist").append("<br>주문자: "+val.buyer_name);
					$("#paylist").append("<br>결제금액: "+val.amount);
				}
			},
			error :  function(request, status){
				alert("목록 가져오기를 할 수 없습니다.");
			}
		});
	});
	
	$("#all_module").click(function(){
		$.ajax({
			url : "/paylist",
			method : "GET",
// 			contentType : 'application/json; charset=UTF-8',
			success : function(val){
				console.log(val);
				$("#paylist").empty();
				$.each(val, function(i, v){
					$("#paylist").append("고유ID: "+v.imp_uid);
					$("#paylist").append("<br>상점 거래ID: "+v.merchant_uid);
					if(v.cancel_amount != 0 ) $("#paylist").append("<br><span style=\"color:red;font-weight:bold;\">주문취소</span>");
					else if(v.failed_at != 0 ) $("#paylist").append("<br><span style=\"color:pink;font-weight:bold;\">결제오류</span>");
					else $("#paylist").append("<br><span style=\"color:blue;font-weight:bold;\">결제완료</span>");
					$("#paylist").append("<br>주문상품: "+v.name);
					$("#paylist").append("<br>주문자: "+v.buyer_name);
					$("#paylist").append("<br>결제금액: "+v.amount+"<hr><br>");
				});
				
			},
			error :  function(request, status){
				alert("목록 가져오기를 할 수 없습니다.");
			}
		});
	});
	
	
	
	$("#replacetest").click(()=>{
		window.location.reload(true);
		
	})
	
});





function orderList(){
	let fm = document.fm;
	fm.action ="/pay";
	fm.method="post";
	fm.submit();
}

</script>




</head>
<body>

	<button id="replacetest">윈도우 리플레이스 테스트</button>

	<%
	String[] cart_id;
	%>
	<%
	String[] product_name = request.getParameterValues("product_name");
	String[] receipt_product_cod = request.getParameterValues("receipt_product_cod");
	String[] cart_quantity = request.getParameterValues("cart_quantity");
	String[] product_img = request.getParameterValues("product_img");
	cart_id = request.getParameterValues("cart_id");
	String user_code = request.getParameter("user_code");
	%>

	<%-- <%
	for (int k = 0; k < cart_id.length; k++) {
	%>
	<h1>
		각 카트아이디 번호는 :
		<%=cart_id[k]%></h1>
	<%
	}
	%>
	<h1>겨우 빼온 유저 코드는</h1>
	<%=user_code%> --%>


	<div class="allwrapper">
		<div class="headerarea">
			<div class="headerinfo">
				<h3>주문확인/결제</h3>
			</div>
		</div>
		<div class="bodyarea">
			<div class="bodytitle">
				<div class="leftarea">

					<div class="leftinfo">

						<%
						for (int x = 0; x < product_name.length; x++) {
						%>
						<div class="contents">
							<div class="col1">
								<img src=<%=product_img[x]%>>
							</div>


							<div class="col2">
								<h3>
									상품이름:<%=product_name[x]%></h3>
								<h3 class="product_cods" value="<%=receipt_product_cod[x]%>">
									상품코드:<%=receipt_product_cod[x]%></h3>
								<h3 class="cart_quantitys" value="<%=cart_quantity[x]%>">
									수량:<%=cart_quantity[x]%></h3>

							</div>
						</div>

						<%
						}
						%>



					</div>

				</div>
				<div class="rightarea">
					<div class="rightinfo">
						<!-- 새로운 컨트롤러 경로이다 다시 만들자.  -->

						<br>
						<h2>결제하기</h2>

						주문자아이디:<input type="text" name="id" id="unm"
							value=<%=session.getAttribute("userId")%>> <br>
						총지불금액:<input type="number" name="receipt_paid_amount" id="amount"
							value=<%=request.getParameter("finallsum")%>> <input
							type="hidden" name="receipt_merchant_uid"
							id="receipt_merchant_uid"> <input id="user_code"
							type="hidden" name="user_code"
							value="<%=request.getParameter("user_code")%>">
						<%
						for (int k = 0; k < cart_id.length; k++) {
						%>
						<input class="cart_id" type="hidden" value="<%=cart_id[k]%>">
						<%
						}
						%>


						<button id="check_module" type="button">결제하기</button>
						<button id="insertreceipt" type="button">컨트롤러</button>
						<button id="test">결제가 됬다는 가정하 테스트</button>

						<script>						
					$("#test").click(()=>{	
						let cart_quantity=cart_quantityArray;
						let product_cod=product_codArray;
						console.log(cart_quantity)
						console.log("클릭확인");
						
						//다날 카트결제 짜증 나서
						//테스트용 거래아이디 발급임
						let receipt_merchant_uid=Math.random().toString(36);
						
						/* 	console.log(cart_idarray) */
						 	 $.ajax({
								 //red를 타고 싶다면 url을 paycomplete.do 으로 바꾸어라.
								url : "generalpaycomplete.do",
								  traditional : true,
								data : {
									"receipt_merchant_uid": receipt_merchant_uid,
									"receipt_paid_amount":$("#amount").val(),
									//내 업보다... id 는 cart 컬럼의 id로 user 테이블을 참조하는 키이다.
									"id":$("#unm").val(),cart_id:cart_idarray ,
									"user_code":$("#user_code").val(),
									"cart_quantity":cart_quantity,
									"product_cod":product_cod
								},
								method : "POST",
								success : function(data){								
									
									
									console.log("결제 성공코드 1 이면 성공 -1 이면 에러로 자동 취소처리:  = "+data);
									if(data==1){
										//alert("결제가 완료 되었습니다. 메인 홈으로 이동합니다.")
										location.replace("mainhome.jsp")	
									}else if(data ==-1){
										//결제후에 DB에 삽입중 주문 수량이 창고수량보다 큰경우 발동되는 결제 취소 아작스통신입니다.
										// 또한 백엔드 상의 예기치 못한 예외로 인한 등등
										alert("결제 취소 되었습니다 주문 수량이 창고수량보다 초과할 수 없습니다. 메인 홈으로 이동합니다.");
										location.replace("mainhome.jsp");
										
									}
								}//석세스 종료
							
						 	 });//아작스 종료					
						
							
					})//클릭 종료
				
					
					</script>



						<%-- <form action="pay.do" method="post" name="fm">
							<br>
							<h2>결제하기</h2>

							주문자명:<input type="text" name="receipt_buyer_id" id="unm" value=<%=session.getAttribute("userId")%>> >
							<br>
							 <input type="text" name="receipt_buyer_tel" id="utel" placeholder="예시: 010-1111-2222">
							 <br>
							 <input type="text" name="uaddr" id="receipt_buyer_addr" placeholder="주소 입력">
							 <br>
							 상품코드<input type="text" name="receipt_product_cod" id="receipt_product_cod" value=<%=request.getParameter("receipt_product_cod")%>>
							 <br>

							지불금액<input type="number" name="receipt_paid_amount" id="amount" value=<%=request.getParameter("finallsum")%>><br>
							수량:<input type="text" name="salequantity" id="salequantity" value=<%=request.getParameter("salequantity")%>><br>
							<input type="hidden" name="receipt_imp_uid" id="receipt_imp_uid">
							<input type="hidden" name="receipt_merchant_uid" id="receipt_merchant_uid"> 
							<input type="hidden" name="receipt_imp_uid" id="receipt_imp_uid">
							<button id="check_module" type="button">결제하기</button>
							<button id="insertreceipt" type="submit" ></button>
							<br>
						</form>	 --%>
					</div>


				</div>
			</div>
		</div>
	</div>






	<%-- <form action="pay.do" method="post" name="fm">
		<div
			style="position: sticky; top: 0; left: 0; background-color: #fff; padding-bottom: 20px; border-bottom: 1px solid #000;">

			<br>
			<h2>결제하기</h2>

			주문자명:<input type="text" name="receipt_buyer_id" id="unm"
				value=<%=session.getAttribute("userId")%>> ><br> <input
				type="text" name="receipt_buyer_tel" id="utel"
				placeholder="예시: 010-1111-2222"><br> <input type="text"
				name="uaddr" id="receipt_buyer_addr" placeholder="주소 입력"><br>
			상품코드<input type="text" name="receipt_product_cod"
				id="receipt_product_cod"
				value=<%=request.getParameter("receipt_product_cod")%>><br>

			지불금액<input type="number" name="receipt_paid_amount" id="amount"
				value=<%=request.getParameter("finallsum")%>><br> 수량:<input
				type="text" name="salequantity" id="salequantity"
				value=<%=request.getParameter("salequantity")%>><br> <input
				type="hidden" name="receipt_imp_uid" id="receipt_imp_uid"> <input
				type="hidden" name="receipt_merchant_uid" id="receipt_merchant_uid">
			<input type="hidden" name="receipt_imp_uid" id="receipt_imp_uid">



			<button id="check_module" type="button">결제하기</button>
			<br>
			
			
			<hr>
			<!-- 여기서 부터는! API쓰는 거임  -->
			<h2>결제내역 관련</h2>
			merchant_uid: <input type="text" name="merchant_uid" id="merchant_uid" placeholder="merchant_uid 입력">
			<br>
		<!-- 	<!-- <button id="cancel_module" type="button">취소하기</button> -->
			<button class="myOrder_module" type="button" data-val="/paid">결제완료주문내역조회</button>
			<button class="myOrder_module" type="button" data-val="/cancelled">취소완료주문내역조회</button>
			<button id="all_module" type="button">모든목록조회</button> -->
		</div>

		<p id="paylist"></p>
	</form> --%>
	<hr>

	<!-- <h2>관리자 확정</h2>
	<button id="completequantity" type="button">재고사항 반영</button>
	<button id="cancel_module_complete" type="button">취소하기</button> -->





</body>
</html>