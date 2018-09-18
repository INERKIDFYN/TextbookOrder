package cn.zzu.pojo;

public class Teacher{

	private String Tid;
	private String Tname;
	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	private String Tpassword;
	private String Tcollege;
	private String Tphonenumber;
	
	public String getTcollege() {
		return Tcollege;
	}
	public void setTcollege(String tcollege) {
		Tcollege = tcollege;
	}
	public String getTphonenumber() {
		return Tphonenumber;
	}
	public void setTphonenumber(String tphonenumber) {
		Tphonenumber = tphonenumber;
	}
	public Teacher() {
		super();
	}
	
}
