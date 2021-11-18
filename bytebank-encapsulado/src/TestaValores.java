
public class TestaValores {
	public static void main(String[] args) {
		Conta conta = new Conta(1337, 24226);
		
		
		//conta está inconsistente   

		System.out.println(conta.getAgencia());
		
		Conta conta2 = new Conta(1337, 32132);
		Conta conta3 = new Conta(1337, 18456);
		
		System.out.println("O total de contas é: " + Conta.getTotal());
	}
}
