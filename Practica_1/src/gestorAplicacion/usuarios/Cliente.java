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


    //SERIALIZACION
    try{
        ObjectOutputStream clientes_datos = new ObjectOutputStream(new FileOutputStream("/cliente.dat"));
    
        clientes_datos.writeObject(clientes);
    
        clientes_datos.close();
    
        ObjectInputStream clientes_recuperar= new ObjectInputStream(new FileInputStream("/cliente.dat"));
    
        //DEVUELVE LOS DATOS EN TIPO ARRAY
        Cliente[] clientes_recuperados=(Cliente[]) clientes_recuperar.readObject();
    
        clientes_recuperar.close();
    
        //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
        for (Cliente c: clientes_recuperados){
            System.out.printIn(c);
        }
    }
    catch (Exception c){
    }

    //SERIALIZACION
    try{
        ObjectOutputStream pedidos_datos = new ObjectOutputStream(new FileOutputStream("/pedido.dat"));
    
        pedidos_datos.writeObject(pedidosCliente);
    
        pedidos_datos.close();
    
        ObjectInputStream pedidos_recuperar= new ObjectInputStream(new FileInputStream("/pedido.dat"));
    
        //DEVUELVE LOS DATOS EN TIPO ARRAY
        Pedido[] pedidos_recuperados=(Pedido[]) pedidos_recuperar.readObject();
    
        pedidos_recuperar.close();
    
        //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
        for (Pedido p: pedidos_recuperados){
            System.out.printIn(p);
        }
    }
    catch (Exception p){
    }
}
