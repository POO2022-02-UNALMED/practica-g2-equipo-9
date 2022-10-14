
package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Administracion;
import gestorAplicacion.gestion.Producto;

import java.util.ArrayList;

public class Trabajador extends Empleado {

    //ATRIBUTOS DE INSTANCIA
    private int base;
    private int saldoFinal;

    private final int seguro=6;

    private ArrayList<Cliente> ventasDia = new ArrayList<>();//listado de objetos cliente, es decir guarda los clientes con sus respectivos pedidos


    //ATRIBUTOS DE CLASE
    private static long numeroTrabajador=0;


    //CONSTRUCTOR
    public Trabajador(String nombre) {
        super(generarCodigo(),nombre);
        Administracion.getTrabajadores().add(this);
    }


    //metodos

    public String descripcionTrabajador(){
        return "\nNombre: "+this.getNombre()+
                "\nCodigo: "+this.codigo;
    }
    public static long generarCodigo(){
        return numeroTrabajador++;
    }
    public void ingresarArticulo(Producto producto){//yo creo que esto es mas como ingresar pedido

            
    }
    //
    public void verificarProducto(){ //producto vencido?
        
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public ArrayList<Cliente> getVentasDia() {
        return ventasDia;
    }

    public void setVentasDia(ArrayList<Cliente> ventasDia) {
        this.ventasDia = ventasDia;
    }

    //METODOS ABSTRACTOS
    public String asegurar(){
        return "algo";
    }
}
 

    


