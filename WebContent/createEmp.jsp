<%@page import="master.DAO.DepartmentDAO"  %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EmpAddCheck" method="post">
	<table>
	<br><br>
		<span style="color:red;font-size: 15px"><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%></span>
		<span style="color:green;font-size: 15px"><%=(request.getAttribute("saved") == null) ? "" : request.getAttribute("saved")%></span>
		<br>
		<br>
		<tr>
			<td>Employee ID : &nbsp;</td>
			<td><input type="text" name="empId" placeholder="Employee id" required="required"></td>
		</tr>
		<tr>
			<td>Employee NAME : &nbsp;</td>
			<td><input type="text" name="empName" placeholder="Employee name" required="required"></td>
		</tr>
		<tr>
		<td>Department Id : </td>
		<td>
			<%
				DepartmentDAO obj = new DepartmentDAO();
				ArrayList<String> arr=new ArrayList<String>();
				arr=obj.getDeptId();
				Iterator<String> itr=arr.iterator();
				%>
				<select  name="deptId" ><%
				while(itr.hasNext()){
					String x=(String) itr.next();
				%>
			          <option value="<%=x %>"><%=x %></option>
				<%}%> </select>
		</td>
		<tr>
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