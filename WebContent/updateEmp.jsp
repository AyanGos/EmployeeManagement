<%@page import="java.util.*" %>
<%@page import="master.DAO.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
<form action="UpdateEmp" method="post">
	<table>
	<br><br>
		<span style="color:green;font-size: 15px"><%=(request.getAttribute("saved") == null) ? "" : request.getAttribute("saved")%></span>
		<br>
		<br>
		<tr>
		<td>Employee ID : </td>
		<td>
			<%
			    EmployeeDAO obj1 = new EmployeeDAO();
				ArrayList<String> arr1=new ArrayList<String>();
				arr1=obj1.getEmpId();
				Iterator<String> itr1=arr1.iterator();
				%>
				<select  name="empId" ><%
				while(itr1.hasNext()){
					String x=(String) itr1.next();
				%>
			          <option value="<%=x %>"><%=x %></option>
				<%}%> </select>
		</td>
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
					String x1=(String) itr.next();
				%>
			          <option value="<%=x1 %>"><%=x1 %></option>
				<%}%> </select>
		</td>
		<tr>
		<tr>
			<td><input type="submit"   value="Update"></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="index.jsp">Home</a>
</form>
</body>
</html>