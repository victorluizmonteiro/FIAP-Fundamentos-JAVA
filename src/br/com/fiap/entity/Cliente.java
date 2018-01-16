package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.exception.PaymentException;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;
	private ContaCorrente contaCorrente;
	private Cartao tipoCartao;
	
	
	
	public Cliente() {
		super();
	}
	
	

	public Cliente(Integer id, String nome, String cpf, String email, LocalDate dataNascimento,
			ContaCorrente contaCorrente, Cartao tipoCartao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.contaCorrente = contaCorrente;
		this.tipoCartao = tipoCartao;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	


public Cartao getTipoCartao() {
		return tipoCartao;
	}



public void setTipoCartao(Cartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

public void reaizarPagamento(List<Item>itens,Cartao cartao) throws PaymentException {
	Double valores = itens.stream().mapToDouble(valorItens -> valorItens.getValor()).sum();
	
	if(isCreditCard(cartao)) {
		cartao.setFatura(valores);
	}else {
		if(this.contaCorrente.getSaldo() < valores) {
			throw new PaymentException("Saldo insuficiente");
		}
		this.contaCorrente.setSaldo(this.contaCorrente.getSaldo() - valores);
	}
	
}

	private boolean isCreditCard(Cartao cartao) {
	
		return cartao.getTipoCartao().equals(TipoCartao.CREDITO) ? true : false;
		}
	

}
