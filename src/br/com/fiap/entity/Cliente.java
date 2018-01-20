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
	private Cartao cartao;
	
	
	
	public Cliente() {
		super();
	}
	
	

	public Cliente(Integer id, String nome, String cpf, String email, LocalDate dataNascimento,
			ContaCorrente contaCorrente, Cartao cartao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.contaCorrente = contaCorrente;
		this.cartao = cartao;
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
	
	


public Cartao getCartao() {
		return cartao;
	}



public void setTipoCartao(Cartao cartao) {
		this.cartao = cartao;
	}

public void realizarPagamento(List<Item>itens,Cartao cartao) throws PaymentException {
	Double valores = itens.stream().mapToDouble(valorItens -> valorItens.getValor()).sum();
	Double desconto = 0.05;
	Double valorComDesconto = valores - (valores*desconto);
	if(isCreditCard(cartao)) {
		cartao.setFatura(valores);
	}else {
		if(this.contaCorrente.getSaldo() < valores) {
			throw new PaymentException("Saldo insuficiente");
		}
		System.out.println("Você ganhou 5% de desconto em sua compra ! ");
		System.out.println("Valor pago : " + valorComDesconto);
		this.contaCorrente.setSaldo(this.contaCorrente.getSaldo() - valorComDesconto);
		
	}
	System.out.println("Pagamento realizado com sucesso !");
	
}

	private boolean isCreditCard(Cartao cartao) {
	
		return cartao.getTipoCartao().equals(TipoCartao.CREDITO) ? true : false;
		}
	
	
	
	

}
