package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		
		//endereço IP do jost remoto (server)
		InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
		
		// Canal de comunicação NÃO orientado à conexão
		// clientSocket terá uma porta designada pelo SO - entre 1024 e 65535
		DatagramSocket clientSocket = new DatagramSocket();							//SO asigna uma porta
		
		// Declaração e preenchimento do buffer de envio
		byte[] sendData = new byte[1024];
		sendData = "sou um cliente".getBytes();
		
		// Criação do datagrama com endereço e porta do host remoto 9876
		DatagramPacket sendPacket = new DatagramPacket (sendData, sendData.length, IPAdress, 9876);
	
		// Envio do datagrama ao host remoto
		clientSocket.send(sendPacket);
		System.out.println("Mensagem enviada para o servidor");
		
		// Declaração do buffer de recebimento (caso haja)
		byte[] recBuffer = new byte[1024];
		
		//criação do datagrama a ser recebido
		DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
		
		//recebimento do datagrama do host remoto (método bloqueante)
		clientSocket.receive(recPkt); 	//BLOCKING
		
		// Obtenção da ingormação vinda no datagrama
		String informacao = new String(recPkt.getData(), recPkt.getOffset(), recPkt.getLength());
		
		System.out.println("Recebido do servidor: " + informacao);
		
		//fechamento da conexão
		clientSocket.close();
		
		
	}
}
