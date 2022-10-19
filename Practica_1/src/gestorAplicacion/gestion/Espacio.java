package gestorAplicacion.gestion;

import java.time.LocalDate;
import java.util.ArrayList;


public class Espacio implements Serializable {
    //ATRIBUTOS DE INSTANCIA
    private String nombre;

    private ArrayList<LocalDate> fechas = new ArrayList(); // fechas disponibles para un espacio
    // ATRIBUTOS DE CLASE
    private static ArrayList<Espacio> listado = new ArrayList<>();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Espacio> getListado() {
        return listado;
    }

    public static void setListado(ArrayList<Espacio> listado) {
        Espacio.listado = listado;
    }

    public ArrayList<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<LocalDate> fechas) {
        this.fechas = fechas;
    }

    //SERIALIZACION
    try{
        ObjectOutputStream espacios_datos = new ObjectOutputStream(new FileOutputStream("/espacio.dat"));
    
        espacios_datos.writeObject(listado);
    
        espacios_datos.close();
    
        ObjectInputStream espacios_recuperar= new ObjectInputStream(new FileInputStream("/espacio.dat"));
    
        //DEVUELVE LOS DATOS EN TIPO ARRAY
        Espacio[] espacios_recuperados=(Espacio[]) espacios_recuperar.readObject();
    
        espacios_recuperar.close();
    
        //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
        for (Espacio s: espacios_recuperados){
            System.out.printIn(s);
        }
    }
    catch (Exception s){
    }

}
