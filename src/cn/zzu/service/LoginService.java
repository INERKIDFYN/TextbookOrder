package cn.zzu.service;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;
import cn.zzu.pojo.User;

public interface LoginService {

//	Student checkStuLogin(String id,String pwd);
//	Teacher checkTeaLogin(String id,String pwd);
//	Manager checkManLogin(String id,String pwd);
	User checkLogin(String id,String pwd,String identity);
}
