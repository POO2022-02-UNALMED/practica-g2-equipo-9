package gestorAplicacion.gestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;


public class Espacio {
    //ATRIBUTOS DE INSTANCIA
    private String nombre;

    private ArrayList<LocalDate> fechas = new ArrayList(); // fechas disponibles para un espacio
    // ATRIBUTOS DE CLASE
    private static ArrayList<Espacio> listado = new ArrayList<>();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Espacio> getListado() {
        return listado;
    }

    public static void setListado(ArrayList<Espacio> listado) {
        Espacio.listado = listado;
    }

    public ArrayList<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<LocalDate> fechas) {
        this.fechas = fechas;
    }


    public LocalDate seleccionarFecha( int n){ //metodo para mostrar las primeras n fechas disponibles para un espacio tomado
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println(i+". "+this.getFechas().get(i));
        }
        System.out.println("Por favor ingrese la opcion correspondiente a la fecha que deas seleccionar");
        int opcion = sc.nextInt();

        while (opcion<0 || opcion >=n){ //verificar que el usuario ingrese una opcion valida
            System.out.println("Por favor ingrese una opcion valida");
            opcion=sc.nextInt();
        }
        this.getFechas().remove(opcion); // se quita la disponibilidad de la fecha seleccionada

        return this.getFechas().get(opcion); //retorna la fecha tomada por el usuario
    }
    public void reordenarFechas(){ //metodo utilizado para reordenar las fechas disponibles una vez se cancela una reserva de un espacio


    }


}
