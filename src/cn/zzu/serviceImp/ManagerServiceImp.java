package cn.zzu.serviceImp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Record;
import cn.zzu.service.ManagerService;

public class ManagerServiceImp implements ManagerService{

	@Override
	public Manager checkLogin(String id, String pwd) throws IOException {
		// TODO Auto-generated method stub
		Manager ma=null;
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		Map<String, String> m=new HashMap<String, String>();
		m.put("id", id);
		m.put("password", pwd);
		ma=session.selectOne("cn.zzu.mapper.ManagerMapper.checklogin", m);
		session.close();
		return ma;
	}

	@Override
	public List<Record> checkRecords() throws IOException {
		// TODO Auto-generated method stub
		List<Record> records=null;
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		records=session.selectList("cn.zzu.mapper.RecordMapper.che_records");
		session.close();
		return records;
	}

	@Override
	public boolean sub_comment(Map m) throws IOException {
		// TODO Auto-generated method stub
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		int index=session.update("cn.zzu.mapper.RecordMapper.sub_comment",m);
		session.commit();
		session.close();
		return index>0;
	}

}
