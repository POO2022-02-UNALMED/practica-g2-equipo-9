package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends Empleado{

    //ATRIBUTOS DE INSTANCIA

    private final int seguro= 1;

    //ATRIBUTOS DE CLASE
    private static long numeroGerente=0;
    private static ArrayList<Gerente>gerentes=new ArrayList<>();


    //CONSTRUCTOR

    public Gerente(long codigo, String nombre, String cargo, Double sueldo, boolean estadoIngreso, Double comision, LocalDate fechaCreacion, LocalDate fechaIngreso) {
        super(generarCodigo(), nombre, cargo, sueldo, estadoIngreso, fechaCreacion, fechaIngreso);
        gerentes.add(this);
    }

    //OTROS METODOS
    public static long generarCodigo(){
        return numeroGerente++;
    }

    //METODOS ABSTRACTOS
    public String asegurar(){
        return "algo";
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
}
