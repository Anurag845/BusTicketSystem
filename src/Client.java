import java.net.*;
import java.io.*;
import java.util.*;

class Client{

	public static void main(String[] args){
		
		try{
		Socket s = new Socket("localhost",3000);

		System.out.println("\nCONNECTED TO SERVER\n");
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		Scanner in = new Scanner(System.in);

		String msg,input;
		while(true){
			msg = dis.readUTF();
			System.out.println(msg);
			if(msg.indexOf("Enter") >=0){
				input= in.next();
				dos.writeUTF(input);
			}
		}
		/*do
		{
			msg = dis.readUTF();
			System.out.println(msg);
			input= in.next();
			dos.writeUTF(input);
		}while(input!="2");*/
	
		}
		catch(Exception e){}
	
	}
}

