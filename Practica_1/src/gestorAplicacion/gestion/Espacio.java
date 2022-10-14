package gestorAplicacion.gestion;

import java.time.LocalDate;
import java.util.ArrayList;


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
}
