package com.javaex.ex02;

public class DigitThread extends Thread {
	
	@Override
	public void run() {
		
		for(char i = 0; i<=10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
