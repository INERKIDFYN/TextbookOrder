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
            // $('.menuson li').click(function(e) {
            //     $('.menuson li.active').removeClass('active');
            //     $(this).addClass('active');
            // });
            $('.menuson li').hover(function(e) {
                $('.menuson li.horver').removeClass('horver');
                $(this).addClass('horver');
            });
        })	
        </script>
    </head>
    <body>
        <div class="left_main">
            <div class="title">教材订购系统</div>
            <ul class="menuson" >  
                <li><a href="main/manager/text_list.jsp" target="rightFrame"><i class="glyphicon glyphicon-list-alt"></i>所有教材</a></li>
                <li><a href="manService?oper=verification" target="rightFrame"><i class="glyphicon glyphicon-check"></i>审核请求</a></li>
                <li><a href="main/manager/outbook.jsp" target="rightFrame"><i class="glyphicon glyphicon-export"></i>出库</a></li>
                <li><a href="main/manager/inbook.jsp" target="rightFrame"><i class="glyphicon glyphicon-import"></i>入库</a></li>
                <li><a href="main/manager/lack_book.jsp" target="rightFrame"><i class="glyphicon glyphicon-exclamation-sign"></i>缺书</a></li>
            </ul>    
        </div>
    </body>
</html>

