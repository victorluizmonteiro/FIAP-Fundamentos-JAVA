package br.com.fiap.entity;

import java.io.FileWriter;
import java.io.IOException;
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
	
	public void gerarNotaFiscal(Cartao cartao) throws IOException {
		  String   LOJA = "========== LOJA DO POVO ==========";
		  String  DATA = "Data : " + LocalDate.now().format(DateTimeFormatter.ofPattern("DD/MM/YYYY"));
		  String  LABEL_CLIENTE = "\n[DADOS DO CLIENTE]";
		  String  FORMA_PAGAMENTO = "\nForma de Pagamento : " + cliente.getCartao().getTipoCartao().name();
		  String  DADOS_CLIENTE = "\nNome : " + cliente.getNome() + "\nCPF : " + cliente.getCpf() + "\nEmail : "+ cliente.getEmail();
		  String DESCRICAO_PRODUTOS = "\n========== Produtos Comprados ==========";
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(LOJA);
				System.out.println(DATA);
				System.out.println(LABEL_CLIENTE);
				System.out.println(DADOS_CLIENTE);
				System.out.println(FORMA_PAGAMENTO);
				System.out.println(DESCRICAO_PRODUTOS);
			 	itens.stream().forEach(System.out::println);
				
			}
		};
		
	 	Runnable r2 = new Runnable() {
		 	String path = cartao.getTipoCartao().equals(TipoCartao.CREDITO) ? "arquivos/notaFiscalCredito.txt" : "arquivos/NotaFiscalDebito.txt" ;

			@Override
			public void run() {
				FileWriter file;
				try {
					file = new FileWriter(path);
					file.write(LOJA);
					file.write(DATA);
					file.write(LABEL_CLIENTE);	
					file.write(DADOS_CLIENTE);
					file.write(FORMA_PAGAMENTO);
					file.write(DESCRICAO_PRODUTOS);
					itens.forEach(u -> {
						try {
							file.write(u.toString());
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					});
					System.out.println("Nota fiscal gerada !, conferir em sua pasta arquivos !");
					file.flush();
					file.close();
				 
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		};
		new Thread(r1).start();
		new Thread(r2).start();
		
	 	
	 	
	 	
		
	}

}
