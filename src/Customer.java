import java.io.*;

class Customer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1175169679709396186L;
	int age;
    String name;
    int Aadhar;
    int busno;
    int bookno;
    
    Customer(int busno,int bookno,int age,String name,int Aadhar) {
    	this.busno = busno;
    	this.bookno = bookno;
        this.age = age;
        this.name = name;
        this.Aadhar = Aadhar;
    }

	Customer(int busno, String name, int Aadhar, int age) {
		this.busno = busno;
		this.bookno = 0;
        this.age = age;
        this.name = name;
        this.Aadhar = Aadhar;
	}
	
	Customer(int busno, int Aadhar, int age) {
		this.busno = busno;
		this.bookno = 0;
        this.age = age;
        this.name = "default";
        this.Aadhar = Aadhar;
	}
}