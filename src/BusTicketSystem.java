import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.*;

class BusTicketSystem {
	public static void main(String[] args) throws IOException 
    {
    	//Booking bk = new Booking();
    	
    	//bk.getdata();
		
		MySQLJDBC mysqljdbc = new MySQLJDBC();
		mysqljdbc.read();
    	
        ServerSocket ss = new ServerSocket(3000);
         
        // running infinite loop for getting
        // client request
        while (true) 
        {
            Socket s = null;
             
            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();
                 
                System.out.println("A new client is connected : " + s);
                 
                // obtaining input and out streams
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                //DataInputStream dis = new DataInputStream(s.getInputStream());
                //DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                 
                System.out.println("Assigning new thread for this client");
 
                // create a new thread object
                Thread t = new ClientHandler(s,ois,oos);
 
                // Invoking the start() method
                t.start();
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
	final ObjectInputStream ois;
    final ObjectOutputStream oos;
    
    final Socket s;
    // Constructor
    public ClientHandler(Socket s, ObjectInputStream ois, ObjectOutputStream oos) 
    {
        this.s = s;
        this.ois = ois;
        this.oos = oos;
        //this.dos = dos;
    }
 
    
	@Override
    public void run() {
		
		Booking bk = new Booking();
		
		try {

			System.out.println("Customer connected");
			ArrayList<Object> values = new ArrayList<Object>();
        	while(true) {
          	        int choice = (int) ois.readObject();
        	        switch(choice) {
        	            case 1: bk.addbus(ois,oos);
        	                break;
        	            case 2: bk.cancelbus(ois,oos);
        	                break;
        	            case 3: bk.showbuses(oos);
        	                break;
        	            case 4: bk.showbuses(oos);
        	                break;
        	            case 5: bk.bookticket(ois,oos,values);
        	                break;
        	            case 6: bk.cancelticket(ois,oos);
        	                break;
        	            case 7: bk.checkbus(ois,oos);
    	                    break;
        	            case 8: values = bk.login(ois,oos);
        	            	break;
        	            case 9: bk.signup(ois,oos);
        	            	break;
        	            case 10: bk.senddata(oos);
        	            	break;
        	        }
        	}
        	
		}
		catch(IOException | ClassNotFoundException i) {
			System.out.println(i);
		}
    }
}
