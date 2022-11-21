import Empleado

class Gerente(Empleado.Empleado):

    _numeroGerente=0
    _Gerentes = []

    def __init__(self, codigo, nombre, cargo, sueldo, fechaIngreso, _seguro):
        super().__init__(codigo, nombre, cargo, sueldo, fechaIngreso)

        self._seguro = _seguro

    #preguntar por lo del genetrador de codigo

    def generarCodigo(cls):
        return  cls._numeroGerente+1

    #ToString
    def __str__(self):
        return "Codigo: ", {self._codigo}, " Nombre ", {self._nombre}, " fecha vinculacion ", {self.fechaIngreso}

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
    