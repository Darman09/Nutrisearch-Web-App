package servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DaoGlobal;
import utilities.Navigation;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listElement", DaoGlobal.getAllNutri());
		Navigation.load(request, response, "home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("button");
		String id = request.getParameter("nutriId");
		HttpSession session = request.getSession();
		switch (button) {
		case "oneElement":
			session.setAttribute("element", DaoGlobal.getOneNutri(id));
			Navigation.menu(request, response, button, "home");
			break;
		default:
			session.setAttribute("action", "search");
			session.setAttribute("action", "search");
			Navigation.load(request, response, "home");
			break;
		}

		// Navigation.menu(request, response, button, "home");
	}

}
