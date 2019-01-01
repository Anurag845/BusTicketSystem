import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class MySQLJDBC {

        Connection cn = null;   
   
    public MySQLJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anurag?useSSL=false","root","dell");         
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateavail(int no,int tno,boolean flag) throws SQLException {
    	Statement st = cn.createStatement();
    	if(flag) {
    		st.executeUpdate("update Buses set avail = avail-"  + tno +", book = book+ " + tno +" where bno = "+no);
    	}
    	else {
    		st.executeUpdate("update Buses set avail = avail+"  + tno +", book = book- " + tno +" where bno = "+no);
    	}
    }
    
    public void removeBus(int no) throws SQLException {
    	Statement st = cn.createStatement();
    	st.executeUpdate("delete from Buses where bno=" + no);
    }
    
    public void removeCust(Customer c) throws SQLException {
		Statement st = cn.createStatement();
		st.executeUpdate("delete from Customers where busno = " + c.busno + " and bookno = " + c.bookno);
		
	}
   
    public void writeBus(Bus b) {
        try {
        	PreparedStatement st = cn.prepareStatement("insert into Buses values(?,?,?,?,?,?,?)");
            //st.executeUpdate("insert into Buses values(b.busno,b.availcount,b.bcount,'b.source','b.destination','b.date',b.fare");
        	st.setInt(1,b.busno);
        	st.setInt(2,b.availcount);
        	st.setInt(3,b.bcount);
        	st.setString(4,b.source);
        	st.setString(5,b.destination);
        	st.setString(6,b.date);
        	st.setInt(7,b.fare);
        	int i = st.executeUpdate();
        	System.out.println(i + " Buses Database Updated");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void writeCust(Customer c) throws SQLException {
    	PreparedStatement st = cn.prepareStatement("insert into Customers values(?,?,?,?,?)");
    	st.setInt(1,c.busno);
    	st.setInt(2,c.bookno);
    	st.setInt(3,c.age);
    	st.setString(4,c.name);
    	st.setInt(5,c.Aadhar);
    	int i = st.executeUpdate();
    	System.out.println(i + " Customers Database Updated");
    }
   
    public void read() {
        try {
        	Statement st = cn.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select * from Buses");
           
            while(rs.next()) {
                int bno = rs.getInt(1);
                int avail = rs.getInt(2);
                int book = rs.getInt(3);
                String  src = rs.getString(4);
                String dest = rs.getString(5);
                String bdate = rs.getString(6);
                int fare = rs.getInt(7);
               
                System.out.print("Bus no " + bno + "\t");
                System.out.print("Available " + avail + "\t");
                System.out.print("Booked " + book + "\t");
                System.out.print("Source " + src + "\t");
                System.out.print("Destination " + dest + "\t");
                System.out.print("Date " + bdate + "\t");
                System.out.println("Fare " + fare);
               
                Bus b = new Bus(bno,avail,book,src,dest,bdate,fare);
                Global.buses.add(b);
            }
            
            rs = st.executeQuery("select * from Customers");
    
            while(rs.next()) {
            	int bno = rs.getInt(1);
            	int book = rs.getInt(2);
            	int age = rs.getInt(3);
            	String name = rs.getString(4);
            	int ano = rs.getInt(5);
            	
            	Customer c = new Customer(bno,book,age,name,ano);
            	Global.passtick.put(c.bookno,c);
            	
            }
            
            rs = st.executeQuery("select max(bookno) from Customers");
            while(rs.next()) {
            	Global.count = rs.getInt(1);
            }
            
            rs = st.executeQuery("select * from Person");
            
            while(rs.next()) {
            	String username = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				long aadhar = rs.getLong(4);
				String designation = rs.getString(5);
				int id = rs.getInt(6);
				String email = rs.getString(7);
				Person p = new Person(username,password,name,aadhar,designation,id,email);
				Global.person.add(p);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

	public ArrayList<Object> login(String username, String password) {
		ArrayList<Object> values = new ArrayList<Object>();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from Person where username = '" + username + "' and password = '" + password + "'");
			
			while(rs.next()) {
				username = rs.getString(1);
				password = rs.getString(2);
				String name = rs.getString(3);
				long aadhar = rs.getLong(4);
				String designation = rs.getString(5);
				int id = rs.getInt(6);
				String email = rs.getString(7);
				values.add(designation);
				values.add(email);
				values.add(id);
				return values;
				//Global.person.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values.add("Not Found");
		return values;
	}

	public void signup(Person p) {
		try {
			PreparedStatement st = cn.prepareStatement("insert into Person values(?,?,?,?,?,?,?)");
			st.setString(1,p.username);
			st.setString(2,p.password);
			st.setString(3,p.name);
			st.setLong(4,p.aadhar);
			st.setString(5,p.designation);
			st.setInt(6,p.id);
			st.setString(7,p.emailid);
			int val = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}