package project;

import project.endereco.Endereco;

public class Usuario {

    protected String nome;
    protected int idade;
    protected String email;
    protected String numero;
    protected Endereco cep;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, int idade, String email, String numero, Endereco cep) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.numero = numero;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco getCep() {
		return cep;
	}

	public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
	public void setCep(Endereco cep) {
		this.cep = cep;
	}

}
