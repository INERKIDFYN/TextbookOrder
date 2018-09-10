package cn.zzu.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zzu.dao.LoginDao;
import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;
import cn.zzu.pojo.User;

public class LoginDaoImp implements LoginDao{


	@Override
	public User checkLoginDao(String id, String pwd,String identity) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbookorder?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			if(identity.equals("学生")){
				Student s=null;
				String sql="select * from student where Sid=? and Spassword=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pwd);
				rs=ps.executeQuery();
				while(rs.next()){
					s=new Student();
					s.setId(rs.getString("Sid"));
					s.setPassword(rs.getString("Spassword"));
					s.setName(rs.getString("Sname"));
					s.setSyear(rs.getInt("Syear"));
					s.setScollege(rs.getString("Scollege"));
					s.setSmajor(rs.getString("Smajor"));
					s.setSclass(rs.getString("Sclass"));
				}
				return s;
			}else if(identity.equals("教师")){
				Teacher t=null;
				String sql="select * from teacher where Tid=? and Tpassword=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pwd);
				rs=ps.executeQuery();
				while(rs.next()){
					t=new Teacher();
					t.setId(rs.getString("Tid"));
					t.setPassword(rs.getString("Tpassword"));
					t.setName(rs.getString("Tname"));
					t.setTcollege(rs.getString("Tcollege"));
					t.setTphonenumber(rs.getString("Tphonenumber"));
				}
				return t;
			}else if(identity.equals("教材发行人员")){
				Manager m=null;
				String sql="select * from manager where Mid=? and Mpassword=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pwd);
				rs=ps.executeQuery();
				while(rs.next()){
					m=new Manager();
					m.setId(rs.getString("Mid"));
					m.setPassword(rs.getString("Mpassword"));
					m.setName(rs.getString("Mname"));
					m.setMphonenumber(rs.getString("Mphonenumber"));
				}
				return m;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return null;
	}

}
