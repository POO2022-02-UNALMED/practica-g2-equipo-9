
package gestorAplicacion;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public static void main(String[] args) { //esto es solo un ejemplo
        Producto p1=new Producto(4, "cola", 4, 8, 1, 1);
        Producto p2=new Producto(4, "cola", 4, 8, 2, 1);
        Producto p3=new Producto(4, "pepsi", 4, 8, 1, 1);
        System.out.println(Informe.getInventario().size());
        for(Producto i:Informe.getInventario()){
            System.out.println(i.getNombre()+i.getCodigo());
        }
        System.out.println("\n");
        Trabajador.ingresarArticulo("cola");
        System.out.println(Informe.getInventario().size());
        for(Producto i:Informe.getInventario()){
            System.out.println(i.getNombre()+i.getCodigo());
        }
        System.out.println("\n");
        
        
        
        
        /*Scanner entrada=new Scanner(System.in);
        
        System.out.println("estas son las opciones:");
        
        
        boolean a=true;
        while(a){
            System.out.println("Presiona:");
            System.out.println("1.presiona para agregar producto");
            System.out.println("2.suma");
            System.out.println("3.para tamaño de inventario");
            System.out.println("4.salir");
            
            System.out.println("Presiona una opcion: ");
            int opcion =entrada.nextInt();
            switch(opcion){
                
            case 1 -> {
                boolean b=true;
                while(b){
                    
                    System.out.println("1. Agregar Coca cola");
                    System.out.println("2. Agregar Pepsi");
                    System.out.println("3. salir");
                    opcion=entrada.nextInt();
                    switch(opcion){
                        case 1 -> {
                            Informe.generarPedidoProveedor(opcion);
                    }
                        case 2 -> {
                            Informe.generarPedidoProveedor(opcion);
                    }
                        case 3 -> b=false;
                }
                
            }
            }
            case 2 -> System.out.println("soy suma");
            case 3 -> System.out.println(Informe.getInventario().size());
            case 4 -> a = false;
            }
        }*/
        
    }
}
