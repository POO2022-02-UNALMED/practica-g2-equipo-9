package uiMain;

import gestorAplicacion.gestion.Pedido;

import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Reserva;
import gestorAplicacion.usuarios.*;


import java.util.ArrayList;
import java.util.Scanner;

// Esta funcionalidad muestra el historial de los pedidos, productos, reservas y empleados ingresados al sistema


public class FuncionalidadInformacion {

    static Scanner input = new Scanner(System.in);

    static String readString() {
        return input.nextLine();
    }

    static int readInt() {
        return input.nextInt();
    }

    static double readDouble() {
        return input.nextDouble();
    }

    static void pressEnter() {
        System.out.println("\nPresiona Enter para continuar...");
        readString();
    }



    public static void Informacion(){

        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Sistema del Historial del bar");
        System.out.println("*******************************");
        System.out.println("Historial sobre los pedidos, productos, reserva\n e información sobre los empleados");
        System.out.println("++++++++++++++++++++++++++++++++");

        String opcion;
        do {

            System.out.println(" 1. Pedidos.");
            System.out.println(" 2. Productos.");
            System.out.println(" 3. Empleados.");
            System.out.println(" 4. Reservas.");
            System.out.println(" 5. Gestion Empleados");
            System.out.println(" 0. Volver al menu principal\n");

            opcion = readString();

            switch (opcion){
                case "1":
                    info_pedidos();
                    break;
                case "2":
                    info_productos();
                    break;
                case "3":
                    info_empleados();
                    break;
                case "4":
                    info_reservas();
                    break;
                    
                case "5":
                	GestionEmpleados.GE();
                	break;
                case "0":
                    break;

                default:
                    System.out.println("\nLa opcion ingresada no es valida. Por favor presione Enter");
                    pressEnter();
                    break;
            }

        }while (!opcion.equals("0"));


    }

    static void info_pedidos(){
        int opcion_pedidos;
        ArrayList<Pedido> listapedidos = Pedido.getPedidos();
        opcion_pedidos = -1;
        do {
            System.out.println(
                    "\n++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Informacion de pedidos realizados");
            System.out.println("Total de pedidos recibidos: " + Pedido.getTotalPedidos());

            System.out.println("Seleccione el pedido que desea consultar\n");

            for (int i = 0; i < listapedidos.size(); ++i) {
                System.out.println(" " + (i + 1) + ". Pedido " + listapedidos.get(i).getCodigo());
            }

            System.out.println("\n 0. Regresar.");
            try {
                opcion_pedidos = Integer.parseInt(FuncionalidadInformacion.readString());
            } catch (Exception e) {
                System.out.println("\nIntroduzca una opción valida");
                pressEnter();
            }

            if ((opcion_pedidos - 1 >= listapedidos.size()) || (opcion_pedidos < 0)) {
                System.out.println("Introduzca una opción valida");
                pressEnter();
                continue;

            }
            if (opcion_pedidos == 0) {
                continue;
            }
            if (opcion_pedidos != -1) {
                System.out.println(listapedidos.get(opcion_pedidos - 1));
                pressEnter();
                opcion_pedidos = -1;
            }

        }while (!(opcion_pedidos == 0));

    }

    static void info_productos(){
        int opcion_producto;
        ArrayList<Producto> listaproductos = Producto.getProductos();
        opcion_producto = -1;
        do {
            System.out.println(
                    "\n+++++++++++++++++++++++++++++++++");

            System.out.println("Informacion sobre productos");

            System.out.println("Seleccione el producto que desea consultar\n");

            for (int i = 0; i < listaproductos.size(); ++i) {
                System.out.println(" " + (i + 1) + ". " + listaproductos.get(i).getNombre());
            }

            System.out.println("\n 0. Regresar.");

            try {
                opcion_producto = Integer.parseInt(FuncionalidadInformacion.readString());
            } catch (Exception e) {
                System.out.println("\nIntroduzca una opción valida");
                pressEnter();
            }

            if ((opcion_producto - 1 >= listaproductos.size()) || (opcion_producto < 0)) {
                System.out.println("Introduzca una opción valida");
                pressEnter();
                continue;
            }
            if (opcion_producto == 0) {
                continue;
            }
            if (opcion_producto != -1) {
                System.out.println(listaproductos.get(opcion_producto - 1));
                pressEnter();
                opcion_producto = -1;
            }

        } while (!(opcion_producto == 0));

    }

    static void info_empleados(){
        int opcion_empleados;
        ArrayList<Empleado> listaempleados = Empleado.getEmpleados();
        opcion_empleados = -1;

        do {
            System.out.println(
                    "\n+++++++++++++++++++++++++++++++++");

            System.out.println("Informacion sobre empleados");
            System.out.println("Lista de Empleados");

            for (int i = 0; i < listaempleados.size(); ++i) {
                System.out.println(" " + (i + 1) + ". " + listaempleados.get(i).getNombre());
            }
            //System.out.println("Lista de Empleados");
            System.out.println("\n 0. Regresar.");

            try {
                opcion_empleados = Integer.parseInt(FuncionalidadInformacion.readString());
            } catch (Exception e) {
                System.out.println("\nPor favor introduzca una opción valida");
                pressEnter();
            }
            if ((opcion_empleados - 1 >= listaempleados.size()) || (opcion_empleados < 0)) {
                System.out.println("Por favor introduzca una opción valida");
                pressEnter();
                continue;

            }
            if (opcion_empleados == 0) {
                continue;
            }
            if (opcion_empleados != -1) {
                System.out.println(listaempleados.get(opcion_empleados - 1).informacion());
                pressEnter();
                opcion_empleados = -1;
            }

        }while (!(opcion_empleados == 0));

    }

    static void info_reservas() {

        int opcion_reservas;
        ArrayList<Reserva> listareservas = Reserva.getReservas();
        opcion_reservas = -1;

        do {
            System.out.println(
                    "\n+++++++++++++++++++++++++++++++++");

            System.out.println("Informacion sobre reservas");
            System.out.println("Lista de Reservas realizadas");

            for (int i = 0; i < listareservas.size(); ++i) {
                System.out.println(" " + (i + 1) + ". " + listareservas.get(i).getIdReserva());
            }
            //System.out.println("Lista de Reservas realizadas");
            System.out.println("\n 0. Regresar.");

            try {
                opcion_reservas = Integer.parseInt(FuncionalidadInformacion.readString());
            } catch (Exception e) {
                System.out.println("\nPor favor introduzca una opción valida");
                pressEnter();
            }
            if ((opcion_reservas - 1 >= listareservas.size()) || (opcion_reservas < 0)) {
                System.out.println("Introduzca una opción valida");
                pressEnter();
                continue;
            }
            if (opcion_reservas == 0) {
                continue;
            }
            if (opcion_reservas != -1) {
                System.out.println(listareservas.get(opcion_reservas - 1));
                pressEnter();
                opcion_reservas = -1;
            }

        }while (!(opcion_reservas == 0));
    }
}

