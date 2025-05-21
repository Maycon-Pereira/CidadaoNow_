package project.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import project.endereco.Endereco;

public class IntegracaoApi {

	public Endereco buscaCep(String cep) throws Exception {
		 String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(enderecoURL))
	                .build();

	        HttpResponse<String> response = client
	                .send(request, HttpResponse.BodyHandlers.ofString());

	        String json = response.body();
	        
	        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
	        if (jsonObject.has("erro") && jsonObject.get("erro").getAsBoolean()) {
	            return null; // CEP inválido
	        }
	        
	        return new Gson().fromJson(json, Endereco.class);
		
	}
}
