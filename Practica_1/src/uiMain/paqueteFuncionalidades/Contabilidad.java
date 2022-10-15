package uiMain.paqueteFuncionalidades;

import java.time.LocalDate;
import java.util.*;

import java.util.Scanner;

import gestorAplicacion.gestion.*;

public class Contabilidad {
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
        HashMap<Integer,String> meses = new HashMap<Integer,String>();
        meses.put(1,"Enero"); meses.put(2,"Febrero"); meses.put(3, "Marzo"); meses.put(4, "Abril"); meses.put(5, "Mayo"); meses.put(6,"Junio");
        meses.put(7, "Julio");meses.put(8, "Agosto"); meses.put(9, "Septiembre"); meses.put(10, "Octubre"); meses.put(11, "Noviembre"); meses.put(12, "Diciembre");

        //Iterator lo uso para recorrer el Array fechas de forma secuencial
        Iterator value = fechas.iterator(); //El método iterator() nos va a permitir obtener un objeto de tipo Iterator que representa la colección a recorrer

        //.hasNext: Método que devuelve true si existe un siguiente elemento a la hora de iterar sobre una colección.
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

        Contabilidad.calcularVentasMes(mesSeleccionado);
    }

    public static void calcularVentasMes(int mesSeleccionado){
        ArrayList<Producto> productosVendidosMes =new ArrayList<>();

        for(Producto producto: Producto.getProductos()){
            if (producto.getFechaVenta().getMonthValue()==mesSeleccionado){
                productosVendidosMes.add(producto);
            }
        }
        Double totalVentasProductos=0;
        for(Producto producto: productosVendidosMes){
            if(producto.getEstado()=="Vendido"){
                totalVentasProductos+=producto.getPrecioVenta();
            }
        }
        double ventasTotales = 0;
    }

    public static void main(String[] args) {
        Producto producto = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto1 = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 02, 02), 0, 0);
        Producto producto2 = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 02, 1), 0, 0);
        Producto producto3 = new Producto(null, null, "vendido", "coca", 0, 0, null, null, LocalDate.of(2020, 12, 1), 0, 0);
        contabilidad();
    }
}
