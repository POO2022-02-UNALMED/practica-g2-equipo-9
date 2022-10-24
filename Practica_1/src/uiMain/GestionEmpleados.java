package uiMain;

import java.util.*;
import gestorAplicacion.usuarios.Empleado;

public class GestionEmpleados {
	
	public static void GE() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Buen dia admin, que se le ofrece el dia de hoy");
        System.out.println("1. Despedir un empleado");
        System.out.println("2. Contratar un empleado");
        System.out.println("3. Informacion de algun empleado");
     
        int opcion = sc.nextInt();
        
        while(opcion < 1 && opcion> 3){
         
        	System.out.println("Por favor ingrese una opcion valida");
            
        	opcion = sc.nextInt();
            
        	System.out.println("Buen dia admin, que se le ofrece el dia de hoy");
            System.out.println("1. Despedir Empleado");
            System.out.println("2. Contratar Empleado");
            System.out.println("3. Informacion de empleado");
      
        }
        if(opcion == 1) {
        	

        	System.out.println("que empleado desea eliminar");
        	
        	int p;
        	Scanner sc1 = new Scanner(System.in);
        	
        }
        else if(opcion == 2){
        	
        }
        else if(opcion == 3) {
        	
			for(int i=0; i<Empleado.getEmpleados().size();i++) {
        		
        	}
        }
	}
	
	
	
	
	// contratar un nuevo empleado;
	
	static void ContratarEmpleado(){
			
	}
	// despides algun empleado
	static void DespedirEmpleado() {
		
		}
	
}
