package project;

import java.util.Scanner;

import project.model.CriarEvento;
import project.model.CriarUsuario;
import project.utils.Login;

public class CidadaoNow {

	public static void main(String[] args)  throws Exception  {

		Scanner s = new Scanner(System.in);
		Login log = new Login();
		CriarUsuario user = new CriarUsuario();
		
		int valor = 0;
		
		CriarEvento evento = new CriarEvento();
		//evento.criarEvento(s);
		
		System.out.println("Bem vindo ao sistema Cidad�oNow, onde seus eventos habitam");	
		System.out.println("J� � um us�ario? digite o n�mero: ( 1 ), para se cadastrar digite o n�mero: ( 2 )");
		valor = s.nextInt();
	
		if (valor == 2) {
			user.criarUsuario(s);
		 } else if (valor == 1){
			 evento.opcoes(s);
			 //log.logarUsuario(s);
		 }
		s.close();
	}

}
