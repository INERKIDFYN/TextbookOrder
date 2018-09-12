package cn.zzu.pojo;

public class Book {

	private String Bid;
	private String Bname;
	private String Bauthor;
	private String Bpress;
	private float Bprice;
	private int Bcurnum;
	public String getBid() {
		return Bid;
	}
	public void setBid(String bid) {
		Bid = bid;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBauthor() {
		return Bauthor;
	}
	public void setBauthor(String bauthor) {
		Bauthor = bauthor;
	}
	public String getBpress() {
		return Bpress;
	}
	public void setBpress(String bpress) {
		Bpress = bpress;
	}
	public float getBprice() {
		return Bprice;
	}
	public void setBprice(float bprice) {
		Bprice = bprice;
	}
	public int getBcurnum() {
		return Bcurnum;
	}
	public void setBcurnum(int bcurnum) {
		Bcurnum = bcurnum;
	}
	public Book() {
		super();
	}
	public Book(String bid, String bname, String bauthor, String bpress,
			float bprice, int bcurnum) {
		super();
		Bid = bid;
		Bname = bname;
		Bauthor = bauthor;
		Bpress = bpress;
		Bprice = bprice;
		Bcurnum = bcurnum;
	}
	
}
