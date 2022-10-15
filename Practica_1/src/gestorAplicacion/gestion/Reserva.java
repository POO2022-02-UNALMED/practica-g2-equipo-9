package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    //ATRIBUTOS DE INSTANCIA
    private int idReserva;
    private String estado; //"Exitosa", "No exitosa"
    private Cliente cliente;
    private ArrayList<Servicio> serivicios;
    private LocalDate fechaReserva; // el dia de la ejecucion de la reserva
    private LocalDate fechaCreacion; // el dia que se creo la reserva
    private Pedido pedido;

    //ATRIBUTOS DE CLASE
    private static int numReservas = 0; // contador del numero de reservas


    //CONSTRUCTORES

    public Reserva(String estado, Cliente cliente, ArrayList<Servicio> serivicios, LocalDate fechaReserva, LocalDate fechaCreacion, Pedido pedido) {
        this.idReserva = numReservas;
        this.estado = estado;
        this.cliente = cliente;
        this.serivicios = serivicios;
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

    public ArrayList<Servicio> getSerivicios() {
        return serivicios;
    }

    public void setSerivicios(ArrayList<Servicio> serivicios) {
        this.serivicios = serivicios;
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
}
