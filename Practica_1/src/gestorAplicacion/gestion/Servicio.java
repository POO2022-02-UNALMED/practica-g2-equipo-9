package gestorAplicacion.gestion;

public enum Servicio implements Serializable{
    BARMAN(200),  COCKTAILCHALLENGE(300),MESEROEXCLUSIVO(400), STRIPPER(500);

    private final float precio;
    private Servicio(float precio){
        this.precio=precio;
    }

    public float getPrecio() {
        return precio;
    }

    //SERIALIZACION
    try{
        ObjectOutputStream servicios_datos = new ObjectOutputStream(new FileOutputStream("/servicio.dat"));
        
        servicio_datos.writeObject(precio);
        
        servicio_datos.close();
        
        ObjectInputStream servicio_recuperar= new ObjectInputStream(new FileInputStream("/servicio.dat"));
        
        //DEVUELVE LOS DATOS 
        servicio_datos.writeObject(precio);
        
        ventas_recuperar.close();
    }
    catch (Exception precio){
    }
}
