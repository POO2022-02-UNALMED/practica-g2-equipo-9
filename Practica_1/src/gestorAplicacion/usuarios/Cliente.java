package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Reserva;

import java.util.ArrayList;

import java.util.*;

public class Cliente extends Usuario {

    //ATRIBUTOS DE INSTANCIA
    private int numeroReserva;
    private String estadoReserva;
    private Reserva reserva;
    private Pedido pedido;//Pedido de cliente


    //ATRIBUTOS DE CLASE
    private static ArrayList<Cliente> clientes=new ArrayList<>();

    private ArrayList<Pedido> historialPedidos = new ArrayList<Pedido>();
    private static long numeroCliente=0;




    //CONSTRUCTOR

    public Cliente(String nombre){
        super(generarCodigo(), nombre);
        clientes.add(this);
    }

    public Cliente(){
        super(-1, "N/A");
    }

    public  Cliente(String nombre, int numeroReserva, String estadoReserva, Pedido pedido, ArrayList<Pedido> historialPedidos) {
        this(nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
        this.pedido = pedido;
        this.historialPedidos = historialPedidos;
        clientes.add(this);}

    public Cliente(String nombre, int numeroReserva, String estadoReserva, Pedido pedido) {
        this(nombre); // sobrecarga de metodos
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
        this.pedido = pedido;

    }



    //OTROS METODOS

    private static long generarCodigo(){
        numeroCliente++;
        return numeroCliente;
    }

    public static String mostrarClientesRegistrados(){ //Muestra todos los clientes con pedidos "No pagado"
        String s="";
        int i =1;
        for (Cliente cliente: Cliente.getClientes()){
            s+="\n"+i+". Codigo de cliente: "+cliente.getCodigo()+", Nombre: "+cliente.getNombre();
            i++;
        }
        return s;
    }
    public static Cliente seleccionarCliente(long codigo){//Escoge un cliente por el codigo unico que tiene asignado
        Cliente clienteSeleccionado=null;
        for (Cliente cliente: Cliente.getClientes()){
            if(cliente.getCodigo()==codigo){
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public void setHistorialPedidos(ArrayList<Pedido> historialPedidos) {
        this.historialPedidos = historialPedidos;
    }

    public String informacion() {
        return "El cliente " + this.nombre + " con número de reserva " + this.numeroReserva+ " y estado de la reserva "
                + this.estadoReserva + "Ha hecho "
                + this.historialPedidos.size() + " pedidos en el sistema.";
    }

    public void agregarPedidoHistorial(Pedido pedido) {
        historialPedidos.add(pedido);
    }

    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_clientes_datos = new FileInputStream("/cliente.dat");

            ObjectOutputStream clientes_datos = new ObjectOutputStream(archivo_clientes_datos);
        
            clientes_datos.writeObject(clientes);
        
            clientes_datos.close();

            archivo_clientes_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception c){
            System.out.println("ERROR");
        }
    }
    
    public void Load (){
        try{
            FileOutputStream archivo_clientes_recuperar = new FileInputStream("/cliente.dat");
            
            ObjectInputStream clientes_recuperar= new ObjectInputStream(archivo_clientes_recuperar);

            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Cliente[] clientes_recuperados=(Cliente[]) clientes_recuperar.readObject();
                
            clientes_recuperar.close();

            archivo_clientes_recuperar.close();

            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Cliente cc: clientes_recuperados){
                System.out.println(cc);
            }
                
            System.out.println("DATOS CARGADOS");
        }
            
        catch (Exception cc){
            System.out.println("ERROR");
        }

    }




}
