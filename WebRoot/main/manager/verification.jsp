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
        <script type="text/javascript">
		function getData(ispass){		
			//创建ajax引擎对象
			
				var Tid=document.getElementById('Tid').value;
		        var Bid=document.getElementById('Bid').value;
		        var year=document.getElementById('year').value;
		        var major=document.getElementById('major').value;
		        var comment=document.getElementById('comment').value;
		        var records={year:year,major:major,Tid:Tid,Bid:Bid,ispass:ispass,comment:comment};
		        
		        $.ajax({
	                url:"manService",
	                type:"post",
	                dataType:"json",
	                data:JSON.stringify(records),
	                success:function(data){
	                   alert("成功");
	                   window.location.href='manService?oper=verification';
	                },
	                error:function(e){
	                    alert("错误！！");
	                }
	            });        
	}
	</script>	
    </head>
    <body style="background: #F1F1F1;">
        <div class="wrap">
            <div class="main_title">审核请求
                <i class="glyphicon glyphicon-refresh"></i>
            </div>
            
                <div class="table_content" style="height: 440px;">
                    <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                            <tr>
                                <th>书名</th>
                                <th>作者</th>
                                <th>出版社</th>
                                <th>价格</th>
                                <th>备注</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%List<Record> records=(List<Record>)request.getAttribute("records");
                        if(records!=null){
                        for(Record r:records){%>
                            <tr>
                            <input type="hidden" id="Tid" value=<%=r.getTid() %> />
                            <input type="hidden" id="Bid" value=<%=r.getBid() %> />
                            <input type="hidden" id="year" value=<%=r.getSyear() %> />
                            <input type="hidden" id="major" value=<%=r.getSmajor() %> />
                                <td style="vertical-align: middle;"><%=r.getBname() %></td>
                                <td><%=r.getBauthor() %></td>
                                <td><%=r.getBpress() %></td>
                                <td><%=r.getBprice() %></td>
                                <td><input type="text" class="form-control input-sm" id="comment"/></td>
                                <td>
                                    <div class="btn-group btn-group-sm" role="group"><button class="btn btn-default" onclick="getData(1)">通过</button><button class="btn btn-danger" onclick="getData(0)">不通过</button></div>
                                </td>
                            </tr>
                            <%}} %>
                        </tbody>
                    </table>
                </div>
            
        </div>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    
    </body>
</html>


