package gestorAplicacion.usuarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public abstract class Usuario  implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATRIBUTOS DE INSTANCIA
    protected long codigo;
    protected String nombre;


    //ATRIBUTOS DE CLASE

    private static ArrayList<Usuario> usuarios=new ArrayList<>();

    Usuario(){

    }

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

    @Override
    public String toString() {
        return "Objeto de tipo Usuario\n"+"Nombre: "+this.nombre+"\n"+"Codio de usuario: "+this.codigo;
    }
}


