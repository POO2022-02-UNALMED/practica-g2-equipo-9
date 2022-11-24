from gestorAplicacion_py.usuarios.Empleado import Empleado


from datetime import datetime,timedelta

#from gestorAplicacion_py.gestion.Producto import Producto


class Trabajador(Empleado):

    _trabajadores = []


    def __init__(self,codigo,nombre,fechaVinculacion):
        super().__init__(fechaVinculacion,codigo,nombre,"Trabajador",self.getSueldo)
        self._seguro =6
        Trabajador._trabajadores.append(self)
        
        


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




    def asegurar(self):
        vinculacion=self.getFechaVinculacion
        finVinculacion=self.getFechaVinculacion+relativedelta(months=self.getSeguro)
        if datetime.now()>finVinculacion:
            return "Trabajador "+self.getNombre()+" tiene vencido el seguro, este vencio en la fecha "+finVinculacion
        else:
            return "Trabajador "+self.getNombre()+", lo cubre el seguro desde la fecha "+vinculacion+" hasta la fecha "+finVinculacion

    def calcularPrima(self):
        return self.getSeguro()*0.5

    @classmethod
    def generarCodigo(cls):
        return cls._numeroTrabajadores + 1
       





    
