<%@ page language="java" import="java.util.*,cn.zzu.pojo.Student" pageEncoding="utf-8"%>
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
     Student s=(Student)session.getAttribute("student");
     String name=s.getName();
  %>
  <body>
  <div>
     <i>欢迎登录, <%=name %></i>
     <a href="">查看个人信息</a>
     <a href="">修改密码</a>
  </div>
         这里是本学期教材 <br>
  </body>
</html>
