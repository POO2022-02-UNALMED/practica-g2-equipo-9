
package uiMain;

import java.util.Scanner;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Trabajador;

import javax.management.MBeanAttributeInfo;

public class interfazGenerica {

    public static void main(String[] args) {
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
            System.out.println("Que accion desea realizar ?\n");
            System.out.println("1. Crear una nueva reserva");
            System.out.println("2. Modificar o cancelar una reserva ya existente");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. Salir del sistema");
            opcion = sc.nextInt();

            while(opcion<1 || opcion>6){
                System.out.println("Por favor ingrese una opcion valida");
                opcion=sc.nextInt();
            }
            switch (opcion){
                case 1:
                    FuncionalidadesReserva.realizarReserva();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...\n");
                    sc.close();
                    System.exit(0);

            }


        }


    }
}
