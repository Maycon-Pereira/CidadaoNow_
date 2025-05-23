package project.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import project.model.CriarEvento;

public class Login {

	public void logarUsuario(Scanner s) throws Exception {
		
		CriarEvento evento = new CriarEvento();
		
		System.out.println("--- Login ---");
		System.out.println("Digite o seu Email para logar: ");
		String logEmail = s.next();
		
        
        
    

        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linha;
            String nomeEncontrado = null;

            boolean encontrou = false;

            System.out.println("--- Buscando Usu�rio com o Email: " + logEmail + " ---");
            
            while ((linha = reader.readLine()) != null) {
            	if (linha.startsWith("Nome: ")) {
                    nomeEncontrado = linha.substring(6).trim();
                }
                if (linha.startsWith("Email: ")) {
                    String emailNoArquivo = linha.substring(7).trim();
                    if (emailNoArquivo.equalsIgnoreCase(logEmail)) {
                        encontrou = true;
                        System.out.println("Email encontrado! Bem-vindo " + nomeEncontrado);
                        evento.opcoes(s);
                        //evento.criarEvento(s);
                        break;
                    }
                }                
            }
            
            if (!encontrou) {
                System.out.println("Usu�rio n�o encontrado.");
                return;
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
	

	

}
