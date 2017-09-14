package domain.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AbstractController extends HttpServlet {
	private static final long serialVersionUID = -5390054473430572423L;

	public AbstractController() {
	  super();
	}
	
	protected void forward(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletConfig().getServletContext().
			getRequestDispatcher(jsp).forward(request, response);
	}
}
