
package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Producto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trabajador extends Empleado implements Sueldo{

    //ATRIBUTOS DE INSTANCIA
    private int saldoFinal;
    private final int seguro = 6;

    private ArrayList<Cliente> ventasDia = new ArrayList<>();//listado de objetos cliente, es decir guarda los clientes con sus respectivos pedidos


    //ATRIBUTOS DE CLASE
    private static long numeroTrabajador = 0;
    private static ArrayList<Trabajador> trabajadores = new ArrayList<>();


    //CONSTRUCTOR

    public Trabajador(String nombre, String cargo, boolean estadoIngreso, LocalDate fechaCreacion, LocalDate fechaIngreso, int saldoFinal, ArrayList<Cliente> ventasDia) {
        super(generarCodigo(), nombre, cargo, Sueldo.sueldoBase, estadoIngreso, fechaCreacion, fechaIngreso);
        this.saldoFinal = saldoFinal;
        this.ventasDia = ventasDia;
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
        return "algo";
    }


    //OTROS METODOS
    public static long generarCodigo() {
        return numeroTrabajador++;
    }

    //Este metodo me ayuda a saber que comision gana un trabajador por los productos que vente
    public static double comisionTrabajador(Trabajador trabajador){
        double comisionPorProducto=0;

        for (Producto e: Producto.getProductos()){
            if (e.getEstado().equals("VENDIDO") && e.getTrabajador()==trabajador){
                comisionPorProducto+=e.getPrecioVenta()*Sueldo.porcentajeComision;
            }
            }
        return comisionPorProducto;
        }


}
 

    


