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

}
