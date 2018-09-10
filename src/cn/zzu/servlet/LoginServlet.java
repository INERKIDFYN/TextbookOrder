package cn.zzu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zzu.pojo.Student;
import cn.zzu.pojo.Teacher;
import cn.zzu.service.LoginService;
import cn.zzu.serviceImp.LoginServiceImp;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String identity=(String) req.getParameter("identity");
		String id=req.getParameter("id");
		String pwd=req.getParameter("password");
		LoginService ls=new LoginServiceImp();
		if(identity.equals("学生")){
			Student s=ls.checkStuLogin(id, pwd);
			stuLogin(s,req,resp);
		}else if(identity.equals("教师")){
			Teacher t=ls.checkTeaLogin(id, pwd);
			teaLogin(t,req,resp);
		}
	}

	private void teaLogin(Teacher t, HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(t!=null){
			HttpSession hs=req.getSession();
			hs.setAttribute("teacher", t);
			resp.sendRedirect("/tb/main/main.jsp");
		}else{
			req.setAttribute("loginFlag", false);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

	private void stuLogin(Student s,HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		if(s!=null){
			HttpSession hs=req.getSession();
			hs.setAttribute("student", s);
			resp.sendRedirect("/tb/main/main.jsp");
		}else{
			req.setAttribute("loginFlag", false);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
