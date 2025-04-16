package client;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import common.*;

public class Client {

	private InterfazDeServer server;
	private Persona clientReadData()
	{
		Persona persona = new Persona();
		
		Scanner reader = new Scanner(System.in);
		
		String nombre = "";
	    int edad = -1;

	    //nombre
	    while (true) {
	        System.out.print("Ingrese su nombre: ");
	        nombre = reader.nextLine().trim();

	        if (!nombre.isEmpty()) {
	            persona.setNombre(nombre);
	            break;
	        } 
	        else 
	            System.out.println("El nombre no puede estar vacío. Intente nuevamente.");
	        
	    }

	    //edad
	    while (true) {
	        System.out.print("Ingrese su edad: ");
	        String input = reader.nextLine().trim();

	        try {
	            edad = Integer.parseInt(input);
	            if (edad >= 0) {
	                persona.setEdad(edad);
	                break;
	            } 
	            else
	                System.out.println("La edad debe ser un número positivo. Intente nuevamente.");
	        
	        } catch (NumberFormatException e) {
	            System.out.println("Edad inválida. Por favor ingrese un número entero.");
	        }
	    }

	    return persona;
	}
	
	public Client() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry(2002);		
		server = (InterfazDeServer) registry.lookup("BD_Personas");
	};
	
	public void getBD() throws RemoteException {
		ArrayList<Persona> BD = server.getPersonas();
		System.out.println("[");
		for (Persona persona : BD)
		{
			System.out.println("Nombre: "+persona.getNombre() + " edad " + persona.getEdad());
		}
		System.out.println("]");
	}
	
	public void anadirPersona() throws RemoteException
	{
		Persona persona = clientReadData();
		server.insertPersona(persona.getNombre(),persona.getEdad());

	}
	
	
	public void removePersona() throws RemoteException
	{
		Persona persona = clientReadData();
		if (server.removePersona(persona.getNombre(),persona.getEdad()))
			System.out.println("Persona eliminada");
		else
		{
			System.out.println("No se encontro persona "+ persona.getNombre()+ " edad "+ persona.getEdad());
		}
			
	}
	
}
