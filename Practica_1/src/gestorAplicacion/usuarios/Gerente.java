package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

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
    try{
        ObjectOutputStream gerentes_datos = new ObjectOutputStream(new FileOutputStream("/gerente.dat"));
    
        gerentes_datos.writeObject(gerentes);
    
        gerentes_datos.close();
    
        ObjectInputStream gerentes_recuperar= new ObjectInputStream(new FileInputStream("/gerente.dat"));
    
        //DEVUELVE LOS DATOS EN TIPO ARRAY
        Gerente[] gerentes_recuperados=(Gerente[]) gerentes_recuperar.readObject();
    
        gerentes_recuperar.close();
    
        //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
        for (Gerentes g: gerentes_recuperados){
            System.out.printIn(g);
        }
    }
    catch (Exception g){
    }



}
