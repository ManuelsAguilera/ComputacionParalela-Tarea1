package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.*;

public class ServerImpl extends UnicastRemoteObject  implements InterfazDeServer {

	private ArrayList<Persona> BD; 
	
	private void printBD()
	{
		System.out.println("[");
		for (Persona persona : this.BD)
		{
			System.out.println("Nombre: "+persona.getNombre() + " edad " + persona.getEdad());
		}
		System.out.println("]");
	}
	
	public ServerImpl() throws RemoteException
	{
		super();
		BD = new ArrayList<Persona>();
		
	}
	
	@Override
	public ArrayList<Persona> getPersonas() throws RemoteException {
		//Loggear para avisar en servidor
		System.out.println("Base de datos entregada a cliente");
		return BD;
	}

	@Override
	public void insertPersona(String nombre, int edad) throws RemoteException {		
		BD.add(new Persona(nombre,edad));
		//Loggear para avisar en servidor
		System.out.println("BD servidor modificada. Mostrando cambios:");
		System.out.println("Nueva persona: "+ nombre +" edad " +edad);
		printBD();
		
	}

	@Override
	public boolean removePersona(String nombre, int edad) throws RemoteException {
		
		for (Persona persona : BD)
		{
			if (persona.getNombre().equals(nombre) & persona.getEdad() == edad)
			{
				System.out.println("Eliminando persona: "+nombre+ " edad "+edad);
				BD.remove(persona);
				return true;
			}
		}
		
		return false;
		
	}
		
	
		
	

}
