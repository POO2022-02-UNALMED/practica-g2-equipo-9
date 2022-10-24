
package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Trabajador extends Empleado implements Sueldo{

    //ATRIBUTOS DE INSTANCIA
    private int saldoFinal;
    private final int seguro = 6;



    private ArrayList<Cliente> ventasDia = new ArrayList<>();//listado de objetos cliente, es decir guarda los clientes con sus respectivos pedidos


    //ATRIBUTOS DE CLASE
    private static long numeroTrabajador = 0;
    private static ArrayList<Trabajador> trabajadores = new ArrayList<>();



    //CONSTRUCTOR

    public Trabajador(String nombre, LocalDate fechaIngreso) {
        super(generarCodigo(), nombre,"Trabajador", Sueldo.sueldoBase, fechaIngreso);
        trabajadores.add(this);
    }






    //GETTERS Y SETTERS

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public int getSeguro() {
        return seguro;
    }

    public ArrayList<Cliente> getVentasDia() {
        return ventasDia;
    }

    public void setVentasDia(ArrayList<Cliente> ventasDia) {
        this.ventasDia = ventasDia;
    }

    public static long getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public static void setNumeroTrabajador(long numeroTrabajador) {
        Trabajador.numeroTrabajador = numeroTrabajador;
    }



    public static ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public static void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        Trabajador.trabajadores = trabajadores;
    }

    //METODOS ABSTRACTOS
    public String asegurar() {
        LocalDate vinculacion= super.getFechaIngreso();
        LocalDate finVinculacion= super.getFechaIngreso().plusMonths(this.getSeguro());

        if(LocalDate.now().isAfter(finVinculacion)){
            return "Trabajador "+this.getNombre()+" "+" con codigo "+this.getCodigo()+" tiene vencido el seguro, este vencio en la fecha "+finVinculacion;
        }
        else{
            return "Trabajador "+ this.getNombre()+" con codigo "+this.getCodigo()+" el seguro lo cubre desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion;
        }

    }
    public double calculoDePrima() {
        return this.getSueldo()*0.5;
    }


    //OTROS METODOS
    public static long generarCodigo() {
        return numeroTrabajador++;
    }

    public String toString(){
        return "Codigo: "+this.getCodigo()+", Nombre: "+super.getNombre()+ ", Fecha de vinculacion: "+super.getFechaIngreso();
    }

    public static String mostrarTrabajadores(){ //Muestra todos los trabajadores
        String s="";
        int i =1;
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            s+="\n"+i+". Codigo: "+trabajador.getCodigo()+" Nombre: "+trabajador.getNombre();
            i++;
        }
        return s;
    }
    public static Trabajador seleccionarTrabajador(long codigo){//Escoge un trabajador por el codigo unico que tiene asignado
        Trabajador trabajadorSeleccionado=null;
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            if(trabajador.getCodigo()==codigo){
                trabajadorSeleccionado=trabajador;
                break;
            }
        }
        return trabajadorSeleccionado;
    }





    

}


 

    


