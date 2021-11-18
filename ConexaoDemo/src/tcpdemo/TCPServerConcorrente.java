package tcpdemo;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerConcorrente {

	public static void main(String[] args) throws Exception{
		
		// Cria o mecanismo para escutar e atrender conexões pela porta 9000
		ServerSocket serverSocket = new ServerSocket(9000);
		while(true) {
			// método bloqueante que cria um novo socket com o nó
			// Socket no terá uma porta designada pelo SO - entre 1024 e 65535
			System.out.println("Esperando conexçao...");
			
			Socket no = serverSocket.accept();	//BLOCKING
			
			System.out.println("conexão aceita");
			//thread para atender o novo no
			ThreadAtendimento thread = new ThreadAtendimento(no);
			thread.start(); 	//executa a thread -> chamada ao metodo run()
			
			
		}
	}
}
