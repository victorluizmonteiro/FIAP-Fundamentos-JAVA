package br.com.fiap.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.fiap.entity.Cartao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.ContaCorrente;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.NotaFiscal;
import br.com.fiap.entity.TipoCartao;
import br.com.fiap.exception.PaymentException;

public class TestePagamentoDebito {

	public static void main(String[] args) throws PaymentException {
		ContaCorrente contaCorrente = new ContaCorrente(1000.0);
		Cartao cartao = new Cartao(TipoCartao.DEBITO);
		Cliente cliente = new Cliente(1,"Victor","48474810892","victor.monteiro@gmail.com",LocalDate.now(),contaCorrente,cartao);
		
		Item item1 = new Item(1,"Tênis Nike ",300.0);
		Item item2 = new Item(2,"Camisa Polo Tamanho G",200.0);
		Item item3 = new Item(3,"Calça Jeans",100.0);
		
		List<Item>itens = Arrays.asList(item1,item2,item3);
		
		System.out.println(contaCorrente.getSaldo());
		cliente.reaizarPagamento(itens, cartao);
		
		System.out.println("Saldo atual de sua conta " + contaCorrente.getSaldo());
		
		NotaFiscal notaFiscal = new NotaFiscal(1, itens, LocalDateTime.now(), cliente);
		
		notaFiscal.gerarNotaFiscal();
	
	}

}
