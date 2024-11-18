package com.spring.finall.user.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.finall.user.OneDayClassVO;
import com.spring.finall.user.ReviewVO;

@Repository
public class OneDayClassDAObatis {

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<OneDayClassVO> selectOneDayClass(OneDayClassVO vo) {

		return mybatis.selectList("OneDayClassVO.selectOneDayClass", vo);

	}

	public HashMap<String, Object> getReview(OneDayClassVO ovo) {
		System.out.println("스크립트에서 받은 nextepage: " + ovo.getNextpage() + "선택한클래스이름: " + ovo.getOnedayclass_name());

		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean endPageFlag;
		// 리절트 맵은 List 속에 OnedayvlassVO를 한개릴 집어 넣는다. 그리고 그 OnedayvlassVO 속에 List<Review>
		// 형태가 들어가있다.
		// 따라서 밑에서 to list형태로 따로 만들어와 빼온다.

		List<OneDayClassVO> list = mybatis.selectList("OneDayClassVO.getReview", ovo);
		System.out.println("트라이 캐치 통과");

		// 이거는 미리 다음번째 페이징을 한뒤 널이면 없음으로 프론트단에서 다음페이지 버튼 기능 자체를 끄는 기능이다.
		//오류예방 마지막  리미트절을 위한 단순 필드이다. 컬럼 아님!
		Integer preventNextPage=ovo.getNextpage()+4;
		List<OneDayClassVO> isEndpage=  mybatis.selectList("OneDayClassVO.isEndpage", ovo);
	
		// System.out.println("list-> "+list);

//		System.out.println(list);
//		System.out.println("-----------------------------------------------------");
//		System.out.println(list.get(0));
//
//		for (int k = 0; k < list.get(0).getReivewvo().size(); k++) {
//
//			System.out.println("후기: " + list.get(0).getReivewvo().get(k).getReview_comment());
//			System.out.println("작성일: " + list.get(0).getReivewvo().get(k).getReview_create_at());
//		}
//
//		System.out.println("-----------------------------------------------------");
//
//		OneDayClassVO oneday = list.get(0);
//
//		System.out.println("-----------------------------------------------------");
//		System.out.println("oneday-> " + oneday);
//		System.out.println("-----------------------------------------------------");

		
		//후기가 올라온 적이 없을시 널값을 대쳐하려고 만든 따로국밥 if 문
		int isFirstReview=list.size();		
		
		if(isFirstReview==0) {	
			//편의의상 클래스 이름은 넣어준다 프론트단에서 스타일 조건걸려고 하는거임 에효
			ovo.setOnedayclass_name(ovo.getOnedayclass_name());
			map.put("onedayclass", ovo);
			map.put("joinToReview", null);
			map.put("isEmpty", "isEmpty");	
			return map;
			
		}
		
		
		List<ReviewVO> reviewVo = list.get(0).getReivewvo();

		System.out.println("reviewVo-> " + reviewVo);

		
		// 그냥 마지막페이지 인지 검산용이다.
		if (isEndpage.size() == 0 || reviewVo.size() < 4) {
			endPageFlag = true;

			list.get(0).setEndPageFlag(endPageFlag);
		} else  {
			endPageFlag = false;
			list.get(0).setEndPageFlag(endPageFlag);

		}
		
		
		

		System.out.println("list.get(0)->" + list.get(0));

		// 뒤로 접기 기능은 없고 endPageFlag=false; 로 프론트단에서 호출기능 여부 자체를 막을것이라 이렇게 단순 페이징 4계산해도될듯
		if (ovo.getNextpage() == 0) {
			list.get(0).setNextpage(4);
		} else {
			list.get(0).setNextpage(4 + ovo.getNextpage());
		}

		// 리절트맵은(위 list) 사이즈가 1인 OnedayvlassVO를 가지고 있으며 그 OnedayvlassVO는 List형태의 필드
		// Review를 가지고 있어 데이터를 편히
		// 다루기 위해 List로 만든다.
		List<Object> joinToReview = ovo.toList(list.get(0), reviewVo.size());

		System.out.println("리턴 직전 마지막페이지 투루?");
		map.put("onedayclass", list.get(0));
		map.put("joinToReview", joinToReview);

		return map;
	}

}
