package gestorAplicacion.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public abstract class Usuario implements Serializable {

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

    //SERIALIZACION
    public void Save() {
        try{
            ObjectOutputStream usuarios_datos = new ObjectOutputStream(new FileOutputStream("/usuario.dat"));
        
            usuarios_datos.writeObject(usuarios);
        
            usuarios_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception u){
            System.out.println("ERROR");
        }
    }
    
        public void Load (){
            try{
                ObjectInputStream usuarios_recuperar= new ObjectInputStream(new FileInputStream("/usuario.dat"));

                //DEVUELVE LOS DATOS EN TIPO ARRAY
                Usuario[] usuarios_recuperados=(Usuario[]) usuarios_recuperar.readObject();
                
                usuarios_recuperar.close();

                //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
                for (Usuario uu: usuarios_recuperados){
                    System.out.printIn(uu);
                }
                
                System.out.println("DATOS CARGADOS");
            }
            
            catch (Exception uu){
                System.out.println("ERROR");
            }

        }
}


