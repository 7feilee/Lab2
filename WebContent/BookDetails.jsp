<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		*{
			margin: 0 auto;
			padding: 0;
		}
		
		li{
			line-height: auto;
			list-style: none;
			padding-left: auto;
		}
		ul{
			height: 50px;
			width: 200%;
			background: #9AFF9A;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>书目介绍</title>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
	</script>
	<script type="text/javascript">
	function deletes()
	{
		var ISBN = document.getElementById("ISBN");
		alert("delete successfully");
		window.location.href = "delete?ISBN="+ISBN.innerHTML;
	}
	</script>
</head>
	<body>
		<blockquote>
		<div id="Layer1" style="position:absolute; left:0;width:100%; height:100%; z-index:-1">
		<img src="1.jpg" height="40%" width="100%"/>
		</div>
		</blockquote>
<br></br><br></br>
	<center>
		<h1>The details of the book and author</h1><br/><br/>
		<h2>ISBN</h2><br/>
		<p id="ISBN">
		<s:property value = "ISBN"/></p>
		<br/>
		Title:<s:property value = "Title"/>
		<br/>
		Publisher:<s:property value = "Publisher"/>
		<br/>
		PublishDate:<s:property value = "PublishDate"/>
		<br/>
		Price:<s:property value = "Price"/>
		<br/>
		AuthorID:<s:property value = "AuthorID"/>
		<br/>
		Name:<s:property value = "Name"/>
		<br/>
		Age:<s:property value = "Age"/>
		<br/>
		Country:<s:property value = "Country"/>
		<br/><br><br>
		<input type=button value="delete this book"  onclick="deletes();">
		<br><br>
     <a href="BookUpdate.jsp">Update</a><br>
		</center>
	<br><center><a href="index.php">返回主界面</a><br></br></center>
	</body>
</html>