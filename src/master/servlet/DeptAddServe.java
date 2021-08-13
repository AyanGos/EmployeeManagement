package master.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.DepartmentDAO;
import master.DTO.DepartmentDTO;

/**
 * Servlet implementation class DeptAddServe
 */
public class DeptAddServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		
		DepartmentDTO ddto = new DepartmentDTO();
		ddto.setDeptId(deptId);
		ddto.setDeptName(deptName);
		
		DepartmentDAO ddao = new DepartmentDAO();
		ddao.insertDeptment(ddto);
		request.setAttribute("saved", "Successfully saved!!");
		RequestDispatcher rd=request.getRequestDispatcher("createDept.jsp");
		rd.forward(request, response);
	}

}
