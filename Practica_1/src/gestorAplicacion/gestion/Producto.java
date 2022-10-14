
package gestorAplicacion.gestion;

public class Producto {
    //ATRIBUTOS INSTANCIA
    private String nombre;
    private int precioCompra;
    private int precioVenta;
    private long codigo;
    private int fechaVencimiento;
    private int fechaIngreso;
    private int fechaVenta;
    private int disponibles;
    private int reservados;

    //ATRIBUTOS DE CLASE
    private static long numeroProducto=0;
    
    //CONSTRUCTOR
    public Producto (String nombre, int precioVenta){
        this.codigo=generarCodigo();
        this.nombre=nombre;
        this.precioVenta=precioVenta;
        Administracion.getInventario().add(this);
    }
    public static long generarCodigo(){
        return numeroProducto++;
    }


    public String descripcionProducto(){
        return "\nNombre: "+this.getNombre()+
                "\nCodigo: "+this.getCodigo()+
                "\nPrecio venta: "+this.getPrecioVenta();
    }
    
         //GETTERS Y SETTERS

    public int getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(int fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(int fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getReservados() {
        return reservados;
    }

    public void setReservados(int reservados) {
        this.reservados = reservados;
    }

    public static long getNumeroProducto() {
        return numeroProducto;
    }

    public static void setNumeroProducto(long numeroProducto) {
        Producto.numeroProducto = numeroProducto;
    }
}
