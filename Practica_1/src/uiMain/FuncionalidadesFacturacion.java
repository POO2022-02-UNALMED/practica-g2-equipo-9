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
            System.out.println(Producto.mostrarProductosDisponibles());
            ArrayList<Producto> productosDisponibles= Producto.productosDisponibles();//PRODUCTOS NO VENDIDOS
            //CONFIRMAR QUE NOMBRE INGRESADO EXISTA EN EL INVENTARIO
            System.out.println("Escoja nombre de producto:");
            String nombreEscogido= entrada.next();
            boolean verificarNombre=Producto.verificarProducto(nombreEscogido,productosDisponibles);
            while(verificarNombre==false){
                System.out.println("Producto ingresado no disponible, ingrese un nombre valido");
                nombreEscogido= entrada.next();
                verificarNombre=Producto.verificarProducto(nombreEscogido,productosDisponibles);
            }
            //CONFIRMAR CANTIDAD DE PRODUCTO
            System.out.println("Escoja cantidad de producto:");
            long cantidadEscogida= entrada.nextLong();
            boolean verificarCantidad=Producto.verificarProducto(nombreEscogido,cantidadEscogida,productosDisponibles);
            while(verificarCantidad==false){
                System.out.println("Cantidad no disponible, ingrese una cantidad valida");
                cantidadEscogida= entrada.nextLong();
                verificarCantidad=Producto.verificarProducto(nombreEscogido,cantidadEscogida,productosDisponibles);
            }
            //AGREGAR CANTIDAD A PRODUCTOS ESCOGIDOS
            ArrayList<Producto> productosEscogidos=Producto.agregarProducto(nombreEscogido,cantidadEscogida,productosDisponibles);

            //AGREGAR SERVICIOS
            ArrayList<Servicio>serviciosEscogidos=new ArrayList<>();
            System.out.println();
            System.out.println("Desea agregar servicios:");
            System.out.println("1. Agregar servicios");
            System.out.println("2. No agregar servicios");
            int opcion1= entrada.nextInt();
            while(opcion1!=1 || opcion1!=2){
                System.out.println("Ingrese una opcion valida");
                opcion1= entrada.nextInt();
            }
            if (opcion1==1){
                //MOSTRAR SERVICIOS
                System.out.println(Servicio.serviciosOfrecidos());//Se muestran los servicios y sus precios
                HashMap<Integer, Servicio>servicios=Servicio.hashmapServicios();
                System.out.println("Seleccione cantidad de servicios que desea ingresar");
                int opcion2= entrada.nextInt();//cantidad de servicios
                opcion2= entrada.nextInt();
                for(int e=0; e<opcion2; e++){
                    System.out.println("Ingrese numero del servicio "+e+1+":");
                    int opcion3= entrada.nextInt();
                    while(opcion3<=0 || opcion3> servicios.size()){
                        System.out.println("Numero del servicio no valido, ingrese otro numero");
                        opcion3= entrada.nextInt();
                    }
                    serviciosEscogidos.add(servicios.get(opcion3));
                }
                System.out.println("Ingresar nombre del cliente:");
                String nombreCliente= entrada.next();
                Cliente cliente =new Cliente(nombreCliente,0,null,null, null);
                Pedido pedido=new Pedido(trabajadorSeleccionado,cliente,"No pagado",productosEscogidos,serviciosEscogidos, LocalDate.now());
                cliente.setPedido(pedido);
                System.out.println("Ingrese para:");
                System.out.println("1. Pagar ahora mismo");
                System.out.println("2. Pagar luego");
                System.out.println("3. Cancelar pedido");
                int opcion4= entrada.nextInt();
                while(opcion4<=0 && opcion4>3){
                    System.out.println("Opcion invalida, ingrese de nuevo un numero:");
                    opcion4= entrada.nextInt();
                }
                if(opcion4==1){//pagar pedido, cambia estado de pedido a Pagado y estado de productos a Vendido
                    pedido.pagarPedido();
                    pedido.generarFactura();
                }
                else if(opcion4==2){
                    pedido.reservarPedido();//reservar pedido, cambia estado de pedido a No pagado y estado de productos a Reservado
                    pedido.generarFactura();
                }
                else if(opcion4==3){
                    Pedido.getPedidos().remove(pedido);//Remueve el pedido del listado de pedidos
                }

            }

        }
        else if (opcion==2){//AGREGAR PEDIDO A CLIENTE EXISTENTE
            System.out.println("Listado de clientes con pedidos abiertos");
            System.out.println(Cliente.mostrarClientes());
            System.out.println("Ingrese un codigo de cliente:");
            long codigo= entrada.nextLong();
            Cliente clienteSeleccionado=Cliente.seleccionarCliente(codigo);
            while(clienteSeleccionado==null){
                System.out.println("Codigo no valido, ingrese uno nuevo");
                codigo=entrada.nextLong();
                clienteSeleccionado=Cliente.seleccionarCliente(codigo);
            }
            System.out.println("Descripcion del trabajador que atiende este cliente");
            System.out.println(clienteSeleccionado.getPedido().getTrabajador());
            System.out.println();
        }
        else if(opcion==3) {//BUSCAR PEDIDOS "No pagados" QUE VENDRIAN SIENDO LOS PENDIENTES
        }
    }
}

