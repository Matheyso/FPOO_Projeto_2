package br.org.sesisp.model;

public class Produto {
	//atributos
	private int id;
	private String nome;
	private int preco;
	
	//met construto
	public Produto() {
		
	}
	
	//metodos get e set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int Preco) {
		this.preco = Preco;
	}
	
	

}
