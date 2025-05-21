package project;

import java.time.LocalDateTime;

public class Evento {
	
	protected String nome; 
	protected String endereco;
	protected Categoria categoria;
	protected LocalDateTime horarioInicio;
	protected LocalDateTime horarioTermino;
	protected String descricao;
	
	public Evento() {}

	public Evento(String nome, String endereco, Categoria categoria, LocalDateTime horarioInicio,
			LocalDateTime horarioTermino, String descricao) {
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalDateTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalDateTime getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(LocalDateTime horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
