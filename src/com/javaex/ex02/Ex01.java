package com.javaex.ex02;

import com.javaex.ex01.DigitThread;

public class Ex01 {

	public static void main(String[] args) {
		
		Thread thread1 = new DigitThread();
		Thread thread2 = new LowerThread();
		Thread thread3 = new UpperThread();
		
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
