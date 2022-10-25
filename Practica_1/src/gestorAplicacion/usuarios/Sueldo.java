package gestorAplicacion.usuarios;

import java.util.*;

/*
* Se agrupan metodos que utiliza la clase empleado para heredar a sus hijas
* Define algunas constantes aplicables para todos los empleados
* cada Hijo de empleado define de forma distinta los metodos aqui declarados
* */

public interface Sueldo {
    public final static double sueldoBase=100;
    public final static double porcentajeComisionProductos=0.2;
    public final static double porcentajeComisionServicios=0.1;
    public abstract double getSueldo();
    public abstract void setSueldo(double sueldo);
    public abstract void aumentarSueldo(double porcentaje);
    public abstract double calculoDePrima();



    


}


