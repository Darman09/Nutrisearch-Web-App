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
import model.Favoris;
import model.Nutri;
import utilities.Navigation;

/**
 * Servlet implementation class Home
 */
@WebServlet("/listFavoris")
public class ListFavoris extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFavoris() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Favoris> listFav =  DaoGlobal.getAllFavoris();
		List<Nutri> listNutri = new LinkedList<>();
		for (Favoris favoris : listFav) {
			listNutri.add(DaoGlobal.getOneNutri(favoris.getIdproduit()));
		}
		request.setAttribute("favorisList", listNutri);
		Navigation.load(request, response, "listFavoris");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("button");
		String id = request.getParameter("nutriId");
		String nom = request.getParameter("modifyName");
		String grade = request.getParameter("modifyGrade");
		String packaging = request.getParameter("modifyPackaging");
		String paysOrigine = request.getParameter("modifyPaysOrigine");
		String paysVente = request.getParameter("modifyPaysVente");
		String categorie = request.getParameter("modifyCategorie");
		String ingredientDescription = request.getParameter("modifyDescription");
		String quantity = request.getParameter("modifyQuantity");
		HttpSession session = request.getSession();
		switch (button) {
		case "modify":
			Nutri n = DaoGlobal.modifyProduct(id, nom, grade, packaging, paysOrigine, paysVente, categorie, ingredientDescription, quantity);
			session.setAttribute("element", n);
			session.setAttribute("result", DaoGlobal.getAllNutri());
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
