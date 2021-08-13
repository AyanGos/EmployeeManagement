package master.DAO;

import java.sql.*;
import java.util.*;

import master.DTO.EmployeeDTO;
import master.utilities.ConnectionFactory;

public class EmployeeDAO {

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	String getId = "select empid from emp where empid=?";
	String insert = "insert into emp values(?,?,?)";
	String select = "select empid from emp";
	String delete = "delete from emp where empid=?";
	String update = "update emp set empname=?,deptid=? where empid=?";
	
	ConnectionFactory obj = new ConnectionFactory();
	Connection cn = obj.getCon();
	
	public void insertEmp(EmployeeDTO edto) {
		
		try {
			ps=cn.prepareStatement(insert);
			ps.setString(1, edto.getEmpId());
			ps.setString(2, edto.getEmpName());
			ps.setString(3, edto.getDeptId());
			ps.executeUpdate();
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmp(String empId) {
		
		try {
			ps=cn.prepareStatement(delete);
			ps.setString(1, empId);
			ps.executeUpdate();
			cn.commit();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		obj.releaseConnectionSourcePS(rs, ps, cn);
	}
	
	public void updateEmp(EmployeeDTO edto) {
		
		try {
			ps = cn.prepareStatement(update);
			ps.setString(1, edto.getEmpName());
			ps.setString(2, edto.getDeptId());
			ps.setString(3, edto.getEmpId());
			ps.executeUpdate();
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		obj.releaseConnectionSourcePS(rs, ps, cn);
	}
	
	public int checkEmpId(String empId) {
		
		int flag =0;
		try {
			ps = cn.prepareStatement(getId);
			ps.setString(1, empId);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag=1;
			}
		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}
		obj.releaseConnectionSourcePS(rs, ps, cn);
		return flag;
	}
	public ArrayList<String> getEmpId() {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(select);
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
			
		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}
		return arr;
	}
}


