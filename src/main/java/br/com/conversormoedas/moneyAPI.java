package br.com.conversormoedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class moneyAPI {
   
    public static String sendRequestAPI(String moedaConversora, String moedaOriginal) {
        
        // Cria o Cliente HTTP, que realizará as requisições;
        HttpClient client = HttpClient.newHttpClient();
        
        // Define o request com o URL do JSON e faz o build.
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://economia.awesomeapi.com.br/json/last/" + moedaConversora + "-" + moedaOriginal)).build();    
        
        // manda a requisição pelo Cliente HTTP, de forma assíncrona, 
        // e retorna o req.body no formato String.
        
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()) 
                .thenApply(HttpResponse::body) // retorna o body da resposta
                .thenApply(moneyAPI::parse) // aplica o método parse ao conteúdo vindo no body
                .join();  // junta tudo e retorna os dados do JSON.
    }
    
    // Faz o parse do JSON para Object.
    public static String parse(String responseBody) {
        JSONObject valor = new JSONObject(responseBody); // Transforma a resposta do body em Object
        String moedaURL = valor.toString().substring(2, 8); // Faz um substring do Objeto, para pegar o USD-URL
        
        JSONObject dadosDaMoedaConversora = valor.getJSONObject(moedaURL); // Seleciona o Objeto USDBRL
        
        return dadosDaMoedaConversora.getString("ask"); //Seleciona o valor da moedaConversora
    }
}
