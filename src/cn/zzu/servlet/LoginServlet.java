package cn.zzu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Teacher;
import cn.zzu.service.ManagerService;
import cn.zzu.service.TeacherService;
import cn.zzu.serviceImp.ManagerServiceImp;
import cn.zzu.serviceImp.TeacherServiceImp;


public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String identity=req.getParameter("identity");
		String id=req.getParameter("id");
		String pwd=req.getParameter("password");
		if(identity.equals("教师")){
			TeacherService ts=new TeacherServiceImp();
			Teacher t=ts.checkLogin(id, pwd);
			if(t!=null){
				HttpSession hs=req.getSession();
				hs.setAttribute("teacher", t);
				resp.sendRedirect("/tb1/main/teacher/main.jsp");
			}else{
				req.setAttribute("loginFlag", false);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
		}
		if(identity.equals("管理员")){
			ManagerService ms=new ManagerServiceImp();
			Manager m=ms.checkLogin(id, pwd);
			if(m!=null){
				HttpSession hs=req.getSession();
				hs.setAttribute("manager", m);
				resp.sendRedirect("/tb1/main/manager/main.jsp");
			}else{
				req.setAttribute("loginFlag", false);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
		}
	}
}
