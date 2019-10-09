<%@page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function () {
	    $("#butu").click(function () {

        })

        $("#butt").click(function () {
            var word=$("#pl").val();
            console.log(word);

            var userid=${requestScope.smuser.id };
            console.log(userid);
            var username="${ requestScope.smuser.name }";
            var xhr;
            if (XMLHttpRequest){
                xhr=new XMLHttpRequest();
            }else {
                xhr=new ActiveXObject("microsoft.XMLHTTP");
            }
            //xhr.open("post","${pageContext.request.contextPath}/user_ajax3");
            xhr.open("GET","${pageContext.request.contextPath}/user_ajax3?word="+word+"&userid="+userid+"&username="+username);
            xhr.send();
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4&&xhr.status==200){
                    console.log(xhr.responseText);
                    var jsArray = eval("("+ xhr.responseText +")");
                    //清空页面中原始ul标签
                    $("ul").remove();
                    var ul = $("<ul/>");
                    //参数1:遍历的数组是谁  参数2:回调函数  function(){} 参数1:当前遍历下标 参数2:当前遍历的对象
                    $.each(jsArray,function(i,user){
                        console.log(i);
                        console.log(user);

                        ul.append("<li value='"+user.id+"' id=>"+user.username+":"+user.word+"</li>");
                        ul.append("<input type='submit' class='button' onclick='aa("+user.id+","+user.up+","+user.down+")' id='butu' value='顶 ' />"+user.up);
                        ul.append("<input type='submit' class='button' onclick='bb("+user.id+","+user.up+","+user.down+")' id='butd' value='踩 ' />"+user.down);
                        $("body").append(ul);
                    })
                    //var libai=eval("("+ xhr.responseText +")");
                }
            }


        })


    })
    function aa(a,b,c) {
        var b1=b+1;
        var xhr;
        if (XMLHttpRequest){
            xhr=new XMLHttpRequest();
        }else {
            xhr=new ActiveXObject("microsoft.XMLHTTP");
        }
        //xhr.open("post","${pageContext.request.contextPath}/user_ajax3");
        xhr.open("GET","${pageContext.request.contextPath}/user_ajax4?id="+a+"&up="+b1+"&down="+c);
        xhr.send();
        xhr.onreadystatechange=function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                var jsArray = eval("(" + xhr.responseText + ")");
                //清空页面中原始ul标签
                $("ul").remove();
                var ul = $("<ul/>");
                //参数1:遍历的数组是谁  参数2:回调函数  function(){} 参数1:当前遍历下标 参数2:当前遍历的对象
                $.each(jsArray, function (i, user) {
                    console.log(i);
                    console.log(user);

                    ul.append("<li value='" + user.id + "' id=>" + user.username + ":" + user.word + "</li>");
                    ul.append("<input type='submit' class='button' onclick='aa(" + user.id + "," + user.up + "," + user.down + ")' id='butu' value='顶 ' />" + user.up);
                    ul.append("<input type='submit' class='button' onclick='bb(" + user.id + "," + user.up + "," + user.down + ")' id='butd' value='踩 ' />" + user.down);
                    $("body").append(ul);
                })
            }
        }

    }


    function bb(a,b,c) {
        var c1=c+1;
        var xhr;
        if (XMLHttpRequest){
            xhr=new XMLHttpRequest();
        }else {
            xhr=new ActiveXObject("microsoft.XMLHTTP");
        }
        //xhr.open("post","${pageContext.request.contextPath}/user_ajax3");
        xhr.open("GET","${pageContext.request.contextPath}/user_ajax4?id="+a+"&up="+b+"&down="+c1);
        xhr.send();
        xhr.onreadystatechange=function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                var jsArray = eval("(" + xhr.responseText + ")");
                //清空页面中原始ul标签
                $("ul").remove();
                var ul = $("<ul/>");
                //参数1:遍历的数组是谁  参数2:回调函数  function(){} 参数1:当前遍历下标 参数2:当前遍历的对象
                $.each(jsArray, function (i, user) {
                    console.log(i);
                    console.log(user);

                    ul.append("<li value='" + user.id + "' id=>" + user.username + ":" + user.word + "</li>");
                    ul.append("<input type='submit' class='button' onclick='aa(" + user.id + "," + user.up + "," + user.down + ")' id='butu' value='顶 ' />" + user.up);
                    ul.append("<input type='submit' class='button' onclick='bb(" + user.id + "," + user.up + "," + user.down + ")' id='butd' value='踩 ' />" + user.down);
                    $("body").append(ul);
                })
            }
        }

    }

</script>
	</head>
	<body>
							<p>
								<h1>欢迎${ requestScope.smuser.name }</h1>
								<br />
							</p>


                            <div><img src="${pageContext.request.contextPath }/img/060651mk1xv4v0t4z1jtk1.jpg" width="178" height="61" /></div>
                            <div>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</div>
    <div>评论 <input type="text" class="inputgri" id="pl" /><input type="submit" class="button" id="butt" value="提交 &raquo;" /></div>
    <div>评论区</div>
    <div>

	<ul id="showInfo" >
		<c:forEach items="${requestScope.smlist}" var="sw">
			<li>
					${sw.username }:${sw.word }

			</li>
            <input type="submit" class="button" onclick="aa(${sw.id },${sw.up },${sw.down })" id="butu" value="顶 " />${sw.up }
            <input type="submit" class="button" id="butd" onclick="bb(${sw.id },${sw.up },${sw.down })" value="踩" />${sw.down }
		</c:forEach>
	</ul>


    </div>

	</body>
</html>
