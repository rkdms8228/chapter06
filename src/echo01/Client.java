package echo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=========================");

		
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.45.93", 10001));
		
		
		System.out.println("[서버에 연결되었습니다.]");
		
		//메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); //번역
		BufferedWriter bw = new BufferedWriter(osw);
		
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8"); //번역
		BufferedReader br = new BufferedReader(isr);
		
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		
		while(true) { //메세지를 계속 주고받기 위해 반복문
			
			//키보드 입력
			String str = sc.nextLine();
			
			if(str.equals("/q")) {
				break;
			}
			
			//메세지 보내기
			bw.write(str);
			bw.newLine();
			bw.flush(); //강제 보냄(일정 칸 수가 차지 않으면 전송이 되지 않지만 강제로 전송하게끔 하는 것)
			
			
			//메세지 받기
			String reMsg = br.readLine();
			System.out.println("server: ["+reMsg+"]");
			
			}

		
		System.out.println("=========================");
		System.out.println("<클라이언트 종료>");
		
		
		sc.close();
		br.close();
		bw.close();
		socket.close();

	}

}
