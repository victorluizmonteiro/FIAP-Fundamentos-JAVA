package br.com.fiapmain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import br.com.fiap.entity.Cartao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.ContaCorrente;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.TipoCartao;
import br.com.fiap.exception.PaymentException;

public class Aplicacao {

	public static void main(String[] args) throws PaymentException {
		ContaCorrente contaCorrente = new ContaCorrente(1000.0);
		Cartao cartao = new Cartao(TipoCartao.DEBITO);
		Cliente cliente = new Cliente(1,"Victor","48474810892","victor.monteiro@gmail.com",LocalDate.now(),contaCorrente,cartao);
		
		Item item1 = new Item(1,"Cola",400.0);
		Item item2 = new Item(2,"Sapato",400.0);
		
		List<Item>itens = Arrays.asList(item1,item2);
		
		System.out.println(contaCorrente.getSaldo());
		cliente.reaizarPagamento(itens, cartao);
		
		System.out.println(contaCorrente.getSaldo());
	}

}
