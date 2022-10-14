
package gestorAplicacion.gestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Pedido {

    private String estadoPedido;
    private ArrayList<Producto> productos = new ArrayList<>();//arraylist de productos pedidos por el cliente
    private int fecha;
    private long codigo; //cuando se cree, se cree con el mismo ID del cliente

    private static long numeroPedido=0;
    //constructor
    public Pedido(){
        this.estadoPedido="No cobrado"; //estado pedido por defecto es no cobrado
        this.codigo=generarCodigo();
        this.fecha=fecha;
        Administracion.getVentas().add(this);

    }
    //metodos
    public String descripcionPedido(){
        long i=1;
        String cadena="";
        long total=0;
        for ( Producto e: productos){
            cadena+="\n"+i+". Nombre: "+e.getNombre()+"....Precio: "+e.getPrecioVenta();
            total+=e.getPrecioVenta();
            i++;
        }
        cadena+="\nTotal: "+total;
        return cadena;
    }
    public long generarCodigo(){
        return numeroPedido++;
    }

    public void cobrarProducto(){
        this.estadoPedido="cobrado";
    }
    public void reembolsarProducto(){
        this.estadoPedido="reembolsado";
    }

    public void eliminarProducto(String nombre){
        for(Producto i: productos){
            if (productos!=null) {
                if (i.getNombre() == nombre) {
                    productos.remove(i);
                    break;
                }
            }
        }
    }
    public void ingresarProducto(Producto producto){
        productos.add(producto);
    }

    public String listaProductos(){
        Iterator<Producto> iterator =productos.iterator();
        StringBuffer lista= new StringBuffer("Productos pedidos:\n");
        while(iterator.hasNext()){
            long i=0;
            Producto producto= (Producto) iterator.next();
            lista.append(producto.descripcionProducto()+"\n");
        }
        return lista.toString();
        }
    public String generarFactura(ArrayList<Producto> productos){
        
        Administracion.getVentas().add(this);
        return "algo";
    }
    
    //getters y setters

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

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
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
}
