package gestorAplicacion.usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Gerente extends Empleado implements Serializable {


    private static final long serialVersionUID = 1L;

    //ATRIBUTOS DE INSTANCIA

    private final int seguro= 1;

    //ATRIBUTOS DE CLASE
    private static long numeroGerente=0;
    private static ArrayList<Gerente>gerentes=new ArrayList<>();


    //CONSTRUCTOR

    public Gerente(String nombre, LocalDate fechaIngreso) {
        super(generarCodigo(), nombre, "Gerente", Sueldo.sueldoBase*2, fechaIngreso);
        gerentes.add(this);
    }

   /* // SOBRE CARGA DEL CONSTRUCTOR.
    //  No toma parámetros y llama al constructor usando valores predeterminados.
    public Gerente() {
        this("NN", false, null);
    }*/


    //OTROS METODOS
    public static long generarCodigo(){
        return numeroGerente++;
    }

    public String toString(){ //ligadura dinamica
        return "Codigo: "+this.getCodigo()+", Nombre: "+super.getNombre()+ ", Fecha de vinculacion: "+super.getFechaIngreso();
    }


    //METODOS ABSTRACTOS
    public String asegurar() {
        String s=super.asegurar();

        LocalDate finVinculacion= super.getFechaIngreso().plusMonths(this.getSeguro());

        if(LocalDate.now().isAfter(finVinculacion)){
            s+=" con codigo "+this.getCodigo()+" tiene vencido el seguro, este vencio en la fecha "+finVinculacion;
        }
        else{
            s+=" con codigo "+this.getCodigo()+" el seguro lo cubre desde la fecha "+this.getFechaIngreso()+" hasta la fecha "+finVinculacion;
        }
        return s;

    }
    public double calculoDePrima() {
        return this.getSueldo()*0.6;
    }
    //GETTERS Y SETTERS


    public int getSeguro() {
        return seguro;
    }

    public static long getNumeroGerente() {
        return numeroGerente;
    }

    public static void setNumeroGerente(long numeroGerente) {
        Gerente.numeroGerente = numeroGerente;
    }

    public static ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public static void setGerentes(ArrayList<Gerente> gerentes) {
        Gerente.gerentes = gerentes;
    }
    
    
    
    
    
    
    
    public String contratarEmpleado(String nombre, LocalDate fechaIngreso) {
	
    	Empleado empleadoNuevo;

		if (cargo.equals("Mesero")) {
			empleadoNuevo = new Trabajador(nombre,fechaIngreso);
		} else if (cargo.equals("Gerente")) {
			empleadoNuevo = new Gerente(nombre,fechaIngreso);
		} else if (cargo.equals("Striper")) {
			empleadoNuevo = new Trabajador(nombre,fechaIngreso);
		} else {
			empleadoNuevo = new Trabajador(nombre,fechaIngreso);
		}

		ArrayList<Empleado> listaEmpleados = Empleado.getEmpleados();
		if (!listaEmpleados.contains(empleadoNuevo)) {
			listaEmpleados.add(empleadoNuevo);
			Empleado.setEmpleados(listaEmpleados);
			return "Empleado " + nombre + " creado con éxito";
		} else {
			return "ERROR: El empleado ya se encuentra en la nomina";
		}
	}
    
    
    public String despedirEmpleado(String empleado) {
		ArrayList<Empleado> listaEmpleados = Empleado.getEmpleados();
		int empleadoCodigo;
		try {
			empleadoCodigo = Integer.parseInt(empleado);
			String nombreEmp = listaEmpleados.get(empleadoCodigo).getNombre();
			listaEmpleados.remove(empleadoCodigo);
			Empleado.setEmpleados(listaEmpleados);
			return "Empleado \"" + nombreEmp + "\" despedido con éxito";
		} catch (Exception e) {
			return "ERROR: El empleado que intentas eliminar no trabaja en el restaurante";
		}
	}




    public static void main(String[] args) {
        Empleado empleado;
        Trabajador trabajador = new Trabajador("Carlos", LocalDate.now());
        empleado = trabajador;
        empleado.asegurar();
    }

}
