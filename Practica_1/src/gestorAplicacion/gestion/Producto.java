
package gestorAplicacion.gestion;

import java.time.LocalDate;
import java.util.ArrayList;
import gestorAplicacion.usuarios.*;

public class Producto {
    //ATRIBUTOS INSTANCIA
    private Trabajador trabajador;
    private Pedido pedido;
    private Cliente cliente;
    private String estado; //agregue estado de producto, "Vendido", "no vendido"
    private String nombre;
    private int precioCompra;
    private int precioVenta;
    private long codigo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaIngreso;
    private LocalDate fechaVenta;
    private int disponibles;
    private int reservados;

    //ATRIBUTOS DE CLASE

    private static ArrayList<Producto> productos=new ArrayList<>();
    private static long numeroProducto=0;

    //GETTER y SETTER de productos importante para muchas cosas
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    
    //CONSTRUCTOR


    public Producto(Trabajador trabajador, Pedido pedido, String estado, String nombre, int precioCompra, int precioVenta, LocalDate fechaVencimiento, LocalDate fechaIngreso, LocalDate fechaVenta, int disponibles, int reservados) {
        this.trabajador = trabajador;
        this.pedido = pedido;
        this.estado = "no Vendido";
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.codigo = generarCodigo();
        this.fechaVencimiento = fechaVencimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaVenta = fechaVenta;
        this.disponibles = disponibles;
        this.reservados = reservados;
        productos.add(this);
    }


    public static long generarCodigo(){
        return numeroProducto++;
    }


    public String descripcionProducto(){
        return "\nNombre: "+this.getNombre()+
                "\nCodigo: "+this.getCodigo()+
                "\nPrecio venta: "+this.getPrecioVenta();
    }
    
         //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getReservados() {
        return reservados;
    }

    public void setReservados(int reservados) {
        this.reservados = reservados;
    }

    public static long getNumeroProducto() {
        return numeroProducto;
    }

    public static void setNumeroProducto(long numeroProducto) {
        Producto.numeroProducto = numeroProducto;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }



    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Producto.productos = productos;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
