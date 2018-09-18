package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

import cn.zzu.pojo.Teacher;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		Map<String, String> m=new HashMap<String, String>();
		m.put("id", "1");
		m.put("password","456");
		Teacher teacher=session.selectOne("cn.zzu.mapper.TeacherMapper.checkLogin", m);
		System.out.println(teacher.getTname());
		session.close();
	}
}
