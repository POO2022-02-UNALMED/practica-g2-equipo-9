package uiMain;

import java.time.LocalDate;

import gestorAplicacion.gestion.Espacio;
import gestorAplicacion.gestion.Servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FuncionalidadesReserva {

    public static void realizarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al menu para realizar una Reserva");
        System.out.println("Por favor escoja un sitio a reservar disponible");
        ArrayList<Espacio> espaciosDisponibles = Espacio.getListado();
        for (int i = 0; i < espaciosDisponibles.size(); i++) { // ciclo para mostrar los espacios disponibles
            System.out.println(i + ". " + espaciosDisponibles.get(i).getNombre());
        }
        System.out.println("Ingrese su opcion: ");
        int opcion = sc.nextInt();
        while (opcion < 0 || opcion >= (espaciosDisponibles.size())) {
            System.out.println("Por favor ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }

        Espacio espacioTomado = espaciosDisponibles.get(opcion); // seleciona el espacio del atributo de clase espaciosDisponibles


        System.out.println("A continuacion le presentamos la disponibildiad del espacio: ");

        for (int i = 0; i < 10; i++) { // imprime los primeros 10 dias disponibles
            System.out.println(i + ". " + espacioTomado.getFechas().get(i));
        }
        System.out.println("Escoja una opcion ");
        opcion = sc.nextInt();
        while (opcion < 0 || opcion >= 10) {
            System.out.println("Por favor ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }
        LocalDate fechaTomada = espacioTomado.getFechas().get(opcion);
        espacioTomado.getFechas().remove(opcion); // se quita la disponibilidad de la fecha seleccionada
        System.out.println("Desea agregar servicios adicionales a la reserva? ");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        opcion = sc.nextInt();
        while(opcion != 1 && opcion != 2){
            System.out.println("Por favor ingrese una opcion valdia");
            opcion = sc.nextInt();
        }
        List<Servicio> serviciosDisponibles = Arrays.asList(Servicio.values()); // Convierte el Array de Servicio a ArrayList de Servicio

        while (opcion ==1 || serviciosDisponibles.size()!=0){ // loop para mostrar los serviicios a escoger por el cliente

            List<Servicio> serviciosTomados = new ArrayList<>();
            for (int i = 0; i < serviciosDisponibles.size(); i++) {
                System.out.println(i+". "+serviciosDisponibles.get(i));
            }
            System.out.println("Por favor ingrese el serivicio que desea añadir: ");
            int opcionServicio = sc.nextInt();
            while(opcionServicio >= serviciosDisponibles.size() || opcionServicio < 0){
                System.out.println("Por favor ingrese una opcion valida");
                opcionServicio = sc.nextInt();
            }
            serviciosTomados.add(serviciosDisponibles.get(opcionServicio)); // se añade al ArrayList el serivicio tomado
            serviciosDisponibles.remove(opcionServicio); // se elimina de servicios disponibles ya que fue tomado previamente
            System.out.println("Desea agregar mas servicios ?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcionServicio = sc.nextInt();
            while(opcionServicio != 1 && opcionServicio != 2){
                System.out.println("Por favor ingrese una opcion valdia");
                opcionServicio = sc.nextInt();
            }
            opcion = opcionServicio;
        } // el ciclo se termina por peticion del usuario o porque ya selecciono todos los servicios disponibles

        //PRODUCTOS A AGREGAR EN LA RESERVA Y SU CANTIDAD
        System.out.println("A continuacion ingrese los productos que desea en su reserva: ");
        System.out.println("1. Bebidas alcoholicas");
        System.out.println("2. Bebidas no alcoholicas");
        System.out.println("3. Comida");
        System.out.println("4. Snacks");
        System.out.println("5. Cigarrillos");
        System.out.println("6. Energizantes");
        System.out.println("7. Otros");






    }



}

