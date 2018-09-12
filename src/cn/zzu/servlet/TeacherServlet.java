package cn.zzu.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
		Teacher t=(Teacher) hs.getAttribute("user");
		List<Record> records=ts.checkSubRec(t.getId());
		if(records!=null){
			req.setAttribute("records", records);
			req.getRequestDispatcher("/user/teacher/check_sub_pro.jsp").forward(req, resp);
		}
	}

	private void subBooksOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		HttpSession hs=req.getSession();
		
		//获得json对象
		
		JSONObject json=new JsonReader().receivePost(req);
		Teacher t=(Teacher) hs.getAttribute("user");
		String year=json.getString("year");
		String major=json.getString("major");
		JSONArray jsonArray=json.getJSONArray("books");
		String[] books=new String[jsonArray.size()];
		for(int i=0;i<jsonArray.size();i++){
			books[i]=jsonArray.getString(i);
		}
		System.out.println(year+":"+major+":"+books);
		JSONObject jsonObject=new JSONObject() ;
		boolean flag=ts.SubBooksOrder(books,t.getId(),year,major);
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
			req.getRequestDispatcher("/user/teacher/sub_book_order.jsp").forward(req, resp);
		}
	}


	
	
	
	class JsonReader {
		public JSONObject receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException {
	 
			if(request.getMethod().equals("get")){
				return null;
			}
			// 读取请求内容
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			//将json字符串转换为json对象
			JSONObject json=JSONObject.fromObject(sb.toString());
			return json;
		}
	}

}
