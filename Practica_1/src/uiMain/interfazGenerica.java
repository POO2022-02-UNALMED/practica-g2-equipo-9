
package uiMain;

import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.gestion.Espacio;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;
import gestorAplicacion.gestion.Reserva;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;

import javax.management.MBeanAttributeInfo;

public class interfazGenerica {

    public static void main(String[] args) {
        Espacio sala1 = new Espacio("Sala 1");
        Espacio sala2 = new Espacio("Sala 2");
        Espacio sala3 = new Espacio("Sala 3");

        new Producto("coca cola 250ml", "No vendido" , 2, 2);
        new Producto("Sprite", "No vendido" , 2, 2);
        new Producto("H20", "No vendido" , 2, 2);
        new Producto("Bretana", "No vendido", 2, 2);
        new Producto("coca cola 250ml", "No vendido", 2, 2);
        new Producto("Swchepes", "No vendido", 2, 2);
        new Producto("coca cola 250ml", "No vendido", 2, 2);
        new Producto("Kola Roman", "No vendido", 2, 2);
        new Producto("coca cola 250ml", "No vendido", 2, 2);
        new Producto("Hit mango", "No vendido", 2, 2);
        new Producto("Hit mora", "No vendido", 2, 2);
        new Producto("Smirnoff ice 1L", "No vendido", 5, 1);
        new Producto("Nuvo", "No vendido", 5, 1);
        new Producto("Black and White", "No vendido", 5, 1);
        new Producto("Smirnoff ice 1L", "No vendido", 5, 1);
        new Producto("Something Special", "No vendido", 5, 1);
        new Producto("Double Black", "No vendido", 5, 1);
        new Producto("Red Label", "No vendido", 5, 1);
        new Producto("Double Black", "No vendido", 5, 1);
        new Producto("Red Label", "No vendido", 5, 1);
        new Producto("Blue Label", "No vendido", 5, 1);
        new Producto("Buchanan's", "No vendido", 5, 1);
        new Producto("Arguardiente Antioqueno", "No vendido", 5, 1);
        new Producto("Old par", "No vendido", 10, 1);
        new Producto("Desgranado", "No vendido", 2, 3);
        new Producto("hamburguesa", "No vendido", 2, 3);
        new Producto("pizza", "No vendido", 2, 3);
        new Producto("Salchipapa", "No vendido", 2, 3);
        new Producto("Hot Dog", "No vendido", 2, 3);
        new Producto("pizza", "No vendido", 2, 3);
        new Producto("Lasagna", "No vendido", 2, 3);
        new Producto("hamburguesa", "No vendido", 2, 3);
        new Producto("pan", "No vendido", 2, 3);
        new Producto("hamburguesa", "No vendido", 2, 3);
        new Producto("ensalada", "No vendido", 2, 3);
        new Producto("rosquitas", "No vendido", 2, 4);
        new Producto("papitas", "No vendido", 2, 4);
        new Producto("mani sal", "No vendido", 2, 4);
        new Producto("almendras", "No vendido", 2, 4);
        new Producto("crispetas", "No vendido", 2, 4);
        new Producto("mani pasas", "No vendido", 2, 4);
        new Producto("mani dulce", "No vendido", 2, 4);
        new Producto("Manguito", "No vendido", 2, 4);
        new Producto("Detodito", "No vendido", 2, 4);
        new Producto("Malboro", "No vendido", 2, 5);
        new Producto("boston", "No vendido", 2, 5);
        new Producto("Piel Roja", "No vendido", 2, 5);

        new Producto("belmont", "No vendido", 2, 5);
        new Producto("Lucky Strike", "No vendido", 2, 5);
        new Producto("Rumba", "No vendido", 2, 5);
        new Producto("Lucky Strike", "No vendido", 2, 5);
        new Producto("Star Lite", "No vendido", 2, 5);
        new Producto("Shefield green", "No vendido", 2, 5);
        new Producto("belmont", "No vendido", 2, 5);
        new Producto("Red Bull", "No vendido", 2, 6);
        new Producto("Sparta", "No vendido", 2, 6);
        new Producto("Red Bull", "No vendido", 2, 6);
        new Producto("Bang", "No vendido", 2, 6);
        new Producto("Monster", "No vendido", 2, 6);
        new Producto("Blue", "No vendido", 2, 6);
        new Producto("RockStar", "No vendido", 2, 6);
        new Producto("RockStar", "No vendido", 2, 6);
        new Producto("RockStar", "No vendido", 2, 6);
        new Producto("RockStar", "No vendido", 2, 6);
        new Producto("Monster", "No vendido", 2, 6);
        new Producto("vive 100", "No vendido", 2, 6);
        new Producto("vive 100", "No vendido", 2, 6);
        new Producto("vive 100", "No vendido", 2, 6);
        new Producto("vive 100", "No vendido", 2, 6);
        new Producto("speed max", "No vendido", 2, 6);
        new Producto("speed max", "No vendido", 2, 6);
        new Producto("speed max", "No vendido", 2, 6);
        new Producto("speed max", "No vendido", 2, 6);
        Cliente cliente1 = new Cliente("Jose Fernandez");


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
            System.out.println("4. Balance de ventas");
            System.out.println("5. Calculo de nomina");
            System.out.println("6. Opciones de administrador");
            System.out.println("7. Historial de pedidos, productos, reservas y empleados");
            System.out.println("8. Salir Y GUARDAR del sistema");
            opcion = sc.nextInt();

            while(opcion<1 || opcion>8){
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
                    FuncionalidadesNomina.calculoDeNomina();
                    break;
                case 6:
                    FuncionalidadesAdministrador.opcionesAdministrador();
                    break;
                case 7:
                    FuncionalidadInformacion.Informacion();
                    break;
                case 8:
                    //SERIALIZA TODOS LOS OBJETOS CREADOS HASTA AHORA Y LOS GUARDA
                    Serializador.serializarTodo();
                    System.out.println("Saliendo del sistema...\n");
                    sc.close();
                    System.exit(0);

            }



        }



    }

}
