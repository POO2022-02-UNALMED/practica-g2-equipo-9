package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;

public abstract class Empleado extends Usuario {
    //ATRIBUTOS DE INSTANCIA
    protected String cargo;
    protected double sueldo;
    protected boolean estadoIngreso;


    protected LocalDate fechaVinculacion; //fecha cuando se creo el empleado

    protected LocalDate fechaIngreso; //fecha cuando ingreso el empleado
    //ATRIBUTOS DE CLASE

    private static ArrayList<Empleado> empleados= new ArrayList<>();



    //CONSTRUCTOR

    public Empleado(long codigo, String nombre, String cargo, double sueldo, boolean estadoIngreso, LocalDate fechaIngreso) {
        super(codigo, nombre);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.estadoIngreso = estadoIngreso;
        this.fechaVinculacion = LocalDate.now();
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

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
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



    //OTROS METODOS



    //METODOS ABSTRACTOS
    public abstract String asegurar();

    public abstract double calculoDePrima();

    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_empleados_datos = new FileInputStream("/empleado.dat");

            ObjectOutputStream empleados_datos = new ObjectOutputStream(archivo_empleados_datos);
        
            empleados_datos.writeObject(empleados);
        
            empleados_datos.close();

            archivo_empleados_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception e){
            System.out.println("ERROR");
        }
    }
    
    public void Load (){
        try{
            FileOutputStream archivo_empleados_recuperar = new FileInputStream("/empleado.dat");
            
            ObjectInputStream empleados_recuperar= new ObjectInputStream(archivo_empleados_recuperar);

            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Empleado[] empleados_recuperados=(Empleado[]) empleados_recuperar.readObject();
            
            empleados_recuperar.close();

            archivo_empleados_recuperar.close();

            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Usuario ee: empleados_recuperados){
                System.out.println(ee);
            }
                
            System.out.println("DATOS CARGADOS");
        }
            
        catch (Exception ee){
            System.out.println("ERROR");
        }

    }
}
