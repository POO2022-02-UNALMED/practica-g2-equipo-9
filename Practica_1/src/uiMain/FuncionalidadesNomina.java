package uiMain;

import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.usuarios.Trabajador;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

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
        //obtengo la fecha escogida
        System.out.println("Por favor ingresa una opcion:");
        int opcion=entrada.nextInt();
        int mesSeleccionado=opcionMeses.get(opcion);
        System.out.println("Mes escogido: "+mesSeleccionado);


        System.out.println("Selecciona trabajador a liquidar:");

        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Producto producto = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto1 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto2 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 1), 0, 0);
        Producto producto3 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 12, 1), 0, 0);
        Trabajador trabajador1=new Trabajador(null,null,false,null,null,0,null);
        Producto producto4 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 06, 02), 0, 0);
        Producto producto5 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 04, 1), 0, 0);
        Producto producto6 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 1, 02), 0, 0);
        Producto producto7 = new Producto(null, null, "Vendido", "coca", 0, 400, null, null, LocalDate.of(2020, 02, 1), 0, 0);

        calculoDeNomina();
    }
}
