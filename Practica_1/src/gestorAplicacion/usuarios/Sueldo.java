package gestorAplicacion.usuarios;

public interface Sueldo {
    public final static double sueldo=100;
    public abstract double getSueldo();
    public abstract void setSueldo(double sueldo);
    public abstract void aumentarSueldo(double porcentaje);
    public abstract double primaComision();
}
