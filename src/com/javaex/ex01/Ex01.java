package com.javaex.ex01;

public class Ex01 {

	public static void main(String[] args) {
		
		/*
		for(char ch=65; ch<='Z'; ch++) { //A의 코드값은 65
			System.out.println(ch);
		}
		*/
			
		//출장가서 준비되는대로 시작(숫자 찍기)
		Thread thread = new DigitThread();
		thread.start();
		//thread.run(); **비교해 볼 것
		
		
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
		}

	}

}
