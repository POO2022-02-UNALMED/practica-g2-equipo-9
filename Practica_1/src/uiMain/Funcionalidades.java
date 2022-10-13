package uiMain;
import gestorAplicacion.gestion.Administracion;
import gestorAplicacion.gestion.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionalidades {
    static Scanner sc = new Scanner(System.in);
    public static void generarInformeVentas(){
        ArrayList<Pedido> pedidosFechas = new ArrayList<>();
        System.out.println("A continuacion ingrese ingrese las opciones de acuerdo a los datos requeridos en su informe:\n");
        System.out.println("Ingrese la fecha inicial de su informe");
        int inicial = sc.nextInt();
        while(inicial < 0){
            System.out.println("Por favor ingrese una fecha valida");
            inicial = sc.nextInt();
        }
        System.out.println("Ingrese la fecha final de su informe");
        int fin = sc.nextInt();
        while (fin<=inicial){ // la fecha final del informe debe ser mayor que la fecha inicial.
            System.out.println("Por favor ingrese valida");
            fin = sc.nextInt();
        }

        for (int i = inicial; i < fin; i++) {
            if (Administracion.getVentas().get(i).getFecha() >= inicial & Administracion.getVentas().get(i).getFecha() <= fin )
            pedidosFechas.add(Administracion.getVentas().get(i));

        }



    }
}
