package gestorAplicacion.usuarios;


import gestorAplicacion.gestion.Pedido;

import java.util.ArrayList;

public class Cliente extends Usuario{
    private int numeroReserva;
    private String estadoReserva;
    private static long numeroCliente=0;

    private ArrayList<Pedido> ventasDia = new ArrayList<Pedido>();//cliente tiene un array de pedidos, va pidiendo cosas y se van guardando aqui

    //constructor

    Cliente(String nombre) {
        super(generarCodigo(),nombre);
        this.numeroReserva = numeroReserva;
        this.estadoReserva = estadoReserva;
    }
    public String Descripcion(){
        return "nombre: "+this.nombre+
                "\ncodigo: "+this.codigo;
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

    public static void main(String[] args) {
        Cliente cliente1=new Cliente("sergio");
        Cliente cliente2=new Cliente("kelly");
        System.out.println(cliente1.Descripcion());
        System.out.println(cliente2.Descripcion());

    }

}
