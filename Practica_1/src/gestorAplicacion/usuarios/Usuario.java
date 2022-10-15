package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {

    //ATRIBUTOS DE INSTANCIA
    protected long codigo;
    protected String nombre;


    //ATRIBUTOS DE CLASE

    private static ArrayList<Usuario> usuarios=new ArrayList<>();

    Usuario(long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        usuarios.add(this);
    }

    //GETTERS Y SETTERS

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

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }

    //OTROS METODOS
    private static void generarCodigo() {}
}

