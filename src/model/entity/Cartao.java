package model.entity;

public class Cartao extends Cliente{
	private int id_cartao;
	private String numCartao, dataVal;
	protected double limite;
	public boolean geraCartao;
	
	public Cartao() {
		
	}
	
	public Cartao(String nome, String doc, String numCartao, String dataVal, double limite) {
		super(nome, doc);
		this.numCartao = numCartao;
		this.dataVal = dataVal;
		this.limite = limite;
	}

	public Cartao(int id, double valor, int id_card) {
		
	}

	public Cartao(int id, String nome, String numero, double limite2) {
		
	}

	public Cartao(String nr_cartao, String data, int limite1) {
		
	}

	public Cartao(int id, double valor) {
	
	}


	public Cartao(String nr_cartao, String data, int limite1, int id_cliente) {
		
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getDataVal() {
		return dataVal;
	}

	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void geraCartao() {
		geraCartao = true;
		System.out.println("Novo cartão de crédito gerado.");
	}

	public int getId_cartao() {
		return id_cartao;
	}

	public void setId_cartao(int id_cartao) {
		this.id_cartao = id_cartao;
	}

	public void setIdCliente(int id_cliente) {
		
		
	}

	public String getIdCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNomeCliente(String nomeCliente) {
		// TODO Auto-generated method stub
		
	}

}

