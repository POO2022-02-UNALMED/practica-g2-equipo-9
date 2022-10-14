package gestorAplicacion.usuarios;

public abstract class Usuario {
    protected long codigo;
    protected String nombre;


    Usuario(long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //getters y setters

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

