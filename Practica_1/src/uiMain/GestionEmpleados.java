package uiMain;

import java.util.*;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Trabajador;

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
        	//contratar un trabajador
        	
        	ArrayList<Empleado> empleados= new ArrayList<>();
            for (Trabajador trabajador: Trabajador.getTrabajadores()){
                empleados.add(trabajador);
            }
        }
        else if(opcion == 3) {
<<<<<<< Updated upstream
        	
			for(int i=0; i<Empleado.getEmpleados().size();i++) {
=======
        	//info del algun trabajador
		//	for(int i=0; i<empleados.length;i++) {
>>>>>>> Stashed changes
        		
        	}
        }
	//}
	
	
	
	
	// contratar un nuevo empleado;
	
	static void ContratarEmpleado(){
			
	}
	// despides algun empleado
	static void DespedirEmpleado() {
		
		}
	
}
