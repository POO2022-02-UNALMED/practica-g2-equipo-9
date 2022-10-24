package uiMain;

import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Servicio;
import gestorAplicacion.usuarios.Sueldo;
import gestorAplicacion.usuarios.Trabajador;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class FuncionalidadesNomina {
    //FUNCIONALIDAD NOMINA
    public static void calculoDeNomina(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("=====================BIENVENIDO AL MENU DE NOMINA====================");
        int opcion;
        boolean salir=false;
        while(salir==false){
            SortedSet<Integer>fechas=new TreeSet<>();
            //guardamos las fechas de productos de los que se tengan conocimiento de venta

            for(Producto producto: Producto.getProductos()){
                fechas.add(producto.getFechaVenta().getMonthValue());
            }
            //guardamos las fechas de servicios de los que se tengan conocimiento de venta
            for(Pedido e: Pedido.getPedidos()){
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

            HashMap<Integer,Integer> opcionMeses=new HashMap<>();

            System.out.println("Fechas Disponibles:");
            int i= 1;
            for (Integer numeroMes: fechas){
                //aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
                System.out.println("["+i+"]"+" "+meses.get(numeroMes)+" de "+2022);
                opcionMeses.put(i,numeroMes);
                i++;
            }
            System.out.println("[0] Volver atras");
            //Obtengo la fecha escogida
            System.out.println("Por favor ingresa una opcion:");
            opcion=entrada.nextInt();
            while(opcion<0 || opcion>opcionMeses.size()){
                System.out.println("Opcion no valida, ingresa de nuevo un numero");
                opcion= entrada.nextInt();
            }
            if(opcion==1){
                int mesSeleccionado=opcionMeses.get(opcion);
                System.out.println("Mes escogido: "+meses.get(mesSeleccionado));

                //Seleccionar trabajador
                System.out.println("Selecciona trabajador a liquidar:");

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

                System.out.println(FuncionalidadesNomina.nominaEmpleado(mesSeleccionado,trabajadorSeleccionado));
                System.out.println();
                System.out.println("Presiona 0 para volver atras y ver la contabilidad de otros meses");
                opcion= entrada.nextInt();
                while(opcion!=0){
                    System.out.println("Opcion incorrecta, presione 0 para volver");
                    opcion= entrada.nextInt();
                }
            }
            if(opcion==0){
                salir=true;
            }
        }



    }
    public static String nominaEmpleado(long mesSeleccionado, Trabajador trabajadorSeleccionado){
        //PRODUCTOS QUE VENDIO EL EMPLEADO
        double comisionProductosTrabajador=0;
        SortedSet<String> nombresProductosNoRepetidos= new TreeSet<>();
        ArrayList<String> nombresProductosRepetidos= new ArrayList<>();
        for (Producto producto: Producto.getProductos()){
            if (producto.getFechaVenta().getMonthValue()==mesSeleccionado && producto.getTrabajador()==trabajadorSeleccionado && producto.getEstado().equals("Vendido")){
                comisionProductosTrabajador+=producto.getPrecioVenta()*Sueldo.porcentajeComisionProductos;
                nombresProductosRepetidos.add(producto.getNombre());
                nombresProductosNoRepetidos.add(producto.getNombre());
            }
        }

        String nombreYcantidadProductos="Nombre del producto..............Cantidad";
        for(String nombre: nombresProductosNoRepetidos){
            nombreYcantidadProductos+="\n"+nombre+"....................."+Collections.frequency(nombresProductosRepetidos,nombre);
        }

        //SERVICIOS QUE VENDIO EL EMPLEADO
        double comisionServiciosTrabajador=0;
        SortedSet<Servicio> nombresServiciosNoRepetidos= new TreeSet<>();
        ArrayList<Servicio> nombresServiciosRepetidos= new ArrayList<>();
        for(Pedido e: Pedido.getPedidos()){
            if(e.getFechaPedido().getMonthValue()==mesSeleccionado && e.getTrabajador()==trabajadorSeleccionado && e.getEstadoPedido().equals("Pagado")){
                for(Servicio servicio: e.getServicios()){
                    comisionServiciosTrabajador+=servicio.getPrecio()*Sueldo.porcentajeComisionServicios;
                    nombresServiciosRepetidos.add(servicio);
                    nombresServiciosNoRepetidos.add(servicio);
                }
            }
        }
        String nombreYcantidadServicios="Nombre del servicio..............Cantidad";
        for(Servicio nombre: nombresServiciosNoRepetidos){
            nombreYcantidadServicios+="\n"+nombre+"....................."+Collections.frequency(nombresServiciosRepetidos,nombre);
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

        double total=trabajadorSeleccionado.getSueldo()+comisionProductosTrabajador+comisionServiciosTrabajador;
        String s="";
        s+="\n "+
                "\n "+
                "\n ================================================================== "+
                "\n                     Pago al trabajador con " + trabajadorSeleccionado+
                "\n ================================================================== "+
                "\n  "+
                "\n lista de productos y cantidades vendidas por el empleado :\n"+ nombreYcantidadProductos+
                "\n La comision por producto vendido es del "+Sueldo.porcentajeComisionProductos*100+"%"+
                "\n Por lo que obtiene en comisiones de productos un total de: "+comisionProductosTrabajador+
                "\n lista de servicios y cantidades vendidas por el empleado :\n"+ nombreYcantidadServicios+
                "\n La comision por producto vendido es del "+Sueldo.porcentajeComisionServicios*100+"%"+
                "\n Por lo que obtiene en comisiones de servicios un total de: "+comisionServiciosTrabajador+
                "\n El trabajador tiene un sueldo base de: "+trabajadorSeleccionado.getSueldo()+

                "\n "+
                "\n El sueldo total a pagar del mes de "+meses.get(mesSeleccionado)+"es de: "+total;

        return s;
    }

}
