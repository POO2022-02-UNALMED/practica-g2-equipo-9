from Python.src.gestorAplicacion_py.usuarios.Usuario import Usuario
#from Python.src.gestorAplicacion_py.usuarios.Sueldo import Sueldo
from datetime import datetime
import os
def Sueldo():
    return 0

class Empleado(Usuario):

    _empleados = []
    disponibilidad = True

    def __init__(self,fechaVinculacion,codigo,nombre,cargo,sueldo):
        super().__init__(codigo,nombre)
        self._cargo = cargo
        self._sueldo = sueldo
        self._fechaVinculacion= fechaVinculacion
        Usuario._usuarios.append(self)
        
        

  
        
    def getCargo(self):
        return self.cargo

    def setCargo(self, cargo):
        self.cargo = cargo
        
    def getSueldo(self):
        return self._sueldo

    def setSueldo(self, sueldo):
        self._sueldo = sueldo

    def aumentarSueldo(self, porcentajeAumento):
        self.setSueldo(self.getSueldo()*(1+porcentajeAumento))

    def getFechaVinculacion(self):
        return self._fechaVinculacion
    def setFechaVinculacion(self,fechaVinculacion):
        self._fechaVinculacion=fechaVinculacion

    @classmethod
    def getlista_empleados(cls):
        return cls._empleados

    @classmethod
    def setlista_empleados(cls, empleados):
        cls._empleados = empleados

    @classmethod
    def getDisponibilidad(cls):
        return cls.disponibilidad

    @classmethod
    def setDisponibilidad(cls, Disponibilidad):
        cls.disponibilidad = Disponibilidad

    def informacion(self,disponibilidad):
        if disponibilidad == True:
         return "El empleado ", self._nombre, " tiene un sueldo de ",self.sueldo, " y desenpeña el cargo de ", self.cargo, "\n", " , ingreso en la fecha ", self.fechaIngreso, " y esta disponible actualmente."

        else:
         return "El empleado ", self._nombre, " tiene un sueldo de ",self.sueldo, " y desenpeña el cargo de ", self.cargo, "\n", " , ingreso en la fecha ", self.fechaIngreso, " y No esta disponible actualmente."

    def asegurar(self):
        pass
    def calculoDePrima():
        pass

print(os.path.exists('Sueldo.py'))
     












       