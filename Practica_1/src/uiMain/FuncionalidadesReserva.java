package uiMain;

import java.time.LocalDate;

import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FuncionalidadesReserva {

    public static void agregarProductos(Pedido pedidoReserva){ // metodo para agregar los productos al pedido asociado a la reserva
        System.out.println("Por favor ingrese 1 para empezar");
        Scanner sc = new Scanner(System.in);
        int opcionCiclo = sc.nextInt();
        while(opcionCiclo != 2){
            System.out.println("A continuacion ingrese los productos que desea en su reserva: ");
            System.out.println("1. Bebidas alcoholicas");
            System.out.println("2. Bebidas no alcoholicas");
            System.out.println("3. Comida");
            System.out.println("4. Snacks");
            System.out.println("5. Cigarrillos");
            System.out.println("6. Energizantes");
            System.out.println("7. Otros");



            int opcion = sc.nextInt();
            while (opcion> 7 || opcion< 1){
                System.out.println("Por favor ingrese una opcion valdia");
                opcion = sc.nextInt();
            }
            switch (opcion){
                case 1:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getBebidasAlcoholicas().get(i).getNombre()+" Precio: "+Producto.getBebidasAlcoholicas().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los productos de esta categoria");
                    int opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getBebidasAlcoholicas().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getBebidasAlcoholicas().size(); i++) {
                            System.out.println(i+". "+Producto.getBebidasAlcoholicas().get(i).getNombre()+" Precio: "+Producto.getBebidasAlcoholicas().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getBebidasAlcoholicas().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getBebidasAlcoholicas().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getBebidasNoAlcoholicas().get(i).getNombre()+" Precio: "+Producto.getBebidasNoAlcoholicas().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getBebidasNoAlcoholicas().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getBebidasNoAlcoholicas().size(); i++) {
                            System.out.println(i+". "+Producto.getBebidasNoAlcoholicas().get(i).getNombre()+" Precio: "+Producto.getBebidasNoAlcoholicas().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getBebidasNoAlcoholicas().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getBebidasNoAlcoholicas().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getComidas().get(i).getNombre()+" Precio: "+Producto.getComidas().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getComidas().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getComidas().size(); i++) {
                            System.out.println(i+". "+Producto.getComidas().get(i).getNombre()+" Precio: "+Producto.getComidas().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getComidas().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getComidas().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getSnacks().get(i).getNombre()+" Precio: "+Producto.getSnacks().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getSnacks().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getSnacks().size(); i++) {
                            System.out.println(i+". "+Producto.getSnacks().get(i).getNombre()+" Precio: "+Producto.getSnacks().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getSnacks().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getSnacks().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getCigarrillos().get(i).getNombre()+" Precio: "+Producto.getCigarrillos().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getCigarrillos().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getCigarrillos().size(); i++) {
                            System.out.println(i+". "+Producto.getCigarrillos().get(i).getNombre()+" Precio: "+Producto.getCigarrillos().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getCigarrillos().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getCigarrillos().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getEnergizantes().get(i).getNombre()+" Precio: "+Producto.getEnergizantes().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getEnergizantes().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getEnergizantes().size(); i++) {
                            System.out.println(i+". "+Producto.getEnergizantes().get(i).getNombre()+" Precio: "+Producto.getEnergizantes().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getEnergizantes().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getEnergizantes().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getOtrosProductos().get(i).getNombre()+" Precio: "+Producto.getOtrosProductos().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("o ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                            while(cantidadProducto>1){
                                if(producto.getNombre().equals(Producto.getOtrosProductos().get(opcionProducto).getNombre())){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                }
                            }
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getOtrosProductos().size(); i++) {
                            System.out.println(i+". "+Producto.getOtrosProductos().get(i).getNombre()+" Precio: "+Producto.getOtrosProductos().get(i).getPrecioVenta());
                        }
                        if (opcionProducto<Producto.getOtrosProductos().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Pro favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                while(cantidadProducto>1){
                                    if(producto.getNombre().equals(Producto.getOtrosProductos().get(opcionProducto).getNombre())){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    }
                                }
                            }
                        }
                    }
                    break;
            }

            System.out.println("Desea agregar mas productos ?");
            System.out.println("1. Si");
            System.out.println("2. No");
            while(opcionCiclo!=1 && opcionCiclo!=2){
                System.out.println("Por favor ingrese una opcion valida");
                opcionCiclo = sc.nextInt();
            }
            opcionCiclo = sc.nextInt();
        }

    }

    public static void realizarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al menu para realizar una Reserva");
        System.out.println("Es usted un cliente registrado?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = sc.nextInt();
        while(opcion != 1 && opcion!= 2){
        	
            System.out.println("Por favor ingrese una opcion valida");
            System.out.println("Es usted un cliente registrado?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = sc.nextInt();
        }
        Reserva reservaCreada = new Reserva();
        while (opcion == 1){
            System.out.println("Por favor ingrese su id");
            int idCliente = sc.nextInt();
            for (Cliente cliente:
                 Cliente.getClientes()) {
                if (cliente.getCodigo()==idCliente){
                    System.out.println("Bienvenido "+cliente.getNombre());
                    reservaCreada.setCliente(cliente);
                    //Reserva reservaCreada = new Reserva(cliente);
                    opcion = 0;
                }
                else if (cliente.equals(Cliente.getClientes().get(-1))) {
                    System.out.println("Usuario no encontrado por favor verifique el id");
                }
            }
        }

        while (opcion ==2){
            System.out.println("Por favor ingrese su nombre");
            String nombreCliente = sc.next();
            Cliente cliente = new Cliente(nombreCliente);
            reservaCreada.setCliente(cliente);
            System.out.println("Su registro a sido exitoso");
            opcion = 0;

        }

        System.out.println("Por favor escoja un sitio a reservar disponible");
        ArrayList<Espacio> espaciosDisponibles = Espacio.getListado();
        for (int i = 0; i < espaciosDisponibles.size(); i++) { // ciclo para mostrar los espacios disponibles
            System.out.println(i + ". " + espaciosDisponibles.get(i).getNombre());
        }
        System.out.println("Ingrese su opcion: ");
        List<Servicio> serviciosDisponibles = Arrays.asList(Servicio.values());
        opcion = sc.nextInt();

        while (opcion < 0 || opcion >= (espaciosDisponibles.size())) {
            System.out.println("Por favor ingrese una opcion valida: ");
            opcion = sc.nextInt();
        }

        Espacio espacioTomado = espaciosDisponibles.get(opcion); // seleciona el espacio deseado por el usuario


        System.out.println("A continuacion le presentamos la disponibildiad del espacio: ");

        LocalDate fechaTomada = espacioTomado.seleccionarFecha(10); // le muestra y permite selccionar al usuario uno de los 10 primeros dias disponibles para el espacio tomado

        System.out.println("Desea agregar servicios adicionales a la reserva? ");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        opcion = sc.nextInt();
        while(opcion != 1 && opcion != 2){
            System.out.println("Por favor ingrese una opcion valdia");
            opcion = sc.nextInt();
        }
         // Convierte el Array de Servicio a ArrayList de Servicio
        List<Servicio> serviciosTomados = new ArrayList<>();
        while (opcion ==1 && !serviciosDisponibles.isEmpty()){ // loop para mostrar los servicios a escoger por el cliente

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
            serviciosDisponibles.remove((Integer)opcionServicio); // se elimina de servicios disponibles ya que fue tomado previamente
            System.out.println("SERIVICIOS DISPONIBLES  ");
            System.out.println(serviciosDisponibles);
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
        Pedido pedidoReserva = new Pedido();
        agregarProductos(pedidoReserva); // se llama al metodo agregar productos
        reservaCreada.setPedido(pedidoReserva);
        reservaCreada.setFechaReserva(fechaTomada);
        reservaCreada.setServicios((ArrayList<Servicio>) serviciosTomados);


    }

    public static void modificarReserva(Reserva reserva){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que va a modificar ?");
        System.out.println("1. Modificar el espacio y la fecha.");
        System.out.println("2. Modificar la fecha de la reserva.");
        System.out.println("3. Modificar el pedido.");
        System.out.println("4. Salir y volver atras");
        int opcion = sc.nextInt();
        while (opcion<0 || opcion >4){
            System.out.println("Por favor ingrese una opcion valida");
            opcion = sc.nextInt();
        }
        while(opcion != 4){
            if (opcion == 1){
                System.out.println("A continuacion se le mostraran los espacios disponibles");
                reserva.getEspacio().reordenarFechas(reserva); // elimina la fecha previmente seleccionada y la vuelve a poner en orden en la lista de las fechas disponibles
                for (int i = 0; i < Espacio.getListado().size(); i++) {
                    System.out.println(i+". "+Espacio.getListado().get(i).getNombre());
                }
                System.out.println("Por favor ingrese una opcion");
                int opcionEspacio = sc.nextInt();
                while(opcionEspacio< 0 || opcionEspacio >= Espacio.getListado().size()){
                    System.out.println("Por favor ingrese una opcion valida");
                    opcionEspacio= sc.nextInt();
                }
                reserva.setEspacio(Espacio.getListado().get(opcionEspacio));
            }
            else if (opcion == 2){
                reserva.getEspacio().reordenarFechas(reserva); // elimina la fecha previmente seleccionada y la vuelve a poner en orden en la lista de las fechas disponibles
                System.out.println("A continuacion se mostraran las fechas disponibles para su espacio previamente seleccionado");
                LocalDate nuevaFecha = reserva.getEspacio().seleccionarFecha(10); // Se emplea el metodo para volver a seleccionar la fecha del espacio seleccionado
                reserva.setFechaReserva(nuevaFecha);

            }
            else if(opcion == 3){
                System.out.println("A continuacion podra modificar su pedido");
                agregarProductos(reserva.getPedido());
            }
            opcion = 4;
        }
    }

    public static void cancelarReserva(Reserva reserva){
        if (LocalDate.now().isAfter(reserva.getFechaReserva())){ //verifica que aun se pueda cancelar la reserva comparandolo con el dia actual
            reserva.setEstado("Cancelada");
            for (Producto producto: //ciclo para cambiar el estado a los prductos que estaban en el pedido asociado a la reserva
                    reserva.getPedido().getProductos()) {
                producto.setEstado("No vendido");
            }
        }
        else{
            System.out.println("Ha excedido la fecha limite para cancelar la reserva");
        }
        System.out.println(reserva.toString());
    }

    public static void main(String[] args) {
        Espacio sala1 = new Espacio("Sala 1");
        Espacio sala2 = new Espacio("Sala 2");
        Espacio sala3 = new Espacio("Sala 3");
        Espacio sala4 = new Espacio("Sala 4");
        Espacio sala5 = new Espacio("Sala 5");
        Espacio sala6 = new Espacio("Sala 6");
        Espacio sala7 = new Espacio("Sala 7");
        Espacio sala8 = new Espacio("Sala 8");
        Espacio sala9 = new Espacio("Sala 9");

        new Producto("coca cola 250ml", "No vendido", 1, 2, 2);
        new Producto("Sprite", "No vendido", 1, 2, 2);
        new Producto("H20", "No vendido", 1, 2, 2);
        new Producto("Bretana", "No vendido", 1, 2, 2);
        new Producto("coca cola 250ml", "No vendido", 1, 2, 2);
        new Producto("Swchepes", "No vendido", 1, 2, 2);
        new Producto("coca cola 250ml", "No vendido", 1, 2, 2);
        new Producto("Kola Roman", "No vendido", 1, 2, 2);
        new Producto("coca cola 250ml", "No vendido", 1, 2, 2);
        new Producto("Hit mango", "No vendido", 1, 2, 2);
        new Producto("Hit mora", "No vendido", 1, 2, 2);
        new Producto("Smirnoff ice 1L", "No vendido", 2, 5, 1);
        new Producto("Nuvo", "No vendido", 2, 5, 1);
        new Producto("Black and White", "No vendido", 2, 5, 1);
        new Producto("Smirnoff ice 1L", "No vendido", 2, 5, 1);
        new Producto("Something Special", "No vendido", 2, 5, 1);
        new Producto("Double Black", "No vendido", 2, 5, 1);
        new Producto("Red Label", "No vendido", 2, 5, 1);
        new Producto("Double Black", "No vendido", 2, 5, 1);
        new Producto("Red Label", "No vendido", 2, 5, 1);
        new Producto("Blue Label", "No vendido", 2, 5, 1);
        new Producto("Buchanan's", "No vendido", 2, 5, 1);
        new Producto("Arguardiente Antioqueno", "No vendido", 2, 5, 1);
        new Producto("Old par", "No vendido", 5, 10, 1);
        new Producto("Desgranado", "No vendido", 1, 2, 3);
        new Producto("hamburguesa", "No vendido", 1, 2, 3);
        new Producto("pizza", "No vendido", 1, 2, 3);
        new Producto("Salchipapa", "No vendido", 1, 2, 3);
        new Producto("Hot Dog", "No vendido", 1, 2, 3);
        new Producto("pizza", "No vendido", 1, 2, 3);
        new Producto("Lasagna", "No vendido", 1, 2, 3);
        new Producto("hamburguesa", "No vendido", 1, 2, 3);
        new Producto("pan", "No vendido", 1, 2, 3);
        new Producto("hamburguesa", "No vendido", 1, 2, 3);
        new Producto("ensalada", "No vendido", 1, 2, 3);
        new Producto("rosquitas", "No vendido", 1, 2, 4);
        new Producto("papitas", "No vendido", 1, 2, 4);
        new Producto("mani sal", "No vendido", 1, 2, 4);
        new Producto("almendras", "No vendido", 1, 2, 4);
        new Producto("crispetas", "No vendido", 1, 2, 4);
        new Producto("mani pasas", "No vendido", 1, 2, 4);
        new Producto("mani dulce", "No vendido", 1, 2, 4);
        new Producto("Manguito", "No vendido", 1, 2, 4);
        new Producto("Detodito", "No vendido", 1, 2, 4);
        new Producto("Malboro", "No vendido", 1, 2, 5);
        new Producto("boston", "No vendido", 1, 2, 5);
        new Producto("Piel Roja", "No vendido", 1, 2, 5);

        new Producto("belmont", "No vendido", 1, 2, 5);
        new Producto("Lucky Strike", "No vendido", 1, 2, 5);
        new Producto("Rumba", "No vendido", 1, 2, 5);
        new Producto("Lucky Strike", "No vendido", 1, 2, 5);
        new Producto("Star Lite", "No vendido", 1, 2, 5);
        new Producto("Shefield green", "No vendido", 1, 2, 5);
        new Producto("belmont", "No vendido", 1, 2, 5);
        new Producto("Red Bull", "No vendido", 1, 2, 6);
        new Producto("Sparta", "No vendido", 1, 2, 6);
        new Producto("Red Bull", "No vendido", 1, 2, 6);
        new Producto("Bang", "No vendido", 1, 2, 6);
        new Producto("Monster", "No vendido", 1, 2, 6);
        new Producto("Blue", "No vendido", 1, 2, 6);
        new Producto("RockStar", "No vendido", 1, 2, 6);
        new Producto("RockStar", "No vendido", 1, 2, 6);
        new Producto("RockStar", "No vendido", 1, 2, 6);
        new Producto("RockStar", "No vendido", 1, 2, 6);
        new Producto("Monster", "No vendido", 1, 2, 6);
        new Producto("vive 100", "No vendido", 1, 2, 6);
        new Producto("vive 100", "No vendido", 1, 2, 6);
        new Producto("vive 100", "No vendido", 1, 2, 6);
        new Producto("vive 100", "No vendido", 1, 2, 6);
        new Producto("speed max", "No vendido", 1, 2, 6);
        new Producto("speed max", "No vendido", 1, 2, 6);
        new Producto("speed max", "No vendido", 1, 2, 6);
        new Producto("speed max", "No vendido", 1, 2, 6);


        realizarReserva();
    }



}

