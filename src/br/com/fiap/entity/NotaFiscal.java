package br.com.fiap.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotaFiscal {
	private Integer id;
	private List<Item>itens;
	private LocalDateTime dataNotaFiscal;
	private Cliente cliente;
	public NotaFiscal(Integer id, List<Item> itens, LocalDateTime dataNotaFiscal, Cliente cliente) {
		super();
		this.id = id;
		this.itens = itens;
		this.dataNotaFiscal = dataNotaFiscal;
		this.cliente = cliente;
	}
	public NotaFiscal() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public LocalDateTime getDataNotaFiscal() {
		return dataNotaFiscal;
	}
	public void setDataNotaFiscal(LocalDateTime dataNotaFiscal) {
		this.dataNotaFiscal = dataNotaFiscal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void gerarNotaFiscal() {
		
		System.out.println("========== LOJA DO POVO ==========");
		System.out.println("Data : " + LocalDate.now().format(DateTimeFormatter.ofPattern("DD/MM/YYYY")));
		System.out.println("\n[DADOS DO CLIENTE]");
		System.out.println("\nNome : " + this.cliente.getNome() + "\nEmail : " + this.cliente.getEmail() + "\nCPF : "+ this.cliente.getCpf());
		System.out.println("\n========== Produtos  comprados ========== ");
	 	itens.stream().forEach(u -> {
			System.out.println( "Código do Produto : " + u.getId() + "\nDescrição : " + u.getDescricao() + "\nValor : " + u.getValor());
		
		});
	 
		
	}
	

}
