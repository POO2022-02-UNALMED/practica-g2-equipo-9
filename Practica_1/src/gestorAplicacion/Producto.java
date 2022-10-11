
package gestorAplicacion;
public class Producto {
    private int fechaVencimiento;
    private String nombre;
    private int precioCompra;
    private int precioVenta;
    private long codigo;
    private int fechaIngreso;
    private int fechaVenta;
    
    //constructor
    
    public Producto(int fechaVencimiento, String nombre, int precioCompra, int precioVenta, long codigo, int fechaIngreso) {
        this.fechaVencimiento = fechaVencimiento;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.codigo = codigo;
        this.fechaIngreso = fechaIngreso;
        
        Informe.getInventario().add(this);
        
    }
    
         //getters y setters

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
    
}
