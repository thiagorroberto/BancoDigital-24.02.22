package pacote;



public class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double valorMensal;
	protected double valorEmprestimo;
	protected int meses;
	protected Cliente cliente;
	protected int assinatura;
	

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	

	@Override
	public void transferir(double valor, IConta contaDestino, int assinatura) {
		if (assinatura == cliente.assinatura) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
		else {
			System.err.println("Assinatura incorreta!");
			System.exit(100);
			
		}
		
	}
	
	
	public void emprestimo(double valor, int meses) {
		valorEmprestimo = valor;
		valorMensal = (valor / meses);
		saldo += valor;
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
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Emprestimo: %.2f", this.valorEmprestimo));
		System.out.println(String.format("Valor do empréstimo cobrado mensalmente: %.2f", this.valorMensal));
		System.out.println(String.format("Saldo Total: %.2f", this.saldo));
	}

	@Override
	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		
	}
	
}
