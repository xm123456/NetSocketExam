package Exam2.Exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class CheckSocket extends Thread{
Socket socket;
public  CheckSocket(Socket s){
	this.socket=s;
}
public void out(String out){
	try {
		
		socket.getOutputStream().write(out.getBytes("UTF-8"));
	
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void run(){
	try{

	BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
    String line=null;
    while ((line=br.readLine())!=null) {
		ChatManager.getChatManager().publish(this, line);
	}
    br.close();
	}catch (UnsupportedEncodingException e){
		e.printStackTrace();
	}catch (IOException e){
		e.printStackTrace();
//	while (true) {
//		count++;
//		out("loop"+count);
//		try {
//			sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
    

}
	

}
