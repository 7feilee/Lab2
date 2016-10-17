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
<title>著作</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
function details(e)
{
	var BookTitle = document.getElementById("BookTitle");
	window.location.href = "getDetail?BookTitle="+e.innerHTML;
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
		<center><h1>The author's books list</h1></center><br></br><br></br>
		<center>
		<h2>AuthorName:<s:property value = "Authorname"/></h2>
		<br><h2>BookList:</h2><br>
		<table border="2">
			<s:iterator value="BookList" var="String" status = "status">
			<tr>
			<td>
				<p id="BookTitle"><p onclick="details(this);"><s:property value="String"/> </p> 
			</td>
			</tr>
			</s:iterator>
		</table>
		</center>
		<br><center><a href="index.php">返回主界面</a><br></br></center>
	</body>
</html>
