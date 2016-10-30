
package View;
import java.io.*;
import java.sql.*;
import java.util.*; 
public class Boutique
{	
	//declarando mis variables.....
	private String name_Boutique;
	long clienteID, vendedorID, ventaID, calzadoId;
	String  Nombre, Telefono, Modelo, v_nombre;
	double precioNitty;
	char opcion = ' ';		
	char decision ;
	char finbucle = ' ';
	
	
	Calzado unCalzado = new Calzado(); //instanciando las clases
	Cliente unCliente = new Cliente();
	Vendedor unSeller = new Vendedor();
	Venta miVenta = new Venta();
	QueryTable miQuery = new QueryTable();
	
	
	Scanner enter = new Scanner(System.in);
	InputStreamReader isr = new InputStreamReader(System.in);
     BufferedReader br = new BufferedReader (isr);
	 
	
	public Boutique()
	{}
	
	public Boutique(String name)
	{
		this.name_Boutique = name;
		System.out.println("\n\t\t\t VAMPYSOFT  \n\t\t\t");
		System.out.println("\n");
		System.out.println("\n\t\t\t   BIENVENIDO  \n\t\t\t      A ");
		System.out.println("\t___________________________________________________________");
		System.out.printf("\n\t\t\t   %s \n", this.name_Boutique);
		System.out.println("\n\n \t KM.21 de Las Americas, Riviera del Caribe \n\n ");
		System.out.println("\t----------------------------------------------------------\n");
		
		
	}
	public void subMenuCliente()  // menu del Cliente
	{
	do{
		System.out.println("\t\t _____________________________________________________");
		System.out.printf("\n\t\t\t      M E N U  C L I E N T E  \n             ");
		System.out.println(" -----------------------------------------------------\n");
		System.out.println("\t\t *----- 1. CONSULTAR  \n");
		System.out.println("\t\t *----- 2. ELIMINAR \n"); //verificar que no necesite un UPDATE en vez de un eliminar
		System.out.println("\t\t *----- 3. ACTUALIZAR \n");
		System.out.println("\t\t *-----'n'.RETORNAR \n");
		System.out.println("\t\t-----------------------------------------------------\n");
		System.out.println(" Eliga Opcion...: ");
		opcion = enter.next().charAt(0);
		
		switch(opcion)
		   {
			   case '1':
				{
					do{
						System.out.println("\n\t\t\t\t CONSULTAR CLIENTE\n\n\n");
					System.out.print("\n\n Teclee eleccion 1-verTodos 2-solo el Id que introduzca.: ");
					char eleccion = enter.next().charAt(0);
					switch(eleccion)
					{
						 case '1':
						{
							try{
								miQuery.queryCliente();
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
							
							break;
						}
						case '2':
						{
							try
								{
									System.out.print("---ClienteID. :");
								    clienteID = enter.nextLong();
									miQuery.queryCliente((long)clienteID);
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
							break;
						}
					
					  }
					  System.out.print(" --- DESEA CONSULTAR OTRO Cliente ?? [s/n]: ");
						decision = enter.next().charAt(0);
					  
					} while(decision != 'n');
				
					break;
				}
				
				case '2':
				{
					
					do{
			     
							System.out.println("\n\t\t\t\t ELIMINAR CLIENTE\n\n");
							System.out.println("---clienteID. :");
							clienteID = enter.nextLong();
						try
						{	
							unCliente.deleteCliente((long)clienteID);
						}catch(Exception ei)
						{
							ei.getStackTrace();
						}
						System.out.print(" --- DESEA ELIMINAR OTRO CLIENTE ?? [s/n]: ");
				        decision = enter.next().charAt(0);
						
						}while(decision != 'n'); //fin do-while
					
						break;
					}//fin del case 2
					case '3':
					{
						do{
			     
							System.out.println("\n\t\t\t\t ACTUALIZAR CLIENTE\n\n");
							System.out.println("---clienteID. :");
							clienteID = enter.nextLong();
							try
						{	
							System.out.print(" --- NOMBRE       : ");
							Nombre = br.readLine();
							System.out.print(" --- TELEFONO     : ");
							Telefono = br.readLine();
							unCliente.updateCliente((long)clienteID, Nombre, Telefono);
						}catch(Exception ei)
						{
							ei.getStackTrace();
						}
						System.out.print(" --- DESEA ACTUALIZAR OTRO CLIENTE ?? [s/n]: ");
				        decision = enter.next().charAt(0);
						
						}while(decision != 'n'); //fin do-while
						break;
					}
				default: 
					System.out.println(" --- DESEA SALIR DEL MENU CLIENTE ??[4/n]: ");
				    finbucle = enter.next().charAt(0);	
		   }//fin de switch principal
		}while(finbucle != '4');
		
		
		
	}//fin metodo subMenuCliente()
	public void subMenuCalzado()  // menu del Calzado
	{
		do{
		System.out.println("\t\t _____________________________________________________");
		System.out.printf("\n\t\t\t      M E N U  C A L Z A D O  \n             ");
		System.out.println(" -----------------------------------------------------\n");
		System.out.println("\t\t *----- 1. CONSULTAR  \n");
		System.out.println("\t\t *----- 2. ELIMINAR \n");
		System.out.println("\t\t *----- 3. ACTUALIZAR \n");
		System.out.println("\t\t *----'n'. RETORNAR \n");
		System.out.println("\t\t-----------------------------------------------------\n");
		
		System.out.println(" Eliga Opcion...: ");
		opcion = enter.next().charAt(0);
		switch(opcion)
		   {
			   case '0':
				{
					do{
					System.out.println("\n\t\t\t\t Registrar CALZADO\n\n\n");
					System.out.print("\n\n \t\t DIGITE LOS DATOS DEL Calzado \n\n");
					try{
						System.out.print(" --- Calzado_ID. : ");
						calzadoId = enter.nextLong();
						System.out.print(" --- Calzado_Model. : ");
						Modelo = br.readLine();
						System.out.print(" --- Calzado_Precio. : ");
						precioNitty= enter.nextDouble();
						unCalzado = new Calzado((long)calzadoId,Modelo,precioNitty);
						unCalzado.registrarCalzado();
					}catch(Exception ei)
					{
						ei.getStackTrace();
					}
					System.out.print(" --- DESEA REGISTRAR OTRO CALZADO[s/n]: ");
					decision = enter.next().charAt(0);
					}while(decision != 'n');
				break;
				}
					
				case '1':
				{
					do{
					System.out.println("\n\t\t\t\t CONSULTAR CALZADO\n\n\n");
					System.out.print("\n\n Teclee eleccion 1-verTodos 2-solo el Id que introduzca.: ");
					char eleccion = enter.next().charAt(0);
					
					switch(eleccion)
					{
						 case '1':
						{
							try{
								miQuery.queryCalzado();
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
							
							break;
						}
						case '2':
						{
							try
								{
									System.out.print("---CalzadoID. :");
								    calzadoId = enter.nextLong();
									miQuery.queryCalzado((long)calzadoId);
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
							break;
						}
			  		
						
					}//fin switch
					System.out.print(" --- DESEA CONSULTAR OTRO Calzado ?? [s/n]: ");
						decision = enter.next().charAt(0);
					
					}while(decision != 'n'); //fin do-while
					break;
				}//fin del case 1
				
			   case'2':
			   {
				 do{
			     
				 System.out.println("\n\t\t\t\t ELIMINAR CALZADO\n\n");
			     System.out.println("---CalzadoID. :");
				 calzadoId= enter.nextLong();
				 
				 try{
					 unCalzado.deleteCalzado((long)calzadoId);
				    }catch(Exception ei)
					{
						ei.getStackTrace();
					}
						System.out.print(" --- DESEA ELIMINAR OTRO Calzado ?? [s/n]: ");
				        decision = enter.next().charAt(0);
				   }while(decision != 'n');
				   
				   break;
			   }//fin Case 2
			   case '3':
			   {
				   do{
			     
							System.out.println("\n\t\t\t\t ACTUALIZAR CALZADO\n\n");
							
							try
						{	
							System.out.print(" --- Calzado_ID : ");
						calzadoId = enter.nextLong();
						System.out.print(" --- MODELO     : ");
						Modelo = br.readLine();
						System.out.print(" --- PRECIO     : ");
						precioNitty = enter.nextDouble();
						unCalzado.actualizarCalzado((long)calzadoId,Modelo, precioNitty);
						
						}catch(Exception ei)
						{
							ei.getStackTrace();
						}
						System.out.print(" --- DESEA ACTUALIZAR OTRO CALZADO ?? [s/n]: ");
				        decision = enter.next().charAt(0);
					}while(decision != 'n'); //fin do-while
				   break;
			   }//fin case 3
			   default: 
					System.out.println(" --- DESEA SALIR DEL MENU CALZADO ??[4/n]: ");
				    finbucle = enter.next().charAt(0);

		   }//fin del switch	 principal
	   }while(finbucle !='4');
	}//fin metodo submenu-Calzado()	

	public void subMenuVendedor()  // menu Vendedor
	{
		do{
		System.out.println("\t\t _____________________________________________________");
		System.out.printf("\n\t\t\t      M E N U   V E N D E D O R  \n             ");
		System.out.println(" -----------------------------------------------------\n");
		System.out.println("\t\t *----- 1. REGISTRAR  \n");
		System.out.println("\t\t *----- 2. ELIMINAR \n");  //solo lo borrara si no tiene ventas Registradas
		System.out.println("\t\t *----- 3. ACTUALIZAR   \n");
		System.out.println("\t\t *----- 4. CONSULTAR   \n");
		System.out.println("\t\t *----'n'. RETORNAR \n");
		System.out.println("\t\t-----------------------------------------------------\n");
		
		System.out.print(" Eliga Opcion...: ");
		 opcion = enter.next().charAt(0);
		 switch(opcion)
		   {
			  case '1':
			  {
				do{
			     
					System.out.println("\n\t\t\t\t REGISTRAR VENDEDOR\n\n\n");
					System.out.println("\n\n \t\t DIGITE LOS DATOS DEL VENDEDOR \n\n");
					try{
						System.out.print(" --- VENDEDOR_ID. : ");
						vendedorID = enter.nextLong();
						System.out.print(" --- VENDEDOR_Name. : ");
						v_nombre = br.readLine();
						unSeller = new Vendedor((long)vendedorID,v_nombre);
						unSeller.registrarSeller();
					}catch(Exception ei)
					{
						ei.getStackTrace();
					}
					System.out.print(" --- DESEA REGISTRAR OTRO VENDEDOR [s/n]: ");
					decision = enter.next().charAt(0);
			 }while(decision != 'n');
			 
					break;
			   }
			   
			   case '2':
			   {
				   do{
			     
				 System.out.println("\n\t\t\t\t ELIMINAR VENDEDOR\n\n");
			     System.out.println("---VendedorID. :");
				 vendedorID = enter.nextLong();
				 
				 try{
					 unSeller.deleteVendedor(vendedorID);
				    }catch(Exception ei)
					{
						ei.getStackTrace();
					}
						System.out.print(" --- DESEA ELIMINAR OTRO VENDEDOR ?? [s/n]: ");
				        decision = enter.next().charAt(0);
				   }while(decision != 'n');
				   
				   break;
				}//fin case2	
				
				case '3':
				{
					do{
			     
					System.out.println("\n\t\t\t\t ACTUALIZAR VENDEDOR\n\n\n");
					System.out.print("---VendedorID. :");
					vendedorID = enter.nextLong();
					System.out.print(" --- VENDEDOR_Name. : ");
					try{
						v_nombre = br.readLine();
						unSeller. updateSeller((long)vendedorID, v_nombre);
						
						}catch(Exception ei)
						{
							ei.getStackTrace();
						}
						System.out.print(" --- DESEA ACTUALIZAR OTRO VENDEDOR ?? [s/n]: ");
						decision = enter.next().charAt(0);
					}while(decision != 'n');
					
					break;
				}//fin case 3
				
				case '4':
				{
					do{
										
					 System.out.println("\n\t\t\t\t CONSULTAR VENDEDOR\n\n\n");
					System.out.print("\n\n Teclee eleccion 1-verTodos 2-solo el Id que introduzca.: ");
					 char eleccion = enter.next().charAt(0);
					 switch (eleccion)
					 {
							case '1':
							{
								try{
								miQuery.queryVendedor();
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
									break;
							}
						
							case '2':
							{
								System.out.print("---VendedorID. :");
								vendedorID = enter.nextLong();
								try
								{
									miQuery.queryVendedor((long)vendedorID);
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
								break;
							}//fin switch	
					 }	
						System.out.print(" --- DESEA CONSULTAR OTRO VENDEDOR ?? [s/n]: ");
						decision = enter.next().charAt(0);
				}while(decision != 'n');
					break; //break case 3
			}//fin case  3			
				default: 
					System.out.println(" --- DESEA SALIR DEL MENU VENDEDOR ??[5/n]: ");
				    finbucle = enter.next().charAt(0);
		   	
		 }//fin switch principal 	
		}while(finbucle != '5');//fin del do-while
}
//fin menu Vendedor
 

	public void subMenuVenta() // menu de la Venta
	{
				
		do{		
		    System.out.println("\t\t _____________________________________________________");
		System.out.printf("\n\t\t\t      M E N U   V E N T A  \n             ");
		System.out.println(" -----------------------------------------------------\n");
		System.out.println("\t\t *----- 1. REALIZAR PEDIDO  \n");
		System.out.println("\t\t *----- 2. CONSULTAR VENTA \n");
		System.out.println("\t\t *----- 3. ACTUALIZAR VENTA \n"); 
		System.out.println("\t\t *----'n'. RETORNAR \n");
		System.out.println("\t\t-----------------------------------------------------\n");
		System.out.println(" Eliga Opcion...: ");
		   opcion = enter.next().charAt(0);
		   
		   switch(opcion)
		   {
			 
			case '1' :
			{
			char decision ;
			
			System.out.println("\n\t\t\t\tREALIZANDO PEDIDO\n\n\n");
			System.out.println("\n\n \t\t DIGITE LOS DATOS DEL CLIENTE \n\n");
			System.out.print(" --- CLIENTE_ID   : ");
			try{
			clienteID = enter.nextLong();
			System.out.print(" --- NOMBRE       : ");
			Nombre = br.readLine();
			System.out.print(" --- TELEFONO     : ");
			Telefono = br.readLine();
			
			unCliente = new Cliente((long)clienteID, Nombre, Telefono);
			unCliente.registrarCliente();
			 
			System.out.println("\n\n \t\t DIGITE LOS DATOS DE LA VENTA \n\n"); 
			System.out.print(" --- VENTA_ID    : ");
			ventaID = enter.nextLong();
			System.out.print(" --- VENDEDOR_ID. : ");
			vendedorID = enter.nextLong();
			System.out.print(" --- VENDEDOR_Name. : ");
			v_nombre = br.readLine();
			
			unSeller  = new Vendedor((long)vendedorID, v_nombre);
						
			}catch(Exception ei)
		    {
			  ei.getStackTrace();
		    }
			 
			System.out.print("\n\n DIGITE LOS DATOS DEL CALZADO \n\n");
			//hago un do- while para decidir cuantos cuantos calzados  agreagar a mi tabla Venta
			
			do
			{
				try{
				System.out.print(" --- Calzado_ID : ");
				calzadoId = enter.nextLong();
				System.out.print(" --- MODELO     : ");
				Modelo = br.readLine();
				System.out.print(" --- PRECIO     : ");
				precioNitty = enter.nextDouble();
				
				miVenta = new Venta (ventaID,unSeller,unCliente);	
			 
			  try{
					miVenta.registrarVenta();
			   }catch(Exception ei){ei.getStackTrace();}
				unCalzado = new Calzado((long)calzadoId,Modelo,precioNitty,miVenta);	
				unCalzado.registrarCalzado();		
				} catch(Exception ei)
		        {
			      ei.getStackTrace();
		        }
				
				System.out.print(" \n --- DESEA AGREGAR OTRO CALZADO A SU VENTA [s/n]: ");
				 decision = enter.next().charAt(0);
			 }while(decision == 's');
				
			   
				break;
			}
			case '2':
			{
				
				do
				{
					 System.out.println("\n\t\t\t\t CONSULTAR VENTA\n\n\n");
					System.out.print("\n\n Teclee eleccion 1-verTodos 2-solo el Id que introduzca.: ");
				    char eleccion = enter.next().charAt(0);
					switch(eleccion)
					{
						case '1':
						{
								try{
									miQuery.queryVenta();
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
							break;
						}
						case '2':
						{
							System.out.print("---VentaID. :");
								ventaID = enter.nextLong();
								try
								{
									miQuery.queryVenta((long)ventaID);
								}catch(Exception ei)
								{
									ei.getStackTrace();
								}
							break;
						}
					}//fin de sub switch
					System.out.print(" --- DESEA CONSULTAR OTRO VENTA ?? [s/n]: ");
						decision = enter.next().charAt(0);
				}while(decision != 'n');
				
				break;
			}//fin del case 2
			case '3':
			{
				do
				{
					 System.out.println("\n\t\t\t\t ACTUALIZAR VENTA\n\n\n");
					 System.out.print("\t Introduzca IdVenta.: ");
				     ventaID = enter.nextLong();
					 try{
					  System.out.print("\t Introduzca IdVendedor.: ");
					  vendedorID = enter.nextLong();
					  System.out.print("\t Introduzca IdCliente.: ");
					  clienteID = enter.nextLong();
					  miVenta.actualizarVenta((long)ventaID, (long)vendedorID,(long)clienteID);
				    }catch(Exception ei)
					{
						ei.getStackTrace();
					}
					System.out.print(" --- DESEA ACTUALIZAR OTRO VENTA ?? [s/n]: ");
					
				    decision = enter.next().charAt(0);
				}while(decision != 'n');
				break;
				// me actualizara la venta  con ID de la Venta, del Vendedor que vendio y con el Cliente, el cliente debe estar ya registrado
				//en la tabla Cliente
			}
			default: 
					System.out.println(" --- DESEA HACER OTRA VENTA [s/4]: ");
				finbucle = enter.next().charAt(0);
				}//fin switch	     
		  }while(finbucle != '4');
		  
		  
	    }//fin metod realizarVenta()
			
 }//fin clase Boutique

