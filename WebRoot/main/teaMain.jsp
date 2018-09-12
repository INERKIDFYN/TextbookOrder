<%@ page language="java" import="java.util.*,cn.zzu.pojo.Teacher" pageEncoding="utf-8"%>
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
     Teacher t=(Teacher)session.getAttribute("user");
     String name=t.getName();
  %>
  <body>
  <div>
     <i>欢迎登录, <%=name %></i>
     <a href="">查看个人信息</a>
     <a href="/tb/user/pwd.jsp">修改密码</a>
  </div>
        <a href="teacherService?oper=subJsp">提交书单</a>
        <a href="teacherService?oper=checkSubJsp">查看审核进度</a>
  </body>
</html>