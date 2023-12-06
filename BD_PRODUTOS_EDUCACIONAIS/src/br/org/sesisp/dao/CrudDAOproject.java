package br.org.sesisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Produto;

public class CrudDAOproject {
		
		// CRUD C-Create R-Read D-Delete
		
		//CREATE (Inserir dados)
		public void create(Produto produto) {
			String sql = "INSERT INTO produtos(nome, preco) VALUE (?,?)";
			Connection conn = null;
			PreparedStatement p = null;
			
			try {

				conn = Conexao.CriandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				p.setString(1, produto.getNome());
				p.setInt(2, produto.getPreco());
				p.execute();
			}catch(Exception e) {
				System.out.println(conn);
				System.out.println(p);
				JOptionPane.showMessageDialog(null, "ERRO ao inserir dados! \nERRO: " + e);
			}finally {
				try {
					if(p != null);
					//p.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
	}// fim CRIATE
	//*****************************************************************
		
	//metodo U - Update
		
	public void update(Produto produto) {
		String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.CriandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, produto.getNome());
			p.setInt(2, produto.getPreco());
			p.setInt(3, produto.getId());
			p.execute();//executa instrução para gravar dados no banco
			//JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
			System.out.println("Produto atualizado com sucesso");
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "ERRO ao atualizar dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
				
	}//fim UPDATE
	//*****************************************************************
	
	//metodo R - Read
	public List<Produto> read(){
		String sql = "SELECT * FROM produtos";
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		
		try {
			conn = Conexao.CriandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			resultado = p.executeQuery();//mostra os dados da consulta sql
			while(resultado.next()) {
				Produto ver_produto = new Produto();
				//recuperar RA
				ver_produto.setId(resultado.getInt("id"));
				//recuperar o nome
				ver_produto.setNome(resultado.getString("nome"));
				//recuperar idade
				ver_produto.setPreco(resultado.getInt("preco"));
				//adicionar na lista
				produtos.add(ver_produto);
				
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO ao editar dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return produtos;
	}//fim READ
	//*****************************************************************
	
	//metodo D - Delete
	
	public boolean delete(int id) {
		String sql = "DELETE FROM produtos WHERE id = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.CriandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setInt(1, id);
			p.execute();
			//JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
			System.out.println("Produto excluido com sucesso!");
		}catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "ERRO ao Excluir dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}//fim DELETE
	//xnnwinasinxinasinx
		
		

}




















