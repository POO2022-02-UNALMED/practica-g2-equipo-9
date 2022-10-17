package gestorAplicacion.gestion;

public enum Servicio {
    BARMAN(200),  COCKTAILCHALLENGE(300),MESEROEXCLUSIVO(400), STRIPPER(500);

    private final float precio;
    private Servicio(float precio){
        this.precio=precio;
    }

    public float getPrecio() {
        return precio;
    }
}
