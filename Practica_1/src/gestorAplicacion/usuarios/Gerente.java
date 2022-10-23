package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends Empleado implements Sueldo{

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

    //OTROS METODOS
    public static long generarCodigo(){
        return numeroGerente++;
    }

    public String toString(){
        return "Codigo: "+this.getCodigo()+", Nombre: "+super.getNombre()+ ", Fecha de vinculacion: "+super.getFechaVinculacion();
    }


    //METODOS ABSTRACTOS
    public String asegurar() {
        LocalDate vinculacion= super.getFechaVinculacion();
        LocalDate finVinculacion= super.getFechaVinculacion().plusYears(this.getSeguro());

        if(LocalDate.now().isAfter(finVinculacion)){
            return "Gerente "+this.getNombre()+" "+" con codigo "+this.getCodigo()+", tiene vencido el seguro, este vencio en la fecha "+finVinculacion;
        }
        else{
            return "Gerente "+ this.getNombre()+" con codigo "+this.getCodigo()+", lo cubre el seguro desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion;
        }

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


}
