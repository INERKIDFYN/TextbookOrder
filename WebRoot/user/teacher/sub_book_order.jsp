<%@ page language="java" import="java.util.*,cn.zzu.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title></title>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
		function getData(){		
			//创建ajax引擎对象
				var year=document.getElementById('year').value;
		        var major=document.getElementById('major').value;
		        var books=[];
		        obj=document.getElementsByName("books");
		        for(k in obj){
		        	if(obj[k].checked){
		        		books.push(obj[k].value);
		        	}
		        }
		        var records={year:year,major:major,books:books};
				$.ajax({
	                url:"teacherService",
	                type:"post",
	                dataType:"json",
	                data:JSON.stringify(records),
	                success:function(data){
	                   alert("成功");
	                   window.location.href='/tb/main/teaMain.jsp';
	                },
	                error:function(e){
	                    alert("错误！！");
	                }
	            });        
	}
	</script>
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
		<div>
			<form id="fm" >
			<input type="hidden" name="oper" value="subBooks" />
			<select id="year" name="year">
				<option value="2018">大一</option>
				<option value="2017">大二</option>
				<option value="2016">大三</option>
				<option value="2015">大四</option>
			</select>
			<select id="major" name="major">
				<option value="软件工程">软件工程</option>
				<option value="电子信息">电子信息</option>
			</select>
		
		<table>
		<tr>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>价格</td>
		</tr>
		<%
		List<Book> books=(List<Book>)request.getAttribute("books");
		for(Book b:books){%>
			<tr>
			<td><%=b.getBname() %></td>
			<td><%=b.getBauthor() %></td>
			<td><%=b.getBpress() %></td>
			<td><%=b.getBprice() %></td>
			<td><input type="checkbox" name="books" value=<%=b.getBid()%> /></td>
		    </tr>	
		<%}%>
		</table>
			<input type="button" value="提交" onclick="getData()"/>
		</form>
		</div>
	</body>
</html>

