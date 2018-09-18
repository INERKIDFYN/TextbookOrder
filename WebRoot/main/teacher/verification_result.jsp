<%@ page language="java" import="java.util.*,cn.zzu.pojo.Record" pageEncoding="utf-8"%>
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
        <script type="text/javascript" src="js/jquery.js"></script>
    </head>
    <body style="background: #F1F1F1;">
        <div class="wrap">
            <div class="main_title">审核结果
                <i class="glyphicon glyphicon-refresh"></i>
            </div>
            <div class="content_body">
                <div class="table_content" style="height: 440px;">
                    <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                            <tr>
                                <th>书名</th>
                                <th>作者</th>
                                <th>出版社</th>
                                <th>价格</th>
                                <th>是否通过</th>
                                <th>备注</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%List<Record> records=(List<Record>)request.getAttribute("records"); 
                        if(records!=null){
                        for(Record r:records){%>
                            <tr>
                                <td><%=r.getBname() %></td>
                                <td><%=r.getBauthor() %></td>
                                <td><%=r.getBpress() %></td>
                                <td><%=r.getBprice() %></td>
                                <% String str=null;
                                if(r.getChecked()==0){str="审核中";}else if(r.getPass()==0){
                                	str="未通过审核";}else if(r.getPass()==1){
                                	str="已通过审核";}%>
                                <td><%=str %></td><td><%=r.getComment() %></td>
                            </tr>
                            <%}} %>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    
    </body>
</html>


