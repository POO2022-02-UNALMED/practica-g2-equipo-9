package gestorAplicacion.gestion;


import java.io.Serializable;
import java.util.*;

/*
* Aqui estan presentes los servicios disponibles ofrecidos en la discoteca
* */

public enum Servicio {

    BARMAN(200),  COCKTAILCHALLENGE(300),MESEROEXCLUSIVO(400), STRIPPER(500);

    private final float precio;
    private Servicio(float precio){
        this.precio=precio;
    }

    public float getPrecio() {
        return precio;
    }


    public static String motrarNombreCantidadPrecio(ArrayList<Servicio> serviciosPedidos){//muestra nombre cantidad precio y valor total de los servicios pedidos
        String s="Pedido de servicios:" +
                "\nNombre, Cantidad, Precio";
        SortedSet<Servicio> nombresNoRepetidos = new TreeSet<>();
        double valorTotal=0;
        for(Servicio servicio: serviciosPedidos){
            nombresNoRepetidos.add(servicio);
            valorTotal+=servicio.getPrecio();
        }
        int i=1;
        for(Servicio servicio: nombresNoRepetidos){
            s+="\n"+i+". Nombre: "+servicio+", cantidad: "+Collections.frequency(serviciosPedidos,servicio)+", Precio: "+Collections.frequency(serviciosPedidos,servicio)*servicio.getPrecio();
            i++;
        }
        s+="\nValor total de servicios: "+valorTotal;
        return s;
    }
    public static String serviciosOfrecidos() {//String que muestra servicios y sus precios
        String s = "Numero de servicio, Nombre de servicio, Precio:";
        int i = 1;
        for (Servicio servicio : Servicio.values()) {
            s += "\nNumero de servicio: " + i + " , Nombre: " + servicio + ", Precio: " + servicio.getPrecio();
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

    public static ArrayList<Servicio> agregarServicios(int numeroServicio,long cantidadEscogida, HashMap<Integer,Servicio> servicios){
        ArrayList<Servicio> a=new ArrayList<>();
        for(long i=0;i<cantidadEscogida;i++){
            a.add(servicios.get(numeroServicio));
        }
        return a;
    }

    public static boolean verificarServicio(Servicio servicio, ArrayList<Servicio> serviciosPedidos){//Verficicar que el servicio este en la lista de servicios
        boolean existe=false;
        if(serviciosPedidos.contains(servicio)){
            existe=true;
        }
        return existe;
    }
    public static boolean verificarServicio(Servicio servicio, long cantidadEscogida, ArrayList<Servicio> serviciosPedidos){//Verificar que la cantidad del servicio, exista en la lista de servicios pedidos
        boolean existe=false;
        if(cantidadEscogida>=0 && cantidadEscogida<=Collections.frequency(serviciosPedidos,servicio)){
            existe=true;
        }
        return existe;
    }


}
