package gestorAplicacion.gestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;


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
    public void Save() {
        try{
            FileOutputStream archivo_espacios_datos = new FileInputStream("/espacio.dat");
            
            ObjectOutputStream espacios_datos = new ObjectOutputStream(archivo_espacios_datos);
            
            espacios_datos.writeObject(listado);
        
            espacios_datos.close();
            
            archivo_espacios_datos.close();
            
            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception es){
            System.out.println("ERROR");
        }
    }

    public void Load (){
        try{
            FileOutputStream archivo_espacios_recuperar = new FileInputStream("/espacio.dat");
        
            ObjectInputStream espacios_recuperar= new ObjectInputStream(archivo_espacios_recuperar);

            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Espacio[] espacios_recuperados=(Espacio[]) espacios_recuperar.readObject();
            
            espacios_recuperar.close();

            archivo_espacios_recuperar.close();

            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Espacio ess: espacios_recuperados){
                System.out.println(ess);
            }
            
            System.out.println("DATOS CARGADOS");
        }
        
        catch (Exception ess){
            System.out.println("ERROR");
        }

    }

}
