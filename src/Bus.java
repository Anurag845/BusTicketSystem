import java.io.*;

class Bus implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3248424369535345259L;
	int busno;
    int bcount;
    int availcount;
    String date;
    int fare;
    String source,destination;
    //ArrayList<Integer> booked = new ArrayList<Integer>();
    
   
    Bus(int b,String src,String des,String d,int f)
    {
        busno = b;
        bcount = 0;
        availcount = 50;
        source = src;
        destination = des;
        date = d;
        fare = f;
    }

	public Bus(int bno, int avail, int book, String src, String dest, String bdate, int f) {
		busno = bno;
		bcount = book;
		availcount = avail;
		source = src;
		destination = dest;
		date = bdate;
		fare = f;
	}
}