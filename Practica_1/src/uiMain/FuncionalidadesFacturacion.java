package uiMain;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.usuarios.Trabajador;

import java.util.*;

public class FuncionalidadesFacturacion {
    public static void facturarPedido(){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Que operacion desea realizar? ")
        System.out.println("1. Ingresar Pedido nuevo");
        System.out.println("2. Ver listas de Pedidos NO PAGADO");

        int opcion = entrada.nextInt();

        if(opcion==1){
            //MOSTRAR TRABAJADORES
            System.out.println("Seleccione codigo de trabajador que atendera el pedido:");
            System.out.println(Trabajador.mostrarTrabajadores());
            long codigo= entrada.nextLong();
            Trabajador trabajadorSeleccionado=Trabajador.seleccionarTrabajador(codigo);
            System.out.println("Descripcion del trabajador seleccionado: ");
            System.out.println(trabajadorSeleccionado);
            System.out.println("");
            System.out.println("");

            while(true){
                System.out.println("Seleccione para:");
                System.out.println("1. Ingresar producto");
                System.out.println("2. Ingresar Servicios");
                System.out.println("3. Terminar/mostrar factura ");
                int opcion1= entrada.nextInt();
                if (opcion1==1){
                    //MOSTRAR PRODUCTOS DISPONIBLES Y CANTIDADES
                    SortedSet<String> nombres= new TreeSet<>();
                    for(Producto e: Producto.getProductos()){
                        nombres.add(e.getNombre());
                    }
                    ArrayList<Producto> productosDisponibles=new ArrayList<>();
                    long contador=1;
                    for(String nombreProducto: nombres){
                        long contadorDeProducto=0;
                        for(Producto producto: Producto.getProductos()){
                            if(nombreProducto.equals(producto.getNombre()) && producto.getEstado().equals("NO VENDIDO")){
                                contadorDeProducto++;
                                productosDisponibles.add(producto);
                            }
                        }
                        System.out.println("Nombre de producto: Cantidad en el inventario");
                        System.out.println();
                        System.out.println(contador+". "+nombreProducto+": "+ contadorDeProducto);
                        contador++;
                    }
                    System.out.println("Escoja nombre de producto:");
                    String nombreEscogido= entrada.next();
                    long cantidadEscogida;
                    while(true){
                        System.out.println("Escoja cantidad de producto a pedir:");
                        long a= entrada.nextLong();
                        if (a>=0 && a<=Collections.frequency(productosDisponibles,nombreEscogido) ){
                            cantidadEscogida=a;
                            break;
                        }
                        else{
                            System.out.println("No hay la cantidad escogida, escoja una cantidad valida");
                            System.out.println("");
                        }
                    }
                    ArrayList<Producto>productosPedidos=new ArrayList<>();
                    long contador2=0;
                    for (Producto producto: productosDisponibles) {
                        if (producto.getNombre().equals(nombreEscogido)) {
                            productosPedidos.add(producto);
                            contador2++;
                        }
                        if(contador2<cantidadEscogida){
                            break;
                        }
                    }
                    //Pedido pedido=new Pedido(trabajadorSeleccionado,null,"NO VENDIDO",productosPedidos,);

                    }
                if(opcion1==2){

                }
                if(opcion1==3){
                    break;
                }
            }
        }
    }
}
