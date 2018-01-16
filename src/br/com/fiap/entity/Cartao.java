package br.com.fiap.entity;

public class Cartao {
	
	private TipoCartao tipoCartao;
	private Double fatura;
	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public Double getFatura() {
		return fatura;
	}
	public void setFatura(Double fatura) {
		this.fatura = fatura;
	}
	
	
	public Cartao(TipoCartao tipoCartao) {
		super();
		this.tipoCartao = tipoCartao;
	}
	public Cartao(TipoCartao tipoCartao, Double fatura) {
		super();
		this.tipoCartao = tipoCartao;
		this.fatura = fatura;
	}
	
	
	
	

}
