
package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Producto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trabajador extends Empleado implements Sueldo, Serializable{

    //ATRIBUTOS DE INSTANCIA
    private int saldoFinal;
    private final int seguro = 6;

    private ArrayList<Cliente> ventasDia = new ArrayList<>();//listado de objetos cliente, es decir guarda los clientes con sus respectivos pedidos


    //ATRIBUTOS DE CLASE
    private static long numeroTrabajador = 0;
    private static ArrayList<Trabajador> trabajadores = new ArrayList<>();


    //CONSTRUCTOR

    public Trabajador(String nombre, boolean estadoIngreso, LocalDate fechaIngreso, int saldoFinal, ArrayList<Cliente> ventasDia) {
        super(generarCodigo(), nombre,"trabajador", Sueldo.sueldoBase, estadoIngreso, fechaIngreso);
        this.saldoFinal = saldoFinal;
        this.ventasDia = ventasDia;
        trabajadores.add(this);
    }






    //GETTERS Y SETTERS

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public int getSeguro() {
        return seguro;
    }

    public ArrayList<Cliente> getVentasDia() {
        return ventasDia;
    }

    public void setVentasDia(ArrayList<Cliente> ventasDia) {
        this.ventasDia = ventasDia;
    }

    public static long getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public static void setNumeroTrabajador(long numeroTrabajador) {
        Trabajador.numeroTrabajador = numeroTrabajador;
    }



    public static ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public static void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        Trabajador.trabajadores = trabajadores;
    }

    //METODOS ABSTRACTOS
    public String asegurar() {
        LocalDate vinculacion= super.getFechaVinculacion();
        LocalDate finVinculacion= super.getFechaVinculacion().plusMonths(this.getSeguro());

        if(LocalDate.now().isAfter(finVinculacion)){
            return "Trabajador "+this.getNombre()+" "+" con codigo "+this.getCodigo()+" tiene vencido el seguro, este vencio en la fecha "+finVinculacion;
        }
        else{
            return "Trabajador "+ this.getNombre()+" con codigo "+this.getCodigo()+" el seguro lo cubre desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion;
        }

    }


    //OTROS METODOS
    public static long generarCodigo() {
        return numeroTrabajador++;
    }

    public String toString(){
        return "Codigo: "+this.getCodigo()+", Nombre: "+super.getNombre()+ ", Fecha de vinculacion: "+super.getFechaVinculacion();
    }

    public static String mostrarTrabajadores(){ //Muestra todos los trabajadores
        String s="";
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            s+="\n"+trabajador;
        }
        return s;
    }
    public static Trabajador seleccionarTrabajador(long codigo){//Escoge un trabajador por el codigo unico que tiene asignado
        Trabajador trabajadorSeleccionado=null;
        for (Trabajador trabajador: Trabajador.getTrabajadores()){
            if(trabajador.getCodigo()==codigo){
                trabajadorSeleccionado=trabajador;
                break;
            }
        }
        return trabajadorSeleccionado;
    }


    //SERIALIZACION
    try{
        ObjectOutputStream trabajadores_datos = new ObjectOutputStream(new FileOutputStream("/trabajador.dat"));
    
        trabajadores_datos.writeObject(trabajadores);
    
        trabajadores_datos.close();
    
        ObjectInputStream trabajadores_recuperar= new ObjectInputStream(new FileInputStream("/trabajador.dat"));
    
        //DEVUELVE LOS DATOS EN TIPO ARRAY
        Trabajador[] trabajadores_recuperados=(Trabajador[]) trabajadores_recuperar.readObject();
    
        trabajadores_recuperar.close();
    
        //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
        for (Trabajador t: trabajadores_recuperados){
            System.out.printIn(t);
        }
    }
    catch (Exception t){
    }

//SERIALIZACION
        try{
            ObjectOutputStream ventas_datos = new ObjectOutputStream(new FileOutputStream("/ventas.dat"));
        
            ventas_datos.writeObject(ventasDia);
        
            ventas_datos.close();
        
            ObjectInputStream ventas_recuperar= new ObjectInputStream(new FileInputStream("/ventas.dat"));
        
            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Cliente[] ventas_recuperados=(Cliente[]) ventas_recuperar.readObject();
        
            ventas_recuperar.close();
        
            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Cliente v: ventas_recuperados){
                System.out.printIn(v);
            }
        }
        catch (Exception v){
        }

}
 

    


