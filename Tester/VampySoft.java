
import DataAccess.*;
import View.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class VampySoft
{
    public static void main(String[] args)
    {	  		
  		
     try{  
		//controlando la excepcion 
		 DataBaseV miBD = new DataBaseV();  
					 miBD.crearDB();      //crear mi Base de Datos
		 miBD.crearTablas();  //creando mis tablas
	  
		Pantalla miP = new Pantalla(); 
		miP.menuPrincipal();  //menu que utiliza todos los metodos de las clases creadas
	 
	  }catch(Exception ei)
	  {
		  ei.getStackTrace();
	  }
	  
    }    
}
		