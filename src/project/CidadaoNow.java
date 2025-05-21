package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import project.endereco.Endereco;
import project.utils.IntegracaoApi;

public class CidadaoNow {

	public static void main(String[] args)  throws Exception  {
		Scanner s = new Scanner(System.in);
		int valor = 0;
		
		System.out.println("Bem vindo ao sistema Cidad�oNow, onde seus eventos habitam");	
		
		
		System.out.println("J� � um us�ario? digite o n�mero: ( 1 ), para se cadastrar digite o n�mero: ( 2 )");
		valor = s.nextInt();
	
		if (valor == 2) {
		    criarArquivoDeUsuarios();
		 } else if (valor == 1){
			 jaCadastrado();
		 }
	}
	
	public static void criarArquivoDeUsuarios() throws Exception  {

		IntegracaoApi api = new IntegracaoApi();
		Endereco end = null;
		Endereco endereco = new Endereco();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o seu Nome: ");
	    String nome = s.next();
	    System.out.println("Digite a sua Idade: ");
	    int idade = s.nextInt();
	    System.out.println("Digite o seu Email: ");
	    String email = s.next();
	    System.out.println("Digite o seu N�mero: ");
	    String numero = s.next();
	    
	        System.out.println("Digite o seu CEP: ");
	        String cep = s.next();

	        try {
	        	end = api.buscaCep(cep);
	            if (end == null) {
	                System.out.println("CEP inv�lido. Tente novamente.");
	            }
	        } catch (Exception e) {
	            System.out.println("Erro ao buscar o CEP. Verifique sua conex�o.");
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
	        writer.write("N�mero: " + usuario.getNumero());
	        writer.newLine();
	        writer.write("Cep: " + usuario.getCep().getCep());
	        writer.newLine();
	        writer.write("----------");
	        writer.newLine();
	        System.out.println("Usu�rio salvo com sucesso!");
	    } catch (IOException e) {
	        System.out.println("Erro ao salvar usu�rio: " + e.getMessage());
	    }
	    
	    jaCadastrado();
	    
	}
	

	public static void jaCadastrado() {
		System.out.println(" voce � um Us�ario Cadastrado");
	}

}
