package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Pedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class Cliente extends Usuario {

    //ATRIBUTOS DE INSTANCIA
    private int numeroReserva;
    private String estadoReserva;
    private Pedido pedido;//Pedido de cliente


    //ATRIBUTOS DE CLASE
    private static ArrayList<Cliente> clientes=new ArrayList<>();

    private ArrayList<Pedido> historialPedidos = new ArrayList<Pedido>();
    private static long numeroCliente=0;





    //CONSTRUCTOR

    public Cliente(String nombre, int numeroReserva, String estadoReserva, Pedido pedido, ArrayList<Pedido> historialPedidos) {
        super(generarCodigo(), nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
        this.pedido = pedido;
        this.historialPedidos = historialPedidos;
        clientes.add(this);
    }



    //OTROS METODOS

    private static long generarCodigo(){

        return numeroCliente++;
    }

    public static String mostrarClientes(){ //Muestra todos los clientes con pedidos "No pagado"
        String s="";
        int i =1;
        for (Cliente cliente: Cliente.getClientes()){
            if (cliente.pedido.getEstadoPedido().equals("No pagado")){
                s+="\n"+i+". Codigo de cliente: "+cliente.getCodigo()+" Nombre: "+cliente.getNombre();
                i++;
            }
        }
        return s;
    }

    public static Cliente seleccionarCliente(long codigo){//Escoge un cliente por el codigo unico que tiene asignado
        Cliente clienteSeleccionado=null;
        for (Cliente cliente: Cliente.getClientes()){
            if(cliente.getCodigo()==codigo && cliente.getPedido().getEstadoPedido().equals("No pagado")){
                clienteSeleccionado=cliente;
                break;
            }
        }
        return clienteSeleccionado;
    }

    //GETTER Y SETTERS

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

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Cliente.clientes = clientes;
    }

    public Pedido getPedido() {
        return pedido;
    }


    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String informacion() {
        return "El cliente " + this.nombre + " con número de reserva " + this.numeroReserva+ " y estado de la reserva "
                + this.estadoReserva + "Ha hecho "
                + this.historialPedidos.size() + " pedidos en el sistema.";
    }

    public void agregarPedidoHistorial(Pedido pedido) {
        historialPedidos.add(pedido);
    }



}
