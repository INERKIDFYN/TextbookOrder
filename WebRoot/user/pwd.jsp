<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title></title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<!--引入jQuery文件  -->
<script type="text/javascript" src="js/jquery.js"></script>
<!--声明jQuery代码域  -->
<script type="text/javascript">
	$(function(){
		//校验密码修改
		$("#fm").submit(function(){
			if($("#newpwd").val()==""){//校验新密码
				alert("新密码不能为空");
				return false;
			}else if($("#cfpwd").val()==""){//校验确认密码
				alert("确认密码不能为空");
				return false;
			}else if($("#newpwd").val()!=$("#cfpwd").val()){//校验新密码和确认密码是否一致
				alert("两次密码 不一致");
				return false;
			}else{
				return true;
			}
		})
	})

</script>
	</head>
	<body>
		<form action="changePwd" method="post" id="fm">
			<table>
				<tr>
					<td>新密码</td>
					<td><input type="password" id="newpwd" /></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" id="cfpwd" name="npwd" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="确定"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

