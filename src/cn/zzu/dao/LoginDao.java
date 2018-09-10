package cn.zzu.dao;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;
import cn.zzu.pojo.User;

public interface LoginDao {

	User checkLoginDao(String id,String pwd,String identity);
}
