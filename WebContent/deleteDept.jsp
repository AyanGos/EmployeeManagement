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
<form action="DeptDel" method="post">
	<table style="margin-top: 65px">
		<span style="color:green;font-size: 15px"><%=(request.getAttribute("saved") == null) ? "" : request.getAttribute("saved")%></span>
		<tr>
		<td>Department ID : </td>
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
			<td><input type="submit"   value="Delete"></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="index.jsp">Home</a>
</form>
</body>
</html>