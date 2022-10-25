package baseDatos;

import gestorAplicacion.gestion.*;
import gestorAplicacion.usuarios.*;

import java.io.*;
import java.util.List;

public class Serializador {
    /*
     * Serializamos una lista por el nombre de la clase
     * @param <E>       El generico se usa para poder agredar las clases que se crearon
     * @param lista     Una lista de objetos
     * @param className El nombre de la clase que queremos usar como nombre del archivo
     */
    public static <E> void serializar(List<E> lista, String className) {

        File archivo=new File("");
        try {
            String path = new File(archivo.getAbsolutePath()) + "/src/baseDatos/temp/" + className + ".txt";
            // Se crea un fileoutputstream para saber donde serializar los archivos
            FileOutputStream fileOut = new FileOutputStream(path);
            // Se crea un objeto output stream para poder escribir en el archivo
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Guardamos la lista de objetos
            out.writeObject(lista);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void serializarTodo() {
        Serializador.serializar(Espacio.getListado(),"Espacio");
        Serializador.serializar(Pedido.getPedidos(),"Pedido");
        Serializador.serializar(Producto.getProductos(),"Producto");
        Serializador.serializar(Reserva.getReservas(),"Reserva");
        Serializador.serializar(Cliente.getClientes(),"Cliente");
        Serializador.serializar(Empleado.getEmpleados(),"Empleado");
        Serializador.serializar(Gerente.getGerentes(),"Gerente");
        Serializador.serializar(Trabajador.getTrabajadores(),"Trabajador");
        Serializador.serializar(Usuario.getUsuarios(),"Usuario");
    }
}
