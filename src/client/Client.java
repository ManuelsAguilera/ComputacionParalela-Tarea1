package client;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import common.*;

public class Client {

	private InterfazDeServer server;
	
	public Client() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry(2002);		
		server = (InterfazDeServer) registry.lookup("BD_Personas");
	};
	
	public void mostrarPersonas() throws RemoteException {
		ArrayList<Persona> BD = server.getPersonas();
		System.out.println("[");
		for (Persona persona : BD)
		{
			System.out.println("Nombre: "+persona.getNombre() + " edad " + persona.getEdad());
		}
		System.out.println("]");
	}
	
	public void anadirPersona(String nombre, int edad) throws RemoteException
	{
		server.persona(nombre,edad);

	}
	
}
