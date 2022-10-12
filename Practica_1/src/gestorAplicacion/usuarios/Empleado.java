package gestorAplicacion.usuarios;

public abstract class Empleado extends Usuario{
    protected String cargo;
    protected int salario;
    protected boolean estadoIngreso;

    Empleado(long codigo, String nombre) {
        super(codigo, nombre);
    }
}
