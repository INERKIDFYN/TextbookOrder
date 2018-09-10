<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	<% Object obj=request.getAttribute("loginFlag");
	if(obj!=null){
	%>
	 <div >
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">用户名或密码错误</span>
	</div>
	 <%} %>
	 <% Object pwd=session.getAttribute("pwd");
	if(pwd!=null){
	%>
	<div >
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">密码修改成功</span>
	</div>
	<% }
	   session.removeAttribute("pwd");%>
		<form id="formid" method="post"  action="login">
			<table>
			<tr>
				<td>身份</td>
				<td>
					<select name="identity">
						<option value="学生">学生</option>
						<option value="教师">教师</option>
						<option value="采购人员">采购人员</option>
						<option value="教材发行人员">教材发行人员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>账号</td>
				<td ><input type="text" id="id" name="id"/></td>
			</tr>
			<tr>
				<td >密码</td>
				<td><input type="password" id="passid" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登录" />
				</td>
			</tr>
			</table>
		</form>
	</body>
</html>
