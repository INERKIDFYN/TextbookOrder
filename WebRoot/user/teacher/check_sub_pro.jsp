<%@ page language="java" import="java.util.*,cn.zzu.pojo.Record" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			table{
				background-color: burlywood;
			}
			td{
				background-color: white;
				margin: auto;
			}
		</style>
	</head>
	<body>
	<%
		List<Record> records=(List<Record>)request.getAttribute("records");
	    List<Record> nchecked=new ArrayList<Record>();
	    List<Record> passed=new ArrayList<Record>();
	    List<Record> npass=new ArrayList<Record>();
	    for(Record r:records){
	    	if(r.getCheck()==0){
	    		nchecked.add(r);
	    	}else{
	    		if(r.getPass()==1){
	    			passed.add(r);
	    		}else{
	    			npass.add(r);
	    		}
	    	}
	    }
		%>
		<%if(nchecked.size()>0){ %>
	<h3>审核中</h3>
		<table>
			<tr>
			<td>专业</td>
			<td>年级</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>价格</td>
			<td>状态</td>
		</tr>
			<%for(Record r:nchecked){%>
			<tr>
			<td><%=r.getSmajor() %></td>
			<td><%=r.getSyear() %></td>
			<td><%=r.getBname() %></td>
			<td><%=r.getBauthor() %></td>
			<td><%=r.getBpress() %></td>
			<td><%=r.getBprice() %></td>
			
			<td>审核中</td>
			</tr>
			<%}%>
		</table>
		<%} 
		if(passed.size()>0){ %>
			<h3>已通过审核</h3>
		<table>
			<tr>
			<td>专业</td>
			<td>年级</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>价格</td>
			<td>状态</td>
		</tr>
			<%for(Record r:passed){%>
			<tr>
			<td><%=r.getSmajor() %></td>
			<td><%=r.getSyear() %></td>
			<td><%=r.getBname() %></td>
			<td><%=r.getBauthor() %></td>
			<td><%=r.getBpress() %></td>
			<td><%=r.getBprice() %></td>
			<td><%="已通过审核" %></td>
			</tr>
			<%}%>
		</table>
		<%}
		if(npass.size()>0){ %>
			<h3>未通过审核</h3>
		<table>
			<tr>
			<td>专业</td>
			<td>年级</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>价格</td>
			<td>状态</td>
		</tr>
		<%for(Record r:npass){%>
			<tr>
			<td><%=r.getSmajor() %></td>
			<td><%=r.getSyear() %></td>
			<td><%=r.getBname() %></td>
			<td><%=r.getBauthor() %></td>
			<td><%=r.getBpress() %></td>
			<td><%=r.getBprice() %></td>
			<td><%="未通过审核" %></td>
			</tr>
			<%}%>
		</table>
		<%} %>
	
	</body>
</html>

