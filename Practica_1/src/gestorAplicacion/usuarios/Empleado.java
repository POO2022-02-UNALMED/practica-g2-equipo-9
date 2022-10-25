package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;
/*
* Clase de la que heredan Trabajador y Gerente
* Contiene atributos y metodos comunes para los empleados de la discoteca
*
* */

public abstract class Empleado extends Usuario implements Serializable, Sueldo {

    private static final long serialVersionUID = 1L;

    //ATRIBUTOS DE INSTANCIA
    protected String cargo;
    protected double sueldo;

    protected LocalDate fechaIngreso; //fecha cuando ingreso el empleado
    //ATRIBUTOS DE CLASE

    private static ArrayList<Empleado> empleados= new ArrayList<>();
    protected boolean disponibilidad;



    //CONSTRUCTOR

    public Empleado(long codigo, String nombre, String cargo, double sueldo, LocalDate fechaIngreso) {
        super(codigo, nombre);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
        empleados.add(this);
    }
    
    
    public String toString() {
    	
    	return nombre+","+cargo+","+sueldo+","+","+fechaIngreso+","+codigo;
    }


    //GETTERS Y SETTERS


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static void setEmpleados(ArrayList<Empleado> empleados) {
        Empleado.empleados = empleados;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void aumentarSueldo(double porcentajeAumento) {
        this.setSueldo(this.getSueldo()*(1+porcentajeAumento));
    }

    public boolean getDisponibilidad() {
        return this.disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }



    //OTROS METODOS

    public String informacion() { // retorna la disponibilidad del empleado
        if (this.getDisponibilidad()) {
            return "El Empleado " + this.nombre + "\n" + "Tiene un sueldo de: $" + this.sueldo
                    + " y desempeña el cargo de " + this.cargo + ".\n" + "Ingreso en la fecha:"+ this.fechaIngreso
                    + "Está disponible actualmente.";
        } else {
            return "El Empleado " + this.nombre +  "\n" + "Tiene un sueldo de: $" + this.sueldo
                    + " y desempeña el cargo de " + this.cargo + ".\n"  + "Ingreso en la fecha:"+ this.fechaIngreso
                    + "No está disponible actualmente.";
        }
    }

    public String asegurar(){ //muestra la fecha de ingreso y la fecha de finalizacion del seguro
        String s="La fecha de vinculacion del trabajador es: "+this.getFechaIngreso()+
                "\nEl nombre del empleado es "+this.getNombre();
        return s;
    }





}
