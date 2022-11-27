from Python.src.gestorAplicacion_py.usuarios.Empleado import Empleado


from datetime import datetime,timedelta

from Python.src.gestorAplicacion_py.gestion.Producto import Producto


class Trabajador(Empleado):

    _trabajadores = []
    _numeroTrabajador = 0


    def __init__(self,codigo,nombre,fechaVinculacion,_saldoFinal):
        super().__init__(fechaVinculacion,codigo,nombre,"Trabajador",self.getSueldo)
        self._seguro =6
        self._saldoFinal=_saldoFinal
        
        Trabajador._trabajadores.append(self)
        
        
    def getSeguro(self):
        return self._seguro

    def setSeguro(self,seguro):
        self._seguro = seguro

    def getSaldoFinal(self):
        return self._saldoFinal

    def setSaldoFinal(self, saldoF):
        self._saldoFinal = saldoF

    @classmethod
    def getTrabajadores(cls):
        return cls._trabajadores

    @classmethod
    def setTrabajadores(cls,trabajadores):
        cls._trabajadores = trabajadores

    @classmethod
    def getNumeroTrabajador(cls):
        return cls._numeroTrabajador

    @classmethod
    def setNumeroTrabajador(cls,NumeroT):
        cls._numeroTrabajador = NumeroT

    
    def asegurar(self):
        vinculacion=self.getFechaVinculacion
        finVinculacion=self.getFechaVinculacion+timedelta(days=self.seguro*30)
        if datetime.now()>finVinculacion:
            return "Trabajador "+self.getNombre()+" tiene vencido el seguro, este vencio en la fecha "+finVinculacion
        else:
            return "Trabajador "+self.getNombre()+", lo cubre el seguro desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion

    def calcularPrima(self):
        return self.getSeguro()*0.5

    @classmethod
    def generarCodigo(cls):
        return cls._numeroTrabajadores + 1



    
