package project.utils;

import java.io.BufferedReader;

public class JsonConversor {

	public static String converteJsonEmString(BufferedReader bufferedReader) throws Exception {
		String resposta, jsonString = "";
		while((resposta = bufferedReader.readLine()) != null) {
			jsonString += resposta;
		}
		return jsonString;
	}
}
