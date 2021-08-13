<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="DeptAddCheck" method="post">
	<table>
	<br><br>
		<span style="color:red;font-size: 15px"><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%></span>
		<span style="color:green;font-size: 15px"><%=(request.getAttribute("saved") == null) ? "" : request.getAttribute("saved")%></span>
		<br>
		<br>
		<tr>
			<td>DEPARTMENT ID : &nbsp;</td>
			<td><input type="text" name="deptId" placeholder="department id" required="required"></td>
		</tr>
		<tr>
			<td>DEPARTMENT NAME : &nbsp;</td>
			<td><input type="text" name="deptName" placeholder="department name" required="required"></td>
		</tr>
		<tr>
			<td><input type="submit"   value="Create"></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="index.jsp">Home</a>
</form>
</body>
</html>