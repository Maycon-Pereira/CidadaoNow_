package project.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import project.Usuario;
import project.endereco.Endereco;
import project.utils.IntegracaoApi;
import project.utils.Login;

public class CriarUsuario {

	public void criarUsuario(Scanner s) throws Exception  {
			
		Login log = new Login();
		IntegracaoApi api = new IntegracaoApi();
		
			Endereco end = null;
			
			System.out.println("Digite o seu Nome: ");
		    String nome = s.next();
		    System.out.println("Digite a sua Idade: ");
		    int idade = s.nextInt();
		    s.nextLine();
		    System.out.println("Digite o seu Email: ");
		    String email = s.next();
		    System.out.println("Digite o seu Número: ");
		    String numero = s.next();
		    
		        System.out.println("Digite o seu CEP: ");
		        String cep = s.next();
	
		        try {
		        	end = api.buscaCep(cep);
		            if (end == null) {
		                System.out.println("CEP inválido. Tente novamente.");
		            }
		        } catch (Exception e) {
		            System.out.println("Erro ao buscar o CEP. Verifique sua conexão.");
		            return;
		        }
		    
		    Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setIdade(idade);
			usuario.setEmail(email);
			usuario.setNumero(numero);
			usuario.setCep(end);
	
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
		        writer.write("Nome: " + usuario.getNome());
		        writer.newLine();
		        writer.write("Idade: " + usuario.getIdade());
		        writer.newLine();
		        writer.write("Email: " + usuario.getEmail());
		        writer.newLine();
		        writer.write("Número: " + usuario.getNumero());
		        writer.newLine();
		        writer.write("Cep: " + usuario.getCep().getCep());
		        writer.newLine();
		        writer.write("----------");
		        writer.newLine();
		        System.out.println("Usuário salvo com sucesso!");
		    } catch (IOException e) {
		        System.out.println("Erro ao salvar usuário: " + e.getMessage());
		    }
		    log.logarUsuario(s);
		    
		}

}
