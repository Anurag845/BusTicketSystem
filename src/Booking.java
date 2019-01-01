import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

class Booking {
	
	public ArrayList<Object> login(ObjectInputStream ois,ObjectOutputStream oos) {
		ArrayList<Object> values = null;
		try {
			String username;
			username = (String)ois.readObject();
			String password = (String)ois.readObject();
			MySQLJDBC jdbc = new MySQLJDBC();
			values = jdbc.login(username,password);
			if(values.size() == 1) {
				oos.writeObject(0);
				oos.writeObject("Username or password incorrect");
			}
			else if(values.get(0).equals("admin")) {
				oos.writeObject(1);
				oos.writeObject("Log in successful");
			}
			else if(values.get(0).equals("user")) {
				oos.writeObject(2);
				oos.writeObject("Log in successful");
			}
			return values;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return values;
	}

	public void signup(ObjectInputStream ois,ObjectOutputStream oos) {
		try {
		String name = (String)ois.readObject();
		long Aadhar = (long)ois.readObject();
		String username = (String)ois.readObject();
		String password = (String)ois.readObject();
		String designation = (String)ois.readObject();
		String email = (String)ois.readObject();
		int id = Global.person.size() + 1;
		Person p = new Person(username,password,name,Aadhar,designation,id,email);
		Global.person.add(p);
		MySQLJDBC jdbc = new MySQLJDBC();
		jdbc.signup(p);
		oos.writeObject("Sign Up successful");
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public void addbus(ObjectInputStream ois,ObjectOutputStream oos) {
		try {
			Bus b = (Bus)ois.readObject();
			b.busno = Global.buses.size() + 1;
			for(Bus bus : Global.buses) {
				if(b.source.equals(bus.source) && b.destination.equals(bus.destination) && b.date.equals(bus.date)) {
					oos.writeObject("Bus from " + b.source + " to " + b.destination + " already exists");
					return;
				}
				if(b.busno == bus.busno) {
					b.busno++;
				}
			}
        	Global.buses.add(b);
        	oos.writeObject("Bus added successfully");
        	MySQLJDBC jdbc = new MySQLJDBC();
            jdbc.writeBus(b);
		}
		catch(Exception i) {
			System.out.println(i);
		}
    }
 
    public void cancelbus(ObjectInputStream ois,ObjectOutputStream oos) {
		try {
        	MySQLJDBC jdbc = new MySQLJDBC();
        	       	
        	int no = (int) ois.readObject();
        	boolean flag = false;
        	Iterator<Bus> it = Global.buses.iterator();
            Bus bus = null;
        	for(Bus b : Global.buses) {
        	    if(b.busno == no) {
        	        bus = b;
        	        jdbc.removeBus(no);
        	        flag = true;
        	        break;
        	    }
        	}
        	Global.buses.remove(bus);
        	if(flag) {
        		oos.writeObject("Bus cancelled successfully");
        	}
        	else {
        		oos.writeObject("Bus no incorrect");
        	}
        	oos.writeObject(Global.buses);
		}
		catch(IOException | ClassNotFoundException | SQLException i) {
			System.out.println(i);
		}
    }

    public void showbuses(ObjectOutputStream oos) {
		try {
			oos.writeObject(Global.buses.size());
    	    for(Bus b : Global.buses) {
    	    	//dos.writeUTF("Bus no " + b.busno + "\nDate " + b.date + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n" + "Fare " + b.fare + "\n");
    	    	oos.writeObject(b);
    	    }
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }
 
    public void checkbus(ObjectInputStream ois,ObjectOutputStream oos) {
        //Scanner sc = new Scanner(System.in);
		try {
    	    int bno = (int)ois.readObject();
    	    String businfo;
    	    for(Bus b : Global.buses) {
    	        if(b.busno == bno) {
    	            businfo = "Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n";
    	            businfo += "Booking number" + " " + "Name" + "\t" + "Aadhar" + "\t" + "Age" + "\n";
                	for(int bookno : Global.passtick.keySet()) {
                    	Customer c = Global.passtick.get(bookno);
                    	if(c.busno==bno) {
                    		businfo += c.bookno + "\t" + c.name + "\t" + c.Aadhar + "\t" + c.age + "\n";
                    	}
                	}
                	oos.writeObject(businfo);
                	return;
            	}
        	}
    	    oos.writeObject("Bus does not exist");
		}
		catch(IOException i) {
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void senddata(ObjectOutputStream oos) {
    	try {
			oos.writeObject(Global.buses);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public synchronized void bookticket(ObjectInputStream ois,ObjectOutputStream oos,ArrayList<Object> values) {
    	System.out.println("Inside book method");
    	try {
        	int no = (int) ois.readObject();
        	
        	for(Bus b : Global.buses) {        		
        	    if(b.busno == no) {        	        
        	    	int tno = (int) ois.readObject();
        	        if(tno <= b.availcount) {
        	        	System.out.println("no detected");
        	        	Customer c1,c2,c3,c4;
        	        	
        	        	MySQLJDBC jdbc = new MySQLJDBC();
        	        	switch(tno) {
        	        	case 1: Global.buses.remove(b);
        	        			c1 = (Customer) ois.readObject();
        	        			Global.count++;        	        			
        	        			b.bcount++;
        	        			b.availcount--;
        	        			Global.buses.add(b);
        	        			c1.bookno = Global.count;        	        			
        	        			oos.writeObject(c1.bookno);
        	        			jdbc.writeCust(c1);
        	        			Global.passtick.put(c1.bookno,c1);
            	                jdbc.updateavail(no,1,true);
            	                break;
        	        	case 2: Global.buses.remove(b);
        	        			c1 = (Customer) ois.readObject();
        	        			Global.count++;
	        					b.bcount++;
	        					b.availcount--;
	        					c1.bookno = Global.count;
	        					oos.writeObject(c1.bookno);
	        					jdbc.writeCust(c1);
	        					Global.passtick.put(c1.bookno,c1);
	        					c2 = (Customer) ois.readObject();
	        					Global.count++;
	        					b.bcount++;	
	        					b.availcount--;
	        					Global.buses.add(b);
	        					c2.bookno = Global.count;
	        					oos.writeObject(c2.bookno);
	        					jdbc.writeCust(c2);
	        					Global.passtick.put(c2.bookno,c2);
	        					jdbc.updateavail(no,2,true);
	        					break;
        	        	case 3: Global.buses.remove(b);
        	        			c1 = (Customer) ois.readObject();
        	        			Global.count++;
    							b.bcount++;
    							b.availcount--;
    							c1.bookno = Global.count;
    							oos.writeObject(c1.bookno);
    							Global.passtick.put(c1.bookno,c1);
    							jdbc.writeCust(c1);
    							c2 = (Customer) ois.readObject();
    							b.bcount++;
    							b.availcount--;
    							Global.count++;
    							c2.bookno = Global.count;
    							oos.writeObject(c2.bookno);    							
    							Global.passtick.put(c2.bookno,c2);
    							jdbc.writeCust(c2);
    							c3 = (Customer) ois.readObject();
    							Global.count++;
    							b.bcount++;
    							b.availcount--;
    							Global.buses.add(b);
    							Global.count++;
    							c3.bookno = Global.count;
    							oos.writeObject(c3.bookno);    							
    							Global.passtick.put(c3.bookno,c3);
    							jdbc.writeCust(c3);
    							jdbc.updateavail(no,3,true);
    							break;
        	        	case 4: Global.buses.remove(b);
        	        			c1 = (Customer) ois.readObject();
    							b.bcount++;
    							b.availcount--;
    							Global.count++;
    							c1.bookno = Global.count;
    							oos.writeObject(c1.bookno);    							
    							Global.passtick.put(c1.bookno,c1);
    							jdbc.writeCust(c1);
    							c2 = (Customer) ois.readObject();
    							b.bcount++;
    							b.availcount--;
    							Global.count++;
    							c2.bookno = Global.count;
    							oos.writeObject(c2.bookno);    							
    							Global.passtick.put(c2.bookno,c2);
    							jdbc.writeCust(c2);
    							c3 = (Customer) ois.readObject();
    							b.bcount++;
    							b.availcount--;
    							Global.count++;
    							c3.bookno = Global.count;
    							oos.writeObject(c3.bookno);    							
    							Global.passtick.put(c3.bookno,c3);
    							jdbc.writeCust(c3);
    							c4 = (Customer) ois.readObject();
    							b.bcount++;
    							b.availcount--;
    							Global.buses.add(b);
    							Global.count++;
    							c4.bookno = Global.count;
    							oos.writeObject(c4.bookno);    							
    							Global.passtick.put(c4.bookno,c4);
    							jdbc.writeCust(c4);
    							jdbc.updateavail(no,4,true);
    							break;
        	        	}
        	        	oos.writeObject("Booking successful");
        	        }
        	        else {
        	        	oos.writeObject("Tickets not available");
        	        }
        	    }
        	}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    		e.printStackTrace();
    	}
		}
    

    public synchronized void cancelticket(ObjectInputStream ois,ObjectOutputStream oos) {
		try {
			int no = (int)ois.readObject();
        	for(Bus b : Global.buses) {
        	    if(b.busno == no) {        	      
        			int tno = (int)ois.readObject();
        			System.out.println(tno);
        	        if(tno <= b.bcount) {
        	        	int bookno,ano;
        	        	MySQLJDBC jdbc = new MySQLJDBC();
        	            for(int i = 0; i < tno ; i++) {
        	            	bookno = (int)ois.readObject();
        	            	System.out.println(bookno);
        	                if(Global.passtick.containsKey(bookno)) {
        	                	Customer c = Global.passtick.get(bookno);
        	                	ano = (int)ois.readObject();
        	                	System.out.println("c.aadhar " + c.Aadhar + " ano " + ano);
        	                	
        	                	if(c.Aadhar == ano) {
        	                		Global.passtick.remove(bookno);
        	                		oos.writeObject("Ticket with bookno " +bookno + " cancelled");
        	                		Global.buses.remove(b);
        	                		b.availcount +=1;
        	                		Global.buses.add(b);
        	                		jdbc.removeCust(c);
        	                		jdbc.updateavail(b.busno,tno,false);
        	                	}
        	                	else {
        	                		oos.writeObject("Booking number " + bookno + " does not match Aadhar number");
        	                	}
        	                }
        	                else {
        	                    	oos.writeObject("Booking number "+ bookno + " does not exist");
        	                }
        	            }
        	        }
        	        else {
        	            oos.writeObject(tno + " tickets haven't been booked yet");        	            
        	        }
        	    }
        	}
		}
		catch(IOException | SQLException | ClassNotFoundException i) {
			System.out.println(i);
		}	
    }
    
    public void getdata() {
    	try {
    		FileInputStream fis = new FileInputStream("Buses.txt");
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		while(true) {
    			try {
    				Bus b = (Bus)ois.readObject();
    				Global.buses.add(b);
    			}
    			catch(EOFException e) {
    				break;
    			}
    		}
    		ois.close();
    		fis.close();
    	}
    	catch(Exception e) {
    		
    	}
    }
    
    public void updatedata() {
    	try {
    		FileOutputStream fos = new FileOutputStream("Buses.txt");
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		
    		if(Global.buses.size() > 0) {
    			for(Bus b : Global.buses) {
    				oos.writeObject(b);
    			}
    		}
    		fos.close();
    		oos.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }      
}