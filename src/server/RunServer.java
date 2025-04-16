package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {

	public static void main(String[] args) 
	{
		try
		{
			ServerImpl server = new ServerImpl();
			Registry registry = LocateRegistry.createRegistry(2002);
			registry.bind("BD_Personas", server);
			System.out.println("Server up!");
			
			
		}
		catch (RemoteException RemoteE)
		{
			RemoteE.printStackTrace();
		}
		
		catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
