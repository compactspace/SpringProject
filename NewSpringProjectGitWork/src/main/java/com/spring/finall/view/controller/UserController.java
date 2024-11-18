package com.spring.finall.view.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.finall.security.SecurityUserVO;
import com.spring.finall.security.SecurityUserVOService;
import com.spring.finall.user.CartService;
import com.spring.finall.user.CartVO;
import com.spring.finall.user.MemberService;
import com.spring.finall.user.OneDayClassService;
import com.spring.finall.user.OneDayClassVO;
import com.spring.finall.user.OrderInfoService;
import com.spring.finall.user.OrderInfoVO;
import com.spring.finall.user.PayService;
import com.spring.finall.user.PayVO;
import com.spring.finall.user.ProductService;
import com.spring.finall.user.ProductVO;
import com.spring.finall.user.ReserveInfoVO;
import com.spring.finall.user.ReserveInfoVOService;
import com.spring.finall.user.ReserveRestVOService;
import com.spring.finall.user.ReserveService;
import com.spring.finall.user.ReserveVO;
import com.spring.finall.user.UserVO;
import com.spring.importutil.ImportUtil;
import com.spring.redisutil.RedisUtil;

@Aspect
@Controller
public class UserController {

	// REST API사용을 위한 인증(access_token취득)
	public static final String IMPORT_TOKEN_URL = "https://api.iamport.kr/users/getToken";

	// 결제 단건조회(고유 가맹점 주문번호 조회) API
	public static final String IMPORT_PAYMENTINFO_URL = "https://api.iamport.kr/payments/find/";

	// 결제상태기준 복수조회 API
	public static final String IMPORT_PAYMENTLIST_URL = "https://api.iamport.kr/payments/status/all";

	// 결제취소 API
	public static final String IMPORT_CANCEL_URL = "https://api.iamport.kr/payments/cancel";

	// payments.validation : 	ments확장기능. 결제될 내역에 대한 사전정보 등록&검증
	// POST /payments/prepare결제금액 사전등록 API
	public static final String IMPORT_PREPARE_URL = "https://api.iamport.kr/payments/prepare";

	// "아임포트 Rest Api key로 설정";
	public static final String KEY = "5813011072781514";
	// "아임포트 Rest Api Secret로 설정";
	public static final String SECRET = "VNRG31vl6jUe1vmlJjSiyrlVgy442Ft4tD9sSpwUdBwkV1lDTeFDubHI1z0Egycl6ZUnlmixdzIVw0kO";
	// "가맹점 식별코드 값으로 설정"
	public static final String IMPKEY = "imp77544746";

	boolean PASSWORDCHANGE;

	// 서비스호출위해 자동주입

	@Autowired
	private ImportUtil importutil;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RedisUtil redisutil;

	@Autowired
	private PayService payService;

	@Autowired
	private ReserveService reserveService;

	@Autowired
	private ReserveRestVOService reserveRestServie;

	@Autowired
	private ReserveInfoVOService reserveinfoService;

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService protService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private SecurityUserVOService SecurityUserVOService;

	@Autowired
	private OrderInfoService orderInfoService;

	@Autowired
	private OneDayClassService OneDayClassService;

	
	
	@RequestMapping(value = "/testResponseBody.do")
	@ResponseBody
	public String testResponseBody() {

		return "dd";

	}
	
	
	
	
	//비동기 통신은 모델엔뷰 안들리고 어디 들리는지 확인하는 영상
	@RequestMapping(value ="/ajaxtest.do")
	@ResponseBody
	public String ajaxtest() {
		
		return "옜다.";
	}
	
	

	
	@RequestMapping(value = "/insertreserve.do")
	@ResponseBody
	public String insertreserve(@RequestParam(value = "check", required = false) String checks, ReserveVO vo,
			HttpSession session, Model model) {

		// 그냥 안전 빵으로 세션이 없으면 돌아가도록 처리
		if (session.getAttribute("userId") == null) {

			return "needjoin";
		}

		if (reserveService.insertreserve(vo, checks) == false) {

			return "false";
		} else {

			model.addAttribute("insertreserve");
			return "true";
		}

	}
//
//	@RequestMapping(value = "/addcartnoneredis.do")
//	public String addcart(CartVO vo, Model model, HttpServletRequest req) {
//		
//	 boolean check=addredis(req);
//		
//		if(check) {
//			
//		}else {}
//		
//		
////		System.out.println("장바구니담기 수량->>" + req.getParameter("cart_quantity"));
//		cartService.addcart(vo);
//		// 컨트롤러 매핑시 넘어오는거
//		// CartVO 우선 필요한거 다 넘어옴
//		// name="product_cod" value="${p.product_cod}">
//		// name="product_name" value="${p.product_name}">
//		// name="product_name" value="${p.product_price}">
//		// name="cart_quantity" value="1">
//
//		return "productlist.do";
//
//	}

	



	
	@RequestMapping(value="/403", method={RequestMethod.GET,RequestMethod.POST})
	public String error403() {
		System.out.println("권하이 없다꼬요");
	    return "403";
	}
	
	
	
	
	
	
	
	// 일반 상품을 카트에 추가 하는 매핑
	// 특가 상품과는 다르게 오더 인포테이블은 여기서 건드리지 않을 것임
	@RequestMapping(value = "/generaladdcart.do")
	@ResponseBody
	public int generaladdcart(CartVO vo, HttpSession session, Model model, HttpServletRequest req,
			@Param("id") String id) throws UnsupportedEncodingException {

		int executerow = (Integer) cartService.generalproductlist(vo);

		return executerow;
	}

	// 레디스 특가상품 전용 카드
	@RequestMapping(value = "/addcart.do")
	@ResponseBody
	public String addcart(CartVO vo, OrderInfoVO ovo, HttpSession session, Model model, HttpServletRequest req,
			@Param("id") String id) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		// 먼저 레디스에 있는 클라인지 확인하자.
		String check = addredis(req);

		id = req.getParameter("id");

		if (check.equals("1")) {

			Integer cartid = (Integer) cartService.addcart(vo);
			ovo.setCart_id(cartid);
			ovo.setUser_code((Integer) session.getAttribute("user_code"));

			orderInfoService.insertorderinfo(ovo);

			return "1";
		} else if (check.equals("0")) {

			return "0";
		} else {
			return "-1";
		}

	}

	public String addredis(HttpServletRequest req) {
		redisutil.RedisAllSerializer();
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new StringRedisSerializer());
//		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		String checkid = req.getParameter("id");
		String checkpcode = req.getParameter("product_cod");
		HashMap<String, Object> dateMap = new HashMap<String, Object>();
		// key 명이 userInfo 이고, 가르키는게 HashMap 형태인 필드명 checkid 과 필드값 checkid 이다.
		String isAlreadyid = (String) redisTemplate.opsForHash().get("isExist", checkid);
		String isAlreadycode = (String) redisTemplate.opsForHash().get("isExist",
				"checkpcode" + checkid + req.getParameter("product_cod"));

		// 널포인트 익셉션 그냥 if로 처리하자.
		if (redisTemplate.opsForValue().get(checkpcode) == null) {
			return "0";
		}

		Integer isZero = Integer.parseInt((String) redisTemplate.opsForValue().get(checkpcode));

		if (isZero == 0) {

			return "0";

		} else {

			if (isAlreadyid == null || !isAlreadyid.equals(checkid)) {
				dateMap.put(checkid, checkid);
				dateMap.put("checkpcode" + checkid + req.getParameter("product_cod"), checkpcode);
				System.out.println("레디에 에 없는 값으로 생성");
				// redis에 Hash 형태로 삽입시는 다음 set 함수들 4개가 모두 필요하다.
				redisTemplate.opsForHash().putAll("isExist", dateMap);
				// decrement 함수는 redis 자료형이 숫자인 경우 key 명을 입력시 -1씩 감소시킨다.
				redisTemplate.opsForValue().decrement(req.getParameter("product_cod"));

				return "1";
			} else if (isAlreadycode == null || isAlreadyid.equals(checkid)) {
				System.out.println("isAlreadycode->>" + isAlreadycode);

				boolean checks = redisTemplate.opsForHash().hasKey("isExist",
						"checkpcode" + checkid + req.getParameter("product_cod"));

				if (checks) {
					System.out.println("레디스에 있는 값이니노생성");
					return "-1";
				} else {
					dateMap.put("checkpcode" + checkid + req.getParameter("product_cod"), checkpcode);
					redisTemplate.opsForHash().putAll("isExist", dateMap);
					redisTemplate.opsForValue().decrement(req.getParameter("product_cod"));

					return "1";
				}

			} else {

				System.out.println("레디스에 있는 값이니노생성");

				return "-1";
			}

		}

	}

	public boolean cancleredis(HttpServletRequest req) {

		// 나중 로그인자 아이디로 집어넣을시 주석을 해제하자.
		String checkid = req.getParameter("id");
//		String checkid = "Test";

		HashMap<String, Object> dateMap = new HashMap<String, Object>();
		dateMap.put(checkid, checkid);

		String test = (String) redisTemplate.opsForHash().get("userInfo", checkid);
		System.out.println("test=>>>" + test);

		if (test == null || !test.equals(checkid)) {
			System.out.println("레디에 에 없는 값으로 생성");

			redisTemplate.setKeySerializer(new StringRedisSerializer());
			redisTemplate.setValueSerializer(new StringRedisSerializer());
			redisTemplate.opsForHash().putAll("userInfo", dateMap);
			redisTemplate.opsForValue().decrement("2");

			return true;
		} else {

			System.out.println("레디스에 있는 값이니노생성");

			return false;
		}

		// 데이터 조회
//		String email = (String) redisTemplate.opsForHash().get("userInfo", "email");
//		String mobile = (String) redisTemplate.opsForHash().get("userInfo", "mobile");
//		

	}

	@RequestMapping(value = "/plusoneajaxaddcart.do")
	@ResponseBody
	public int plusoneajaxaddcart(CartVO vo, Model model, HttpServletRequest req) {
		vo.setId(req.getParameter("id"));
		vo.setProduct_cod(Integer.parseInt(req.getParameter("product_cods")));
		vo.setPlusone(Integer.parseInt(req.getParameter("plusone")));

		cartService.addcart(vo);
		int updateone = updateone(vo, model, req);

		return updateone;

	}

	public int updateone(CartVO vo, Model model, HttpServletRequest req) {

		System.out.println("req.getParameter(\"id\")->>>>>>>>>>>>>" + req.getParameter("id"));
		model.addAttribute("mycart", cartService.cartlist(vo));

		List<CartVO> listone = cartService.getupdateOne(vo);
		for (CartVO voc : listone) {
			System.out.println("voc->" + voc.getCart_quantity());
		}

		return listone.get(0).getCart_quantity();

	}

	// 일반 상품 카트 버리기
	@RequestMapping(value = "/dropgeneralcart.do")
	@ResponseBody
	public int dropcart(CartVO vo, HttpServletRequest req) {
		// ParameterValues 는 대략 배열로 여러개의 파라미터를 받는다.

		System.out.println("뭐가오나->" + req.getParameterValues("cart_idarry"));
		String[] cart_idarry = req.getParameterValues("cart_idarry");
		int executequery;
		try {
			for (int i = 0; i < cart_idarry.length; i++) {
				System.out.println("카트번호->" + cart_idarry[i]);
				vo.setCart_id(Integer.parseInt(cart_idarry[i]));
				cartService.dropgeneralcart(vo);

			}

			executequery = 1;
		} catch (Exception e) {
			executequery = -1;
		}

		return executequery;

	}

	@RequestMapping(value = "/dropcart.do")
	public String dropcart(CartVO vo, Model model, HttpServletRequest req) {
		// ParameterValues 는 대략 배열로 여러개의 파라미터를 받는다.

		System.out.println("뭐가오나->" + req.getParameterValues("product_cod"));
		String[] product_cods = req.getParameterValues("product_cod");

		vo.setId(req.getParameter("id"));

		// 장바구니비우기 클릭시
		// 장바구니 테이블 딜리트와, 레디스 재고량 일씩 증가해주는거임
		for (int i = 0; i < product_cods.length; i++) {
			System.out.println("뭐가오나->" + product_cods[i]);
			System.out.println("아이디옴?->" + req.getParameter("id"));
			System.out.println(">>->" + "checkpcode" + req.getParameter("id") + req.getParameter((product_cods[i])));
			System.out.println();
			vo.setProduct_cod(Integer.parseInt(product_cods[i]));
			cartService.dropcart(vo);
			redisTemplate.opsForValue().increment((product_cods[i]));
			redisTemplate.opsForHash().delete("isExist", "checkpcode" + req.getParameter("id") + (product_cods[i]));
		}

		return "/cartlist.do";

	}

//	// 하나씩 제거 카트
//	@RequestMapping(value = "/isZeor.do")
//	@ResponseBody
//	public String isZeor(CartVO vo, Model model, HttpServletRequest req) {
//		System.out.println("왜 내가 빈문자열이라!!->>" + req.getParameter("id"));
//		System.out.println("왜 내가 빈문코드야!!->>" + req.getParameter("product_cod"));
//		System.out.println("쿼리스트링으로도 커맨드 객체가 반응하나?->>" + vo.getId());
//
//		boolean check = cartService.isZeorcheck(vo);
//		if (check) {
//			return "worklist.jsp";
//		} else {
//			return "worklist.jsp";
//		}
//
//	}

	// redi 특가상품 상품수량 -1씩 해주는 매핑
	@RequestMapping(value = "/ajaxisZeor.do")
	@ResponseBody
	public boolean ajaxisZeor(CartVO vo, HttpServletRequest req) {

		redisutil.RedisAllSerializer();
		vo.setProduct_cod(Integer.parseInt(req.getParameter("product_cods")));

		boolean check = cartService.dropcart(vo);
		if (check) {
			String test = (String) redisTemplate.opsForHash().get("isExist", req.getParameter("id"));
			redisTemplate.opsForValue().increment(req.getParameter("product_cods"));
			String isAlreadycode = (String) redisTemplate.opsForHash().get("isExist",
					"checkpcode" + req.getParameter("id") + req.getParameter("product_cods"));

			System.out.println("isAlreadycode->>>" + isAlreadycode);

			redisTemplate.opsForHash().delete("isExist",
					"checkpcode" + req.getParameter("id") + req.getParameter("product_cods"));

			return true;
		} else {
			return false;
		}

	}

	// redis 테스트를 위해 잠시
	// return "cart.jsp"; 주석처리
	// salecart.jsp 는 수량한정 전용으로 수량 조절 기능 만 막아두었
	@RequestMapping(value = "/cartlist.do")
	public String cartlist(CartVO vo, Model model, HttpServletRequest req) {
		model.addAttribute("impKey", IMPKEY);
//		System.out.println("req.getParameter(\"id\")->>>>>>>>>>>>>" + req.getParameter("id"));
		model.addAttribute("mycart", cartService.cartlist(vo));

		List<CartVO> test = cartService.cartlist(vo);
		for (CartVO tes : test) {
			System.out.println("정보는->>" + tes.getCart_id());
		}

		// 컨트롤러 매핑시 넘어오는거
		// CartVO 우선 필요한거 다 넘어옴
		// name="product_cod" value="${p.product_cod}">
		// name="product_name" value="${p.product_name}">
		// name="product_name" value="${p.product_price}">
		// name="cart_quantity" value="1">

		System.out.println("장바구니비어있어요판단용 모델어티리뷰트값" + cartService.cartlist(vo).size());
		model.addAttribute("checkmycart", cartService.cartlist(vo).size());
		return "salecart.jsp";
//		return "cart.jsp";

	}

	// 일반 상품전용 카트
	@RequestMapping(value = "/generalcartlist.do")
	public String generalcartlist(CartVO vo, Model model, HttpServletRequest req) {
		model.addAttribute("impKey", IMPKEY);
		model.addAttribute("mycart", cartService.cartlist(vo));

		List<CartVO> test = cartService.generalcartlist(vo);
		for (CartVO tes : test) {
			System.out.println("카트아이디->>" + tes.getCart_id());
			System.out.println("카트아이디->>" + tes.getProduct_name());
			System.out.println("카트아이디->>" + tes.getCart_quantity());
		}

		System.out.println("장바구니비어있어요판단용 모델어티리뷰트값" + cartService.cartlist(vo).size());
		model.addAttribute("checkmycart", cartService.cartlist(vo).size());
		// return "salecart.jsp";
		return "cart.jsp";

	}

	// 일반 상품 장바구니에서 수량 + - 하는 함수
	@RequestMapping(value = "/plusminus.do")
	@ResponseBody
	public int plusminus(CartVO vo, Model model, HttpServletRequest req) {

		Integer executequery = cartService.plusminus(vo);
		return executequery;

	}

	@RequestMapping(value = "/pay.do", method = RequestMethod.GET)
	public String cartlist(@RequestParam(value = "finallsum", required = false) String finallsum, CartVO vo,
			Model model, HttpServletRequest req) {
		System.out.println("+req.getParameter(\"id\")->>>>>" + req.getParameter("id"));

//			req.setAttribute("finallsum", vo.setFinallsum(req.getParameter(finallsum)));
		model.addAttribute("pay", finallsum);
		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("impKey", IMPKEY);
		System.out.println("그냥 확인용");

		return "pay.jsp";

	}

	@RequestMapping(value = "/modalpay.do", method = RequestMethod.GET)
	@ResponseBody
	public List<String> modalcartlist(@RequestParam(value = "finallsum", required = false) String finallsum, CartVO vo,
			Model model, HttpServletRequest req) {
		System.out.println("+req.getParameter(\"id\")->>>>>" + req.getParameter("id"));

//			req.setAttribute("finallsum", vo.setFinallsum(req.getParameter(finallsum)));

		List<String> modalpayList = new ArrayList();
		modalpayList.add(0, finallsum);
		modalpayList.add(1, req.getParameter("id"));
		modalpayList.add(2, IMPKEY);

		/*
		 * model.addAttribute("pay", finallsum); model.addAttribute("id",
		 * req.getParameter("id")); model.addAttribute("impKey", IMPKEY);
		 */

		return modalpayList;

	}

	// 일반 상품 상품페이지로 최초 진입이나, 제품군 선택시 호출되는 메서드
	@RequestMapping(value = "/productlist.do")
	public String productGroupLlist(ProductVO vo, HttpServletRequest req, Model model) {
		
		String product_group = req.getParameter("product_group");
		if (product_group == null) {
			product_group = "pencile";
			vo.setProduct_group(product_group);
		} else if (product_group.equals("groupdetermined")) {
			product_group = "제품군미정";
			vo.setProduct_group(product_group);
		}

		System.out.println(" vo.getProduct_group 매핑 확인 " + vo.getProduct_group());
		// model.addAttribute("productService", protService.productlist(vo));

		List<ProductVO> grouplist = protService.productGroupLlist(vo);

		model.addAttribute("productService", grouplist);

		return "generalproductlist.jsp";

	}

	// 요건 정체불명메서드
	@RequestMapping(value = "/ajaxproductlist.do")
	public String ajaxProductlist(HttpServletRequest req, Model model) {

		String product_group = req.getParameter("product_group");
		// 게씨발 uri 쿼리스트링에 한글 되있으면 또 이상하게 깨짐.
		// 따라서 우선 영어로 받고 다시 한국어로 해준다.
		if (product_group.equals("groupdetermined")) {
			product_group = "제품군미정";
		}
		System.out.println("아작스  product_group 매핑 확인 " + product_group);

		List<ProductVO> grouplist = protService.ajaxproductlist(product_group);

		model.addAttribute("productService", grouplist);

		// return "productlist.jsp";
		return "generalproductlist.jsp";

	}

	// 회원가입전 이미 있는 아이디 인지 체그하는 아작스 호출
	@RequestMapping(value = "/checkid.do")
	@ResponseBody
	public boolean insertMembership(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {

		System.out.println("아작스매핑ㅎ롹린");
		boolean check = memberService.checkidMembership(vo);

		if (check) {
			// 확인함 리퀘스트 매핑 삭제시 리턴값을 전달도 못하고 오류남
			return check;
		} else {
			return check;
		}

	} // 회원가입전 이미 있는 아이디 인지 체그하는 아작스 호출 종료

	// 시큐리티 회원가입전 이미 있는 아이디 인지 체그하는 아작스 호출
	@RequestMapping(value = "/securitycheckid.do")
	@ResponseBody
	public boolean isduplicateId(SecurityUserVO vo, HttpSession session, HttpServletRequest req) throws Exception {

		int executerow = SecurityUserVOService.checkidMembership(vo);

		if (executerow <= 0) {
			// 확인함 리퀘스트 매핑 삭제시 리턴값을 전달도 못하고 오류남
			return true;
		} else {
			return false;
		}

		
		
		
	} // 회원가입전 이미 있는 아이디 인지 체그하는 아작스 호출 종료

	// 회원가입 시작! 바로위 아작스 처리후 주석 해제할것
	// 여기 url에서 새로고침하면 자꾸 데이터들어감 우찌 고치냐
	@RequestMapping(value = "/signup.do")
	@ResponseBody
	public String insertMembership(UserVO vo, HttpSession session) throws Exception {

		String password = BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt());
		vo.setPassword(password);
//		vo.setNaver_id("해당사이트에서가입");
		System.out.println(password);

		try {
			memberService.insertMembership(vo);
			return "signupsuccess";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("내가뜨면 아이디 유니크제약조건위배");
			return "signupfalse";
		}

//		return "login.jsp";

	}// 회원가입 종료

//바로 밑에 있는 로그인 시도 login 메소드를 도와주는  일반 메소드로
//아이디있는지 없는지 를 먼저 판별하게 해준다.
	public boolean isexistid(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {
		boolean check = memberService.checkidMembershiptwo(vo);
		if (check) {
			System.out.println("있는 아이디라면  isexistid 호출됨" + check);
			return check;
		} else {
			System.out.println("없는아이디" + check);
			return check;
		}

	}// 로그인 시 있는 아이디 인지 함수종료

	// 회원가입 시작! 바로위 아작스 처리후 주석 해제할것
	// 여기 url에서 새로고침하면 자꾸 데이터들어감 우찌 고치냐
	@RequestMapping(value = "/securitysignup.do")
	@ResponseBody
	public String signupsecurityMembership(SecurityUserVO vo, HttpSession session) throws Exception {

		String password = BCrypt.hashpw(vo.getUser_pwd(), BCrypt.gensalt());
		vo.setUser_pwd(password);
		System.out.println(password);
		// 현재 날짜 및 시간 가져오기
		Date currentDate = new Date();
		// 원하는 형식으로 날짜 및 시간 포맷팅
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		String formattedDateTime = dateFormat.format(currentDate);

		// 결과 출력
		System.out.println("현재 시각: " + formattedDateTime);
		vo.setUser_create(formattedDateTime);

		try {

			SecurityUserVOService.insertMembership(vo);
			// memberService.insertMembership(vo);
			return "signupsuccess";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("내가뜨면 아이디 유니크제약조건위배");
			return "signupfalse";
		}

//			return "login.jsp";

	}// 회원가입 종료

	@RequestMapping(value = "/loginpage.do")
	public String loginpage() {

		return "securityloginform.jsp";
	}

	// sql 인젝션 테스트 로그인시도시작
	@RequestMapping(value = "/sqlinjectlogin.do")
	public String sqlinjectlogin(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {

		System.out.println("받은 id " + req.getParameter("id"));
		System.out.println("받은 password " + req.getParameter("password"));

		if (isexistid(vo, session, req)) {

			// memberService.loginpasswordMembership(vo);

			// 여기서 sql 인잭션이 막히는듯???
			// boolean ispasswrodback = BCrypt.checkpw(vo.getPassword(),
			// memberService.loginpasswordMembership(vo));

			// sql 인젝션 테스트 위해 단순 함수만듬
			List<UserVO> executequry = memberService.injectionLogin(vo);

			System.out.println("pwd ?->>" + executequry);

			if (executequry != null) {

				Integer user_code = memberService.selectmainhomeuser_code(vo);

				if (vo != null) {
					vo.setUser_where("finalluser");
					session.setAttribute("userId", vo.getId());
					session.setAttribute("user_code", user_code);
					session.setAttribute("user_where", vo.getUser_where());
					System.out.println("vo.getUser_where()->>" + vo.getUser_where());

					return "mainhome.jsp";
				}

			} else {

				return "login.jsp";
			}
		}

		return "login.jsp";

	}// 로그인시도 종료

	// 로그인시도시작
	@RequestMapping(value = "/login.do")

	public String login(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {

		System.out.println("받은 id " + req.getParameter("id"));
		System.out.println("받은 password " + req.getParameter("password"));

		// System.getProperty 의 변수는 예약어인듯 하다 프로그램이 실행될때 뭔가 처리된
		// 아무 의미없는 값 집어 넣으면 널이 뜬다..
//	System.out.println("\n");

//		System.out.println("카탈리나" + System.getProperty("catalina.home"));
//		System.out.println("\n");
//		System.out.println("============= Propertie 전체 조회 ================");
//		Properties props = System.getProperties();
//		for (Object propKey : System.getProperties().keySet()) {
//			String key = (String) propKey;
//			String value = props.getProperty(key);
//			System.out.println(key + "=" + value);
//		}
//
//		System.getProperties();

		if (isexistid(vo, session, req)) {
			// memberService.loginpasswordMembership(vo);

			// 여기서 sql 인잭션이 막히는듯???
			boolean ispasswrodback = BCrypt.checkpw(vo.getPassword(), memberService.loginpasswordMembership(vo));

			System.out.println("ispasswrodback ?->>" + ispasswrodback);

			if (ispasswrodback) {

				Integer user_code = memberService.selectmainhomeuser_code(vo);

				if (vo != null) {
					vo.setUser_where("finalluser");
					session.setAttribute("userId", vo.getId());
					session.setAttribute("user_code", user_code);
					session.setAttribute("user_where", vo.getUser_where());
					System.out.println("vo.getUser_where()->>" + vo.getUser_where());

					return "mainhome.jsp";
				}

			} else {

				return "login.jsp";
			}
		}

		return "login.jsp";

	}// 로그인시도 종료

//  개인정보수정중  원래비밀번호먼저확인하기 아작스
	@RequestMapping(value = "/checkpassword.do")
	@ResponseBody
	public boolean changepassword(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {
		System.out.println("id를못끌고오나 el로" + req.getParameter("id"));

		if (isexistid(vo, session, req)) {
			memberService.loginpasswordMembership(vo);

			boolean checkpassword = BCrypt.checkpw(vo.getPassword(), memberService.loginpasswordMembership(vo));
			System.out.println("ispasswrodback->>>>>>>>>>" + checkpassword);
			if (checkpassword) {
				System.out.println("이프문 참");
				return checkpassword;

			} else {
				System.out.println("엘스문 펠스");
				return checkpassword;
			}
		}
		System.out.println("이프나엘스문도안타 펠스");
		return false;
	}// 개인정보수정중 원래비밀번호먼저확인하기 아작스 종료

	// 비밀번호 변경 아작스 !
	// 네임값도 겹치니 그냥 아작스로 처리
	@RequestMapping(value = "/changepassword.do")
	@ResponseBody
	public boolean changepasswordcomplete(UserVO vo, HttpServletResponse response, HttpSession session,
			HttpServletRequest req) throws Exception {
		String afterpassword = vo.getAfterpassword();
		System.out.println("암호화전 afterpassword->>>>" + afterpassword);
		// 비밀번호 + salt로 암호화된 비밀번호 생성
		afterpassword = BCrypt.hashpw(afterpassword, BCrypt.gensalt());
		// vo.setPassword(memberService.loginpasswordMembership(vo));
		System.out.println("암호화후->>" + afterpassword);

		vo.setAfterpassword(afterpassword);
		int check = memberService.changepasswordcomplete(vo);

		if (check == 1) {
			// 당연히 비번을 변경했으니 기존 세션연결을 해지한다.
			session.setAttribute("userId", null);
			PASSWORDCHANGE = true;
			return PASSWORDCHANGE;
		} else {
			PASSWORDCHANGE = false;
			return PASSWORDCHANGE;
		}

	}

//	// 네이버로그인후 네이버로그인으로 가입된 회원인미 먼저 확인하는 메소드
//	@RequestMapping(value = "/navercheckid.do")
//	public String naverMembershipCheck(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {
//
//		System.out.println("네이버컨트롤로에서 디스페쳐로  일로 발급받은 아이디가  와졌니?" + req.getAttribute("id"));
//		String id = (String) req.getAttribute("id");
//		vo.setId(id);
//
//		boolean check = memberService.checkidMembership(vo);
//		System.out.println("사전검사 아이디가 투루라면 가입가능 하고 if문 타고 아니라면 펠스로 else문탐" + check);
//		if (check) {
//			return "/insertNaverMembership.do?id=" + id;
//
//		} else {
//			System.out.println("사전검사 아이디가 팰스라면 바로 로그인시켜버려" + check);
//
//			return "/naverlogin.do?id=" + id;
//		}
//
//	} // 네이버로그인 후 이미 가입된 회원인지 함수 종료

//	// 네이버로그인후 자동 회원가입시도함수
//	@RequestMapping(value = "/insertNaverMembership.do")
//	public String insertNaverMembership(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {
////네이버 가입자는 패스워드 필요없어서 지움
//		System.out.println("req id->>" + req.getParameter("id"));
//		String id = req.getParameter("id");
//		System.out.println("id를 못가져오나" + vo.getId());
//		vo.setUser_where("naveruser");
//		vo.setNaver_id("네이버이용자");
//		vo.setUser_name("미기입");
//		vo.setPassword("불필요");
//		try {
//			memberService.insertMembership(vo);
//			return "/naverlogin.do?id=" + id;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("내가 뜨면 프라이머리키 위배로 데이터삽입 오류");
//		}
//
//		return "/naverlogin.do";
//
//	}// 네이버로그인후 회원가입 종료

//	// 네이버가입자 로그인시도시작
//	@RequestMapping(value = "/naverlogin.do")
//	public String naverlogin(UserVO vo, HttpSession session, HttpServletRequest req) throws Exception {
//
//		session.setAttribute("userId", vo.getId());
//		System.out.println("네이버로그인자는 세션어트리뷰트가지금 널임?" + vo.getId());
//		return "worklist.jsp";
//
//	}// 네이버가입자 로그인시도 종료

	// 로그아웃시도
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:mainhome.jsp";
	}

	@RequestMapping(value = "/restOneDayClass.do")
	@ResponseBody
	public Integer restOneDayClass(HttpServletRequest req) throws Exception {
		String onedayclass_num = req.getParameter("onedayclass_num");
		String openday = req.getParameter("openday");

		if (onedayclass_num == null || openday == null) {

			return -1;
		}

		int check = reserveRestServie.restOneDayClass(req);

		if (check > 0) {

			return check;
		} else {

			return 0;
		}

	}

	@RequestMapping(value = "/selectOneDayClass.do")
	@ResponseBody
	public List<OneDayClassVO> selectOneDayClass(OneDayClassVO vo, HttpServletResponse response, HttpSession session,
			HttpServletRequest req) throws Exception {

		List<OneDayClassVO> onedayselect = OneDayClassService.selectOneDayClass(vo);
		System.out.println("onedayselect->>>" + onedayselect);
		return onedayselect;

	}

	@RequestMapping(value = "/onedayclasssubmit.do")
	public String onedayclasssubmit(OneDayClassVO vo, Model model, HttpServletRequest req) throws Exception {

		List<OneDayClassVO> onedayselect = OneDayClassService.selectOneDayClass(vo);
		model.addAttribute("firstonedayclass", onedayselect);

		for (OneDayClassVO rseult : onedayselect) {
			System.out.println("클래스 고유번호  " + rseult.getOnedayclass_num());
			System.out.println("클래스 이름  " + rseult.getOnedayclass_name());
		}

		return "onedayclasssubmit.jsp";

	}

	@RequestMapping(value = "/insertreserveinfo.do")
	@ResponseBody
	public String insertreserveinfo(ReserveInfoVO vo, HttpServletRequest req, HttpSession session, Model model) {

		System.out.println("매핑 및 변수확인");
		System.out.println("거래아이디" + req.getParameter("merchant_uid"));
		System.out.println("클래스번호" + req.getParameter("onedayclass_num"));
		System.out.println("유저코드" + req.getParameter("user_code"));
		System.out.println("나머지수" + req.getParameter("rest"));

		// 그냥 안전 빵으로 세션이 없으면 돌아가도록 처리
		if (session.getAttribute("user_code") == null) {

			return "needjoin";
		}
		boolean check = reserveinfoService.insertreserveinfo(vo);

		if (check) {

			return "true";
		} else {

			reserveRestServie.reserverestupdate(req);

			return "false";
		}

	}

	@RequestMapping(value = "/checkreserveinfo.do")
	@ResponseBody
	public String insertreserve2(ReserveInfoVO vo, HttpServletRequest req, HttpSession session, Model model) {

		if (session.getAttribute("user_code") == null) {

			return "needjoin";
		}
		boolean check = reserveinfoService.checkreserveinfo(vo);

		if (check) {

			return "true";
		} else {

			return "false";
		}

	}

	@RequestMapping(value = "/myreserveinfo.do")
	public String myreserveinfo(HttpServletRequest req, Model model, HttpSession session) {

		List<Object> result = reserveinfoService.myreserveinfo(req);

		model.addAttribute("myreserveinfo", result);
		session.setAttribute("empty", result);

		return "myreserveinfo.jsp";

	}

	// 결제현황
	// 카카오 성님들도 해당 주문 번호에대한 부분 수량 취소따윈 없다하니
	// 각 주문번호마다 여러개으 상품을 환불 처리하기 위해
	// 주문번허도 심어야 한다..! 퍽
	@RequestMapping(value = "/mypayinfo.do")
	public String mypayinfo(PayVO pvo, Model model, HttpSession session) {

		// 결제 가맹점번호는 잠시 하드코딩처리
		pvo.setReceipt_merchant_uid("sdff");

		List<PayVO> mypayinfo = payService.showpaylist(pvo);

		model.addAttribute("mypayinfo", mypayinfo);
		session.setAttribute("empty", mypayinfo);

		return "mypayinfo.jsp";

	}

	// 단건 결제 상세조회 현황 및 취소
	// 카카오 성님들도 해당 주문 번호에대한 부분 수량 취소따윈 없다하니
	// 각 주문번호마다 여러개으 상품을 환불 처리하기 위해
	// 주문번허도 심어야 한다..! 퍽
	@RequestMapping(value = "/mypaydetailinfo.do")
	public String mypaydetailinfo(UserVO uvo, PayVO pvo, Model model, HttpServletRequest req, HttpSession session) {

		List<PayVO> mypaydetailinfo = payService.mypaydetailinfo(uvo, pvo);

		model.addAttribute("mypaydetailinfo", mypaydetailinfo);
		String status = req.getParameter("status");
		if (status.equals("cancel")) {
			model.addAttribute("iscancelinfo", "cancelinfo");
		} else if (status.equals("pay")) {
			model.addAttribute("iscancelinfo", "payinfo");
		}

		session.setAttribute("empty", mypaydetailinfo);

		return "mypaydetailinfo.jsp";

	}

	// 나의 개인정보를 보는 메서드
	@RequestMapping(value = "/mypersonalinfo.do")
	public String mypersonalinfo(UserVO uvo, Model model) {

		// 자료 형태가 길이가1 인 리스트 속에 UserVO 를 때려 박은거라 프론트에서 출력이 힘듬 살짝 가공하자. 에휴
		List<Object> myinfolist = memberService.mypersonalinfo(uvo);

		model.addAttribute("myinfolist", myinfolist);

		return "myinfo.jsp";

	}
	//테스트용 으로 지금 주문번호를 자바스크립트로 생성하고 있으니 아레 로직은 당연히 환불실패임 잠시 주석처리한다.
	//따라서 테스트 중이라면 바로밑에 있는
	//@RequestMapping(value = "/testcallcancelapi.do") 으로 가라
	@RequestMapping(value = "/callcancelapi.do")
	@ResponseBody
	public String callcancelapi(HttpServletRequest req, Model model) throws IOException {

		String merchant_uid = req.getParameter("merchant_uid");
		// 이제 여기서 취소 api를 호출해야 한다.
		// 1.토큰을 발급받자.
		// => 자바는 외부로 요청을 하려면
		// => HttpClient client = HttpClientBuilder 만들고
		// => 요청의 Post도 만들고
		// => 요청시 데이터 꼴도 만들어준다.
		String token = importutil.getImportToken();
		System.out.println("발급받은 토큰 확인" + token);
		
		
		// 2.발급받은 토큰으로 이제 취소 api를 호출해보자.
		String resultpay = importutil.cancelPayment(token, merchant_uid);

		if (resultpay.equals("1")) {
			// UPDATE reserverest rest=10 WHERE onedayclass_num=? AND openday=?
			reserveRestServie.reserverestpaycancelupdate(req);
			reserveinfoService.paystatusupdate(req);

			return "1";

		} else {
			// 결제에 실패했다고 로직 추가해주기
			return "-1";

		}

	}
	
	//테스트용 으로 지금 주문번호를 결제시에 자바스크립트로 생성하였고, 그걸 db에 넣는 중이다.
	// 따라서 우선 if else문을 단순히 null 기준으로 한다.
	@RequestMapping(value = "/testcallcancelapi.do")
	@ResponseBody
	public String testcallcancelapi(HttpServletRequest req, Model model) throws IOException {

		String merchant_uid = req.getParameter("merchant_uid");
	

		if (merchant_uid!=null) {
			// UPDATE reserverest rest=10 WHERE onedayclass_num=? AND openday=?
			reserveRestServie.reserverestpaycancelupdate(req);
			reserveinfoService.paystatusupdate(req);

			return "1";

		} else {
			// 결제에 실패했다고 로직 추가해주기
			return "-1";

		}

	}
	
	
	
	
	
	
	
	

}
