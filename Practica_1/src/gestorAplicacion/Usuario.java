package gestorAplicacion;
import java.util.Date;

public abstract class Usuario {
    private long id;
    private boolean estadiIngreso;

    public abstract boolean ingresarAlPos();

}