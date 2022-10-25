
package uiMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;

import javax.management.MBeanAttributeInfo;

public class interfazGenerica {

    public static void main(String[] args) {
        //SE INICIA EL DESERIALIZADOR Y SUELTA TODOS LOS OBJETOS CREADOS
        Deserializador.deserializarTodo();
        Pedido.setNumeroPedido(Pedido.getPedidos().size());
        Producto.setNumeroProducto(Producto.getProductos().size());
        Reserva.setNumReservas(Reserva.getReservas().size());
        Cliente.setNumeroCliente(Cliente.getClientes().size());
        Gerente.setNumeroGerente(Gerente.getGerentes().size());
        Trabajador.setNumeroTrabajador(Trabajador.getTrabajadores().size());

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





        new Producto("Aguila","No vendido",700,1);
        new Producto("Club colombia","Vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Tecate","No vendido",600,1);
        new Producto("Aguila","No vendido",700,1);
        new Producto("Club colombia","Vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Tecate","No vendido",600,1);
        new Producto("Aguila","No vendido",700,1);
        new Producto("Club colombia","Vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Tecate","No vendido",600,1);
        new Producto("Aguila","No vendido",700,1);
        new Producto("Club colombia","Vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Heineken","No vendido",500,1);
        new Producto("Tecate","No vendido",600,1);
        new Producto("Tecate","No vendido",600,1);
        new Producto("Tecate","No vendido",600,1);



        Cliente miguel=new Cliente("Miguel");
        Cliente gustavo=new Cliente("Gustavo");



        //NOMINA FACTURACION
        Gerente gerente1=new Gerente("Mafe",LocalDate.of(2020,06,1));
        Trabajador trabajador1=new Trabajador("Sergio",LocalDate.of(2020,01,25));
        Trabajador trabajador2=new Trabajador("Russbell",LocalDate.of(2020,02,14));

        Cliente cliente2=new Cliente();
        Cliente cliente3=new Cliente("Julio");


        Producto a=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a1=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a2=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a3=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a4=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a5=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a6=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));
        Producto a7=new Producto(trabajador2,"Vendido","vive 100", 600,LocalDate.of(2022,03,12));

        Producto a8=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a9=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a10=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a11=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a12=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a13=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a14=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a15=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));

        Producto a32=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a33=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a34=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a35=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a36=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a37=new Producto(trabajador2,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));



        Producto a16=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a17=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a18=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a19=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a20=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a21=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a22=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a23=new Producto(trabajador1,"Vendido","Aguila", 600,LocalDate.of(2022,03,12));
        Producto a24=new Producto(trabajador1,"Vendido","Aguila",700,LocalDate.of(2022,03,17));
        Producto a25=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,03,17));

        Producto a26=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a27=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a28=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a29=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a30=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));
        Producto a31=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,06,17));

        Producto a38=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a39=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a40=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));
        Producto a41=new Producto(trabajador1,"Vendido","Rockstar",700,LocalDate.of(2022,12,17));




        ArrayList<Producto> productos1=new ArrayList<>();
        productos1.add(a1);
        productos1.add(a2);
        productos1.add(a3);
        productos1.add(a4);
        productos1.add(a5);
        productos1.add(a6);
        productos1.add(a7);

        ArrayList<Producto> productos2=new ArrayList<>();
        productos1.add(a8);
        productos1.add(a9);
        productos1.add(a10);
        productos1.add(a11);
        productos1.add(a12);
        productos1.add(a13);
        productos1.add(a14);
        productos1.add(a15);

        ArrayList<Producto> productos3=new ArrayList<>();
        productos3.add(a32);
        productos3.add(a33);
        productos3.add(a34);
        productos3.add(a35);
        productos3.add(a36);
        productos3.add(a37);

        ArrayList<Producto> productos4=new ArrayList<>();
        productos4.add(a16);
        productos4.add(a17);
        productos4.add(a18);
        productos4.add(a19);
        productos4.add(a20);
        productos4.add(a21);
        productos4.add(a22);
        productos4.add(a23);
        productos4.add(a24);
        productos4.add(a25);



        ArrayList<Producto> productos5=new ArrayList<>();
        productos5.add(a26);
        productos5.add(a27);
        productos5.add(a28);
        productos5.add(a29);
        productos5.add(a30);
        productos5.add(a31);


        ArrayList<Producto> productos6=new ArrayList<>();
        productos6.add(a38);
        productos6.add(a39);
        productos6.add(a40);
        productos6.add(a41);



        ArrayList<Servicio> servicios1=new ArrayList<>();
        servicios1.add(Servicio.STRIPPER);
        servicios1.add(Servicio.BARMAN);
        servicios1.add(Servicio.COCKTAILCHALLENGE);
        servicios1.add(Servicio.MESEROEXCLUSIVO);
        servicios1.add(Servicio.MESEROEXCLUSIVO);

        ArrayList<Servicio> servicios2=new ArrayList<>();
        servicios2.add(Servicio.STRIPPER);
        servicios2.add(Servicio.BARMAN);

        ArrayList<Servicio> servicios3=new ArrayList<>();
        servicios3.add(Servicio.STRIPPER);
        servicios3.add(Servicio.BARMAN);

        ArrayList<Servicio> servicios4=new ArrayList<>();
        servicios4.add(Servicio.STRIPPER);
        servicios4.add(Servicio.BARMAN);

        ArrayList<Servicio> servicios5=new ArrayList<>();
        servicios5.add(Servicio.STRIPPER);
        servicios5.add(Servicio.BARMAN);

        ArrayList<Servicio> servicios6=new ArrayList<>();
        servicios6.add(Servicio.STRIPPER);
        servicios6.add(Servicio.BARMAN);

        Pedido pedido1=new Pedido(trabajador2,cliente2,"Pagado",productos1,servicios1,LocalDate.of(2022,03,12));
        Pedido pedido2=new Pedido(trabajador2,cliente3,"Pagado",productos2,servicios2,LocalDate.of(2022,06,12));
        Pedido pedido3=new Pedido(trabajador2,cliente2,"Pagado",productos3,servicios3,LocalDate.of(2022,12,12));


        Pedido pedido4=new Pedido(trabajador1,cliente2,"Pagado",productos4,servicios4,LocalDate.of(2022,03,12));
        Pedido pedido5=new Pedido(trabajador1,cliente3,"Pagado",productos5,servicios5,LocalDate.of(2022,06,12));
        Pedido pedido6=new Pedido(trabajador1,cliente2,"Pagado",productos6,servicios6,LocalDate.of(2022,12,12));

        //CUANDO SE DESERIALIZA ES IMPORTANTE SETTEAR ESTOS ATRIBUTOS DE CLASE AL TAMAÑO ACTUAL DE LOS RESPECTIVOS ARRAYS QUE CONTIENEN LOS
        //OBJETOS DE LA CLASE, YA QUE TRABAJAMOS CON CODIGOS UNICOS Y CUANDO SE INICIA EL PROGRAMA ESTOS ATRIBUTOS SE DEVUELVEN A CERO

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
