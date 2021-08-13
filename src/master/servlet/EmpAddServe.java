package master.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.EmployeeDAO;
import master.DTO.EmployeeDTO;

/**
 * Servlet implementation class EmpAddServe
 */
public class EmpAddServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String empId=request.getParameter("empId");
		String empName = request.getParameter("empName");
		String deptId = request.getParameter("deptId");
		
		EmployeeDTO edto = new EmployeeDTO();
		edto.setEmpId(empId);
		edto.setEmpName(empName);
		edto.setDeptId(deptId);
		
		EmployeeDAO edao = new EmployeeDAO();
		edao.insertEmp(edto);
		request.setAttribute("saved", "Successfully saved!!");
		RequestDispatcher rd=request.getRequestDispatcher("createEmp.jsp");
		rd.forward(request, response);
	}

}
