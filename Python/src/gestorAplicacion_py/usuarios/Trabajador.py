from gestorAplicacion_py.usuarios.Empleado import Empleado
from gestorAplicacion_py.gestion.Producto import Producto

class Trabajador(Empleado):

    _trabajadores = []
    _numeroTrabajadores = 0

    def __init__(self, codigo,nombre,cargo,sueldo,fechaIngreso,saldoFinal,seguro=6):
        super().__init__(codigo,nombre,cargo,sueldo,fechaIngreso)
        self._saldoFinal = saldoFinal
        self._seguro = seguro
        # falta colocar generar codigo
        Empleado._empleados.append(self)
        Trabajador._trabajadores.append(self)
        
    def getSaldoFinal(self):
        return self._saldoFinal

    def setSaldoFinal(self,saldoFinal):
        self._saldoFinal = saldoFinal

    def getSeguro(self):
        return self._seguro

    def setSeguro(self,seguro):
        self._seguro = seguro

    def getTrabajadores(cls):
        return cls._trabajadores

    def setTrabajadores(cls,trabajadores):
        cls._trabajadores = trabajadores

    def getNumeroTrabajadores(cls):
        return cls._numeroTrabajadores

    def setNumeroTrabajadores(cls,trabajadores):
        cls._numeroTrabajadores = trabajadores
