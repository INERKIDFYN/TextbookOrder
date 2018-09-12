package cn.zzu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;
import cn.zzu.pojo.User;
import cn.zzu.service.LoginService;
import cn.zzu.serviceImp.LoginServiceImp;

public class LoginServlet extends HttpServlet {

	LoginService ls=new LoginServiceImp();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String identity=(String) req.getParameter("identity");
		String id=req.getParameter("id");
		String pwd=req.getParameter("password");
		User u=ls.checkLogin(id, pwd, identity);
		if(u==null){
			req.setAttribute("loginFlag", false);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		HttpSession hs=req.getSession();
		hs.setAttribute("user", u);
		if(identity.equals("ѧ��")){
			Student s=(Student) u;
			hs.setAttribute("identity", "ѧ��");
			resp.sendRedirect("/tb/main/stuMain.jsp");
		}else if(identity.equals("��ʦ")){
			Teacher t=(Teacher) u;
			hs.setAttribute("identity", "��ʦ");
			resp.sendRedirect("/tb/main/teaMain.jsp");
		}else if(identity.equals("����Ա")){
			Manager m=(Manager) u;
			hs.setAttribute("identity", "����Ա");
			resp.sendRedirect("/tb/main/manMain.jsp");
		}
	}
}
