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
		<table>
			<tr>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>价格</td>
			<td>状态</td>
		</tr>
		<%
		List<Record> records=(List<Record>)request.getAttribute("records");
		for(Record r:records){%>
			<tr>
			<td><%=r.getBname() %></td>
			<td><%=r.getBauthor() %></td>
			<td><%=r.getBpress() %></td>
			<td><%=r.getBprice() %></td>
			<%if(r.getCheck()==0){ %>
			<td>审核中</td>
			<%}else{ if(r.getPass()==0){ %>
			<td><%="未通过审核" %></td>
			<%}else{ %>
			<td><%="已通过审核" %></td>
			<%}} %>
		    </tr>	
		<%}%>
		</table>
	</body>
</html>

