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
	 System.out.println("������Ҫ��������ݣ�");
	 Scanner input = new Scanner(System.in);
	 String s = input.nextLine();
	 //input.close();
	 //ʹ��UDP��ʽ��������ͨ��
	 try {
		 DatagramSocket socket = new DatagramSocket(8004);
		 InetAddress serverAddress = InetAddress.getByName("169.254.242.24");
		 System.out.println("client:"+s);
		 //�Ѵ������ݷֽ���ֽ�
		  byte data [] = s.getBytes(); 
		  //����һ��DatagramPacket���󣬲�ָ��Ҫ��������ݰ����͵����統�е��ĸ�����ַ���Լ��˿ں�
		  DatagramPacket packet = new DatagramPacket(data,data.length,serverAddress,8001);
		  //���Ͱ�
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
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
		}
 }

