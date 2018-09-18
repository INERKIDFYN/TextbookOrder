<%@ page language="java" import="java.util.*,cn.zzu.pojo.Book" pageEncoding="utf-8"%>
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
		function getData(){		
			//创建ajax引擎对象
			
				var year=document.getElementById('year').value;
		        var major=document.getElementById('major').value;
		        var books=[];
		        obj=document.getElementsByName("books");
		        alert("aa");
		        for(k in obj){
		        	if(obj[k].checked){
		        		books.push(obj[k].value);
		        	}
		        }
		       
		        var records={year:year,major:major,books:books};
				$.ajax({
	                url:"teacherService",
	                type:"post",
	                dataType:"json",
	                data:JSON.stringify(records),
	                success:function(data){
	                   alert("提交成功");
	                   window.location.href='teacherService?oper=checkSubJsp';
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
            <div class="main_title">提交教材
                <i class="glyphicon glyphicon-refresh"></i>
            </div>
            <form action="" method="post" class="content_body">
                <div class="input_info">
                    <span>
                        <select class="form-control" id="year">
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>                          
                        </select>
                    </span>
                    <span>
                        <select class="form-control">
                            <option >信息工程学院</option>                      
                        </select>
                    </span>
                    <span>
                        <select class="form-control" id="major">
                            <option value="软件工程">软件工程</option>
                            <option value="电子信息">电子信息</option>                      
                        </select>
                    </span>
                    <div class="input_bookname">
                        <input type="text" class="form-control" placeholder="请输入书名"/>
                        <button class="btn btn-warning" style="background-color:#F9692F;">搜索</button>
                    </div>
                </div>
                <div class="table_content">
                    <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                            <tr>
                                <th>书名</th>
                                <th>作者</th>
                                <th>出版社</th>
                                <th>价格</th>
                                <th>选择</th>
                            </tr>
                        </thead>
                        <tbody>
               <%List<Book> books=(List<Book>)request.getAttribute("books");
               if(books!=null){
               for(int i=0;i<books.size();i++){
               Book b=books.get(i);%>
			<tr>
			<td><%=b.getBname() %></td>
			<td><%=b.getBauthor() %></td>
			<td><%=b.getBpress() %></td>
			<td><%=b.getBprice() %></td>
			<td class="col-md-1 check_box"><input type="checkbox" name="books" value=<%=b.getBid() %> /></td>
			<%}}%>
		    </tr>	
                        </tbody>
                    </table>
                </div>
                <div class="submit_button">
                    <input type="button" class="btn btn-warning" value="提交" onclick="getData()" style="background-color:#F9692F;"/>
                </div>
            </form>
        </div>
    </body>
</html>

