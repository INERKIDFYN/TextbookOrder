package cn.zzu.serviceImp;

import cn.zzu.dao.LoginDao;
import cn.zzu.daoImp.LoginDaoImp;
import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;
import cn.zzu.pojo.User;
import cn.zzu.service.LoginService;

public class LoginServiceImp implements LoginService{

	LoginDao ld=new LoginDaoImp();
//	@Override
//	public Student checkStuLogin(String id, String pwd) {
//		// TODO Auto-generated method stub
//		return ld.checkstuLoginDao(id, pwd);
//	}
//	@Override
//	public Teacher checkTeaLogin(String id, String pwd) {
//		// TODO Auto-generated method stub
//		return ld.checkTeaLoginDao(id, pwd);
//	}
//	@Override
//	public Manager checkManLogin(String id, String pwd) {
//		// TODO Auto-generated method stub
//		return ld.checkManLoginDao(id,pwd);
//	}
	@Override
	public User checkLogin(String id, String pwd,String identity) {
		// TODO Auto-generated method stub
		return ld.checkLoginDao(id, pwd,identity);
	}


}
