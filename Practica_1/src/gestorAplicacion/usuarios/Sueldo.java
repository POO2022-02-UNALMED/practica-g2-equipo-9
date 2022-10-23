package gestorAplicacion.usuarios;

import java.util.*;

public interface Sueldo implements Serializable{
    public final static double sueldoBase=100;
    public final static double porcentajeComisionProductos=0.2;
    public final static double porcentajeComisionServicios=0.1;
    public abstract double getSueldo();
    public abstract void setSueldo(double sueldo);
    public abstract void aumentarSueldo(double porcentaje);
    public abstract double calculoDePrima();



   
    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_sueldos_datos = new FileInputStream("/sueldo.dat");

            ObjectOutputStream sueldos_datos = new ObjectOutputStream(archivo_sueldos_datos);
    

            sueldos_datos.writeObject(sueldo);
            
            sueldos_datos.close();

            archivo_sueldos_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception sueldo){
            System.out.println("ERROR");
        }
    }
    
    public void Load (){
        try{
            FileOutputStream archivo_sueldos_recuperar = new FileInputStream("/sueldo.dat");
            
            ObjectInputStream sueldos_recuperar= new ObjectInputStream(archivo_sueldos_recuperar);

            results= sueldos_recuperar.readObject();

            sueldos_recuperar.close();

            archivo_sueldos_recuperar.close();

            //IMPRIME LOS DATOS
            System.out.println(results);
                
            System.out.println("DATOS CARGADOS");
        }
            
        catch (Exception sueldoss){
            System.out.println("ERROR");
        }

    }

}


