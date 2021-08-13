package master.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.EmployeeDAO;

/**
 * Servlet implementation class EmpDel
 */
public class EmpDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String empId = request.getParameter("empId");
		
		EmployeeDAO edao = new EmployeeDAO();
		edao.deleteEmp(empId);
		request.setAttribute("saved", "Successfully deleted!!");
		RequestDispatcher rd=request.getRequestDispatcher("deleteEmp.jsp");
		rd.forward(request, response);
	}

}
