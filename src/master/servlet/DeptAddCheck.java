package master.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.DepartmentDAO;

/**
 * Servlet implementation class DeptAddCheck
 */
public class DeptAddCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		DepartmentDAO ddao = new DepartmentDAO();
		
		String deptId = request.getParameter("deptId");
		int flag = ddao.checkDeptId(deptId);
		
		if(flag==1)
		{

			request.setAttribute("error", "Department ID already exists.");
			RequestDispatcher rd=request.getRequestDispatcher("createDept.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("DeptAddServe");
			rd.forward(request, response);
		}
	}

}
