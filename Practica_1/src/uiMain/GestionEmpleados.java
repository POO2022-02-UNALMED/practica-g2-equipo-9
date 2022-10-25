package uiMain;

import java.time.LocalDate;
import java.util.*;
import gestorAplicacion.usuarios.*;


public class GestionEmpleados {
	
	static Scanner sc = new Scanner(System.in);
	
	static String readString() {
        return sc.nextLine();
    }

    static int readInt() {
        return sc.nextInt();
    }

    static double readDouble() {
        return sc.nextDouble();
    }

    static void pressEnter() {
        System.out.println("\n Presiona Enter para continuar");
        readString();
    }
    
	public static void GE() {
		
		/*
		System.out.println("Buen dia, es usted un Gerente o Administrador?");
        System.out.println("1. Si");
        System.out.println("2. No");
		*/
		
		
		
		System.out.println("Bienvenido al sistemas de gestion de empleados");
		System.out.println("Que se le ofrese el dia de hoy");
        
		String opcion;
        
        do {
        	System.out.println(" 1. Contratar empleado");
            System.out.println(" 2. Despedir empleado");
            System.out.println(" 3. Informacion sobre empleado");
            System.out.println(" 0. Volver al menu principal\n");

            opcion = readString();

            switch (opcion){
                case "1":
                   // contratar();
                	System.out.println("Contratar empleado\n");
                	
                	System.out.println("Ingrese el codigo que le dara al empleado");
                	String code = readString();
                	int codigo;
                	
                	try {
                			codigo = Integer.parseInt(code);
                	}catch(Exception e) {
                		codigo = -1;
                	}
                	
                	System.out.println("Ingresar Nombre del empleado");
                	String Nombre = readString();
                	
                	System.out.println("Ingresar cargo, puede ser: Mesero, Gerente, Striper, bartender");
                	String cargo = readString();
                	
                	
                	
                	
                	System.out.println(Gerente.contratarEmpleado(Nombre, Fecha));
                	
                	Empleado enpleadoNuevo = Empleado.getEmpleados().get(Empleado.getEmpleados().size()-1);
                	
                	System.out.println();
                    break;
                case "2":
                    //despedir();
                	System.out.println("");
                    break;
                case "3":
                    //info_empleados();
                    break;
                case "0":
                    break;

                default:
                    System.out.println("\nLa opcion ingresada no es valida. Por favor presione Enter");
                    pressEnter();
                    break;
            }
        }
        
	   
     
        while(0 < 1 && 4> 3);{
         
        }


       
        
    }
	
	
}
