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
        System.out.println("AGREGAR PRODUCTOS A LA RESERVA");
        System.out.println("============================================================\n");
        System.out.println("Ahora a agregar los productos que quiere en su reserva\n");
        System.out.println("Por favor ingrese 1 para ver las categorias de los productos: \n");
        Scanner sc = new Scanner(System.in);
        int opcionCiclo = sc.nextInt();
        while(opcionCiclo != 2){
            for (Producto producto:
                 pedidoReserva.getProductos()) {
                System.out.println(producto.descripcionProducto());

            }
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
                System.out.println("Por favor ingrese una opcion valida");
                opcion = sc.nextInt();
            }
            switch (opcion){
                case 1:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getBebidasAlcoholicas().get(i).getNombre()+" Precio: "+Producto.getBebidasAlcoholicas().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto");
                    System.out.println("Ingrese 5 para ver todos los productos de esta categoria");
                    int opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {

                                if(producto.getNombre().equals(Producto.getBebidasAlcoholicas().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }


                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getBebidasAlcoholicas().size(); i++) {
                            System.out.println(i+". "+Producto.getBebidasAlcoholicas().get(i).getNombre()+" Precio: "+Producto.getBebidasAlcoholicas().get(i).getPrecioVenta());
                        }
                        System.out.println("Ingrese el numero de producto");
                        opcionProducto=sc.nextInt();

                        if (opcionProducto<Producto.getBebidasAlcoholicas().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                    if(producto.getNombre().equals(Producto.getBebidasAlcoholicas().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                        if(cantidadProducto == 0){
                                            break;
                                        }
                                    }
                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
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
                            System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {
                                if(producto.getNombre().equals(Producto.getBebidasNoAlcoholicas().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }

                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
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
                                System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {

                                    if(producto.getNombre().equals(Producto.getBebidasNoAlcoholicas().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                        if(cantidadProducto == 0){
                                            break;
                                        }
                                    }

                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
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
                            System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {

                                if(producto.getNombre().equals(Producto.getComidas().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }

                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
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
                                System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {

                                    if(producto.getNombre().equals(Producto.getComidas().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                        if(cantidadProducto == 0){
                                            break;
                                        }
                                    }

                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
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
                            System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {

                                if(producto.getNombre().equals(Producto.getSnacks().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }

                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
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
                                System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {

                                    if(producto.getNombre().equals(Producto.getSnacks().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                        if(cantidadProducto == 0){
                                            break;
                                        }
                                    }

                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
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
                            System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {

                                if(producto.getNombre().equals(Producto.getCigarrillos().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }

                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
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

                                    if(producto.getNombre().equals(Producto.getCigarrillos().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                        if(cantidadProducto == 0){
                                            break;
                                        }
                                    }

                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
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
                            System.out.println("Por favor ingrese una cantidad entre 1 y 15");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {

                                if(producto.getNombre().equals(Producto.getEnergizantes().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }

                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getEnergizantes().size(); i++) {
                            System.out.println(i+". "+Producto.getEnergizantes().get(i).getNombre()+" Precio: "+Producto.getEnergizantes().get(i).getPrecioVenta());
                        }
                        System.out.println("Ingrese el numero de producto\n");
                        opcionProducto = sc.nextInt();
                        while(opcionProducto<0 || opcionProducto>=Producto.getEnergizantes().size()){
                            System.out.println("Por favor ingrese una opcion valida");
                            opcionProducto = sc.nextInt();
                        }
                        if (opcionProducto<Producto.getEnergizantes().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Por favor ingrese una cantidad entre y 15");
                                cantidadProducto = sc.nextInt();
                            }
                            for (Producto producto: Producto.getProductos()) {
                                    if(producto.getNombre().equals(Producto.getEnergizantes().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                        producto.setEstado("Reservado");
                                        pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                        --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente
                                        if (cantidadProducto == 0){
                                            break;
                                        }
                                    }

                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
                            }
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+". "+Producto.getOtrosProductos().get(i).getNombre()+" Precio: "+Producto.getOtrosProductos().get(i).getPrecioVenta());
                    }
                    System.out.println("Ingrese el numero de producto\n");
                    System.out.println("Ingrese 5 para ver todos los prodductos de esta categoria");
                    opcionProducto = sc.nextInt();
                    while(opcionProducto<0 || opcionProducto>5){
                        System.out.println("Por favor ingrese una opcion valida");
                        opcionProducto = sc.nextInt();
                    }
                    if (opcionProducto<=4){
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = sc.nextInt();
                        while(cantidadProducto < 1){
                            System.out.println("Por favor ingrese una cantidad mayor o igual a 1");
                            cantidadProducto = sc.nextInt();
                        }
                        for (Producto producto: Producto.getProductos()) {

                                if(producto.getNombre().equals(Producto.getOtrosProductos().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto == 0){
                                        break;
                                    }
                                }

                        }
                        if(cantidadProducto !=0  ){
                            System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                        }
                        else{
                            System.out.println("Productos agregados con exito! \n");
                        }

                    }
                    if(opcionProducto == 5){
                        for (int i = 0; i < Producto.getOtrosProductos().size(); i++) {
                            System.out.println(i+". "+Producto.getOtrosProductos().get(i).getNombre()+" Precio: "+Producto.getOtrosProductos().get(i).getPrecioVenta());
                        }
                        System.out.println("Ingrese el numero de producto\n");
                        opcionProducto = sc.nextInt();
                        while(opcionProducto<0 || opcionProducto>Producto.getOtrosProductos().size()){
                            System.out.println("Por favor ingrese una opcion valida");
                            opcionProducto = sc.nextInt();
                        }
                        if (opcionProducto<Producto.getOtrosProductos().size()){
                            System.out.println("Por favor ingrese la cantidad");
                            int cantidadProducto = sc.nextInt();
                            while(cantidadProducto < 1){
                                System.out.println("Por favor ingrese una cantidad entre 1 y 20");
                                cantidadProducto = sc.nextInt();
                            }

                            for (Producto producto: Producto.getProductos()) {
                                if(producto.getNombre().equals(Producto.getOtrosProductos().get(opcionProducto).getNombre()) && producto.getEstado().equals("No vendido")){
                                    producto.setEstado("Reservado");
                                    pedidoReserva.getProductos().add(producto); // se agrega al ArrayList de los productos el producto seleccionad
                                    --cantidadProducto; // Cuando se agrega un producto se va restando a cantidadProducto para que se agregue exactaente la cantidad requerida por el cliente;
                                    if(cantidadProducto ==0){
                                        break;
                                    }
                                }

                            }
                            if(cantidadProducto !=0  ){
                                System.out.println("Hiceron falta por agregar "+ cantidadProducto+" debido a falta de unidades disponibles");
                            }
                            else{
                                System.out.println("Productos agregados con exito! \n");
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
            System.out.println(cliente.toString());
            opcion = 0;

        }

        System.out.println("Por favor escoja un sitio a reservar disponible");
        ArrayList<Espacio> espaciosDisponibles = Espacio.getListado();
        for (int i = 0; i < espaciosDisponibles.size(); i++) { // ciclo para mostrar los espacios disponibles
            System.out.println(i + ". " + espaciosDisponibles.get(i).getNombre());
        }
        System.out.println("Ingrese su opcion: ");

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
        //List<Servicio> serviciosDisponibles = Arrays.asList(Servicio.values());
        ArrayList<Servicio> serviciosDisponibles = new ArrayList<>();
        for (Servicio servicio:
             Servicio.values()) {
            serviciosDisponibles.add(servicio);
        }
        ArrayList<Servicio> serviciosTomados = new ArrayList<>();
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
            serviciosDisponibles.remove(opcionServicio); // se elimina de servicios disponibles ya que fue tomado previamente

            if (!serviciosDisponibles.isEmpty()){
                System.out.println("Desea agregar mas servicios ?");
                System.out.println("1. Si");
                System.out.println("2. No");
                opcionServicio = sc.nextInt();
                while(opcionServicio != 1 && opcionServicio != 2){
                    System.out.println("Por favor ingrese una opcion valdia");
                    opcionServicio = sc.nextInt();
                }
            }
            else{
                System.out.println("Usted ya ha seleccionado todos los servicios disponibles");
            }
            opcion = opcionServicio;
        } // el ciclo se termina por peticion del usuario o porque ya selecciono todos los servicios disponibles

        //PRODUCTOS A AGREGAR EN LA RESERVA Y SU CANTIDAD
        Pedido pedidoReserva = new Pedido();
        agregarProductos(pedidoReserva); // se llama al metodo agregar productos
        reservaCreada.setEspacio(espacioTomado);
        reservaCreada.setPedido(pedidoReserva);
        reservaCreada.setFechaReserva(fechaTomada);
        reservaCreada.setServicios(serviciosTomados);
        reservaCreada.setEstado("Activa");
        reservaCreada.getCliente().setReserva(reservaCreada);
        System.out.println(reservaCreada.toString());

    }

    public static void modificarReserva(Reserva reserva){
        Scanner sc = new Scanner(System.in);
        System.out.println("MODIFICAR RESERVA");
        System.out.println("============================================================\n");
        System.out.println("BIENVENIDO "+reserva.getCliente().getNombre()+"\n");
        System.out.println("Que desea modificar? \n");
        System.out.println("1. Modificar el espacio y la fecha.");
        System.out.println("2. Modificar la fecha de la reserva.");
        System.out.println("3. Modificar el pedido.");
        System.out.println("4. Salir y volver atras\n");
        int opcion = sc.nextInt();
        while (opcion<0 || opcion >4){
            System.out.println("Por favor ingrese una opcion valida\n");
            opcion = sc.nextInt();
        }
        while(opcion != 4){
            if (opcion == 1){
                System.out.println("============================================================\n");
                System.out.println("A continuacion se le mostraran los espacios disponibles\n");
                reserva.getEspacio().reordenarFechas(reserva); // elimina la fecha previmente seleccionada y la vuelve a poner en orden en la lista de las fechas disponibles
                for (int i = 0; i < Espacio.getListado().size(); i++) {
                    System.out.println(i+". "+Espacio.getListado().get(i).getNombre());
                }
                System.out.println("Por favor ingrese una opcion");
                int opcionEspacio = sc.nextInt();
                while(opcionEspacio< 0 || opcionEspacio >= Espacio.getListado().size()){
                    System.out.println("Por favor ingrese una opcion valida\n");
                    opcionEspacio= sc.nextInt();
                }
                Espacio espacioTomado =  Espacio.getListado().get(opcionEspacio);
                System.out.println("A continuacion le presentamos la disponibildiad del espacio: \n");


                LocalDate fechaTomada =  espacioTomado.seleccionarFecha(10);
                reserva.setFechaReserva(fechaTomada);
                reserva.setEspacio(espacioTomado);
                System.out.println("Su reserva se ha modificado con exito!\n");
                System.out.println(reserva.toString());

            }
            else if (opcion == 2){
                reserva.getEspacio().reordenarFechas(reserva); // elimina la fecha previmente seleccionada y la vuelve a poner en orden en la lista de las fechas disponibles
                System.out.println("A continuacion se mostraran las fechas disponibles para su espacio previamente seleccionado\n");
                LocalDate nuevaFecha = reserva.getEspacio().seleccionarFecha(10); // Se emplea el metodo para volver a seleccionar la fecha del espacio seleccionado
                reserva.setFechaReserva(nuevaFecha);
                System.out.println("Su reserva se ha modificado con exito!\n");
                System.out.println(reserva.toString());

            }
            else if(opcion == 3){

                System.out.println("Usted desea ....\n");
                System.out.println("1. Crear un pedido desde cero");
                System.out.println("2. Añadir productos al pedido existente");

                int opcionModPedido = sc.nextInt();
                while(opcionModPedido!=1 && opcionModPedido!=2){
                    System.out.println("Por favor ingrese una opcion valida");
                    opcionModPedido=sc.nextInt();
                }
                if(opcionModPedido == 1){
                    for (Producto producto: //ciclo para cambiar el estado a los productos que estaban en el pedido asociado a la reserva
                            reserva.getPedido().getProductos()) {
                        producto.setEstado("No vendido");
                    }
                    reserva.getPedido().setProductos(new ArrayList<Producto>());
                    System.out.println("============================================================\n");
                    agregarProductos(reserva.getPedido());
                    System.out.println("Su reserva se ha modificado con exito!\n");
                    System.out.println(reserva.toString());
                }
                else{
                    System.out.println("============================================================\n");
                    System.out.println("A continuacion podra modificar su pedido\n");
                    agregarProductos(reserva.getPedido());
                    System.out.println("Su reserva se ha modificado con exito!\n");
                    System.out.println(reserva.toString());
                }
            }
            opcion = 4;
        }
    }

    public static void cancelarReserva(Reserva reserva){
        System.out.println("CANCELACION DE RESERVA");
        System.out.println("============================================================\n");
        System.out.println("BIENVENIDO "+reserva.getCliente().getNombre()+"\n");
        if (LocalDate.now().isBefore(reserva.getFechaReserva())){ //verifica que aun se pueda cancelar la reserva comparandolo con el dia actual
            reserva.setEstado("Cancelada");
            for (Producto producto: //ciclo para cambiar el estado a los prductos que estaban en el pedido asociado a la reserva
                    reserva.getPedido().getProductos()) {
                producto.setEstado("No vendido");
            }
        }
        else{
            reserva.setEstado("Cancelada");
            System.out.println("Ha excedido la fecha limite para cancelar la reserva\n");
            reserva.setPagoCancelacion(100);
        }
        System.out.println(reserva.toString());
    }

    public static void modificarCancelarReserva(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("MODIFICAR O CANCELAR RESERVA");
        System.out.println("============================================================\n");


        System.out.println("Usted desea...\n");
        System.out.println("1. Modificar una reserva");
        System.out.println("2. Cancelar una reserva\n");
        opcion = sc.nextInt();
        while(opcion != 1 && opcion!=2){
            System.out.println("Por favor ingrese una opcion valida");
            opcion = sc.nextInt();
        }
        if (opcion == 1) {
            System.out.println("Por favor ingrese su id \n");
            int id = sc.nextInt();

            for (Cliente cliente:
                    Cliente.getClientes()) {
                if(cliente.getCodigo()==id){
                    modificarReserva(cliente.getReserva()); ;
                    return;
                }
            }
        }
        else if (opcion == 2) {
            System.out.println("Por favor ingrese su id \n");
            int id = sc.nextInt();

            for (Cliente cliente:
                    Cliente.getClientes()) {
                if(cliente.getCodigo()==id){

                    cancelarReserva(cliente.getReserva()); ;
                    return;
                }
            }
        }
    }

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
        realizarReserva();
        modificarCancelarReserva();


    }



}

