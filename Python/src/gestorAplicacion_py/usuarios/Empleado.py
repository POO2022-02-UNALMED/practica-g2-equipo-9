import Usuario
import Sueldo
from datetime import datetime

class Empleado(Usuario,Sueldo):

    _empleados = []
    disponibilidad = True

    def __init__(self,codigo,nombre,cargo,sueldo,fechaIngreso):
        super().__init__(codigo,nombre)
        self.cargo = cargo
        self.sueldo = sueldo
        self.fechaVinculacion=
        self.fechaIngreso = fechaIngreso
        Usuario._usuarios.append(self)

  

    def getCargo(self):
        return self.cargo

    def setCargo(self, Cargo):
        self.cargo = Cargo

        
    def getSueldo(self):
        return self.sueldo

    def setSueldo(self, Sueldo):
        self.sueldo = Sueldo
    def aumentarSueldo(self, porcentajeAumento):
        self.setSueldo(self.getSueldo()*(1+porcentajeAumento))

    def getFechaIngreso(self):
        return self.fechaIngreso

    def setFechaIngreso(self, FechaIngreso):
        self.fechaIngreso = FechaIngreso

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













       