package cn.zzu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.zzu.JsonReader.JsonReader;
import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;
import cn.zzu.pojo.Teacher;
import cn.zzu.service.TeacherService;
import cn.zzu.serviceImp.TeacherServiceImp;

public class TeacherServlet extends HttpServlet {

	TeacherService ts=new TeacherServiceImp();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println(req.getMethod());
		System.out.println(req.getMethod().equals("POST"));
		if(req.getMethod().equals("POST")){
			subBooksOrder(req,resp);
			return;
		}
		String oper=req.getParameter("oper");
		if(oper.equals("subJsp")){
			StockBooks(req,resp);
			return;
		}
		if(oper.equals("checkSubJsp")){
			checkSubRec(req,resp);
			return;
		}
		resp.getWriter().write("123");
	}

	private void checkSubRec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=req.getSession();
		Teacher t=(Teacher) hs.getAttribute("teacher");
		List<Record> records=ts.checkSubRec(t.getTid());
		if(records!=null){
			req.setAttribute("records", records);
			req.getRequestDispatcher("/main/teacher/verification_result.jsp").forward(req, resp);
		}
	}

	private void subBooksOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		HttpSession hs=req.getSession();
		
		//获得json对象
		
		JSONObject json=new JsonReader().receivePost(req);
		Teacher t=(Teacher) hs.getAttribute("teacher");
		String year=json.getString("year");
		String major=json.getString("major");
		JSONArray jsonArray=json.getJSONArray("books");
		String [] bookid=new String [jsonArray.size()];
		for(int i=0;i<jsonArray.size();i++){
			bookid[i]=(String)jsonArray.get(i);
		}
		List<Book> books=ts.StockBooksById(bookid);
		for(Book b:books){
			System.out.println(b.getBauthor());
		}
		JSONObject jsonObject=new JSONObject();
		boolean flag=ts.SubBooksOrder(books,t.getTid(),year,major);
		if(flag){
			jsonObject.put("message", "提交成功！");
			resp.getWriter().write(jsonObject.toString());
		}else{
			jsonObject.put("message", "提交失败！");
			resp.getWriter().write(jsonObject.toString());
		}
	}

	private void StockBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Book> books=ts.StockBooks();
		if(books!=null){
			req.setAttribute("books", books);
			req.getRequestDispatcher("/main/teacher/submit_text.jsp").forward(req, resp);
		}
	}

}
