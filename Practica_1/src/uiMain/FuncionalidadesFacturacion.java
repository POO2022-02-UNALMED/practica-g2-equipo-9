package uiMain;
import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Servicio;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class FuncionalidadesFacturacion {

    public static void opcionesDePedido() {
        Scanner entrada = new Scanner(System.in);

        //MUESTRA EL LISTADO DE TRABAJADORES
        Trabajador trabajadorSeleccionado;
        long codigoTrabajador;
        System.out.println("============================================================");
        System.out.println("Lista de trabajadores:");
        System.out.println(Trabajador.mostrarTrabajadores());
        System.out.println("============================================================");
        //SELECCIONAR TRABAJADOR QUE TOMARA EL PEDIDO
        System.out.println("Selecciona el codigo del trabajador que tomara el pedido:");
        codigoTrabajador = entrada.nextInt();//codigo de empleado
        trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigoTrabajador);
        while (trabajadorSeleccionado == null) {
            System.out.println("Codigo de trabajador no existe, ingrese uno valido");
            codigoTrabajador = entrada.nextInt();
            trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigoTrabajador);
        }
        System.out.println();

        //CLIENTE
        Cliente cliente = null;
        String nombreCliente;
        long codigoCliente;

        //PEDIDO
        Pedido pedido=null;
        long codigoPedido;

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        System.out.println("==========================OPCIONES DE PEDIDO=========================");
        while (salir == false) {
            System.out.println("============================================================");
            System.out.println("Descripcion del trabajador seleccionado:");
            System.out.println(trabajadorSeleccionado);
            System.out.println("============================================================");
            System.out.println();
            System.out.println("======================MENU DE OPCIONES======================");
            System.out.println("Presiona un numero para");
            System.out.println("1.Ingresar pedido a usuario no registrado");//Cliente null, hace recomendaciones generales de los productos mas vendidos
            System.out.println("2.Registra usuario y agrega pedido");//registra un usuario y le toma el pedido
            System.out.println("3.Ingresar pedido a usuario existente");//Recomienda pedido segun lo que ha comprado
            System.out.println("4.Cambiar trabajador");
            System.out.println("5.Ver pedidos existente No pagado");

            System.out.println("6.Volver");
            System.out.println("============================================================");
            System.out.println("Ingresa una opcion:");
            opcion = entrada.nextInt();
            if (opcion == 1) {
                cliente=new Cliente();
                pedido=tomarPedido(trabajadorSeleccionado, cliente);
            } else if (opcion == 2) {
                System.out.println("Ingresar nombre para registrar cliente:");
                nombreCliente= entrada.nextLine();;
                cliente=new Cliente(nombreCliente);
                pedido=tomarPedido(trabajadorSeleccionado,cliente);
                cliente.getHistorialPedidos().add(pedido);
            } else if (opcion == 3) {
                System.out.println(Cliente.mostrarClientesRegistrados());
                System.out.println();
                System.out.println("Ingrese codigo de cliente registrado para seleccionarlo:");
                codigoCliente=entrada.nextLong();
                cliente=Cliente.seleccionarCliente(codigoCliente);
                while(cliente==null){
                    System.out.println("Codigo invalido, ingrese un codigo de cliente existente");
                    System.out.println();
                    System.out.println("Ingrese codigo de cliente registrado para seleccionarlo:");
                    codigoCliente=entrada.nextLong();
                    cliente=Cliente.seleccionarCliente(codigoCliente);
                }
                pedido=tomarPedido(trabajadorSeleccionado,cliente);
            } else if (opcion == 4) {
                //MUESTRA EL LISTADO DE TRABAJADORES
                System.out.println("============================================================");
                System.out.println("Lista de trabajadores:");
                System.out.println(Trabajador.mostrarTrabajadores());
                System.out.println("============================================================");
                //SELECCIONAR TRABAJADOR QUE TOMARA EL PEDIDO
                System.out.println("Selecciona el codigo del trabajador que tomara el pedido:");
                codigoTrabajador = entrada.nextInt();//codigo de empleado
                trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigoTrabajador);
                while (trabajadorSeleccionado == null) {
                    System.out.println("Codigo de trabajador no existe, ingrese uno valido");
                    codigoTrabajador = entrada.nextInt();
                    trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigoTrabajador);
                }
                System.out.println("============================================================");
                System.out.println("Descripcion del trabajador seleccionado:");
                System.out.println(trabajadorSeleccionado);
                System.out.println("============================================================");
            } else if (opcion == 5) {
                //MUESTRA LOS PEDIDOS NO PAGADOS
                System.out.println(Pedido.mostraPedidos());
                System.out.println();
                System.out.println("Seleccione un codigo de pedido");
                codigoPedido=entrada.nextLong();
                pedido=Pedido.seleccionarPedido(codigoPedido);
                while(pedido==null){
                    System.out.println("codigo equivocado, selecciona un codigo correcto");
                    System.out.println();
                    System.out.println("Seleccione un codigo de pedido");
                    codigoPedido=entrada.nextLong();
                    pedido=Pedido.seleccionarPedido(codigoPedido);
                }
                System.out.println();
                System.out.println("Desea pagar este pedido?");
                System.out.println("1. Pagar");
                System.out.println("2. Volver/No hacer nada");
                opcion= entrada.nextInt();
                while(opcion!=1 && opcion!=2){
                    System.out.println("Opcion invalida, seleccione una opcion correcta:");
                    opcion= entrada.nextInt();
                }
                if(opcion==1){
                    pedido.setEstadoPedido("Pagado");
                    for(Producto producto: pedido.getProductos()){
                        producto.setEstado("Vendido");
                    }
                }
            }
            else if(opcion==6){
                salir=true;
            }
            if (pedido!=null){
                System.out.println(pedido.generarFactura());
            }
        }

    }

    public static Pedido tomarPedido(Trabajador trabajadorSeleccionado, Cliente cliente) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Producto> productosPedidos = new ArrayList<>();
        ArrayList<Servicio> serviciosPedidos = new ArrayList<>();
        Pedido pedido = null;
        String factura = null;
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        System.out.println(!salir);
        while (salir == false) {
            System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
            System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
            System.out.println();
            System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
            System.out.println("============================================================");
            System.out.println();
            //MOSTRAR PEDIDO QUE LLEVA HASTA EL MOMENTO
            System.out.println("1. Agregar productos");
            System.out.println("2. Remover productos del pedido");
            System.out.println("3. Agregar servicios");
            System.out.println("4. Remover servicios del pedido");
            System.out.println("5. Vaciar pedido(productos y servicios)/sigue en el bucle");
            System.out.println("6. No tomar pedido/sale del bucle");
            System.out.println("Opciones para pagar luego o pagar ya:");
            System.out.println("7. Pagar luego /genera factura/crea objeto/sale del bucle");
            System.out.println("8. Pagar ya /genera factura/crea objeto/sale del bucle");

            System.out.println("Ingrese una opcion");
            opcion = entrada.nextInt();
            while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6 && opcion != 7 && opcion!=8) {
                System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println();
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("1. Agregar productos");
                System.out.println("2. Remover productos del pedido");
                System.out.println("3. Agregar servicios");
                System.out.println("4. Remover servicios del pedido");
                System.out.println("5. Vaciar pedido(productos y servicios)/sigue en el bucle");
                System.out.println("6. No tomar pedido/sale del bucle");
                System.out.println("Opciones para pagar luego o pagar ya:");
                System.out.println("7. Pagar luego /genera factura/crea objeto/sale del bucle");
                System.out.println("8. Pagar ya /genera factura/crea objeto/sale del bucle");
                System.out.println("============================================================");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
            }
            System.out.println();
            if (opcion == 1) {
                agregarProductos(productosPedidos, serviciosPedidos);
            } else if (opcion == 2) {
                if (productosPedidos.size() == 0) {
                    System.out.println("No hay productos para remover, ingrese otra opcion");
                } else if (productosPedidos.size() >= 0) {
                    removerProductos(productosPedidos, serviciosPedidos);
                }
            } else if (opcion == 3) {
                agregarServicios(productosPedidos,serviciosPedidos);
            } else if (opcion == 4) {
                if (serviciosPedidos.size()==0){
                    System.out.println("No hay productos para remover, ingrese otra opcion");
                }else if(serviciosPedidos.size()>=0){
                    removerServicios(productosPedidos,serviciosPedidos);
                }
            } else if (opcion == 5) {
                for (Producto producto : productosPedidos) {
                    producto.setEstado("No vendido");
                }
                productosPedidos.clear();
                serviciosPedidos.clear();
            }else if (opcion == 6) {
                for (Producto producto : productosPedidos) {
                    producto.setEstado("No vendido");
                }
                productosPedidos.clear();
                serviciosPedidos.clear();
                salir = true;
            }
            else if (opcion == 7) {
                if (productosPedidos.size() == 0 && serviciosPedidos.size() == 0) {
                    System.out.println("No has hecho ningun pedido de productos o servicios, ingresa un pedido valido");
                } else if (productosPedidos.size() >= 0 || serviciosPedidos.size() >= 0) {
                    for (Producto producto : productosPedidos) {
                        producto.setTrabajador(trabajadorSeleccionado);
                        producto.setEstado("Reservado");
                        producto.setCliente(cliente);
                    }
                    pedido = new Pedido(trabajadorSeleccionado, cliente, "No pagado", productosPedidos, serviciosPedidos, LocalDate.now());
                    salir = true;
                }

            } else if (opcion == 8) {
                if (productosPedidos.size() == 0 && serviciosPedidos.size() == 0) {
                    System.out.println("No has hecho ningun pedido de productos o servicios, ingresa un pedido valido");
                } else if (productosPedidos.size() != 0 || serviciosPedidos.size() != 0) {
                    for (Producto producto : productosPedidos) {
                        producto.setTrabajador(trabajadorSeleccionado);
                        producto.setEstado("Vendido");
                        producto.setCliente(cliente);
                    }
                    pedido = new Pedido(trabajadorSeleccionado, cliente, "Pagado", productosPedidos, serviciosPedidos, LocalDate.now());
                    cliente.getHistorialPedidos().add(pedido);
                    salir = true;
                }
            }


        }
        return pedido;
    }
    public static ArrayList<Servicio> removerServicios(ArrayList<Producto> productosPedidos, ArrayList<Servicio> serviciosPedidos){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int  numeroServicio;
        long cantidadEscogida;
        boolean salir = false;
        System.out.println();
        System.out.println();
        System.out.println("===========================MENU PARA REMOVER SERVICIOS=================================");
        while (salir == false) {
            if(serviciosPedidos.size()==0){
                System.out.println();
                System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println();
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("Que operacion desea realizar? presione:");
                System.out.println("1. Volver atras");
                System.out.println("============================================================");
                System.out.println("No hay servicios para remover");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                while (opcion != 1) {
                    System.out.println();
                    System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println();
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("Que operacion desea realizar? presione:");
                    System.out.println("1. Volver atras");
                    System.out.println("============================================================");
                    System.out.println("No hay servicios para remover");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if (opcion == 1) {
                    salir = true;
                }

            }
            else if(serviciosPedidos.size()>=0){
                System.out.println();
                System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println();
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("==========================SERVICIOS QUE SE OFRECEN=======================================");
                System.out.println(Servicio.serviciosOfrecidos());//Se muestran los servicios y sus precios
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("Que operacion desea realizar? presione:");
                System.out.println("1. Remover cierta cantidad de servicios");//Estado producto= Reservado, Permite otra iteracion del bucle con lo cual podras agregar mas productos
                System.out.println("2. Remover todos los servicios y salir");
                System.out.println("3. Volver atras");
                System.out.println("============================================================");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                while (opcion != 1 && opcion != 2) {
                    System.out.println();
                    System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println();
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("==========================SERVICIOS QUE SE OFRECEN=======================================");
                    System.out.println(Servicio.serviciosOfrecidos());//Se muestran los servicios y sus precios
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("Que operacion desea realizar? presione:");
                    System.out.println("1. Remover cierta cantidad de servicios");//Estado producto= Reservado, Permite otra iteracion del bucle con lo cual podras agregar mas productos
                    System.out.println("2. Remover todos los servicios y salir");
                    System.out.println("3. Volver atras");
                    System.out.println("============================================================");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if(opcion==1){
                    HashMap<Integer, Servicio>servicios=Servicio.hashmapServicios();
                    System.out.println("Escoger numero de servicio que desea remover:");
                    numeroServicio=entrada.nextInt();
                    boolean verificarNumeroServicio=Servicio.verificarServicio(servicios.get(numeroServicio),serviciosPedidos);
                    while(verificarNumeroServicio==false){
                        System.out.println("Opcion no valida, ingrese un numero de servicio que este en su pedido");
                        System.out.println();
                        System.out.println("Escoger numero de servicio que desea remover:");
                        numeroServicio=entrada.nextInt();
                        verificarNumeroServicio=Servicio.verificarServicio(servicios.get(numeroServicio),serviciosPedidos);
                    }
                    System.out.println("Ingrese el numero de "+servicios.get(numeroServicio)+" que desea remover de su pedido:");
                    cantidadEscogida=entrada.nextLong();
                    boolean verificarCantidad=Servicio.verificarServicio(servicios.get(numeroServicio),cantidadEscogida,serviciosPedidos);
                    while(verificarCantidad==false){
                        System.out.println("Cantidad escogida no existe");
                        System.out.println();
                        System.out.println("Ingrese el numero de "+servicios.get(numeroServicio)+" que desea remover de su pedido:");
                        cantidadEscogida=entrada.nextLong();
                        verificarCantidad=Servicio.verificarServicio(servicios.get(numeroServicio),cantidadEscogida,serviciosPedidos);
                    }
                    //REMOVER SERVICIOS
                    Iterator<Servicio> listaIterada = serviciosPedidos.iterator();
                    int i = 0;
                    while (listaIterada.hasNext()) {
                        Servicio actual = listaIterada.next();
                        if (actual==servicios.get(numeroServicio) && i < cantidadEscogida) {
                            listaIterada.remove();
                            i++;
                        }
                    }
                }
                else if(opcion==2){
                    serviciosPedidos.clear();
                    salir=true;
                }
                else if(opcion==3){
                    salir=true;
                }
            }
        }
        return serviciosPedidos;
    }
    public static ArrayList<Servicio> agregarServicios(ArrayList<Producto> productosPedidos, ArrayList<Servicio> serviciosPedidos){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int  numeroServicio;
        long cantidadEscogida;
        boolean salir = false;
        System.out.println();
        System.out.println();
        System.out.println("===========================MENU PARA AGREGAR SERVICIOS=================================");
        while (salir == false) {
            System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
            System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
            System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
            System.out.println("============================================================");
            System.out.println();
            System.out.println("==========================SERVICIOS QUE SE OFRECEN=======================================");
            System.out.println(Servicio.serviciosOfrecidos());//Se muestran los servicios y sus precios
            System.out.println("============================================================");
            System.out.println();
            System.out.println("======================MENU DE OPCIONES======================");
            System.out.println("No hay productos disponibles para vender, debe agregar productos en el inventario en opciones de administrador");
            System.out.println("1. Agregar servicio y cantidad");
            System.out.println("2. No agregar mas servicios/volver atras");
            System.out.println("============================================================");
            System.out.println("Ingrese una opcion");
            opcion = entrada.nextInt();
            while (opcion != 1 && opcion != 2) {
                System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("==========================SERVICIOS QUE SE OFRECEN=======================================");
                System.out.println(Servicio.serviciosOfrecidos());//Se muestran los servicios y sus precios
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("1. Agregar servicio y cantidad");
                System.out.println("2. No agregar mas servicios/volver atras");
                System.out.println("============================================================");
                System.out.println("Ingrese una opcion");
                numeroServicio = entrada.nextInt();
            }
            if(opcion==1){
                HashMap<Integer, Servicio>servicios=Servicio.hashmapServicios();
                System.out.println("Seleccione numero del servicio que desea ingresar");
                numeroServicio= entrada.nextInt();
                while(numeroServicio<1 || numeroServicio>servicios.size()){
                    System.out.println();
                    System.out.println("Opcion no valida, ingrese un numero de servicio correcto");
                    System.out.println();
                    System.out.println("Seleccione NUMERO del servicio que desea ingresar");
                    numeroServicio= entrada.nextInt();
                }
                System.out.println("Seleccione la cantidad de "+servicios.get(numeroServicio)+" que desea:");
                cantidadEscogida= entrada.nextLong();
                serviciosPedidos.addAll(Servicio.agregarServicios(numeroServicio,cantidadEscogida,servicios));
            }
            else if(opcion==2){
                salir=true;
            }
        }
        return serviciosPedidos;
    }
    public static ArrayList<Producto> removerProductos(ArrayList<Producto> productosPedidos, ArrayList<Servicio> serviciosPedidos) {
        ArrayList<Producto> todosLosProductosDelInventario = Producto.getProductos();//Totdos los productos del inventario
        ArrayList<Producto> productosNoVendidos;
        Scanner entrada = new Scanner(System.in);
        int opcion;
        String nombreEscogido;
        long cantidadEscogida;
        boolean salir = false;
        System.out.println();
        System.out.println();
        System.out.println("===========================MENU PARA REMOVER PRODUCTOS A SU PEDIDO===========================");
        while (salir == false) {
            if (productosPedidos.size() == 0) {
                System.out.println();
                System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println();
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("Que operacion desea realizar? presione:");
                System.out.println("1. Volver atras");
                System.out.println("============================================================");
                System.out.println("No hay productos para remover");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                while (opcion != 1) {
                    System.out.println();
                    System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println();
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("Que operacion desea realizar? presione:");
                    System.out.println("1. Volver atras");
                    System.out.println("============================================================");
                    System.out.println("No hay productos para remover");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if (opcion == 1) {
                    salir = true;
                }
            } else if (productosPedidos.size() > 0) {
                System.out.println();
                System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println();
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("Que operacion desea realizar? presione:");
                System.out.println("1. Remover cierta cantidad de producto");//Estado producto= Reservado, Permite otra iteracion del bucle con lo cual podras agregar mas productos
                System.out.println("2. Remover todos los productos y salir");
                System.out.println("3. Volver atras");
                System.out.println("============================================================");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                while (opcion != 1 && opcion != 2) {
                    System.out.println();
                    System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println();
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("Que operacion desea realizar? presione:");
                    System.out.println("1. Remover cierta cantidad de producto");//Estado producto= Reservado, Permite otra iteracion del bucle con lo cual podras agregar mas productos
                    System.out.println("2. Remover todos los productos y salir");
                    System.out.println("3. Volver atras");
                    System.out.println("============================================================");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if (opcion == 1) {
                    System.out.println();
                    System.out.println("=================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println();
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("Ingrese nombre del producto que desea remover:");
                    nombreEscogido = entrada.nextLine();;
                    boolean verificarNombre = Producto.verificarProducto(nombreEscogido, productosPedidos);
                    while (verificarNombre == false) {
                        System.out.println("Producto ingresado no esta en la lista, ingrese un nombre valido");
                        System.out.println();
                        System.out.println("Ingrese nombre del producto que desea remover:");
                        nombreEscogido = entrada.nextLine();;
                        verificarNombre = Producto.verificarProducto(nombreEscogido, productosPedidos);
                    }
                    System.out.println("Escoja cantidad de producto que desea remover:");
                    cantidadEscogida = entrada.nextLong();
                    boolean verificarCantidad = Producto.verificarProducto(nombreEscogido, cantidadEscogida, productosPedidos);
                    while (verificarCantidad == false) {
                        System.out.println("Cantidad ingresada no disponible, ingrese una cantidad valida");
                        System.out.println();
                        System.out.println("Escoja cantidad de producto que desea remover:");
                        cantidadEscogida = entrada.nextLong();
                        verificarCantidad = Producto.verificarProducto(nombreEscogido, cantidadEscogida, productosPedidos);
                    }
                    //CAMBIAR ESTADO A PRODUCTOS Y REMOVERLOS
                    Iterator<Producto> listaIterada = productosPedidos.iterator();
                    int i = 0;
                    while (listaIterada.hasNext()) {
                        Producto actual = listaIterada.next();
                        if (actual.getNombre().equals(nombreEscogido) && i < cantidadEscogida) {
                            actual.setEstado("No vendido");
                            listaIterada.remove();
                            i++;
                        }
                    }
                }
                if (opcion == 2) {
                    for (Producto producto : productosPedidos) {
                        producto.setEstado("No vendido");
                    }
                    productosPedidos.clear();
                    salir = true;
                }
                if (opcion == 3) {
                    salir = true;
                }

            }
        }


        return productosPedidos;
    }

    public static ArrayList<Producto> agregarProductos(ArrayList<Producto> productosPedidos, ArrayList<Servicio> serviciosPedidos) {
        ArrayList<Producto> productosNoVendidos;
        Scanner entrada = new Scanner(System.in);
        int opcion;
        String nombreEscogido;
        long cantidadEscogida;
        boolean salir = false;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("===========================MENU PARA AGREGAR PRODUCTOS A SU PEDIDO===========================");

        while (salir == false) {
            productosNoVendidos = Producto.productosDisponibles(Producto.getProductos());//Productos con estado "No vendido" y fecha null
            if (productosNoVendidos.size() == 0) {
                System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("============INVENTARIO DE PRODUCTOS DISPONIBLES=============");
                System.out.println(Producto.mostrarProductosDisponibles(productosNoVendidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("No hay productos disponibles para vender, debe agregar productos en el inventario en opciones de administrador");
                System.out.println("1. Volver atras");
                System.out.println("============================================================");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                while (opcion != 1) {
                    System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("============INVENTARIO DE PRODUCTOS DISPONIBLES=============");
                    System.out.println(Producto.mostrarProductosDisponibles(productosNoVendidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("No hay productos disponibles para vender, debe agregar productos en el inventario en opciones de administrador");
                    System.out.println("1. Volver atras");
                    System.out.println("============================================================");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if (opcion == 1) {
                    salir = true;
                }
            } else if (productosNoVendidos.size() > 0) {
                System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("============INVENTARIO DE PRODUCTOS DISPONIBLES=============");
                System.out.println(Producto.mostrarProductosDisponibles(productosNoVendidos));
                System.out.println("============================================================");
                System.out.println();
                System.out.println("======================MENU DE OPCIONES======================");
                System.out.println("No hay productos disponibles para vender");
                System.out.println("1. Agregar producto y cantidad");
                System.out.println("2. No agregar mas productos/volver atras");
                System.out.println("============================================================");
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                while (opcion != 1 && opcion != 2) {
                    System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS HASTA EL MOMENTO======================");
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("============INVENTARIO DE PRODUCTOS DISPONIBLES=============");
                    System.out.println(Producto.mostrarProductosDisponibles(productosNoVendidos));
                    System.out.println("============================================================");
                    System.out.println();
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("No hay productos disponibles para vender, debe agregar productos en el inventario en opciones de administrador");
                    System.out.println("1. Agregar producto y cantidad");
                    System.out.println("2. No agregar mas productos/volver atras");
                    System.out.println("============================================================");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if (opcion == 1) {
                    //SELECCIONAR NOMBRE DE PRODUCTO
                    System.out.println("Escoja nombre de producto:");
                    nombreEscogido = entrada.nextLine();;
                    //VERIFICA QUE EL PRODUCTO ESTE EN LA LISTA DE PRODUCTOS NO VENDIDOS
                    boolean verificarNombre = Producto.verificarProducto(nombreEscogido, productosNoVendidos);
                    while (verificarNombre == false) {
                        System.out.println("Producto ingresado no disponible, ingrese un nombre valido");
                        System.out.println();
                        System.out.println("Escoja nombre de producto:");
                        nombreEscogido = entrada.nextLine();;
                        verificarNombre = Producto.verificarProducto(nombreEscogido, productosNoVendidos);
                    }
                    //CONFIRMA QUE LA CANTIDAD DE PRODUCTO INGRESADA ESTE EN LA LISTA DE PRODUCTOS NO VENDIDOS
                    System.out.println("Escoja cantidad de producto:");
                    cantidadEscogida = entrada.nextLong();
                    boolean verificarCantidad = Producto.verificarProducto(nombreEscogido, cantidadEscogida, productosNoVendidos);
                    while (verificarCantidad == false) {
                        System.out.println("Cantidad ingresada no disponible, ingrese una cantidad valida");
                        System.out.println();
                        System.out.println("Escoja cantidad de producto:");
                        cantidadEscogida = entrada.nextLong();
                        verificarCantidad = Producto.verificarProducto(nombreEscogido, cantidadEscogida, productosNoVendidos);
                    }
                    //AGREGA PRODUCTOS AL ARRAYLIST DE PRODUCTOS PEDIDOS
                    productosPedidos.addAll(Producto.agregarProducto(nombreEscogido, cantidadEscogida, productosNoVendidos));
                    System.out.println();
                    System.out.println();
                    //RESERVA TODOS LOS PRODUCTOS ESCOGIDOS EN ESTA ITERACION
                    for (Producto producto : productosPedidos) {
                        producto.setEstado("Reservado");
                    }
                }
                else if (opcion == 2) {
                    for (Producto producto : productosPedidos) {
                        producto.setEstado("Reservado");
                    }
                    salir = true;
                }
            }
        }
        return productosPedidos;
    }

    public static void main(String[] args) {
        Producto producto2=new Producto("Pepsi","Reservado",500,0);
        Producto producto5=new Producto("Pepsi","Reservado",500,0);
        Producto producto6=new Producto("Pepsi","No vendido",500,0);
        Producto producto3=new Producto("Coca cola","No vendido",500,0);
        Producto producto4=new Producto("Coca cola","No vendido",500,0);
        Trabajador trabajador=new Trabajador("Russbell",LocalDate.of(2022,02,02));
        Trabajador trabajador1=new Trabajador("Sergio",LocalDate.of(2022,02,02));
        Trabajador trabajador2=new Trabajador("Mafre",LocalDate.of(2022,02,02));
        Cliente cliente1=new Cliente("Miguel");

        Producto producto=new Producto(trabajador,null,"coca",0,null);
        System.out.println(Trabajador.getTrabajadores().size());
        Trabajador.getTrabajadores().remove(trabajador);
        System.out.println(Trabajador.getTrabajadores().size());

        System.out.println(producto.getTrabajador().getNombre());


    }
}

