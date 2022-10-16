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
        System.out.println("Bienvenidos al pago de Nomina: ");

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
        for (Integer e: fechas){
            //aqui se muestran las fechas de las que se tiene conocimiento de ventas realizadas
            System.out.println("["+i+"]"+" "+meses.get(e)+" de "+2022);
            opcionMeses.put(i,e);
            i++;
        }
        //Obtengo la fecha escogida
        System.out.println("Por favor ingresa una opcion:");
        int opcion=entrada.nextInt();
        int mesSeleccionado=opcionMeses.get(opcion);
        System.out.println("Mes escogido: "+mesSeleccionado);

        //Seleccionar trabajador
        System.out.println("Selecciona trabajador a liquidar:");

        for (Trabajador trabajador: Trabajador.getTrabajadores()){

            System.out.println(trabajador);
        }
        System.out.println("Ingresa codigo del trabajador: ");
        long codigo = entrada.nextInt();//codigo de empleado

        //buscamos el codigo del trabajador
        Trabajador trabajadorSeleccionado=null;
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            if(trabajador.getCodigo()==codigo){
                trabajadorSeleccionado=trabajador;
                break;
            }
        }

        System.out.println(FuncionalidadesNomina.nominaEmpleado(mesSeleccionado,trabajadorSeleccionado));


    }
    public static String nominaEmpleado(long mesSeleccionado, Trabajador trabajadorSeleccionado){
        //PRODUCTOS QUE VENDIO EMPLEADO
        ArrayList<Producto> productosVendioEmpleado= new ArrayList<>();
        for (Producto producto: Producto.getProductos()){
            if (producto.getFechaVenta().getMonthValue()==mesSeleccionado && producto.getTrabajador()==trabajadorSeleccionado && producto.getEstado().equals("VENDIDO")){
                productosVendioEmpleado.add(producto);
            }
        }
        //COMISION POR VENTA
        double comisionesEmpleado=0;
        for(Producto e: productosVendioEmpleado){
            comisionesEmpleado+=e.getPrecioVenta()*Sueldo.porcentajeComision;
        }

        //SERVICIOS QUE VENDIO
        ArrayList<Servicio> serviciosVendioEmpleado= new ArrayList<>();
        for(Pedido e: Pedido.getPedidos()){
            if(e.getFechaPedido().getMonthValue()==mesSeleccionado && e.getTrabajador()==trabajadorSeleccionado && e.getEstadoPedido().equals("PAGADO")){
                for(Servicio servicio: e.getServicios()){
                    serviciosVendioEmpleado.add(servicio);
                }
            }
        }
    }

    public static void main(String[] args) {
        Producto producto = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto1 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto2 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 1), 0, 0);
        Producto producto3 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 12, 1), 0, 0);
        Producto producto4 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 06, 02), 0, 0);
        Producto producto5 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 04, 1), 0, 0);
        Producto producto6 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 1, 02), 0, 0);
        Producto producto7 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 1), 0, 0);



    }
}
