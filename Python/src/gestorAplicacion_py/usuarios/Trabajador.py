from usuarios.Empleado import Empleado
from gestion.Producto import Producto

class Trabajador(Empleado):
    def __init__(self, saldoFinal, seguro):
        super().__init__()