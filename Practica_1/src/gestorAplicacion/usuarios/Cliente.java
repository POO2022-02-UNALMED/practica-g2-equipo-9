package gestorAplicacion.usuarios;

public class Cliente extends Usuario{
 
    private int numeroReserva;
    
    //metodos
    public String solicitarReembolso(int id){
        return "algo";
    }
    public String solicitarReserva(){
        return "algo";
    }


    @Override
    public void ingresarAlPos() {

    }

    public static void main(

            String[] args) {System.out.println("hola");//hola soy sergio

    }
}
