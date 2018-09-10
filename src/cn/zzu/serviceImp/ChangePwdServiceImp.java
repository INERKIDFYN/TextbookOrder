package cn.zzu.serviceImp;

import cn.zzu.dao.ChangePwdDao;
import cn.zzu.daoImp.ChangePwdDaoImp;
import cn.zzu.service.ChangePwdService;

public class ChangePwdServiceImp implements ChangePwdService{

	ChangePwdDao cd=new ChangePwdDaoImp();
	@Override
	public int changePwd(String identity, String newPwd,String id) {
		// TODO Auto-generated method stub
		return cd.changePwdDao(identity, newPwd,id);
	}

}
