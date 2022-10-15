package uiMain;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoField;

import gestorAplicacion.gestion.Espacio;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.gestion.*;

public class Funcionalidades {

    public static void realizarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al menu para realizar una Reserva");
        System.out.println("Por favor escoja un sitio a reservar disponible");
        ArrayList<Espacio> espaciosDisponibles = Espacio.getListado();
        for (int i = 0; i < espaciosDisponibles.size(); i++) { // ciclo para mostrar los espacios disponibles
            System.out.println(i + ". " + espaciosDisponibles.get(i).getNombre());
        }
        System.out.println("Ingrese su opcion: ");
        int opcion = sc.nextInt();
        while (opcion < 0 || opcion >= (espaciosDisponibles.size())) {
            System.out.println("Por favor ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }

        Espacio espacioTomado = espaciosDisponibles.get(opcion); // seleciona el espacio del atributo de clase espaciosDisponibles


        System.out.println("A continuacion le presentamos la disponibildiad del espacio: ");

        for (int i = 0; i < 10; i++) { // imprime los primeros 10 dias disponibles
            System.out.println(i + ". " + espacioTomado.getFechas().get(i));
        }
        System.out.println("Escoja una opcion ");
        opcion = sc.nextInt();
        while (opcion < 0 || opcion >= 10) {
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

    public static void contabilidad() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido al menu de contabilidad");

        System.out.println("Meses disponibles");

        //se buscan meses en los que se han comprado productos
        //tanteando cosas XD
        //Sorted set almacena las fechas de forma ordenada y no admite repetidos, lo hace automaticamente
        SortedSet<Integer> fechas = new TreeSet<Integer>();//meses unicos
        for (Producto producto : Producto.getProductos()) {
            //busca la fecha de venta de producto, luego obtiene de ella el int asociado al mes y lo guarda en fechas
            fechas.add(producto.getFechaVenta().getMonthValue());
        }
        HashMap<Integer,String> meses = new HashMap<Integer,String>();
        meses.put(1,"Enero"); meses.put(2,"Febrero"); meses.put(3, "Marzo"); meses.put(4, "Abril"); meses.put(5, "Mayo"); meses.put(6,"Junio");
        meses.put(7, "Julio");meses.put(8, "Agosto"); meses.put(9, "Septiembre"); meses.put(10, "Octubre"); meses.put(11, "Noviembre"); meses.put(12, "Diciembre");

        //Iterator lo uso para recorrer el Array fechas de forma secuencial
        Iterator value = fechas.iterator(); //El método iterator() nos va a permitir obtener un objeto de tipo Iterator que representa la colección a recorrer
        int i= 1;
        //.hasNext: Método que devuelve true si existe un siguiente elemento a la hora de iterar sobre una colección.
        while (value.hasNext()) {
            //aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
            System.out.println("["+i+"]"+" "+meses.get(value.next())+" de "+2022);
            i++;
        }
        System.out.println("Por favor ingresa una opcion");
        int opcion=entrada.nextInt();
        






    }

    public static void main(String[] args) {
        Producto producto = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto1 = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto2 = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 02, 1), 0, 0);
        Producto producto3 = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 12, 1), 0, 0);
        contabilidad();
    }
}

