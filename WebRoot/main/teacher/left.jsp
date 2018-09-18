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
        <title>无标题文档</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script language="JavaScript" src="js/jquery.js"></script>
        <script type="text/javascript">
        $(function(){	
            $('.menuson li').click(function() {
                $('.menuson li.active').removeClass('active');
                $(this).addClass('active');
            });
            $('.menuson li').hover(function() {   
                $(this).addClass('horver');
            }, function() {
                $('.menuson li.horver').removeClass('horver');
            });
        })	
        </script>
        <script type="text/javascript">
      window.onload=function (){
        window.parent.rightFrame.location.href="teacherService?oper=subJsp";
     }
    </script>
    </head>
    <body>
        <div class="left_main">
            <div class="title">教材订购系统</div>
            <ul class="menuson" >  
                <li><a href="teacherService?oper=subJsp" target="rightFrame"><i class="glyphicon glyphicon-list"></i>提交教材</a></li>
                <li><a href="teacherService?oper=checkSubJsp" target="rightFrame"><i class="glyphicon glyphicon-check"></i>审核结果</a></li>
            </ul>    
        </div>
    </body>
</html>

