package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DaoGlobal;
import model.Nutri;
import utilities.Navigation;

/**
 * Servlet implementation class Home
 */
@WebServlet("/oneElement")
public class OneElement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OneElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Navigation.load(request, response, "oneElement");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("button");
		String id = request.getParameter("nutriId");
		String nom = request.getParameter("modifyName"+id);
		String grade = request.getParameter("modifyGrade"+id);
		String packaging = request.getParameter("modifyPackaging"+id);
		String paysOrigine = request.getParameter("modifyPaysOrigine"+id);
		String paysVente = request.getParameter("modifyPaysVente"+id);
		String categorie = request.getParameter("modifyCategorie"+id);
		String ingredientDescription = request.getParameter("modifyDescription"+id);
		String quantity = request.getParameter("modifyQuantity"+id);
		HttpSession session = request.getSession();
		switch (button) {
		case "modify":
			Nutri n = DaoGlobal.modifyProduct(id, nom, grade, packaging, paysOrigine, paysVente, categorie, ingredientDescription, quantity);
			session.setAttribute("element", n);
			Navigation.menu(request, response, button, "oneElement");
			break;
		case "home":
			Navigation.to(request, response, "home");
			break;
		default:
			Navigation.to(request, response, "home");
			break;
		}
	}

}
