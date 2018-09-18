<%@ page language="java" import="java.util.*,cn.zzu.pojo.Teacher" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>无标题文档</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript" src="js/jquery.js"></script>
    </head>
    <body style="background:#FFFFFF;">
        <div class="top_main">
            <div class="user">  
                <%Teacher t=(Teacher)session.getAttribute("teacher"); %> 
                <span><%=t.getTname() %></span>
                <a href="login.jsp" target="_parent">退出</a></i>
            </div>    
        </div>
    </body>
</html>

