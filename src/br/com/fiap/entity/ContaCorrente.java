package br.com.fiap.entity;

public class ContaCorrente {
	
	private Double saldo = 4000.0;
	
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public ContaCorrente() {}
	public ContaCorrente(Double saldo) {
		super();
		this.saldo = saldo;
	}
	
	
	
	
	

}
