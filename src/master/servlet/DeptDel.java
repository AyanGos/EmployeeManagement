package master.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.DepartmentDAO;

/**
 * Servlet implementation class DeptDel
 */
public class DeptDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String deptId = request.getParameter("deptId");
		
		DepartmentDAO ddao = new DepartmentDAO();
		ddao.deleteDepartment(deptId);
		
		request.setAttribute("saved", "Successfully deleted!!");
		RequestDispatcher rd=request.getRequestDispatcher("deleteDept.jsp");
		rd.forward(request, response);
	}

}
