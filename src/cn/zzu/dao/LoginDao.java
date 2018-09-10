package cn.zzu.dao;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;

public interface LoginDao {

	Student checkstuLoginDao(String id,String pwd);
	Teacher checkTeaLoginDao(String id,String pwd);
	Manager checkManLoginDao(String id, String pwd);
}
