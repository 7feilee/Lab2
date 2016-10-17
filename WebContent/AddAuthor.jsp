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
	u-textRight{
	text-align: left !important; 
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加作者</title>
</head>
<body>
<blockquote>
<div id="Layer1" style="position:absolute; left:0;width:100%; height:100%; z-index:-1">
<img src="1.jpg" height="40%" width="100%"/>
</div>
</blockquote>
<br></br><br></br>
<center><h1>Insert a record to author table</h1></center><br></br><br></br>
	<form action="AddAuthor" method="post">
	 	<center>
	 	AuthorID: <input type="text" name="AuthorID" align="right"><br>
	 	&nbsp;Name&nbsp;: <input type="text" name="Name" align="right"><br>
	 	&nbsp;Age&nbsp;   : <input type="text" name="Age" align="right"><br>
	  	Country : <input type="text" name="Country" align="right"><br><br>
		&nbsp;&nbsp;<input type="submit" value="submit">
		</center>
	</form>
	<br><center>&nbsp;&nbsp;<a href="index.php">返回主界面</a><br></br></center>
<div class="bottom"></div>
	</body>
</html>