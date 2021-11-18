package tcpdemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	
	public static void main(String[] args) throws Exception{
		
		// Tenta criar uma conex�o com o host remoto "127.0.0.1" na porta 9000
		// Socket s ter� uma porta designada pelo SO - entre 1024 e 65535
		Socket s = new Socket("127.0.0.1", 9000);
		
		// Cria a cadeia de sa�da (escrita) de informa��es do socket
		OutputStream os = s.getOutputStream();
		DataOutputStream writer = new DataOutputStream(os);
		
		// Cria a cadeia de entrada (leitura) de ingorma��es do socket
		InputStreamReader is = new InputStreamReader(s.getInputStream());
		BufferedReader reader = new BufferedReader(is);
		
		// Cria um buffer que l� informa��es do teclado
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader(System.in));
		
		//leirua do teclado
		String texto = inFromUser.readLine();	//BLOCKING
		
		// Escrita no socket (envio de informa��o ao host remoto)
		writer.writeBytes(texto + "\n");
		
		// leitura do socket (recebimento da informa��o do host remoto)
		String response = reader.readLine();  	//BLOCKING
		System.out.println("DoServidor: " + response);
		
		// Fechamento do canal
		s.close();
		
	}

}
