
package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Trabajador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Pedido {

    //ATRIBUTOS DE INSTANCIA

    private Trabajador trabajador;
    private Cliente cliente;
    private String estadoPedido;
    private ArrayList<Producto> productos = new ArrayList<>();//arraylist de productos pedidos por el cliente

    private ArrayList<Servicio> servicios =new ArrayList<>();//arraylist de servicios pedidos por el cliente
    private LocalDate fecha;
    private long codigo; //cuando se cree, se cree con el mismo ID del cliente

    //ATRIBUTOS DE CLASE

    private static ArrayList<Pedido> pedidos= new ArrayList<>();
    private static long numeroPedido=0;
    //CONSTRUCTOR

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Pedido.pedidos = pedidos;
    }


    //GETTERS Y SETTERS

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        this.codigo = codigo;
    }

    public static long getNumeroPedido() {
        return numeroPedido;
    }

    public static void setNumeroPedido(long numeroPedido) {
        Pedido.numeroPedido = numeroPedido;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    //METODOS
    public long generarCodigo(){
        return numeroPedido++;
    }

    public void cobrarProducto(){
        this.estadoPedido="cobrado";
    }
    public void reembolsarProducto(){
        this.estadoPedido="reembolsado";
    }

    public void ingresarProducto(Producto producto){
        productos.add(producto);
    }

}
