package baseDatos;

import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.*;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializador {
    public static <E> void deserializador(List<E> list, String className) {
        FileInputStream fileIn;
        File archivo1=new File("");
        try {
            // Creamos una cadena con la ruta del archivo que vamos a cargar
            String path = new File(archivo1.getAbsolutePath()) + "/Practica_1/src/baseDatos/temp/" + className + ".txt";
            System.out.println(path);
            // Utilizamos un file para crear este archivo si no existe aun
            File archivo = new File(path);
            archivo.createNewFile(); // Crea un nuevo archivo si no existe

            // Usamos un FileInputStream para poder saber de donde cargar el archivo
            fileIn = new FileInputStream(path);

            // Si el archivo esta vacio se lanza un throw EOFException y se muestra como un mensaje de vacio, pero si no se usa el objeto in para leer el archivo
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Lee el listado de elementos
            ArrayList<E> listado = (ArrayList<E>) in.readObject();

            // Recorro el ArrayList
            for (E el : listado) {
                list.add(el);
            }

            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Esta vacio");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void deserializarTodo() {
        Deserializador.deserializador(Espacio.getListado(),"Espacio");
        Deserializador.deserializador(Pedido.getPedidos(),"Pedido");
        Deserializador.deserializador(Producto.getProductos(),"Producto");
        Deserializador.deserializador(Reserva.getReservas(),"Reserva");
        Deserializador.deserializador(Cliente.getClientes(),"Cliente");
        Deserializador.deserializador(Empleado.getEmpleados(),"Empleado");
        Deserializador.deserializador(Gerente.getGerentes(),"Gerente");
        Deserializador.deserializador(Trabajador.getTrabajadores(),"Trabajador");
        Deserializador.deserializador(Usuario.getUsuarios(),"Usuario");
    }
}
