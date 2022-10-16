
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

    public Trabajador(String nombre, String cargo, boolean estadoIngreso, LocalDate fechaIngreso, int saldoFinal, ArrayList<Cliente> ventasDia) {
        super(generarCodigo(), nombre, cargo, Sueldo.sueldoBase, estadoIngreso, fechaIngreso);
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
        LocalDate vinculacion= super.getFechaVinculacion();
        LocalDate finVinculacion= super.getFechaVinculacion().plusMonths(6);

        if(LocalDate.now().isAfter(finVinculacion)){
            return "Trabajador "+this.getNombre()+" "+" con codigo "+this.getCodigo()+" tiene vencido el seguro, este vencio en la fecha "+finVinculacion;
        }
        else{
            return "Trabajador "+ this.getNombre()+" con codigo "+this.getCodigo()+" el seguro lo cubre desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion;
        }

    }


    //OTROS METODOS
    public static long generarCodigo() {
        return numeroTrabajador++;
    }

    public String toString(){
        return "Codigo: "+this.getCodigo()+", Nombre: "+super.getNombre();
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
 

    


