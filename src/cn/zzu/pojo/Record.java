package cn.zzu.pojo;

public class Record {

	private String Tid;
	private String Bid;
	private String Bname;
	private String Bauthor;
	private String Bpress;
	private float Bprice;
	private int pass;
	private int Syear;
	private String Smajor;
	private int checked;
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
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
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getSyear() {
		return Syear;
	}
	public void setSyear(int syear) {
		Syear = syear;
	}
	public String getSmajor() {
		return Smajor;
	}
	public void setSmajor(String smajor) {
		Smajor = smajor;
	}
	public Record() {
		super();
	}
	
}
