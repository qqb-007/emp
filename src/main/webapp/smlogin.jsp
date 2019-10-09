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

            $("#butt").click(function () {
                var name=$("#smname").val();
                console.log(name);

                var psd=$("#psd").val();
                console.log(psd);
                var xhr;
                if (XMLHttpRequest){
                    xhr=new XMLHttpRequest();
                }else {
                    xhr=new ActiveXObject("microsoft.XMLHTTP");
                }
                xhr.open("POST","${pageContext.request.contextPath}/user_loginSmuser");
                xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
                xhr.send("smusername="+name+"&smpassword="+psd);
                xhr.onreadystatechange=function () {
                    if(xhr.readyState==4&&xhr.status==200){
                        console.log(xhr.responseText);
                        if (xhr.responseText=="ok"){
                            console.log("ok111");
                            location.href='${pageContext.request.contextPath }/sm/user_showAllsmword?smusername='+name;
                        }
                        //var libai=eval("("+ xhr.responseText +")");
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
						login
					</h1>

						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" id="smname"  name="admin.username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" id="psd"  name="admin.password" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" id="butt" value="Submit &raquo;" />
							<input type="button" class="button" onclick="location.href='regist.jsp'" value="Regist &raquo;" />
						</p>

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
