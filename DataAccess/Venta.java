package DataAccess;
import java.io.*;
import java.sql.*;
import java.util.*; 

public class Venta extends DataBaseV 		//class Venta solo guarda el Id del Vendedor y del Cliente que compro en NittyShoe Boutique
{	
	private long IdVenta;
	private Vendedor miV ;
	private Cliente unCli;
	
	
	public Venta(){}
	
	public Venta(long IdVenta, Vendedor miV, Cliente unCli)
	{
		this.IdVenta = IdVenta;
		this.unCli = unCli;
		this.miV= miV;
	}
	
	public long getIdVenta()  {return IdVenta;}
	
	public void registrarVenta()throws Exception  //probar
	{
		
		try{
			conn = DriverManager.getConnection(URL);
			
			String setVenta = "INSERT INTO Venta" + 
			 "( ventaId, vID,cliID)" +
			 "VALUES(?,?,?)";
		
		 stmt = conn.prepareStatement(setVenta);
			
            stmt.setLong(1,getIdVenta());
			stmt.setLong(2,miV.getIdSeller());
			stmt.setLong(3,unCli.getId());
		
			
			System.out.println("\n* Venta Registrada en base de datos " +  this.nameDB);
			
			stmt.executeUpdate();
					
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
		
	}//registar Venta
public void actualizarVenta(long IdVenta,long IdVendedor,long IdCliente)throws Exception
{
	try{
			
		conn = DriverManager.getConnection(URL);
		String upVent = "UPDATE Venta SET  vID = ?, cliID = ? "
					+  " WHERE ventaId = ?";
					
		stmt = conn.prepareStatement(upVent);
		stmt.setLong(1,IdVendedor);
		stmt.setLong(2,IdCliente);
		stmt.setLong(3,IdVenta);
		stmt.executeUpdate();			
		System.out.println("\n* Venta  actualizada en base de datos " +  this.nameDB);		
		
		stmt.close();
		conn.close();
		}catch(Exception eo)
		{
			eo.getStackTrace();
		}
	}
		



  }//fin clase Venta
