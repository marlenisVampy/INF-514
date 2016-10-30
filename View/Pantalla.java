package View;
import java.io.*;
import java.sql.*;
import java.util.*; 
import DataAccess.*;

public class Pantalla  // clase para El menu Principal
{
	private Boutique NittyShoe = new Boutique("NittyShoe");
	Scanner enter = new Scanner(System.in);
	char eleccion;
	public Pantalla(){}
	
	
	public void menuPrincipal()
	{
		do{
		System.out.println("\t\t _____________________________________________________");
		System.out.printf("\n\t\t\t      M E N U   P R I N C I P A L \n             ");
		System.out.println(" -----------------------------------------------------\n");
		System.out.println("\t\t *----- 1. CLIENTE  \n");
		System.out.println("\t\t *----- 2. VENDEDOR \n");
		System.out.println("\t\t *----- 3. CALZADO  \n");
		System.out.println("\t\t *----- 4. VENTA    \n");
		System.out.println("\t\t *----- 5. RETORNAR \n");
		System.out.println("\t\t-----------------------------------------------------\n");
		
		System.out.print(" Eliga Opcion...: ");
		eleccion = enter.next().charAt(0);
		switch(eleccion)
		{
			case '1':
			{
				
				NittyShoe.subMenuCliente();
				break;				
			}
			
			case '2':
			{
				NittyShoe.subMenuVendedor();
				
				break;
			}
			case '3':
			{
				NittyShoe.subMenuCalzado();
				break;
			}
			case '4':
			{
				NittyShoe.subMenuVenta();
				
				break;
			}
			
			default: 
					System.out.print(" --- DESEA SALIR DEL MENU PRINCIPAL ??[6/n]: ");
				    eleccion = enter.next().charAt(0);	
		}//fi n del switch
		
		
		}while(eleccion !='6');
	}//fin metodo menuPrincipal()
	
}//fin clase pantalla
