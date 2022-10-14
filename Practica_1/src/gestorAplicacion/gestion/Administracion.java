
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

    //metodos para crear instancias de clase
    public Trabajador crearTrabajador(String nombre){
        return new Trabajador(nombre);
    }
    public Pedido crearPedido(){
        return new Pedido();
    }
    public Producto crearProducto(String nombre, int precioVenta){
        return new Producto(nombre,precioVenta);
    }
    public Cliente crearCliente(String nombre){
        return new Cliente(nombre);
    }


    //metodos para mostrar informacion de los objetos en las listas, las descripciones internas estan dentro de los propios objetos

    public String mostrarTrabajadores(){
        int i=1;
        String cadena="";
        for (Trabajador e: trabajadores){
            cadena+="\nTrabajador "+i+e.descripcionTrabajador();
            i++;
        }
        return cadena;
    }
    public String mostrarPedidos(){
        int i=1;
        String cadena="";
        for (Pedido e: ventas){
            cadena+="\nPedido "+i+e.descripcionPedido();
            i++;
        }
        return cadena;
    }
    public String mostrarProductos(){
        int i=1;
        String cadena="";
        for (Producto e: inventario){
            cadena+="\nProducto "+i+e.descripcionProducto();
            i++;
        }
        return cadena;
    }
    public String mostrarClientes(){
        int i=1;
        String cadena="";
        for (Cliente e: clientes){
            cadena+="\nCliente "+i+e.descripcionCliente();
            i++;
        }
        return cadena;
    }

    //metodos para buscar objetos
    public Trabajador buscarTrabajador(long codigo){  // busca en la lista trabajadores si el trabajador existe, devuelve un objeto tipo Trabajador
        for (Trabajador e : trabajadores) {
            if (e.getCodigo()==codigo) {
                return e;
            }
        }
        return null;
    }
    public Pedido buscarPedido(long codigo){ // busca en la lista ventas(pedido) si el pedido existe, devuelve un objeto tipo Pedido
        for (Pedido e : ventas) {
            if (e.getCodigo()==codigo) {
                return e;
            }
        }
        return null;
    }
    public Producto buscarProducto(long codigo){  // busca en el inventario si el producto existe, devuelve un objeto tipo Producto
        for (Producto e : inventario) {
            if (e.getCodigo()==codigo) {
                return e;
            }
        }
        return null;
    }
    public Cliente buscarCliente(long codigo){  // busca en clientes si el cliente existe, devuelve un objeto tipo Cliente
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
