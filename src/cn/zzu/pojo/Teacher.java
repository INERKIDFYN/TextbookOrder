package cn.zzu.pojo;

public class Teacher extends User{

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
	public Teacher(String tid, String tpassword, String tname, String tcollege,
			String tphonenumber) {
		super(tid,tpassword,tname);
		Tcollege = tcollege;
		Tphonenumber = tphonenumber;
	}
	public Teacher() {
		super();
	}
	
}
