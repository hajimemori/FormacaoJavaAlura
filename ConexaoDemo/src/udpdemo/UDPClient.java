package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		
		//endere�o IP do jost remoto (server)
		InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
		
		// Canal de comunica��o N�O orientado � conex�o
		// clientSocket ter� uma porta designada pelo SO - entre 1024 e 65535
		DatagramSocket clientSocket = new DatagramSocket();							//SO asigna uma porta
		
		// Declara��o e preenchimento do buffer de envio
		byte[] sendData = new byte[1024];
		sendData = "sou um cliente".getBytes();
		
		// Cria��o do datagrama com endere�o e porta do host remoto 9876
		DatagramPacket sendPacket = new DatagramPacket (sendData, sendData.length, IPAdress, 9876);
	
		// Envio do datagrama ao host remoto
		clientSocket.send(sendPacket);
		System.out.println("Mensagem enviada para o servidor");
		
		// Declara��o do buffer de recebimento (caso haja)
		byte[] recBuffer = new byte[1024];
		
		//cria��o do datagrama a ser recebido
		DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
		
		//recebimento do datagrama do host remoto (m�todo bloqueante)
		clientSocket.receive(recPkt); 	//BLOCKING
		
		// Obten��o da ingorma��o vinda no datagrama
		String informacao = new String(recPkt.getData(), recPkt.getOffset(), recPkt.getLength());
		
		System.out.println("Recebido do servidor: " + informacao);
		
		//fechamento da conex�o
		clientSocket.close();
		
		
	}
}
