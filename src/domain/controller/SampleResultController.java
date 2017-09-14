package domain.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.database.DBConnection;
import app.database.DBConnectionFactory;
import domain.model.SampleModel;

public class SampleResultController extends AbstractController {
	private static final long serialVersionUID = -4287804135213080088L;

	public SampleResultController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SampleModel model = new SampleModel();
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		HttpSession session = request.getSession();
		String s1 = (String) session.getAttribute("S1");
		request.setAttribute("day", s1);
				
		//request.setAttribute("yyyymmdd", model.catString(year, month, day));
		
		DBConnection con = null;
		List<Map<String,String>> userList = null;
		try {
			con = DBConnectionFactory.getConnection();
			userList = model.getUserList(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally  {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("userList", userList);
		forward("/jsp/sample_result.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
