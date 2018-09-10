package cn.zzu.pojo;

public class Manager extends User{
	private String Mphonenumber;
	public String getMphonenumber() {
		return Mphonenumber;
	}
	public void setMphonenumber(String mphonenumber) {
		Mphonenumber = mphonenumber;
	}
	public Manager(String mid, String mpassword, String mname,
			String mphonenumber) {
		super(mid,mpassword,mname);
		Mphonenumber = mphonenumber;
	}
	public Manager() {
		super();
	}
	
}
