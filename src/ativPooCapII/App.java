package ativPooCapII;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.dao.ClienteDao;
import model.dao.TransacaoDao;
import model.dao.CartaoDao;
import model.entity.Cliente;
import model.entity.Transacao;
import model.entity.Cartao;

public class App {

	public static String leString(String msg) {
		String valor = JOptionPane.showInputDialog(null, msg);
		return valor;
	}

	public static int menuMain() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1 - Menu cliente");
		System.out.println("2 - Menu cartão");
		System.out.println("3 - Sair");
		System.out.println(" ");
		System.out.println("Digite uma opção: ");
		Scanner input1 = new Scanner(System.in);
		return input1.nextInt();
	}
	
	public static int menu() {
		System.out.println("MENU CLIENTE");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar todos");
		System.out.println("3 - Listar por ID");
		System.out.println("4 - Sair");
		System.out.println(" ");
		System.out.print("Digite uma opção: ");
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	public static int menuCard() {
		System.out.println("MENU PRODUTO");
		System.out.println("1 - Inserir cartão");
		System.out.println("2 - Consultar cartões");
		System.out.println("3 - Inserir compra");
		System.out.println("4 - Consultar compras");
		System.out.println("5 - Consultar limite");
		System.out.println("6 - Pagar fatura");
		System.out.println("7 - Sair");
		System.out.println(" ");
		System.out.print("Digite uma opção: ");
		Scanner input2 = new Scanner(System.in);
		return input2.nextInt();
	}

	
	//----------------------------------------------------------------------------------//
	//                           MÉTODOS CLASSE CLIENTE
	//----------------------------------------------------------------------------------//
	
	public static void metodoInserir() {
		String nome = leString("Digite o nome: ");
		String doc = leString("Digite o cpf: ");
		Cliente cliente = new Cliente(nome, doc);
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.inserir(cliente);
	}
	
	public static void metodoConsultarTodos() {	
		List<Cliente> registros = new ClienteDao().consultarTodos();
		if (!registros.isEmpty()) {
			String saida = "";
			saida += "id\tnome\tcpf\n";
			for (int  i = 0; i < registros.size(); i++) {
				Cliente c = registros.get(i);
				saida += c.getId() + "\t";
				saida += c.getNome() + "\t";
				saida += c.getDoc() + "\n";
			}
			JOptionPane.showMessageDialog(null, new JTextArea(saida));
		} else {
			System.out.println("Não possui registros");
		}
	}
	
	public static Cliente metodoConsultarId() {
		String idStr = leString("Digite o ID");
		// converter de String para int
		int id = Integer.parseInt(idStr);
		ClienteDao dao = new ClienteDao();
		Cliente c = dao.consultar(id);
		return c;
	}
	
	//----------------------------------------------------------------------------------//
	//                           MÉTODOS CLASSE CARTAO
	//----------------------------------------------------------------------------------//
	
	public static void inserirCartao() {
		
		String nome_cliente = leString("Digite o primeiro nome do cliente: ");
		String nr_cartao = leString("Digite o número do cartão: ");
		String data = leString("Digite a data de validade do cartão: ");
		String limite = leString("Digite o limite do cartão: ");
		int limite1 = Integer.parseInt(limite);
		int id_cliente = 0;
		CartaoDao cartaoDao = new CartaoDao();
		id_cliente = cartaoDao.pesquisaCliente(nome_cliente);
		Cartao cartao = new Cartao(nr_cartao, data, limite1, id_cliente);
		cartaoDao.inserirCartao(cartao);
	}
	
	public static void metodoConsultarCards() {	
		List<Cartao> registros = new CartaoDao().consultarTodosCard();
		if (!registros.isEmpty()) {
			String saida = "";
			saida += "id\tnumero\tdata val\tlimite\tid cliente\n";
			for (int  i = 0; i < registros.size(); i++) {
				Cartao cr = registros.get(i);
				saida += cr.getId() + "\t";
				saida += cr.getNumCartao() + "\t";
				saida += cr.getDataVal() + "\n";
				saida += cr.getLimite() + "\n";
				saida += cr.getIdCliente() + "\n";
			}
			JOptionPane.showMessageDialog(null, new JTextArea(saida));
		} else {
			System.out.println("Não possui registros");
		}
	}
	
	public static Cartao consultarLimite() {
		String idStr = leString("Digite o ID do cliente");
		// converter de String para int
		int id = Integer.parseInt(idStr);
		CartaoDao dao = new CartaoDao();
		Cartao c = dao.consultaLimite(id);
		return c;
	}
	
	public static Cartao pagarFatura() {
		String idStr = leString("Digite o ID do cartão");
		// converter de String para int
		int id = Integer.parseInt(idStr);
		CartaoDao dao = new CartaoDao();
		Cartao c = dao.consultaLimite(id);
		return c;
	}
	
	//----------------------------------------------------------------------------------//
	//                           MÉTODOS CLASSE TRANSACAO
	//----------------------------------------------------------------------------------//
	
	public static void inserirCompra() {
		String valorStr = leString("Digite o valor da compra: ");
		String idStr = leString("Digite o ID do cartão: ");
		double valor = Double.parseDouble(valorStr);
		int id = Integer.parseInt(idStr);
		Transacao transacao = new Transacao(valor, id);
		TransacaoDao transacaoDao = new TransacaoDao();
		transacaoDao.inserirCompra(transacao);
	}
	
	public static Transacao consultarCompras() {
		String idStr = leString("Digite o ID do cartão");
		// converter de String para int
		int id = Integer.parseInt(idStr);
		TransacaoDao dao = new TransacaoDao();
		Transacao t = dao.consultarCompras(id);
		return t;
	}

	
	public static void main(String[] args) {
		int opcao;

		do {
			opcao = menuMain();
			switch (opcao) {
			case 1:

				int op;

				do {
					op = menu();
					switch (op) {
					case 1:
						metodoInserir();
						break;
					case 2:
						metodoConsultarTodos();
						break;
					case 3:
						Cliente cli = metodoConsultarId();
						String saida;
						if (cli != null) {
							saida = "id\tnome\tcpf\n";
							saida += cli.getId() + "\t";
							saida += cli.getNome() + "\t";
							saida += cli.getDoc() + "\n";
						} else {
							saida = "Registro não foi localizado!";
						}
						JOptionPane.showMessageDialog(null, new JTextArea(saida));
						break;
					case 4:
						System.out.println("Voltando ao menu principal.");
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				} while (op != 4);

				break;
			case 2:

				int opCartao;

				do {
					opCartao = menuCard();
					switch (opCartao) {
					case 1:
						inserirCartao();
						break;
					case 2:
						metodoConsultarCards();
						break;
					case 3:
						inserirCompra();
						break;
					case 4: 
						consultarCompras();
						break;
					case 5:
						consultarLimite();
					case 6:
						pagarFatura();
						break;
					case 7:
						System.out.println("Voltando ao menu principal.");
					default:
						System.out.println("Opção inválida.");
						break;
					}
				} while (opCartao != 7);

				break;
			case 3:
				System.out.println("Finalizando programa.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 3);

	}

}
