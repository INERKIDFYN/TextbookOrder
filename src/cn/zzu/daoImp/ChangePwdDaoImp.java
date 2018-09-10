package cn.zzu.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zzu.dao.ChangePwdDao;

public class ChangePwdDaoImp implements ChangePwdDao{

	@Override
	public int changePwdDao(String identity, String newPwd,String id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		int index=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbookorder?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="";
			if(identity.equals("学生")){
				sql="update student set Spassword=? where Sid=?";
				
			}else if(identity.equals("教师")){
				sql="update teacher set Tpassword=? where Tid=?";
			}else if(identity.equals("教材发行人员")){
				sql="update manager set Mpassword=? where Mid=?";
			}
			if(!sql.equals("")){
				ps=conn.prepareStatement(sql);
				ps.setString(1, newPwd);
				ps.setString(2, id);
				index=ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

}
