package domain.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SampleController extends AbstractController {
	private static final long serialVersionUID = -4287804135213080088L;

	public SampleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = getSession(request);
		HttpSession session = request.getSession();
		session.setAttribute("S1", "S1Value");
		
		Cookie cookie = new Cookie("visited", "1");
		response.addCookie(cookie);
		
		forward("/jsp/sample.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
