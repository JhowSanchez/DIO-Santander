
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
			throw new RuntimeException("Saque não concluido: Saldo insuficiente");
		}
		else {
			saldo -= valor;
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (valor > saldo) {
			throw new RuntimeException("Transferencia nao concluida: Saldo insuficiente");
		}
		else {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.println("Transferencia concluida: o valor " + valor + " foi transferido com sucesso para a conta " + contaDestino.getNumero() + " Agencia " + contaDestino.getAgencia());
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s%n", this.cliente.getNome());
		System.out.printf("Agencia: %d%n", this.agencia);
		System.out.printf("Numero: %d%n", this.numero);
		System.out.printf("Saldo: %.2f%n", getSaldo());
	}


	@Override
	public String toString() {
		return "Conta{" +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo +
				", cliente=" + cliente +
				'}';
	}
}
