package cn.zzu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.zzu.pojo.Record;
import cn.zzu.service.ManagerService;
import cn.zzu.serviceImp.ManagerServiceImp;
import cn.zzu.JsonReader.JsonReader;

public class ManagerServlet extends HttpServlet {

	ManagerService ms=new ManagerServiceImp();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		if(req.getMethod().equals("POST")){
			sub_comment(req,resp);
			return;
		}
		String oper=req.getParameter("oper");
		if(oper==null){
			return;
		}
		if(oper.equals("verification")){
			Verification(req,resp);
			return;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void sub_comment(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		JSONObject json=new JsonReader().receivePost(req);
		String year=json.getString("year");
		String major=json.getString("major");
		String Bid=json.getString("Bid");
		String Tid=json.getString("Tid");
		int pass=json.getInt("ispass");
		String comment=json.getString("comment");
		Map m=new HashMap();
		m.put("year", year);
		m.put("major", major);
		m.put("Bid", Bid);
		m.put("Tid", Tid);
		m.put("comment", comment);
		m.put("pass", pass);
		boolean flag=ms.sub_comment(m);
		JSONObject jsonObject=new JSONObject();
		System.out.println(major);
		if(flag){
			jsonObject.put("message", "提交成功！");
			resp.getWriter().write(jsonObject.toString());
		}
	}

	private void Verification(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Record> records=ms.checkRecords();
		if(records!=null){
			req.setAttribute("records", records);
			req.getRequestDispatcher("/main/manager/verification.jsp").forward(req, resp);
		}
	}
}
