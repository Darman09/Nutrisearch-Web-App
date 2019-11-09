package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Favoris;
import model.Nutri;

public class DaoGlobal {

	static public LinkedList<Nutri> getAllNutri() throws IOException {
		LinkedList<Nutri> listNutri = new LinkedList<Nutri>();
		URL url = new URL("http://localhost:8095/rest/nutri/all");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			JsonArray array = (JsonArray) parser.parse(output);
			for (JsonElement jsonElement : array) {
				Gson g = new Gson();
				listNutri.add(g.fromJson(new String(jsonElement.toString().getBytes(), "UTF-8"), Nutri.class));
			}
		}
		return listNutri;
	}

	static public Nutri getOneNutri(String id) throws IOException {
		URL url = new URL("http://localhost:8095/rest/nutri/findOne/?id=" + id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		JsonObject obj = new JsonObject();
		Gson json = new Gson();
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			obj = (JsonObject) parser.parse(output);
		}
		return json.fromJson(new String(obj.toString().getBytes(), "UTF-8"), Nutri.class);
	}

	static public LinkedList<Nutri> getAllByNutriscore(String nutriscore, String searchPaysVente,
			String searchPaysOrigine) throws IOException {
		LinkedList<Nutri> listNutri = new LinkedList<Nutri>();
		if (nutriscore != null && nutriscore != "none") {

		} else {
			nutriscore = "";
		}
		if (searchPaysVente != null && !searchPaysVente.isEmpty()) {

		} else {
			searchPaysVente = "none";
		}
		if (searchPaysOrigine != null && !searchPaysOrigine.isEmpty()) {

		} else {
			searchPaysOrigine = "none";
		}
		URL url = new URL(
				"http://localhost:8095/rest/nutri/allByElement/?nutriscore=" + URLEncoder.encode(nutriscore, "UTF-8")
						+ "&paysOrigine=" + URLEncoder.encode(searchPaysOrigine, "UTF-8") + "&paysVente="
						+ URLEncoder.encode(searchPaysVente, "UTF-8"));
		System.out.println(url.getPath());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			JsonArray array = (JsonArray) parser.parse(output);
			for (JsonElement jsonElement : array) {
				Gson g = new Gson();
				listNutri.add(g.fromJson(new String(jsonElement.toString().getBytes(), "UTF-8"), Nutri.class));
			}
		}
		return listNutri;
	}

	static public LinkedList<Favoris> getFavorisByProductId(String id) throws IOException {
		LinkedList<Favoris> listFav = new LinkedList<Favoris>();
		URL url = new URL("http://localhost:8095/rest/favoris/findByIdProduct/?idproduit=" + id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			JsonArray array = (JsonArray) parser.parse(output);
			for (JsonElement jsonElement : array) {
				Gson g = new Gson();
				listFav.add(g.fromJson(new String(jsonElement.toString().getBytes(), "UTF-8"), Favoris.class));
			}
		}
		return listFav;
	}

	static public void deleteProduct(String id) throws IOException {
		URL url = new URL("http://localhost:8095/rest/nutri/delete/?id=" + id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		List<Favoris> listFav = DaoGlobal.getFavorisByProductId(id);
		for (Favoris favoris : listFav) {
			DaoGlobal.deleteFavoris(favoris.getId());
		}
	}

	static public void deleteFavoris(String id) throws IOException {
		URL url = new URL("http://localhost:8095/rest/favoris/delete/?id=" + id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
	}

	static public Nutri modifyProduct(String id, String nom, String grade, String packaging, String paysOrigine,
			String paysVente, String categorie, String ingredientDescription, String quantity) throws IOException {
		String data = "http://localhost:8095/rest/nutri/modify/?id=" + URLEncoder.encode(id, "UTF-8") + "&nom="
				+ URLEncoder.encode(nom, "UTF-8") + "&grade=" + URLEncoder.encode(grade, "UTF-8") + "&packaging="
				+ URLEncoder.encode(packaging, "UTF-8") + "&paysOrigine=" + URLEncoder.encode(paysOrigine, "UTF-8")
				+ "&paysVente=" + URLEncoder.encode(paysVente, "UTF-8") + "&categorie="
				+ URLEncoder.encode(categorie, "UTF-8") + "&ingredientDescription="
				+ URLEncoder.encode(ingredientDescription, "UTF-8") + "&quantity="
				+ URLEncoder.encode(quantity, "UTF-8");
		URL url = new URL(data);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException(
					"Failed : HTTP error code : " + conn.getResponseCode() + " | " + conn.getResponseMessage());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		JsonObject obj = new JsonObject();
		Gson json = new Gson();
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			obj = (JsonObject) parser.parse(output);
		}
		return json.fromJson(new String(obj.toString().getBytes(), "UTF-8"), Nutri.class);
	}

	static public Nutri addProduct(String id, String nom, String grade, String packaging, String paysOrigine,
			String paysVente, String categorie, String ingredientDescription, String quantity) throws IOException {
		String data = "http://localhost:8095/rest/nutri/add/?&nom=" + URLEncoder.encode(nom, "UTF-8") + "&grade="
				+ URLEncoder.encode(grade, "UTF-8") + "&packaging=" + URLEncoder.encode(packaging, "UTF-8")
				+ "&paysOrigine=" + URLEncoder.encode(paysOrigine, "UTF-8") + "&paysVente="
				+ URLEncoder.encode(paysVente, "UTF-8") + "&categorie=" + URLEncoder.encode(categorie, "UTF-8")
				+ "&ingredientDescription=" + URLEncoder.encode(ingredientDescription, "UTF-8") + "&quantity="
				+ URLEncoder.encode(quantity, "UTF-8");
		URL url = new URL(data);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException(
					"Failed : HTTP error code : " + conn.getResponseCode() + " | " + conn.getResponseMessage());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		JsonObject obj = new JsonObject();
		Gson json = new Gson();
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			obj = (JsonObject) parser.parse(output);
		}
		return json.fromJson(new String(obj.toString().getBytes(), "UTF-8"), Nutri.class);
	}

	static public void addProductFavoris(String id) throws IOException {
		String data = "http://localhost:8095/rest/favoris/add/?idproduit=" + id;
		URL url = new URL(data);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException(
					"Failed : HTTP error code : " + conn.getResponseCode() + " | " + conn.getResponseMessage());
		}
	}

	static public LinkedList<Favoris> getAllFavoris() throws IOException {
		LinkedList<Favoris> listFav = new LinkedList<Favoris>();
		URL url = new URL("http://localhost:8095/rest/favoris/all");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JsonParser parser = new JsonParser();
			JsonArray array = (JsonArray) parser.parse(output);
			for (JsonElement jsonElement : array) {
				Gson g = new Gson();
				listFav.add(g.fromJson(new String(jsonElement.toString().getBytes(), "UTF-8"), Favoris.class));
			}
		}
		return listFav;
	}
}
