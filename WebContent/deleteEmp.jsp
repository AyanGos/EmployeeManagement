<%@page import="java.util.*" %>
<%@page import="master.DAO.EmployeeDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EmpDel" method="post">
	<table style="margin-top: 65px">
		<span style="color:green;font-size: 15px"><%=(request.getAttribute("saved") == null) ? "" : request.getAttribute("saved")%></span>
		<tr>
		<td>Employee ID : </td>
		<td>
			<%
			    EmployeeDAO obj = new EmployeeDAO();
				ArrayList<String> arr=new ArrayList<String>();
				arr=obj.getEmpId();
				Iterator<String> itr=arr.iterator();
				%>
				<select  name="empId" ><%
				while(itr.hasNext()){
					String x=(String) itr.next();
				%>
			          <option value="<%=x %>"><%=x %></option>
				<%}%> </select>
		</td>
		</tr>
		<tr>
			<td><input type="submit"   value="Delete"></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="index.jsp">Home</a>
</form>

</body>
</html>