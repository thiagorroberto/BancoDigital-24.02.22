package pacote;

public class Main {
	public static void main(String[] args) {
		
		Cliente jose = new Cliente();
		jose.setNome("jose");
		jose.setAssinatura(123456);
		jose.getAssinatura();
		
		Cliente thiago = new Cliente();
		thiago.setNome("thiago");
		thiago.setAssinatura(654321);
		thiago.getAssinatura();
			
		Conta cc = new ContaCorrente(thiago);
		Conta poupanca = new ContaPoupanca(jose);

		cc.depositar(100);
		cc.transferir(100, poupanca, 654321);
		cc.emprestimo(1000, 10);
			
		cc.imprimirExtrato();
		poupanca.emprestimo(500, 5);
		poupanca.imprimirExtrato();
	}
}

