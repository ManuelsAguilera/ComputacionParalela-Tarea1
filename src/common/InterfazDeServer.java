package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfazDeServer extends  Remote {
	
	//Metodos de interfaz
	public ArrayList<Persona> getPersonas() throws RemoteException;
	public void persona(String nombre, int edad) throws RemoteException;
}
