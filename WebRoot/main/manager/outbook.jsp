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
        <script type="text/javascript" src="js/jquery.js"></script>
    </head>
    <body style="background: #F1F1F1;">
        <div class="wrap">
            <div class="main_title">出库</div>
            <form action="" method="post" class="content_body">
                <div class="input_info">
                    <span>
                        <select class="form-control">
                            <option value="1">大一</option>
                            <option value="2">大二</option>
                            <option value="3">大三</option>
                            <option value="4">大四</option>                          
                        </select>
                    </span>
                    <span>
                        <select class="form-control">
                            <option value="1">信息工程学院</option>
                            <option value="2">广西省</option>
                            <option value="3">福建省</option>
                            <option value="4">湖南省</option>
                            <option value="5">山东省</option>                            
                        </select>
                    </span>
                    <span>
                        <select class="form-control">
                            <option value="1">软件工程</option>
                            <option value="2">广西省</option>
                            <option value="3">福建省</option>
                            <option value="4">湖南省</option>
                            <option value="5">山东省</option>                            
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
                            <tr>
                                <td>操作系统</td>
                                <td>申</td>
                                <td>电子工业出版社</td>
                                <td>38.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>电子导论</td>
                                <td>兵</td>
                                <td>郑州大学出版社</td>
                                <td>32.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                           </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                            <tr>
                                <td>计算机网络</td>
                                <td>纪</td>
                                <td>郑州大学出版社</td>
                                <td>40.0</td>
                                <td class="col-md-1 check_box"><input type="checkbox" value="option1"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="submit_button">
                    <input type="submit" class="btn btn-warning" value="提交" style="background-color:#F9692F;"/>
                </div>
            </form>
        </div>
        <script language="JavaScript" src="js/jquery.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    
    </body>
</html>

