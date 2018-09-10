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

public class LoginDaoImp implements LoginDao{

	@Override
	public Student checkstuLoginDao(String id, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbooksystem?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="select * from student where Sid=? and Spassword=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()){
				s=new Student();
				s.setSid(rs.getString("Sid"));
				s.setSpassword(rs.getString("Spassword"));
				s.setSname(rs.getString("Sname"));
				s.setSyear(rs.getInt("Syear"));
				s.setScollege(rs.getString("Scollege"));
				s.setSmajor(rs.getString("Smajor"));
				s.setSclass(rs.getString("Sclass"));
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
		return s;
	}

	@Override
	public Teacher checkTeaLoginDao(String id, String pwd) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Teacher t=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbooksystem?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="select * from teacher where Tid=? and Tpassword=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()){
				t=new Teacher();
				t.setTid(rs.getString("Tid"));
				t.setTpassword(rs.getString("Tpassword"));
				t.setTname(rs.getString("Tname"));
				t.setTcollege(rs.getString("Tcollege"));
				t.setTphonenumber(rs.getString("Tphonenumber"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
		return t;
	}

	@Override
	public Manager checkManLoginDao(String id, String pwd) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Manager m = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbooksystem?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="select * from manager where Mid=? and Mpassword=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			while(rs.next()){
				m=new Manager();
				m.setMid(rs.getString("Mid"));
				m.setMpassword(rs.getString("Mpassword"));
				m.setMname(rs.getString("Mname"));
				m.setMphonenumber(rs.getString("Mphonenumber"));
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
		return m;
	}

}
