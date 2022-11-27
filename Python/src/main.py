from gestorAplicacion_py.usuarios.Trabajador import Trabajador

from main_py.main import *
from datetime import datetime
def main():
    trabajador1=Trabajador(0,"sergio",datetime.today().strftime('%Y-%m-%d'))
    trabajador2=Trabajador(1,"valentina",datetime.today().strftime('%Y-%m-%d'))
    trabajador3=Trabajador(3,"Russbell",datetime.today().strftime('%Y-%m-%d'))
    print(trabajador1.getFechaVinculacion())
    print(trabajador2.getFechaVinculacion())
    print(trabajador3.getFechaVinculacion())
