package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Administracion;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Usuario{

    //ATRIBUTOS DE INSTANCIA
    private int numeroReserva;
    private String estadoReserva;
    private ArrayList<Pedido> pedidosCliente = new ArrayList<>();//cliente tiene un array de pedidos, va pidiendo cosas y se van guardando aqui

    private static long numeroCliente=0;


    //CONSTRUCTOR

    public Cliente(String nombre) {
        super(numeroCliente,nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
        Administracion.getClientes().add(this);
    }
    //metodos


    public String descripcionCliente(){
        return "\nNombre: "+this.nombre+
                "\nCodigo: "+this.codigo;
    }
    private static void generarCodigo(){
        numeroCliente++;
    }
    public void ingresarPedido(Pedido pedido){
        pedidosCliente.add(pedido);
    }

    public String listaPedido(){
        Iterator<Pedido> iterator = pedidosCliente.iterator();
        StringBuffer lista = new StringBuffer("Pedidos cliente: \n");
        while (iterator.hasNext()){
            Pedido pedido=(Pedido) iterator.next();
            lista.append(pedido.listaProductos()+"\n");
        }
        return lista.toString();
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
}
