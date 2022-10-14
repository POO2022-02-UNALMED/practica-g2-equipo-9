package gestorAplicacion.usuarios;

import java.util.ArrayList;

public abstract class Empleado extends Usuario{
    //ATRIBUTOS DE INSTANCIA
    protected String cargo;
    protected int salario;
    protected boolean estadoIngreso;

    //ATRIBUTOS DE CLASE

    private static ArrayList<Empleado> empleados= new ArrayList<>();
    //CONSTRUCTOR
    Empleado(long codigo, String nombre) {
        super(codigo, nombre);
        empleados.add(this);
    }


    //METODOS ABSTRACTOS
    public abstract String asegurar();


}
