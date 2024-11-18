package com.spring.finall.transaction;



//그냥 연습용으로 데이터베이스 테이블을 하나만들자.
//create table transaction (num int);

//그리고 sql 메퍼에도 추가하자.
public class TransactionVO {
	
	public int num;
	

	public void setNum(int num) {
		this.num= num;
	}
	
	public int getNum() {
		 return  this.num;
	}
	
	

}
