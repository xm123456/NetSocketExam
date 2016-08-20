package Exam3.Exam3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new ReadByGet().start();
	}

	static class ReadByGet extends Thread{
    	public void run(){
    		try {

    			URL url=new URL("http://hq.sinajs.cn/list=sz300170");

			    URLConnection connection=url.openConnection();
			    InputStream is=connection.getInputStream();
    		    InputStreamReader isr=new InputStreamReader(is,"GBK");
    		    BufferedReader br=new BufferedReader(isr);
    		  
    		   
    		    String line;
    		    StringBuilder builder=new StringBuilder();
    		    while ((line=br.readLine())!=null) {
					builder.append(line);
			    	

				}
    		  
    		   
    		    br.close();
    		    isr.close();
    		    is.close();
    		    System.out.println(builder.toString());
    		} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
	}
}
