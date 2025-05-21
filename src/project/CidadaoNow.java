package project;

import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CidadaoNow {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int valor = 0;
		
		System.out.println("Bem vindo ao sistema Cidad�oNow, onde seus eventos habitam");	
		
		System.out.println("J� � um us�ario? digite o n�mero: ( 1 ), para se cadastrar digite o n�mero: ( 2 )");
		valor = s.nextInt();
	
		if (valor == 2) {
		    criarArquivoDeUsuarios();
		    jaCadastrado();
		 } else if (valor == 1){
			 jaCadastrado();
		 }
	}
	
	public static void criarArquivoDeUsuarios() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o seu Nome: ");
	    String nome = s.next();
	    if (nome.isEmpty() ) 
	    System.out.println("Digite a sua Idade: ");
	    int idade = s.nextInt();
	    System.out.println("Digite o seu Email: ");
	    String email = s.next();
	    System.out.println("Digite o seu N�mero: ");
	    String numero = s.next();
		
		Usuario usuario = new Usuario(nome, idade, email, numero);

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
	        writer.write("Nome: " + usuario.getNome());
	        writer.newLine();
	        writer.write("Idade: " + usuario.getIdade());
	        writer.newLine();
	        writer.write("Email: " + usuario.getEmail());
	        writer.newLine();
	        writer.write("N�mero: " + usuario.getNumero());
	        writer.newLine();
	        writer.write("----------");
	        writer.newLine();
	        System.out.println("Usu�rio salvo com sucesso!");
	    } catch (IOException e) {
	        System.out.println("Erro ao salvar usu�rio: " + e.getMessage());
	    }
	    
	}
	
	public static void jaCadastrado() {
		System.out.println(" voce � um Us�ario Cadastrado");
	}
}
