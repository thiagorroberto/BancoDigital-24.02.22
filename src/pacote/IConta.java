package pacote;

public interface IConta {

	void sacar(double valor);
	
	void depositar(double valor);
	
	public void transferir(double valor, IConta contaDestino, int assinatura);
	
	void imprimirExtrato();
}
