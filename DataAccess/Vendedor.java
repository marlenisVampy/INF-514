 
package DataAccess;
import java.io.*;
import java.sql.*;
import java.util.*; 

//class Vendedor
public class Vendedor extends DataBaseV
{
	private long Id;
	private String nombreVendedor;

	public Vendedor(){}
	
	public Vendedor(long Id)
	{this.Id = Id;}
	
	public Vendedor(long Id, String name)
	{
		setIDVendedor(Id);
		setNameSeller(name);
	}
	
	public void setIDVendedor(long id)
	{
		this.Id = id;
	}
	
	public void setNameSeller(String name)
	{
		this.nombreVendedor = name;
	}
	
	public long getIdSeller(){return this.Id;}
	public String getNameSeller(){return this.nombreVendedor;}
	
	public void registrarSeller()throws Exception
	{
		try
		{
			conn = DriverManager.getConnection(URL);
			String cad0 = "INSERT INTO Vendedor " + 
			 "( vendedorID,v_nombre)" +
			 "VALUES(?,?)";
			stmt = conn.prepareStatement(cad0);
			
			stmt.setLong(1,getIdSeller());
			stmt.setString(2,getNameSeller());
			 
			stmt.executeUpdate();
			
			System.out.println("\n* Nuevo Vendedor insertado en base de datos " +  this.nameDB);			
			
			stmt.close();
           conn.close();
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}//fin metodo registrarSeller()
	public void updateSeller(Long Id, String name)throws Exception	 //probar
	{
		conn = DriverManager.getConnection(URL);
		
		String upSeller = "UPDATE Vendedor SET v_nombre = ? WHERE vendedorID  = ?";
		stmt = conn.prepareStatement(upSeller);
		
		
		stmt.setString(1,name);
		stmt.setLong(2,Id);
		stmt.executeUpdate();			
		System.out.println("\n* Vendedor actualizado en base de datos " +  this.nameDB);		
		
		stmt.close();
		conn.close();
	}//fin metodo updateSeller()
	
	public void deleteVendedor(long Id)throws Exception //probar
	{
		try{
			conn = DriverManager.getConnection(URL);
			String delSeller = "DELETE FROM Vendedor WHERE vendedorID = ? ";
			
			stmt = conn.prepareStatement(delSeller);
			stmt.setLong(1,Id);
			stmt.executeUpdate();
			System.out.println("\n* Vendedor borrado de la  base de datos " +  this.nameDB);		
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}//fin metodo deleteVendedor
	
	
}//fin clase Vendedor
