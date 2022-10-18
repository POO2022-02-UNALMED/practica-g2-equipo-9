package gestorAplicacion.gestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public enum Servicio {
    BARMAN(200),  COCKTAILCHALLENGE(300),MESEROEXCLUSIVO(400), STRIPPER(500);

    private final float precio;
    private Servicio(float precio){
        this.precio=precio;
    }

    public float getPrecio() {
        return precio;
    }

    public static String mostrarServicios(ArrayList<Servicio> servicios){
        String s="Servicios:" +
                "\nNombre...........Cantidad.........Precio";
        int i=1;
        SortedSet<Servicio>servicioNoRepetido=new TreeSet<>();
        for(Servicio servicio: servicios){
            s+="\n"+i+". "+servicio+" "+ Collections.frequency(servicios,servicio)+"....."+Collections.frequency(servicios,servicio)* servicio.getPrecio();
        }
        return s;
    }
}
