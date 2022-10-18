package gestorAplicacion.usuarios;

public interface Sueldo implements Serializable{
    public final static double sueldoBase=100;
    public final static double porcentajeComision=0.2;

    public abstract double getSueldo();
    public abstract void setSueldo(double sueldo);
    public abstract void aumentarSueldo(double porcentaje);
    public abstract double calculoDePrima();
   
    //SERIALIZACION
    try{
        ObjectOutputStream sueldos_datos = new ObjectOutputStream(new FileOutputStream("/sueldo.dat"));

        //DEVUELVE LOS DATOS
        sueldos_datos.writeObject(sueldo);
        
        sueldos_datos.close();
        
        ObjectInputStream sueldos_recuperar= new ObjectInputStream(new FileInputStream("/sueldo.dat"));
    }
    catch (Exception sueldo){
    }
}


