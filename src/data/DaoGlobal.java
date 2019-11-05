package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
				listNutri.add(g.fromJson(new String(jsonElement.toString().getBytes(),"UTF-8"), Nutri.class));
			}
		}
		return listNutri;
	}

	static public Nutri getOneNutri(String id) throws IOException {
		URL url = new URL("http://localhost:8095/rest/nutri/findOne/?id="+id);
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
		return json.fromJson(new String(obj.toString().getBytes(),"UTF-8"), Nutri.class);
	}

	static public LinkedList<Nutri> getAllByNutriscore(String nutriscore) throws IOException {
		LinkedList<Nutri> listNutri = new LinkedList<Nutri>();
		URL url = new URL("http://localhost:8095/rest/nutri/allByScore/?nutriscore="+nutriscore);
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
				listNutri.add(g.fromJson(new String(jsonElement.toString().getBytes(),"UTF-8"), Nutri.class));
			}
		}
		return listNutri;
	}
}
