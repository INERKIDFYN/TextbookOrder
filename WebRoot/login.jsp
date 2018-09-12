<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    	<base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>教材订购系统</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript" src="js/jquery.js"></script>
        <script src="js/cloud.js" type="text/javascript"></script>

        <script language="javascript">
            $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){  
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })  
        });  
        </script> 
    </head>
    <body style="background-color:#FFD28A; background-repeat:no-repeat; background-position:center top; overflow:hidden;">
        <div id="mainBody">
            <div id="cloud1" class="cloud"></div>
            <div id="cloud2" class="cloud"></div>
        </div>  

        <div class="logintop">    
            <span>欢迎登录教材订购系统</span>       
        </div>

        <div class="loginbody">
            <div class="loginbox">
            
                <form action="login" method="post" style="padding-bottom: 10px;">
                    <ul>
                    	<li><% Object obj=request.getAttribute("loginFlag");
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
	   session.removeAttribute("pwd");%></li>
                        <li><input name="id" type="text" class="loginuser" placeholder="请输入用户名"/></li>
                        <li><input name="password" type="password" class="loginpwd" placeholder="请输入密码"/></li>
                        <li>
                            <span class="loginradio"><input id="login_admin" name="identity" type="radio" value="管理员"/><label for="login_admin">管理员</label></span>
                            <span class="loginradio"><input id="login_teacher" name="identity" type="radio" value="教师"/><label for="login_teacher">老师</label></span>
                            <span class="loginradio"><input id="login_student" name="identity" type="radio" value="学生" checked="checked"/><label for="login_student">学生</label></span>
                            <span class="loginradio"><input type="submit" class="loginbtn" value="登录"   /></span>
                        </li>
                    </ul>
                </form>    
            </div>    
        </div>
    </body>
</html>

