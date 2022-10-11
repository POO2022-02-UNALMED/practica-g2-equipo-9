package gestorAplicacion;

public abstract class Empleado extends Usuario{
    private String nombre;
    private String cargo;
    private int salario;
    private boolean estadoIngreso;
    
    
    public abstract boolean ingresarAlPos();


}
