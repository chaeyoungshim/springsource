package com.study.calc;

/* 재귀호출
 재귀호출 : 메소드 안에서 자신의 메소드를 다시 호출
 		   기본단계와 재귀단계로 나뉨
 */

public class Recursion1 {
	public static void main(String[] args) {
		int num = 4;
		func(num);
	}
	public static void func(int n) {
		if(n > 0) { //재귀단계
			System.out.println("Hello");
			func(n-1); //이렇게만 하면 계속 무한 루프 돌게 됨
		}else { //기본단계
			return;
		}
	}
	
	
//	void countdown(int i) {
//		
//		if(i >= 0) {
//			// 기본단계
//			return;
//		}else {
//			// 재귀단계
//			countdown(i-1);
//		}
//	}
	
	
}
