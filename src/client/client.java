package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	private static DataOutputStream toServer;
	private static DataInputStream fromServer;
 public static void main(String[] args){
	 System.out.println("请输入要传输的内容：");
	 Scanner input = new Scanner(System.in);
	 String s = input.nextLine();
	 //input.close();
	 //使用UDP方式进行网络通信
	 try {
		 DatagramSocket socket = new DatagramSocket(8004);
		 InetAddress serverAddress = InetAddress.getByName("169.254.242.24");
		 System.out.println("client:"+s);
		 //把传输内容分解成字节
		  byte data [] = s.getBytes(); 
		  //创建一个DatagramPacket对象，并指定要讲这个数据包发送到网络当中的哪个、地址，以及端口号
		  DatagramPacket packet = new DatagramPacket(data,data.length,serverAddress,8001);
		  //发送包
		  socket.send(packet);
	 }  catch (IOException e) {
			e.printStackTrace();
		}
//		Socket socket = new Socket("localhost", 8001);
//		fromServer = new DataInputStream(socket.getInputStream());
//		toServer = new DataOutputStream(socket.getOutputStream());
//	}  catch (IOException e) {
//		e.printStackTrace();
//	}
//			try {
//				toServer.writeUTF(s);
//				toServer.flush();
//				System.out.println("client:"+s);
//			} catch (IOException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
		}
 }

