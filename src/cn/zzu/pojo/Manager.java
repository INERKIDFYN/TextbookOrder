package cn.zzu.pojo;

public class Manager{
	private String Mid;
	private String Mname;
	private String Mpassword;
	public String getMid() {
		return Mid;
	}
	public void setMid(String mid) {
		Mid = mid;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public String getMpassword() {
		return Mpassword;
	}
	public void setMpassword(String mpassword) {
		Mpassword = mpassword;
	}
	private String Mphonenumber;
	public String getMphonenumber() {
		return Mphonenumber;
	}
	public void setMphonenumber(String mphonenumber) {
		Mphonenumber = mphonenumber;
	}
	public Manager() {
		super();
	}
	
}
