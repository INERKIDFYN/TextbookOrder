package cn.zzu.pojo;

public class Manager {

	private String Mid;
	private String Mpassword;
	private String Mname;
	private String Mphonenumber;
	public String getMid() {
		return Mid;
	}
	public void setMid(String mid) {
		Mid = mid;
	}
	public String getMpassword() {
		return Mpassword;
	}
	public void setMpassword(String mpassword) {
		Mpassword = mpassword;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public String getMphonenumber() {
		return Mphonenumber;
	}
	public void setMphonenumber(String mphonenumber) {
		Mphonenumber = mphonenumber;
	}
	public Manager(String mid, String mpassword, String mname,
			String mphonenumber) {
		super();
		Mid = mid;
		Mpassword = mpassword;
		Mname = mname;
		Mphonenumber = mphonenumber;
	}
	public Manager() {
		super();
	}
	
}
