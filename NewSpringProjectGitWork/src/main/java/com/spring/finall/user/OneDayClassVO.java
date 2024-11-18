package com.spring.finall.user;

import java.util.ArrayList;
import java.util.List;

public class OneDayClassVO {

	private String onedayclass_name;
	private int onedayclass_price;
	private String onedayclass_info;
	private String reserve_img;
	private Integer onedayclass_num;
	
	
	//그냥 리미트절을 위한 단순 필드이다. 컬럼 아님!
	private Integer nextpage;
	
	//오류예방 마지막  리미트절을 위한 단순 필드이다. 컬럼 아님!
	private Integer preventNextPage;
	
	
	//그냥 마지막 페이지인지 확인하는 단순 필드이다 컬럼 아님!.
	private boolean endPageFlag;
	
	
	
	
	
	public Integer getPreventNextPage() {
		return preventNextPage;
	}

	public void setPreventNextPage(Integer preventNextPage) {
		this.preventNextPage = preventNextPage;
	}

	public boolean isEndPageFlag() {
		return endPageFlag;
	}

	public void setEndPageFlag(boolean endPageFlag) {
		this.endPageFlag = endPageFlag;
	}

	//조인용 ReivewVO 클래스이다.
	private List<ReviewVO> reivewvo;
	
	
	
	
	
	public Integer getNextpage() {
		return nextpage;
	}

	public void setNextpage(Integer nextpage) {
		this.nextpage = nextpage;
	}




	public List<Object> toList(OneDayClassVO ovo,int size) {
		
		List<Object> list = new ArrayList();
		for(int k=0; k<size; k++ ) {
			list.add(ovo.getReivewvo().get(k));
		}
		
		System.out.println("-------------투리스트 리턴 직전----");
		System.out.println(list);
		System.out.println("-------------투리스트 리턴 종료----");
		return list;
	}

	


	public Integer getOnedayclass_num() {
		return onedayclass_num;
	}

	public List<ReviewVO> getReivewvo() {
		return reivewvo;
	}

	public void setReivewvo(List<ReviewVO> reivewvo) {
		this.reivewvo = reivewvo;
	}

	public void setOnedayclass_num(Integer onedayclass_num) {
		this.onedayclass_num = onedayclass_num;
	}

	public String getReserve_img() {
		return reserve_img;
	}

	public void setReserve_img(String reserve_img) {
		this.reserve_img = reserve_img;
	}

	public String getOnedayclass_name() {
		return onedayclass_name;
	}

	public void setOnedayclass_name(String onedayclass_name) {
		this.onedayclass_name = onedayclass_name;
	}

	public int getOnedayclass_price() {
		return onedayclass_price;
	}

	public void setOnedayclass_price(int onedayclass_price) {
		this.onedayclass_price = onedayclass_price;
	}

	public String getOnedayclass_info() {
		return onedayclass_info;
	}

	public void setOnedayclass_info(String onedayclass_info) {
		this.onedayclass_info = onedayclass_info;
	}

}
