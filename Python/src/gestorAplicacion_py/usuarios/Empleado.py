from usuarios.Usuario import Usuario

class Empleado(Usuario):

    _empleados = []
    disponibilidad = True

    def __init__(self,codigo,nombre,cargo,sueldo,fechaIngreso):
        super().__init__(codigo,nombre)
        self.cargo = cargo
        self.sueldo = sueldo
        self.fechaIngreso = fechaIngreso

  

    def getCargo(self):
        return self.cargo

    def setCargo(self, Cargo):
        self.cargo = Cargo

    def getSueldo(self):
        return self.sueldo

    def setSueldo(self, Sueldo):
        self.sueldo = Sueldo

    def getFechaIngreso(self):
        return self.fechaIngreso

    def setFechaIngreso(self, FechaIngreso):
        self.fechaIngreso = FechaIngreso

    def getlista_empleados(cls):
        return cls._empleados

    def setlista_empleados(cls, empleados):
        cls._empleados = empleados

    def getDisponibilidad(cls):
        return cls.disponibilidad

    def setDisponibilidad(cls, Disponibilidad):
        cls.disponibilidad = Disponibilidad

    def informacion(self,disponibilidad):
        if disponibilidad == True:
         return "El empleado ", self._nombre, " tiene un sueldo de ",self.sueldo, " y desenpeña el cargo de ", self.cargo, "\n", " , ingreso en la fecha ", self.fechaIngreso, " y esta disponible actualmente."

        else:
         return "El empleado ", self._nombre, " tiene un sueldo de ",self.sueldo, " y desenpeña el cargo de ", self.cargo, "\n", " , ingreso en la fecha ", self.fechaIngreso, " y No esta disponible actualmente."

    def asegurar(self):
        return "La fecha de vinculacion del trabajador es: ", self.fechaIngreso, ".\nEl nombre del Trabajador es: ", self._nombre












       