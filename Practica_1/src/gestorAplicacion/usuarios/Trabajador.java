
package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Producto;

import java.util.ArrayList;

public class Trabajador extends Empleado {
    private int base;
    private int saldoFinal;

    private ArrayList<Cliente> ventasDia = new ArrayList<>();//listado de objetos cliente, es decir guarda los clientes con sus respectivos pedidos
    private ArrayList<Trabajador> listado = new ArrayList<>(); //listado de objetos trabajdores

    Trabajador(long codigo, String nombre) {
        super(codigo, nombre);
    }


    //metodos

    public void ingresarArticulo(Producto producto){//yo creo que esto es mas como ingresar pedido

            
    }
    //
    public void verificarProducto(){ //producto vencido?
        
    }
    }
 

    


