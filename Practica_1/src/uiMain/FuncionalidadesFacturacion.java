package uiMain;
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
        ArrayList<Producto> productosPedidos = null;
        ArrayList<Servicio> serviciosPedidos = null;
        //MUESTRA EL LISTADO DE TRABAJADORES
        System.out.println("============================================================");
        System.out.println();
        System.out.println("Lista de trabajadores:");
        System.out.println(Trabajador.mostrarTrabajadores());
        System.out.println("============================================================");
        //SELECCIONAR TRABAJADOR QUE TOMARA EL PEDIDO
        System.out.println("Selecciona el codigo del trabajador que tomara el pedido:");
        long codigo = entrada.nextInt();//codigo de empleado
        Trabajador trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigo);
        while (trabajadorSeleccionado == null) {
            System.out.println("Codigo de trabajador no existe, ingrese uno valido");
            codigo = entrada.nextInt();
            trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigo);
        }
        System.out.println("============================================================");
        System.out.println();
        System.out.println("Descripcion del trabajador seleccionado:");
        System.out.println(trabajadorSeleccionado);
        System.out.println();
        System.out.println("============================================================");

        Cliente cliente = null;


        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        System.out.println(!salir);
        System.out.println("==========================OPCIONES DE PEDIDO=========================");
        while (salir == false) {

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

            } else if (opcion == 2) {

            } else if (opcion == 3) {

            } else if (opcion == 4) {

            } else if (opcion == 5) {

            }
        }
    }

    public static String tomarPedido(Trabajador trabajadorSeleccionado, Cliente cliente) {
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
            if (productosPedidos.size() == 0) {
                System.out.println("No hay productos pedidos");
            } else {
                System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
            }
            System.out.println();
            if (serviciosPedidos.size() == 0) {
                System.out.println("No hay servicios pedidos");
            } else {
                System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
            }
            System.out.println("============================================================");
            System.out.println();
            //MOSTRAR PEDIDO QUE LLEVA HASTA EL MOMENTO
            System.out.println("1. Agregar productos");
            System.out.println("2. Remover productos del pedido");
            System.out.println("3. Agregar servicios");
            System.out.println("4. Remover servicios del pedido");
            System.out.println("5. Vaciar pedido(productos y servicios)/sigue en el bucle");
            System.out.println("6. Pagar luego /genera factura/crea objeto/sale del bucle");
            System.out.println("7. Pagar ya /genera factura/crea objeto/sale del bucle");
            System.out.println("8. No tomar pedido/sale del bucle");
            System.out.println("Ingrese una opcion");
            opcion = entrada.nextInt();
            while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6 && opcion != 7) {
                System.out.println("=====================PRODUCTOS Y SERVICIOS PEDIDOS======================");
                if (productosPedidos.size() == 0) {
                    System.out.println("No hay productos pedidos");
                } else {
                    System.out.println(Producto.mostrarNombresCantidadPrecio(productosPedidos));
                }
                System.out.println();
                if (serviciosPedidos.size() == 0) {
                    System.out.println("No hay servicios pedidos");
                } else {
                    System.out.println(Servicio.motrarNombreCantidadPrecio(serviciosPedidos));
                }
                System.out.println("============================================================");
                System.out.println();
                System.out.println("1. Agregar productos");
                System.out.println("2. Remover productos del pedido");
                System.out.println("3. Agregar servicios");
                System.out.println("4. Remover servicios del pedido");
                System.out.println("5. Vaciar pedido(productos y servicios)/sigue en el bucle");
                System.out.println("6. Pagar luego /genera factura/crea objeto/sale del bucle");
                System.out.println("7. Pagar ya /genera factura/crea objeto/sale del bucle");
                System.out.println("8. No tomar pedido/sale del bucle");
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
            } else if (opcion == 6) {
                if (productosPedidos.size() == 0 && serviciosPedidos.size() == 0) {
                    System.out.println("No has hecho ningun pedido de productos o servicios, ingresa un pedido valido");
                } else if (productosPedidos.size() >= 0 || serviciosPedidos.size() >= 0) {
                    cliente = new Cliente();
                    for (Producto producto : productosPedidos) {
                        producto.setEstado("Reservado");
                    }
                    pedido = new Pedido(trabajadorSeleccionado, cliente, "No pagado", productosPedidos, serviciosPedidos, LocalDate.now());
                    factura += pedido.generarFactura();
                    salir = true;
                }

            } else if (opcion == 7) {
                if (productosPedidos.size() == 0 && serviciosPedidos.size() == 0) {
                    System.out.println("No has hecho ningun pedido de productos o servicios, ingresa un pedido valido");
                } else if (productosPedidos.size() != 0 || serviciosPedidos.size() != 0) {
                    cliente = new Cliente();
                    for (Producto producto : productosPedidos) {
                        producto.setEstado("Vendido");
                    }
                    pedido = new Pedido(trabajadorSeleccionado, cliente, "Pagado", productosPedidos, serviciosPedidos, LocalDate.now());
                    factura += pedido.generarFactura();
                    salir = true;
                }
            } else if (opcion == 8) {
                for (Producto producto : productosPedidos) {
                    producto.setEstado("No vendido");
                }
                productosPedidos.clear();
                serviciosPedidos.clear();
                salir = true;
            }


        }
        return factura;
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
                    System.out.println("======================MENU DE OPCIONES======================");
                    System.out.println("Que operacion desea realizar? presione:");
                    System.out.println("1. Remover cierta cantidad de producto");//Estado producto= Reservado, Permite otra iteracion del bucle con lo cual podras agregar mas productos
                    System.out.println("2. Remover todos los productos y salir");
                    System.out.println("3. Volver atras");
                    System.out.println("============================================================");
                    System.out.println("Ingrese una opcion");
                    opcion = entrada.nextInt();
                }
                if(opcion==1){

                }
                else if(opcion==2){

                }
                else if(opcion==3){
                    salir=true;
                }
            }
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
                    System.out.println("Opcion no valida, ingrese un numero correcto");
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
                    nombreEscogido = entrada.next();
                    boolean verificarNombre = Producto.verificarProducto(nombreEscogido, productosPedidos);
                    while (verificarNombre == false) {
                        System.out.println("Producto ingresado no esta en la lista, ingrese un nombre valido");
                        System.out.println();
                        System.out.println("Ingrese nombre del producto que desea remover:");
                        nombreEscogido = entrada.next();
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
        ArrayList<Producto> todosLosProductosDelInventario = Producto.getProductos();//Totdos los productos del inventario
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
            productosNoVendidos = Producto.productosDisponibles(todosLosProductosDelInventario);//Productos con estado "No vendido" y fecha null
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
                System.out.println("No hay productos disponibles para vender, debe agregar productos en el inventario en opciones de administrador");
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
                    nombreEscogido = entrada.next();
                    //VERIFICA QUE EL PRODUCTO ESTE EN LA LISTA DE PRODUCTOS NO VENDIDOS
                    boolean verificarNombre = Producto.verificarProducto(nombreEscogido, productosNoVendidos);
                    while (verificarNombre == false) {
                        System.out.println("Producto ingresado no disponible, ingrese un nombre valido");
                        System.out.println();
                        System.out.println("Escoja nombre de producto:");
                        nombreEscogido = entrada.next();
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
    /*public static void facturarPedido(){

        Scanner entrada=new Scanner(System.in);
        System.out.println("Que operacion desea realizar? ");
        System.out.println("1. Ingresar Pedido a nuevo cliente");
        System.out.println("2. Agregar Pedido a cliente existente");
        System.out.println("3. Ver listas de Pedidos no pagados");
        System.out.println();
        System.out.println("Ingrese una opcion:");
        int opcion = entrada.nextInt();

        while(opcion<1 || opcion>3){
            System.out.println("Opcion invalida, ingrese un numero valido");
            opcion= entrada.nextInt();
        }
        if(opcion==1){ //INGRESAR PEDIDO A CLIENTE NUEVO
            System.out.println("Lista de trabajadores:");
            //MUESTRA EL LISTADO DE TRABAJADORES
            System.out.println(Trabajador.mostrarTrabajadores());
            System.out.println("Selecciona el codigo del trabajador que tomara el pedido:");
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
            System.out.println(productosEscogidos);
            //AGREGAR SERVICIOS
            ArrayList<Servicio>serviciosEscogidos=new ArrayList<>();
            System.out.println();
            System.out.println("Desea agregar servicios:");
            System.out.println("1. Agregar servicios");
            System.out.println("2. No agregar servicios");
            int opcion1= entrada.nextInt();
            while(opcion1<1 || opcion1>2){
                System.out.println("Ingrese una opcion valida");
                opcion1= entrada.nextInt();
            }
            if (opcion1==1){
                //MOSTRAR SERVICIOS
                System.out.println(Servicio.serviciosOfrecidos());//Se muestran los servicios y sus precios
                HashMap<Integer, Servicio>servicios=Servicio.hashmapServicios();
                System.out.println("Seleccione cantidad de servicios que desea ingresar");
                int opcion2= entrada.nextInt();//cantidad de servicios

                for(int e=0; e<opcion2; e++){
                    System.out.println("Ingrese numero del servicio "+(e+1)+":");
                    int opcion3= entrada.nextInt();
                    while(opcion3<=0 || opcion3 > servicios.size()){
                        System.out.println("Numero del servicio no valido, ingrese otro numero");
                        opcion3= entrada.nextInt();
                    }
                    serviciosEscogidos.add(servicios.get(opcion3));
                }
                System.out.println(serviciosEscogidos);
                System.out.println("Ingresar nombre del cliente:");
                String nombreCliente= entrada.next();
                Cliente cliente =new Cliente(nombreCliente,0,null,null);
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
                    System.out.println(pedido.generarFactura());
                }
                else if(opcion4==2){
                    pedido.reservarPedido();//reservar pedido, cambia estado de pedido a No pagado y estado de productos a Reservado
                    System.out.println(pedido.generarFactura());
                }
                else if(opcion4==3){
                    Pedido.getPedidos().remove(pedido);//Remueve el pedido del listado de pedidos
                }

            }
            else if(opcion1==2){
                System.out.println("Ingresar nombre del cliente:");
                String nombreCliente= entrada.next();
                Cliente cliente =new Cliente(nombreCliente,0,null,null);
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
                    System.out.println(pedido.generarFactura());
                }
                else if(opcion4==2){
                    pedido.reservarPedido();//reservar pedido, cambia estado de pedido a No pagado y estado de productos a Reservado
                    System.out.println(pedido.generarFactura());
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
    }*/


}

