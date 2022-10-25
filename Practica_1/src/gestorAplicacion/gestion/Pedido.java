
package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Gerente;
import gestorAplicacion.usuarios.Trabajador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
/*
* Clase creada para almacenar los prodcutos deseados por el cliente
* Tambien puede contener servicios
* El pedido esta asociado tanto a trabajador como al cliente
* */


public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    //ATRIBUTOS DE INSTANCIA

    private Trabajador trabajador;
    private Cliente cliente;
    private String estadoPedido; // "Pagado", "No pagado"
    private ArrayList<Producto> productos = new ArrayList<>();//arraylist de productos pedidos por el cliente

    private ArrayList<Servicio> servicios =new ArrayList<>();//arraylist de servicios pedidos por el cliente
    private LocalDate fechaPedido;
    private long codigo; //cuando se cree, se cree con el mismo ID del cliente

    private static int totalPedidos = 0;

    //ATRIBUTOS DE CLASE

    private static ArrayList<Pedido> pedidos= new ArrayList<>();
    private static long numeroPedido=0;

    //CONSTRUCTOR


    public Pedido() {
    }

    public Pedido(Cliente cliente, String estadoPedido, ArrayList<Producto> productos, ArrayList<Servicio> servicios, LocalDate fechaPedido, long codigo) {
        this.cliente = cliente;
        this.estadoPedido = estadoPedido; //CONSTRUCTOR PARA LA FUNCIONALIDAD realizarReserva
        this.productos = productos;
        this.servicios = servicios;
        this.fechaPedido = fechaPedido;
        this.codigo = codigo;
        pedidos.add(this);
    }

    public Pedido(Trabajador trabajador, Cliente cliente, String estadoPedido, ArrayList<Producto> productos, ArrayList<Servicio> servicios, LocalDate fechaPedido) {
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.estadoPedido = estadoPedido;
        this.productos = productos;
        this.servicios = servicios;
        this.fechaPedido = fechaPedido;
        this.codigo = generarCodigo();
        pedidos.add(this);
        Pedido.totalPedidos += 1;
    }

    //GETTERS Y SETTERS


    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Pedido.pedidos = pedidos;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public static int getTotalPedidos() {
        return pedidos.size();
    }

    public static void setTotalPedidos(int totalPedidos) {
        Pedido.totalPedidos = totalPedidos;
    }


    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int id) {
        this.codigo = codigo;
    }

    public static long getNumeroPedido() {
        return numeroPedido;
    }

    public static void setNumeroPedido(long numeroPedido) {
        Pedido.numeroPedido = numeroPedido;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    //OTROS METODOS
    public long generarCodigo(){
        return numeroPedido++;
    }



    public String generarFactura(){ //genera la factura del pedido realizado
        String productos ="Productos: " +
                "\nNombre........Cantidad.......Precio";
        HashMap<String, Double> nombreYprecio = new HashMap<>();
        double totalProductos = 0;
        ArrayList<String> nombre = new ArrayList<>();
        for (Producto producto : this.getProductos()) {
            if (nombreYprecio.containsKey(producto.getNombre()) == false) {
                nombreYprecio.put(producto.getNombre(), producto.getPrecioVenta());
            }
            nombre.add(producto.getNombre());
            totalProductos += producto.getPrecioVenta();
        }
        long i = 1;
        for (String clave : nombreYprecio.keySet()) {
            productos += "\n" + i + ". Nombre: " + clave + ", Cantidad pedida: " + Collections.frequency(nombre, clave) + "......" + "Precio: "+nombreYprecio.get(clave) * Collections.frequency(nombre, clave);
            i++;
        }

        productos += "\nTotal de producto:" + totalProductos;

        String servicios="Servicios:" +
                "\nNombre...........Cantidad.........Precio";
        int b=1;
        double totalServicios=0;
        SortedSet<Servicio> servicioNoRepetido=new TreeSet<>();
        for(Servicio servicio: this.getServicios()){
            if(servicioNoRepetido.contains(servicio)==false){
                servicios+="\n"+b+". Servicio: "+servicio+", Cantidad: "+ Collections.frequency(this.getServicios(),servicio)+"....."+"Precio: "+Collections.frequency(this.getServicios(),servicio)* servicio.getPrecio();
                b++;
            }
            totalServicios+=servicio.getPrecio();
            servicioNoRepetido.add(servicio);

        }
        servicios += "\nTotal de servicios:" + totalServicios;


        String s="";
        s+= "\n=============FACTURA DEL PEDIDO============="+
                "\nFactura # "+this.getCodigo()+
                "\nFecha: "+this.getFechaPedido()+
                "\nNombre cliente: "+this.getCliente().getNombre()+
                "\nVendido por "+this.getTrabajador().getNombre()+" con codigo "+this.getTrabajador().getCodigo()+
                "\n"+productos+
                "\n"+servicios+
                "\nTotal:"+ (totalProductos+totalServicios)+
                "\n===========================================";
        return s;
    }

    public double sumaProductos(){ // calcula el precio del total de los productos pedidos
        double sumaTotal=0;
        for (Producto producto: this.getProductos()){
            sumaTotal+=producto.getPrecioVenta();
        }
        return sumaTotal;
    }
    public double sumaServicios(){ // calcula el precio del total de los servicios pedidos
        double sumaTotal=0;
        for (Servicio servicio: this.getServicios()){
            sumaTotal+=servicio.getPrecio();
        }
        return sumaTotal;
    }
    public static String mostraPedidos(){ // Muestra los pedidos no pagados
        String s="";
        long i=1;
        for(Pedido pedido: Pedido.getPedidos()){
            if(pedido.getEstadoPedido().equals("No pagado")){
                double productos=pedido.sumaProductos();
                double servicios=pedido.sumaServicios();
                s+="\n"+"Codigo de pedido: "+pedido.getCodigo()+", Cliente: "+ pedido.getCliente().getNombre()+", Valor total: "+(productos+servicios);
                i++;
            }
        }
        return s;
    }
    public static Pedido seleccionarPedido(long codigo){ // ingresa el codigo del pedido y retorna el objeto pedido correspondiente
        Pedido pedido1=null;
        for(Pedido pedido: Pedido.getPedidos()){
            if(pedido.getCodigo()==codigo){
                pedido1=pedido;
                break;
            }
        }
        return pedido1;
    }

}
