package uiMain;

import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Servicio;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

import static uiMain.FuncionalidadesNomina.nominaEmpleado;

public class FuncionalidadesAdministrador {
    public static void opcionesAdministrador() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=====================BIENVENIDO AL MENU DE OPCIONES DE ADMINISTRADOR====================");
        int opcion;
        boolean salir = false;
        while (salir == false) {
            System.out.println("1. Opciones de empleado");
            System.out.println("2. Opciones de producto");
            System.out.println("3. Volver");
            opcion = entrada.nextInt();
            while (opcion != 1 && opcion != 2 && opcion != 3) {
                System.out.println();
                System.out.println("Opcion invalida, vuelve a ingresar una opcion");
                System.out.println();
                System.out.println("1. Opciones de empleado");
                System.out.println("2. Mostrar Inventario de productos");
                System.out.println("3. Volver");
                System.out.println();
                System.out.println("Ingrese una opcion:");
                opcion = entrada.nextInt();
            }
            if (opcion == 1) {
                opcionesEmpleado();
            } else if (opcion == 2) {
                System.out.println("===============================INVENTARIO DE PRODUCTOS DISPONIBLES==========================================");
                System.out.println();
                ArrayList<Producto> productosNoVendidos = Producto.productosDisponibles(Producto.getProductos());//Productos con estado "No vendido" y fecha null
                System.out.println(Producto.mostrarProductosDisponibles(productosNoVendidos));
                System.out.println();
                System.out.println("=============================================================================================================");
            } else if (opcion == 3) {
                salir = true;
            }
        }
    }



    public static void opcionesEmpleado() {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        while (salir == false) {
            System.out.println("=====================OPCIONES DE EMPLEADO===================");

            System.out.println("1. Ver seguro de un trabajador");
            System.out.println("2. Empleado del mes");
            System.out.println("3. Volver");
            System.out.println("Ingrese una opcion:");
            opcion = entrada.nextInt();
            while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
                System.out.println("=====================OPCIONES DE EMPLEADO===================");
                System.out.println("1. Ver seguro de un trabajador");
                System.out.println("2. Empleado del mes");
                System.out.println("3. Volver");
                System.out.println("Ingrese una opcion:");
                opcion = entrada.nextInt();
            }

            if (opcion == 1) {
                System.out.println(Trabajador.mostrarTrabajadores());
                System.out.println();
                System.out.println("Ingresa codigo de un trabajador");
                opcion= entrada.nextInt();
                Trabajador trabajador=Trabajador.seleccionarTrabajador(opcion);
                while(trabajador==null){
                    System.out.println();
                    System.out.println("Codigo de trabajador no existe, ingresa un codigo correcto");
                    opcion= entrada.nextInt();
                    trabajador=Trabajador.seleccionarTrabajador(opcion);
                }
                Empleado empleado=trabajador;
                System.out.println("Trabajador seleccionado:");
                System.out.println();
                System.out.println(trabajador);
                System.out.println();
                System.out.println("Seguro del trabajador:");
                System.out.println(empleado.asegurar());// Ligadura dinamica

            } else if (opcion == 2) {
                empleadoDelMes();
            } else if (opcion == 3) {
                salir = true;
            }


        }

    }
    public static void empleadoDelMes() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=====================BIENVENIDO AL MENU DE NOMINA====================");
        int opcion;
        boolean salir = false;
        while (salir == false) {
            SortedSet<Integer> fechas = new TreeSet<>();
            //guardamos las fechas de productos de los que se tengan conocimiento de venta

            for (Producto producto : Producto.getProductos()) {
                fechas.add(producto.getFechaVenta().getMonthValue());
            }
            //guardamos las fechas de servicios de los que se tengan conocimiento de venta
            for (Pedido e : Pedido.getPedidos()) {
                fechas.add(e.getFechaPedido().getMonthValue());
            }
            HashMap<Integer, String> meses = new HashMap<Integer, String>();
            meses.put(1, "Enero");
            meses.put(2, "Febrero");
            meses.put(3, "Marzo");
            meses.put(4, "Abril");
            meses.put(5, "Mayo");
            meses.put(6, "Junio");
            meses.put(7, "Julio");
            meses.put(8, "Agosto");
            meses.put(9, "Septiembre");
            meses.put(10, "Octubre");
            meses.put(11, "Noviembre");
            meses.put(12, "Diciembre");

            HashMap<Integer, Integer> opcionMeses = new HashMap<>();

            System.out.println("Fechas Disponibles:");
            int i = 1;
            for (Integer numeroMes : fechas) {
                //aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
                System.out.println("[" + i + "]" + " " + meses.get(numeroMes) + " de " + 2022);
                opcionMeses.put(i, numeroMes);
                i++;
            }
            System.out.println("[0] Volver atras");
            //Obtengo la fecha escogida
            System.out.println("Por favor ingresa una opcion:");
            opcion = entrada.nextInt();
            while (opcion < 0 || opcion > opcionMeses.size()) {
                System.out.println("Opcion no valida, ingresa de nuevo un numero");
                opcion = entrada.nextInt();
            }
            if (opcion >= 1 && opcion <= opcionMeses.size()) {
                int mesSeleccionado = opcionMeses.get(opcion);
                System.out.println("Mes escogido: " + meses.get(mesSeleccionado));

                //Busco trabajador del mes
                TreeMap<Double, Trabajador> cuenta = new TreeMap<>();
                for (Trabajador trabajador : Trabajador.getTrabajadores()) {
                    double totalVentas= 0;
                    for (Producto producto : Producto.getProductos()) {
                        if (producto.getTrabajador() == trabajador && producto.getEstado().equals("Vendido") && producto.getFechaVenta().getMonthValue()==mesSeleccionado) {
                            totalVentas+=producto.getPrecioVenta();
                        }
                    }
                    for(Pedido pedido: Pedido.getPedidos()){
                        if(pedido.getFechaPedido().getMonthValue()==mesSeleccionado && pedido.getTrabajador()==trabajador && pedido.getEstadoPedido().equals("Pagado")){
                            for(Servicio servicio: pedido.getServicios()){
                                totalVentas+=servicio.getPrecio();
                            }
                        }
                    }
                    if (cuenta.containsValue(trabajador) == false) {
                        cuenta.put(totalVentas, trabajador);
                    }
                }
                System.out.println("El trabajador que mas ha vendido es: ");
                System.out.println();
                Trabajador mejor = (Trabajador) cuenta.values().toArray()[cuenta.size() - 1];
                System.out.println(mejor);
                System.out.println("Con seguro:");
                System.out.println(mejor.asegurar());
                System.out.println();
                System.out.printf("===============NOMINA DE EMPLEADO DEL MES===================");
                System.out.println();
                System.out.println(nominaEmpleado(mesSeleccionado,mejor));
                System.out.println();
                System.out.println("===========================================================");
                System.out.println();
                System.out.println("Desea aumentar su sueldo?");
                System.out.println();
                System.out.println("1. Aumentar sueldo");
                System.out.println("2. No aumentar sueldo/volver");
                opcion=entrada.nextInt();
                if(opcion==1){
                    mejor.aumentarSueldo(0.1);
                }
                System.out.println("El nuevo sueldo actual del trabajador es:");
                System.out.println(mejor.getSueldo());

            }
            else if(opcion==0){
                salir=true;
            }
        }
    }
    public static void calculoDeNomina() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=====================BIENVENIDO AL MENU DE NOMINA====================");
        int opcion;
        boolean salir = false;
        while (salir == false) {
            SortedSet<Integer> fechas = new TreeSet<>();
            //guardamos las fechas de productos de los que se tengan conocimiento de venta

            for (Producto producto : Producto.getProductos()) {
                fechas.add(producto.getFechaVenta().getMonthValue());
            }
            //guardamos las fechas de servicios de los que se tengan conocimiento de venta
            for (Pedido e : Pedido.getPedidos()) {
                fechas.add(e.getFechaPedido().getMonthValue());
            }
            HashMap<Integer, String> meses = new HashMap<Integer, String>();
            meses.put(1, "Enero");
            meses.put(2, "Febrero");
            meses.put(3, "Marzo");
            meses.put(4, "Abril");
            meses.put(5, "Mayo");
            meses.put(6, "Junio");
            meses.put(7, "Julio");
            meses.put(8, "Agosto");
            meses.put(9, "Septiembre");
            meses.put(10, "Octubre");
            meses.put(11, "Noviembre");
            meses.put(12, "Diciembre");

            HashMap<Integer, Integer> opcionMeses = new HashMap<>();

            System.out.println("Fechas Disponibles:");
            int i = 1;
            for (Integer numeroMes : fechas) {
                //aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
                System.out.println("[" + i + "]" + " " + meses.get(numeroMes) + " de " + 2022);
                opcionMeses.put(i, numeroMes);
                i++;
            }
            System.out.println("[0] Volver atras");
            //Obtengo la fecha escogida
            System.out.println("Por favor ingresa una opcion:");
            opcion = entrada.nextInt();
            while (opcion < 0 || opcion > opcionMeses.size()) {
                System.out.println("Opcion no valida, ingresa de nuevo un numero");
                opcion = entrada.nextInt();
            }
            if (opcion >= 1 && opcion <= opcionMeses.size()) {
                int mesSeleccionado = opcionMeses.get(opcion);
                System.out.println("Mes escogido: " + meses.get(mesSeleccionado));

                //Seleccionar trabajador
                System.out.println("Selecciona trabajador a liquidar:");

                System.out.println(Trabajador.mostrarTrabajadores());
                System.out.println("Ingresa codigo del trabajador: ");

                long codigo = entrada.nextInt();//codigo de empleado
                //buscamos el codigo del trabajador
                Trabajador trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigo);
                while (trabajadorSeleccionado == null) {
                    System.out.println("Codigo de trabajador no existe, ingrese uno valido");
                    codigo = entrada.nextInt();
                    trabajadorSeleccionado = Trabajador.seleccionarTrabajador(codigo);
                }

                System.out.println(FuncionalidadesNomina.nominaEmpleado(mesSeleccionado, trabajadorSeleccionado));
                System.out.println();
                System.out.println("Presiona 0 para volver atras y ver la contabilidad de otros meses");
                opcion = entrada.nextInt();
                while (opcion != 0) {
                    System.out.println("Opcion incorrecta, presione 0 para volver");
                    opcion = entrada.nextInt();
                }
            }
            if (opcion == 0) {
                salir = true;
            }
        }


    }
}
