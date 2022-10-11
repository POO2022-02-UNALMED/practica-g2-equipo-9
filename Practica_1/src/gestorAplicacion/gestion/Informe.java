
package gestorAplicacion.gestion;

import java.util.ArrayList;

public class Informe{
    
    private int fecha;
    private static ArrayList<Pedido> ventas = new ArrayList<Pedido>();//arraylist de los pedidos creados
    private static ArrayList<Producto> inventario = new ArrayList<Producto>();//arraylist de los objetos creados
    
    //metodos 
    public static void generarPedidoProveedor(int opcion){
        switch(opcion){
            case 1 -> {
                new Producto(4, "cola", 4, 8, 1, 1);
            }
                
            case 2 -> {
                new Producto(4, "pepsi", 4, 8, 1, 1);
            }
    }
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
        Informe.ventas = ventas;
    }

    public static ArrayList<Producto> getInventario() {
        return inventario;
    }

    public static void setInventario(ArrayList<Producto> inventario) {
        Informe.inventario = inventario;
    }
    
    
}
