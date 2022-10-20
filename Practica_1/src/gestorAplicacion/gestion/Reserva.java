package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Reserva implements Serializable {
    //ATRIBUTOS DE INSTANCIA
    private int idReserva;
    private String estado; //"Exitosa", "No exitosa"
    private Cliente cliente;
    private ArrayList<Servicio> servicios;
    private LocalDate fechaReserva; // el dia de la ejecucion de la reserva
    private LocalDate fechaCreacion; // el dia que se creo la reserva
    private Pedido pedido;

    //ATRIBUTOS DE CLASE
    private static int numReservas = 0; // contador del numero de reservas


    //CONSTRUCTORES

    public Reserva(String estado, Cliente cliente, ArrayList<Servicio> servicios, LocalDate fechaReserva, LocalDate fechaCreacion, Pedido pedido) {
        this.idReserva = numReservas;
        this.estado = estado;
        this.cliente = cliente;
        this.servicios = servicios;
        this.fechaReserva = fechaReserva;
        this.fechaCreacion = fechaCreacion;
        this.pedido = pedido;
        numReservas++;
    }

    //GETTERS Y SETTERS


    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public static int getNumReservas() {
        return numReservas;
    }

    public static void setNumReservas(int numReservas) {
        Reserva.numReservas = numReservas;
    }
    
    
    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_reservas_datos = new FileInputStream("/usuario.dat");

            ObjectOutputStream reservas_datos = new ObjectOutputStream(archivo_reservas_datos);
    
            reservas_datos.writeObject(servicios);
    
            reservas_datos.close();

            archivo_reservas_datos.close();

            System.out.println("DATOS GUARDADOS");
        
        }
    
        catch (Exception s){
            System.out.println("ERROR");
        }
    }

    public void Load (){
        try{
            FileOutputStream archivo_reservas_recuperar = new FileInputStream("/usuario.dat");
        
            ObjectInputStream reservas_recuperar= new ObjectInputStream(archivo_reservas_recuperar);

            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Servicio[] reservas_recuperados=(Usuario[]) reservas_recuperar.readObject();
            
            reservas_recuperar.close();

            archivo_reservas_recuperar.close();

            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Usuario ss: reservas_recuperados){
                System.out.println(ss);
            }
            
            System.out.println("DATOS CARGADOS");
        }
        
        catch (Exception ss){
            System.out.println("ERROR");
        }

    }
   
}
