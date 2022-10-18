
package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.Cliente;
import gestorAplicacion.usuarios.Trabajador;

import java.time.LocalDate;
import java.util.*;


public class Pedido {

    //ATRIBUTOS DE INSTANCIA

    private Trabajador trabajador;
    private Cliente cliente;
    private String estadoPedido; // "Pagado", "No pagado"
    private ArrayList<Producto> productos = new ArrayList<>();//arraylist de productos pedidos por el cliente

    private ArrayList<Servicio> servicios =new ArrayList<>();//arraylist de servicios pedidos por el cliente
    private LocalDate fechaPedido;
    private long codigo; //cuando se cree, se cree con el mismo ID del cliente

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


    public String generarFactura(){

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
            productos += "\n" + i + ". " + clave + "...." + Collections.frequency(nombre, clave) + "......" + nombreYprecio.get(clave) * Collections.frequency(nombre, clave);
            i++;
        }

        productos += "\nTotal de producto:" + totalProductos;

        String servicios="Servicios:" +
                "\nNombre...........Cantidad.........Precio";
        int b=1;
        double totalServicios=0;
        SortedSet<Servicio> servicioNoRepetido=new TreeSet<>();
        for(Servicio servicio: this.getServicios()){
            servicios+="\n"+b+". "+servicio+" "+ Collections.frequency(this.getServicios(),servicio)+"....."+Collections.frequency(this.getServicios(),servicio)* servicio.getPrecio();
            totalServicios+=servicio.getPrecio();
            b++;
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
                "\nTotal:"+totalProductos+totalServicios+
                "\n======================================";
        return s;
    }
    public void pagarPedido(){
        this.setEstadoPedido("Pagado");
        for(Producto producto: this.getProductos()){
            producto.setEstado("Vendido");
        }
    }
    public void reservarPedido(){
        this.setEstadoPedido("No pagado");
        for(Producto producto: this.getProductos()){
            producto.setEstado("Reservado");
        }
    }



}
