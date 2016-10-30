
package DataAccess;
import java.io.*;
import java.sql.*;
import java.util.*; 


//class Query
public class QueryTable extends DataBaseV //clase de las Consultas a las tablas de VampyDB
{
	
	
	public QueryTable(){}
	
	//sobrecarga del metodo queryCliente()
	public void queryCliente()throws Exception
	{
			
		try{  
			  conn = DriverManager.getConnection(URL);
		  	  String query = "SELECT * FROM Cliente "; 
			  stmt = conn.prepareStatement(query);			  
			  result = stmt.executeQuery();
				long clienteID;
		    String Nombre, Telefono;
			
			System.out.println("\n\t\t\tCLIENTE \n");
			System.out.println("   ____________________________________________________");
		    System.out.println("\n  | CLI_ID      |     NOMBRE COMPLETO      | TELEFONO\n");
		    System.out.println("   ---------------------------------------------------\n");
			
			while(result.next())
			{
			   
				clienteID = result.getLong("clienteID");              
				Nombre = result.getString("clienteNombre");
				Telefono = result.getString("clienteTel");
			
				System.out.printf("|%-8s",clienteID);
				System.out.printf("      |%-8s\t",Nombre);
				System.out.printf("      |%-8s",Telefono + "\n");
           }    
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}  
			  
	}
	public void queryCliente(long id)throws Exception
	{		
		try{  
			  conn = DriverManager.getConnection(URL);
		  	  String query = "SELECT * FROM Cliente WHERE clienteID = ?"; 
			  stmt = conn.prepareStatement(query);			  
			  stmt.setLong(1,id);
			  result = stmt.executeQuery();
			
			long clienteID;
		    String Nombre, Telefono;
			
			System.out.println("\n\t\t\tCLIENTE \n");
			System.out.println("   ____________________________________________________");
		    System.out.println("\n  | CLI_ID          |   NOMBRE COMPLETO          | TELEFONO\n");
		    System.out.println("   ---------------------------------------------------\n");
			
			while(result.next()){
			   
		    clienteID = result.getLong("clienteID");              
            Nombre = result.getString("clienteNombre");
            Telefono = result.getString("clienteTel");
			
			System.out.printf("|%-8s",clienteID);
		    System.out.printf("           |%-8s\t",Nombre);
            System.out.printf("    |%-8s",Telefono + "\n");
           }    
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}
	}//fin metodo queryCliente
	//sobrecarga del metodo queryVendedor()
	public void queryVendedor()throws Exception
	{
		try{
			
		      conn = DriverManager.getConnection(URL);
		   	  String query = "SELECT * FROM Vendedor"; 
			  stmt = conn.prepareStatement(query);			  
			  
			  result = stmt.executeQuery();
			  
			   long vendedorID;
		    String Nombre;
			
			System.out.println("\n\t\t\t VENDEDOR\n");
			System.out.println("   ____________________________________________________");
		    System.out.println("\n\t\t | Vendedor_ID    |   NOMBRE COMPLETO   |\n");
		    System.out.println("   ---------------------------------------------------\n");
			
			while(result.next()){
			   
		    vendedorID = result.getLong("vendedorID");              
            Nombre = result.getString("v_nombre");
            			
			System.out.printf("\t\t  |%-8s",vendedorID);
		    System.out.printf("       | %-8s",Nombre);
			 System.out.printf("\n");
           }    
		   System.out.println("\n* Vendedor consultado en base de datos " +  this.nameDB);
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}
}//fin del queryVendedor()

	public void queryVendedor(long id)throws Exception
	{
		try{
			  conn = DriverManager.getConnection(URL);
		   	  String query = "SELECT * FROM Vendedor WHERE vendedorID = ?"; 
			  stmt = conn.prepareStatement(query);			  
			  stmt.setLong(1,id);
			  result = stmt.executeQuery();
			  
			  long vendedorID;
		      String Nombre;
			
			System.out.println("\n\t\t\t VENDEDOR\n");
			System.out.println("   ___________________________________________");
		    System.out.println("\n  | Vendedor_ID     |   NOMBRE COMPLETO   |\n");
		    System.out.println("   --------------------------------------------\n");
			
			while(result.next())
			{
			   
		    vendedorID = result.getLong("vendedorID");              
            Nombre = result.getString("v_nombre");
            			
			System.out.printf("   |%-8s",vendedorID);
		    System.out.printf("         |%-8s\t",Nombre);
           
            }    
		   System.out.println("\n* Vendedor consultado en base de datos " +  this.nameDB);
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}
	} //fin metodo queryVendedor
		
//sobrecarga del metodo queryCalzado()
public void queryCalzado()
{
	try{
		    conn = DriverManager.getConnection(URL);
		   	  String query = "SELECT * FROM Calzado "; 
			  stmt = conn.prepareStatement(query);			  
			  
			  result = stmt.executeQuery();
			  
			  long cID, venta_Id;
			  String model;
			  double precio;
			  System.out.println("\n\t\t\t CALZADOS\n");
			System.out.println(" _____________________________________________________");
		    System.out.println("\n CAL_ID    |   CAL_MODEL       |  CAL_Precio     | Venta_Id");
		    System.out.println("   ---------------------------------------------------\n");
			while(result.next())
			{
			 		   
			 cID = result.getLong("calzadoID");
			 model = result.getString("calzadoModel");
			 precio = result.getDouble("calzadoPrecio");
			 venta_Id = result.getLong("ventaId");		
			 
			 System.out.printf("  |%-8s  ",cID);
			 System.out.printf("|   %-8s",model);
		     System.out.printf("     |   %-8s ",precio);
			 System.out.printf("    |   %-8s\t",venta_Id);
			 System.out.printf("\n"); 
			}
			System.out.println("\n* Calzado consultado en base de datos " +  this.nameDB);
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}	

			  
}
public void queryCalzado(long id)throws Exception
{
		try{
		     conn = DriverManager.getConnection(URL);
		   	  String query = "SELECT * FROM Calzado WHERE calzadoID = ?"; 
			  stmt = conn.prepareStatement(query);			  
			  stmt.setLong(1,id);
			  result = stmt.executeQuery();
			  
			  long cID, venta_Id;
			  String model;
			  double precio;
			  
			  System.out.println("\n\t\t\t CALZADOS\n");
			System.out.println(" _____________________________________________________");
		    System.out.println("\n  CAL_ID     |   CAL_MODEL     |  CAL_Precio   | Venta_Id");
		    System.out.println("   ---------------------------------------------------\n");
			while(result.next())
			{
			 		   
			 cID = result.getLong("calzadoID");
			 model = result.getString("calzadoModel");
			 precio = result.getDouble("calzadoPrecio");
			 venta_Id = result.getLong("ventaId");		
						  
			  System.out.printf("  |%-8s  ",cID);
			  System.out.printf("|   %-8s",model);
		      System.out.printf("     |   %-8s ",precio);
			  System.out.printf("    |   %-8s\t",venta_Id);
			 System.out.printf("\n");
			}
			System.out.println("\n* Calzado consultado en base de datos " +  this.nameDB);
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}	

	}
	//sobrecarga del metodo queryVenta()
	public void queryVenta()throws Exception
	{
		try{
		    conn = DriverManager.getConnection(URL);
		   	  String query = "SELECT * FROM Venta"; 
			  stmt = conn.prepareStatement(query);			  
			 
			  result = stmt.executeQuery();
			  
			  long ventaID, vendedorID,clienteID;
	      	System.out.println("\n\t\t\t VENTA\n");
			System.out.println(" _____________________________________________________");
		    System.out.println("\n|  V_ID     |    Vendedor_ID   |    Cliente_ID |\n");
		    System.out.println("   ---------------------------------------------------\n");
			while(result.next()){
			 		   
			 ventaID = result.getLong("ventaId");
			 vendedorID = result.getLong("vID");
			 clienteID = result.getLong("cliID");
			
            System.out.printf("  |%-8s  ",ventaID);
			System.out.printf("|       %-8s",vendedorID);
		    System.out.printf("     |    %-8s\t",clienteID);
			System.out.printf("\n"); 
			}
			System.out.println("\n*Venta consultada en base de datos " +  this.nameDB);
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}	

		
	}
public void queryVenta(long id)
{
		try{
		    conn = DriverManager.getConnection(URL);
		   	  String query = "SELECT * FROM Venta WHERE ventaId = ?"; 
			  stmt = conn.prepareStatement(query);			  
			  stmt.setLong(1,id);
			  result = stmt.executeQuery();
			  
			  long ventaID, vendedorID,clienteID;
			  
			  System.out.println("\n\t\t\t VENTA\n");
			 System.out.println(" _____________________________________________________");
		     System.out.println("\n|  V_ID     |    Vendedor_ID   |    Cliente_ID |\n");
		     System.out.println("   ---------------------------------------------------\n");
			while(result.next()){
			 		   
			 ventaID = result.getLong("ventaId");
			 vendedorID = result.getLong("vID");
			 clienteID = result.getLong("cliID");
			
            
			 System.out.printf("  |%-8s  ",ventaID);
			System.out.printf("|       %-8s",vendedorID);
		    System.out.printf("     |    %-8s\t",clienteID);
			 System.out.printf("\n");
			 
			}
			System.out.println("\n*Venta consultada en base de datos " +  this.nameDB);
			stmt.close();
		    conn.close();
		}catch (Exception ei)
		{
			ei.getStackTrace();
		}	

	}
	
}//fin clases QueryTable
