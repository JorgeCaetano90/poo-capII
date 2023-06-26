package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Cartao;
import model.entity.Transacao;

public class TransacaoDao {

	public void inserirCompra(Transacao transacao) {
		// ABRIR CONEXÃO
		ConectaBD con = new ConectaBD();
		
		String sql = "SELECT id_cartao FROM cartao WHERE id_cartao = ?";
		Cartao cartao = null;
		int id_cartao = 0;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id_cartao);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int id_cartao1 = rs.getInt("id_cartao");
				transacao.setId_cartao(id_cartao1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		String sql_1 = "INSERT INTO transacao (valor, id_cartao, id_cartao_adic) VALUES (?, ?, NULL)";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql_1);
			pst.setDouble(1, transacao.getCompra());
			pst.setInt(2, transacao.getId_cartao());
			pst.execute();
			System.out.println("Compra realizada com sucesso.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Transacao consultarCompras(int id_cartao) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT id_transacao, valor, id_cartao FROM transacao WHERE id_cartao = ?";
		Transacao card = null;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id_cartao);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id_transacao");
				double valor = rs.getDouble("valor");
				int id_card = rs.getInt("id_cartao");
				card = new Transacao(id, valor, id_card);
				card.setId_cartao(rs.getInt("id_cartao"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return card;
	}

}
