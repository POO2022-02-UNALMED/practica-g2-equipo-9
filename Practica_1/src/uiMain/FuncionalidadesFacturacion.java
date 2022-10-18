package uiMain;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Servicio;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Trabajador;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class FuncionalidadesFacturacion {
    public static void facturarPedido(){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Que operacion desea realizar? ");
        System.out.println("1. Ingresar Pedido a nuevo cliente");
        System.out.println("2. Agregar Pedido a cliente existente");
        System.out.println("3. Ver listas de Pedidos no pagados");

        int opcion = entrada.nextInt();

        if(opcion==1){ //INGRESAR PEDIDO A CLIENTE NUEVO
            System.out.println("Lista de trabajadores:");
            //MUESTRA EL LISTADO DE TRABAJADORES
            System.out.println(Trabajador.mostrarTrabajadores());
            System.out.println("Ingresa codigo del trabajador: ");
            long codigo = entrada.nextInt();//codigo de empleado
            //buscamos el codigo del trabajador
            Trabajador trabajadorSeleccionado=Trabajador.seleccionarTrabajador(codigo);
            while(trabajadorSeleccionado==null){
                System.out.println("Codigo de trabajador no existe, ingrese uno valido");
                codigo= entrada.nextInt();
                trabajadorSeleccionado=Trabajador.seleccionarTrabajador(codigo);
            }
            System.out.println("Descripcion del trabajador seleccionado:");
            System.out.println(trabajadorSeleccionado);
            System.out.println();
            System.out.println();

            System.out.println("Productos disponibles: ");
            //MOSTRAR PRODUCTOS DISPONIBLES Y CANTIDADES
            SortedSet<String> nombres= new TreeSet<>();
            for(Producto e: Producto.getProductos()){
                nombres.add(e.getNombre());
            }
            System.out.println("Nombre de producto: Cantidad en el inventario");
            ArrayList<Producto> productosDisponibles=new ArrayList<>();
            long contador=1;
            for(String nombreProducto: nombres){
                long contadorDeProducto=0;
                for(Producto producto: Producto.getProductos()){
                    if(nombreProducto.equals(producto.getNombre()) && producto.getEstado().equals("No vendido")){
                        contadorDeProducto++;
                        productosDisponibles.add(producto);
                    }
                }
                System.out.println();
                System.out.println(contador+". "+nombreProducto+": "+ contadorDeProducto);
                contador++;
            }
            //confirmar que nombre de producto exista
            System.out.println("Escoja nombre de producto:");
            String nombreEscogido= entrada.next();
            while(true){
                if (nombres.contains(nombreEscogido)) {
                    break;
                }
                else {
                    System.out.println("Producto ingresado no disponible, ingrese un nombre valido");
                    nombreEscogido= entrada.next();
                }
            }
            //confirmar cantidad de producto
            System.out.println("Escoja cantidad de producto a pedir:");
            long cantidadEscogida= entrada.nextLong();
            while(true) {
                long cont = 0;
                for (Producto producto : productosDisponibles) {
                    if (producto.getNombre().equals(nombreEscogido)) {
                        cont++;
                    }
                }
                if (cont >= cantidadEscogida) {
                    break;
                }
                else {
                    System.out.println("Cantidad ingresada no disponible, ingrese una cantidad valida");
                    cantidadEscogida=entrada.nextLong();
                }
            }
            //agregar cantidad de productos
            ArrayList<Producto> productosEscogidos=new ArrayList<>();
            long cont=0;
            for(Producto producto: productosDisponibles){
                cont++;
                if(producto.getNombre().equals(nombreEscogido)){
                    productosEscogidos.add(producto);
                }
                if(cont>=cantidadEscogida){
                    break;
                }
            }
            //agregar servicios
            ArrayList<Servicio>serviciosEscogidos=new ArrayList<>();
            System.out.println();
            System.out.println("Desea agregar servicios:");
            System.out.println("1. Agregar servicios");
            System.out.println("2. No agregar servicios");
            int opcion1= entrada.nextInt();
            while(opcion1!=1 || opcion1!=2){
                opcion1= entrada.nextInt();
            }
            if (opcion1==1){
                //mostrar servicios
                System.out.println("Nombre del servicio: precio");
                HashMap<Integer,Servicio> servicios=new HashMap<>();
                int i=1;
                for(Servicio servicio: Servicio.values()){
                    System.out.println(i+". "+servicio+": "+servicio.getPrecio());
                    servicios.put(i,servicio);
                    i++;
                }
                System.out.println("Seleccione cantidad de servicios que desea ingresar");
                int opcion2= entrada.nextInt();//cantidad de servicios
                opcion2= entrada.nextInt();
                for(int e=0; e<opcion2; e++){
                    System.out.println("Ingrese numero de servicio "+e+1+":");
                    int opcion3= entrada.nextInt();
                    while(opcion3<=0 || opcion3> servicios.size()){
                        System.out.println("Numero del servicio no valido, ingrese otro numero");
                        opcion3= entrada.nextInt();
                    }
                    serviciosEscogidos.add(servicios.get(opcion3));
                }
                System.out.println("Ingresar nombre del cliente:");
                String nombreCliente= entrada.next();
                Cliente cliente =new Cliente(nombreCliente,0,null,null);
                Pedido pedido=new Pedido(trabajadorSeleccionado,cliente,"No pagado",productosEscogidos,serviciosEscogidos, LocalDate.now());
                cliente.setPedido(pedido);
                System.out.println(Pedido.generarFactura(pedido,cliente));
            }

        }
        else if (opcion==2){//AGREGAR PEDIDO A CLIENTE EXISTENTE

        }

    }
}

