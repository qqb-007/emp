<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function () {
		$("#username").blur(function () {
			var username=$(this).val();
			var xhr;
            if(window.XMLHttpRequest){
                xhr = new XMLHttpRequest();
            }else{
                xhr = new ActiveXObject("microsoft.XMLHTTP");
            }
            xhr.open("GET","${pageContext.request.contextPath}/user_ajax?adminname="+username);
            xhr.send();
            xhr.onreadystatechange =  function(){

                if(xhr.readyState==4 && xhr.status==200){
                    console.log(xhr.responseText);
                    $("#usernameMsg").html("<font color='red'>"+xhr.responseText+"</font>");
                }
            }

        })
		$("#but").click(function () {
			var id="1";
		    var xhr;
		    if (XMLHttpRequest){
		        xhr=new XMLHttpRequest();
			}else {
		        xhr=new ActiveXObject("microsoft.XMLHTTP");
			}
			xhr.open("POST","${pageContext.request.contextPath}/user_ajax2");
            xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
            xhr.send("id="+id);
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4&&xhr.status==200){
                    console.log(xhr.responseText);
                    var libai=eval("("+ xhr.responseText +")");
                }
            }


        })
        $("#name").blur(function () {
			var name= $(this).val();
			var xhr;
			if(XMLHttpRequest){
			    xhr=new XMLHttpRequest();
			}else{
			    xhr=new ActiveXObject("microsoft.XMLHTTP");
			}
			xhr.open("post","${pageContext.request.contextPath}/user_ajax1");
			xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
			xhr.send("aname="+name);
			xhr.onreadystatechange = function () {
				if(xhr.readyState==4&&xhr.status==200){
				    console.log(xhr.responseText);
                    $("#usernameMsg1").html("<font color='red'>"+xhr.responseText+"</font>");

				}
            }
        })
    })

</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath }/user_addadmin"  method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" id="username" class="inputgri" name="admin.username" /><span id="usernameMsg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" id="name" name="admin.name" /><span id="usernameMsg1"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="admin.password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="admin.sex" value="男" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="admin.sex" value="女"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="vcode" src="${ pageContext.request.contextPath }/code" style="width:88px;height:20px" />
									<a href="javascript:;" onclick="document.getElementById('vcode').src = '${ pageContext.request.contextPath }/code?t='+Math.random()">换一张</a>

								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
					<input type="button" id="but" value="点我"/>
					<ul id="showInfo" >

					</ul>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>

		</div>

	</body>
</html>
