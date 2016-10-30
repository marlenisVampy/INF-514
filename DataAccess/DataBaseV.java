package DataAccess;

//VampySoft.java										//MJCC  100301097
import java.io.*;
import java.sql.*;
import java.util.*; 
import DataAccess.*;


//clase que me creara la base de datos y las tablas
public class DataBaseV
{
	protected String nameDB = "VampyDB";
	protected Connection conn = null;
	protected Statement stat0 = null;
	protected ResultSet result = null;
	protected PreparedStatement stmt = null; 
	
	protected String URL = "jdbc:derby:" + nameDB + ";create=true"; 
	   
	   public DataBaseV(){}
	  public void crearDB() throws Exception
	 { //metodo para crear la VampyDB
  			      		
		try{
		  //  Conexion a la base de datos via el JDBC Derby      
			conn = DriverManager.getConnection(URL);
			System.out.println("\n* Conexion exitosa con la base de datos " +  this.nameDB);	        
			conn.close();
		  }catch(Exception ei)
			{
				ei.getStackTrace();
			}
    
	}
  
  public void crearTablas() throws Exception 	//crear tablas VampyDB.
	{		
		try{
			
			conn = DriverManager.getConnection(URL);
			stat0 = conn.createStatement();
				
			String cad0 = "CREATE TABLE Cliente " + 
			 "( clienteID BIGINT NOT NULL PRIMARY KEY,"+
	         "  clienteNombre VARCHAR(25) NOT NULL,"+
		     "  clienteTel VARCHAR(13) NOT NULL )";
			
			String cad1 = "CREATE TABLE Vendedor " + 
			"( vendedorID BIGINT NOT NULL PRIMARY KEY,"+
			"   v_nombre VARCHAR(25) NOT NULL )";
			 
			 
			 String cad2 = "CREATE TABLE Venta " + 
			" (ventaId BIGINT NOT NULL PRIMARY KEY,"+
			" vID BIGINT CONSTRAINT VendedorID_FK REFERENCES Vendedor(vendedorID)," +
			" cliID BIGINT CONSTRAINT ClienteID_FK REFERENCES Cliente(clienteID))";
			
			String cad3 = "CREATE TABLE Calzado " + 
			" (calzadoID BIGINT NOT NULL PRIMARY KEY," +
			"  calzadoModel VARCHAR(15) NOT NULL," +
			" calzadoPrecio DECIMAL (7,2) NOT NULL,"+
			" ventaId BIGINT CONSTRAINT VentaId_FK REFERENCES Venta(ventaId))";
			//La tabla Calzado, recibe el ID de la venta donde esta
			
			
			stat0.executeUpdate(cad0); //crea la tabla Cliente
			stat0.executeUpdate(cad1);  //crea la tabla Vendedor
			stat0.executeUpdate(cad2);  //crea la tabla Venta
			stat0.executeUpdate(cad3);   //crea la tabla Calzado
			
			System.out.println("\n* Todas las tablas estan creadas en base de datos " +  this.nameDB);	
			
		stat0.close();
		conn.close();
		}catch(Exception ei)
		{
			ei.getStackTrace();
		}
		
	}	
}	//fin clase DataBaseV
