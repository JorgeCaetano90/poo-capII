package model.entity;

import model.dao.TransacaoDao;

public class Transacao extends Cartao{
	private String estab;
	private double compra, total;

	public Transacao() {
		
	}

	public Transacao(double valor, int id) {
		
	}

	public Transacao(int id, double valor, int id_card) {
		
	}

	public void estab(String estab) {
		this.estab = estab;
	}
	
	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}
	
	public void compra (double compra) {
		if (compra > limite) {
			System.out.println("Compra não realizada. Limite excedido!");
		} else {
			limite -= compra;
			total += compra;
			System.out.println("Compra realizada!");
		}
	}
	
	public double pagarCartao() {
		return total;
	}
	
	public void inserir() {
		TransacaoDao transacaoDao = new TransacaoDao();
		transacaoDao.inserirCompra(this);
	}
}
