package cn.zzu.pojo;

public class Teacher {

	private String Tid;
	private String Tpassword;
	private String Tname;
	private String Tcollege;
	private String Tphonenumber;
	public String getTid() {
		return Tid;
	}
	public void setTid(String tid) {
		Tid = tid;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
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
	public Teacher(String tid, String tpassword, String tname, String tcollege,
			String tphonenumber) {
		super();
		Tid = tid;
		Tpassword = tpassword;
		Tname = tname;
		Tcollege = tcollege;
		Tphonenumber = tphonenumber;
	}
	public Teacher() {
		super();
	}
	
}
