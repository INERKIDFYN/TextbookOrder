package cn.zzu.daoImp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zzu.dao.TeacherServiceDao;
import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;

public class TeacherServiceDaoImp implements TeacherServiceDao{

	@Override
	public List<Book> StockBookDao() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Book> l=new ArrayList<Book>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbookorder1?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="select * from stock";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Book b=new Book();
				b.setBid(rs.getString("Bid"));
				b.setBname(rs.getString("Bname"));
				b.setBauthor(rs.getString("Bauthor"));
				b.setBpress(rs.getString("Bpress"));
				b.setBprice(rs.getFloat("Bprice"));
				b.setBcurnum(rs.getInt("Bcurnum"));
				l.add(b);
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
		return l;
	}

	@Override
	public boolean SubBooksOrderDao(String[] books, String id, String year,
			String major) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Book> l=new ArrayList<Book>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbookorder1?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="select * from stock where Bid=?";
			ps=conn.prepareStatement(sql);
			for(String bid:books){
				ps.setString(1, bid);
				rs=ps.executeQuery();
				while(rs.next()){
					Book b=new Book();
					b.setBid(rs.getString("Bid"));
					b.setBname(rs.getString("Bname"));
					b.setBauthor(rs.getString("Bauthor"));
					b.setBpress(rs.getString("Bpress"));
					b.setBprice(rs.getFloat("Bprice"));
					b.setBcurnum(rs.getInt("Bcurnum"));
					l.add(b);
				}
			}
			if(l.size()==0){
				return false;
			}
			sql="insert into t_buy(Tid,Bid,Bname,Bauthor,Bpress,Bprice,pass,Syear,Smajor) values("
					+ "?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			for(Book book:l){
				ps.setString(1, id);
				ps.setString(2, book.getBid());
				ps.setString(3, book.getBname());
				ps.setString(4, book.getBauthor());
				ps.setString(5, book.getBpress());
				ps.setFloat(6, book.getBprice());
				ps.setInt(7, 0);
				ps.setInt(8, Integer.parseInt(year));
				ps.setString(9, major);
				ps.executeUpdate();
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
		return true;
	}

	@Override
	public List<Record> checkSubRecDao(String id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Record> l=new ArrayList<Record>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/textbookorder1?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
			String sql="select * from t_buy where Tid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				Record r=new Record();
				r.setTid(rs.getString("Tid"));
				r.setBid(rs.getString("Bid"));
				r.setBauthor(rs.getString("Bauthor"));
				r.setBname(rs.getString("Bname"));
				r.setBpress(rs.getString("Bpress"));
				r.setBprice(rs.getFloat("Bprice"));
				r.setPass(rs.getInt("pass"));
				r.setSyear(rs.getInt("Syear"));
				r.setSmajor(rs.getString("Smajor"));
				r.setCheck(rs.getInt("check"));
				l.add(r);
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
		return l;
	}

}
