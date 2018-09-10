<%@ page language="java" import="java.util.*,cn.zzu.pojo.Manager" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

  </head>
  <%
     Manager m=(Manager)session.getAttribute("user");
     String name=m.getName();
  %>
  <body>
  <div>
     <i>欢迎登录, <%=name %></i>
     <a href="">查看个人信息</a>
     <a href="/tb/user/pwd.jsp">修改密码</a>
  </div>
         这里是本学期教材 <br>
  </body>
</html>