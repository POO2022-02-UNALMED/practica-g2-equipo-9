
package gestorAplicacion.gestion;

import gestorAplicacion.usuarios.pedido;
import gestorAplicacion.usuarios.Trabajador;

import java.time.LocalDate;
import java.util.*;


public class Pedido implements Serializable {

    //ATRIBUTOS DE INSTANCIA

    private Trabajador trabajador;
    private pedido pedido;
    private String estadoPedido; // "Pagado", "No pagado"
    private ArrayList<Producto> productos = new ArrayList<>();//arraylist de productos pedidos por el pedido

    private ArrayList<Servicio> servicios =new ArrayList<>();//arraylist de servicios pedidos por el pedido
    private LocalDate fechaPedido;
    private long codigo; //cuando se cree, se cree con el mismo ID del pedido

    //ATRIBUTOS DE CLASE

    private static ArrayList<Pedido> pedidos= new ArrayList<>();
    private static long numeroPedido=0;

    //CONSTRUCTOR


    public Pedido() {
    }

    public Pedido(pedido pedido, String estadoPedido, ArrayList<Producto> productos, ArrayList<Servicio> servicios, LocalDate fechaPedido, long codigo) {
        this.pedido = pedido;
        this.estadoPedido = estadoPedido; //CONSTRUCTOR PARA LA FUNCIONALIDAD realizarReserva
        this.productos = productos;
        this.servicios = servicios;
        this.fechaPedido = fechaPedido;
        this.codigo = codigo;
    }

    public Pedido(Trabajador trabajador, pedido pedido, String estadoPedido, ArrayList<Producto> productos, ArrayList<Servicio> servicios, LocalDate fechaPedido) {
        this.trabajador = trabajador;
        this.pedido = pedido;
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

    public pedido getpedido() {
        return pedido;
    }

    public void setpedido(pedido pedido) {
        this.pedido = pedido;
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
                "\nNombre pedido: "+this.getpedido().getNombre()+
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

    //SERIALIZACION
    public void Save() {
        try{
            FileOutputStream archivo_pedidos_datos = new FileInputStream("/pedido.dat");

            ObjectOutputStream pedidos_datos = new ObjectOutputStream(archivo_pedidos_datos);
        
            pedidos_datos.writeObject(pedidos);
        
            pedidos_datos.close();

            archivo_pedidos_datos.close();

            System.out.println("DATOS GUARDADOS");
        }
        
        catch (Exception p){
            System.out.println("ERROR");
        }
    }
    
    public void Load (){
        try{
            FileOutputStream archivo_pedidos_recuperar = new FileInputStream("/pedido.dat");
            
            ObjectInputStream pedidos_recuperar= new ObjectInputStream(archivo_pedidos_recuperar);

            //DEVUELVE LOS DATOS EN TIPO ARRAY
            Pedido[] pedidos_recuperados=(Pedido[]) pedidos_recuperar.readObject();
                
            pedidos_recuperar.close();

            archivo_pedidos_recuperar.close();

            //IMPRIME LOS DATOS DE FORMA INDIVIDUAL
            for (Pedido pp: pedidos_recuperados){
                System.out.println(pp);
            }
                
            System.out.println("DATOS CARGADOS");
        }
            
        catch (Exception pp){
            System.out.println("ERROR");
        }

    }

}
