
package gestorAplicacion.gestion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import gestorAplicacion.usuarios.*;

/*
*Clase creada para representar los productos fisicos
*para cada unidad de cada producto se crea un objeto de tipo Producto
* Un pedido puede contener muchos productos
*
*/


public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;


    //ATRIBUTOS INSTANCIA
    private Trabajador trabajador;
    private Cliente cliente;
    private String estado; //agregue estado de producto, "Vendido", "No vendido", "Reservado"
    private String nombre;
    private double precioVenta;
    private long codigo;

    private LocalDate fechaVenta;

    private int tipo; //"1. Bebidas alcoholicas", "2. Bebidas no alcoholicas", "3. Comida", "4. Snacks", "5. Cigarrillos", "6. Energizantes", "7. Otros"

    //ATRIBUTOS DE CLASE

    private static ArrayList<Producto> productos = new ArrayList<>(); //ARRAYLIST DONDE SE GUARDAN TODOS LOS PRODUCTOS
    private static long numeroProducto = 0;

    private static ArrayList<Producto> bebidasAlcoholicas = new ArrayList<>(); // En esta lista va la primera instancia de un nuevo producto de tipo bebidasAlcoholicas, es decir no se puede repetir
    private static ArrayList<Producto> bebidasNoAlcoholicas = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo bebidasNoAlcoholicas, es decir no se puede repetir
    private static ArrayList<Producto> comidas = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo comidas, es decir no se puede repetir
    private static ArrayList<Producto> snacks = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo snacks, es decir no se puede repetir
    private static ArrayList<Producto> cigarrillos = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo cigarrillos, es decir no se puede repetir
    private static ArrayList<Producto> energizantes = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo energizantes, es decir no se puede repetir
    private static ArrayList<Producto> otrosProductos = new ArrayList<>();// En esta lista va la primera instancia de un nuevo producto de tipo otrosProductos, es decir no se puede repetir





    //CONSTRUCTOR


    public Producto() {
        Producto.numeroProducto++;
        this.codigo = Producto.numeroProducto;
        productos.add(this);
    }

    public Producto(String nombre, String estado, int precioVenta, int tipo){
        this();
        this.nombre = nombre;
        this.estado=estado;
        this.precioVenta = precioVenta;
        this.tipo = tipo;
        categorizarProducto(this);

    }

    public Producto(Trabajador trabajador, String estado, String nombre, int precioVenta, LocalDate fechaVenta) {
        this.trabajador = trabajador;
        this.estado = estado;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.codigo = generarCodigo();
        this.fechaVenta = fechaVenta;
        productos.add(this);

    }

    public Producto(Trabajador trabajador, Cliente cliente, String estado, String nombre, double precioVenta, LocalDate fechaVenta, int tipo) {
        Producto.numeroProducto++;
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.estado = estado;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.codigo = Producto.numeroProducto;
        this.fechaVenta = fechaVenta;
        this.tipo = tipo;
        productos.add(this);
        categorizarProducto(this);

    }

    public static long generarCodigo() {
        return numeroProducto++;
    }


    public String descripcionProducto() { //genera una pequeña descripcion del producto en cuestion
        return "\nNombre: " + this.getNombre() +
                "\nCodigo: " + this.getCodigo() +
                "\nPrecio venta: " + this.getPrecioVenta();
    }

    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public static long getNumeroProducto() {
        return numeroProducto;
    }

    public static void setNumeroProducto(long numeroProducto) {
        Producto.numeroProducto = numeroProducto;
    }


    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Producto.productos = productos;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static ArrayList<Producto> getBebidasAlcoholicas() {
        return bebidasAlcoholicas;
    }

    public static void setBebidasAlcoholicas(ArrayList<Producto> bebidasAlcoholicas) {
        Producto.bebidasAlcoholicas = bebidasAlcoholicas;
    }

    public static ArrayList<Producto> getBebidasNoAlcoholicas() {
        return bebidasNoAlcoholicas;
    }

    public static void setBebidasNoAlcoholicas(ArrayList<Producto> bebidasNoAlcoholicas) {
        Producto.bebidasNoAlcoholicas = bebidasNoAlcoholicas;
    }

    public static ArrayList<Producto> getComidas() {
        return comidas;
    }

    public static void setComidas(ArrayList<Producto> comidas) {
        Producto.comidas = comidas;
    }

    public static ArrayList<Producto> getSnacks() {
        return snacks;
    }

    public static void setSnacks(ArrayList<Producto> snacks) {
        Producto.snacks = snacks;
    }

    public static ArrayList<Producto> getCigarrillos() {
        return cigarrillos;
    }

    public static void setCigarrillos(ArrayList<Producto> cigarrillos) {
        Producto.cigarrillos = cigarrillos;
    }

    public static ArrayList<Producto> getEnergizantes() {
        return energizantes;
    }

    public static void setEnergizantes(ArrayList<Producto> energizantes) {
        Producto.energizantes = energizantes;
    }

    public static ArrayList<Producto> getOtrosProductos() {
        return otrosProductos;
    }

    public static void setOtrosProductos(ArrayList<Producto> otrosProductos) {
        Producto.otrosProductos = otrosProductos;
    }
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public static void categorizarProducto(Producto producto) { // Este metodo sirve para clasificar los productos segun su tipo y ponerlo en el ArrayList correpondiente si es que este no existe en dicho ArrayList
        switch (producto.tipo) {
            case 1:
                Producto.verificarExistenciaCategoria(Producto.bebidasAlcoholicas, producto);
                break;
            case 2:
                Producto.verificarExistenciaCategoria(Producto.bebidasNoAlcoholicas, producto);
                break;
            case 3:
                Producto.verificarExistenciaCategoria(Producto.comidas, producto);
                break;
            case 4:
                Producto.verificarExistenciaCategoria(Producto.snacks, producto);
                break;
            case 5:
                Producto.verificarExistenciaCategoria(Producto.cigarrillos, producto);
                break;
            case 6:
                Producto.verificarExistenciaCategoria(Producto.energizantes, producto);
                break;
            case 7:
                Producto.verificarExistenciaCategoria(Producto.otrosProductos, producto);
                break;
        }
    }

    public static void verificarExistenciaCategoria(ArrayList<Producto> lista, Producto producto) { //verifica si el producto ya estaba en el sistema en caso de que no lo agrega a la lista de su categoria correpondiente
        try {
            for (Producto value : lista) {
                if (value.getNombre().equals(producto.getNombre())) {
                    return;
                }
            }
            lista.add(producto);

        } catch (Exception e) {

        }

    }


    public static String mostrarProductosDisponibles(ArrayList<Producto> listaProducto) {//Muestra nombre, cantidad y precio de un array, pero ojo, este metodo no filtra por vendidos
        String s = "Este es el inventario de productos disponibles para vender:" +
                "\nNombre, Cantidad, Precio:";
        SortedSet<String> productosDisponiblesNoRepetidos = new TreeSet<>();
        ArrayList<String> productosDisponiblesRepetidos = new ArrayList<>();
        HashMap<String, Double> listaPrecios = new HashMap<>();
        for (Producto producto : listaProducto) {
            productosDisponiblesNoRepetidos.add(producto.getNombre());
            productosDisponiblesRepetidos.add(producto.getNombre());
            if (listaPrecios.containsKey(producto.getNombre()) == false) {
                listaPrecios.put(producto.getNombre(), producto.getPrecioVenta());
            }
        }
        int i = 1;
        for (String nombre : productosDisponiblesNoRepetidos) {
            s += "\n" + i + ". Nombre: " + nombre + ", Cantidad: " + Collections.frequency(productosDisponiblesRepetidos, nombre) + ", Precio: " + listaPrecios.get(nombre);
            i++;
        }
        return s;
    }

    public static String mostrarNombresCantidadPrecio(ArrayList<Producto> productosPedidos) { //muestra lista de productos con nombres cantidades y precios hasta el momento
        String s = "Pedido de Productos: " +
                "\nNombre, Cantidad, Precio:";
        SortedSet<String> nombresNoRepetidos = new TreeSet<>();
        ArrayList<String> nombresRepetidos = new ArrayList<>();
        HashMap<String, Double> listaPrecios = new HashMap<>();
        double valorTotal = 0;
        for (Producto producto : productosPedidos) {
            nombresNoRepetidos.add(producto.getNombre());
            nombresRepetidos.add(producto.getNombre());
            if (listaPrecios.containsKey(producto.getNombre()) == false) {
                listaPrecios.put(producto.getNombre(), producto.getPrecioVenta());
            }
            valorTotal += producto.getPrecioVenta();
        }
        int i = 1;
        for (String nombre : nombresNoRepetidos) {
            s += "\n" + i + ". Nombre: " + nombre + ", Cantidad: " + Collections.frequency(nombresRepetidos, nombre) + ", Precio: " + Collections.frequency(nombresRepetidos, nombre) * listaPrecios.get(nombre);
            i++;
        }
        s += "\nValor total de productos= " + valorTotal;
        return s;
    }

    public static ArrayList<Producto> productosDisponibles(ArrayList<Producto> Inventario) {//Devuelve un arraylist de productos con estado de producto no vendido y fecha null
        ArrayList<Producto> productosDisponibles = new ArrayList<>();
        for (Producto producto : Inventario) {
            if (producto.getEstado().equals("No vendido") && producto.getFechaVenta() == null) {
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
    }

    public static boolean verificarProducto(String nombre, ArrayList<Producto> listaProductos) {//verifica que nombre exista en la lista
        boolean existe = false;
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public static boolean verificarProducto(String nombre, long cantidad, ArrayList<Producto> listaProductos) {//verifica que nombre y cantidad exista en la lista
        boolean existe = false;
        ArrayList<String> nombresProducto = new ArrayList<>();
        for (Producto producto : listaProductos) {
            nombresProducto.add(producto.getNombre());
        }
        if (cantidad >= 0 && cantidad <= Collections.frequency(nombresProducto, nombre)) {
            existe = true;
        }
        return existe;
    }

    public static ArrayList<Producto> agregarProducto(String nombre, long cantidad, ArrayList<Producto> listaProductos) {//agrega elementos y devuelve un array
        ArrayList<Producto> productosEscogidos = new ArrayList<>();
        long contador = 0;
        for (Producto producto : listaProductos) {
            if (contador < cantidad) {
                if (producto.getNombre().equals(nombre)) {
                    productosEscogidos.add(producto);
                    contador++;
                }
            } else {
                break;
            }
        }
        return productosEscogidos;
    }



}




