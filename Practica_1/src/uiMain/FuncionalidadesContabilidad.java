package uiMain;

import java.time.LocalDate;
import java.util.*;

import java.util.Scanner;

import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Sueldo;
import gestorAplicacion.usuarios.Trabajador;

public class FuncionalidadesContabilidad {
    //FUNCIONALIDAD CONTABILIDAD
    public static void contabilidad() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido al menu de contabilidad");

        System.out.println("Meses disponibles");

        //se buscan meses en los que se han comprado productos
        //tanteando cosas XD
        //Sorted set almacena las fechas de forma ordenada y no admite repetidos, lo hace automaticamente
        SortedSet<Integer> fechas = new TreeSet<Integer>();//meses unicos
        for (Producto producto : Producto.getProductos()) {
            //busca la fecha de venta de producto, luego obtiene de ella el int asociado al mes y lo guarda en fechas
            fechas.add(producto.getFechaVenta().getMonthValue());
        }
        //Busca fechas de servicios de los que se tengan conocimiento de orden
        for (Pedido pedido: Pedido.getPedidos()){
            fechas.add(pedido.getFechaPedido().getMonthValue());
        }
        HashMap<Integer,String> meses = new HashMap<Integer,String>();
        meses.put(1,"Enero"); meses.put(2,"Febrero"); meses.put(3, "Marzo"); meses.put(4, "Abril"); meses.put(5, "Mayo"); meses.put(6,"Junio");
        meses.put(7, "Julio");meses.put(8, "Agosto"); meses.put(9, "Septiembre"); meses.put(10, "Octubre"); meses.put(11, "Noviembre"); meses.put(12, "Diciembre");

        //Iterator lo uso para recorrer el Array fechas de forma secuencial
        Iterator value = fechas.iterator(); //El método iterator() nos va a permitir obtener un objeto de tipo Iterator que representa la colección a recorrer


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
        int mesSeleccionado=opcionMeses.get(opcion);
        System.out.println("Mes escogido: "+mesSeleccionado);

        System.out.println(FuncionalidadesContabilidad.calcularGananciasMes(mesSeleccionado,meses));
    }

    public static String calcularGananciasMes(int mesSeleccionado, HashMap<Integer,String> meses){

        //GUARDAMOS LA FECHA DE VENTA DE UN PRODUCTO
        ArrayList<Producto> productosVendidosMes =new ArrayList<>();

        for(Producto producto: Producto.getProductos()){
            if (producto.getFechaVenta().getMonthValue()==mesSeleccionado){
                productosVendidosMes.add(producto);
            }
        }
        //PRODUCTOS CON ESTADO VENDIDO EN ESE MES Y CALCULAMOS LAS COMISIONES
        double comisionesTotales=0;
        double totalVentasProductos=0;
        for(Producto producto: productosVendidosMes){
            if(producto.getEstado().equals("VENDIDO")){
                totalVentasProductos+=producto.getPrecioVenta();
                comisionesTotales+=producto.getPrecioVenta()*Sueldo.porcentajeComision;
            }
        }

        //CALCULAMOS LAS COMISIONES TOTALES POR LOS PRODUCTOS VENDIDOS ESE MES



        //SERVICIOS VENDIDOS EN EL MES SELECCIONADO
        ArrayList<Servicio> serviciosMes=new ArrayList<>();
        for (Pedido pedido: Pedido.getPedidos()){
            if(pedido.getFechaPedido().getMonthValue()==mesSeleccionado && pedido.getEstadoPedido()=="PAGADO"){
                for (Servicio servicio: pedido.getServicios()){
                    serviciosMes.add(servicio);
                }
            }
        }
        double totalVentasDeServicios=0;
        for (Servicio e: serviciosMes){
            totalVentasDeServicios+=e.getPrecio();
        }
        double pagoTrabajador=0;
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            pagoTrabajador+=trabajador.getSueldo();

        }
        double pagoGerente=0;
        for (Gerente gerente: Gerente.getGerentes()){
            pagoGerente+=gerente.getSueldo();
        }

        double gananciasNetas = totalVentasProductos+totalVentasDeServicios-pagoTrabajador-pagoGerente-comisionesTotales;//ganancias netas

        String s = "Contabilidad del mes "+meses.get(mesSeleccionado)+" del 2022:" +
                "\n-------------------------------"+
                "\nValor total por Productos: "+totalVentasProductos+
                "\nValor total por Servicios: "+totalVentasDeServicios+
                "\nPago mensual a Empleados: -"+pagoTrabajador+
                "\nPago Comisiones a Trabajadores: -"+comisionesTotales+
                "\nPago mensual a gerentes: -"+pagoGerente;



        //Declaro un array de tipo Sueldo para guardar objetos tipo Trabajador y Gerente

        //Esto de aqui que sigue es por si hay que pagar primas a trabajador
        double primaEmpleados=0;
        double primaGerente=0;
        ArrayList<Sueldo> empleados= new ArrayList<>();
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            empleados.add(trabajador);
        }
        for (Gerente gerente: Gerente.getGerentes()){
            empleados.add(gerente);
        }
        if (meses.get(mesSeleccionado)=="Junio" || meses.get(mesSeleccionado)=="Diciembre"){
            for (Sueldo empleado: empleados){
                if (empleado instanceof Trabajador){//Utilice instanceof cuando necesite confirmar el tipo de un objeto en tiempo de ejecución. Verifica si prima pertenece a trabajador
                    primaEmpleados+=empleado.calculoDePrima();
                }
                else if(empleado instanceof Gerente){
                    primaGerente+=empleado.calculoDePrima();
                }
            }
            gananciasNetas-=(primaEmpleados-primaGerente);
            s+="\nPago de Prima a Empleados: -"+primaEmpleados+
                    "\nPago de Prima a Gerentes: -"+primaGerente;
        }

        //El resultado final de toda esta cosa es

        s += "\n-------------------------------"+
                "\n\nGanancias totales de este mes: "+ gananciasNetas;
        return s;

    }

    public static void main(String[] args) {
        Producto producto = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto1 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto2 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 1), 0, 0);
        Producto producto3 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 12, 1), 0, 0);
        Trabajador trabajador1=new Trabajador(null,false,null,0,null);
        Trabajador trabajador2=new Trabajador(null,false,null,0,null);
        System.out.println(trabajador1.getCodigo());
        System.out.println(trabajador2.getCodigo());
        Gerente gerente1= new Gerente(null,false,null);
        Gerente gerente2= new Gerente(null,false,null);


    }
}
