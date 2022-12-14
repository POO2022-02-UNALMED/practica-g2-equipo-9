package gestorAplicacion.gestion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/*
* Clase hecha para los espacios fisicos de la discoteca
* Cada reserva debe tener un espacio asociado
* Las fechas para cada obejto de tipo espacio creado son independientes
*/

public class Espacio implements Serializable {
    private static final long serialVersionUID = 1L;


    //ATRIBUTOS DE INSTANCIA
    private String nombre; //nombre del espacio

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

    //CONSTRUCTORES


    public Espacio(String nombre) {
        this.nombre = nombre;
        this.generarFechasDisponibles();
        Espacio.listado.add(this);
    }


    public LocalDate seleccionarFecha(int opcion){ //metodo que selecciona la fecha del espacio segun las opcion pasada como parametro

        LocalDate fechaTomada = this.getFechas().get(opcion);
        this.getFechas().remove(opcion); // se quita la disponibilidad de la fecha seleccionada
        return fechaTomada; //retorna la fecha tomada por el usuario
    }
    public void reordenarFechas(Reserva reserva){ //metodo utilizado para reordenar las fechas disponibles una vez se cancela o modifica una reserva de un espacio
        for (int i = 0; i < fechas.size(); i++) {
            if(fechas.get(i).isBefore(reserva.getFechaReserva()) && fechas.get(i+1).isAfter(reserva.getFechaReserva())){
                fechas.add(i+1, reserva.getFechaReserva());
                break;
            }
            else if (fechas.get(i).isBefore(reserva.getFechaReserva()) && i==fechas.size()-1) {
                fechas.add(reserva.getFechaReserva());
                break;
            }
            else if (fechas.get(i).isAfter(reserva.getFechaReserva()) && i==0) {
                fechas.add(0, reserva.getFechaReserva());
                break;

            }

        }

    }

    public void actualizarFechas(){ //metodo para eliminar fechas ya vencidas
        for (LocalDate fecha:
                fechas) {
            if(fecha.isBefore(LocalDate.now())){
                fechas.remove(fecha);
            }
        }
    }

    public void generarFechasDisponibles(){ // metodo para generar fechas disponibles una vez se crea un espacio
        this.fechas.add(LocalDate.now());
        for (int i = 1; i < 30; i++) {
            this.fechas.add(LocalDate.now().plusDays(i));
        }
    }




}
