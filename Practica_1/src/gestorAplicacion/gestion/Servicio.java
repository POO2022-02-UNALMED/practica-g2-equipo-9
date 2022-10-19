package gestorAplicacion.gestion;

import java.util.*;

public enum Servicio {
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

}
