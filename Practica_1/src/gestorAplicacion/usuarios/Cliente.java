package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Pedido;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Usuario{

    //ATRIBUTOS DE INSTANCIA
    private int numeroReserva;
    private String estadoReserva;
    private ArrayList<Pedido> pedidosCliente = new ArrayList<>();//cliente tiene un array de pedidos, va pidiendo cosas y se van guardando aqui


    //ATRIBUTOS DE CLASE
    private static ArrayList<Cliente> clientes=new ArrayList<>();
    private static long numeroCliente=0;





    //CONSTRUCTOR

    public Cliente(long codigo, String nombre, int numeroReserva, String estadoReserva, ArrayList<Pedido> pedidosCliente) {
        super(generarCodigo(),nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
        this.pedidosCliente = pedidosCliente;
        clientes.add(this);

    }



    //metodos



    private static long generarCodigo(){

        return numeroCliente++;
    }



    public String solicitarReembolso(int id){
        return "algo";
    }
    public String solicitarReserva(){
        return "algo";
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public static long getNumeroCliente() {
        return numeroCliente;
    }

    public static void setNumeroCliente(long numeroCliente) {
        Cliente.numeroCliente = numeroCliente;
    }

    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    public void setPedidosCliente(ArrayList<Pedido> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Cliente.clientes = clientes;
    }




}
