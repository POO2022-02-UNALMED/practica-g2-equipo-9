package gestorAplicacion.usuarios;

public class Gerente extends Empleado{


    public void generarInformeVentas(){}
    public void generarInformeTrabajador(){}
    public void generarInventario(){}
    public void registrarTrabajador(){}

    
    @Override
    public boolean ingresarAlPos() {
        return false;
    }
}
