package Exam2.Exam2;
import java.util.Vector;
//4.使用 ServerSocket 建立聊天服务器-2
public class ChatManager {

	private ChatManager(){
		
	}
	private static final ChatManager cm=new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	Vector<CheckSocket>vector =new Vector<CheckSocket>();
	
	public void add(CheckSocket cs){
		vector.add(cs);
	}
	public void publish(CheckSocket cs,String out){
	 for (int i = 0; i < vector.size(); i++) {
		CheckSocket csCheckSocket=vector.get(i);
		if (!cs.equals(csCheckSocket)) {
			csCheckSocket.out(out);
		}
	}
}
}
