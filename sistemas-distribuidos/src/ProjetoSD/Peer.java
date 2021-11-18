package ProjetoSD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Peer extends Mensagem {
	
	public static void main(String[] args) throws Exception {
		
		InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
		DatagramSocket clientSocket = new DatagramSocket();
		Mensagem.menu();
		Scanner console = new Scanner(System.in);
		int opcao = console.nextInt();
		switch (opcao){
			case 1:	System.out.println("Voce escolheu Join");
				join(IPAdress);
				break;
			case 2: System.out.println("Voce escoheu Search");
				break;
			case 3: System.out.println("Voce escolheu Downloard");
				break;
			
			
		}
		
	}

	private static void join(InetAddress IPAdress) {
		
		byte[] sendData = new byte[1024];
		sendData = "sou um cliente".getBytes();
		DatagramPacket sendPacket = new DatagramPacket (sendData, sendData.length, IPAdress, 9876);
		
	}
}
