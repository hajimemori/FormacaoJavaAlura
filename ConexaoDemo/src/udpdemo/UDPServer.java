package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws Exception{
		
		//canal de comunica��o N�O orientado � conex�o na porta 9876
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		while(true) {
			// Declara��o do buffer de recebimento
			byte[] recBuffer = new byte[1024];
			
			// Cria��o do datagrama a ser recebido
			DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
			
			System.out.println("Esperando alguma mensagem...");
			
			// recebimento do datagrama do host remoto (m�todo bloqueante)
			serverSocket.receive(recPkt);	//BLOCKING
			
			//DECLARA��O E PREENCHIMENTO DO BUFFER DE ENVIO
			byte[] sendBuf = new byte[1024];
			sendBuf = "Sou o servidor".getBytes();
			
			//para descobrir o IPAdress do cliente e a porta do cliente:
			InetAddress IPAdress = recPkt.getAddress();
			int port = recPkt.getPort();
			
			//cria�o do datagrama a ser enviado (como resposta ao cliente)
			DatagramPacket sendPkt = new DatagramPacket(sendBuf, sendBuf.length, IPAdress, port);
			
			// envio do datagrama ao cliente
			serverSocket.send(sendPkt);
			System.out.println("Mensagem enviada pelo server...");
				
		}
		
		//fechamento da conex�o 
		//serverSocket.close();
		
	}
}
