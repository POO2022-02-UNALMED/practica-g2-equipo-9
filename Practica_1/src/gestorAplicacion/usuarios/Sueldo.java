package gestorAplicacion.usuarios;

public interface Sueldo {
    public final static double sueldoBase=100;
    public final static double porcentajeComision=0.2;

    public abstract double getSueldo();
    public abstract void setSueldo(double sueldo);
    public abstract void aumentarSueldo(double porcentaje);
    public abstract double calculoDePrima();
}
