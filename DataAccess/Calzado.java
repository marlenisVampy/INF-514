package DataAccess;
import java.io.*;
import java.sql.*;
import java.util.*; 
import DataAccess.*;

public class Calzado extends DataBaseV
{
	private long calId;
	private String modelo;
	private double precio;
	private Venta miVenta; //Calzado recibe un objeto Venta, agregacion
	
	public Calzado(){}
	public Calzado(long calId, String model, double precio)
	{
		setID(calId);
		setModelo( model );
		setPrecio( precio);
	}
	public Calzado(long calId, String model, double precio, Venta miVenta)
	{
		setID(calId);
		setModelo( model );
		setPrecio( precio);
		this.miVenta = miVenta;
	}
	
	public void setID(long Id)
	{
		this.calId = Id;
	}
	public void setModelo(String model)
	{
		this.modelo = model;
	}
	public void setPrecio(double price)
	{
		this.precio = (price > 0) ? price : 0.00;
	}
	
	public long getId(){return this.calId;}
	public String getModelo(){return this.modelo;}
	public double getPrecio(){return this.precio;}
	
	public void registrarCalzado() throws Exception
	{
		try{
		conn = DriverManager.getConnection(URL);
		String cad0 = "INSERT INTO Calzado " + 
			 "( calzadoID,calzadoModel,calzadoPrecio,ventaId)" +
			 "VALUES(?,?,?,?)";
			 
			stmt = conn.prepareStatement(cad0);
			
			stmt.setLong(1,getId());
			stmt.setString(2,getModelo());
			stmt.setDouble(3,getPrecio());
			stmt.setLong(4,miVenta.getIdVenta());
			
			stmt.executeUpdate();
			
			System.out.println("\n* Nuevo Calzado insertado en base de datos " +  this.nameDB);
			stmt.close();
			conn.close();		
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}//fin registrarCalzado()
	//recibe el Id del Calzado que quiere actualizar 
	public void actualizarCalzado(long id, String model, double precio)throws Exception
	{
		try
		{
			conn = DriverManager.getConnection(URL);
		
		   String upCal = "UPDATE Calzado SET calzadoModel = ?, calzadoPrecio = ? "
					+  " WHERE calzadoID  = " + id;
					
			stmt = conn.prepareStatement(upCal);
			
		stmt.setString(1,model);
		stmt.setDouble(2,precio);
		stmt.executeUpdate();			
		System.out.println("\n* Calzado actualizado en base de datos " +  this.nameDB);		
		
		stmt.close();
		conn.close();
		}catch(Exception eo)
		{
			eo.getStackTrace();
		}
	}//fin metodo actualizarCalzado()
	
	public void deleteCalzado(long Id)throws Exception  //probar
	{
		try{
		  conn = DriverManager.getConnection(URL);
			String delCal = "DELETE FROM Calzado WHERE calzadoID = " + Id;
			
			stmt = conn.prepareStatement(delCal);		
			stmt.executeUpdate();
					System.out.println("\n* Calzado borrado de base de datos " +  this.nameDB);	
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}//fin metodo de deleteCalzado()

  
}//fin class Calzado
