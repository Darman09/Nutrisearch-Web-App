package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
				session.setAttribute("result", session.getAttribute("result"));
			} else {
				session.setAttribute("result", DaoGlobal.getAllNutri());
			}
		} else {
			session.setAttribute("result", DaoGlobal.getAllNutri());
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
		String searchPaysOrigine = request.getParameter("searchPaysOrigine");
		String searchPaysVente = request.getParameter("searchPaysVente");
		HttpSession session = request.getSession();
		switch (button) {
		case "oneElement":
			session.setAttribute("element", DaoGlobal.getOneNutri(id));
			Navigation.menu(request, response, button, "home");
			break;
		case "filter":
			session.setAttribute("result",
					DaoGlobal.getAllByNutriscore(nutriscore.toLowerCase(), searchPaysOrigine, searchPaysVente));
			session.setAttribute("action", "filter");
			List<String> filters = new LinkedList<String>();
			if (nutriscore != null && nutriscore != "") {
				filters.add("Grade : " + nutriscore);
			}
			if (searchPaysVente != null && searchPaysVente != "") {
				filters.add("Pays de vente : " + searchPaysVente);
			}
			if (searchPaysOrigine != null && searchPaysOrigine != "") {
				filters.add("Pays d'origine : " + searchPaysOrigine);
			}
			request.setAttribute("filterResult", filters);
			request.setAttribute("gradeSelected", nutriscore);
			request.setAttribute("paysOrigineSelected", searchPaysOrigine);
			request.setAttribute("paysVenteSelected", searchPaysVente);
			Navigation.load(request, response, "home");
			break;
		case "delete":
			DaoGlobal.deleteProduct(id);
			session.setAttribute("action", "delete");
			Navigation.to(request, response, "home");
			break;
		case "resetFilter":
			session.setAttribute("result", DaoGlobal.getAllByNutriscore("none", "none", "none"));
			session.setAttribute("action", "filter");
			Navigation.to(request, response, "home");
		case "add":
			String nom = request.getParameter("addName");
			String grade = request.getParameter("addGrade");
			String packaging = request.getParameter("addPackaging");
			String paysOrigine = request.getParameter("addPaysOrigine");
			String paysVente = request.getParameter("addPaysVente");
			String categorie = request.getParameter("addCategorie");
			String ingredientDescription = request.getParameter("addDescription");
			String quantity = request.getParameter("addQuantity");
			DaoGlobal.addProduct(id, nom, grade, packaging, paysOrigine, paysVente, categorie, ingredientDescription,
					quantity);
			session.setAttribute("result", DaoGlobal.getAllNutri());
			Navigation.to(request, response, "home");
			break;
		case "addfavoris":
			DaoGlobal.addProductFavoris(id);
			Navigation.to(request, response, "home");
			break;
		case "listfavoris":
			DaoGlobal.getAllFavoris();
			Navigation.to(request, response, "listFavoris");
			break;
		default:
			Navigation.to(request, response, "home");
			break;
		}

		// Navigation.menu(request, response, button, "home");
	}

}
