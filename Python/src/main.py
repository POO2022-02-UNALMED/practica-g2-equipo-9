from gestorAplicacion_py.usuarios.Trabajador import Trabajador
from datetime import datetime
def main():
    trabajador1=Trabajador(0,"sergio",datetime.today().strftime('%Y-%m-%d'))
    trabajador2=Trabajador(1,"valentina",datetime.today().strftime('%Y-%m-%d'))
    
    print(trabajador1.getFechaVinculacion())
    print(trabajador2.getFechaVinculacion())
    print(datetime.now())

if __name__=="__main__":
    main()
    
