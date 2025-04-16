package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient {

	public static void main(String args[])
	{
		try {
			Client client = new Client();
			
			System.out.println("Client is up!");
			
			
			/* Desde aqui en adelante, la mayoria del codigo es simplemente el menu de comandos */
			
			int opciones=-1;
			Scanner reader = new Scanner(System.in);
			String buffer = "";
			while ( opciones != 0) {
				
				System.out.println("-                   -");
				System.out.println("Elige una opcion:\n"+"1 : Mostrar Base de datos");
				System.out.println("2: Agregar Persona a Base de Datos");
				System.out.println("3: Eliminar Persona a Base de datos");
				
				
				while (true)
				{					
					if (reader.hasNextInt())
					{
						buffer = reader.next();
						opciones = (int)Integer.parseInt(buffer);
						break;
					}
					else
					{
						System.out.println("Porfavor solo ingresar numeros enteros");
						reader.nextLine();
					}
						
				}
				
				
				switch (opciones)
				{
					case 1:
						client.getBD();
						break;
					case 2:
						client.anadirPersona();
						break;
					case 3:
						client.removePersona();
						break;
					default:
						System.out.println("Valor invalido");
				}
				
			}
			
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
