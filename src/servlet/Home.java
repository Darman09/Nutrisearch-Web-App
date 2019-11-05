package servlet;

import java.io.IOException;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("action") != null) {
			if (session.getAttribute("action").equals("filter")) {
				request.setAttribute("result", session.getAttribute("result"));
			} else {
				request.setAttribute("result", DaoGlobal.getAllNutri());
			}
		} else {
			request.setAttribute("result", DaoGlobal.getAllNutri());
		}
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
		String nutriscore = request.getParameter("grade");
		HttpSession session = request.getSession();
		switch (button) {
		case "oneElement":
			session.setAttribute("element", DaoGlobal.getOneNutri(id));
			Navigation.menu(request, response, button, "home");
			break;
		case "filter":
			session.setAttribute("result", DaoGlobal.getAllByNutriscore(nutriscore.toLowerCase()));
			session.setAttribute("action", "filter");
			Navigation.load(request, response, "home");
			break;
		case "delete":
			DaoGlobal.deleteProduct(id);
			Navigation.to(request, response, "home");
			break;
		default:
			Navigation.to(request, response, "home");
			break;
		}

		// Navigation.menu(request, response, button, "home");
	}

}
