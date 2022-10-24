package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Reserva {
    //ATRIBUTOS DE INSTANCIA
    private int idReserva;
    private String estado; //"Activa", "Cancelada", "Cumplida",  "Vencida"
    private Cliente cliente;
    private ArrayList<Servicio> servicios;
    private LocalDate fechaReserva; // el dia de la ejecucion de la reserva
    private LocalDate fechaCreacion; // el dia que se creo la reserva
    private Pedido pedido;

    private Espacio espacio;

    //ATRIBUTOS DE CLASE
    private static int numReservas = 0; // contador del numero de reservas
    private int pagoCancelacion=0;


    //CONSTRUCTORES


    public Reserva() {
        this.fechaCreacion = LocalDate.now();
        this.idReserva = numReservas;
        numReservas++;
    }

    public Reserva(Cliente cliente){
        this();
        this.cliente = cliente;
    }


    public Reserva(String estado, Cliente cliente, ArrayList<Servicio> servicios, LocalDate fechaReserva, Pedido pedido) {
        this(cliente); // sobrecarga de metodos
        this.idReserva = numReservas;
        this.estado = estado;
        this.servicios = servicios;
        this.fechaReserva = fechaReserva;
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


    public int getPagoCancelacion() {
        return pagoCancelacion;
    }

    public void setPagoCancelacion(int pagoCancelacion) {
        this.pagoCancelacion = pagoCancelacion;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public int calcularPrecioReserva(){ // metodo para calcular el total a pagar en la reserva
        int acumulado = 0;
        for (Servicio servicio: this.servicios // ciclo para sumar los precios de los servicios
        ) {
            acumulado+= servicio.getPrecio();
        }

        for (Producto producto: this.pedido.getProductos() //ciclo para sumar los precios de los productos añadidos a al pedido asociado a la reserva
        ) {
            acumulado+= producto.getPrecioVenta();
        }

        return acumulado; // retorna el acumulado de todo lo sumado anteriormente
    }

    @Override
    public String toString() { // metodo para realizar un resumen en la funcionalidadesdeReserva
        switch (this.getEstado()) {
            case "Activa":
                return "Reserva realizada con exito\n" + "El total de su reserva es de: " + this.calcularPrecioReserva() + "\n" +
                        "Su reserva es para el dia: " + this.getFechaReserva() + "\n" + "Y esta fue creada el dia: " + this.getFechaCreacion();
            case "Cancelada":
                return "Su reserva ha sido cancelada con exito\n" + "El valor a pagar por su cancelacion es de: " + this.pagoCancelacion;

            case "Cumplida":
                return "Esta reserva se ha culminado con exito el dia "+this.getFechaReserva();
        }
        return super.toString();
    }

    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_reservas_datos = new FileInputStream("/usuario.dat");

            ObjectOutputStream reservas_datos = new ObjectOutputStream(archivo_reservas_datos);
    
            reservas_datos.writeObject(servicios);
    
            reservas_datos.close();

            archivo_reservas_datos.close();
        
        }
    
        catch (Exception s){
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
                return ss;
            }
        }
        
        catch (Exception ss){
        }

    }
}
