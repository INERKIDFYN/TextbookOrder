package cn.zzu.serviceImp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;
import cn.zzu.pojo.Teacher;
import cn.zzu.service.TeacherService;

public class TeacherServiceImp implements TeacherService{

	@Override
	public List<Book> StockBooks() throws IOException {
		// TODO Auto-generated method stub
		List<Book> books=null;
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		books=session.selectList("cn.zzu.mapper.BookMapper.StockBooks");
		session.close();
		return books;
	}
	@Override
	public boolean SubBooksOrder(List<Book> books, String id, String year,
			String major) throws IOException {
		// TODO Auto-generated method stub
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		List<Record> records=new ArrayList<Record>();
		for(Book b:books){
			Record r=new Record();
			r.setTid(id);
			r.setBid(b.getBid());
			r.setBname(b.getBname());
			r.setBauthor(b.getBauthor());
			r.setBpress(b.getBpress());
			r.setBprice(b.getBprice());
			r.setPass(0);
			r.setSmajor(major);
			r.setSyear(Integer.parseInt(year));
			records.add(r);
		}
		for(Record r:records){
			System.out.println(r.getBname());
		}
		int index=session.insert("cn.zzu.mapper.RecordMapper.sub_books", records);
		session.commit();
		System.out.println(index);
		session.close();
		return index>0;
	}
	@Override
	public List<Record> checkSubRec(String id) throws IOException {
		// TODO Auto-generated method stub
		List<Record> records=null;
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		records=session.selectList("cn.zzu.mapper.RecordMapper.check_recordsbyid",id);
		session.close();
		return records;
	}
	@Override
	public Teacher checkLogin(String id, String pwd) throws IOException {
		// TODO Auto-generated method stub
		Teacher t=null;
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		Map<String, String> m=new HashMap<String, String>();
		m.put("id", id);
		m.put("password", pwd);
		t=session.selectOne("cn.zzu.mapper.TeacherMapper.checkLogin", m);
		session.close();
		return t;
	}
	@Override
	public List<Book> StockBooksById(String [] bookid) throws IOException {
		// TODO Auto-generated method stub
		List<Book> books=null;
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		books=session.selectList("cn.zzu.mapper.BookMapper.StockBooksById",bookid);
		session.close();
		return books;
	}

}
