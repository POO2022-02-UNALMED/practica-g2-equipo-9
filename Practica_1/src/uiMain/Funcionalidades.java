package uiMain;

import java.time.LocalDate;
import java.util.*;
import static java.util.Map.entry;
import java.time.temporal.ChronoField;

import gestorAplicacion.gestion.Administracion;
import gestorAplicacion.gestion.Espacio;
import gestorAplicacion.gestion.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.gestion.*;

public class Funcionalidades {

    public static void realizarReserva(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al menu para realizar una Reserva");
        System.out.println("Por favor escoja un sitio a reservar disponible");
        ArrayList<Espacio> espaciosDisponibles = Espacio.getListado();
        for (int i = 0; i < espaciosDisponibles.size(); i++) { // ciclo para mostrar los espacios disponibles
            System.out.println(i+". "+espaciosDisponibles.get(i).getNombre());
        }
        System.out.println("Ingrese su opcion: ");
        int opcion = sc.nextInt();
        while(opcion<0 || opcion >=(espaciosDisponibles.size())){
            System.out.println("Por favor ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }

        Espacio espacioTomado = espaciosDisponibles.get(opcion); // seleciona el espacio del atributo de clase espaciosDisponibles


        System.out.println("A continuacion le presentamos la disponibildiad del espacio: ");

        for (int i = 0; i < 10; i++) { // imprime los primeros 10 dias disponibles
            System.out.println(i+". "+espacioTomado.getFechas().get(i));
        }
        System.out.println("Escoja una opcion ");
        opcion = sc.nextInt();
        while(opcion<0 || opcion >= 10){
            System.out.println("Por favor ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }
        LocalDate fechaTomada = espacioTomado.getFechas().get(opcion);
        espacioTomado.getFechas().remove(opcion); // se quita la disponibilidad de la fecha seleccionada
        System.out.println("Desea agregar servicios adicionales a la reserva? ");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        opcion = sc.nextInt();




    }

    public static void contabilidad(){
        System.out.println("Bienvenido al menu de contabilidad");

        System.out.println("Meses disponibles");

        //se buscan meses en los que se han comprado productos y
        SortedSet<Integer> fechas =new TreeSet<Integer>();//meses unicos
        for (Producto productos: )

    }
}
