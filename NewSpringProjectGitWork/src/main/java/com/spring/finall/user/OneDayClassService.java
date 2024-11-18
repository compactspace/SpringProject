package com.spring.finall.user;

import java.util.HashMap;
import java.util.List;

public interface OneDayClassService {
	
	public abstract List<OneDayClassVO> selectOneDayClass(OneDayClassVO vo);

	public abstract HashMap<String,Object> getReview(OneDayClassVO ovo);
}
