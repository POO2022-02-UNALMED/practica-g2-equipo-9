
from Python.src.gestorAplicacion_py.usuarios.Empleado import Empleado
from Python.src.gestorAplicacion_py.usuarios.Sueldo import Sueldo


class Gerente(Empleado,Sueldo):

    _numeroGerente=0
    _Gerentes = []

    _seguro=12
    def __init__(self, codigo, nombre, cargo, sueldo, fechaIngreso):
        super().__init__(fechaIngreso,codigo,nombre,"Gerente",Sueldo.sueldoBase*0.5)



    #preguntar por lo del genetrador de codigo


    #ToString
    def __str__(self):
        return "Codigo: ", self.getCodigo(), " Nombre ", self.getNombre(), " fecha vinculacion ", self.getFechaIngreso()

    #preguntar por la funcion de asegurar

    def calculoDePrima(self): #Calcula la prima del gerente
        return self.getSueldo*0.6

    def getSeguro(self):
        return self._seguro
       
    def setSeguro(self, seguro):
        self._seguro = seguro

    @classmethod
    def getNumeroGerente(cls):
        return cls._numeroGerente

    @classmethod
    def setNumeroGerente(cls,numero):
        cls._numeroGerente = numero

    @classmethod
    def getListaGerentes(cls):
        return cls._Gerentes

    @classmethod
    def setListaGerentes(cls,lista):
        cls._Gerentes = lista
    
    def generarCodigo(cls):
        return cls._numeroGerente+1


    