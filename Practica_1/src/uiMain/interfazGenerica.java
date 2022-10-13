
package uiMain;

import java.util.Scanner;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Administracion;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;
import gestorAplicacion.usuarios.Usuario;

public class interfazGenerica {
    static Scanner entrada= new Scanner(System.in);
    static long leerNumero(){ //leer numero
        return entrada.nextLong();
    }

    static String leerString(){ //leer numero
        entrada.nextLine();
        return entrada.nextLine();
    }

    public static void main(String[] args) {
        Cliente cliente1= new Cliente("sergio");
        Producto producto1=new Producto("Coca cola");
        Producto producto2=new Producto("Pepsi");
        Administracion admin=new Administracion();
        int opcion;
        do {
            System.out.println("Que operacion desea realizar?");
            System.out.println("1. Ingresar pedido");
            System.out.println("2. Salir del sistema");
            opcion =(int) leerNumero();

            switch(opcion){
                case 1:ingresarPedido(admin); break;
                case 2:break;
            }
        }while(opcion !=2);

    }
    static void ingresarPedido(Administracion admin){
            while(true){
                System.out.println("1. Ingresar producto a cliente nuevo");
                System.out.println("2. Ingresar producto a cliente existente");
                System.out.println("3. Regresar");
                long opcion=leerNumero();
                if (opcion==1){

                }
                else if(opcion==2){
                        System.out.println("Ingresa codigo cliente");
                        long codigo=leerNumero();

                        if(admin.buscarCliente(codigo)!=null){
                            Pedido a=Pedido.crearPedido();
                            admin.buscarCliente(codigo).ingresarPedido(a);
                            while(true){
                                System.out.println("1. Ingresa producto");
                                System.out.println("2. Terminar pedido");
                                System.out.println("3. Cobrar pedido");
                                long opcion2=leerNumero();
                                if (opcion2==1){
                                    System.out.println("Ingresa nombre producto");
                                    String nombre=leerString();
                                    if (admin.buscarProducto(nombre)!=null) {
                                        a.ingresarProducto(admin.buscarProducto(nombre));
                                    }
                                }
                                else if (opcion2==2){
                                    break;
                                }
                                else if (opcion2==3){
                                    
                                }
                                else{
                                    System.out.println("Opcion no valida");
                                }
                            }


                }
                else if(opcion==3){
                    break;
                }
                else {
                    System.out.println("Ingresa una opcion valida:");
                }
            }


        }
    }


    /*public static Scanner input = new Scanner(System.in);
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
        
    /*}
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

    }*/
}
