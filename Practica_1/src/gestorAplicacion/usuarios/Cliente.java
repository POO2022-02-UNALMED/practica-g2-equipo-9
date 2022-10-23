package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Pedido;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Usuario {

    //ATRIBUTOS DE INSTANCIA
    private int numeroReserva;
    private String estadoReserva;
    private Pedido pedido;//Pedido de cliente
    private ArrayList<Pedido> pedidos=new ArrayList<>();

    //ATRIBUTOS DE CLASE
    private static ArrayList<Cliente> clientes=new ArrayList<>();
    private static long numeroCliente=0;





    //CONSTRUCTOR

    public Cliente() {
        super(0, "N/A");
    }

    public Cliente(String nombre, int numeroReserva, String estadoReserva, Pedido pedido) {
        super(generarCodigo(), nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
        this.pedido = pedido;
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




}
