package cn.zzu.pojo;

public class Student {

	private String Sid;
	private String Spassword;
	private String Sname;
	private int Syear;
	private String Scollege;
	private String Smajor;
	private String Sclass;
	public String getSid() {
		return Sid;
	}
	public void setSid(String sid) {
		Sid = sid;
	}
	public String getSpassword() {
		return Spassword;
	}
	public void setSpassword(String spassword) {
		Spassword = spassword;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getSyear() {
		return Syear;
	}
	public void setSyear(int syear) {
		Syear = syear;
	}
	public String getScollege() {
		return Scollege;
	}
	public void setScollege(String scollege) {
		Scollege = scollege;
	}
	public String getSmajor() {
		return Smajor;
	}
	public void setSmajor(String smajor) {
		Smajor = smajor;
	}
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		Sclass = sclass;
	}
	public Student(String sid, String spassword, String sname, int syear,
			String scollege, String smajor, String sclass) {
		super();
		Sid = sid;
		Spassword = spassword;
		Sname = sname;
		Syear = syear;
		Scollege = scollege;
		Smajor = smajor;
		Sclass = sclass;
	}
	public Student() {
		super();
	}
	
}
