package br.org.sesisp.view;

import br.org.sesisp.dao.CrudDAOproject;
import br.org.sesisp.model.Produto;
import java.util.Scanner;

public class TelaMain {

	public static void main(String[] args) {
		//instanciar um objeto da classe CrudDAO
		CrudDAOproject inserirProduto = new CrudDAOproject();
		//instanciar um objeto aluno
		Produto pro1 = new Produto();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Bem Vindo(a) ao carrinho da Liberton!");


		
		int opcaoDados;
		do {
			System.out.println("\nO que voce quer fazer?");
			System.out.println("\n1 - Adicionar Produto");
			System.out.println("2 - Atualizar Produto");
			System.out.println("3 - Excluir Produto");
			System.out.println("4 - Produtos Adicionados");
			System.out.println("0 - Fechar Pedido");
			opcaoDados = entrada.nextInt();
			
			switch(opcaoDados){
			case 1:
				System.out.println("Informe o nome do produto: ");
				pro1.setNome(entrada.next());
				System.out.println("Informe o preco do produto");
				pro1.setPreco(entrada.nextInt());
				inserirProduto.create(pro1);
				System.out.println("Produto Adicionado!");
			break;
			case 2:
				//************************************************
				//Atualizar Valores
				System.out.println("Lista de produtos disponiveis para atualizacao: ");
				for(Produto vassoura : inserirProduto.read()) {
					System.out.println("");
					System.out.println("Dados do produto: \n" + "ID - " + vassoura.getId() + "\nNome - " + vassoura.getNome() + "\nPreco - " + vassoura.getPreco());
				}
				System.out.println("Informe o ID do Produto que deseja atualizar");
				pro1.setId(entrada.nextInt());
				System.out.println("Informe o novo nome: ");
				pro1.setNome(entrada.next());
				System.out.println("Informe a nova preco: ");
				pro1.setPreco(entrada.nextInt());

				inserirProduto.update(pro1);
				System.out.println("Produto atualizado!");
				System.out.println("Nome: " + pro1.getNome());
				System.out.println("Preco: " + pro1.getPreco());

			break;
			case 3: 
				//************************************************
				//excluir dados
				System.out.println("Lista de produtos disponiveis para exclusao: ");
				for(Produto vassoura : inserirProduto.read()) {
					System.out.println("");
					System.out.println("Dados do Produto: \n" + "ID - " + vassoura.getId() + "\nNome - " + vassoura.getNome() + "\nPreco - " + vassoura.getPreco());
				}
				System.out.println("\nInsira o ID do Produto que deseja excluir: ");
				CrudDAOproject remover_aluno = new CrudDAOproject();
				remover_aluno.delete(entrada.nextInt());
			break;
			case 4: 
				//************************************************
				//ler tabela alunos do BD
				for(Produto vassoura : inserirProduto.read()) {
					System.out.println("");
					System.out.println("Dados do Produto: \n" + "ID - " + vassoura.getId() + "\nNome - " + vassoura.getNome() + "\nPreco - " + vassoura.getPreco());
				}
			break;
			case 0:
				System.out.println("O programa encerrou!");
			break;
			}
		}while(opcaoDados != 0);

		

		
		


	}

}

