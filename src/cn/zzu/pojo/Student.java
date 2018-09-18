package cn.zzu.pojo;

public class Student{

	private String Sid;
	private String Sname;
	private String Spassword;
	public String getSid() {
		return Sid;
	}
	public void setSid(String sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSpassword() {
		return Spassword;
	}
	public void setSpassword(String spassword) {
		Spassword = spassword;
	}
	private int Syear;
	private String Scollege;
	private String Smajor;
	private String Sclass;
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
	public Student() {
		super();
	}
	
}
