package br.com.fiap.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import br.com.fiap.entity.Cartao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Item;
import br.com.fiap.entity.NotaFiscal;
import br.com.fiap.entity.TipoCartao;
import br.com.fiap.exception.PaymentException;

public class TestePagamentoCredito {

	public static void main(String[] args) throws PaymentException, IOException, InterruptedException {
	

		
		LocalDate dataNascimento = LocalDate.of(1997, Month.JUNE, 1);
		
		Cartao cartao = new Cartao(TipoCartao.CREDITO);
		Cliente cliente = new Cliente(1,"Marcos","48474410896","marcos@gmail.com",dataNascimento,null,cartao);
		
		Item item1 = new Item(1,"Video Game ",1000.0);
		Item item2 = new Item(2,"Chuteira de campo tamanho 42",800.0);
		Item item3 = new Item(3,"Perfume 100ML",100.0);
		
		List<Item>itens = Arrays.asList(item1,item2,item3);
		
		
		cliente.realizarPagamento(itens, cartao);
		
		
		
		NotaFiscal notaFiscal = new NotaFiscal(1, itens, LocalDateTime.now(), cliente);
		
		notaFiscal.gerarNotaFiscal(cartao);
		
		System.out.println("Total gasto : " + cartao.getFatura());
	}

}
