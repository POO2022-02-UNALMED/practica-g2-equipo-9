package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Gerente extends Empleado implements Sueldo, Serializable{

    //ATRIBUTOS DE INSTANCIA

    private final int seguro= 1;

    //ATRIBUTOS DE CLASE
    private static long numeroGerente=0;
    private static ArrayList<Gerente>gerentes=new ArrayList<>();


    //CONSTRUCTOR

    public Gerente(String nombre, boolean estadoIngreso, LocalDate fechaIngreso) {
        super(generarCodigo(), nombre, "Gerente", Sueldo.sueldoBase*2, estadoIngreso, fechaIngreso);
        gerentes.add(this);
    }

   /* // SOBRE CARGA DEL CONSTRUCTOR.
    //  No toma parámetros y llama al constructor usando valores predeterminados.
    public Gerente() {
        this("NN", false, null);
    }*/


    //OTROS METODOS
    public static long generarCodigo(){
        return numeroGerente++;
    }

    public String toString(){
        return "Codigo: "+this.getCodigo()+", Nombre: "+super.getNombre()+ ", Fecha de vinculacion: "+super.getFechaVinculacion();
    }


    //METODOS ABSTRACTOS
    public String asegurar() {
        LocalDate vinculacion= super.getFechaVinculacion();
        LocalDate finVinculacion= super.getFechaVinculacion().plusYears(this.getSeguro());

        if(LocalDate.now().isAfter(finVinculacion)){
            return "Gerente "+this.getNombre()+" "+" con codigo "+this.getCodigo()+", tiene vencido el seguro, este vencio en la fecha "+finVinculacion;
        }
        else{
            return "Gerente "+ this.getNombre()+" con codigo "+this.getCodigo()+", lo cubre el seguro desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion;
        }

    }
    public double calculoDePrima() {
        return this.getSueldo()*0.6;
    }
    //GETTERS Y SETTERS


    public int getSeguro() {
        return seguro;
    }

    public static long getNumeroGerente() {
        return numeroGerente;
    }

    public static void setNumeroGerente(long numeroGerente) {
        Gerente.numeroGerente = numeroGerente;
    }

    public static ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public static void setGerentes(ArrayList<Gerente> gerentes) {
        Gerente.gerentes = gerentes;
    }

    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_gerentes_datos = new FileInputStream("/gerente.dat");

            ObjectOutputStream gerentes_datos = new ObjectOutputStream(archivo_gerentes_datos);
        
            gerentes_datos.writeObject(gerentes));
        
            gerentes_datos.close();7

            archivo_gerentes_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception g){
            System.out.println("ERROR");
        }
    }
    
    public void Load (){
        try{
            FileOutputStream archivo_gerentes_recuperar = new FileInputStream("/gerente.dat");
            
            ObjectInputStream gerentes_recuperar= new ObjectInputStream(archivo_gerentes_recuperar);

            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Gerente[] gerentes_recuperados=(Gerente[]) gerentes_recuperar.readObject();
            
            gerentes_recuperar.close();
            
            archivo_gerentes_recuperar.close();

            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Gerentes gg: gerentes_recuperados){
                System.out.printIn(gg);
            }
                
            System.out.println("DATOS CARGADOS");
        }
            
        catch (Exception gg){
            System.out.println("ERROR");
        }

    }

}
