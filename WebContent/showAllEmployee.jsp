<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="master.utilities.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="functions.js"></script>  
</head>
<body>
<h1 style="margin-top: 20px;margin-bottom: -20px;">Employee List</marquee></h1>
  <br>
  <div>
    <div>
        <h2> Select Field name and Search </h2>
        <select name="category" id="category">
          <option value ="1"> Employee Id </option>
          <option value="2">Employee Name</option>
          <option value="3">Department Id</option>
        </select>
        <input type="text" name="branch_name" id="branch_name" placeholder="&#128269 Search here ..."
          onkeyup="searchTable('branch_name')">
        <br><br>
        <table id="myTable" class="table_style_1">
          <thead>
            <tr style="text-align: center;">
              <th onclick="sortTable(0)" style="width: 150px;">Sl No</th>
              <th onclick="sortTable(0)" style="width: 150px;">Employee Id</th>
              <th onclick="sortTable(1)" style="width:185px;">Employee Name</th>
              <th onclick="sortTable(2)" style="width:185px;">Department Id</th>
             </tr>
          </thead>
          <tbody>
          <%
          	ConnectionFactory obj = new ConnectionFactory();
            Connection cn = obj.getCon();
            Statement st = null;
            ResultSet rs = null;
            
            try {
            	st = cn.createStatement();
            	rs = st.executeQuery("Select * from emp");
            	int x=1;
            	while(rs.next()) {
            		%>
            <tr style="text-align: center;">
              <td style="width:150px;"><%=x++%></td>
              <td style="width:150px;"><%=rs.getString(1) %></td>
              <td style="width:185px;"><%=rs.getString(2) %></td>
              <td style="width:182px;"><%=rs.getString(3) %></td>
            </tr>
            <%
            	}
            } catch (SQLException se) {
            	se.printStackTrace();
            }
            obj.releaseConnectionSourceST(rs, st, cn);
            %>
          </tbody>
        </table>
    </div>
  </div>
<a href="index.jsp">Home</a>
</body>

</html>