package ProjetoSD;

public abstract class Mensagem {

	public void joinOk(String IPporta, String arquivos[]) {
		System.out.printf("Sou o peer "+ IPporta + " com os arquivos ");
		for(int i = 0; i<arquivos.length; i++) {
			System.out.printf(arquivos[i] + " ");
		}
		System.out.println("");
	}
	
	public void search(String IPporta[]) {
		System.out.println("Peers com arquivo solicitado: ");
		for(int i = 0; i<IPporta.length; i++) {
			System.out.printf(IPporta[i] + " ");
			System.out.println("");
		}
	}
	
	public void recebido(String arquivo, String pasta) {
		System.out.println("Arquivo " + arquivo + " recebido com sucesso na pasta " + pasta + ".");
	}
	
	public void download_negado (String IPporta, String novo_IPporta) {
		System.out.println("peer " + IPporta +  " negou o download, pedindo agora para o peer " + novo_IPporta + ".");
	}
	
	public static void menu() {
		System.out.println("Escolha uma das opções: ");
		System.out.println("1- JOIN ");
		System.out.println("2- SEARCH ");
		System.out.println("3- DOWNLOAD ");
		
	}
	
	
	
}
