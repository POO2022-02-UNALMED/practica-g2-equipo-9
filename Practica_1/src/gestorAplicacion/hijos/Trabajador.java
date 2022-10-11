
package gestorAplicacion.hijos;

import gestorAplicacion.hijos.Producto;
import gestorAplicacion.hijos.Pedido;
import gestorAplicacion.hijos.Informe;
import gestorAplicacion.padres.Empleado;
import java.util.ArrayList;

public class Trabajador extends Empleado {
    private int base;
    private int saldoFinal;
    
    private ArrayList<Pedido> ventasDia = new ArrayList<Pedido>();
    private ArrayList<Trabajador> listado = new ArrayList<Trabajador>(); //listado de objetos trabajdores
    
    
    //metodos
    @Override
    public boolean ingresarAlPos() {
        return false;
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
 

    


