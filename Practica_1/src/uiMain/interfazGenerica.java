
package uiMain;

import gestorAplicacion.gestion.Informe;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.usuarios.Trabajador;

public class interfazGenerica {
    public static void main(String[] args) { //esto es solo un ejemplo
        Producto p1=new Producto(4, "cola", 4, 8, 1, 1);
        Producto p2=new Producto(4, "cola", 4, 8, 2, 1);
        Producto p3=new Producto(4, "pepsi", 4, 8, 1, 1);
        System.out.println(Informe.getInventario().size());
        for(Producto i:Informe.getInventario()){
            System.out.println(i.getNombre()+i.getCodigo());
        }
        System.out.println("\n");
        Producto a=Trabajador.ingresarArticulo("cola");
        System.out.println(Informe.getInventario().size());
        for(Producto i:Informe.getInventario()){
            System.out.println(i.getNombre()+i.getCodigo());
        }
        
        System.out.println("\n");
        System.out.println(a.getNombre()+a.getCodigo());
        
        
        
        
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