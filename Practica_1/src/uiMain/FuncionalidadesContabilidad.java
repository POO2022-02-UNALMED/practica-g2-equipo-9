package uiMain;

import java.time.LocalDate;
import java.util.*;

import java.util.Scanner;

import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Sueldo;
import gestorAplicacion.usuarios.Trabajador;

public class FuncionalidadesContabilidad {
    //FUNCIONALIDAD CONTABILIDAD
    public static void contabilidad() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido al menu de contabilidad");

        System.out.println("Meses disponibles");
        SortedSet<Integer> fechas = new TreeSet<Integer>();
        for (Producto producto : Producto.getProductos()) {
            fechas.add(producto.getFechaVenta().getMonthValue());
        }
        for (Pedido pedido: Pedido.getPedidos()){
            fechas.add(pedido.getFechaPedido().getMonthValue());
        }
        HashMap<Integer,String> meses = new HashMap<Integer,String>();
        meses.put(1,"Enero");
        meses.put(2,"Febrero");
        meses.put(3, "Marzo");
        meses.put(4, "Abril");
        meses.put(5, "Mayo");
        meses.put(6,"Junio");
        meses.put(7, "Julio");
        meses.put(8, "Agosto");
        meses.put(9, "Septiembre");
        meses.put(10, "Octubre");
        meses.put(11, "Noviembre");
        meses.put(12, "Diciembre");


        HashMap<Integer,Integer> opcionMeses=new HashMap<>();

        System.out.println("Fechas Disponibles:");
        int i= 1;
        for (Integer e: fechas){
            //aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
            System.out.println("["+i+"]"+" "+meses.get(e)+" de "+2022);
            opcionMeses.put(i,e);
            i++;
        }
        //obtengo la fecha escogida
        System.out.println("Por favor ingresa una opcion:");
        int opcion=entrada.nextInt();
        while(opcion<=0 || opcion>opcionMeses.size()){
            System.out.println("Opcion no valida, ingresa otro numero");
            opcion= entrada.nextInt();
        }
        int mesSeleccionado=opcionMeses.get(opcion);
        System.out.println("Mes escogido: "+mesSeleccionado);

        System.out.println(FuncionalidadesContabilidad.calcularGananciasMes(mesSeleccionado,meses));
    }

    public static String calcularGananciasMes(int mesSeleccionado, HashMap<Integer,String> meses){

        //GUARDAMOS LA FECHA DE VENTA DE UN PRODUCTO
        ArrayList<Producto> productosVendidosMes =new ArrayList<>();
        double comisionesTotalesProductos=0;
        double totalVentasProductos=0;
        for(Producto producto: Producto.getProductos()){
            if (producto.getFechaVenta().getMonthValue()==mesSeleccionado && producto.getEstado().equals("Vendido")){
                productosVendidosMes.add(producto);
            }
        }
        //PRODUCTOS CON ESTADO VENDIDO EN ESE MES: CALCULAMOS VENTAS TOTALES Y COMISIONES TOTALES

        for(Producto producto: productosVendidosMes){
            totalVentasProductos+=producto.getPrecioVenta();
            comisionesTotalesProductos+=producto.getPrecioVenta()*Sueldo.porcentajeComisionProductos;
        }




        //SERVICIOS VENDIDOS EN EL MES SELECCIONADO
        ArrayList<Servicio> serviciosMes=new ArrayList<>();
        for (Pedido pedido: Pedido.getPedidos()){
            if(pedido.getFechaPedido().getMonthValue()==mesSeleccionado && pedido.getEstadoPedido()=="Pagado"){
                for (Servicio servicio: pedido.getServicios()){
                    serviciosMes.add(servicio);
                }
            }
        }
        double totalVentasDeServicios=0;
        double comisionesTotalesServicios=0;
        for (Servicio e: serviciosMes){
            totalVentasDeServicios+=e.getPrecio();
            comisionesTotalesServicios+=e.getPrecio()*Sueldo.porcentajeComisionServicios;
        }
        double pagoTrabajador=0;
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            pagoTrabajador+=trabajador.getSueldo();

        }
        double pagoGerente=0;
        for (Gerente gerente: Gerente.getGerentes()){
            pagoGerente+=gerente.getSueldo();
        }

        double gananciasNetas = totalVentasProductos+totalVentasDeServicios-pagoTrabajador-pagoGerente-comisionesTotalesProductos-comisionesTotalesServicios;//ganancias netas

        String s = "Contabilidad del mes "+meses.get(mesSeleccionado)+" del 2022:" +
                "\n-------------------------------"+
                "\nValor total por Productos: "+totalVentasProductos+
                "\nValor total por Servicios: "+totalVentasDeServicios+
                "\nPago mensual a Empleados: -"+pagoTrabajador+
                "\nPago Comisiones por Productos vendidos: -"+comisionesTotalesProductos+
                "\nPago Comisiones por Servicios vendidos -"+comisionesTotalesServicios+
                "\nPago mensual a gerentes: -"+pagoGerente;



        //Declaro un array de tipo Empleado para guardar objetos tipo Trabajador y Gerente

        //Esto de aqui que sigue es por si hay que pagar primas a trabajador
        double primaTrabajadores=0;
        double primaGerentes=0;
        ArrayList<Empleado> empleados= new ArrayList<>();
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            empleados.add(trabajador);
        }
        for (Gerente gerente: Gerente.getGerentes()){
            empleados.add(gerente);
        }
        if (meses.get(mesSeleccionado)=="Junio" || meses.get(mesSeleccionado)=="Diciembre"){
            for (Empleado empleado: empleados){
                if (empleado instanceof Trabajador){//Utilice instanceof cuando necesite confirmar el tipo de un objeto en tiempo de ejecución. Verifica si empleado pertenece a Trabajador
                    primaTrabajadores+=empleado.calculoDePrima();
                }
                else if(empleado instanceof Gerente){
                    primaGerentes+=empleado.calculoDePrima();
                }
            }
            gananciasNetas-=(primaTrabajadores-primaGerentes);
            s+="\nPago de Prima a Empleados: -"+primaTrabajadores+
                    "\nPago de Prima a Gerentes: -"+primaGerentes;
        }

        //El resultado final de toda esta cosa es

        s += "\n-------------------------------"+
                "\n\nGanancias totales de este mes: "+ gananciasNetas;
        return s;

    }

}
