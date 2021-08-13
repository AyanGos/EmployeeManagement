package master.DAO;

import java.sql.*;
import java.util.*;

import master.DTO.DepartmentDTO;
import master.utilities.ConnectionFactory;

public class DepartmentDAO {
	
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	String selectId ="select deptid from dept";
	String insertDept = "insert into dept values(?,?)";
	String deleteDept = "delete from dept where deptid=?";
	String getName = "select deptname from dept";
	
	ConnectionFactory obj = new ConnectionFactory();
	Connection cn = obj.getCon();
	
	public void insertDeptment(DepartmentDTO ddto) {
		
		try {
			ps=cn.prepareStatement(insertDept);
			ps.setString(1, ddto.getDeptId());
			ps.setString(2, ddto.getDeptName());
			ps.executeUpdate();
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		obj.releaseConnectionSourcePS(rs, ps, cn);
	}
	
	public void deleteDepartment(String deptId) {
		
		try {
			ps = cn.prepareStatement(deleteDept);
			ps.setString(1, deptId);
			ps.executeUpdate();
			cn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		obj.releaseConnectionSourcePS(rs, ps, cn);
	}
	
	public int checkDeptId(String deptId) {
		int flag=0;
		
		try {
			st=cn.createStatement();
			rs=st.executeQuery(selectId);
			while(rs.next()) {
				if(rs.getString(1).equals(deptId)) {
					flag=1;
					break;
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		obj.releaseConnectionSourceST(rs, st, cn);
		return flag;
	}
	public ArrayList<String> getDeptId() {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			st = cn.createStatement();
			rs=st.executeQuery(selectId);
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
