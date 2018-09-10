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
		if(identity.equals("学生")){
			Student s=(Student) u;
			stuLogin(s,req,resp);
		}else if(identity.equals("教师")){
			Teacher t=(Teacher) u;
			teaLogin(t,req,resp);
		}else if(identity.equals("教材发行人员")){
			Manager m=(Manager) u;
			manLogin(m,req,resp);
		}
	}
	private void manLogin(Manager m, HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(m!=null){
			HttpSession hs=req.getSession();
			hs.setAttribute("manager", m);
			resp.sendRedirect("/tb/main/main.jsp");
		}
	}

	private void teaLogin(Teacher t, HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(t!=null){
			HttpSession hs=req.getSession();
			hs.setAttribute("teacher", t);
			resp.sendRedirect("/tb/main/main.jsp");
		}
	}

	private void stuLogin(Student s,HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		if(s!=null){
			HttpSession hs=req.getSession();
			hs.setAttribute("student", s);
			resp.sendRedirect("/tb/main/stuMain.jsp");
		}
	}
}
