
package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;

import java.util.ArrayList;
import java.util.Iterator;

public class Administracion{
    
    private int fecha;
    private static ArrayList<Pedido> ventas = new ArrayList<Pedido>();//arraylist de los pedidos creados
    private static ArrayList<Producto> inventario = new ArrayList<Producto>();//arraylist de los objetos creados

    private static ArrayList<Cliente> clientes = new ArrayList<>();//arraylist de los clientes en el sistema
    //metodos

    public Producto buscarProducto(String nombre){  // Nombre del producto
        Iterator<Producto> iterator = inventario.iterator();
        while(iterator.hasNext()){
            Producto producto = (Producto) iterator.next();
            if (producto.getNombre()==nombre){
                return producto;
            }
            }
        return null;
        }

    public Cliente buscarCliente(long codigo){  // codigo del cliente
        Iterator<Cliente> iterator = clientes.iterator();
        while(iterator.hasNext()){
            Cliente cliente= (Cliente) iterator.next();
            if (cliente.getCodigo()==codigo){
                return cliente;
            }
        }
        return null;
    }


    public static void generarPedidoProveedor(int opcion){

    }
    
    public String estadisticasVentas(){
        return "algo";
    }
    
    //getters y setters

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public static ArrayList<Pedido> getVentas() {
        return ventas;
    }

    public static void setVentas(ArrayList<Pedido> ventas) {
        Administracion.ventas = ventas;
    }

    public static ArrayList<Producto> getInventario() {
        return inventario;
    }

    public static void setInventario(ArrayList<Producto> inventario) {
        Administracion.inventario = inventario;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Administracion.clientes = clientes;
    }
}
