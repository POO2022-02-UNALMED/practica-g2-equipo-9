import Empleado
#from gestorAplicacion_py.gestion.Producto import Producto
from datetime import datetime

class Trabajador(Empleado.Empleado):

    _trabajadores = []
    _numeroTrabajadores = 0

    def __init__(self, codigo,nombre,cargo,sueldo,fechaIngreso,saldoFinal,seguro=6):
        super().__init__(codigo,nombre,"Trabajador",cargo,sueldo,fechaIngreso)
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

    @classmethod
    def getTrabajadores(cls):
        return cls._trabajadores

    @classmethod
    def setTrabajadores(cls,trabajadores):
        cls._trabajadores = trabajadores

    @classmethod
    def getNumeroTrabajadores(cls):
        return cls._numeroTrabajadores

    @classmethod
    def setNumeroTrabajadores(cls,trabajadores):
        cls._numeroTrabajadores = trabajadores


    def asegurar(self):
        s =Empleado.asegurar
        finVinculacion = self.getFechaIngres
        #preguntar como hacer eso

    def calcularPrima(self):
        return self.getSeguro*0.5

    @classmethod
    def generarCodigo(cls):
        return cls._numeroTrabajadores + 1
       

    #ese tostring hay q ver con que va

    
