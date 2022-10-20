package uiMain;

import java.time.LocalDate;
import java.util.*;

import java.util.Scanner;

import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Sueldo;
import gestorAplicacion.usuarios.Trabajador;

import javax.sound.midi.Soundbank;

public class FuncionalidadVerificarProducto {

    public static void VerificarProducto(){

        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Sistema de bodega de productos");
        System.out.println("++++++++++++++++++++++++++++++++");

        System.out.println("Acontinuación Podra Visualizar el total de productos");

        Scanner input =new Scanner(System.in);
        System.out.println("Que operacion desea realizar? ");
        System.out.println("1. Verificar producto por mes de ingreso");
        System.out.println("2. Verificar producto por precio");
        System.out.println("3. Verificar producto por categoria"); // bebidasAlcoholicas, bebidasNoAlcoholicas, comidas, snacks, cigarrillos, energizantes, otrosProductos
        System.out.println(("4. verficcar el total de todos los productos"));

        int opcion = input.nextInt();

        if(opcion==1){
            SortedSet<Integer> fechas = new TreeSet<Integer>();
            for (Producto producto : Producto.getProductos()) {
               //
                fechas.add(producto.getFechaIngreso().getMonthValue());
            }
            HashMap<Integer,String> meses = new HashMap<Integer,String>();
            meses.put(1,"Enero"); meses.put(2,"Febrero"); meses.put(3, "Marzo"); meses.put(4, "Abril"); meses.put(5, "Mayo"); meses.put(6,"Junio");
            meses.put(7, "Julio");meses.put(8, "Agosto"); meses.put(9, "Septiembre"); meses.put(10, "Octubre"); meses.put(11, "Noviembre"); meses.put(12, "Diciembre");

            Iterator value = fechas.iterator();

            HashMap<Integer,Integer> opcionMeses=new HashMap<>();

            System.out.println("Fechas Disponibles:");
            int i= 1;
            for (Integer e: fechas){

                System.out.println("["+i+"]"+" "+meses.get(e)+" de "+2022);
                opcionMeses.put(i,e);
                i++;
            }
            System.out.println("Por favor ingresa un mes:");
            int opcion1=input.nextInt();
            int mesSeleccionado=opcionMeses.get(opcion1);
            System.out.println("Mes escogido: "+mesSeleccionado);
        }

        if(opcion==2){

        }

        if(opcion==3){

        }

        if(opcion==4){

        }

        if(opcion==5){

        }


    }


}
