package com.spring.finall.view.controller;


import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.finall.apiutile.NaverApiUtile;
import com.spring.finall.user.MemberService;
import com.spring.finall.user.UserVO;

@Controller
public class ApiController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private NaverApiUtile naverapiutile;

	private String clientId = "oIB_pADeJKcErdJaXoqA";// 애플리케이션 클라이언트 아이디값";
	private String ClientSecret = "xhm_mwBHDx";
	@SuppressWarnings("deprecation")
	// 네이버 로그인후 바로 회원정보 조회 API를 호출하게 되는 콜백URI
	private String redirectURI = URLEncoder.encode("http://localhost:8090/finall/isExistId.do");
	SecureRandom random = new SecureRandom();
	private String state = new BigInteger(130, random).toString();
	// 네이버 로그인창이 뜬뒤 헤더속 redirectURI 을 본다. 그다음 개발자가 정한 콜백유알엘과 일치 하는지 보고 콜백유알앨로 응답을
	// 준다잉
	private String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code" + "&client_id=" + clientId
			+ "&redirect_uri=" + redirectURI + "&state=" + state;
	// 사용자 정보를 주는 네이버 api url 이다.
	private String infoURL = "https://openapi.naver.com/v1/nid/me";

	// 팩트 체그 리스펀스 바디 지우면 오류남, 그런데
	@RequestMapping(value = "/naverloginform.do")
	@ResponseBody
	public void isalreadyid(UserVO vo, HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		res.sendRedirect(apiURL);
	}

	
	

	
	
	
	
	
	// 네이버 로그인후 api 에서 주는 url에 담긴 파라미터도 req.getParameter("code") 로 가져올 수있다! 제일중요
	@RequestMapping(value = "/isExistId.do")
	public void isExistId(UserVO vo, HttpServletRequest req, HttpServletResponse response)
			throws Exception {

		// 네이버 로그인후 얻은 코드로 토큰을 발급는 url
		String gettokenapiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&" + "client_id="
				+ clientId + "&client_secret=" + ClientSecret + "&code=" + req.getParameter("code") + "&state="
				+ req.getParameter("state");

	

		// 주의: 지금은 톰캣이 손님이다 즉 톰캣이 네이버로 부터 토큰을 받는거다.
		String token = naverapiutile.getNaverApiToken(gettokenapiURL);

		if (token.equals("faile")) {
			throw new Exception("클라이언트 아이디 또는 시크릿키가 잘못된것 같습니다.");

		}
		
		// 아오 "Bearer " 이렇게 공백=스페이스바 한칸 추가 해야 인식하네
				String header = "Bearer " + token;
				// System.out.println("header 가 널이 아니길->>"+header);
				
				Map<String, String> requestHeaders = new HashMap<>();
				requestHeaders.put("Authorization", header);

			;
		
		

		String navermembershipinfo = naverapiutile.getNaverMemberInfo(infoURL,requestHeaders);
		System.out.println("컨트롤러속 빌더로부터 받은 네이버 정보: "+navermembershipinfo);		
		
		if (navermembershipinfo == null) {
			throw new Exception("클라이언트 정보를 가져오지 못한 에러 입니다.");
		}

		// 이제 네이버로부터 회원의 정보를 받아왔는데 그 정보로 이미 기존 톰캣사이트의 회원가입이 되어있는지 판단하고
		
		//포워딩 처리로 한다.
		req.setAttribute("navermembershipinfo", navermembershipinfo);
		RequestDispatcher rds = req.getRequestDispatcher("/isAlreadyTomcatMember.do");
		rds.forward(req, response);
	}

	
	
	//이제 받은 유저의 정보를 자바 가가 알아 먹을수있는 json형태로 변환시켜 네이버가 제공한 json형태의 유저 정보를 빼온뒤 DB에 접속하여 가이입시키던지 기회원이면 로그인시키던지 하는 메서드
	@RequestMapping(value = "/isAlreadyTomcatMember.do")
	public String isAlreadyTomcatMember(UserVO vo, HttpServletRequest req, HttpSession session) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String navermembershipinfo= (String)req.getAttribute("navermembershipinfo");
		try {

			JsonNode nodeNaverMemberShipInfo = mapper.readTree(navermembershipinfo);
			System.out.println("---------------nodeNaverMemberShipInfo 시작------------");
			System.out.println(nodeNaverMemberShipInfo);
			System.out.println("---------------nodeNaverMemberShipInfo 종료------------");
			
			
			// {"resultcode":"00","message":"success","response":{"id":"rQE_RsS0i5F8jxIgoh88swhDV1UZerijF96octiN2aM","nickname":"입실론극혐","profile_image":"https://ssl.pstatic.net/static/pwe/address/img_profile.png","age":"30-39","gender":"M","email":"younggoo7000@naver.com","mobile":"010-9313-0686","mobile_e164":"+821093130686","name":"신원찬","birthday":"11-05","birthyear":"1991"}}
			// System.out.println( nodeNaverMemberShipInfo);
			
			//주의해라 위 출력 결과에서 response key 가 다시 또 제이슨 형태이므로 아래처럼 데이터를 다시 뽑아야한다. 
			JsonNode noderesponse = nodeNaverMemberShipInfo.get("response");
			JsonNode nodeid =noderesponse.get("id");
			String strid = mapper.writeValueAsString(nodeid);
			JsonNode nodemobile = noderesponse.get("mobile");
			String strmobile = mapper.writeValueAsString(nodemobile);
			JsonNode nodename = noderesponse.get("name");
			String strname = mapper.writeValueAsString(nodename);

			
			String id=strid.replaceAll("\"", "");
			String mobile=strmobile.replaceAll("\"", "");
			String name=strname.replaceAll("\"", "");
			
			System.out.println("nodeid: "+nodeid+"nodemobile: "+nodemobile+"nodename: "+nodename);
			System.out.println("id: "+id+"mobile: "+mobile+"name: "+name);
			
			//어머나 현재 값에 "" 가 붙어 있어서 아오 제거 해주어야 한다.	
			
			vo.setId(id);
			vo.setUser_tell(mobile);
			vo.setUser_name(name);
			vo.setPassword("불필요");
			vo.setUser_where("naveruser");

			// 이제 네이버의 정보로 톰캣사이트에서 가입한 이력이 있는지 조회한다.
			boolean check = memberService.checkidMembership(vo);

			// 즉 가입한적 없으니 가입 시킨다.
			if (check) {
				try {
					memberService.insertMembership(vo);
					Integer user_code = memberService.selectusercode(vo);
					session.setAttribute("userId", id);
					session.setAttribute("user_code", user_code);
					return "/mainhome.jsp";

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("내가 뜨면 프라이머리키 위배로 데이터삽입 오류");
					req.setAttribute("err", "err");
					return "/login.jsp";
				}
			}else {
				Integer user_code = memberService.selectusercode(vo);
				session.setAttribute("userId", vo.getId());
				session.setAttribute("user_code", user_code);
				return "/mainhome.jsp";
			}			
			

		} catch (JsonProcessingException e) {
			
			throw new Exception("json데이터 가공중 에러 발생:"+ e);

		}	

	}


	
//이녀석은 솔직히 아직 필요없음
//	List<NameValuePair> convertParameter(Map<String, String> paramMap) {
//
//		System.out.println("paramMap: " + paramMap.toString());
//
//		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
//		Set<Entry<String, String>> entries = paramMap.entrySet();
//		/*
//		 * Set Interface -> 순서X 중복X     Set 인터페이스는 중복 요소를 포함할 수 없으며 랜덤 액세스를 허용하지않아
//		 * iterator 또는 foreach를 이용하여 요소를 탐색할 수 있다. 현재 내용이 어렵지
//		 * 
//		 */
//		for (Entry<String, String> entry : entries) {
//			paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//		}
//		System.out.println("paramList: " + paramList);
//		return paramList;
//	}



}
