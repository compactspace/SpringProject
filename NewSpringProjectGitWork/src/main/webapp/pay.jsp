<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
var chk = false;
$(document).ready(function(){
	
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
				buyer_name: $("#unm").val() ,
				buyer_tel: $("#utel").val() ,
				buyer_addr: $("#uaddr").val() ,
				buyer_postcode: '123-456',
				}, function (rsp) {//아작스의 함수 success 비슷 rsp 는 성공 에러 다 받음 
					console.log("하씨발 결재 귀찮네 rsp.merchant_uid 는?");
					console.log(rsp.merchant_uid);
					console.log(JSON.stringify(rsp.merchant_uid));
					if (rsp.success) {
						var msg = '결제가 완료되었습니다.';
						msg += '\n고유ID : ' + rsp.imp_uid;
						msg += '\n상점 거래ID : ' + rsp.merchant_uid;
						msg += '\n결제 금액 : ' + rsp.paid_amount;
						msg += '\n카드 승인번호 : ' + rsp.apply_num;
						$("#receipt_imp_uid").val(receipt_imp_uid);
						$("#receipt_merchant_uid").val(receipt_merchant_uid);
						
					
						$("#receipt_imp_uid").val(rsp.merchant_uid)
						$("#merchant_uid").val(rsp.merchant_uid);
						chk = true;
					} else {
						var msg = '결제에 실패했다 자식아';
						msg += '\n에러내용 : ' + rsp.error_msg;

						chk = false;
					}
					alert(msg);
					if(chk==true){
						//전체리스트 조회
						//orderList();
						//내 주문목록 조회
						alert("트리거 직전");
						$(".myOrder_module").eq(0).trigger("click");
						alert("트리거 작동후");
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
	$("#cancel_module").click(function () {
		$.ajax({
			url : "/paycan.do",
			data : {"receipt_merchant_uid": $("#merchant_uid").val(),"receipt_buyer_id":$("#unm").val()},
			method : "POST",
			success : function(val){
				console.log(val);
				if(val==1){
					alert("취소 완료");
					$("#all_module").trigger("click");
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

	<form action="pay.do" method="post" name="fm">
		<div
			style="position: sticky; top: 0; left: 0; background-color: #fff; padding-bottom: 20px; border-bottom: 1px solid #000;">
			
			<br>
			<h2>결제하기</h2>			
	
			주문자명:<input type="text" name="receipt_buyer_id" id="unm" value=<%=session.getAttribute("userId") %>> ><br>
			<input type="text" name="receipt_buyer_tel" id="utel" placeholder="예시: 010-1111-2222"><br> 
		<input type="text" name="uaddr" id="receipt_buyer_addr" placeholder="주소 입력"><br>
		상품코드<input type="text" name="receipt_product_cod"
				id="receipt_product_cod"
				value=<%=request.getParameter("receipt_product_cod" )%>><br>
		
		지불금액<input type="number" name="receipt_paid_amount" id="amount" value=<%=request.getParameter("finallsum") %>><br>
		수량:<input type="text" name="salequantity" id="salequantity" value=<%=request.getParameter("salequantity") %> ><br>
		
			<input type="hidden" name="receipt_imp_uid" id="receipt_imp_uid" >
			<input type="hidden" name="receipt_merchant_uid" id="receipt_merchant_uid">
			<input type="hidden" name="receipt_imp_uid" id="receipt_imp_uid">
<%-- <c:choose>					
 <c:when test="${authnum eq null }">
 <button id="phonesms" type="button">결제전본인인증이먼저필요해요</button></c:when>
 <c:otherwise>
 <button id="check_module" type="button">결제하기</button>
 </c:otherwise>
</c:choose>
		 --%>
		 <button id="check_module" type="button">결제하기</button>
			<br>
			<hr>
<!-- 여기서 부터는! API쓰는 거임  -->
			 <h2>결제내역 관련</h2>
			merchant_uid: <input type="text" name="merchant_uid" id="merchant_uid" placeholder="merchant_uid 입력"><br>
			<!-- <button id="cancel_module" type="button">취소하기</button> -->
			<button class="myOrder_module" type="button" data-val="/paid">결제완료주문내역조회</button>
			<button class="myOrder_module" type="button" data-val="/cancelled">취소완료주문내역조회</button>
			<button id="all_module" type="button">모든목록조회</button>
		</div>

		<p id="paylist"></p> 
	</form>
	<hr>
	<h2>관리자 확정</h2>
<button id="completequantity" type="button">재고사항 반영</button>
<button id="cancel_module_complete" type="button">취소하기</button>





</body>
</html>