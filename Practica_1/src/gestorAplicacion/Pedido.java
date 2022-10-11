
package gestorAplicacion;

import java.util.ArrayList;

public class Pedido {
    private String estadoPedido;
    private ArrayList<Producto> productos = new ArrayList<Producto>();//arraylist de productos pedidos por el cliente
    private int fecha;
    private int id; //cuando se cree, se cree con el mismo ID del cliente    
    //constructor

    public Pedido(int fecha, int id) {
        this.estadoPedido="no pagado";
        this.fecha = fecha;
        this.id = id;
    }

    
    
    //metodos 
    public String generarFactura(){
        return("algo");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
