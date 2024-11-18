package com.spring.finall.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ProductService {
	
	//이 메서드는 대기 정체불명
	public abstract List<ProductVO> productlist(ProductVO vo);
	
	//일반 상품 최초 링크를 타거나 제품군 선택시 호출되는 메서드
	public abstract List<ProductVO> productGroupLlist (ProductVO vo);
	
	public abstract List<ProductVO> ajaxproductlist(String product_group);

public  abstract int completequantity(HashMap<String, ArrayList<Object>> map);
	
public abstract int updateOrderQuantity(int cart_quantity, int product_cod);


}
