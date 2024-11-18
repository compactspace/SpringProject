package com.spring.finall.javasyntax;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime {

	public static void main(String[] args) {
		  // 현재 날짜 및 시간 가져오기
        Date currentDate = new Date();

        // 원하는 형식으로 날짜 및 시간 포맷팅
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        
        String formattedDateTime = dateFormat.format(currentDate);

        // 결과 출력
        System.out.println("현재 시각: " + formattedDateTime);

	}

}
