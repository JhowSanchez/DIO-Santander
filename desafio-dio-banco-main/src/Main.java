import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");

		Cliente juliano = new Cliente();
		juliano.setNome("Juliano");

		Cliente otavio = new Cliente();
		otavio.setNome("Otavio");

		Cliente renato = new Cliente();
		renato.setNome("Renato");
		
		Conta cc = new ContaCorrente(juliano);
		Conta poupanca = new ContaPoupanca(juliano);

		Conta cc1 = new ContaCorrente(otavio);
		Conta poupanca1 = new ContaPoupanca(otavio);

		Conta cc2 = new ContaCorrente(renato);
		Conta poupanca2 = new ContaPoupanca(renato);

		Conta cc3 = new ContaCorrente(venilton);
		Conta poupanca3 = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		List<Conta> listaConta = new ArrayList<>();

		Banco Santander = new Banco("Santander", listaConta);
		Santander.addCliente(cc2);
		Santander.addCliente(cc);
		Santander.addCliente(cc3);
		Santander.addCliente(cc1);

		Santander.exibirListaClientes();

		Santander.excluirConta(cc1);

		Santander.exibirListaClientes();

	}

}
