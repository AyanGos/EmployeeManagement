package master.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.EmployeeDAO;

/**
 * Servlet implementation class EmpAddCheck
 */
public class EmpAddCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String empId = request.getParameter("empId");
		
		EmployeeDAO edao = new EmployeeDAO();
		int flag = edao.checkEmpId(empId);
		
		if(flag==1)
		{

			request.setAttribute("error", "Employee ID already exists.");
			RequestDispatcher rd=request.getRequestDispatcher("createEmp.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("EmpAddServe");
			rd.forward(request, response);
		}
	}

}
