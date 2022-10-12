package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Usuario{
    private int numeroReserva;
    private String estadoReserva;
    private static long numeroCliente=0;

    private ArrayList<Pedido> pedidosCliente = new ArrayList<Pedido>();//cliente tiene un array de pedidos, va pidiendo cosas y se van guardando aqui

    //constructor

    Cliente(String nombre) {
        super(generarCodigo(),nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;

    }
    //metodos
    public String Descripcion(){
        return "nombre: "+this.nombre+
                "\ncodigo: "+this.codigo;
    }
    private static long generarCodigo(){
        return numeroCliente++;
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

    public static void main(String[] args) {
        Producto producto1=new Producto("coca cola");
        Producto producto2=new Producto("Pepsi");

        Cliente  cliente1=new Cliente("Sergio");
        Pedido pedido1 =new Pedido();
        Pedido pedido2 =new Pedido();
        pedido1.ingresarProducto(producto2);
        pedido1.ingresarProducto(producto2);
        pedido1.ingresarProducto(producto1);
        pedido2.ingresarProducto(producto2);
        pedido2.ingresarProducto(producto1);
        cliente1.ingresarPedido(pedido1);
        cliente1.ingresarPedido(pedido2);



        System.out.println(cliente1.listaPedido());
    }

}
