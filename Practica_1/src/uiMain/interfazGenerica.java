
package uiMain;

import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Reserva;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;

import javax.management.MBeanAttributeInfo;

public class interfazGenerica {

    public static void main(String[] args) {


        //SE INICIA EL DESERIALIZADOR Y SUELTA TODOS LOS OBJETOS CREADOS
        Deserializador.deserializarTodo();

        //CUANDO SE DESERIALIZA ES IMPORTANTE SETTEAR ESTOS ATRIBUTOS DE CLASE AL TAMAÑO ACTUAL DE LOS RESPECTIVOS ARRAYS QUE CONTIENEN LOS
        //OBJETOS DE LA CLASE, YA QUE TRABAJAMOS CON CODIGOS UNICOS Y CUANDO SE INICIA EL PROGRAMA ESTOS ATRIBUTOS SE DEVUELVEN A CERO
        Pedido.setNumeroPedido(Pedido.getPedidos().size());
        Producto.setNumeroProducto(Producto.getProductos().size());
        Reserva.setNumReservas(Reserva.getReservas().size());
        Cliente.setNumeroCliente(Cliente.getClientes().size());
        Gerente.setNumeroGerente(Gerente.getGerentes().size());
        Trabajador.setNumeroTrabajador(Trabajador.getTrabajadores().size());
        System.out.println("\nBienvenido a...\n\n");

        System.out.println(" _____  _____   ____  _____     ______          _        _______\n" +
                "|_   _||_   _| |_   \\|_   _|   |_   _ \\        / \\      |_   __ \\\n" +
                "  | |    | |     |   \\ | |       | |_) |      / _ \\       | |__) |\n" +
                "  | '    ' |     | |\\ \\| |       |  __'.     / ___ \\      |  __ /\n" +
                "   \\ \\__/ /     _| |_\\   |_     _| |__) |  _/ /   \\ \\_   _| |  \\ \\_\n" +
                "    `.__.'     |_____|\\____|   |_______/  |____| |____| |____| |___|\n" +
                "\n");

        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Ingresando al sistema...\n");
        while (true){
            System.out.println("---SISTEMA DE DISCOTECA---\n");
            System.out.println("Que acción desea realizar ?\n");
            System.out.println("1. Crear una nueva reserva");
            System.out.println("2. Modificar o cancelar una reserva ya existente");
            System.out.println("3. Opciones de Pedido/Facturar");
            System.out.println("4. Balance generar de ventas");
            System.out.println("5. Opciones Administrador");
            System.out.println("6. Historial de pedidos, productos, reservas y empleados");
            System.out.println("7. Salir Y GUARDAR del sistema");
            opcion = sc.nextInt();

            while(opcion<1 || opcion>7){
                System.out.println("Por favor ingrese una opcion valida");
                opcion=sc.nextInt();
            }
            switch (opcion){
                case 1:
                    FuncionalidadesReserva.realizarReserva();
                    break;
                case 2:
                    FuncionalidadesReserva.modificarCancelarReserva();
                    break;
                case 3:
                    FuncionalidadesFacturacion.opcionesDePedido();
                    break;
                case 4:
                    FuncionalidadesContabilidad.contabilidad();
                    break;
                case 5:

                    break;

                case 6:
                    FuncionalidadInformacion.Informacion();
                    break;
                case 7:
                    //SERIALIZA TODOS LOS OBJETOS CREADOS HASTA AHORA Y LOS GUARDA
                    Serializador.serializarTodo();
                    System.out.println("Saliendo del sistema...\n");
                    sc.close();
                    System.exit(0);

            }


        }


    }

}
