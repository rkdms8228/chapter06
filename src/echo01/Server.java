package echo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.8", 10001));
		
		System.out.println("<서버 시작>");
		System.out.println("=========================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8"); //번역
		BufferedReader br = new BufferedReader(isr); //가속
		
		
		//메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os,  "UTF-8"); //번역
		BufferedWriter bw = new BufferedWriter(osw);
		
	
		while(true) { //메세지를 계속 주고받기 위해 반복문
			
			//메세지 받기
			String msg = br.readLine();
			
			if(msg == null) {
				break;
			}

			System.out.println("받은 메세지: "+msg);
			
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush(); //강제 보냄(일정 칸 수가 차지 않으면 전송이 되지 않지만 강제로 전송하게끔 하는 것)
			
		}
		
		
		System.out.println("=========================");
		System.out.println("<서버 종료>");
		
		
		br.close();
		socket.close();
		serverSocket.close();

	}

}
