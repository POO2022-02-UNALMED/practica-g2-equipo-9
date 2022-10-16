
package gestorAplicacion.gestion;

import java.time.LocalDate;
import java.util.ArrayList;
import gestorAplicacion.usuarios.*;

public class Producto {
    //ATRIBUTOS INSTANCIA
    private Trabajador trabajador;
    private Pedido pedido;
    private Cliente cliente;
    private String estado; //agregue estado de producto, "VENDIDO", "NO VENDIDO"
    private String nombre;
    private double precioCompra;
    private double precioVenta;
    private long codigo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaIngreso;
    private LocalDate fechaVenta;
    private int disponibles;
    private int reservados;

    private int tipo; //"1. Bebidas alcoholicas", "2. Bebidas no alcoholicas", "3. Comida", "4. Snacks", "5. Cigarrillos", "6. Energizantes", "7. Otros"

    //ATRIBUTOS DE CLASE

    private static ArrayList<Producto> productos=new ArrayList<>();
    private static long numeroProducto=0;

    private static ArrayList<Producto> bebidasAlcoholicas = new ArrayList<>(); // En esta lista va la primera instancia de un nuevo producto de tipo bebidasAlcoholicas, es decir no se puede repetir
    private static ArrayList<Producto> bebidasNoAlcoholicas = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo bebidasNoAlcoholicas, es decir no se puede repetir
    private static ArrayList<Producto> comidas = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo comidas, es decir no se puede repetir
    private static ArrayList<Producto> snacks = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo snacks, es decir no se puede repetir
    private static ArrayList<Producto> cigarrillos = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo cigarrillos, es decir no se puede repetir
    private static ArrayList<Producto> energizantes = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo energizantes, es decir no se puede repetir
    private static ArrayList<Producto> otrosProductos = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo otrosProductos, es decir no se puede repetir

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
        this.estado = estado;
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

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static ArrayList<Producto> getBebidasAlcoholicas() {
        return bebidasAlcoholicas;
    }

    public static void setBebidasAlcoholicas(ArrayList<Producto> bebidasAlcoholicas) {
        Producto.bebidasAlcoholicas = bebidasAlcoholicas;
    }

    public static ArrayList<Producto> getBebidasNoAlcoholicas() {
        return bebidasNoAlcoholicas;
    }

    public static void setBebidasNoAlcoholicas(ArrayList<Producto> bebidasNoAlcoholicas) {
        Producto.bebidasNoAlcoholicas = bebidasNoAlcoholicas;
    }

    public static ArrayList<Producto> getComidas() {
        return comidas;
    }

    public static void setComidas(ArrayList<Producto> comidas) {
        Producto.comidas = comidas;
    }

    public static ArrayList<Producto> getSnacks() {
        return snacks;
    }

    public static void setSnacks(ArrayList<Producto> snacks) {
        Producto.snacks = snacks;
    }

    public static ArrayList<Producto> getCigarrillos() {
        return cigarrillos;
    }

    public static void setCigarrillos(ArrayList<Producto> cigarrillos) {
        Producto.cigarrillos = cigarrillos;
    }

    public static ArrayList<Producto> getEnergizantes() {
        return energizantes;
    }

    public static void setEnergizantes(ArrayList<Producto> energizantes) {
        Producto.energizantes = energizantes;
    }

    public static ArrayList<Producto> getOtrosProductos() {
        return otrosProductos;
    }

    public static void setOtrosProductos(ArrayList<Producto> otrosProductos) {
        Producto.otrosProductos = otrosProductos;
    }
}
