
package uiMain;

import gestorAplicacion.gestion.Informe;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Trabajador;

public class interfazGenerica {

    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<saludoIngreso> saludo = new ArrayList<>();

    public static void main(String[] args) { //esto es solo un ejemplo
        System.out.println("Hola");




        /*
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

        while (true) {
            System.out.println();
            System.out.println("-------      Menú principal del sistema       -------");
            System.out.println("Bienvenido al sistema de Unbar");
            System.out.println("Escoja una opcion");
            System.out.println("1. Ingresar");
            System.out.println("2. Registrarse ");
            System.out.println("0. salir");
            System.out.println("------------------------------------------------------");
            System.out.println();
            option = input.next();
            if (option.equals("1")) {
                ingresar();
            } else if (option.equals("2")) {
                registrarse();
            } else if (option.equals("0")) {
                break;
            }
        }
        
        
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
    public static void ingresar() {
        System.out.println("-                   Iniciar sesión                   -");
        System.out.println("-   Ingrese su numero de documento/correo electronico:");
        String ingreso = input.next();
        boolean res;
        try {
            Integer.parseInt(ingreso);
            res = true;
        } catch (NumberFormatException excepcion) {
            res = false;
        }
    }
    public static void registrarse(){

    }
}
