
package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Trabajador;

import java.util.ArrayList;
import java.util.Iterator;

public class Administracion{
    
    private int fecha;
    private static ArrayList<Trabajador> trabajadores = new ArrayList<>();//arraylist de trabajadores
    private static ArrayList<Pedido> ventas = new ArrayList<Pedido>();//arraylist de los pedidos creados
    private static ArrayList<Producto> inventario = new ArrayList<>();//arraylist de los objetos creados

    private static ArrayList<Producto> productosPedidos = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();//arraylist de los clientes en el sistema
    //metodos


    public Cliente crearCliente(String nombre){
        return new Cliente(nombre);
    }
    public Pedido crearPedido(){
        return new Pedido();
    }
    public String mostrarProductos(){
        long i=1;
        String cadena="";
        for ( Producto e: inventario){
            cadena+="\n"+i+". nombre: "+e.getNombre();
            i++;
        }
        return cadena;
    }
    public String mostrarClientes(){
        long i=1;
        String cadena="";
        for ( Cliente e: clientes){
            cadena+="\nCliente: "+i+
                    "\nCodigo cliente: "+e.getCodigo()+
                    "\nNombre: "+e.getNombre()+
                    "\n";
            i++;
        }
        return cadena;
    }
    public Producto buscarProducto(String nombre){  // codigo del cliente
        Producto i = null;
        for (Producto e : inventario) {
            if (e.getNombre().equals(nombre)) {//los String se comparan con equals
                i=e;
                break;
            }
        }
        if (i!=null){
            Administracion.inventario.remove(i);
            Administracion.productosPedidos.add(i);
            return i;
        }
        else{
            return null;
        }
    }
    public Cliente buscarCliente(long codigo){  // codigo del cliente
        for (Cliente e : clientes) {
            if (e.getCodigo() == codigo) {
                return e;
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

    public static ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public static void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        Administracion.trabajadores = trabajadores;
    }

    public static ArrayList<Producto> getProductosPedidos() {
        return productosPedidos;
    }

    public static void setProductosPedidos(ArrayList<Producto> productosPedidos) {
        Administracion.productosPedidos = productosPedidos;
    }
}
