package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunClient {

	public static void main(String args[])
	{
		try {
			Client client = new Client();
			
			System.out.println("Client is up!");
			
			client.mostrarPersonas();
			client.anadirPersona("Vicente",23); //no me acuerdo
			client.anadirPersona("Manuel",21);
			client.anadirPersona("Alex", 22);
			client.mostrarPersonas();
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
