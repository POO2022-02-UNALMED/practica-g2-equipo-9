package gestorAplicacion.gestion;


import java.util.*;

public enum Servicio {

public enum Servicio implements Serializable{

    BARMAN(200),  COCKTAILCHALLENGE(300),MESEROEXCLUSIVO(400), STRIPPER(500);

    private final float precio;
    private Servicio(float precio){
        this.precio=precio;
    }
    
    public float getPrecio() {
        return precio;
    }


    public static String serviciosOfrecidos() {//String que muestra servicios y sus precios
        String s = "Nombre de servicio....precio";
        int i = 1;
        for (Servicio servicio : Servicio.values()) {
            s += "\n" + i + "" + servicio + "...." + servicio.getPrecio();
            i++;
        }
        return s;

    }
    public static HashMap<Integer,Servicio> hashmapServicios(){ //devuelve un hashmap con el numero del servicio y su valor
        HashMap<Integer,Servicio> servicios=new HashMap<>();
        int i=1;
        for(Servicio servicio: Servicio.values()){
            servicios.put(i,servicio);
            i++;
        }
        return servicios;
    }

    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_servicios_datos = new FileInputStream("/servicio.dat");

            ObjectOutputStream servicios_datos = new ObjectOutputStream(archivo_servicios_datos);
    

            servicios_datos.writeObject(servicio);
            
            servicios_datos.close();

            archivo_servicios_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception servicio){
            System.out.println("ERROR");
        }
    }
    
    public void Load (){
        try{
            FileOutputStream archivo_servicios_recuperar = new FileInputStream("/servicio.dat");
            
            ObjectInputStream servicios_recuperar= new ObjectInputStream(archivo_servicios_recuperar);

            results= servicios_recuperar.readObject();

            servicios_recuperar.close();

            archivo_servicios_recuperar.close();

            //IMPRIME LOS DATOS
            System.out.println(results);
                
            System.out.println("DATOS CARGADOS");
        }
            
        catch (Exception servicioss){
            System.out.println("ERROR");
        }

    }

}
