package testes;

public class Soma {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		
		int result = soma(x, y);
		
		
		System.out.println("A soma total deu: " + result);
		
		
	}
	
	public static int soma(int a, int b) {
		int valor = a + b;
		return valor;
	}
}
