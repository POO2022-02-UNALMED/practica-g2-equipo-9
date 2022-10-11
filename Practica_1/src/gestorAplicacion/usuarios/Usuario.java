package gestorAplicacion.usuarios;

public abstract class Usuario {
    private long id;
    private String nombre;
    private ArrayList <usuarios> usuarios = new ArrayList<>();

    public abstract void ingresarAlPos();


    
}
