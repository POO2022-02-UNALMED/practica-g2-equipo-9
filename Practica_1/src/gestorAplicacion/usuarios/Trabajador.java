
package gestorAplicacion.usuarios;

import gestorAplicacion.gestion.Informe;
import gestorAplicacion.gestion.Pedido;
import gestorAplicacion.gestion.Producto;

import java.util.ArrayList;

public class Trabajador extends Empleado {
    private int base;
    private int saldoFinal;
    
    private ArrayList<Pedido> ventasDia = new ArrayList<Pedido>();
    private ArrayList<Trabajador> listado = new ArrayList<Trabajador>(); //listado de objetos trabajdores
    
    
    //metodos
    @Override
    public void ingresarAlPos() {

    }
    public static Producto ingresarArticulo(String opcion){//yo creo que esto es mas como ingresar pedido
        
        Producto a = null;
        for(Producto i: Informe.getInventario()){
            if (i.getNombre().equals(opcion)){
                a=i;
                Informe.getInventario().remove(i);
                break;
            }
        }
        return a;
            
    }
    public void verificarProducto(){ //producto vencido?
        
    }
    }
 

    


