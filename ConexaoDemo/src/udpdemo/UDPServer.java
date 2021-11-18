package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws Exception{
		
		//canal de comunicação NÃO orientado à conexão na porta 9876
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		while(true) {
			// Declaração do buffer de recebimento
			byte[] recBuffer = new byte[1024];
			
			// Criação do datagrama a ser recebido
			DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
			
			System.out.println("Esperando alguma mensagem...");
			
			// recebimento do datagrama do host remoto (método bloqueante)
			serverSocket.receive(recPkt);	//BLOCKING
			
			//DECLARAÇÃO E PREENCHIMENTO DO BUFFER DE ENVIO
			byte[] sendBuf = new byte[1024];
			sendBuf = "Sou o servidor".getBytes();
			
			//para descobrir o IPAdress do cliente e a porta do cliente:
			InetAddress IPAdress = recPkt.getAddress();
			int port = recPkt.getPort();
			
			//criaão do datagrama a ser enviado (como resposta ao cliente)
			DatagramPacket sendPkt = new DatagramPacket(sendBuf, sendBuf.length, IPAdress, port);
			
			// envio do datagrama ao cliente
			serverSocket.send(sendPkt);
			System.out.println("Mensagem enviada pelo server...");
				
		}
		
		//fechamento da conexão 
		//serverSocket.close();
		
	}
}
