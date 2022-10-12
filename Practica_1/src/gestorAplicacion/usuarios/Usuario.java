package gestorAplicacion.usuarios;

public abstract class Usuario {
    protected long codigo;
    protected String nombre;

    Usuario(long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}

