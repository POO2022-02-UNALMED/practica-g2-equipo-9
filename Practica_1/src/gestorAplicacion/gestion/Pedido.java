
package gestorAplicacion.gestion;

import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
    private String estadoPedido;
    private ArrayList<Producto> productos = new ArrayList<Producto>();//arraylist de productos pedidos por el cliente
    private int fecha;
    private long codigo; //cuando se cree, se cree con el mismo ID del cliente

    private static long numeroPedido=0;
    //constructor
    Pedido(){
        1
        this.codigo=generarCodigo();
    }
    public long generarCodigo(){
        return numeroPedido++;
    }


    
    
    //metodos
    public void cobrar(){
        this.estadoPedido="cobrado"
    }
    public void reembolsar(){
        this.estadoPedido="reembolsar"
    }
    public void ingresarProducto(Producto producto){
        productos.add(producto);
    }
    public String listaProductos(){
        Iterator<Producto> iterator =productos.iterator();
        StringBuffer lista= new StringBuffer("Productos pedidos:\n");
        while(iterator.hasNext()){
            Producto producto= (Producto) iterator.next();
            lista.append(producto.descripcion()+"\n");
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        this.codigo = codigo;
    }



}
