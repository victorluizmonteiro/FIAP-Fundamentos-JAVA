package br.com.fiap.entity;

import java.time.LocalDateTime;
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
	
	
	

}
