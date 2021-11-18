
//contrato Autenticavel
	//quem assinar esse contrato, precisa implementar:
		//o metodo setSenha
		//o metodo autentica

public abstract interface Autenticavel{
	
	public abstract void setSenha(int senha);
	
	public abstract boolean autentica(int senha);
}
