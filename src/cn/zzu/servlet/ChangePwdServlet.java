package cn.zzu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zzu.pojo.User;
import cn.zzu.service.ChangePwdService;
import cn.zzu.serviceImp.ChangePwdServiceImp;

public class ChangePwdServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String newPwd=req.getParameter("npwd");
		HttpSession hs=req.getSession();
		String identity=(String) hs.getAttribute("identity");
		User u=(User) hs.getAttribute("user");
		ChangePwdService cs=new ChangePwdServiceImp();
		int flag=cs.changePwd(identity, newPwd, u.getId());
		if(flag>0){
			hs.setAttribute("pwd", true);
			resp.sendRedirect("/tb/login.jsp");
		}
	}
}
