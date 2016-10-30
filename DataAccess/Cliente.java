	
package DataAccess;
import java.io.*;
import java.sql.*;
import java.util.*; 
	   
public class Cliente extends DataBaseV
{
 	private long clienteId;
    private String clienteNombre;
	private String clienteTel;
	
	
	public Cliente(){}
	
	public Cliente(long id, String clieN, String cliTel)
	{
		setIdCliente(id);
		setNomCliente(clieN);
		setTelefono(cliTel);
		
	}
	
	public void setIdCliente(Long id)
    {
        this.clienteId = id;
    }	
	 public void setNomCliente(String name)
    {                
		clienteNombre = name;
     }
	public void setTelefono(String tel)
	{
		  this.clienteTel= tel;
    }
	public long getId(){return this.clienteId;}
    public String getNameClient(){return this.clienteNombre;}
	public String getTelefono(){return this.clienteTel;}
	
	 public void registrarCliente() throws Exception //registrarCliente en la db
    {
		
		try
		{			
			conn = DriverManager.getConnection(URL);
				
			String cad0 = "INSERT INTO Cliente " + 
			 "( clienteID,clienteNombre,clienteTel)" +
			 "VALUES(?,?,?)";
			 
			PreparedStatement stmt = conn.prepareStatement(cad0);
			 
			 stmt.setLong(1,getId());
			 stmt.setString(2,getNameClient());
			 stmt.setString(3,getTelefono());
			 
			 stmt.executeUpdate();
			 	System.out.println("\n* Nuevo Cliente insertado en base de datos " +  this.nameDB);			
		stmt.close();
        conn.close();
		}catch(Exception ei)
		{
			ei.getStackTrace();
		}
		
	}//fin registrarCliente()
	public void updateCliente(Long Id, String name, String Tel)throws Exception		//recibira el Id del cliente que desea actualizar sus datos..
	{
		try{
			
		conn = DriverManager.getConnection(URL);
		
		String upCli = "UPDATE Cliente SET clienteNombre = ?, clienteTel = ? "
					+  " WHERE clienteID = ?";
					
		stmt = conn.prepareStatement(upCli);
		
				
		stmt.setString(1,name);
		stmt.setString(2,Tel);
		stmt.setLong(3,Id);
		stmt.executeUpdate();			
		System.out.println("\n* Cliente actualizado en base de datos " +  this.nameDB);		
		
		stmt.close();
		conn.close();
		}catch(Exception eo)
		{
			eo.getStackTrace();
		}
	}//fin metodo updateCliente()
	
	public void deleteCliente(long Id)throws Exception
	{
		try{
			conn = DriverManager.getConnection(URL);
			String delCli = "DELETE FROM Cliente WHERE clienteID = " + Id;
			
			stmt = conn.prepareStatement(delCli);		
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			System.out.println("\n* Cliente borrado de la base de datos " +  this.nameDB);		
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}//fin metodo deleteCliente()	
 }//fin clase Client
