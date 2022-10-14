package gestorAplicacion.usuarios;

public class Gerente extends Empleado{

    private final int seguro= 1;
    private static long numeroGerente=0;
    Gerente(long codigo, String nombre) {
        super(codigo, nombre);
    }
    public static void generarInformeVentas(){

    }

    //OTROS METODOS
    public static void generarCodigo(){
        numeroGerente++;
    }

    //METODOS ABSTRACTOS
    public String asegurar(){
        return "algo";
    }




    

}
