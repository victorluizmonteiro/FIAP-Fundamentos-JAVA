package br.com.fiap.entity;

public class Item {

	private Integer id;
	private String descricao;
	private Double valor;
	
	
	public Item() {
		super();
	}
	public Item(Integer id, String descricao, Double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		
		return "\nCódigo do prouto : " + this.id + "\nDecrição : " + this.descricao + "\nValor : " + 
		this.valor +"\n";
	}
	
}
