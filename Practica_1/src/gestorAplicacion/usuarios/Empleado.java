package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Empleado extends Usuario {
    //ATRIBUTOS DE INSTANCIA
    protected String cargo;
    protected double sueldo;
    protected boolean estadoIngreso;


    protected LocalDate fechaCreacion; //fecha cuando se creo el empleado

    protected LocalDate fechaIngreso; //fecha cuando ingreso el empleado
    //ATRIBUTOS DE CLASE

    private static ArrayList<Empleado> empleados= new ArrayList<>();

    //CONSTRUCTOR

    public Empleado(long codigo, String nombre, String cargo, double sueldo, boolean estadoIngreso, LocalDate fechaCreacion, LocalDate fechaIngreso) {
        super(codigo, nombre);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.estadoIngreso = estadoIngreso;
        this.fechaCreacion = LocalDate.now();
        this.fechaIngreso = fechaIngreso;
        empleados.add(this);
    }


    //GETTERS Y SETTERS


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isEstadoIngreso() {
        return estadoIngreso;
    }

    public void setEstadoIngreso(boolean estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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


    public double calculoDePrima() {
        return this.getSueldo()*0.5;
    }

    //METODOS ABSTRACTOS
    public abstract String asegurar();


}
