package com.spring.finall.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.finall.CustomException.PayRunTimeTranException;
import com.spring.finall.user.ProductService;
import com.spring.finall.user.ProductVO;
@Service("productservice")
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	private ProductDAOMybatis productdao; 

	@Override
	public List<ProductVO> productlist(ProductVO vo) {		
		
		
		return productdao.productlist(vo);
	}
	
	
	//일반 상품 최초 링크를 타거나 제품군 선택시 호출되는 메서드
		public  List<ProductVO> productGroupLlist (ProductVO vo){
			
			return productdao.productGroupLlist(vo);
		}
	
	
	
	@Override
	public List<ProductVO> ajaxproductlist(String product_group) {
		
		return productdao.ajaxproductlist(product_group);
	}
	
	@Override
	public  int updateOrderQuantity(int cart_quantity, int product_cod) throws PayRunTimeTranException {
		
		return 	productdao.updateOrderQuantity(cart_quantity, product_cod);
		
		
	}
	
	
	
	
	@Override
public int completequantity(HashMap<String, ArrayList<Object>> map){	
		
		
		return productdao.completequantity(map);
	}

	
	
	
	
	

}
